package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzqp extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbpm;
    private final int zzbpo;
    private final boolean zzbpp;
    private boolean zzbqm;
    private boolean zzbqn;
    private final zzqm zzbqo;
    private final int zzbqp;
    private final int zzbqq;
    private final int zzbqr;
    private final int zzbqs;
    private final int zzbqt;
    private final int zzbqu;
    private final String zzbqv;
    private final boolean zzbqw;
    private final boolean zzbqx;

    public zzqp() {
        this(new zzqm());
    }

    @VisibleForTesting
    private final zzqt zza(View view, zzqj zzqj) {
        boolean z;
        if (view == null) {
            return new zzqt(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzqt(this, 0, 0);
            }
            zzqj.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzqt(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbek)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzqj.zzmd();
                webView.post(new zzqr(this, zzqj, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new zzqt(this, 0, 1);
            }
            return new zzqt(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzqt(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzqt zza = zza(viewGroup.getChildAt(i3), zzqj);
                i += zza.zzbre;
                i2 += zza.zzbrf;
            }
            return new zzqt(this, i, i2);
        }
    }

    @VisibleForTesting
    private static boolean zzmi() {
        boolean z;
        try {
            Context context = zzq.zzkz().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null) {
                return false;
            }
            if (keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (Process.myPid() == next.pid) {
                    if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager == null) {
                        z = false;
                    } else {
                        z = powerManager.isScreenOn();
                    }
                    if (z) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzq.zzla().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzmk() {
        synchronized (this.lock) {
            this.zzbqm = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzazw.zzed(sb.toString());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0084 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084 A[LOOP:1: B:30:0x0084->B:42:0x0084, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = zzmi()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzql r0 = com.google.android.gms.ads.internal.zzq.zzkz()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzazw.zzed(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.zzmk()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x0019:
            if (r0 == 0) goto L_0x0062
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d }
            if (r2 == 0) goto L_0x004c
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x003d }
            if (r2 == 0) goto L_0x004c
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003d }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x003d }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d }
            r1 = r0
            goto L_0x004c
        L_0x003d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzawd r2 = com.google.android.gms.ads.internal.zzq.zzla()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzazw.zzed(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x004c:
            if (r1 == 0) goto L_0x0062
            if (r1 != 0) goto L_0x0051
            goto L_0x0062
        L_0x0051:
            com.google.android.gms.internal.ads.zzqs r0 = new com.google.android.gms.internal.ads.zzqs     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r0.<init>(r4, r1)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x005a:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzazw.zzed(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.zzmk()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x0062:
            int r0 = r4.zzbqp     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0081
        L_0x006b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzazw.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzawd r1 = com.google.android.gms.ads.internal.zzq.zzla()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x0081
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzazw.zzc(r1, r0)
        L_0x0081:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
        L_0x0084:
            boolean r1 = r4.zzbqm     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzazw.zzed(r1)     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.Object r1 = r4.lock     // Catch:{ InterruptedException -> 0x0084 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0084 }
            goto L_0x0084
        L_0x0093:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x0000
        L_0x0096:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x009a
        L_0x0099:
            throw r1
        L_0x009a:
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqp.run():void");
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbqm = false;
            this.lock.notifyAll();
            zzazw.zzed("ContentFetchThread: wakeup");
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzj(View view) {
        try {
            zzqj zzqj = new zzqj(this.zzbpm, this.zzbqq, this.zzbpo, this.zzbqr, this.zzbqs, this.zzbqt, this.zzbqu, this.zzbpp);
            Context context = zzq.zzkz().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbqv)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzvj.zzpv().zzd(zzzz.zzckh), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbqv)) {
                    return;
                }
            }
            zzqt zza = zza(view, zzqj);
            zzqj.zzmf();
            if (zza.zzbre != 0 || zza.zzbrf != 0) {
                if (zza.zzbrf != 0 || zzqj.zzmg() != 0) {
                    if (zza.zzbrf != 0 || !this.zzbqo.zza(zzqj)) {
                        this.zzbqo.zzc(zzqj);
                    }
                }
            }
        } catch (Exception e) {
            zzazw.zzc("Exception in fetchContentOnUIThread", e);
            zzq.zzla().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzmh() {
        synchronized (this.lock) {
            if (this.started) {
                zzazw.zzed("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    public final zzqj zzmj() {
        return this.zzbqo.zzo(this.zzbqx);
    }

    public final boolean zzml() {
        return this.zzbqm;
    }

    @VisibleForTesting
    private zzqp(zzqm zzqm) {
        this.started = false;
        this.zzbqm = false;
        this.zzbqn = false;
        this.zzbqo = zzqm;
        this.lock = new Object();
        this.zzbpm = zzabh.zzcwe.get().intValue();
        this.zzbqq = zzabh.zzcwb.get().intValue();
        this.zzbpo = zzabh.zzcwf.get().intValue();
        this.zzbqr = zzabh.zzcwd.get().intValue();
        this.zzbqs = ((Integer) zzvj.zzpv().zzd(zzzz.zzcke)).intValue();
        this.zzbqt = ((Integer) zzvj.zzpv().zzd(zzzz.zzckf)).intValue();
        this.zzbqu = ((Integer) zzvj.zzpv().zzd(zzzz.zzckg)).intValue();
        this.zzbqp = zzabh.zzcwg.get().intValue();
        this.zzbqv = (String) zzvj.zzpv().zzd(zzzz.zzcki);
        this.zzbqw = ((Boolean) zzvj.zzpv().zzd(zzzz.zzckj)).booleanValue();
        this.zzbpp = ((Boolean) zzvj.zzpv().zzd(zzzz.zzckk)).booleanValue();
        this.zzbqx = ((Boolean) zzvj.zzpv().zzd(zzzz.zzckl)).booleanValue();
        setName("ContentFetchTask");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzqj zzqj, WebView webView, String str, boolean z) {
        zzqj.zzmc();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(ViewHierarchyConstants.TEXT_KEY);
                if (this.zzbqw || TextUtils.isEmpty(webView.getTitle())) {
                    zzqj.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzqj.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzqj.zzlx()) {
                this.zzbqo.zzb(zzqj);
            }
        } catch (JSONException unused) {
            zzazw.zzed("Json string may be malformed.");
        } catch (Throwable th) {
            zzazw.zzb("Failed to get webview content.", th);
            zzq.zzla().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }
}
