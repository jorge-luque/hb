package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class DynamiteModule {
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzf();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzh();
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzd();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zza();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzc();
    @GuardedBy("DynamiteModule.class")
    private static Boolean zziu = null;
    @GuardedBy("DynamiteModule.class")
    private static zzk zziv = null;
    @GuardedBy("DynamiteModule.class")
    private static zzm zziw = null;
    @GuardedBy("DynamiteModule.class")
    private static String zzix = null;
    @GuardedBy("DynamiteModule.class")
    private static int zziy = -1;
    private static final ThreadLocal<zza> zziz = new ThreadLocal<>();
    private static final VersionPolicy.zzb zzja = new zzb();
    private static final VersionPolicy zzjb = new zzg();
    private final Context zzjc;

    @DynamiteApi
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, zzb zzb) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzb zzb) {
            this(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
        public static class zza {
            public int zzjg = 0;
            public int zzjh = 0;
            public int zzji = 0;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
        public interface zzb {
            int getLocalVersion(Context context, String str);

            int zza(Context context, String str, boolean z) throws LoadingException;
        }

        zza zza(Context context, String str, zzb zzb2) throws LoadingException;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
    private static class zza {
        public Cursor zzjd;

        private zza() {
        }

        /* synthetic */ zza(zzb zzb) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
    private static class zzb implements VersionPolicy.zzb {
        private final int zzje;
        private final int zzjf = 0;

        public zzb(int i, int i2) {
            this.zzje = i;
        }

        public final int getLocalVersion(Context context, String str) {
            return this.zzje;
        }

        public final int zza(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.zzjc = (Context) Preconditions.checkNotNull(context);
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    @KeepForSdk
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        VersionPolicy.zza zza2;
        zza zza3 = zziz.get();
        zza zza4 = new zza((zzb) null);
        zziz.set(zza4);
        try {
            zza2 = versionPolicy.zza(context, str, zzja);
            int i = zza2.zzjg;
            int i2 = zza2.zzjh;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.toString();
            if (zza2.zzji == 0 || ((zza2.zzji == -1 && zza2.zzjg == 0) || (zza2.zzji == 1 && zza2.zzjh == 0))) {
                int i3 = zza2.zzjg;
                int i4 = zza2.zzjh;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i3);
                sb2.append(" and remote version is ");
                sb2.append(i4);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (zzb) null);
            } else if (zza2.zzji == -1) {
                DynamiteModule zze = zze(context, str);
                Cursor cursor = zza4.zzjd;
                if (cursor != null) {
                    cursor.close();
                }
                zziz.set(zza3);
                return zze;
            } else if (zza2.zzji == 1) {
                DynamiteModule zza5 = zza(context, str, zza2.zzjh);
                Cursor cursor2 = zza4.zzjd;
                if (cursor2 != null) {
                    cursor2.close();
                }
                zziz.set(zza3);
                return zza5;
            } else {
                int i5 = zza2.zzji;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i5);
                throw new LoadingException(sb3.toString(), (zzb) null);
            }
        } catch (LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
            if (zza2.zzjg == 0 || versionPolicy.zza(context, str, new zzb(zza2.zzjg, 0)).zzji != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", e, (zzb) null);
            }
            DynamiteModule zze2 = zze(context, str);
            Cursor cursor3 = zza4.zzjd;
            if (cursor3 != null) {
                cursor3.close();
            }
            zziz.set(zza3);
            return zze2;
        } catch (Throwable th) {
            Cursor cursor4 = zza4.zzjd;
            if (cursor4 != null) {
                cursor4.close();
            }
            zziz.set(zza3);
            throw th;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0091=Splitter:B:39:0x0091, B:23:0x0056=Splitter:B:23:0x0056, B:18:0x0039=Splitter:B:18:0x0039} */
    public static int zza(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x0105 }
            java.lang.Boolean r1 = zziu     // Catch:{ all -> 0x0102 }
            if (r1 != 0) goto L_0x00cf
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.Class r2 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            monitor-enter(r2)     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            r3 = 0
            java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x009f }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x003c
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009f }
            if (r4 != r1) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0036:
            zza(r4)     // Catch:{ LoadingException -> 0x0039 }
        L_0x0039:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x003c:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x009f }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x009f }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x0056
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009f }
            r1.set(r3, r4)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0056:
            int r4 = zzc(r8, r9, r10)     // Catch:{ LoadingException -> 0x0094 }
            java.lang.String r5 = zzix     // Catch:{ LoadingException -> 0x0094 }
            if (r5 == 0) goto L_0x0091
            java.lang.String r5 = zzix     // Catch:{ LoadingException -> 0x0094 }
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x0094 }
            if (r5 == 0) goto L_0x0067
            goto L_0x0091
        L_0x0067:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x0094 }
            r6 = 29
            if (r5 < r6) goto L_0x0079
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x0094 }
            java.lang.String r6 = zzix     // Catch:{ LoadingException -> 0x0094 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0094 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0094 }
            goto L_0x0084
        L_0x0079:
            com.google.android.gms.dynamite.zzi r5 = new com.google.android.gms.dynamite.zzi     // Catch:{ LoadingException -> 0x0094 }
            java.lang.String r6 = zzix     // Catch:{ LoadingException -> 0x0094 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0094 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0094 }
        L_0x0084:
            zza(r5)     // Catch:{ LoadingException -> 0x0094 }
            r1.set(r3, r5)     // Catch:{ LoadingException -> 0x0094 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x0094 }
            zziu = r5     // Catch:{ LoadingException -> 0x0094 }
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x0102 }
            return r4
        L_0x0091:
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x0102 }
            return r4
        L_0x0094:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009f }
            r1.set(r3, r4)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009f }
        L_0x009d:
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            goto L_0x00cd
        L_0x009f:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
        L_0x00a2:
            r1 = move-exception
            goto L_0x00a7
        L_0x00a4:
            r1 = move-exception
            goto L_0x00a7
        L_0x00a6:
            r1 = move-exception
        L_0x00a7:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0102 }
            int r3 = r3.length()     // Catch:{ all -> 0x0102 }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r4.<init>(r3)     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = "Failed to load module via V2: "
            r4.append(r3)     // Catch:{ all -> 0x0102 }
            r4.append(r1)     // Catch:{ all -> 0x0102 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0102 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x0102 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0102 }
        L_0x00cd:
            zziu = r1     // Catch:{ all -> 0x0102 }
        L_0x00cf:
            monitor-exit(r0)     // Catch:{ all -> 0x0102 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x0105 }
            if (r0 == 0) goto L_0x00fd
            int r8 = zzc(r8, r9, r10)     // Catch:{ LoadingException -> 0x00db }
            return r8
        L_0x00db:
            r9 = move-exception
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0105 }
            int r1 = r9.length()     // Catch:{ all -> 0x0105 }
            if (r1 == 0) goto L_0x00f3
            java.lang.String r9 = r0.concat(r9)     // Catch:{ all -> 0x0105 }
            goto L_0x00f8
        L_0x00f3:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x0105 }
            r9.<init>(r0)     // Catch:{ all -> 0x0105 }
        L_0x00f8:
            android.util.Log.w(r10, r9)     // Catch:{ all -> 0x0105 }
            r8 = 0
            return r8
        L_0x00fd:
            int r8 = zzb((android.content.Context) r8, (java.lang.String) r9, (boolean) r10)     // Catch:{ all -> 0x0105 }
            return r8
        L_0x0102:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0102 }
            throw r9     // Catch:{ all -> 0x0105 }
        L_0x0105:
            r9 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r8, r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    private static Boolean zzai() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(zziy >= 2);
        }
        return valueOf;
    }

    private static int zzb(Context context, String str, boolean z) {
        zzk zzl = zzl(context);
        if (zzl == null) {
            return 0;
        }
        try {
            if (zzl.zzaj() >= 2) {
                return zzl.zzb(ObjectWrapper.wrap(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return zzl.zza(ObjectWrapper.wrap(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzc(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r10 == 0) goto L_0x000a
            java.lang.String r8 = "api_force_staging"
            goto L_0x000c
        L_0x000a:
            java.lang.String r8 = "api"
        L_0x000c:
            int r10 = r8.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r2 = r2.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.<init>(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r8 == 0) goto L_0x0083
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 == 0) goto L_0x0083
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 <= 0) goto L_0x007c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0079 }
            zzix = r1     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x0079 }
            if (r1 < 0) goto L_0x0067
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x0079 }
            zziy = r1     // Catch:{ all -> 0x0079 }
        L_0x0067:
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r10 = zziz     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$zza r10 = (com.google.android.gms.dynamite.DynamiteModule.zza) r10     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r10 == 0) goto L_0x007c
            android.database.Cursor r1 = r10.zzjd     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r1 != 0) goto L_0x007c
            r10.zzjd = r8     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            goto L_0x007d
        L_0x0079:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x007c:
            r0 = r8
        L_0x007d:
            if (r0 == 0) goto L_0x0082
            r0.close()
        L_0x0082:
            return r9
        L_0x0083:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>((java.lang.String) r10, (com.google.android.gms.dynamite.zzb) r0)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x0092:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00ae
        L_0x0096:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x009f
        L_0x009b:
            r8 = move-exception
            goto L_0x00ae
        L_0x009d:
            r8 = move-exception
            r9 = r0
        L_0x009f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x00a4
            throw r8     // Catch:{ all -> 0x00ac }
        L_0x00a4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00ac }
            throw r10     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r8 = move-exception
            r0 = r9
        L_0x00ae:
            if (r0 == 0) goto L_0x00b3
            r0.close()
        L_0x00b3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zze(Context context, String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        } else {
            new String("Selected local version of ");
        }
        return new DynamiteModule(context.getApplicationContext());
    }

    private static zzk zzl(Context context) {
        zzk zzk;
        synchronized (DynamiteModule.class) {
            if (zziv != null) {
                zzk zzk2 = zziv;
                return zzk2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzk = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzk) {
                        zzk = (zzk) queryLocalInterface;
                    } else {
                        zzk = new zzj(iBinder);
                    }
                }
                if (zzk != null) {
                    zziv = zzk;
                    return zzk;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    @KeepForSdk
    public final Context getModuleContext() {
        return this.zzjc;
    }

    @KeepForSdk
    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzjc.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (zzb) null);
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws LoadingException, RemoteException {
        zzm zzm;
        IObjectWrapper iObjectWrapper;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        sb.toString();
        synchronized (DynamiteModule.class) {
            zzm = zziw;
        }
        if (zzm != null) {
            zza zza2 = zziz.get();
            if (zza2 == null || zza2.zzjd == null) {
                throw new LoadingException("No result cursor", (zzb) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = zza2.zzjd;
            ObjectWrapper.wrap(null);
            if (zzai().booleanValue()) {
                iObjectWrapper = zzm.zzb(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                iObjectWrapper = zzm.zza(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            }
            Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (zzb) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzb) null);
    }

    private static DynamiteModule zza(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        IObjectWrapper iObjectWrapper;
        try {
            synchronized (DynamiteModule.class) {
                bool = zziu;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (zzb) null);
            } else if (bool.booleanValue()) {
                return zzb(context, str, i);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i);
                sb.toString();
                zzk zzl = zzl(context);
                if (zzl != null) {
                    if (zzl.zzaj() >= 2) {
                        iObjectWrapper = zzl.zzb(ObjectWrapper.wrap(context), str, i);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        iObjectWrapper = zzl.zza(ObjectWrapper.wrap(context), str, i);
                    }
                    if (ObjectWrapper.unwrap(iObjectWrapper) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapper));
                    }
                    throw new LoadingException("Failed to load remote module.", (zzb) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (zzb) null);
            }
        } catch (RemoteException e) {
            throw new LoadingException("Failed to load remote module.", e, (zzb) null);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new LoadingException("Failed to load remote module.", th, (zzb) null);
        }
    }

    @GuardedBy("DynamiteModule.class")
    private static void zza(ClassLoader classLoader) throws LoadingException {
        zzm zzm;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzm = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzm) {
                    zzm = (zzm) queryLocalInterface;
                } else {
                    zzm = new zzl(iBinder);
                }
            }
            zziw = zzm;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzb) null);
        }
    }
}
