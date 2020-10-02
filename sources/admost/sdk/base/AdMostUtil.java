package admost.sdk.base;

import admost.sdk.AdMostManager;
import admost.sdk.listener.AdMostBiddingEventListener;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostFrequencyCappingItem;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.drive.DriveFile;
import com.ogury.p159cm.OguryChoiceManager;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AdMostUtil {
    public static final String ERROR_BINDER = "AdMostViewBinder must be init with layoutId, iconImageId(ImageView), titleId(TextView) and callToActionId(Button) assets";
    static final String HOST_ADBLOCKER_CHECK = "https://www.admost.com";
    static final String HOST_ADBLOCKER_CHECK_ADMOB = "https://www.admob.com";
    static final String HOST_BIDDING_DEBUG_DATA_URL = "med-api.admost.com/v4.5/debug/bid_data";
    static final String HOST_CAMPAIGN_TRACK = "med-api.admost.com/v4.4/campaign/track/%s?pkg=%s";
    static final String HOST_COUNTRY = "med-api.admost.com/v4/country";
    static final String HOST_EXPERIMENT = "cdn-api.admost.com/v4.3/experiment/%s/group/%s/app/%s";
    static final String HOST_IMPRESSION = "med-api.admost.com/v4.5/count/%s/version/1.5";
    static final String HOST_IMPRESSION_UNKNOWNHOST = "195.244.38.37/v4.5/count/%s/version/1.5";
    static final String HOST_INIT = "cdn-api.admost.com/v4.3/init/%s/version/%s?pkg=%s";
    static final String HOST_REGISTER = "med-api.admost.com/v4.4/register/%s?pkg=%s";
    static final String HOST_SEND_IAP = "med-api.admost.com/v4.5/send_iap/%s";
    static final String HOST_SSV_COMPLETE = "ssv.admost.com/v2/complete/%s";
    static final String HOST_SSV_SHOW = "ssv.admost.com/v2/show/%s";
    static final String HOST_TEST_DATA_URL = "med-api.admost.com/v4.2/debug/user_data";
    static final String HOST_TEST_SUITE_ZONES = "med-api.admost.com/v4.1/zones/%s";
    static final String HOST_TIMING_STATS = "statistic.admost.com/v1/ad/timing";
    static final String HOST_TRACK_IAP = "med-api.admost.com/v4/track_iap/%s";
    static final String HOST_UPDATE_USER = "med-api.admost.com/v4.4/update/%s?pkg=%s";
    static final String HOST_ZONE = "cdn-api.admost.com/v4.5/zone/%s/country/%s/version/%s?pkg=%s&exp=%s&group=%s";
    static final String charset = "UTF-8";
    static final String encriptionAlgorithm = "AES";
    static final String encriptionAlgorithmFull = "AES/CBC/PKCS5PADDING";
    static final int flag = 8;
    private static String networkInfo;
    private static long networkInfoLastRefreshed;
    private static Point screenDimensions;

    public static String appVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean checkFrequencyCapping(AdMostBannerResponseItem adMostBannerResponseItem, boolean z) {
        AdMostFrequencyCappingItem adMostFrequencyCappingItem;
        AdMostFrequencyCappingItem adMostFrequencyCappingItem2;
        boolean z2 = true;
        if ((!z || !adMostBannerResponseItem.BypassFrequencyCappingOnSecondRun) && (adMostBannerResponseItem.FcapH > 0 || adMostBannerResponseItem.FcapD > 0 || adMostBannerResponseItem.ImpressionInterval > 0)) {
            String str = adMostBannerResponseItem.ZoneId + "*" + adMostBannerResponseItem.PlacementId;
            if (AdMostManager.getInstance().adFrequencyMap.containsKey(str)) {
                adMostFrequencyCappingItem2 = AdMostManager.getInstance().adFrequencyMap.get(str);
            } else {
                adMostFrequencyCappingItem2 = new AdMostFrequencyCappingItem();
                AdMostManager.getInstance().adFrequencyMap.put(str, adMostFrequencyCappingItem2);
                AdMostPreferences.getInstance().getFCapValues(str, adMostFrequencyCappingItem2);
            }
            int i = adMostBannerResponseItem.FcapH;
            if (i > 0) {
                adMostFrequencyCappingItem2.FcapHourly = i;
                if (adMostFrequencyCappingItem2.FcapHourStartedAt > System.currentTimeMillis() - 3600000 && adMostFrequencyCappingItem2.HourlyCount >= adMostFrequencyCappingItem2.FcapHourly) {
                    AdMostLog.m301v("Ad will not be shown: FCap Hourly " + adMostFrequencyCappingItem2.FcapHourly + " ,capKey: " + str);
                    z2 = false;
                }
            }
            int i2 = adMostBannerResponseItem.FcapD;
            if (i2 > 0) {
                adMostFrequencyCappingItem2.FcapDaily = i2;
                if (adMostFrequencyCappingItem2.FcapDayStartedAt > System.currentTimeMillis() - 86400000 && adMostFrequencyCappingItem2.DailyCount >= adMostFrequencyCappingItem2.FcapDaily) {
                    AdMostLog.m301v("Ad will not be shown: FCap Daily " + adMostFrequencyCappingItem2.FcapDaily + " ,capKey: " + str);
                    z2 = false;
                }
            }
            int i3 = adMostBannerResponseItem.ImpressionInterval;
            if (i3 > 0) {
                adMostFrequencyCappingItem2.ImpresionInterval = i3;
                long currentTimeMillis = adMostFrequencyCappingItem2.LastImpressionTime - (System.currentTimeMillis() - ((long) (adMostBannerResponseItem.ImpressionInterval * 1000)));
                if (currentTimeMillis > 0) {
                    AdMostLog.m301v("Ad will not be shown: ImpressionInterval remaining time: " + currentTimeMillis + " ,capKey: " + str);
                    z2 = false;
                }
            }
        }
        if (z) {
            return z2;
        }
        if (adMostBannerResponseItem.NFFcap > 0 && adMostBannerResponseItem.ZoneNFFcapTime > 0) {
            String str2 = "NFFC*" + adMostBannerResponseItem.ZoneId + "*" + adMostBannerResponseItem.PlacementId;
            if (AdMostManager.getInstance().adFrequencyMap.containsKey(str2)) {
                adMostFrequencyCappingItem = AdMostManager.getInstance().adFrequencyMap.get(str2);
            } else {
                adMostFrequencyCappingItem = new AdMostFrequencyCappingItem();
                AdMostManager.getInstance().adFrequencyMap.put(str2, adMostFrequencyCappingItem);
                AdMostPreferences.getInstance().getFCapValues(str2, adMostFrequencyCappingItem);
            }
            adMostFrequencyCappingItem.NffcCap = adMostBannerResponseItem.NFFcap;
            adMostFrequencyCappingItem.NffcCapTime = adMostBannerResponseItem.ZoneNFFcapTime;
            if (adMostFrequencyCappingItem.NffcStartedAt > System.currentTimeMillis() - ((long) (adMostFrequencyCappingItem.NffcCapTime * 3600000)) && adMostFrequencyCappingItem.NffcCount >= adMostFrequencyCappingItem.NffcCap) {
                AdMostLog.m301v("NFFC Cap reached. NffcCount: " + adMostFrequencyCappingItem.NffcCount + " ,nffCapKey: " + str2);
                return false;
            }
        }
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkRandomizerBypass(admost.sdk.model.AdMostBannerResponseBase r9) {
        /*
            int r0 = r9.ZoneRandomizerBypassCount
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r9.ZoneRandomizerBypassInterval
            r2 = 0
            if (r0 != 0) goto L_0x000c
            return r2
        L_0x000c:
            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.getInstance()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostRandomizerBypassItem> r0 = r0.adRandomizerBypassMap
            java.lang.String r3 = r9.ZoneId
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0029
            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.getInstance()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostRandomizerBypassItem> r0 = r0.adRandomizerBypassMap
            java.lang.String r3 = r9.ZoneId
            java.lang.Object r0 = r0.get(r3)
            admost.sdk.model.AdMostRandomizerBypassItem r0 = (admost.sdk.model.AdMostRandomizerBypassItem) r0
            goto L_0x0042
        L_0x0029:
            admost.sdk.model.AdMostRandomizerBypassItem r0 = new admost.sdk.model.AdMostRandomizerBypassItem
            r0.<init>()
            admost.sdk.AdMostManager r3 = admost.sdk.AdMostManager.getInstance()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostRandomizerBypassItem> r3 = r3.adRandomizerBypassMap
            java.lang.String r4 = r9.ZoneId
            r3.put(r4, r0)
            admost.sdk.base.AdMostPreferences r3 = admost.sdk.base.AdMostPreferences.getInstance()
            java.lang.String r4 = r9.ZoneId
            r3.getRandomizerBypassValues(r4, r0)
        L_0x0042:
            long r3 = r0.StartedAt
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0065
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r0.StartedAt
            int r7 = r9.ZoneRandomizerBypassInterval
            int r7 = r7 * 1000
            long r7 = (long) r7
            long r5 = r5 + r7
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005b
            goto L_0x0065
        L_0x005b:
            int r3 = r0.Count
            int r4 = r9.ZoneRandomizerBypassCount
            if (r3 >= r4) goto L_0x006e
            int r3 = r3 + r1
            r0.Count = r3
            goto L_0x006d
        L_0x0065:
            long r3 = java.lang.System.currentTimeMillis()
            r0.StartedAt = r3
            r0.Count = r1
        L_0x006d:
            r1 = 0
        L_0x006e:
            if (r1 != 0) goto L_0x0079
            admost.sdk.base.AdMostPreferences r2 = admost.sdk.base.AdMostPreferences.getInstance()
            java.lang.String r9 = r9.ZoneId
            r2.storeRandomizerBypassValues(r9, r0)
        L_0x0079:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostUtil.checkRandomizerBypass(admost.sdk.model.AdMostBannerResponseBase):boolean");
    }

    public static boolean checkTagFrequencyCapping(String str) {
        AdMostFrequencyCappingItem adMostFrequencyCappingItem;
        AdMostFrequencyCappingItem cappingForTag = AdMostPolicyManager.getInstance().getCappingForTag(str);
        boolean z = true;
        if (cappingForTag == null || (cappingForTag.ZoneFcapDaily <= 0 && cappingForTag.ZoneImpressionInterval <= 0)) {
            return true;
        }
        String str2 = "TAG*" + str;
        if (AdMostManager.getInstance().adFrequencyMap.containsKey(str2)) {
            adMostFrequencyCappingItem = AdMostManager.getInstance().adFrequencyMap.get(str2);
        } else {
            AdMostFrequencyCappingItem adMostFrequencyCappingItem2 = new AdMostFrequencyCappingItem();
            AdMostManager.getInstance().adFrequencyMap.put(str2, adMostFrequencyCappingItem2);
            AdMostPreferences.getInstance().getFCapValues(str2, adMostFrequencyCappingItem2);
            adMostFrequencyCappingItem = adMostFrequencyCappingItem2;
        }
        AdMostLog.m301v("You have capping in tag named : { " + str + " }");
        if (cappingForTag.ZoneFcapDaily > 0) {
            AdMostLog.m301v("Daily FCAP Found and it is :[" + cappingForTag.ZoneFcapDaily + "]");
            adMostFrequencyCappingItem.ZoneFcapDaily = cappingForTag.ZoneFcapDaily;
            if ((adMostFrequencyCappingItem.ZoneFcapDayStartedAt + 86400000) - System.currentTimeMillis() > 0 && adMostFrequencyCappingItem.ZoneDailyCount >= adMostFrequencyCappingItem.ZoneFcapDaily) {
                z = false;
            }
        }
        if (cappingForTag.ZoneImpressionInterval > 0) {
            AdMostLog.m301v("Impression Interval Found and it is :[" + cappingForTag.ZoneImpressionInterval + "]");
            adMostFrequencyCappingItem.ZoneImpressionInterval = cappingForTag.ZoneImpressionInterval;
            if ((adMostFrequencyCappingItem.ZoneLastImpressionTime + ((long) (cappingForTag.ZoneImpressionInterval * 1000))) - System.currentTimeMillis() > 0) {
                return false;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013a, code lost:
        if (r2 < (r13.FCapLoadThreshold * 1000)) goto L_0x0017;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static admost.sdk.model.AdMostZoneFrequencyCapItem checkZoneFrequencyCapping(admost.sdk.model.AdMostBannerResponseBase r13, boolean r14) {
        /*
            admost.sdk.base.AdMostPolicyManager r0 = admost.sdk.base.AdMostPolicyManager.getInstance()
            r0.updateZoneFrequencyCappingPolicies(r13)
            int r0 = r13.ZoneFcapDaily
            r1 = 1
            r2 = 0
            if (r0 > 0) goto L_0x001a
            int r0 = r13.ZoneFcapHourly
            if (r0 > 0) goto L_0x001a
            int r0 = r13.ZoneImpressionInterval
            if (r0 <= 0) goto L_0x0017
            goto L_0x001a
        L_0x0017:
            r5 = 1
            goto L_0x013e
        L_0x001a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "ZONE*"
            r0.append(r4)
            java.lang.String r4 = r13.ZoneId
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            admost.sdk.AdMostManager r4 = admost.sdk.AdMostManager.getInstance()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostFrequencyCappingItem> r4 = r4.adFrequencyMap
            boolean r4 = r4.containsKey(r0)
            if (r4 == 0) goto L_0x0046
            admost.sdk.AdMostManager r4 = admost.sdk.AdMostManager.getInstance()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostFrequencyCappingItem> r4 = r4.adFrequencyMap
            java.lang.Object r0 = r4.get(r0)
            admost.sdk.model.AdMostFrequencyCappingItem r0 = (admost.sdk.model.AdMostFrequencyCappingItem) r0
            goto L_0x005c
        L_0x0046:
            admost.sdk.model.AdMostFrequencyCappingItem r4 = new admost.sdk.model.AdMostFrequencyCappingItem
            r4.<init>()
            admost.sdk.AdMostManager r5 = admost.sdk.AdMostManager.getInstance()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostFrequencyCappingItem> r5 = r5.adFrequencyMap
            r5.put(r0, r4)
            admost.sdk.base.AdMostPreferences r5 = admost.sdk.base.AdMostPreferences.getInstance()
            r5.getFCapValues(r0, r4)
            r0 = r4
        L_0x005c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "You have capping in zone named : { "
            r4.append(r5)
            java.lang.String r5 = r13.zoneName
            r4.append(r5)
            java.lang.String r5 = " }"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            admost.sdk.base.AdMostLog.m301v(r4)
            int r4 = r13.ZoneFcapHourly
            r5 = 0
            java.lang.String r6 = "]"
            if (r4 <= 0) goto L_0x00b8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "Hourly FCAP Found and it is :["
            r4.append(r7)
            int r7 = r13.ZoneFcapHourly
            r4.append(r7)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            admost.sdk.base.AdMostLog.m301v(r4)
            int r4 = r13.ZoneFcapHourly
            r0.ZoneFcapHourly = r4
            long r7 = r0.ZoneFcapHourStartedAt
            r9 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r7 + r9
            long r9 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r9
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b8
            int r4 = r0.ZoneHourlyCount
            int r9 = r0.ZoneFcapHourly
            if (r4 < r9) goto L_0x00b8
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r7 = r2
        L_0x00b6:
            r4 = 0
            goto L_0x00ba
        L_0x00b8:
            r7 = r2
            r4 = 1
        L_0x00ba:
            int r9 = r13.ZoneFcapDaily
            if (r9 <= 0) goto L_0x00f6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Daily FCAP Found and it is :["
            r9.append(r10)
            int r10 = r13.ZoneFcapDaily
            r9.append(r10)
            r9.append(r6)
            java.lang.String r9 = r9.toString()
            admost.sdk.base.AdMostLog.m301v(r9)
            int r9 = r13.ZoneFcapDaily
            r0.ZoneFcapDaily = r9
            long r9 = r0.ZoneFcapDayStartedAt
            r11 = 86400000(0x5265c00, double:4.2687272E-316)
            long r9 = r9 + r11
            long r11 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r11
            int r11 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r11 <= 0) goto L_0x00f6
            int r11 = r0.ZoneDailyCount
            int r12 = r0.ZoneFcapDaily
            if (r11 < r12) goto L_0x00f6
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f5
            r7 = r9
        L_0x00f5:
            r4 = 0
        L_0x00f6:
            int r9 = r13.ZoneImpressionInterval
            if (r9 <= 0) goto L_0x012c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Impression Interval Found and it is :["
            r9.append(r10)
            int r10 = r13.ZoneImpressionInterval
            r9.append(r10)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            admost.sdk.base.AdMostLog.m301v(r6)
            int r6 = r13.ZoneImpressionInterval
            r0.ZoneImpressionInterval = r6
            long r9 = r0.ZoneLastImpressionTime
            int r6 = r6 * 1000
            long r11 = (long) r6
            long r9 = r9 + r11
            long r11 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r11
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x012c
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x012d
            r7 = r9
            goto L_0x012d
        L_0x012c:
            r5 = r4
        L_0x012d:
            r2 = r7
            if (r5 != 0) goto L_0x013e
            if (r14 == 0) goto L_0x013e
            long r13 = r13.FCapLoadThreshold
            r6 = 1000(0x3e8, double:4.94E-321)
            long r13 = r13 * r6
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 >= 0) goto L_0x013e
            goto L_0x0017
        L_0x013e:
            admost.sdk.model.AdMostZoneFrequencyCapItem r13 = new admost.sdk.model.AdMostZoneFrequencyCapItem
            r14 = r5 ^ 1
            r13.<init>(r14, r2)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostUtil.checkZoneFrequencyCapping(admost.sdk.model.AdMostBannerResponseBase, boolean):admost.sdk.model.AdMostZoneFrequencyCapItem");
    }

    public static void clearNffc(String str) {
        AdMostFrequencyCappingItem adMostFrequencyCappingItem = AdMostManager.getInstance().adFrequencyMap.get(str);
        if (adMostFrequencyCappingItem != null && adMostFrequencyCappingItem.NffcCap > 0 && adMostFrequencyCappingItem.NffcCapTime > 0 && adMostFrequencyCappingItem.NffcCount > 0) {
            AdMostLog.m301v("NFFC cleared : " + str);
            adMostFrequencyCappingItem.NffcCount = 0;
            AdMostPreferences.getInstance().storeFCapValues(str, adMostFrequencyCappingItem);
        }
    }

    public static String decrypt(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (!str.equals("") && str3 != null && !str3.equals("") && str2 != null) {
                    if (!str2.equals("")) {
                        String decode = URLDecoder.decode(str, "UTF-8");
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes("UTF-8"));
                        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), encriptionAlgorithm);
                        Cipher instance = Cipher.getInstance(encriptionAlgorithmFull);
                        instance.init(2, secretKeySpec, ivParameterSpec);
                        return new String(instance.doFinal(Base64.decode(decode, 8)), "UTF-8");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String deviceInfo() {
        try {
            return URLEncoder.encode(Build.BRAND + " " + Build.MODEL, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encrypt(String str, String str2, String str3, boolean z) {
        if (str != null) {
            try {
                if (!str.equals("") && str2 != null && !str2.equals("") && str3 != null) {
                    if (!str3.equals("")) {
                        String str4 = str2.substring(0, 8) + str3.substring(0, 8);
                        if (z) {
                            str4 = str2.substring(0, 16) + str3.substring(0, 16);
                        }
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes("UTF-8"));
                        SecretKeySpec secretKeySpec = new SecretKeySpec(str4.getBytes("UTF-8"), encriptionAlgorithm);
                        Cipher instance = Cipher.getInstance(encriptionAlgorithmFull);
                        instance.init(1, secretKeySpec, ivParameterSpec);
                        byte[] doFinal = instance.doFinal(str.getBytes("UTF-8"));
                        return str3 + URLEncoder.encode(Base64.encodeToString(doFinal, 8), "UTF-8");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String getAdErrorName(int i) {
        if (i == 500) {
            return "AD_ERROR_CONNECTION";
        }
        if (i == 501) {
            return "AD_ERROR_TOO_MANY_REQUEST";
        }
        switch (i) {
            case AdMost.AD_ERROR_FREQ_CAP:
                return "AD_ERROR_FREQ_CAP";
            case AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN:
                return "AD_ERROR_FREQ_CAP_ON_SHOWN";
            case AdMost.AD_ERROR_TAG_PASSIVE:
                return "AD_ERROR_TAG_PASSIVE";
            case AdMost.AD_ERROR_ZONE_PASSIVE:
                return "AD_ERROR_ZONE_PASSIVE";
            case AdMost.AD_ERROR_ZONE_TIMEOUT:
                return "AD_ERROR_ZONE_TIMEOUT";
            case AdMost.AD_ERROR_FAILED_TO_SHOW:
                return "AD_ERROR_FAILED_TO_SHOW";
            default:
                switch (i) {
                    case 400:
                        return "AD_ERROR_NO_FILL";
                    case AdMost.AD_ERROR_WATERFALL_EMPTY:
                        return "AD_ERROR_WATERFALL_EMPTY";
                    case AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID:
                        return "AD_ERROR_INCOMPATIBLE_APP_ZONE_ID";
                    default:
                        return "UNKNOWN_ERROR";
                }
        }
    }

    public static String getAdStatusName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "DESTROYED" : "SHOWN" : "LOADED" : "LOADING" : "NEW";
    }

    public static String getAlphaNumericString16() {
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            double d = (double) 61;
            double random = Math.random();
            Double.isNaN(d);
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz".charAt((int) (d * random)));
        }
        return sb.toString();
    }

    public static int getDip(int i) {
        return Math.round(((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static String getEncryptedHex(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            if (str == null) {
                str = "admostcrosspromo";
            }
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG");
                byte[] bArr2 = new byte[instance.getBlockSize()];
                instance2.nextBytes(bArr2);
                instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), encriptionAlgorithm), new IvParameterSpec(bArr2));
                String format = String.format("%096x", new Object[]{new BigInteger(1, instance.doFinal(bArr))});
                if (format.length() % 2 != 0) {
                    format = AppEventsConstants.EVENT_PARAM_VALUE_NO + format;
                }
                if (str.length() == 32) {
                    while (format.length() % 16 != 0) {
                        if (format.length() % 16 != 0) {
                            format = AppEventsConstants.EVENT_PARAM_VALUE_NO + format;
                        }
                    }
                }
                return String.format("%032x", new Object[]{new BigInteger(1, bArr2)}) + format;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getEventListenerStatusName(int i) {
        switch (i) {
            case 0:
                return "SUCCESS";
            case 1:
                return AdMostBiddingEventListener.ERROR_INITIALIZATION_ERROR;
            case 2:
                return "ERROR_SDK_VERSION";
            case 3:
                return "ERROR_INITIALIZATION_STARTED";
            case 4:
                return AdMostBiddingEventListener.ERROR_STATUS_CHANGED;
            case 5:
                return AdMostBiddingEventListener.ERROR_SINGLETON;
            case 6:
                return "ERROR_NO_FILL";
            case 7:
                return AdMostBiddingEventListener.ERROR_UNKNOWN_REASON;
            case 8:
                return AdMostBiddingEventListener.ERROR_REQUEST_TIMEOUT;
            case 9:
                return AdMostBannerResponseFailReason.REQUEST_LIMIT_PER_WATERFALL;
            case 10:
                return "ERROR_NOT_SUPPORTED_AD_TYPE";
            default:
                return "STATUS NOT KNOWN";
        }
    }

    public static String getIPAddress(boolean z) {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            boolean z2 = hostAddress.indexOf(58) < 0;
                            if (z) {
                                if (z2) {
                                    return hostAddress;
                                }
                            } else if (!z2) {
                                int indexOf = hostAddress.indexOf(37);
                                return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static String getLocaleCountryCode(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (telephonyManager.getPhoneType() != 2) {
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (networkCountryIso == null || networkCountryIso.length() != 2) {
                    return "DE";
                }
                return networkCountryIso.toUpperCase(Locale.US);
            } else if (simCountryIso == null || simCountryIso.length() != 2) {
                return "DE";
            } else {
                return simCountryIso.toUpperCase(Locale.US);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "DE";
        }
    }

    public static String getNetworkClass(Context context) {
        String str = networkInfo;
        if (str != null && str.length() > 0 && networkInfoLastRefreshed > System.currentTimeMillis() - 60000) {
            return networkInfo;
        }
        networkInfo = "";
        networkInfoLastRefreshed = System.currentTimeMillis();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1) {
                networkInfo = "&connected=wifi";
            } else {
                networkInfo = "&connected=gsm";
            }
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    networkInfo += "&network=2G";
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    networkInfo += "&network=3G";
                    break;
                case 13:
                    networkInfo += "&network=4G";
                    break;
                default:
                    networkInfo += "&network=unknown";
                    break;
            }
        } catch (Exception unused) {
            networkInfo = "&connected=problem";
        }
        return networkInfo;
    }

    public static int getRandom(int i) {
        if (i < 1) {
            return 0;
        }
        return new Random().nextInt(i);
    }

    @TargetApi(13)
    public static Point getScreenDims(Activity activity) {
        try {
            if (screenDimensions != null && screenDimensions.x > 0) {
                return screenDimensions;
            }
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            screenDimensions = point;
            defaultDisplay.getSize(point);
            return screenDimensions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean hasInitIds(String str) {
        String[] initId = AdMost.getInstance().getConfiguration().getInitId(str);
        if (initId == null || initId.length == 0) {
            return false;
        }
        return true;
    }

    public static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isInCCPA(AdMostPreferences adMostPreferences) {
        String state = adMostPreferences.getState();
        return state != null && state.equals("CA");
    }

    public static boolean isInEU(AdMostPreferences adMostPreferences) {
        String country = adMostPreferences.getCountry();
        return country.equals("DE") || country.equals("GB") || country.equals("AU") || country.equals("BE") || country.equals("BG") || country.equals("HR") || country.equals("CZ") || country.equals("DK") || country.equals("EE") || country.equals("FI") || country.equals("FR") || country.equals("GR") || country.equals("HU") || country.equals("IE") || country.equals("IT") || country.equals("LV") || country.equals("LT") || country.equals("LU") || country.equals("MT") || country.equals("NL") || country.equals("PL") || country.equals("PT") || country.equals("SK") || country.equals("SI") || country.equals("ES") || country.equals("SE") || country.equals("CY") || country.equals("NO") || country.equals("IS") || country.equals("LI");
    }

    static boolean isInstalledFromPlayStore(Activity activity) {
        PackageManager packageManager = activity.getPackageManager();
        try {
            if ("com.android.vending".equals(packageManager.getInstallerPackageName(packageManager.getApplicationInfo(activity.getPackageName(), 0).packageName))) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int isNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? 0 : 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (packageInfo.requestedPermissions != null) {
                for (String equals : packageInfo.requestedPermissions) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isTabletDevice(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) == 4) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i == 160 || i == 240 || i == 160 || i == 213 || i == 320) {
                return true;
            }
        }
        return false;
    }

    public static void keepFrequencyCapping(String str) {
        int i;
        AdMostFrequencyCappingItem adMostFrequencyCappingItem = AdMostManager.getInstance().adFrequencyMap.get(str);
        if (adMostFrequencyCappingItem != null) {
            if (adMostFrequencyCappingItem.FcapHourly > 0) {
                if (adMostFrequencyCappingItem.FcapHourStartedAt < System.currentTimeMillis() - 3600000) {
                    adMostFrequencyCappingItem.FcapHourStartedAt = System.currentTimeMillis();
                    adMostFrequencyCappingItem.HourlyCount = 0;
                }
                adMostFrequencyCappingItem.LastImpressionTime = System.currentTimeMillis();
                adMostFrequencyCappingItem.HourlyCount++;
            }
            if (adMostFrequencyCappingItem.FcapDaily > 0) {
                if (adMostFrequencyCappingItem.FcapDayStartedAt < System.currentTimeMillis() - 86400000) {
                    adMostFrequencyCappingItem.FcapDayStartedAt = System.currentTimeMillis();
                    adMostFrequencyCappingItem.DailyCount = 0;
                }
                adMostFrequencyCappingItem.LastImpressionTime = System.currentTimeMillis();
                adMostFrequencyCappingItem.DailyCount++;
            }
            if (adMostFrequencyCappingItem.ImpresionInterval > 0) {
                adMostFrequencyCappingItem.LastImpressionTime = System.currentTimeMillis();
            }
            if (adMostFrequencyCappingItem.NffcCap > 0 && adMostFrequencyCappingItem.NffcCapTime > 0) {
                if (adMostFrequencyCappingItem.NffcStartedAt < System.currentTimeMillis() - ((long) (adMostFrequencyCappingItem.NffcCapTime * 3600000))) {
                    adMostFrequencyCappingItem.NffcStartedAt = System.currentTimeMillis();
                    adMostFrequencyCappingItem.NffcCount = 0;
                }
                adMostFrequencyCappingItem.NffcCount++;
            }
            if (adMostFrequencyCappingItem.ZoneFcapHourly > 0) {
                if (adMostFrequencyCappingItem.ZoneFcapHourStartedAt < System.currentTimeMillis() - 3600000) {
                    adMostFrequencyCappingItem.ZoneFcapHourStartedAt = System.currentTimeMillis();
                    adMostFrequencyCappingItem.ZoneHourlyCount = 0;
                }
                adMostFrequencyCappingItem.ZoneHourlyCount++;
            }
            if (adMostFrequencyCappingItem.ZoneFcapDaily > 0) {
                if (adMostFrequencyCappingItem.ZoneFcapDayStartedAt < System.currentTimeMillis() - 86400000) {
                    adMostFrequencyCappingItem.ZoneFcapDayStartedAt = System.currentTimeMillis();
                    adMostFrequencyCappingItem.ZoneDailyCount = 0;
                }
                adMostFrequencyCappingItem.ZoneDailyCount++;
            }
            if (adMostFrequencyCappingItem.ZoneImpressionInterval > 0) {
                adMostFrequencyCappingItem.ZoneLastImpressionTime = System.currentTimeMillis();
            }
            if (adMostFrequencyCappingItem.FcapHourly > 0 || adMostFrequencyCappingItem.FcapDaily > 0 || adMostFrequencyCappingItem.LastImpressionTime > 0 || adMostFrequencyCappingItem.ZoneFcapHourly > 0 || adMostFrequencyCappingItem.ZoneFcapDaily > 0 || adMostFrequencyCappingItem.ZoneImpressionInterval > 0 || ((i = adMostFrequencyCappingItem.NffcCap) > 0 && adMostFrequencyCappingItem.NffcCapTime > 0 && adMostFrequencyCappingItem.NffcCount <= i)) {
                AdMostPreferences.getInstance().storeFCapValues(str, adMostFrequencyCappingItem);
            }
        }
    }

    public static String networkOperatorName(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager.getPhoneType() == 1) {
                return URLEncoder.encode(telephonyManager.getNetworkOperatorName(), "UTF-8");
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void showDebugActivity(AdMostBannerResponseBase adMostBannerResponseBase) {
        if (AdMostLog.isEnabled() && adMostBannerResponseBase != null && AdMost.getInstance().isInitStarted()) {
            Intent intent = new Intent(AdMost.getInstance().getContext(), AdMostDebugActivity.class);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            arrayList.addAll(adMostBannerResponseBase.NetworkList);
            arrayList2.addAll(adMostBannerResponseBase.NetworkListInHouse);
            arrayList3.addAll(adMostBannerResponseBase.NetworkListNotInWaterfall);
            arrayList4.addAll(adMostBannerResponseBase.BiddingItems);
            intent.putParcelableArrayListExtra("NETWORK", arrayList);
            intent.putParcelableArrayListExtra("NETWORK_INHOUSE", arrayList2);
            intent.putParcelableArrayListExtra("NETWORK_NOTINWATERFALL", arrayList3);
            intent.putParcelableArrayListExtra("NETWORK_BIDDING", arrayList4);
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            AdMost.getInstance().getContext().startActivity(intent);
        }
    }

    static double timeZone() {
        double rawOffset = (double) (TimeZone.getDefault().getRawOffset() + Calendar.getInstance().get(16));
        Double.isNaN(rawOffset);
        return rawOffset / 3600000.0d;
    }
}
