package admost.sdk.base;

import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.interfaces.AdMostAdNetworkReference;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.interfaces.AdMostOfferwallSpendInterface;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.listener.AdMostVirtualCurrencyListener;
import admost.sdk.model.AdMostBannerResponseItem;
import android.os.Build;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMostAdNetworkManager {
    private static AdMostAdNetworkManager adNetworkManagerInstance;
    private static final Object lock = new Object();
    public ConcurrentHashMap<String, AdMostAdNetworkInitInterface> adNetworkInitAdapters = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, String> adapterNames = new ConcurrentHashMap<>();
    public AdMostAdNetworkReference adtrialAdManager;
    public AdMostAdNetworkReference inmobiAdManager;
    public AdMostAdNetworkReference startAppAdManager;

    private String getAdapterName(String str, String str2) {
        String str3;
        String str4 = str + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + str2;
        String baseNetwork = AdMostAdNetwork.getBaseNetwork(str);
        if (baseNetwork != null) {
            str3 = baseNetwork + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + str2;
        } else {
            str3 = "";
        }
        if (this.adapterNames.containsKey(str4)) {
            return this.adapterNames.get(str4);
        }
        if (baseNetwork != null && this.adapterNames.containsKey(str3)) {
            return this.adapterNames.get(str3);
        }
        if (baseNetwork == null) {
            baseNetwork = str;
        }
        if (AdMostAdNetwork.hasBaseNetworkAdapter(AdMostAdNetwork.ADMOB, str)) {
            baseNetwork = AdMostUtil.isClassAvailable(AdMostAdClassName.ADMOB_ADAPTER_GT_17_2) ? "ADMOB1720" : AdMostAdNetwork.ADMOB;
        }
        String str5 = AdMostAdNetwork.AdapterHelper.DEFAULT_ADAPTER_PREFIX + baseNetwork.substring(0, 1).toUpperCase(Locale.ENGLISH) + baseNetwork.substring(1).toLowerCase(Locale.ENGLISH) + str2 + AdMostAdNetwork.AdapterHelper.DEFAULT_ADAPTER_SUFFIX;
        this.adapterNames.put(str4, str5);
        return str5;
    }

    public static AdMostAdNetworkManager getInstance() {
        if (adNetworkManagerInstance == null) {
            synchronized (lock) {
                if (adNetworkManagerInstance == null) {
                    adNetworkManagerInstance = new AdMostAdNetworkManager();
                }
            }
        }
        return adNetworkManagerInstance;
    }

    private int getVersionCode(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("\\.")) {
            sb.append(("00" + str2).substring(str2.length()));
        }
        return Integer.parseInt(sb.toString());
    }

    public void destroyAllObjects() {
        AdMostAdNetworkReference adMostAdNetworkReference = this.adtrialAdManager;
        if (adMostAdNetworkReference != null) {
            adMostAdNetworkReference.destroy();
        }
        AdMostAdNetworkReference adMostAdNetworkReference2 = this.startAppAdManager;
        if (adMostAdNetworkReference2 != null) {
            adMostAdNetworkReference2.destroy();
        }
        AdMostAdNetworkReference adMostAdNetworkReference3 = this.inmobiAdManager;
        if (adMostAdNetworkReference3 != null) {
            adMostAdNetworkReference3.destroy();
        }
    }

    public AdMostBannerInterface getBannerAdapter(AdMostBannerResponseItem adMostBannerResponseItem) {
        int i = adMostBannerResponseItem.MinSdkVersion;
        if (i == 0 || Build.VERSION.SDK_INT >= i) {
            int i2 = adMostBannerResponseItem.MaxSdkVersion;
            if (i2 == 0 || Build.VERSION.SDK_INT <= i2) {
                StringBuilder sb = adMostBannerResponseItem.ExcludedSdkVersions;
                if (sb.indexOf("#" + Build.VERSION.SDK_INT + "#") >= 0) {
                    AdMostLog.m303w("Excluded SDK version : " + adMostBannerResponseItem.Network);
                    return null;
                }
                AdMostAdNetworkInitInterface initAdapter = getInitAdapter(adMostBannerResponseItem);
                if (initAdapter != null && !initAdapter.hasInitializationError) {
                    Set<String> set = initAdapter.supportedAdTypes;
                    if (!set.contains(adMostBannerResponseItem.ZoneType + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostBannerResponseItem.Type)) {
                        AdMostLog.m303w("Not supported ad type : " + adMostBannerResponseItem.Network);
                        return null;
                    }
                    if (initAdapter.initRequired && !initAdapter.isInitialized) {
                        AdMost.getInstance().getConfiguration().initNetwork(adMostBannerResponseItem.Network);
                    }
                    try {
                        AdMostBannerInterface bannerResponseItem = ((AdMostBannerInterface) Class.forName(getAdapterName(adMostBannerResponseItem.Network, AdMostAdNetwork.AdapterHelper.BANNER_ADAPTER_PREFIX)).newInstance()).setBannerResponseItem(adMostBannerResponseItem);
                        if (!adMostBannerResponseItem.IsBiddingItem || (bannerResponseItem instanceof AdMostBiddingInterface)) {
                            return bannerResponseItem;
                        }
                        AdMostLog.m303w("Bidding not supported for this network : " + adMostBannerResponseItem.Network);
                        return null;
                    } catch (ClassNotFoundException unused) {
                        AdMostLog.m303w("Adapter class not found for : " + adMostBannerResponseItem.Network + " " + adMostBannerResponseItem.Type);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
            AdMostLog.m303w("Maximum SDK version is not suitable : " + adMostBannerResponseItem.Network);
            return null;
        }
        AdMostLog.m303w("Minimum SDK version is not suitable : " + adMostBannerResponseItem.Network);
        return null;
    }

    public AdMostFullScreenInterface getFullScreenAdapter(AdMostBannerResponseItem adMostBannerResponseItem, boolean z, boolean z2) {
        if (getFullScreenAdapterStatus(adMostBannerResponseItem, z) != 0) {
            return null;
        }
        try {
            AdMostFullScreenInterface bannerResponseItem = ((AdMostFullScreenInterface) Class.forName(getAdapterName(adMostBannerResponseItem.Network, AdMostAdNetwork.AdapterHelper.FULLSCREEN_ADAPTER_PREFIX)).newInstance()).setBannerResponseItem(adMostBannerResponseItem);
            if (adMostBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL) || adMostBannerResponseItem.Type.equals("native")) {
                bannerResponseItem.setNativeAdapter(((AdMostBannerInterface) Class.forName(getAdapterName(adMostBannerResponseItem.Network, AdMostAdNetwork.AdapterHelper.BANNER_ADAPTER_PREFIX)).newInstance()).setBannerResponseItem(adMostBannerResponseItem));
            }
            if (!z2 || (bannerResponseItem instanceof AdMostBiddingInterface)) {
                return bannerResponseItem;
            }
            AdMostLog.m303w("Adapter not suitable for BIDDING : " + adMostBannerResponseItem.Network + " " + adMostBannerResponseItem.Type);
            return null;
        } catch (ClassNotFoundException unused) {
            AdMostLog.m303w("Adapter class not found for : " + adMostBannerResponseItem.Network + " " + adMostBannerResponseItem.Type);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getFullScreenAdapterStatus(AdMostBannerResponseItem adMostBannerResponseItem, boolean z) {
        int i = adMostBannerResponseItem.MinSdkVersion;
        if (i == 0 || Build.VERSION.SDK_INT >= i) {
            int i2 = adMostBannerResponseItem.MaxSdkVersion;
            if (i2 == 0 || Build.VERSION.SDK_INT <= i2) {
                StringBuilder sb = adMostBannerResponseItem.ExcludedSdkVersions;
                if (sb.indexOf("#" + Build.VERSION.SDK_INT + "#") >= 0) {
                    AdMostLog.m303w("Excluded SDK version : " + adMostBannerResponseItem.Network);
                    return 11;
                } else if (adMostBannerResponseItem.isExludedDevice()) {
                    AdMostLog.m303w("Excluded Device : " + adMostBannerResponseItem.getExcludedDeviceName());
                    return 12;
                } else {
                    AdMostAdNetworkInitInterface initAdapter = getInitAdapter(adMostBannerResponseItem);
                    if (initAdapter == null || initAdapter.hasInitializationError) {
                        return 1;
                    }
                    if (initAdapter.initRequired && !initAdapter.isInitialized) {
                        if (!z) {
                            AdMost.getInstance().getConfiguration().initNetwork(adMostBannerResponseItem.Network);
                        }
                        if (!initAdapter.isInitLightWeight) {
                            return 3;
                        }
                    }
                    Set<String> set = initAdapter.supportedAdTypes;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(adMostBannerResponseItem.ZoneType);
                    sb2.append(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR);
                    sb2.append(adMostBannerResponseItem.Type);
                    return !set.contains(sb2.toString()) ? 10 : 0;
                }
            } else {
                AdMostLog.m303w("Maximum SDK version is not suitable : " + adMostBannerResponseItem.Network);
                return 2;
            }
        } else {
            AdMostLog.m303w("Minimum SDK version is not suitable : " + adMostBannerResponseItem.Network);
            return 2;
        }
    }

    public AdMostAdNetworkInitInterface getInitAdapter(AdMostBannerResponseItem adMostBannerResponseItem) {
        if (!adMostBannerResponseItem.IsBiddingItem || AdMostAdNetwork.isBidAdNetworkAvailable(adMostBannerResponseItem.Network)) {
            AdMostAdNetworkInitInterface initAdapter = getInitAdapter(adMostBannerResponseItem.Network);
            if (!adMostBannerResponseItem.IsBiddingItem || initAdapter == null || !initAdapter.hasBiddingInitializationError) {
                return initAdapter;
            }
            return null;
        }
        AdMostLog.m303w("SDK class files not found for BIDDING : " + adMostBannerResponseItem.Network);
        return null;
    }

    public void spendOfferwallCurrency(String str, final AdMostVirtualCurrencyListener adMostVirtualCurrencyListener) {
        final AdMostAdNetworkInitInterface initAdapter = getInitAdapter(str);
        if (initAdapter != null && !initAdapter.hasInitializationError && (initAdapter instanceof AdMostOfferwallSpendInterface)) {
            if (!initAdapter.initRequired || initAdapter.isInitialized) {
                ((AdMostOfferwallSpendInterface) initAdapter).spendVirtualCurrency(adMostVirtualCurrencyListener);
                return;
            }
            initAdapter.setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                }

                public void onInitialized() {
                    ((AdMostOfferwallSpendInterface) initAdapter).spendVirtualCurrency(adMostVirtualCurrencyListener);
                }
            });
            AdMost.getInstance().getConfiguration().initNetwork(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r0.append("Incompatible AdMost SDK and network adapter version(1) : " + r7);
        r0.append("\n");
        r2.hasInitializationError = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r0.append("Incompatible AdMost SDK and network adapter version(2) : " + r7);
        r0.append("\n");
        r2.hasInitializationError = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x013b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x01a9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized admost.sdk.interfaces.AdMostAdNetworkInitInterface getInitAdapter(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r0.<init>()     // Catch:{ all -> 0x025d }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.interfaces.AdMostAdNetworkInitInterface> r1 = r6.adNetworkInitAdapters     // Catch:{ all -> 0x025d }
            boolean r1 = r1.containsKey(r7)     // Catch:{ all -> 0x025d }
            if (r1 == 0) goto L_0x0018
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.interfaces.AdMostAdNetworkInitInterface> r0 = r6.adNetworkInitAdapters     // Catch:{ all -> 0x025d }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x025d }
            admost.sdk.interfaces.AdMostAdNetworkInitInterface r7 = (admost.sdk.interfaces.AdMostAdNetworkInitInterface) r7     // Catch:{ all -> 0x025d }
            monitor-exit(r6)
            return r7
        L_0x0018:
            java.lang.String r1 = admost.sdk.base.AdMostAdNetwork.getBaseNetwork(r7)     // Catch:{ all -> 0x025d }
            if (r1 == 0) goto L_0x0030
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.interfaces.AdMostAdNetworkInitInterface> r2 = r6.adNetworkInitAdapters     // Catch:{ all -> 0x025d }
            boolean r2 = r2.containsKey(r1)     // Catch:{ all -> 0x025d }
            if (r2 == 0) goto L_0x0030
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.interfaces.AdMostAdNetworkInitInterface> r7 = r6.adNetworkInitAdapters     // Catch:{ all -> 0x025d }
            java.lang.Object r7 = r7.get(r1)     // Catch:{ all -> 0x025d }
            admost.sdk.interfaces.AdMostAdNetworkInitInterface r7 = (admost.sdk.interfaces.AdMostAdNetworkInitInterface) r7     // Catch:{ all -> 0x025d }
            monitor-exit(r6)
            return r7
        L_0x0030:
            boolean r2 = admost.sdk.base.AdMostAdNetwork.isAdNetworkAvailable(r7)     // Catch:{ all -> 0x025d }
            r3 = 0
            if (r2 != 0) goto L_0x004d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r0.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r1 = "SDK class files not found : "
            r0.append(r1)     // Catch:{ all -> 0x025d }
            r0.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostLog.m303w(r7)     // Catch:{ all -> 0x025d }
            monitor-exit(r6)
            return r3
        L_0x004d:
            admost.sdk.base.AdMost r2 = admost.sdk.base.AdMost.getInstance()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostConfiguration r2 = r2.getConfiguration()     // Catch:{ all -> 0x025d }
            boolean r2 = r2.isAdNetworkRestrictedForUser(r7)     // Catch:{ all -> 0x025d }
            if (r2 == 0) goto L_0x0076
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r0.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r1 = "SDK class are avaliable but "
            r0.append(r1)     // Catch:{ all -> 0x025d }
            r0.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r7 = " initialization failed because you restricted the networks for test devices."
            r0.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostLog.m303w(r7)     // Catch:{ all -> 0x025d }
            monitor-exit(r6)
            return r3
        L_0x0076:
            admost.sdk.base.AdMost r2 = admost.sdk.base.AdMost.getInstance()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostConfiguration r2 = r2.getConfiguration()     // Catch:{ all -> 0x025d }
            boolean r2 = r2.isAdNetworkForbiddenForUser(r7)     // Catch:{ all -> 0x025d }
            if (r2 == 0) goto L_0x009f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r0.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r1 = "SDK class are available but "
            r0.append(r1)     // Catch:{ all -> 0x025d }
            r0.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r7 = " initialization failed because network is not suitable for children."
            r0.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostLog.m303w(r7)     // Catch:{ all -> 0x025d }
            monitor-exit(r6)
            return r3
        L_0x009f:
            java.lang.String r2 = "Init"
            java.lang.String r2 = r6.getAdapterName(r7, r2)     // Catch:{ all -> 0x025d }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x00b0 }
            java.lang.Object r2 = r2.newInstance()     // Catch:{ Exception -> 0x00b0 }
            admost.sdk.interfaces.AdMostAdNetworkInitInterface r2 = (admost.sdk.interfaces.AdMostAdNetworkInitInterface) r2     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00b6
        L_0x00b0:
            admost.sdk.base.AdMostAdNetworkManager$1 r2 = new admost.sdk.base.AdMostAdNetworkManager$1     // Catch:{ all -> 0x025d }
            r3 = 0
            r2.<init>(r3, r3, r3)     // Catch:{ all -> 0x025d }
        L_0x00b6:
            if (r1 == 0) goto L_0x00be
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.interfaces.AdMostAdNetworkInitInterface> r3 = r6.adNetworkInitAdapters     // Catch:{ all -> 0x025d }
            r3.put(r1, r2)     // Catch:{ all -> 0x025d }
            goto L_0x00c3
        L_0x00be:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.interfaces.AdMostAdNetworkInitInterface> r1 = r6.adNetworkInitAdapters     // Catch:{ all -> 0x025d }
            r1.put(r7, r2)     // Catch:{ all -> 0x025d }
        L_0x00c3:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x025d }
            int r3 = r2.minSdkVersion     // Catch:{ all -> 0x025d }
            r4 = 1
            if (r1 >= r3) goto L_0x00e5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r1.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r3 = "Minimum SDK version is lower than expected : "
            r1.append(r3)     // Catch:{ all -> 0x025d }
            r1.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x025d }
            r0.append(r1)     // Catch:{ all -> 0x025d }
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch:{ all -> 0x025d }
            r2.hasInitializationError = r4     // Catch:{ all -> 0x025d }
        L_0x00e5:
            r1 = 2
            java.lang.String r3 = r2.getAdapterVersion()     // Catch:{ Exception -> 0x013b }
            java.lang.String r3 = r3.substring(r1)     // Catch:{ Exception -> 0x013b }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = "19"
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x013b }
            if (r3 >= r5) goto L_0x0156
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013b }
            r3.<init>()     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = "Minimum supported "
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            r3.append(r7)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = " adapter version for AdMost SDK is "
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = ".a19"
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = ". Adapter found : "
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = r2.getAdapterVersion()     // Catch:{ Exception -> 0x013b }
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = " (SDK Version : "
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = "2.1.7"
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = ")"
            r3.append(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x013b }
            r0.append(r3)     // Catch:{ Exception -> 0x013b }
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch:{ Exception -> 0x013b }
            r2.hasInitializationError = r4     // Catch:{ Exception -> 0x013b }
            goto L_0x0156
        L_0x013b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r3.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r5 = "Incompatible AdMost SDK and network adapter version(1) : "
            r3.append(r5)     // Catch:{ all -> 0x025d }
            r3.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x025d }
            r0.append(r3)     // Catch:{ all -> 0x025d }
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch:{ all -> 0x025d }
            r2.hasInitializationError = r4     // Catch:{ all -> 0x025d }
        L_0x0156:
            java.lang.String r3 = r2.getMinSdkVersion()     // Catch:{ Exception -> 0x01a9 }
            int r3 = r6.getVersionCode(r3)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = "2.1.7"
            int r5 = r6.getVersionCode(r5)     // Catch:{ Exception -> 0x01a9 }
            if (r5 >= r3) goto L_0x01c4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a9 }
            r3.<init>()     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = "Minimum supported AdMost SDK version for this "
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            r3.append(r7)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = " is "
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = r2.getMinSdkVersion()     // Catch:{ Exception -> 0x01a9 }
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = ". SDK found : "
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = "2.1.7"
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = " (Adapter Version : "
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = r2.getAdapterVersion()     // Catch:{ Exception -> 0x01a9 }
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = ")"
            r3.append(r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01a9 }
            r0.append(r3)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch:{ Exception -> 0x01a9 }
            r2.hasInitializationError = r4     // Catch:{ Exception -> 0x01a9 }
            goto L_0x01c4
        L_0x01a9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r3.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r5 = "Incompatible AdMost SDK and network adapter version(2) : "
            r3.append(r5)     // Catch:{ all -> 0x025d }
            r3.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x025d }
            r0.append(r3)     // Catch:{ all -> 0x025d }
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch:{ all -> 0x025d }
            r2.hasInitializationError = r4     // Catch:{ all -> 0x025d }
        L_0x01c4:
            int r3 = r2.initParameterCount     // Catch:{ all -> 0x025d }
            if (r3 <= 0) goto L_0x021c
            boolean r3 = admost.sdk.base.AdMostUtil.hasInitIds(r7)     // Catch:{ all -> 0x025d }
            if (r3 != 0) goto L_0x01e5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r1.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r3 = "At least 1 init id has to be entered in dashboard : "
            r1.append(r3)     // Catch:{ all -> 0x025d }
            r1.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostLog.m303w(r7)     // Catch:{ all -> 0x025d }
            r2.hasInitializationError = r4     // Catch:{ all -> 0x025d }
            goto L_0x021c
        L_0x01e5:
            int r3 = r2.initParameterCount     // Catch:{ all -> 0x025d }
            if (r3 <= r4) goto L_0x021c
            admost.sdk.base.AdMost r3 = admost.sdk.base.AdMost.getInstance()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostConfiguration r3 = r3.getConfiguration()     // Catch:{ all -> 0x025d }
            java.lang.String[] r3 = r3.getInitId(r7)     // Catch:{ all -> 0x025d }
            if (r3 == 0) goto L_0x0206
            admost.sdk.base.AdMost r3 = admost.sdk.base.AdMost.getInstance()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostConfiguration r3 = r3.getConfiguration()     // Catch:{ all -> 0x025d }
            java.lang.String[] r3 = r3.getInitId(r7)     // Catch:{ all -> 0x025d }
            int r3 = r3.length     // Catch:{ all -> 0x025d }
            if (r3 >= r1) goto L_0x021c
        L_0x0206:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x025d }
            r1.<init>()     // Catch:{ all -> 0x025d }
            java.lang.String r3 = "At least 2 init ids have to be entered in dashboard : "
            r1.append(r3)     // Catch:{ all -> 0x025d }
            r1.append(r7)     // Catch:{ all -> 0x025d }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x025d }
            admost.sdk.base.AdMostLog.m303w(r7)     // Catch:{ all -> 0x025d }
            r2.hasInitializationError = r4     // Catch:{ all -> 0x025d }
        L_0x021c:
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x025d }
            java.lang.String r0 = ""
            boolean r0 = r7.equals(r0)     // Catch:{ all -> 0x025d }
            if (r0 != 0) goto L_0x025b
            admost.sdk.base.AdMostLog.allError(r7)     // Catch:{ Exception -> 0x025b }
            boolean r0 = admost.sdk.base.AdMostLog.isEnabled()     // Catch:{ Exception -> 0x025b }
            if (r0 == 0) goto L_0x025b
            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()     // Catch:{ Exception -> 0x025b }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x025b }
            if (r0 == 0) goto L_0x025b
            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()     // Catch:{ Exception -> 0x025b }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x025b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025b }
            r1.<init>()     // Catch:{ Exception -> 0x025b }
            java.lang.String r3 = "AdMost ERROR:\n"
            r1.append(r3)     // Catch:{ Exception -> 0x025b }
            r1.append(r7)     // Catch:{ Exception -> 0x025b }
            java.lang.String r7 = r1.toString()     // Catch:{ Exception -> 0x025b }
            android.widget.Toast r7 = android.widget.Toast.makeText(r0, r7, r4)     // Catch:{ Exception -> 0x025b }
            r7.show()     // Catch:{ Exception -> 0x025b }
        L_0x025b:
            monitor-exit(r6)
            return r2
        L_0x025d:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostAdNetworkManager.getInitAdapter(java.lang.String):admost.sdk.interfaces.AdMostAdNetworkInitInterface");
    }
}
