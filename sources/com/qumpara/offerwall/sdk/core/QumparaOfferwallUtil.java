package com.qumpara.offerwall.sdk.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.places.model.PlaceFields;
import com.loopj.android.http.C4250c;
import com.ogury.p159cm.OguryChoiceManager;
import com.qumpara.lib_qumpara_ads.R$id;
import com.qumpara.lib_qumpara_ads.R$layout;
import com.qumpara.lib_qumpara_ads.R$string;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class QumparaOfferwallUtil {
    public static final Uri BASE_CONTENT_URI;
    public static final String COLUMN_ADJUST_ID = "adjust_id";
    public static final String COLUMN_ADMOST_ID = "admost_id";
    public static final String COLUMN_IDFA = "idfa";
    public static final Uri CONTENT_URI;
    static String QUMPARA_BASE = "https://tr-api.fisicek.com/v2.1/ow/";
    static final String QUMPARA_BASE_PROD = "https://tr-api.fisicek.com/v2.1/ow/";
    static final String QUMPARA_BASE_TEST = "https://test-tr-api.fisicek.com/v2.1/ow/";
    static final String QUMPARA_COUNT_PROD = "http://ow-api.fisicek.com/v1/count";
    public static final String QUMPARA_SUFFIX_GET_CAMPAIGNS = "offers/app/";
    public static final String QUMPARA_SUFFIX_POST_ENGAGE = "engage/";
    public static final String QUMPARA_SUFFIX_POST_REDEEM = "redeem/";
    public static final String QUMPARA_SUFFIX_POST_SPEND_VIRTUAL_CURRENCY = "spend/";
    static final String QUMPARA_WEBSITE = "https://www.qumpara.com";
    public static final String TABLE_NAME = "user";
    public static final String _ID = "_id";
    private static String networkInfo;
    private static long networkInfoLastRefreshed;
    private static Point screenDimensions;

    static {
        Uri parse = Uri.parse("content://com.qumpara.dataprovider");
        BASE_CONTENT_URI = parse;
        CONTENT_URI = parse.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static String appVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static void arrangeViewColorFromRemoteConfig(View view, String str, int i) {
        int i2;
        if (str != null) {
            try {
                i2 = QumparaOfferwall.getContext().getResources().getColor(i);
                try {
                    if (!isNullOrEmpty(str)) {
                        i2 = Color.parseColor(str);
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i2 = -1;
            }
            if (i2 == -1) {
                return;
            }
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(i2);
            } else {
                view.setBackgroundColor(i2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0032 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void arrangeViewGradientColorFromRemoteConfig(android.view.View r4, java.lang.String r5, java.lang.String r6, int r7) {
        /*
            boolean r0 = isNullOrEmpty(r5)     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x0042
            boolean r0 = isNullOrEmpty(r6)     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x0042
            boolean r0 = r5.equals(r6)     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x0042
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ Exception -> 0x0032 }
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ Exception -> 0x0032 }
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x0032 }
            android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT     // Catch:{ Exception -> 0x0032 }
            r2 = 2
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x0032 }
            r3 = 0
            r2[r3] = r5     // Catch:{ Exception -> 0x0032 }
            r5 = 1
            r2[r5] = r6     // Catch:{ Exception -> 0x0032 }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0032 }
            r5 = 0
            r0.setCornerRadius(r5)     // Catch:{ Exception -> 0x0032 }
            r4.setBackgroundDrawable(r0)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0064
        L_0x0032:
            android.content.Context r5 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getContext()     // Catch:{ Exception -> 0x0060 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0060 }
            int r5 = r5.getColor(r7)     // Catch:{ Exception -> 0x0060 }
            r4.setBackgroundColor(r5)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0064
        L_0x0042:
            boolean r6 = isNullOrEmpty(r5)     // Catch:{ Exception -> 0x0060 }
            if (r6 != 0) goto L_0x0050
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ Exception -> 0x0060 }
            r4.setBackgroundColor(r5)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0064
        L_0x0050:
            android.content.Context r5 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getContext()     // Catch:{ Exception -> 0x0060 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0060 }
            int r5 = r5.getColor(r7)     // Catch:{ Exception -> 0x0060 }
            r4.setBackgroundColor(r5)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.arrangeViewGradientColorFromRemoteConfig(android.view.View, java.lang.String, java.lang.String, int):void");
    }

    public static String deviceInfo() {
        try {
            return URLEncoder.encode(Build.BRAND + " " + Build.MODEL, C4250c.DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getLocalizedErrorMessage(int i) {
        if (i == 251) {
            return QumparaOfferwall.getContext().getString(R$string.qumpara_offerwall_error_251);
        }
        if (i == 256) {
            return QumparaOfferwall.getContext().getString(R$string.qumpara_offerwall_error_256);
        }
        if (i != 1003) {
            return QumparaOfferwall.getContext().getString(R$string.qumpara_offerwall_error_unknown);
        }
        return QumparaOfferwall.getContext().getString(R$string.qumpara_offerwall_error_internet);
    }

    public static int getMinRwImageHeight(Context context, int i, int i2) {
        return (((getDeviceWidth(context) - ((i + 1) * i2)) / i) * 71) / OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
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

    public static void hideKeyboard(Context context, View view) {
        if (context != null && view != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
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

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
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

    public static String networkOperatorName(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager.getPhoneType() == 1) {
                return URLEncoder.encode(telephonyManager.getNetworkOperatorName(), C4250c.DEFAULT_CHARSET);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static void openInBrowser(Context context, String str) {
        if (!isNullOrEmpty(str) && context != null) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                str = "http://" + str;
            }
            String str2 = str + "&utm_source=offerwall&off_app_id=" + QumparaOfferwall.getIdentifiers().getApplicationId();
            Intent launchIntentForPackage = QumparaOfferwall.getContext().getPackageManager().getLaunchIntentForPackage("com.qumpara");
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setData(Uri.parse(str2));
                launchIntentForPackage.setAction("android.intent.action.VIEW");
            } else {
                launchIntentForPackage = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            }
            launchIntentForPackage.setFlags(268566528);
            context.startActivity(launchIntentForPackage);
        }
    }

    public static void openKeyboard(Context context) {
        if (context != null) {
            ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(2, 0);
        }
    }

    public static int pxOfDimen(int i, Context context) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int pxToDp(float f) {
        return (int) (f / (((float) Resources.getSystem().getDisplayMetrics().densityDpi) / 160.0f));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:6|(1:8)|9|10|11|12|16|(2:18|19)|20|21|(1:23)|24|(1:26)|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00f8 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x010b A[Catch:{ Exception -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0160 A[Catch:{ Exception -> 0x01b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.app.Dialog showCampaignDetailDialog(java.lang.ref.WeakReference<android.content.Context> r18, com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.OfferwallItem r19, com.qumpara.offerwall.sdk.listener.QumparaOfferwallDialogListener r20, com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.OfferwallResponse r21) {
        /*
            r9 = r19
            r10 = r20
            r1 = r21
            if (r9 == 0) goto L_0x01c3
            java.lang.Object r0 = r18.get()     // Catch:{ Exception -> 0x01b8 }
            if (r0 != 0) goto L_0x0010
            goto L_0x01c3
        L_0x0010:
            android.app.Dialog r12 = new android.app.Dialog     // Catch:{ Exception -> 0x01b8 }
            java.lang.Object r0 = r18.get()     // Catch:{ Exception -> 0x01b8 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x01b8 }
            int r2 = com.qumpara.lib_qumpara_ads.R$style.QumparaDialog     // Catch:{ Exception -> 0x01b8 }
            r12.<init>(r0, r2)     // Catch:{ Exception -> 0x01b8 }
            r2 = 1
            r12.setCancelable(r2)     // Catch:{ Exception -> 0x01b8 }
            r3 = 0
            r12.setCanceledOnTouchOutside(r3)     // Catch:{ Exception -> 0x01b8 }
            r12.requestWindowFeature(r2)     // Catch:{ Exception -> 0x01b8 }
            android.view.Window r0 = r12.getWindow()     // Catch:{ Exception -> 0x01b8 }
            if (r0 == 0) goto L_0x0046
            android.view.Window r0 = r12.getWindow()     // Catch:{ Exception -> 0x01b8 }
            android.graphics.drawable.ColorDrawable r4 = new android.graphics.drawable.ColorDrawable     // Catch:{ Exception -> 0x01b8 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x01b8 }
            r0.setBackgroundDrawable(r4)     // Catch:{ Exception -> 0x01b8 }
            android.view.Window r0 = r12.getWindow()     // Catch:{ Exception -> 0x01b8 }
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()     // Catch:{ Exception -> 0x01b8 }
            r4 = 1061158912(0x3f400000, float:0.75)
            r0.dimAmount = r4     // Catch:{ Exception -> 0x01b8 }
        L_0x0046:
            int r0 = com.qumpara.lib_qumpara_ads.R$layout.qumpara_offerwall_dialog     // Catch:{ Exception -> 0x01b8 }
            r12.setContentView(r0)     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.item_image     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r4 = r0
            com.qumpara.offerwall.sdk.img.FastImageView r4 = (com.qumpara.offerwall.sdk.img.FastImageView) r4     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.item_prize_image     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r5 = r0
            com.qumpara.offerwall.sdk.img.FastImageView r5 = (com.qumpara.offerwall.sdk.img.FastImageView) r5     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.item_reward_detail     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r6 = r0
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.item_prize_value     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r7 = r0
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.item_asset_layout     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r13 = r0
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.container_root     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r8 = r0
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.item_top_header_bold     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r14 = r0
            android.widget.TextView r14 = (android.widget.TextView) r14     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.qumpara_number_1     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x01b8 }
            int r15 = com.qumpara.lib_qumpara_ads.R$id.qumpara_number_2     // Catch:{ Exception -> 0x01b8 }
            android.view.View r15 = r12.findViewById(r15)     // Catch:{ Exception -> 0x01b8 }
            android.widget.TextView r15 = (android.widget.TextView) r15     // Catch:{ Exception -> 0x01b8 }
            int r11 = com.qumpara.lib_qumpara_ads.R$id.qumpara_number_3     // Catch:{ Exception -> 0x01b8 }
            android.view.View r11 = r12.findViewById(r11)     // Catch:{ Exception -> 0x01b8 }
            android.widget.TextView r11 = (android.widget.TextView) r11     // Catch:{ Exception -> 0x01b8 }
            int r3 = com.qumpara.lib_qumpara_ads.R$id.qumpara_number_4     // Catch:{ Exception -> 0x01b8 }
            android.view.View r3 = r12.findViewById(r3)     // Catch:{ Exception -> 0x01b8 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x01b8 }
            int r2 = com.qumpara.lib_qumpara_ads.R$id.qumpara_number_5     // Catch:{ Exception -> 0x01b8 }
            android.view.View r2 = r12.findViewById(r2)     // Catch:{ Exception -> 0x01b8 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x01b8 }
            r16 = r8
            r8 = 4
            r17 = r13
            java.lang.String r13 = r1.getColor(r8)     // Catch:{ Exception -> 0x00e6 }
            int r8 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallToolbarBackground     // Catch:{ Exception -> 0x00e6 }
            arrangeViewColorFromRemoteConfig(r0, r13, r8)     // Catch:{ Exception -> 0x00e6 }
            r0 = 4
            java.lang.String r8 = r1.getColor(r0)     // Catch:{ Exception -> 0x00e6 }
            int r13 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallToolbarBackground     // Catch:{ Exception -> 0x00e6 }
            arrangeViewColorFromRemoteConfig(r15, r8, r13)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = r1.getColor(r0)     // Catch:{ Exception -> 0x00e6 }
            int r13 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallToolbarBackground     // Catch:{ Exception -> 0x00e6 }
            arrangeViewColorFromRemoteConfig(r11, r8, r13)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = r1.getColor(r0)     // Catch:{ Exception -> 0x00e6 }
            int r11 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallToolbarBackground     // Catch:{ Exception -> 0x00e6 }
            arrangeViewColorFromRemoteConfig(r3, r8, r11)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r0 = r1.getColor(r0)     // Catch:{ Exception -> 0x00e6 }
            int r3 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallToolbarBackground     // Catch:{ Exception -> 0x00e6 }
            arrangeViewColorFromRemoteConfig(r2, r0, r3)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x01b8 }
        L_0x00ea:
            r0 = 3
            java.lang.String r0 = r1.getColor(r0)     // Catch:{ Exception -> 0x01b8 }
            if (r0 == 0) goto L_0x00f8
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ Exception -> 0x00f8 }
            r7.setTextColor(r0)     // Catch:{ Exception -> 0x00f8 }
        L_0x00f8:
            java.lang.String r0 = r19.getImage()     // Catch:{ Exception -> 0x01b8 }
            int r1 = com.qumpara.lib_qumpara_ads.R$drawable.uncomplete_img     // Catch:{ Exception -> 0x01b8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01b8 }
            r4.setImageUrl((java.lang.String) r0, (java.lang.Integer) r1)     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallItemPrize r0 = r19.getPrize()     // Catch:{ Exception -> 0x01b8 }
            if (r0 == 0) goto L_0x0125
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallItemPrize r0 = r19.getPrize()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r0 = r0.getImage()     // Catch:{ Exception -> 0x01b8 }
            r5.setImageUrl(r0)     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallItemPrize r0 = r19.getPrize()     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallItemPrize$PrizeAsset r0 = r0.getAsset()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r0 = r0.getValueAsFormatted()     // Catch:{ Exception -> 0x01b8 }
            r7.setText(r0)     // Catch:{ Exception -> 0x01b8 }
        L_0x0125:
            java.lang.Object r0 = r18.get()     // Catch:{ Exception -> 0x01b8 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x01b8 }
            int r1 = com.qumpara.lib_qumpara_ads.R$string.qumpara_offerwall_desc_line5     // Catch:{ Exception -> 0x01b8 }
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallItemPrize r3 = r19.getPrize()     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallItemPrize$PrizeAsset r3 = r3.getAsset()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01b8 }
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ Exception -> 0x01b8 }
            r6.setText(r0)     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r0 = r19.getConditionText()     // Catch:{ Exception -> 0x01b8 }
            r14.setText(r0)     // Catch:{ Exception -> 0x01b8 }
            int r0 = com.qumpara.lib_qumpara_ads.R$id.icon_close     // Catch:{ Exception -> 0x01b8 }
            android.view.View r0 = r12.findViewById(r0)     // Catch:{ Exception -> 0x01b8 }
            r4 = r0
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil$3 r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil$3     // Catch:{ Exception -> 0x01b8 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01b8 }
            r4.setOnClickListener(r0)     // Catch:{ Exception -> 0x01b8 }
            if (r10 == 0) goto L_0x0183
            com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil$4 r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil$4     // Catch:{ Exception -> 0x01b8 }
            r5 = r18
            r0.<init>(r9, r10, r12, r5)     // Catch:{ Exception -> 0x01b8 }
            r12.setOnDismissListener(r0)     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil$5 r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil$5     // Catch:{ Exception -> 0x01b8 }
            r1 = r0
            r2 = r12
            r3 = r17
            r5 = r18
            r6 = r16
            r7 = r20
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01b8 }
            r1 = r17
            r1.setOnClickListener(r0)     // Catch:{ Exception -> 0x01b8 }
            r10.onDialogShown(r12)     // Catch:{ Exception -> 0x01b8 }
        L_0x0183:
            r12.show()     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaImpressionManager r0 = com.qumpara.offerwall.sdk.core.QumparaImpressionManager.getInstance()     // Catch:{ Exception -> 0x01b8 }
            r1 = 2
            java.lang.String r2 = r19.getId()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r3 = r19.getCustomer()     // Catch:{ Exception -> 0x01b8 }
            r0.incrementCountData(r1, r2, r3)     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.analytics.QumparaAnalytics r4 = com.qumpara.analytics.QumparaAnalytics.getInstance()     // Catch:{ Exception -> 0x01b8 }
            android.content.Context r5 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getContext()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r6 = "ow_detail_open"
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getIdentifiers()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r7 = r0.getIdfa()     // Catch:{ Exception -> 0x01b8 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getIdentifiers()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r8 = r0.getApplicationId()     // Catch:{ Exception -> 0x01b8 }
            java.lang.String r9 = r19.getId()     // Catch:{ Exception -> 0x01b8 }
            r4.trackEvent(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x01b8 }
            return r12
        L_0x01b8:
            r0 = move-exception
            r0.printStackTrace()
            if (r10 == 0) goto L_0x01c1
            r20.onDialogShownError()
        L_0x01c1:
            r1 = 0
            return r1
        L_0x01c3:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.showCampaignDetailDialog(java.lang.ref.WeakReference, com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallItem, com.qumpara.offerwall.sdk.listener.QumparaOfferwallDialogListener, com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse):android.app.Dialog");
    }

    public static Dialog showWebViewDialog(WeakReference<Context> weakReference, String str) {
        try {
            if (weakReference.get() != null && isNetworkAvailable(QumparaOfferwall.getContext()) == 1) {
                if (!isNullOrEmpty(str)) {
                    final Dialog dialog = new Dialog((Context) weakReference.get(), 16973834);
                    dialog.setCancelable(true);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setContentView(R$layout.qumpara_offerwall_webview_dialog);
                    WebView webView = (WebView) dialog.findViewById(R$id.webView);
                    ((ImageView) dialog.findViewById(R$id.closeIcon)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    webView.getSettings().setJavaScriptEnabled(true);
                    dialog.show();
                    webView.loadUrl(str);
                    return dialog;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static double timeZone() {
        double rawOffset = (double) (TimeZone.getDefault().getRawOffset() + Calendar.getInstance().get(16));
        Double.isNaN(rawOffset);
        return rawOffset / 3600000.0d;
    }

    public static void toast(final String str) {
        QumparaOfferwall.runOnUIThread().post(new Runnable() {
            public void run() {
                Toast.makeText(QumparaOfferwall.getContext(), str, 0).show();
            }
        });
    }
}
