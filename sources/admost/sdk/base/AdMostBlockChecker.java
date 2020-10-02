package admost.sdk.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class AdMostBlockChecker {
    private static volatile AdMostBlockChecker instance;

    /* renamed from: admost.sdk.base.AdMostBlockChecker$3 */
    static /* synthetic */ class C01923 {
        static final /* synthetic */ int[] $SwitchMap$admost$sdk$base$AdMostBlockChecker$AdBlockStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                admost.sdk.base.AdMostBlockChecker$AdBlockStatus[] r0 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$admost$sdk$base$AdMostBlockChecker$AdBlockStatus = r0
                admost.sdk.base.AdMostBlockChecker$AdBlockStatus r1 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.NO_BLOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostBlockChecker$AdBlockStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                admost.sdk.base.AdMostBlockChecker$AdBlockStatus r1 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.BLOCKED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostBlockChecker$AdBlockStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                admost.sdk.base.AdMostBlockChecker$AdBlockStatus r1 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostBlockChecker.C01923.<clinit>():void");
        }
    }

    public enum AdBlockStatus {
        NO_BLOCK,
        UNKNOWN,
        BLOCKED
    }

    public interface Listener {
        void blockDetected();

        void canShowAds();

        void unknown();
    }

    protected AdMostBlockChecker() {
    }

    public static AdMostBlockChecker getInstance() {
        if (instance == null) {
            synchronized (AdMostBlockChecker.class) {
                if (instance == null) {
                    instance = new AdMostBlockChecker();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void returnToListener(final Listener listener, final AdBlockStatus adBlockStatus) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (listener != null) {
                    int i = C01923.$SwitchMap$admost$sdk$base$AdMostBlockChecker$AdBlockStatus[adBlockStatus.ordinal()];
                    if (i == 1) {
                        listener.canShowAds();
                    } else if (i == 2) {
                        listener.blockDetected();
                    } else if (i == 3) {
                        listener.unknown();
                    }
                }
            }
        });
    }

    public void getAdBlockStatus(Context context, final Listener listener) {
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[SYNTHETIC, Splitter:B:22:0x004d] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[Catch:{ all -> 0x0099 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x0095  */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x009e  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00a3  */
            /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    r0 = 10
                    android.os.Process.setThreadPriority(r0)
                    android.content.Context r0 = r3
                    int r0 = admost.sdk.base.AdMostUtil.isNetworkAvailable(r0)
                    r1 = 1
                    if (r0 != r1) goto L_0x00a7
                    r0 = 200(0xc8, float:2.8E-43)
                    r1 = 2000(0x7d0, float:2.803E-42)
                    r2 = 0
                    java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
                    java.lang.String r4 = "https://www.admob.com"
                    r3.<init>(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
                    java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
                    java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
                    r3.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0042 }
                    int r4 = r3.getResponseCode()     // Catch:{ Exception -> 0x0042 }
                    if (r4 != r0) goto L_0x003c
                    admost.sdk.base.AdMostBlockChecker r4 = admost.sdk.base.AdMostBlockChecker.this     // Catch:{ Exception -> 0x0042 }
                    admost.sdk.base.AdMostBlockChecker$Listener r5 = r4     // Catch:{ Exception -> 0x0042 }
                    admost.sdk.base.AdMostBlockChecker$AdBlockStatus r6 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.NO_BLOCK     // Catch:{ Exception -> 0x0042 }
                    r4.returnToListener(r5, r6)     // Catch:{ Exception -> 0x0042 }
                    r3.disconnect()     // Catch:{ Exception -> 0x0042 }
                    if (r3 == 0) goto L_0x00b0
                    r3.disconnect()
                    goto L_0x00b0
                L_0x003c:
                    java.net.UnknownHostException r4 = new java.net.UnknownHostException     // Catch:{ Exception -> 0x0042 }
                    r4.<init>()     // Catch:{ Exception -> 0x0042 }
                    throw r4     // Catch:{ Exception -> 0x0042 }
                L_0x0042:
                    r4 = move-exception
                    goto L_0x0049
                L_0x0044:
                    r0 = move-exception
                    r4 = r2
                    goto L_0x009c
                L_0x0047:
                    r4 = move-exception
                    r3 = r2
                L_0x0049:
                    boolean r4 = r4 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x0099 }
                    if (r4 == 0) goto L_0x008e
                    java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x0080 }
                    java.lang.String r5 = "https://www.admost.com"
                    r4.<init>(r5)     // Catch:{ Exception -> 0x0080 }
                    java.net.URLConnection r4 = r4.openConnection()     // Catch:{ Exception -> 0x0080 }
                    java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0080 }
                    r4.setConnectTimeout(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    int r1 = r4.getResponseCode()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    if (r1 != r0) goto L_0x006d
                    admost.sdk.base.AdMostBlockChecker r0 = admost.sdk.base.AdMostBlockChecker.this     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    admost.sdk.base.AdMostBlockChecker$Listener r1 = r4     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    admost.sdk.base.AdMostBlockChecker$AdBlockStatus r2 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.NO_BLOCK     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    r0.returnToListener(r1, r2)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    goto L_0x0076
                L_0x006d:
                    admost.sdk.base.AdMostBlockChecker r0 = admost.sdk.base.AdMostBlockChecker.this     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    admost.sdk.base.AdMostBlockChecker$Listener r1 = r4     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    admost.sdk.base.AdMostBlockChecker$AdBlockStatus r2 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.UNKNOWN     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    r0.returnToListener(r1, r2)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                L_0x0076:
                    r4.disconnect()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                    r2 = r4
                    goto L_0x008e
                L_0x007b:
                    r0 = move-exception
                    goto L_0x009b
                L_0x007d:
                    r0 = move-exception
                    r2 = r4
                    goto L_0x0081
                L_0x0080:
                    r0 = move-exception
                L_0x0081:
                    boolean r0 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x0099 }
                    if (r0 == 0) goto L_0x008e
                    admost.sdk.base.AdMostBlockChecker r0 = admost.sdk.base.AdMostBlockChecker.this     // Catch:{ all -> 0x0099 }
                    admost.sdk.base.AdMostBlockChecker$Listener r1 = r4     // Catch:{ all -> 0x0099 }
                    admost.sdk.base.AdMostBlockChecker$AdBlockStatus r4 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.BLOCKED     // Catch:{ all -> 0x0099 }
                    r0.returnToListener(r1, r4)     // Catch:{ all -> 0x0099 }
                L_0x008e:
                    if (r3 == 0) goto L_0x0093
                    r3.disconnect()
                L_0x0093:
                    if (r2 == 0) goto L_0x00b0
                    r2.disconnect()
                    goto L_0x00b0
                L_0x0099:
                    r0 = move-exception
                    r4 = r2
                L_0x009b:
                    r2 = r3
                L_0x009c:
                    if (r2 == 0) goto L_0x00a1
                    r2.disconnect()
                L_0x00a1:
                    if (r4 == 0) goto L_0x00a6
                    r4.disconnect()
                L_0x00a6:
                    throw r0
                L_0x00a7:
                    admost.sdk.base.AdMostBlockChecker r0 = admost.sdk.base.AdMostBlockChecker.this
                    admost.sdk.base.AdMostBlockChecker$Listener r1 = r4
                    admost.sdk.base.AdMostBlockChecker$AdBlockStatus r2 = admost.sdk.base.AdMostBlockChecker.AdBlockStatus.UNKNOWN
                    r0.returnToListener(r1, r2)
                L_0x00b0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostBlockChecker.C01901.run():void");
            }
        }).start();
    }
}
