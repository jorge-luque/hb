package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostPreferences;
import admost.sdk.base.AdMostZoneType;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostBiddingException;
import android.os.AsyncTask;
import android.webkit.WebView;
import com.facebook.ads.BidderTokenProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostFacebookBiddingManager {
    private static AdMostFacebookBiddingManager instance;
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public String audienceNetworkIdentityToken;
    private String deviceUA;
    private String idfa;
    public boolean initCompleted;
    private String mediationPartnerPlatformId = "";
    private int numberOfWaitingRequest = 0;
    private final String ortbDataFormat = "{\"id\":\"%s\",\"imp\":[{\"id\":\"%s\",%s}],\"app\":{\"publisher\":{\"id\":\"%s\"}},\"device\":{\"ua\":\"%s\",\"ifa\":\"%s\"},\"regs\":{\"coppa\":%d},\"user\":{\"buyeruid\":\"%s\"},\"ext\":{\"platformid\":\"%s\"},\"at\":1,\"tmax\":1000,\"test\":%d}";
    private String publisherAppId;
    private final AtomicBoolean requestStarted = new AtomicBoolean();

    public static class AdMostFacebookAudinceIdTask extends AsyncTask<Void, Void, String> {
        private AdmostResponseListener<JSONObject> listener;

        AdMostFacebookAudinceIdTask(AdmostResponseListener<JSONObject> admostResponseListener) {
            this.listener = admostResponseListener;
        }

        private void clearGC() {
            this.listener = null;
        }

        /* access modifiers changed from: package-private */
        public void onError(String str, Exception exc) {
            AdmostResponseListener<JSONObject> admostResponseListener = this.listener;
            if (admostResponseListener != null) {
                admostResponseListener.onError(str, exc);
            }
            clearGC();
        }

        /* access modifiers changed from: package-private */
        public void onResponse(JSONObject jSONObject) {
            AdmostResponseListener<JSONObject> admostResponseListener = this.listener;
            if (admostResponseListener != null) {
                admostResponseListener.onResponse(jSONObject);
            }
            clearGC();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(Void... voidArr) {
            try {
                return BidderTokenProvider.getBidderToken(AdMost.getInstance().getContext());
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str != null) {
                try {
                    if (str.equals("")) {
                        str = "\"\"";
                    }
                    onResponse(new JSONObject(String.format("{\"bidderToken\":\"%s\"}", new Object[]{str})));
                } catch (Exception e) {
                    onError("", e);
                }
            }
        }
    }

    static class AdMostFacebookBiddingError {
        int code;
        String message;

        AdMostFacebookBiddingError() {
        }
    }

    public interface AdMostFacebookBiddingListener {
        void onFail(AdMostFacebookBiddingError adMostFacebookBiddingError);

        void onSuccess(AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid);
    }

    static class AdMostFacebookBiddingRequestResponse {
        String bidId;
        String currency;

        /* renamed from: id */
        String f256id;
        ArrayList<AdMostFacebookBid> seatBid;

        static class AdMostFacebookBid {
            String adm;

            /* renamed from: id */
            String f257id;
            String impId;
            String lUrl;
            String nUrl;
            double price;

            AdMostFacebookBid(JSONObject jSONObject) {
                this.f257id = jSONObject.optString("id");
                this.impId = jSONObject.optString("impid");
                this.price = jSONObject.optDouble("price");
                this.nUrl = jSONObject.optString("nurl");
                this.lUrl = jSONObject.optString("lurl");
                this.adm = jSONObject.optString("adm");
            }

            public void sendLossNotice(double d, int i) {
                AdMostFacebookBiddingManager.getInstance().sendLossNotice(this, this.impId, i, d);
            }

            public void sendWinNotice(double d) {
                AdMostFacebookBiddingManager.getInstance().sendWinNotice(this, d);
            }
        }

        AdMostFacebookBiddingRequestResponse(JSONObject jSONObject) {
            try {
                this.f256id = jSONObject.optString("id");
                this.bidId = jSONObject.optString("bidid");
                this.currency = jSONObject.optString("cur");
                this.seatBid = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray("seatbid");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("bid");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.seatBid.add(new AdMostFacebookBid(jSONArray2.getJSONObject(i2)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private AdMostFacebookBiddingManager() {
        String str = ((AdMostFacebookInitAdapter) AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.FACEBOOK)).applicationId;
        this.publisherAppId = (str == null || str.length() < 1) ? "" : str;
        this.mediationPartnerPlatformId = ((AdMostFacebookInitAdapter) AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.FACEBOOK)).platformId;
        try {
            this.deviceUA = new WebView(AdMost.getInstance().getContext()).getSettings().getUserAgentString();
        } catch (Exception e) {
            this.deviceUA = "";
            e.printStackTrace();
        }
        this.idfa = AdMostPreferences.getInstance().getAdvId();
        getAudienceNetworkIdentityToken();
        AdMostLog.m303w("FacebookBidding publisherAppId :" + this.publisherAppId);
    }

    static /* synthetic */ int access$210(AdMostFacebookBiddingManager adMostFacebookBiddingManager) {
        int i = adMostFacebookBiddingManager.numberOfWaitingRequest;
        adMostFacebookBiddingManager.numberOfWaitingRequest = i - 1;
        return i;
    }

    private void getAudienceNetworkIdentityToken() {
        new AdMostFacebookAudinceIdTask(new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                AdMostFacebookBiddingManager.this.initCompleted = true;
                exc.printStackTrace();
            }

            public void onResponse(JSONObject jSONObject) {
                try {
                    String optString = jSONObject.optString("bidderToken");
                    if (optString != null && !optString.equals("")) {
                        String unused = AdMostFacebookBiddingManager.this.audienceNetworkIdentityToken = optString;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AdMostFacebookBiddingManager.this.initCompleted = true;
            }
        }).execute(new Void[0]);
    }

    static AdMostFacebookBiddingManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostFacebookBiddingManager();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void logError(AdMostBiddingException adMostBiddingException, String str, String str2, String str3) {
        try {
            String optString = adMostBiddingException.response.optString("x-fb-an-errors");
            String optString2 = adMostBiddingException.response.optString("x-fb-debug");
            String optString3 = adMostBiddingException.response.optString("x-fb-an-request-id");
            AdMostLog.m303w("FacebookBiddingManager errorLog sent with x-fb-an-request-id : " + optString3);
            AdMostPreferences.getInstance().addFacebookBiddingLog(str, String.format(Locale.ENGLISH, "{\"platform\":\"android\",\"x-fb-an-errors\":\"%s\",\"x-fb-debug\":\"%s\",\"x-fb-an-request-id\":\"%s\",\"url\":\"%s\",\"body\":\"%s\"}", new Object[]{optString, optString2, optString3, str3, str2.replace("\"", "\\\"")}));
            sendLogsToServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String bid(AdMostBannerResponseItem adMostBannerResponseItem, AdMostFacebookBiddingListener adMostFacebookBiddingListener, boolean z) {
        AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
        AdMostFacebookBiddingListener adMostFacebookBiddingListener2 = adMostFacebookBiddingListener;
        String uuid = UUID.randomUUID().toString();
        boolean isUserChild = AdMost.getInstance().isUserChild();
        String str = null;
        if (adMostBannerResponseItem2.Type.equals("native")) {
            str = String.format("\"native\": {\"h\":-1,\"w\":-1},\"tagid\":\"%s\"", new Object[]{adMostBannerResponseItem2.AdSpaceId});
        } else if (!adMostBannerResponseItem2.ZoneType.equals(AdMostZoneType.FULLSCREEN)) {
            int i = adMostBannerResponseItem2.ZoneSize;
            if (i == 250) {
                str = String.format("\"banner\": {\"h\":250,\"w\":-1}, \"tagid\":\"%s\"", new Object[]{adMostBannerResponseItem2.AdSpaceId});
            } else if (i == 50) {
                str = String.format("\"banner\": {\"h\":50,\"w\":-1}, \"tagid\":\"%s\"", new Object[]{adMostBannerResponseItem2.AdSpaceId});
            }
        } else if (adMostBannerResponseItem2.Type.equals("banner")) {
            str = String.format("\"banner\": {\"h\":0,\"w\":0},\"tagid\":\"%s\", \"instl\":1", new Object[]{adMostBannerResponseItem2.AdSpaceId});
        } else if (adMostBannerResponseItem2.Type.equals("video")) {
            str = String.format("\"video\": {\"h\":0,\"w\":0,\"ext\":{\"videotype\":\"rewarded\"}},\"tagid\":\"%s\"", new Object[]{adMostBannerResponseItem2.AdSpaceId});
        }
        if (str == null) {
            AdMostFacebookBiddingError adMostFacebookBiddingError = new AdMostFacebookBiddingError();
            adMostFacebookBiddingError.message = "AdMostFacebookBiddingManager -- NOT SUPPORTED AD FORMAT";
            adMostFacebookBiddingListener2.onFail(adMostFacebookBiddingError);
            AdMostLog.m303w(adMostFacebookBiddingError.message);
            return uuid;
        } else if (this.audienceNetworkIdentityToken == null) {
            AdMostFacebookBiddingError adMostFacebookBiddingError2 = new AdMostFacebookBiddingError();
            adMostFacebookBiddingError2.message = "AdMostFacebookBiddingManager -- IDENTITY TOKEN NOT READY YET";
            adMostFacebookBiddingListener2.onFail(adMostFacebookBiddingError2);
            AdMostLog.m303w(adMostFacebookBiddingError2.message);
            return uuid;
        } else {
            String str2 = this.publisherAppId;
            if (str2 == null || str2.equals("")) {
                AdMostFacebookBiddingError adMostFacebookBiddingError3 = new AdMostFacebookBiddingError();
                adMostFacebookBiddingError3.message = "AdMostFacebookBiddingManager -- FACEBOOK ApplicationId is not configured properly";
                adMostFacebookBiddingListener2.onFail(adMostFacebookBiddingError3);
                AdMostLog.m303w(adMostFacebookBiddingError3.message);
                return uuid;
            }
            String str3 = this.mediationPartnerPlatformId;
            if (str3 == null || str3.equals("")) {
                AdMostFacebookBiddingError adMostFacebookBiddingError4 = new AdMostFacebookBiddingError();
                adMostFacebookBiddingError4.message = "AdMostFacebookBiddingManager -- FACEBOOK ApplicationId is not configured properly";
                adMostFacebookBiddingListener2.onFail(adMostFacebookBiddingError4);
                AdMostLog.m303w(adMostFacebookBiddingError4.message);
                return uuid;
            }
            String format = String.format(Locale.ENGLISH, "{\"id\":\"%s\",\"imp\":[{\"id\":\"%s\",%s}],\"app\":{\"publisher\":{\"id\":\"%s\"}},\"device\":{\"ua\":\"%s\",\"ifa\":\"%s\"},\"regs\":{\"coppa\":%d},\"user\":{\"buyeruid\":\"%s\"},\"ext\":{\"platformid\":\"%s\"},\"at\":1,\"tmax\":1000,\"test\":%d}", new Object[]{uuid, uuid, str, this.publisherAppId, this.deviceUA, this.idfa, Integer.valueOf(isUserChild ? 1 : 0), this.audienceNetworkIdentityToken, this.mediationPartnerPlatformId, Integer.valueOf(z ? 1 : 0)});
            String format2 = String.format("https://an.facebook.com/%s/placementbid.ortb", new Object[]{this.publisherAppId});
            AdMostGenericRequest.RequestType requestType = AdMostGenericRequest.RequestType.BIDDING_REQUEST;
            final String str4 = uuid;
            final AdMostFacebookBiddingListener adMostFacebookBiddingListener3 = adMostFacebookBiddingListener;
            final String str5 = format;
            C03062 r10 = r0;
            final String str6 = format2;
            C03062 r0 = new AdmostResponseListener<JSONObject>() {
                public void onError(String str, Exception exc) {
                    AdMostFacebookBiddingError adMostFacebookBiddingError = new AdMostFacebookBiddingError();
                    adMostFacebookBiddingError.message = str;
                    if (exc instanceof AdMostBiddingException) {
                        AdMostBiddingException adMostBiddingException = (AdMostBiddingException) exc;
                        int i = adMostBiddingException.serverResponseCode;
                        adMostFacebookBiddingError.code = i;
                        if (i == 400) {
                            adMostFacebookBiddingError.message = "INVALID_BID " + adMostBiddingException.response.optString("x-fb-an-errors") + " INVALID_BID_ADVICE";
                        } else if (i == 204) {
                            adMostFacebookBiddingError.message = "NO_BID " + adMostBiddingException.response.optString("x-fb-an-errors");
                        } else {
                            adMostFacebookBiddingError.message = "UNEXPECTED_ERROR";
                        }
                        AdMostFacebookBiddingManager.this.logError(adMostBiddingException, str4, str5, str6);
                    } else {
                        adMostFacebookBiddingError.code = -1;
                    }
                    adMostFacebookBiddingListener3.onFail(adMostFacebookBiddingError);
                }

                public void onResponse(JSONObject jSONObject) {
                    AdMostFacebookBiddingRequestResponse adMostFacebookBiddingRequestResponse = new AdMostFacebookBiddingRequestResponse(jSONObject);
                    for (int i = 0; i < adMostFacebookBiddingRequestResponse.seatBid.size(); i++) {
                        AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid = adMostFacebookBiddingRequestResponse.seatBid.get(i);
                        if (adMostFacebookBid.impId.equals(str4)) {
                            adMostFacebookBiddingListener3.onSuccess(adMostFacebookBid);
                            return;
                        }
                    }
                }
            };
            new AdMostGenericRequest(requestType, format2, r10).mo611go(AdMostAdNetwork.FACEBOOK, format, this.audienceNetworkIdentityToken);
            return uuid;
        }
    }

    /* access modifiers changed from: package-private */
    public void sendLogsToServer() {
        JSONObject facebookBiddingLog;
        if (this.requestStarted.compareAndSet(false, true)) {
            if (this.numberOfWaitingRequest <= 0 && (facebookBiddingLog = AdMostPreferences.getInstance().getFacebookBiddingLog()) != null && facebookBiddingLog.length() > 0) {
                Iterator<String> keys = facebookBiddingLog.keys();
                while (keys.hasNext()) {
                    final String next = keys.next();
                    String optString = facebookBiddingLog.optString(next);
                    this.numberOfWaitingRequest++;
                    new AdMostGenericRequest(AdMostGenericRequest.RequestType.BIDDING_DEBUG_DATA, "", new AdmostResponseListener<JSONObject>() {
                        public void onError(String str, Exception exc) {
                            AdMostFacebookBiddingManager.access$210(AdMostFacebookBiddingManager.this);
                        }

                        public void onResponse(JSONObject jSONObject) {
                            AdMostPreferences.getInstance().removeFacebookBiddingLog(next);
                            AdMostFacebookBiddingManager.access$210(AdMostFacebookBiddingManager.this);
                        }
                    }).mo611go(optString);
                }
            }
            this.requestStarted.set(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void sendLossNotice(AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid, String str, int i, double d) {
        String str2;
        if (adMostFacebookBid == null) {
            str2 = "https://www.facebook.com/audiencenetwork/nurl/?partner=${PARTNER_FBID}&app=${APP_FBID}&auction=${AUCTION_ID}&ortb_loss_code=2".replace("${PARTNER_FBID}", this.publisherAppId).replace("${APP_FBID}", this.publisherAppId).replace("${AUCTION_ID}", str);
        } else {
            str2 = adMostFacebookBid.lUrl.replace("${AUCTION_PRICE}", String.format(Locale.ENGLISH, "%f", new Object[]{Double.valueOf(d)})).replace("${AUCTION_LOSS}", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i)}));
        }
        AdMostLog.m296e("sendLossNotice : " + str2 + " - " + str + " - " + i + " - " + d);
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.BIDDING_WIN_LOSS_REQUEST, str2, new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                AdMostLog.m303w("Facebook sendLossNotice onSuccess : " + exc.getMessage());
            }

            public void onResponse(JSONObject jSONObject) {
                AdMostLog.m299i("Facebook sendLossNotice onSuccess : " + jSONObject.toString());
            }
        }).mo611go("", this.audienceNetworkIdentityToken);
    }

    /* access modifiers changed from: package-private */
    public void sendWinNotice(AdMostFacebookBiddingRequestResponse.AdMostFacebookBid adMostFacebookBid, double d) {
        String replace = adMostFacebookBid.nUrl.replace("${AUCTION_PRICE}", String.format(Locale.ENGLISH, "%f", new Object[]{Double.valueOf(d)}));
        AdMostLog.m296e("sendWinNotice : " + replace);
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.BIDDING_WIN_LOSS_REQUEST, replace, new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                AdMostLog.m303w("Facebook sendWinNotice onSuccess : " + exc.getMessage());
            }

            public void onResponse(JSONObject jSONObject) {
                AdMostLog.m299i("Facebook sendWinNotice onSuccess : " + jSONObject.toString());
            }
        }).mo611go("", this.audienceNetworkIdentityToken);
    }
}
