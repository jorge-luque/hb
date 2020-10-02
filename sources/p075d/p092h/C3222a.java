package p075d.p092h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* renamed from: d.h.a */
/* compiled from: MultiDex */
public final class C3222a {

    /* renamed from: a */
    private static final Set<File> f8996a = new HashSet();

    /* renamed from: b */
    private static final boolean f8997b = m10654a(System.getProperty("java.vm.version"));

    /* renamed from: d.h.a$c */
    /* compiled from: MultiDex */
    private static final class C3229c {
        /* renamed from: a */
        static void m10670a(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field a = C3222a.m10656b(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) a.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            a.set(classLoader, sb.toString());
            C3222a.m10658b((Object) classLoader, "mPaths", (Object[]) strArr);
            C3222a.m10658b((Object) classLoader, "mFiles", (Object[]) fileArr);
            C3222a.m10658b((Object) classLoader, "mZips", (Object[]) zipFileArr);
            C3222a.m10658b((Object) classLoader, "mDexs", (Object[]) dexFileArr);
        }
    }

    /* renamed from: b */
    private static ApplicationInfo m10655b(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    /* renamed from: c */
    private static ClassLoader m10659c(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (Build.VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    /* renamed from: d */
    public static void m10660d(Context context) {
        if (!f8997b) {
            if (Build.VERSION.SDK_INT >= 4) {
                try {
                    ApplicationInfo b = m10655b(context);
                    if (b != null) {
                        m10650a(context, new File(b.sourceDir), new File(b.dataDir), "secondary-dexes", "", true);
                    }
                } catch (Exception e) {
                    Log.e("MultiDex", "MultiDex installation failure", e);
                    throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
                }
            } else {
                throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Field m10656b(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:41|42|43|44|45) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x009d */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m10650a(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.InstantiationException {
        /*
            java.util.Set<java.io.File> r0 = f8996a
            monitor-enter(r0)
            java.util.Set<java.io.File> r1 = f8996a     // Catch:{ all -> 0x009e }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x000d:
            java.util.Set<java.io.File> r1 = f8996a     // Catch:{ all -> 0x009e }
            r1.add(r6)     // Catch:{ all -> 0x009e }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x009e }
            r2 = 20
            if (r1 <= r2) goto L_0x0055
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r3.<init>()     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "MultiDex is not guaranteed to work in SDK version "
            r3.append(r4)     // Catch:{ all -> 0x009e }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x009e }
            r3.append(r4)     // Catch:{ all -> 0x009e }
            java.lang.String r4 = ": SDK version higher than "
            r3.append(r4)     // Catch:{ all -> 0x009e }
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = " should be backed by "
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "runtime with built-in multidex capabilty but it's not the "
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "case here: java.vm.version=\""
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ all -> 0x009e }
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x009e }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x009e }
        L_0x0055:
            java.lang.ClassLoader r1 = m10659c(r5)     // Catch:{ all -> 0x009e }
            if (r1 != 0) goto L_0x005d
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x005d:
            m10649a((android.content.Context) r5)     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r2 = move-exception
            java.lang.String r3 = "MultiDex"
            java.lang.String r4 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
            android.util.Log.w(r3, r4, r2)     // Catch:{ all -> 0x009e }
        L_0x0069:
            java.io.File r7 = m10646a((android.content.Context) r5, (java.io.File) r7, (java.lang.String) r8)     // Catch:{ all -> 0x009e }
            d.h.c r8 = new d.h.c     // Catch:{ all -> 0x009e }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x009e }
            r6 = 0
            r2 = 0
            java.util.List r2 = r8.mo18877a(r5, r9, r2)     // Catch:{ all -> 0x0099 }
            m10652a((java.lang.ClassLoader) r1, (java.io.File) r7, (java.util.List<? extends java.io.File>) r2)     // Catch:{ IOException -> 0x007c }
            goto L_0x008e
        L_0x007c:
            r2 = move-exception
            if (r10 == 0) goto L_0x0098
            java.lang.String r10 = "MultiDex"
            java.lang.String r3 = "Failed to install extracted secondary dex files, retrying with forced extraction"
            android.util.Log.w(r10, r3, r2)     // Catch:{ all -> 0x0099 }
            r10 = 1
            java.util.List r5 = r8.mo18877a(r5, r9, r10)     // Catch:{ all -> 0x0099 }
            m10652a((java.lang.ClassLoader) r1, (java.io.File) r7, (java.util.List<? extends java.io.File>) r5)     // Catch:{ all -> 0x0099 }
        L_0x008e:
            r8.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0093
        L_0x0092:
            r6 = move-exception
        L_0x0093:
            if (r6 != 0) goto L_0x0097
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x0097:
            throw r6     // Catch:{ all -> 0x009e }
        L_0x0098:
            throw r2     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r5 = move-exception
            r8.close()     // Catch:{ IOException -> 0x009d }
        L_0x009d:
            throw r5     // Catch:{ all -> 0x009e }
        L_0x009e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p075d.p092h.C3222a.m10650a(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    /* renamed from: d.h.a$a */
    /* compiled from: MultiDex */
    private static final class C3223a {

        /* renamed from: b */
        private static final int f8998b = 4;

        /* renamed from: a */
        private final C3224a f8999a;

        /* renamed from: d.h.a$a$a */
        /* compiled from: MultiDex */
        private interface C3224a {
            /* renamed from: a */
            Object mo18875a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        /* renamed from: d.h.a$a$b */
        /* compiled from: MultiDex */
        private static class C3225b implements C3224a {

            /* renamed from: a */
            private final Constructor<?> f9000a;

            C3225b(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.f9000a = constructor;
                constructor.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo18875a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.f9000a.newInstance(new Object[]{file, new ZipFile(file), dexFile});
            }
        }

        /* renamed from: d.h.a$a$c */
        /* compiled from: MultiDex */
        private static class C3226c implements C3224a {

            /* renamed from: a */
            private final Constructor<?> f9001a;

            C3226c(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(new Class[]{File.class, File.class, DexFile.class});
                this.f9001a = constructor;
                constructor.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo18875a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f9001a.newInstance(new Object[]{file, file, dexFile});
            }
        }

        /* renamed from: d.h.a$a$d */
        /* compiled from: MultiDex */
        private static class C3227d implements C3224a {

            /* renamed from: a */
            private final Constructor<?> f9002a;

            C3227d(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
                this.f9002a = constructor;
                constructor.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo18875a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f9002a.newInstance(new Object[]{file, Boolean.FALSE, file, dexFile});
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private C3223a() throws java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.NoSuchMethodException {
            /*
                r2 = this;
                r2.<init>()
                java.lang.String r0 = "dalvik.system.DexPathList$Element"
                java.lang.Class r0 = java.lang.Class.forName(r0)
                d.h.a$a$b r1 = new d.h.a$a$b     // Catch:{ NoSuchMethodException -> 0x000f }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x000f }
                goto L_0x001a
            L_0x000f:
                d.h.a$a$c r1 = new d.h.a$a$c     // Catch:{ NoSuchMethodException -> 0x0015 }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x0015 }
                goto L_0x001a
            L_0x0015:
                d.h.a$a$d r1 = new d.h.a$a$d
                r1.<init>(r0)
            L_0x001a:
                r2.f8999a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p075d.p092h.C3222a.C3223a.<init>():void");
        }

        /* renamed from: a */
        static void m10662a(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = C3222a.m10656b(classLoader, "pathList").get(classLoader);
            Object[] a = new C3223a().m10663a(list);
            try {
                C3222a.m10658b(obj, "dexElements", a);
            } catch (NoSuchFieldException e) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
                C3222a.m10658b(obj, "pathElements", a);
            }
        }

        /* renamed from: a */
        private Object[] m10663a(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                File file = (File) list.get(i);
                objArr[i] = this.f8999a.mo18875a(file, DexFile.loadDex(file.getPath(), m10661a(file), 0));
            }
            return objArr;
        }

        /* renamed from: a */
        private static String m10661a(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f8998b) + ".dex").getPath();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Method m10657b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m10658b(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field b = m10656b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b.set(obj, objArr3);
    }

    /* renamed from: d.h.a$b */
    /* compiled from: MultiDex */
    private static final class C3228b {
        /* renamed from: a */
        static void m10668a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = C3222a.m10656b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            C3222a.m10658b(obj, "dexElements", m10669a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field a = C3222a.m10656b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) a.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                a.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        /* renamed from: a */
        private static Object[] m10669a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) C3222a.m10657b(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* renamed from: a */
    static boolean m10654a(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String str2 = null;
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreTokens()) {
                str2 = stringTokenizer.nextToken();
            }
            if (!(nextToken == null || str2 == null)) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        sb.toString();
        return z;
    }

    /* renamed from: a */
    private static void m10652a(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (!list.isEmpty()) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                C3228b.m10668a(classLoader, list, file);
            } else if (i >= 14) {
                C3223a.m10662a(classLoader, list);
            } else {
                C3229c.m10670a(classLoader, list);
            }
        }
    }

    /* renamed from: a */
    private static void m10649a(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            "Clearing old secondary dex dir (" + file.getPath() + ").";
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                "Trying to delete old file " + file2.getPath() + " of size " + file2.length();
                if (!file2.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                } else {
                    "Deleted old file " + file2.getPath();
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            "Deleted old secondary dex dir " + file.getPath();
        }
    }

    /* renamed from: a */
    private static File m10646a(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            m10651a(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            m10651a(file2);
        }
        File file3 = new File(file2, str);
        m10651a(file3);
        return file3;
    }

    /* renamed from: a */
    private static void m10651a(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}
