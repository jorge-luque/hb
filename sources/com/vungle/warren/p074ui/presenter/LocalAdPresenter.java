package com.vungle.warren.p074ui.presenter;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TJAdUnitConstants;
import com.vungle.warren.SessionData;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.analytics.AnalyticsEvent;
import com.vungle.warren.analytics.AnalyticsVideoTracker;
import com.vungle.warren.download.ApkDownloadManager;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.p074ui.DurationRecorder;
import com.vungle.warren.p074ui.JavascriptBridge;
import com.vungle.warren.p074ui.PresenterAppLeftCallback;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.p074ui.contract.LocalAdContract;
import com.vungle.warren.p074ui.state.OptionsState;
import com.vungle.warren.p074ui.view.WebViewAPI;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.vungle.warren.ui.presenter.LocalAdPresenter */
public class LocalAdPresenter implements LocalAdContract.LocalPresenter, WebViewAPI.WebClientErrorHandler {
    static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    static final String EXTRA_IN_POST = "in_post_roll";
    static final String EXTRA_IS_MUTED = "is_muted_mode";
    static final String EXTRA_REPORT = "saved_report";
    static final String EXTRA_VIDEO_POSITION = "videoPosition";
    static final String HTTPS_VUNGLE_COM_PRIVACY = "https://vungle.com/privacy/";
    public static final int INCENTIVIZED_TRESHOLD = 75;
    static final String TAG = "LocalAdPresenter";
    private ActivityManager activityManager;
    /* access modifiers changed from: private */
    public LocalAdContract.LocalView adView;
    /* access modifiers changed from: private */
    public Advertisement advertisement;
    /* access modifiers changed from: private */
    public final AdAnalytics analytics;
    private File assetDir;
    private AdContract.AdvertisementPresenter.EventListener bus;
    private AtomicBoolean busy = new AtomicBoolean(false);
    private LinkedList<Advertisement.Checkpoint> checkpointList = new LinkedList<>();
    private final Map<String, Cookie> cookies = new HashMap();
    private String dialogBody = "If you exit now, you will not get your reward";
    private String dialogClose = "Close";
    private String dialogContinue = "Continue";
    private String dialogTitle = "Are you sure?";
    private int duration;
    private DurationRecorder durationRecorder;
    private AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    /* access modifiers changed from: private */
    public boolean inPost;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private boolean muted;
    private Placement placement;
    private int progress;
    private Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        boolean errorHappened = false;

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                LocalAdPresenter.this.makeBusError(26);
                LocalAdPresenter.this.closeAndReport();
            }
        }

        public void onSaved() {
        }
    };
    private Report report;
    /* access modifiers changed from: private */
    public Repository repository;
    private final Scheduler scheduler;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    private SessionData sessionData;
    /* access modifiers changed from: private */
    public boolean userExitEnabled;
    private int videoPosition;
    /* access modifiers changed from: private */
    public final AnalyticsVideoTracker videoTracker;
    private final WebViewAPI webViewAPI;

    public LocalAdPresenter(Advertisement advertisement2, Placement placement2, Repository repository2, Scheduler scheduler2, AdAnalytics adAnalytics, AnalyticsVideoTracker analyticsVideoTracker, WebViewAPI webViewAPI2, OptionsState optionsState, File file, SessionData sessionData2, ActivityManager activityManager2) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.videoTracker = analyticsVideoTracker;
        this.webViewAPI = webViewAPI2;
        this.repository = repository2;
        this.assetDir = file;
        this.activityManager = activityManager2;
        this.sessionData = sessionData2;
        if (advertisement2.getCheckpoints() != null) {
            this.checkpointList.addAll(advertisement2.getCheckpoints());
            Collections.sort(this.checkpointList);
        }
        loadData(optionsState);
    }

    /* access modifiers changed from: private */
    public void closeAndReport() {
        if (this.adView.isVideoPlaying()) {
            this.videoTracker.stop();
        }
        if (this.busy.get()) {
            Log.w(TAG, "Busy with closing");
            return;
        }
        this.busy.set(true);
        reportAction("close", (String) null);
        this.scheduler.cancelAll();
        this.adView.close();
    }

    /* access modifiers changed from: private */
    public void continueWithPostroll() {
        if (this.advertisement.hasPostroll()) {
            playPost();
        } else {
            closeAndReport();
        }
    }

    private void download() {
        reportAction("cta", "");
        try {
            this.analytics.ping(this.advertisement.getTpatUrls(AnalyticsEvent.C5464Ad.postrollClick));
            this.analytics.ping(this.advertisement.getTpatUrls("click_url"));
            this.analytics.ping(this.advertisement.getTpatUrls(AnalyticsEvent.C5464Ad.videoClick));
            this.analytics.ping(new String[]{this.advertisement.getCTAURL(true)});
            reportAction(JavascriptBridge.MraidHandler.DOWNLOAD_ACTION, (String) null);
            String ctaurl = this.advertisement.getCTAURL(false);
            this.activityManager.addOnNextAppLeftCallback(new PresenterAppLeftCallback(this.bus, this.placement));
            ApkDownloadManager.getInstance().download(ctaurl, this.advertisement.isRequiresNonMarketInstall());
            if (this.bus != null) {
                this.bus.onNext("open", "adClick", this.placement.getId());
            }
        } catch (ActivityNotFoundException unused) {
            Log.e(TAG, "Unable to find destination activity");
        }
    }

    private void handleWebViewException(@VungleException.ExceptionCode int i) {
        LocalAdContract.LocalView localView = this.adView;
        if (localView != null) {
            localView.removeWebView();
        }
        reportErrorAndCloseAd(i);
    }

    private boolean isWebPageBlank() {
        String websiteUrl = this.adView.getWebsiteUrl();
        return TextUtils.isEmpty(websiteUrl) || "about:blank".equalsIgnoreCase(websiteUrl);
    }

    private void loadData(OptionsState optionsState) {
        Class<Cookie> cls = Cookie.class;
        this.cookies.put(Cookie.INCENTIVIZED_TEXT_COOKIE, this.repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, cls).get());
        this.cookies.put(Cookie.CONSENT_COOKIE, this.repository.load(Cookie.CONSENT_COOKIE, cls).get());
        this.cookies.put(Cookie.CONFIG_COOKIE, this.repository.load(Cookie.CONFIG_COOKIE, cls).get());
        if (optionsState != null) {
            String string = optionsState.getString(EXTRA_REPORT);
            Report report2 = TextUtils.isEmpty(string) ? null : this.repository.load(string, Report.class).get();
            if (report2 != null) {
                this.report = report2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void makeBusError(@VungleException.ExceptionCode int i) {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }

    private boolean needShowGDPR(Cookie cookie) {
        return cookie != null && cookie.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie.getString("consent_status"));
    }

    private void playPost() {
        File file = new File(this.assetDir.getPath());
        final File file2 = new File(file.getPath() + File.separator + "index.html");
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file2, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (z) {
                    if (LocalAdPresenter.this.videoTracker != null) {
                        LocalAdPresenter.this.videoTracker.stop();
                    }
                    LocalAdContract.LocalView access$300 = LocalAdPresenter.this.adView;
                    access$300.showWebsite("file://" + file2.getPath());
                    LocalAdPresenter.this.analytics.ping(LocalAdPresenter.this.advertisement.getTpatUrls(AnalyticsEvent.C5464Ad.postrollView));
                    boolean unused = LocalAdPresenter.this.inPost = true;
                    return;
                }
                LocalAdPresenter.this.makeBusError(27);
                LocalAdPresenter.this.makeBusError(10);
                LocalAdPresenter.this.closeAndReport();
            }
        });
    }

    private void prepare(OptionsState optionsState) {
        String str;
        restoreFromSave(optionsState);
        Cookie cookie = this.cookies.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
        if (cookie == null) {
            str = null;
        } else {
            str = cookie.getString("userID");
        }
        if (this.report == null) {
            Report report2 = new Report(this.advertisement, this.placement, System.currentTimeMillis(), str, this.sessionData);
            this.report = report2;
            report2.setTtDownload(this.advertisement.getTtDownload());
            this.repository.save(this.report, this.repoCallback);
        }
        if (this.durationRecorder == null) {
            this.durationRecorder = new DurationRecorder(this.report, this.repository, this.repoCallback);
        }
        this.webViewAPI.setErrorHandler(this);
        this.adView.showCTAOverlay(this.advertisement.isCtaOverlayEnabled(), this.advertisement.getCtaClickArea());
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(TJAdUnitConstants.String.VIDEO_START, (String) null, this.placement.getId());
        }
    }

    private void reportError(String str) {
        this.report.recordError(str);
        this.repository.save(this.report, this.repoCallback);
        makeBusError(27);
        if (this.inPost || !this.advertisement.hasPostroll()) {
            makeBusError(10);
            this.adView.close();
            return;
        }
        playPost();
    }

    private void reportErrorAndCloseAd(@VungleException.ExceptionCode int i) {
        makeBusError(i);
        closeAndReport();
    }

    private void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        this.adView.pauseVideo();
        this.adView.showDialog(str, str2, str3, str4, onClickListener);
    }

    private void showGDPR(final Cookie cookie) {
        C55133 r5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                cookie.putValue("consent_status", i == -2 ? Cookie.CONSENT_STATUS_OPTED_OUT : i == -1 ? Cookie.CONSENT_STATUS_OPTED_IN : "opted_out_by_timeout");
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "vungle_modal");
                LocalAdPresenter.this.repository.save(cookie, (Repository.SaveCallback) null);
                LocalAdPresenter.this.start();
            }
        };
        cookie.putValue("consent_status", "opted_out_by_timeout");
        cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        cookie.putValue("consent_source", "vungle_modal");
        this.repository.save(cookie, this.repoCallback);
        showDialog(cookie.getString("consent_title"), cookie.getString("consent_message"), cookie.getString("button_accept"), cookie.getString("button_deny"), r5);
    }

    private void showIncetivizedDialog() {
        String str = this.dialogTitle;
        String str2 = this.dialogBody;
        String str3 = this.dialogContinue;
        String str4 = this.dialogClose;
        Cookie cookie = this.cookies.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
        if (cookie != null) {
            str = cookie.getString("title") == null ? this.dialogTitle : cookie.getString("title");
            str2 = cookie.getString("body") == null ? this.dialogBody : cookie.getString("body");
            str3 = cookie.getString("continue") == null ? this.dialogContinue : cookie.getString("continue");
            str4 = cookie.getString("close") == null ? this.dialogClose : cookie.getString("close");
        }
        showDialog(str, str2, str3, str4, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -2) {
                    LocalAdPresenter.this.reportAction(AnalyticsEvent.C5464Ad.videoClose, (String) null);
                    LocalAdPresenter.this.continueWithPostroll();
                }
            }
        });
    }

    public void detach(boolean z) {
        boolean z2 = z | true;
        AsyncFileUtils.ExistenceOperation existenceOperation = this.fileExistenceOperation;
        if (existenceOperation != null) {
            existenceOperation.cancel();
        }
        stop(z2 ? 1 : 0);
        this.adView.destroyAdView();
    }

    public void generateSaveState(OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            Report report2 = this.report;
            optionsState.put(EXTRA_REPORT, report2 == null ? null : report2.getId());
            optionsState.put(EXTRA_INCENTIVIZED_SENT, this.sendReportIncentivized.get());
            optionsState.put(EXTRA_IN_POST, this.inPost);
            optionsState.put(EXTRA_IS_MUTED, this.muted);
            LocalAdContract.LocalView localView = this.adView;
            optionsState.put(EXTRA_VIDEO_POSITION, (localView == null || !localView.isVideoPlaying()) ? this.videoPosition : this.adView.getVideoPosition());
        }
    }

    public boolean handleExit(String str) {
        if (this.inPost) {
            closeAndReport();
            return true;
        } else if (!this.userExitEnabled) {
            return false;
        } else {
            if (!this.placement.isIncentivized() || this.progress > 75) {
                reportAction(AnalyticsEvent.C5464Ad.videoClose, (String) null);
                if (this.advertisement.hasPostroll()) {
                    playPost();
                    return false;
                }
                closeAndReport();
                return true;
            }
            showIncetivizedDialog();
            return false;
        }
    }

    public void onDownload() {
        download();
    }

    public boolean onMediaError(String str) {
        reportError(str);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMraidAction(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -314498168(0xffffffffed412388, float:-3.7358476E27)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 1427818632(0x551ac888, float:1.06366291E13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "download"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "close"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "privacy"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x005a
            if (r0 == r3) goto L_0x0053
            if (r0 != r2) goto L_0x003c
            goto L_0x005d
        L_0x003c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown action "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0053:
            r4.download()
            r4.closeAndReport()
            goto L_0x005d
        L_0x005a:
            r4.closeAndReport()
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p074ui.presenter.LocalAdPresenter.onMraidAction(java.lang.String):void");
    }

    public void onMute(boolean z) {
        this.muted = z;
        if (z) {
            reportAction(AnalyticsEvent.C5464Ad.mute, "true");
        } else {
            reportAction(AnalyticsEvent.C5464Ad.unmute, "false");
        }
        this.videoTracker.setPlayerVolume(z);
    }

    public void onPrivacy() {
        this.activityManager.addOnNextAppLeftCallback(new PresenterAppLeftCallback(this.bus, this.placement));
        this.adView.open(HTTPS_VUNGLE_COM_PRIVACY);
    }

    public void onProgressUpdate(int i, float f) {
        this.progress = (int) ((((float) i) / f) * 100.0f);
        this.videoPosition = i;
        this.durationRecorder.update();
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("percentViewed:" + this.progress, (String) null, this.placement.getId());
        }
        reportAction("video_viewed", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i)}));
        this.videoTracker.onProgress(this.progress);
        if (this.progress == 100) {
            this.videoTracker.stop();
            if (this.checkpointList.peekLast() != null && this.checkpointList.peekLast().getPercentage() == 100) {
                this.analytics.ping(this.checkpointList.pollLast().getUrls());
            }
            continueWithPostroll();
        }
        this.report.recordProgress(this.videoPosition);
        this.repository.save(this.report, this.repoCallback);
        while (this.checkpointList.peek() != null && this.progress > this.checkpointList.peek().getPercentage()) {
            this.analytics.ping(this.checkpointList.poll().getUrls());
        }
        Cookie cookie = this.cookies.get(Cookie.CONFIG_COOKIE);
        if (this.placement.isIncentivized() && this.progress > 75 && cookie != null && cookie.getBoolean("isReportIncentivizedEnabled").booleanValue() && !this.sendReportIncentivized.getAndSet(true)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("placement_reference_id", new JsonPrimitive(this.placement.getId()));
            jsonObject.add("app_id", new JsonPrimitive(this.advertisement.getAppID()));
            jsonObject.add(ReportDBAdapter.ReportColumns.COLUMN_AD_START_TIME, new JsonPrimitive((Number) Long.valueOf(this.report.getAdStartTime())));
            jsonObject.add(QumparaOfferwallUtil.TABLE_NAME, new JsonPrimitive(this.report.getUserID()));
            this.analytics.mo32325ri(jsonObject);
        }
    }

    public void onReceivedError(String str) {
        Report report2 = this.report;
        if (report2 != null) {
            report2.recordError(str);
            this.repository.save(this.report, this.repoCallback);
        }
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException(32);
    }

    public void onVideoStart(int i, float f) {
        int i2 = (int) f;
        reportAction("videoLength", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i2)}));
        this.videoTracker.start(i2);
        this.videoTracker.setPlayerVolume(this.muted);
    }

    public void onViewConfigurationChanged() {
        this.webViewAPI.notifyPropertiesChange(true);
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(31);
        return true;
    }

    public void reportAction(String str, String str2) {
        if (str.equals("videoLength")) {
            int parseInt = Integer.parseInt(str2);
            this.duration = parseInt;
            this.report.setVideoLength((long) parseInt);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -840405966) {
            if (hashCode != 3363353) {
                if (hashCode == 1370606900 && str.equals(AnalyticsEvent.C5464Ad.videoClose)) {
                    c = 2;
                }
            } else if (str.equals(AnalyticsEvent.C5464Ad.mute)) {
                c = 0;
            }
        } else if (str.equals(AnalyticsEvent.C5464Ad.unmute)) {
            c = 1;
        }
        if (c == 0 || c == 1 || c == 2) {
            this.analytics.ping(this.advertisement.getTpatUrls(str));
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void restoreFromSave(OptionsState optionsState) {
        if (optionsState != null) {
            if (optionsState.getBoolean(EXTRA_INCENTIVIZED_SENT, false)) {
                this.sendReportIncentivized.set(true);
            }
            this.inPost = optionsState.getBoolean(EXTRA_IN_POST, this.inPost);
            this.muted = optionsState.getBoolean(EXTRA_IS_MUTED, this.muted);
            this.videoPosition = optionsState.getInt(EXTRA_VIDEO_POSITION, this.videoPosition).intValue();
        }
    }

    public void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    public void start() {
        this.durationRecorder.start();
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(31);
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        Cookie cookie = this.cookies.get(Cookie.CONSENT_COOKIE);
        if (needShowGDPR(cookie)) {
            showGDPR(cookie);
        } else if (this.inPost) {
            if (isWebPageBlank()) {
                playPost();
            }
        } else if (!this.adView.isVideoPlaying() && !this.adView.isDialogVisible()) {
            this.adView.playVideo(new File(this.assetDir.getPath() + File.separator + "video"), this.muted, this.videoPosition);
            int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
            if (showCloseDelay > 0) {
                this.scheduler.schedule(new Runnable() {
                    public void run() {
                        boolean unused = LocalAdPresenter.this.userExitEnabled = true;
                        if (!LocalAdPresenter.this.inPost) {
                            LocalAdPresenter.this.adView.showCloseButton();
                        }
                    }
                }, (long) showCloseDelay);
                return;
            }
            this.userExitEnabled = true;
            this.adView.showCloseButton();
        }
    }

    public void stop(@AdContract.AdStopReason int i) {
        this.durationRecorder.stop();
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        if ((i & 2) != 0) {
            z = true;
        }
        this.adView.pauseWeb();
        if (this.adView.isVideoPlaying()) {
            this.videoPosition = this.adView.getVideoPosition();
            this.adView.pauseVideo();
        }
        if (z2 || !z) {
            if (this.inPost || z) {
                this.adView.showWebsite("about:blank");
            }
        } else if (!this.isDestroying.getAndSet(true)) {
            String str = null;
            reportAction("close", (String) null);
            this.scheduler.cancelAll();
            AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str, this.placement.getId());
            }
        }
    }

    public void attach(LocalAdContract.LocalView localView, OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = localView;
        localView.setPresenter(this);
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            this.muted = (settings & 1) == 1;
            if ((settings & 2) == 2) {
                z = true;
            }
            this.userExitEnabled = z;
        }
        int i = -1;
        int adOrientation = this.advertisement.getAdConfig().getAdOrientation();
        int i2 = 6;
        if (adOrientation == 3) {
            int orientation = this.advertisement.getOrientation();
            if (orientation == 0) {
                i = 7;
            } else if (orientation == 1) {
                i = 6;
            }
            i2 = i;
        } else if (adOrientation == 0) {
            i2 = 7;
        } else if (adOrientation != 1) {
            i2 = 4;
        }
        "Requested Orientation " + i2;
        localView.setOrientation(i2);
        prepare(optionsState);
    }
}
