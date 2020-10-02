package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostPreferences;
import admost.sdk.base.AdMostUtil;
import admost.sdk.base.AdMostZoneType;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostBiddingException;
import android.os.Build;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostAdcolonyBiddingManager {
    private static AdMostAdcolonyBiddingManager instance;
    private static final Object lock = new Object();
    private String SSPId;
    private String adcApplicationId;
    private String appBundle;
    private String appName;
    private String appPublisherId;
    private String appStoreUrl;
    private int connectionType = 0;
    private String deviceCarrier;
    private int deviceHeight;
    private String deviceMake;
    private String deviceModel;
    private String deviceOSV;
    private int deviceType;
    private String deviceUA;
    private int deviceWidth;
    private String exchangeSpecificAppId;
    private String idfa;
    private String ipAddress;
    private String language;
    private final String ortbDataFormat = "{\"id\":\"%s\",\"imp\":[{\"id\":\"%s\",%s,\"secure\":0,\"ext\":{\"adc_zone_id\":\"%s\",\"adc_app_id\":\"%s\"}}],\"app\":{\"id\":\"%s\",\"name\":\"%s\",\"bundle\":\"%s\",\"cat\":[],\"publisher\":{\"id\":\"%s\"},\"storeurl\":\"%s\"},\"device\":{\"ua\":\"%s\",\"ip\":\"%s\",\"ifa\":\"%s\",\"carrier\":\"%s\",\"make\":\"%s\",\"model\":\"%s\",\"os\":\"android\",\"osv\":\"%s\",\"w\":%d,\"h\":%d,\"language\":\"%s\",\"devicetype\":%d,\"connectiontype\":%d},\"regs\":{\"coppa\":%d},\"user\":{\"gender\":\"\"},\"at\":1,\"tmax\":1000,\"test\":%d}";

    static class AdMostAdcolonyBiddingError {
        int code;
        String message;

        AdMostAdcolonyBiddingError() {
        }
    }

    public interface AdMostAdcolonyBiddingListener {
        void onFail(AdMostAdcolonyBiddingError adMostAdcolonyBiddingError);

        void onSuccess(AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid);
    }

    static class AdMostAdcolonyBiddingRequestResponse {
        String bidId;
        String currency;

        /* renamed from: id */
        String f254id;
        ArrayList<AdMostAdcolonyBid> seatBid;

        static class AdMostAdcolonyBid {
            String adm;
            String bidId;
            String currency;

            /* renamed from: id */
            String f255id;
            String impId;
            String lUrl;
            String nUrl;
            double price;
            String seatId;

            AdMostAdcolonyBid(JSONObject jSONObject, String str, String str2, String str3) {
                this.f255id = jSONObject.optString("id");
                this.impId = jSONObject.optString("impid");
                this.price = jSONObject.optDouble("price");
                this.nUrl = jSONObject.optString("nurl");
                this.lUrl = jSONObject.optString("lurl");
                this.adm = jSONObject.optString("adm");
                this.currency = str3;
                this.seatId = str;
                this.bidId = str2;
            }

            public void sendLossNotice(double d, int i) {
                AdMostAdcolonyBiddingManager.getInstance().sendLossNotice(this, this.impId, i, d);
            }

            public void sendWinNotice(double d) {
                AdMostAdcolonyBiddingManager.getInstance().sendWinNotice(this, d);
            }
        }

        AdMostAdcolonyBiddingRequestResponse(JSONObject jSONObject) {
            try {
                this.f254id = jSONObject.optString("id");
                this.bidId = jSONObject.optString("bidid");
                this.currency = jSONObject.optString("cur");
                this.seatBid = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray("seatbid");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("bid");
                    String optString = jSONArray.getJSONObject(i).optString("seat");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.seatBid.add(new AdMostAdcolonyBid(jSONArray2.getJSONObject(i2), optString, this.bidId, this.currency));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private AdMostAdcolonyBiddingManager() {
        String str = "";
        AdMostAdcolonyInitAdapter adMostAdcolonyInitAdapter = (AdMostAdcolonyInitAdapter) AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADCOLONY);
        this.SSPId = adMostAdcolonyInitAdapter.SSPId;
        this.adcApplicationId = adMostAdcolonyInitAdapter.applicationId;
        this.appName = adMostAdcolonyInitAdapter.applicationName;
        this.appPublisherId = adMostAdcolonyInitAdapter.applicationPublisherId;
        this.exchangeSpecificAppId = adMostAdcolonyInitAdapter.exchangeSpecificAppId;
        this.appStoreUrl = adMostAdcolonyInitAdapter.appStoreUrl;
        try {
            this.deviceUA = new WebView(AdMost.getInstance().getContext()).getSettings().getUserAgentString();
        } catch (Exception e) {
            this.deviceUA = str;
            e.printStackTrace();
        }
        try {
            this.deviceMake = Build.BRAND.toLowerCase(Locale.ENGLISH);
            this.deviceModel = Build.MODEL.toLowerCase(Locale.ENGLISH);
            this.deviceOSV = Build.VERSION.SDK_INT + str;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            AdMost.getInstance().getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.deviceHeight = displayMetrics.heightPixels;
            this.deviceWidth = displayMetrics.widthPixels;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.idfa = AdMostPreferences.getInstance().getAdvId();
        this.language = Locale.getDefault().getLanguage();
        this.appBundle = AdMost.getInstance().getContext().getPackageName();
        this.deviceCarrier = AdMostUtil.networkOperatorName(AdMost.getInstance().getContext());
        if (AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA() && AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR()) {
            str = AdMostUtil.getIPAddress(true);
        }
        this.ipAddress = str;
        this.deviceType = AdMostUtil.isTabletDevice(AdMost.getInstance().getActivity()) ? 5 : 4;
        try {
            String networkClass = AdMostUtil.getNetworkClass(AdMost.getInstance().getContext());
            if (networkClass == null) {
                return;
            }
            if (networkClass.contains(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)) {
                this.connectionType = 2;
            } else if (networkClass.contains("2G")) {
                this.connectionType = 4;
            } else if (networkClass.contains("3G")) {
                this.connectionType = 5;
            } else if (networkClass.contains("4G")) {
                this.connectionType = 6;
            } else if (networkClass.contains("gsm")) {
                this.connectionType = 3;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    static AdMostAdcolonyBiddingManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostAdcolonyBiddingManager();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: package-private */
    public String bid(AdMostBannerResponseItem adMostBannerResponseItem, final AdMostAdcolonyBiddingListener adMostAdcolonyBiddingListener, boolean z) {
        final String uuid = UUID.randomUUID().toString();
        boolean isUserChild = AdMost.getInstance().isUserChild();
        String str = adMostBannerResponseItem.AdSpaceId;
        String str2 = null;
        if (adMostBannerResponseItem.ZoneType.equals(AdMostZoneType.FULLSCREEN)) {
            str2 = "\"video\": {\"mimes\":[]}";
        } else {
            int i = adMostBannerResponseItem.ZoneSize;
            if (i == 250) {
                str2 = "\"banner\": {\"h\":250,\"w\":300,\"mimes\":[]}";
            } else if (i == 50) {
                str2 = "\"banner\": {\"h\":50,\"w\":320,\"mimes\":[]}";
            }
        }
        String str3 = this.SSPId;
        if (str3 == null || str3.equals("")) {
            AdMostAdcolonyBiddingError adMostAdcolonyBiddingError = new AdMostAdcolonyBiddingError();
            adMostAdcolonyBiddingError.message = "AdMostAdcolonyBiddingManager -- ADCOLONY SSPId is not configured properly";
            adMostAdcolonyBiddingListener.onFail(adMostAdcolonyBiddingError);
            AdMostLog.m303w(adMostAdcolonyBiddingError.message);
            return uuid;
        } else if (str2 == null) {
            AdMostAdcolonyBiddingError adMostAdcolonyBiddingError2 = new AdMostAdcolonyBiddingError();
            adMostAdcolonyBiddingError2.message = "AdMostAdcolonyBiddingManager -- NOT SUPPORTED AD FORMAT";
            adMostAdcolonyBiddingListener.onFail(adMostAdcolonyBiddingError2);
            AdMostLog.m303w(adMostAdcolonyBiddingError2.message);
            return uuid;
        } else {
            String str4 = this.ipAddress;
            if (str4 == null || str4.equals("")) {
                AdMostAdcolonyBiddingError adMostAdcolonyBiddingError3 = new AdMostAdcolonyBiddingError();
                adMostAdcolonyBiddingError3.message = "AdMostAdcolonyBiddingManager -- Ip Address can not be null";
                adMostAdcolonyBiddingListener.onFail(adMostAdcolonyBiddingError3);
                AdMostLog.m303w(adMostAdcolonyBiddingError3.message);
                return uuid;
            }
            String format = String.format(Locale.ENGLISH, "{\"id\":\"%s\",\"imp\":[{\"id\":\"%s\",%s,\"secure\":0,\"ext\":{\"adc_zone_id\":\"%s\",\"adc_app_id\":\"%s\"}}],\"app\":{\"id\":\"%s\",\"name\":\"%s\",\"bundle\":\"%s\",\"cat\":[],\"publisher\":{\"id\":\"%s\"},\"storeurl\":\"%s\"},\"device\":{\"ua\":\"%s\",\"ip\":\"%s\",\"ifa\":\"%s\",\"carrier\":\"%s\",\"make\":\"%s\",\"model\":\"%s\",\"os\":\"android\",\"osv\":\"%s\",\"w\":%d,\"h\":%d,\"language\":\"%s\",\"devicetype\":%d,\"connectiontype\":%d},\"regs\":{\"coppa\":%d},\"user\":{\"gender\":\"\"},\"at\":1,\"tmax\":1000,\"test\":%d}", new Object[]{uuid, uuid, str2, str, this.adcApplicationId, this.exchangeSpecificAppId, this.appName, this.appBundle, this.appPublisherId, this.appStoreUrl, this.deviceUA, this.ipAddress, this.idfa, this.deviceCarrier, this.deviceMake, this.deviceModel, this.deviceOSV, Integer.valueOf(this.deviceWidth), Integer.valueOf(this.deviceHeight), this.language, Integer.valueOf(this.deviceType), Integer.valueOf(this.connectionType), Integer.valueOf(isUserChild ? 1 : 0), Integer.valueOf(z ? 1 : 0)});
            new AdMostGenericRequest(AdMostGenericRequest.RequestType.BIDDING_REQUEST, String.format("https://rtb.adcolony.com/bid_request?ssp_id=%s", new Object[]{this.SSPId}), new AdmostResponseListener<JSONObject>() {
                public void onError(String str, Exception exc) {
                    AdMostAdcolonyBiddingError adMostAdcolonyBiddingError = new AdMostAdcolonyBiddingError();
                    adMostAdcolonyBiddingError.message = str;
                    if (exc instanceof AdMostBiddingException) {
                        AdMostBiddingException adMostBiddingException = (AdMostBiddingException) exc;
                        int i = adMostBiddingException.serverResponseCode;
                        adMostAdcolonyBiddingError.code = i;
                        if (i == 400) {
                            adMostAdcolonyBiddingError.message = "INVALID_BID Adcolony INVALID_BID_ADVICE - requestId : " + adMostBiddingException.response.optString("x-adc-requestid");
                        } else if (i == 204) {
                            adMostAdcolonyBiddingError.message = "NO_BID Adcolony - requestId : " + adMostBiddingException.response.optString("x-adc-requestid");
                        } else {
                            adMostAdcolonyBiddingError.message = "UNEXPECTED_ERROR requestId : " + adMostBiddingException.response.optString("x-adc-requestid");
                        }
                    } else {
                        adMostAdcolonyBiddingError.code = -1;
                    }
                    adMostAdcolonyBiddingListener.onFail(adMostAdcolonyBiddingError);
                }

                public void onResponse(JSONObject jSONObject) {
                    AdMostAdcolonyBiddingRequestResponse adMostAdcolonyBiddingRequestResponse = new AdMostAdcolonyBiddingRequestResponse(jSONObject);
                    if (adMostAdcolonyBiddingRequestResponse.seatBid.size() <= 0) {
                        AdMostAdcolonyBiddingError adMostAdcolonyBiddingError = new AdMostAdcolonyBiddingError();
                        adMostAdcolonyBiddingError.code = -1;
                        adMostAdcolonyBiddingError.message = "NO_BID Adcolony - requestId : " + uuid;
                        adMostAdcolonyBiddingListener.onFail(adMostAdcolonyBiddingError);
                        return;
                    }
                    for (int i = 0; i < adMostAdcolonyBiddingRequestResponse.seatBid.size(); i++) {
                        AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid = adMostAdcolonyBiddingRequestResponse.seatBid.get(i);
                        if (adMostAdcolonyBid.impId.equals(uuid)) {
                            adMostAdcolonyBiddingListener.onSuccess(adMostAdcolonyBid);
                            return;
                        }
                    }
                }
            }).mo611go(AdMostAdNetwork.ADCOLONY, format);
            return uuid;
        }
    }

    /* access modifiers changed from: package-private */
    public void sendLossNotice(AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid, String str, int i, double d) {
        if (adMostAdcolonyBid != null) {
            String replace = adMostAdcolonyBid.lUrl.replace("${AUCTION_PRICE}", String.format(Locale.ENGLISH, "%f", new Object[]{Double.valueOf(d)})).replace("${AUCTION_LOSS}", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i)})).replace("${AUCTION_ID}", String.format(Locale.ENGLISH, "%s", new Object[]{str})).replace("${AUCTION_IMP_ID}", String.format(Locale.ENGLISH, "%s", new Object[]{str})).replace("${AUCTION_BID_ID}", String.format(Locale.ENGLISH, "%s", new Object[]{adMostAdcolonyBid.bidId})).replace("${AUCTION_SEAT_ID}", String.format(Locale.ENGLISH, "%s", new Object[]{adMostAdcolonyBid.seatId})).replace("${AUCTION_CURRENCY}", String.format(Locale.ENGLISH, "%s", new Object[]{adMostAdcolonyBid.currency}));
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            double d2 = adMostAdcolonyBid.price;
            if (d2 == 0.0d) {
                d2 = 1.0d;
            }
            objArr[0] = Double.valueOf(d / d2);
            String replace2 = replace.replace("${AUCTION_MBR}", String.format(locale, "%f", objArr)).replace("${AUCTION_AD_ID}", String.format(Locale.ENGLISH, "%s", new Object[]{""}));
            AdMostLog.m299i("sendLossNotice : " + replace2);
            new AdMostGenericRequest(AdMostGenericRequest.RequestType.BIDDING_WIN_LOSS_REQUEST, replace2, new AdmostResponseListener<JSONObject>() {
                public void onError(String str, Exception exc) {
                    AdMostLog.m303w("Adcolony sendLossNotice onError : " + exc.getMessage());
                }

                public void onResponse(JSONObject jSONObject) {
                    AdMostLog.m299i("Adcolony sendLossNotice onSuccess : " + jSONObject.toString());
                }
            }).mo611go("");
        }
    }

    /* access modifiers changed from: package-private */
    public void sendWinNotice(AdMostAdcolonyBiddingRequestResponse.AdMostAdcolonyBid adMostAdcolonyBid, double d) {
        String replace = adMostAdcolonyBid.nUrl.replace("${AUCTION_PRICE}", String.format(Locale.ENGLISH, "%f", new Object[]{Double.valueOf(d)}));
        AdMostLog.m299i("sendWinNotice : " + replace);
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.BIDDING_WIN_LOSS_REQUEST, replace, new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                AdMostLog.m303w("Adcolony sendWinNotice onError : " + exc.getMessage());
            }

            public void onResponse(JSONObject jSONObject) {
                AdMostLog.m299i("Adcolony sendWinNotice onSuccess : " + jSONObject.toString());
            }
        }).mo611go("");
    }
}
