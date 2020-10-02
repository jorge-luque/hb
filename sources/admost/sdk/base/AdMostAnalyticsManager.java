package admost.sdk.base;

import admost.sdk.C0164R;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostInAppPurchaseItem;
import admost.sdk.model.AdMostServerException;
import admost.sdk.networkadapter.AdMostAdjustAdapter;
import admost.sdk.networkadapter.AdMostAppsFlyerAdapter;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import com.loopj.android.http.C4250c;
import com.tapjoy.TapjoyAuctionFlags;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMostAnalyticsManager {
    static final int MAX_SESSION_STRING_COUNT = 30;
    static final int MAX_SESSION_STRING_LENGTH = 10000;
    private static AdMostAnalyticsManager instance;
    private static final Object lock = new Object();
    private AdMostAnalyticsSessionPiece activeSessionPiece;
    private Object adjustAdapter;
    private boolean analyticsDisabled;
    private Object appsflyerAdapter;
    private boolean cumulatingSessionPieces;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
    private boolean deleteRunOnce;
    private long deltaTime = 0;
    private long firstSessionStartedAt = -1;
    private boolean isNewUser;
    private long latestSendDate = 0;
    private long latestSentSessionStopTime = 0;
    /* access modifiers changed from: private */
    public final Vector<Boolean> stateChanges = new Vector<>();
    private long tempLatestSentSessionStopTime = 0;
    /* access modifiers changed from: private */
    public boolean updateRequestStarted;
    private boolean updateRequired = false;
    private String userId = "";

    private AdMostAnalyticsManager() {
        this.dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.analyticsDisabled = AdMostPreferences.getInstance().isAnalyticsDisabled();
        this.deltaTime = AdMostPreferences.getInstance().getDeltaTime();
        this.firstSessionStartedAt = AdMostPreferences.getInstance().getFirstSessionStartedAt();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setName("AdMostAnalyticsThread");
                Process.setThreadPriority(10);
                while (true) {
                    if (AdMostAnalyticsManager.this.stateChanges.size() > 0) {
                        AdMostAnalyticsManager adMostAnalyticsManager = AdMostAnalyticsManager.this;
                        adMostAnalyticsManager.setSessionDataThread(((Boolean) adMostAnalyticsManager.stateChanges.get(0)).booleanValue());
                        AdMostAnalyticsManager.this.stateChanges.remove(0);
                    } else {
                        try {
                            synchronized (AdMostAnalyticsManager.this.stateChanges) {
                                AdMostAnalyticsManager.this.stateChanges.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread.setName("AdmostAnayticsKeepSessionData");
        thread.start();
    }

    private void convertCurrentSessionPieces() {
        JSONArray sessionPieces = AdMostPreferences.getInstance().getSessionPieces();
        if (sessionPieces != null && sessionPieces.length() > 0) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sessionPieces.length(); i++) {
                    sb.append(new AdMostAnalyticsSessionPiece((JSONObject) sessionPieces.get(i)).toString2nd());
                    sb.append("*");
                }
                if (sb.length() > 1) {
                    AdMostPreferences.getInstance().replaceSessionPieces2nd(sb.substring(0, sb.length() - 1), 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AdMostPreferences.getInstance().setSessionPieceConversionDone();
    }

    private String getAdjustUserId() {
        if (AdMost.getInstance().isInitStarted()) {
            return AdMostPreferences.getInstance().getAdjustUserId();
        }
        AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
        return "";
    }

    private String getAppsflyerUserId() {
        if (AdMost.getInstance().isInitStarted()) {
            return AdMostPreferences.getInstance().getAppsflyerUserId();
        }
        AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
        return "";
    }

    public static AdMostAnalyticsManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostAnalyticsManager();
                }
            }
        }
        return instance;
    }

    private long getLocalTime() {
        return System.currentTimeMillis();
    }

    protected static String getRandomExtention() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int nextInt = random.nextInt(36);
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".substring(nextInt, nextInt + 1));
        }
        return sb.toString();
    }

    private long getServerTime(long j) {
        return j - (this.deltaTime * 1000);
    }

    private String[] getUserUpdateData(boolean z) {
        String str;
        String str2;
        int i;
        String str3;
        try {
            i = AdMost.getInstance().getContext().getPackageManager().getPackageInfo(AdMost.getInstance().getContext().getPackageName(), 0).versionCode;
            try {
                str2 = URLEncoder.encode(Build.BRAND.toLowerCase(Locale.ENGLISH), C4250c.DEFAULT_CHARSET);
                try {
                    str = URLEncoder.encode(Build.MODEL.toLowerCase(Locale.ENGLISH), C4250c.DEFAULT_CHARSET);
                } catch (Exception e) {
                    e = e;
                    str = "";
                    e.printStackTrace();
                    str3 = "";
                    Locale locale = Locale.ENGLISH;
                    String format = String.format(locale, "\"CampaignId\":\"%s\",\"EI\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(true), AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()});
                    Locale locale2 = Locale.ENGLISH;
                    return new String[]{format, String.format(locale2, "\"CampaignId\":\"%s\",\"IDFA\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(false), AdMostPreferences.getInstance().getAdvId(), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()})};
                }
                try {
                    str3 = AdMost.getInstance().getContext().getResources().getBoolean(C0164R.bool.isTablet) ? "tablet" : PlaceFields.PHONE;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    str3 = "";
                    Locale locale3 = Locale.ENGLISH;
                    String format2 = String.format(locale3, "\"CampaignId\":\"%s\",\"EI\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(true), AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()});
                    Locale locale22 = Locale.ENGLISH;
                    return new String[]{format2, String.format(locale22, "\"CampaignId\":\"%s\",\"IDFA\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(false), AdMostPreferences.getInstance().getAdvId(), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()})};
                }
            } catch (Exception e3) {
                e = e3;
                str2 = "";
                str = str2;
                e.printStackTrace();
                str3 = "";
                Locale locale32 = Locale.ENGLISH;
                String format22 = String.format(locale32, "\"CampaignId\":\"%s\",\"EI\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(true), AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()});
                Locale locale222 = Locale.ENGLISH;
                return new String[]{format22, String.format(locale222, "\"CampaignId\":\"%s\",\"IDFA\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(false), AdMostPreferences.getInstance().getAdvId(), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()})};
            }
        } catch (Exception e4) {
            e = e4;
            str2 = "";
            str = str2;
            i = 0;
            e.printStackTrace();
            str3 = "";
            Locale locale322 = Locale.ENGLISH;
            String format222 = String.format(locale322, "\"CampaignId\":\"%s\",\"EI\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(true), AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()});
            Locale locale2222 = Locale.ENGLISH;
            return new String[]{format222, String.format(locale2222, "\"CampaignId\":\"%s\",\"IDFA\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(false), AdMostPreferences.getInstance().getAdvId(), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()})};
        }
        Locale locale3222 = Locale.ENGLISH;
        String format2222 = String.format(locale3222, "\"CampaignId\":\"%s\",\"EI\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(true), AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()});
        Locale locale22222 = Locale.ENGLISH;
        return new String[]{format2222, String.format(locale22222, "\"CampaignId\":\"%s\",\"IDFA\":\"%s\",\"AppVersion\":\"%s\",\"AppUserId\":\"%s\",\"AdjustUserId\":\"%s\",\"AppsflyerUserId\":\"%s\",\"SDKVersion\":\"%s\",\"OSVersion\":\"%s\",\"Device\":{\"Brand\":\"%s\", \"Model\":\"%s\", \"Type\":\"%s\"}, \"Consent\":\"%s\"", new Object[]{AdMostPreferences.getInstance().getCampaignId(false), AdMostPreferences.getInstance().getAdvId(), i + "", AdMostPreferences.getInstance().getApplicationUserId(), AdMostPreferences.getInstance().getAdjustUserId(), AdMostPreferences.getInstance().getAppsflyerUserId(), AdMost.getInstance().getVersion(), Build.VERSION.SDK_INT + "", str2, str, str3, AdMost.getInstance().getConfiguration().getUserConsentDescription()})};
    }

    private void keepAnalyticsSessionData(AdMostAnalyticsSessionPiece adMostAnalyticsSessionPiece) {
        int i;
        String str;
        if (!AdMostPreferences.getInstance().isSessionPieceConversionDone()) {
            convertCurrentSessionPieces();
        }
        AdMostPreferences.getInstance().addSessionPiece2nd(adMostAnalyticsSessionPiece);
        if (!this.deleteRunOnce) {
            long j = 0;
            if (this.latestSendDate > 0 && !this.cumulatingSessionPieces) {
                char c = 1;
                String[] sessionPieces2nd = AdMostPreferences.getInstance().getSessionPieces2nd(1);
                StringBuilder sb = new StringBuilder();
                int i2 = 1;
                int i3 = 1;
                while (sessionPieces2nd != null && sessionPieces2nd.length > 0 && sessionPieces2nd[0].length() > 0 && i2 <= 30) {
                    int i4 = 0;
                    while (i4 < sessionPieces2nd.length) {
                        try {
                            long parseLong = Long.parseLong(sessionPieces2nd[i4].split(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR)[c]);
                            String format = this.dateFormat.format(Long.valueOf(getServerTime(parseLong)));
                            if (this.latestSendDate != j) {
                                if (this.latestSendDate > this.dateFormat.parse(format).getTime()) {
                                    i4++;
                                    c = 1;
                                    j = 0;
                                }
                            }
                            long parseLong2 = Long.parseLong(sessionPieces2nd[i4].split(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR)[0]);
                            if (sb.length() <= 0) {
                                str = "";
                            } else {
                                str = "*";
                            }
                            sb.append(str);
                            sb.append(parseLong2);
                            sb.append(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR);
                            sb.append(parseLong);
                            if (sb.length() > 10000 && i3 <= 30) {
                                AdMostPreferences.getInstance().replaceSessionPieces2nd(sb.toString(), i3);
                                i3++;
                                sb = new StringBuilder();
                            }
                            i4++;
                            c = 1;
                            j = 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    i2++;
                    sessionPieces2nd = AdMostPreferences.getInstance().getSessionPieces2nd(i2);
                    c = 1;
                    j = 0;
                }
                if (sb.length() > 0) {
                    i = 30;
                    if (i3 <= 30) {
                        AdMostPreferences.getInstance().replaceSessionPieces2nd(sb.toString(), i3);
                    }
                } else {
                    i = 30;
                }
                AdMostPreferences.getInstance().setSessionPieceCurrentIndex(i3);
                for (int i5 = i3 + 1; i5 <= i; i5++) {
                    AdMostPreferences.getInstance().replaceSessionPieces2nd("", i5);
                }
                this.deleteRunOnce = true;
            }
        }
    }

    private void setAdjustUserId(String str) {
        if (!AdMost.getInstance().isInitStarted()) {
            AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
        } else if (str != null && !str.equals(getAdjustUserId())) {
            AdMostPreferences.getInstance().setAdjustUserId(str);
            update();
        }
    }

    private void setAppsflyerUserId(String str) {
        if (!AdMost.getInstance().isInitStarted()) {
            AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
        } else if (str != null && !str.equals(getAppsflyerUserId())) {
            AdMostPreferences.getInstance().setAppsflyerUserId(str);
            update();
        }
    }

    /* access modifiers changed from: private */
    public void setSessionDataThread(boolean z) {
        if (!this.analyticsDisabled) {
            if (this.firstSessionStartedAt < 0) {
                this.firstSessionStartedAt = System.currentTimeMillis();
                AdMostPreferences.getInstance().setFirstSessionStartedAt(this.firstSessionStartedAt);
            }
            if (this.activeSessionPiece == null) {
                this.activeSessionPiece = new AdMostAnalyticsSessionPiece();
            }
            long localTime = getLocalTime();
            if (z) {
                this.activeSessionPiece.StartTime = localTime;
                return;
            }
            AdMostAnalyticsSessionPiece adMostAnalyticsSessionPiece = this.activeSessionPiece;
            if (adMostAnalyticsSessionPiece.StartTime == 0) {
                adMostAnalyticsSessionPiece.StartTime = localTime - 1000;
            }
            AdMostAnalyticsSessionPiece adMostAnalyticsSessionPiece2 = this.activeSessionPiece;
            adMostAnalyticsSessionPiece2.StopTime = localTime;
            keepAnalyticsSessionData(adMostAnalyticsSessionPiece2);
            this.activeSessionPiece = new AdMostAnalyticsSessionPiece();
        }
    }

    /* access modifiers changed from: private */
    public void setUserId(String str) {
        this.userId = str;
        AdMostPreferences.getInstance().setUserId(str);
    }

    /* access modifiers changed from: package-private */
    public ConcurrentHashMap<String, AdMostAnalyticsSession> cumulateSessionPieces() {
        this.cumulatingSessionPieces = true;
        String[] sessionPieces2nd = AdMostPreferences.getInstance().getSessionPieces2nd(1);
        ConcurrentHashMap<String, AdMostAnalyticsSession> concurrentHashMap = new ConcurrentHashMap<>();
        int i = 1;
        while (sessionPieces2nd != null) {
            try {
                if (sessionPieces2nd.length <= 0 || sessionPieces2nd[0].length() <= 0) {
                    break;
                }
                for (String adMostAnalyticsSessionPiece : sessionPieces2nd) {
                    AdMostAnalyticsSessionPiece adMostAnalyticsSessionPiece2 = new AdMostAnalyticsSessionPiece(adMostAnalyticsSessionPiece);
                    long j = adMostAnalyticsSessionPiece2.StopTime == 0 ? adMostAnalyticsSessionPiece2.StartTime : adMostAnalyticsSessionPiece2.StopTime;
                    adMostAnalyticsSessionPiece2.StopTime = j;
                    adMostAnalyticsSessionPiece2.StartTime = getInstance().getServerTime(adMostAnalyticsSessionPiece2.StartTime);
                    adMostAnalyticsSessionPiece2.StopTime = getInstance().getServerTime(adMostAnalyticsSessionPiece2.StopTime);
                    String format = getInstance().dateFormat.format(Long.valueOf(adMostAnalyticsSessionPiece2.StartTime));
                    String format2 = getInstance().dateFormat.format(Long.valueOf(adMostAnalyticsSessionPiece2.StopTime));
                    if (!concurrentHashMap.containsKey(format)) {
                        concurrentHashMap.put(format, new AdMostAnalyticsSession());
                    }
                    AdMostAnalyticsSession adMostAnalyticsSession = concurrentHashMap.get(format);
                    adMostAnalyticsSession.startSessionAt(adMostAnalyticsSessionPiece2.StartTime);
                    if (format.equals(format2)) {
                        adMostAnalyticsSession.stopSessionAt(adMostAnalyticsSessionPiece2.StopTime);
                    } else {
                        long time = getInstance().dateFormat.parse(format2).getTime();
                        adMostAnalyticsSession.stopSessionAt(time);
                        if (!concurrentHashMap.containsKey(format2)) {
                            concurrentHashMap.put(format2, new AdMostAnalyticsSession());
                        }
                        AdMostAnalyticsSession adMostAnalyticsSession2 = concurrentHashMap.get(format2);
                        adMostAnalyticsSession2.startSessionAt(time);
                        adMostAnalyticsSession2.stopSessionAt(adMostAnalyticsSessionPiece2.StopTime);
                    }
                    this.tempLatestSentSessionStopTime = j;
                }
                i++;
                sessionPieces2nd = AdMostPreferences.getInstance().getSessionPieces2nd(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.cumulatingSessionPieces = false;
        return concurrentHashMap;
    }

    /* access modifiers changed from: package-private */
    public String getApplicationUserId() {
        if (AdMost.getInstance().isInitStarted()) {
            return AdMostPreferences.getInstance().getApplicationUserId();
        }
        AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
        return "";
    }

    /* access modifiers changed from: package-private */
    public long getCurrentTimeFromServer() {
        return getServerTime(System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public String getInstallDate() {
        try {
            return this.dateFormat.format(new Date(getInstallDateLong()));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public long getInstallDateLong() {
        try {
            return AdMost.getInstance().getContext().getPackageManager().getPackageInfo(AdMost.getInstance().getContext().getPackageName(), 0).firstInstallTime;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getUserId() {
        if (this.userId.length() > 0) {
            return this.userId;
        }
        String userId2 = AdMostPreferences.getInstance().getUserId();
        this.userId = userId2;
        if (userId2.length() > 0) {
            return this.userId;
        }
        this.isNewUser = true;
        String format = new SimpleDateFormat("yyyyMMddhhmm", Locale.ENGLISH).format(new Date());
        setUserId(format + "A" + getRandomExtention());
        return this.userId;
    }

    /* access modifiers changed from: package-private */
    public boolean hasSessionPiecesToSend() {
        try {
            String[] sessionPieces2nd = AdMostPreferences.getInstance().getSessionPieces2nd(AdMostPreferences.getInstance().getSessionPieceCurrentIndex());
            boolean isUserRegistered = AdMostPreferences.getInstance().isUserRegistered();
            boolean isAnalyticsDisabled = AdMostPreferences.getInstance().isAnalyticsDisabled();
            if (sessionPieces2nd != null && sessionPieces2nd.length > 0 && sessionPieces2nd[0].length() > 0) {
                String[] split = sessionPieces2nd[sessionPieces2nd.length - 1].split(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR);
                long parseLong = split.length > 1 ? Long.parseLong(split[1]) : 0;
                if (parseLong == 0) {
                    parseLong = Long.parseLong(split[0]);
                }
                if (parseLong == this.latestSentSessionStopTime || isAnalyticsDisabled || !isUserRegistered) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isNewUser() {
        return this.isNewUser;
    }

    /* access modifiers changed from: package-private */
    public boolean register() {
        if (AdMostPreferences.getInstance().isUserRegistered() || this.analyticsDisabled) {
            return false;
        }
        long j = 0;
        if (this.firstSessionStartedAt > 0) {
            j = (System.currentTimeMillis() - this.firstSessionStartedAt) / 1000;
        }
        final String[] userUpdateData = getUserUpdateData(true);
        final String format = String.format(Locale.ENGLISH, "{\"Id\":\"%s\",\"InstalledAt\":\"%s\",\"SecsSinceRegister\":%d,%s}", new Object[]{getUserId(), getInstallDate(), Long.valueOf(j), userUpdateData[0]});
        this.updateRequired = false;
        AdMostLog.m299i("UserRegister : " + format);
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.REGISTER, "", new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                if (exc != null) {
                    exc.printStackTrace();
                }
                if (exc != null && (exc instanceof AdMostServerException) && ((AdMostServerException) exc).ErrorCode.equals("1")) {
                    AdMostPreferences.getInstance().setUserUpdateData(userUpdateData[1]);
                    AdMostPreferences.getInstance().setUserRegistered(true);
                }
            }

            public void onResponse(JSONObject jSONObject) {
                String str = "";
                AdMostLog.m299i("UserRegister " + jSONObject.toString());
                try {
                    if (jSONObject.has("ServerTime")) {
                        AdMostAnalyticsManager.this.storeDeltaTime(jSONObject.getLong("ServerTime"));
                        AdMostPreferences.getInstance().setUserUpdateData(userUpdateData[1]);
                        AdMostPreferences.getInstance().setUserRegistered(true);
                        AdMostPolicyManager.getInstance().setPolicyData(jSONObject);
                    }
                    if (jSONObject.has("Country")) {
                        AdMostPreferences.getInstance().setCountry(jSONObject.getString("Country"));
                    }
                    try {
                        if (jSONObject.has("Id") && !jSONObject.optString("Id", str).equals(AdMostAnalyticsManager.this.getUserId())) {
                            AdMostLog.m299i("Changing User Id : " + jSONObject.getString("Id"));
                            AdMostAnalyticsManager.this.setUserId(jSONObject.getString("Id"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("RegisterRequest : ");
                    sb.append(format);
                    sb.append(" value : ");
                    if (jSONObject != null) {
                        str = jSONObject.toString();
                    }
                    sb.append(str);
                    AdMostLog.m298e(sb.toString(), e2, true);
                }
                AdMostAnalyticsManager.this.update();
            }
        }).mo611go(format);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void sendIAP(String str, String str2, String str3, String[] strArr, boolean z) {
        boolean z2 = (!AdMost.getInstance().getConfiguration().debugPurchaseForTesters() || !AdMostLog.isEnabled()) ? z : true;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            double optLong = (double) jSONObject.optLong("price_amount_micros", 0);
            Double.isNaN(optLong);
            double d = optLong / 1000000.0d;
            String optString = jSONObject.optString("price_currency_code");
            if (!AdMostPreferences.getInstance().isUserRegistered()) {
                Log.w(AdMostAdNetwork.ADMOST, "This device is not registered yet, your app tracking is not sent to server.");
            } else if (this.analyticsDisabled) {
                Log.w(AdMostAdNetwork.ADMOST, "Analytics is disabled for this app, please contact AdMost admins to enable.");
            } else if (Build.VERSION.SDK_INT < 11) {
                Log.w(AdMostAdNetwork.ADMOST, "In App Purchase tracking is required min SDK 11");
            } else if (d <= 0.0d || optString.equals("")) {
                Log.w(AdMostAdNetwork.ADMOST, "Could not get amount&currency from SKU DATA");
            } else {
                AdMostIAP instance2 = AdMostIAP.getInstance();
                instance2.storeInLocalStorage(new AdMostInAppPurchaseItem(str, str2, d + "", optString, "", z2, AdMostInAppPurchaseItem.SKU_TYPE_INAPP, true, strArr));
                AdMostIAP.getInstance().sendInAppPurchasesToServer();
            }
        } catch (Exception e) {
            Log.e(AdMostAdNetwork.ADMOST, "Something went wrong with your SKU data");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void setAdjustUserIdWithAdapter() {
        if (!AdMost.getInstance().isInitStarted()) {
            AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
        } else if (AdMost.getInstance().getConfiguration().isAdjustDisabled()) {
            AdMostLog.m303w("Adjust disabled ..! Adjust Id cannot be read ..!");
        } else {
            Object obj = this.adjustAdapter;
            if (obj instanceof AdMostAdjustAdapter) {
                setAdjustUserId(((AdMostAdjustAdapter) obj).getAdjustUserId());
            } else if (obj == null) {
                try {
                    if (AdMostUtil.isClassAvailable(AdMostAdClassName.ADJUST)) {
                        AdMostAdjustAdapter adMostAdjustAdapter = new AdMostAdjustAdapter();
                        this.adjustAdapter = adMostAdjustAdapter;
                        setAdjustUserId(adMostAdjustAdapter.getAdjustUserId());
                    }
                } catch (Exception unused) {
                    this.adjustAdapter = "CLASS_NOT_FOUND";
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnalyticsDisabled(boolean z) {
        this.analyticsDisabled = z;
        AdMostPreferences.getInstance().setAnalyticsDisabled(z);
    }

    public void setAnalyticsUserUnregistered() {
        AdMostPreferences.getInstance().setUserRegistered(false);
        setUserId("");
    }

    /* access modifiers changed from: package-private */
    public void setApplicationUserId(String str) {
        if (!AdMost.getInstance().isInitStarted()) {
            AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
            return;
        }
        String applicationUserId = getApplicationUserId();
        if (str != null && !str.equals(applicationUserId)) {
            AdMostAdNetworkInitInterface initAdapter = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.TAPJOY);
            if (initAdapter != null && initAdapter.isInitAdNetworkCompletedSuccessfully) {
                initAdapter.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter2 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.CHARTBOOST);
            if (initAdapter2 != null) {
                initAdapter2.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter3 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.UNITY);
            if (initAdapter3 != null) {
                initAdapter3.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter4 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.APPLOVIN);
            if (initAdapter4 != null) {
                initAdapter4.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter5 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.FACEBOOK);
            if (initAdapter5 != null) {
                initAdapter5.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter6 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADCOLONY);
            if (initAdapter6 != null) {
                initAdapter6.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter7 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.VUNGLE);
            if (initAdapter7 != null) {
                initAdapter7.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter8 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.MOPUB);
            if (initAdapter8 != null) {
                initAdapter8.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter9 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.IRONSOURCE);
            if (initAdapter9 != null) {
                initAdapter9.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter10 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADMOB);
            if (initAdapter10 != null) {
                initAdapter10.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter11 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.TAPRESEARCH);
            if (initAdapter11 != null && initAdapter11.isInitAdNetworkCompletedSuccessfully) {
                initAdapter11.setUserId(str);
            }
            AdMostAdNetworkInitInterface initAdapter12 = AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.QUMPARA);
            if (initAdapter12 != null) {
                initAdapter12.setUserId(str);
            }
            AdMostPreferences.getInstance().setApplicationUserId(str);
            update();
        }
    }

    /* access modifiers changed from: package-private */
    public void setAppsflyerUserIdWithAdapter() {
        if (!AdMost.getInstance().isInitStarted()) {
            AdMostLog.m303w(AdMost.ERROR_NOT_INIT);
        } else if (AdMost.getInstance().getConfiguration().isAppsflyerDisabled()) {
            AdMostLog.m303w("Appsflyer disabled ..! Appsflyer Id cannot be read ..!");
        } else {
            Object obj = this.appsflyerAdapter;
            if (obj instanceof AdMostAppsFlyerAdapter) {
                setAppsflyerUserId(((AdMostAppsFlyerAdapter) obj).getAppsFlyerUID());
            } else if (obj == null) {
                try {
                    if (AdMostUtil.isClassAvailable(AdMostAdClassName.APPSFLYER)) {
                        AdMostAppsFlyerAdapter adMostAppsFlyerAdapter = new AdMostAppsFlyerAdapter();
                        this.appsflyerAdapter = adMostAppsFlyerAdapter;
                        setAppsflyerUserId(adMostAppsFlyerAdapter.getAppsFlyerUID());
                    }
                } catch (Exception unused) {
                    this.appsflyerAdapter = "CLASS_NOT_FOUND";
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setLatestSendDate(long j) {
        this.latestSendDate = j;
        this.latestSentSessionStopTime = this.tempLatestSentSessionStopTime;
    }

    public void setSessionData(boolean z) {
        synchronized (this.stateChanges) {
            this.stateChanges.add(Boolean.valueOf(z));
            this.stateChanges.notify();
        }
    }

    /* access modifiers changed from: package-private */
    public void setUpdateRequired(boolean z) {
        this.updateRequired = z;
    }

    /* access modifiers changed from: package-private */
    public void storeDeltaTime(long j) {
        this.deltaTime = (System.currentTimeMillis() / 1000) - j;
        AdMostPreferences.getInstance().setDeltaTime(this.deltaTime);
    }

    /* access modifiers changed from: package-private */
    public void trackPurchase(String str, String str2, String str3, boolean z, String str4) {
        String str5 = str4;
        boolean z2 = (!AdMost.getInstance().getConfiguration().debugPurchaseForTesters() || !AdMostLog.isEnabled()) ? z : true;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            double optLong = (double) jSONObject.optLong("price_amount_micros", 0);
            Double.isNaN(optLong);
            double d = optLong / 1000000.0d;
            String optString = jSONObject.optString("price_currency_code");
            if (!AdMostPreferences.getInstance().isUserRegistered()) {
                if (AdMost.getInstance().getIAPCallback() != null) {
                    AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(102, "Client : This device is not registered yet, your app tracking is not sent to server."));
                }
                if (AdMost.getInstance().getIAPListener() != null) {
                    AdMost.getInstance().getIAPListener().onValidationFail(str5, new AdMostServerException(102, "Client : This device is not registered yet, your app tracking is not sent to server."));
                }
                Log.w(AdMostAdNetwork.ADMOST, "This device is not registered yet, your app tracking is not sent to server.");
            } else if (this.analyticsDisabled) {
                if (AdMost.getInstance().getIAPCallback() != null) {
                    AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(103, "Client : Analytics is disabled for this app, please contact AdMost admins to enable."));
                }
                if (AdMost.getInstance().getIAPListener() != null) {
                    AdMost.getInstance().getIAPListener().onValidationFail(str5, new AdMostServerException(103, "Client : Analytics is disabled for this app, please contact AdMost admins to enable."));
                }
                Log.w(AdMostAdNetwork.ADMOST, "Analytics is disabled for this app, please contact AdMost admins to enable.");
            } else if (Build.VERSION.SDK_INT < 11) {
                if (AdMost.getInstance().getIAPCallback() != null) {
                    AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(104, "Client : In App Purchase tracking is required min SDK 11."));
                }
                if (AdMost.getInstance().getIAPListener() != null) {
                    AdMost.getInstance().getIAPListener().onValidationFail(str5, new AdMostServerException(104, "Client : In App Purchase tracking is required min SDK 11."));
                }
                Log.w(AdMostAdNetwork.ADMOST, "In App Purchase tracking is required min SDK 11");
            } else if (d <= 0.0d || optString.equals("")) {
                if (AdMost.getInstance().getIAPCallback() != null) {
                    AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(101, "Client : Could not get amount&currency from SKU DATA."));
                }
                if (AdMost.getInstance().getIAPListener() != null) {
                    AdMost.getInstance().getIAPListener().onValidationFail(str5, new AdMostServerException(101, "Client : Could not get amount&currency from SKU DATA."));
                }
                Log.w(AdMostAdNetwork.ADMOST, "Could not get amount&currency from SKU DATA");
            } else {
                AdMostIAP instance2 = AdMostIAP.getInstance();
                instance2.storeInLocalStorage(new AdMostInAppPurchaseItem(str, str2, d + "", optString, str4, z2, AdMostInAppPurchaseItem.SKU_TYPE_INAPP, false, (String[]) null));
                AdMostIAP.getInstance().sendInAppPurchasesToServer();
            }
        } catch (Exception e) {
            if (AdMost.getInstance().getIAPCallback() != null) {
                AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(101, "Client : Something went wrong with your SKU data."));
            }
            if (AdMost.getInstance().getIAPListener() != null) {
                AdMost.getInstance().getIAPListener().onValidationFail(str5, new AdMostServerException(101, "Client : Something went wrong with your SKU data."));
            }
            Log.e(AdMostAdNetwork.ADMOST, "Something went wrong with your SKU data");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void trackPurchaseAmazon(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, boolean z, String str) {
        try {
            AdMostInAppPurchaseItem adMostInAppPurchaseItem = new AdMostInAppPurchaseItem(jSONObject, jSONObject2, jSONObject3, str, (!AdMost.getInstance().getConfiguration().debugPurchaseForTesters() || !AdMostLog.isEnabled()) ? z : true, AdMostInAppPurchaseItem.SKU_TYPE_INAPP);
            if (adMostInAppPurchaseItem.getAmazonIAPError() != null) {
                if (AdMost.getInstance().getIAPCallback() != null) {
                    AdMost.getInstance().getIAPCallback().onValidationFail(adMostInAppPurchaseItem.getAmazonIAPError());
                }
                if (AdMost.getInstance().getIAPListener() != null) {
                    AdMost.getInstance().getIAPListener().onValidationFail(str, adMostInAppPurchaseItem.getAmazonIAPError());
                }
            } else if (!AdMostPreferences.getInstance().isUserRegistered()) {
                if (AdMost.getInstance().getIAPCallback() != null) {
                    AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(102, "Client : This device is not registered yet, your app tracking is not sent to server."));
                }
                if (AdMost.getInstance().getIAPListener() != null) {
                    AdMost.getInstance().getIAPListener().onValidationFail(str, new AdMostServerException(102, "Client : This device is not registered yet, your app tracking is not sent to server."));
                }
                Log.w(AdMostAdNetwork.ADMOST, "This device is not registered yet, your app tracking is not sent to server.");
            } else if (this.analyticsDisabled) {
                if (AdMost.getInstance().getIAPCallback() != null) {
                    AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(103, "Client : Analytics is disabled for this app, please contact AdMost admins to enable."));
                }
                if (AdMost.getInstance().getIAPListener() != null) {
                    AdMost.getInstance().getIAPListener().onValidationFail(str, new AdMostServerException(103, "Client : Analytics is disabled for this app, please contact AdMost admins to enable."));
                }
                Log.w(AdMostAdNetwork.ADMOST, "Analytics is disabled for this app, please contact AdMost admins to enable.");
            } else {
                AdMostIAP.getInstance().storeInLocalStorage(adMostInAppPurchaseItem);
                AdMostIAP.getInstance().sendInAppPurchasesToServer();
            }
        } catch (Exception unused) {
            if (AdMost.getInstance().getIAPCallback() != null) {
                AdMost.getInstance().getIAPCallback().onValidationFail(new AdMostServerException(105, "Client : Unknown error occured."));
            }
            if (AdMost.getInstance().getIAPListener() != null) {
                AdMost.getInstance().getIAPListener().onValidationFail(str, new AdMostServerException(105, "Client : Unknown error occured."));
            }
            Log.w(AdMostAdNetwork.ADMOST, "Admost trackPurchaseAmazon : Unknown error occured.");
        }
    }

    /* access modifiers changed from: package-private */
    public void update() {
        if (AdMostPreferences.getInstance().isUserRegistered() && !this.analyticsDisabled && !this.updateRequestStarted) {
            this.updateRequestStarted = true;
            final String[] userUpdateData = getUserUpdateData(false);
            if (!AdMostPreferences.getInstance().getUserUpdateData().equals(userUpdateData[1]) || this.updateRequired) {
                this.updateRequired = false;
                AdMostLog.m299i("UserUpdate : " + userUpdateData[0]);
                AdMostGenericRequest adMostGenericRequest = new AdMostGenericRequest(AdMostGenericRequest.RequestType.HOST_UPDATE_USER, getUserId(), new AdmostResponseListener<JSONObject>() {
                    public void onError(String str, Exception exc) {
                        if (exc != null) {
                            exc.printStackTrace();
                        }
                        if (exc != null && (exc instanceof AdMostServerException) && ((AdMostServerException) exc).ErrorCode.equals(TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE)) {
                            AdMostPreferences.getInstance().setUserRegistered(false);
                        }
                        boolean unused = AdMostAnalyticsManager.this.updateRequestStarted = false;
                    }

                    public void onResponse(JSONObject jSONObject) {
                        AdMostLog.m299i("UserUpdate " + jSONObject.toString());
                        try {
                            if (jSONObject.has("ServerTime")) {
                                AdMostAnalyticsManager.this.storeDeltaTime(jSONObject.getLong("ServerTime"));
                                AdMostPreferences.getInstance().setUserUpdateData(userUpdateData[1]);
                                AdMostPolicyManager.getInstance().setPolicyData(jSONObject);
                            }
                            if (jSONObject.has("Country")) {
                                AdMostPreferences.getInstance().setCountry(jSONObject.getString("Country"));
                            }
                            try {
                                if (jSONObject.has("Id") && !jSONObject.optString("Id", "").equals(AdMostAnalyticsManager.this.getUserId())) {
                                    AdMostAnalyticsManager.this.setUserId(jSONObject.getString("Id"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        boolean unused = AdMostAnalyticsManager.this.updateRequestStarted = false;
                    }
                });
                adMostGenericRequest.mo611go("{" + userUpdateData[0] + "}");
                return;
            }
            this.updateRequestStarted = false;
        }
    }
}
