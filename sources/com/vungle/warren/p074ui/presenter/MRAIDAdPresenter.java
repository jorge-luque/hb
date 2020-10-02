package com.vungle.warren.p074ui.presenter;

import android.content.ActivityNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.tapjoy.TJAdUnitConstants;
import com.vungle.warren.SessionData;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.p074ui.DurationRecorder;
import com.vungle.warren.p074ui.PresenterAppLeftCallback;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.p074ui.contract.WebAdContract;
import com.vungle.warren.p074ui.state.OptionsState;
import com.vungle.warren.p074ui.view.WebViewAPI;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.vungle.warren.ui.presenter.MRAIDAdPresenter */
public class MRAIDAdPresenter implements WebAdContract.WebAdPresenter, WebViewAPI.MRAIDDelegate, WebViewAPI.WebClientErrorHandler {
    private static final String ACTION = "action";
    private static final String ACTION_WITH_VALUE = "actionWithValue";
    private static final String CLOSE = "close";
    private static final String CONSENT_ACTION = "consentAction";
    private static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    private static final String EXTRA_REPORT = "saved_report";
    private static final String FLEXVIEW = "flexview";
    private static final String OPEN = "open";
    private static final String OPEN_NON_MRAID = "openNonMraid";
    private static final String OPEN_PRIVACY = "openPrivacy";
    private static final String SUCCESSFUL_VIEW = "successfulView";
    private static final String TAG = "com.vungle.warren.ui.presenter.MRAIDAdPresenter";
    private static final String TPAT = "tpat";
    private static final String USE_CUSTOM_CLOSE = "useCustomClose";
    private static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";
    private static final String VIDEO_VIEWED = "videoViewed";
    private ActivityManager activityManager;
    /* access modifiers changed from: private */
    public WebAdContract.WebAdView adView;
    private Advertisement advertisement;
    private final AdAnalytics analytics;
    private File assetDir;
    /* access modifiers changed from: private */
    public boolean backEnabled;
    private AdContract.AdvertisementPresenter.EventListener bus;
    private Map<String, Cookie> cookieMap = new HashMap();
    private long duration;
    private DurationRecorder durationRecorder;
    private AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private final Placement placement;
    /* access modifiers changed from: private */
    public Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        boolean errorHappened = false;

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                MRAIDAdPresenter.this.makeBusError(26);
                MRAIDAdPresenter.this.closeView();
            }
        }

        public void onSaved() {
        }
    };
    /* access modifiers changed from: private */
    public Report report;
    /* access modifiers changed from: private */
    public Repository repository;
    private final Scheduler scheduler;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    private SessionData sessionData;
    private WebViewAPI webClient;

    public MRAIDAdPresenter(Advertisement advertisement2, Placement placement2, Repository repository2, Scheduler scheduler2, AdAnalytics adAnalytics, WebViewAPI webViewAPI, OptionsState optionsState, File file, SessionData sessionData2, ActivityManager activityManager2) {
        this.advertisement = advertisement2;
        this.repository = repository2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.webClient = webViewAPI;
        this.assetDir = file;
        this.activityManager = activityManager2;
        this.sessionData = sessionData2;
        loadData(optionsState);
    }

    /* access modifiers changed from: private */
    public void closeView() {
        this.adView.close();
        this.scheduler.cancelAll();
    }

    private void download() {
        reportAction("cta", "");
        try {
            this.analytics.ping(new String[]{this.advertisement.getCTAURL(true)});
            this.activityManager.addOnNextAppLeftCallback(new PresenterAppLeftCallback(this.bus, this.placement));
            this.adView.open(this.advertisement.getCTAURL(false));
        } catch (ActivityNotFoundException unused) {
        }
    }

    private void handleWebViewException(@VungleException.ExceptionCode int i) {
        WebAdContract.WebAdView webAdView = this.adView;
        if (webAdView != null) {
            webAdView.removeWebView();
        }
        reportErrorAndCloseAd(i);
    }

    private void loadData(OptionsState optionsState) {
        Class<Cookie> cls = Cookie.class;
        this.cookieMap.put(Cookie.INCENTIVIZED_TEXT_COOKIE, this.repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, cls).get());
        this.cookieMap.put(Cookie.CONSENT_COOKIE, this.repository.load(Cookie.CONSENT_COOKIE, cls).get());
        this.cookieMap.put(Cookie.CONFIG_COOKIE, this.repository.load(Cookie.CONFIG_COOKIE, cls).get());
        if (optionsState != null) {
            String string = optionsState.getString(EXTRA_REPORT);
            Report report2 = TextUtils.isEmpty(string) ? null : this.repository.load(string, Report.class).get();
            if (report2 != null) {
                this.report = report2;
            }
        }
    }

    private void loadMraid(File file) {
        File file2 = new File(file.getParent());
        final File file3 = new File(file2.getPath() + File.separator + "index.html");
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file3, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (!z) {
                    MRAIDAdPresenter.this.makeBusError(27);
                    MRAIDAdPresenter.this.makeBusError(10);
                    MRAIDAdPresenter.this.adView.close();
                    return;
                }
                WebAdContract.WebAdView access$600 = MRAIDAdPresenter.this.adView;
                access$600.showWebsite("file://" + file3.getPath());
            }
        });
    }

    /* access modifiers changed from: private */
    public void makeBusError(@VungleException.ExceptionCode int i) {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }

    private void prepare(OptionsState optionsState) {
        String str;
        this.webClient.setMRAIDDelegate(this);
        this.webClient.setErrorHandler(this);
        loadMraid(new File(this.assetDir.getPath() + File.separator + "template"));
        if (FLEXVIEW.equals(this.advertisement.getTemplateType()) && this.advertisement.getAdConfig().getFlexViewCloseTime() > 0) {
            this.scheduler.schedule(new Runnable() {
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    MRAIDAdPresenter.this.report.recordAction("mraidCloseByTimer", "", currentTimeMillis);
                    MRAIDAdPresenter.this.report.recordAction("mraidClose", "", currentTimeMillis);
                    MRAIDAdPresenter.this.repository.save(MRAIDAdPresenter.this.report, MRAIDAdPresenter.this.repoCallback);
                    MRAIDAdPresenter.this.closeView();
                }
            }, ((long) this.advertisement.getAdConfig().getFlexViewCloseTime()) * 1000);
        }
        Cookie cookie = this.cookieMap.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
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
        Cookie cookie2 = this.cookieMap.get(Cookie.CONSENT_COOKIE);
        if (cookie2 != null) {
            boolean z = cookie2.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie2.getString("consent_status"));
            this.webClient.setConsentStatus(z, cookie2.getString("consent_title"), cookie2.getString("consent_message"), cookie2.getString("button_accept"), cookie2.getString("button_deny"));
            if (z) {
                cookie2.putValue("consent_status", "opted_out_by_timeout");
                cookie2.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie2.putValue("consent_source", "vungle_modal");
                this.repository.save(cookie2, this.repoCallback);
            }
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
        if (showCloseDelay > 0) {
            this.scheduler.schedule(new Runnable() {
                public void run() {
                    boolean unused = MRAIDAdPresenter.this.backEnabled = true;
                }
            }, (long) showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        this.adView.updateWindow(FLEXVIEW.equals(this.advertisement.getTemplateType()));
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(TJAdUnitConstants.String.VIDEO_START, (String) null, this.placement.getId());
        }
    }

    private void reportErrorAndCloseAd(@VungleException.ExceptionCode int i) {
        makeBusError(i);
        closeView();
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
            optionsState.put(EXTRA_REPORT, this.report.getId());
            optionsState.put(EXTRA_INCENTIVIZED_SENT, this.sendReportIncentivized.get());
        }
    }

    public boolean handleExit(String str) {
        if (str == null) {
            if (this.backEnabled) {
                this.adView.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
            }
            return false;
        } else if (this.advertisement == null) {
            Log.e(TAG, "Unable to close advertisement");
            return false;
        } else if (!this.placement.getId().equals(str)) {
            Log.e(TAG, "Cannot close FlexView Ad with invalid placement reference id");
            return false;
        } else if (!FLEXVIEW.equals(this.advertisement.getTemplateType())) {
            Log.e(TAG, "Cannot close a Non FlexView ad");
            return false;
        } else {
            this.adView.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
            reportAction("mraidCloseByApi", (String) null);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
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
            if (r0 == 0) goto L_0x0057
            if (r0 == r3) goto L_0x0053
            if (r0 != r2) goto L_0x003c
            goto L_0x005a
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
            goto L_0x005a
        L_0x0057:
            r4.closeView()
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p074ui.presenter.MRAIDAdPresenter.onMraidAction(java.lang.String):void");
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

    public void onViewConfigurationChanged() {
        this.adView.updateWindow(this.advertisement.getTemplateType().equals(FLEXVIEW));
        this.webClient.notifyPropertiesChange(true);
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(31);
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processCommand(java.lang.String r19, com.google.gson.JsonObject r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int r3 = r19.hashCode()
            java.lang.String r4 = "useCustomPrivacy"
            java.lang.String r5 = "openNonMraid"
            java.lang.String r6 = "successfulView"
            java.lang.String r7 = "open"
            switch(r3) {
                case -1912374177: goto L_0x0078;
                case -1422950858: goto L_0x006e;
                case -735200587: goto L_0x0064;
                case -660787472: goto L_0x005a;
                case -511324706: goto L_0x004f;
                case -418575596: goto L_0x0047;
                case -348095344: goto L_0x003e;
                case 3417674: goto L_0x0036;
                case 3566511: goto L_0x002c;
                case 94756344: goto L_0x0022;
                case 1614272768: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0081
        L_0x0017:
            java.lang.String r3 = "useCustomClose"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 7
            goto L_0x0082
        L_0x0022:
            java.lang.String r3 = "close"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 0
            goto L_0x0082
        L_0x002c:
            java.lang.String r3 = "tpat"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 3
            goto L_0x0082
        L_0x0036:
            boolean r3 = r1.equals(r7)
            if (r3 == 0) goto L_0x0081
            r3 = 5
            goto L_0x0082
        L_0x003e:
            boolean r3 = r1.equals(r4)
            if (r3 == 0) goto L_0x0081
            r3 = 8
            goto L_0x0082
        L_0x0047:
            boolean r3 = r1.equals(r5)
            if (r3 == 0) goto L_0x0081
            r3 = 6
            goto L_0x0082
        L_0x004f:
            java.lang.String r3 = "openPrivacy"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 9
            goto L_0x0082
        L_0x005a:
            java.lang.String r3 = "consentAction"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 1
            goto L_0x0082
        L_0x0064:
            java.lang.String r3 = "actionWithValue"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 2
            goto L_0x0082
        L_0x006e:
            java.lang.String r3 = "action"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 4
            goto L_0x0082
        L_0x0078:
            boolean r3 = r1.equals(r6)
            if (r3 == 0) goto L_0x0081
            r3 = 10
            goto L_0x0082
        L_0x0081:
            r3 = -1
        L_0x0082:
            java.lang.String r12 = "user"
            java.lang.String r13 = "adStartTime"
            java.lang.String r14 = "app_id"
            java.lang.String r15 = "placement_reference_id"
            java.lang.String r8 = "isReportIncentivizedEnabled"
            java.lang.String r10 = "Unknown value "
            java.lang.String r9 = "configSettings"
            java.lang.String r11 = "gone"
            r16 = r5
            java.lang.String r5 = "url"
            java.lang.String r1 = "event"
            r17 = r1
            r1 = 0
            switch(r3) {
                case 0: goto L_0x0397;
                case 1: goto L_0x0357;
                case 2: goto L_0x0258;
                case 3: goto L_0x0241;
                case 4: goto L_0x023f;
                case 5: goto L_0x01eb;
                case 6: goto L_0x01eb;
                case 7: goto L_0x0190;
                case 8: goto L_0x0137;
                case 9: goto L_0x011a;
                case 10: goto L_0x00a0;
                default: goto L_0x009e;
            }
        L_0x009e:
            r1 = 0
            return r1
        L_0x00a0:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r2 = r0.bus
            if (r2 == 0) goto L_0x00ad
            com.vungle.warren.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getId()
            r2.onNext(r6, r1, r3)
        L_0x00ad:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.Object r1 = r1.get(r9)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            com.vungle.warren.model.Placement r2 = r0.placement
            boolean r2 = r2.isIncentivized()
            if (r2 == 0) goto L_0x0118
            if (r1 == 0) goto L_0x0118
            java.lang.Boolean r1 = r1.getBoolean(r8)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0118
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.sendReportIncentivized
            r2 = 1
            boolean r1 = r1.getAndSet(r2)
            if (r1 != 0) goto L_0x0118
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getId()
            r2.<init>((java.lang.String) r3)
            r1.add(r15, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Advertisement r3 = r0.advertisement
            java.lang.String r3 = r3.getAppID()
            r2.<init>((java.lang.String) r3)
            r1.add(r14, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            long r3 = r3.getAdStartTime()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.<init>((java.lang.Number) r3)
            r1.add(r13, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            java.lang.String r3 = r3.getUserID()
            r2.<init>((java.lang.String) r3)
            r1.add(r12, r2)
            com.vungle.warren.analytics.AdAnalytics r2 = r0.analytics
            r2.mo32325ri(r1)
        L_0x0118:
            r1 = 1
            return r1
        L_0x011a:
            r1 = 1
            com.google.gson.JsonElement r2 = r2.get(r5)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.utility.ActivityManager r3 = r0.activityManager
            com.vungle.warren.ui.PresenterAppLeftCallback r4 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r5 = r0.bus
            com.vungle.warren.model.Placement r6 = r0.placement
            r4.<init>(r5, r6)
            r3.addOnNextAppLeftCallback(r4)
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r3 = r0.adView
            r3.open(r2)
            return r1
        L_0x0137:
            com.google.gson.JsonElement r1 = r2.get(r4)
            java.lang.String r1 = r1.getAsString()
            int r2 = r1.hashCode()
            r3 = 3178655(0x30809f, float:4.454244E-39)
            if (r2 == r3) goto L_0x0167
            r3 = 3569038(0x36758e, float:5.001287E-39)
            if (r2 == r3) goto L_0x015d
            r3 = 97196323(0x5cb1923, float:1.9099262E-35)
            if (r2 == r3) goto L_0x0153
            goto L_0x016f
        L_0x0153:
            java.lang.String r2 = "false"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x016f
            r8 = 2
            goto L_0x0170
        L_0x015d:
            java.lang.String r2 = "true"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x016f
            r8 = 1
            goto L_0x0170
        L_0x0167:
            boolean r2 = r1.equals(r11)
            if (r2 == 0) goto L_0x016f
            r8 = 0
            goto L_0x0170
        L_0x016f:
            r8 = -1
        L_0x0170:
            if (r8 == 0) goto L_0x018e
            r2 = 1
            if (r8 == r2) goto L_0x018e
            r2 = 2
            if (r8 != r2) goto L_0x0179
            goto L_0x018e
        L_0x0179:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x018e:
            r1 = 1
            return r1
        L_0x0190:
            java.lang.String r1 = "sdkCloseButton"
            com.google.gson.JsonElement r1 = r2.get(r1)
            java.lang.String r1 = r1.getAsString()
            int r2 = r1.hashCode()
            r3 = -1901805651(0xffffffff8ea4bfad, float:-4.06137E-30)
            if (r2 == r3) goto L_0x01c0
            r3 = 3178655(0x30809f, float:4.454244E-39)
            if (r2 == r3) goto L_0x01b8
            r3 = 466743410(0x1bd1f072, float:3.4731534E-22)
            if (r2 == r3) goto L_0x01ae
            goto L_0x01ca
        L_0x01ae:
            java.lang.String r2 = "visible"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01ca
            r8 = 2
            goto L_0x01cb
        L_0x01b8:
            boolean r2 = r1.equals(r11)
            if (r2 == 0) goto L_0x01ca
            r8 = 0
            goto L_0x01cb
        L_0x01c0:
            java.lang.String r2 = "invisible"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01ca
            r8 = 1
            goto L_0x01cb
        L_0x01ca:
            r8 = -1
        L_0x01cb:
            if (r8 == 0) goto L_0x01e9
            r2 = 1
            if (r8 == r2) goto L_0x01e9
            r2 = 2
            if (r8 != r2) goto L_0x01d4
            goto L_0x01e9
        L_0x01d4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x01e9:
            r1 = 1
            return r1
        L_0x01eb:
            r3 = r19
            boolean r4 = r7.equalsIgnoreCase(r3)
            if (r4 == 0) goto L_0x01fe
            java.lang.String r3 = "mraidOpen"
            r0.reportAction(r3, r1)
            java.lang.String r3 = "download"
            r0.reportAction(r3, r1)
            goto L_0x020b
        L_0x01fe:
            r4 = r16
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x020b
            java.lang.String r3 = "nonMraidOpen"
            r0.reportAction(r3, r1)
        L_0x020b:
            com.google.gson.JsonElement r1 = r2.get(r5)
            java.lang.String r1 = r1.getAsString()
            com.vungle.warren.utility.ActivityManager r2 = r0.activityManager
            com.vungle.warren.ui.PresenterAppLeftCallback r3 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r0.bus
            com.vungle.warren.model.Placement r5 = r0.placement
            r3.<init>(r4, r5)
            r2.addOnNextAppLeftCallback(r3)
            com.vungle.warren.download.ApkDownloadManager r2 = com.vungle.warren.download.ApkDownloadManager.getInstance()
            com.vungle.warren.model.Advertisement r3 = r0.advertisement
            boolean r3 = r3.isRequiresNonMarketInstall()
            r2.download(r1, r3)
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r0.bus
            if (r1 == 0) goto L_0x023d
            com.vungle.warren.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = "adClick"
            r1.onNext(r7, r3, r2)
        L_0x023d:
            r1 = 1
            return r1
        L_0x023f:
            r1 = 1
            return r1
        L_0x0241:
            r3 = r17
            r1 = 1
            com.google.gson.JsonElement r2 = r2.get(r3)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.analytics.AdAnalytics r3 = r0.analytics
            com.vungle.warren.model.Advertisement r4 = r0.advertisement
            java.lang.String[] r2 = r4.getTpatUrls(r2)
            r3.ping(r2)
            return r1
        L_0x0258:
            r3 = r17
            com.google.gson.JsonElement r3 = r2.get(r3)
            java.lang.String r3 = r3.getAsString()
            java.lang.String r4 = "value"
            com.google.gson.JsonElement r2 = r2.get(r4)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.model.Report r4 = r0.report
            long r5 = java.lang.System.currentTimeMillis()
            r4.recordAction(r3, r2, r5)
            com.vungle.warren.persistence.Repository r4 = r0.repository
            com.vungle.warren.model.Report r5 = r0.report
            com.vungle.warren.persistence.Repository$SaveCallback r6 = r0.repoCallback
            r4.save(r5, r6)
            java.lang.String r4 = "videoViewed"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0338
            long r4 = r0.duration
            r6 = 0
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x0338
            float r4 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x029c }
            long r5 = r0.duration     // Catch:{ NumberFormatException -> 0x029c }
            float r5 = (float) r5
            float r4 = r4 / r5
            r5 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r5
            int r10 = (int) r4
            goto L_0x02a4
        L_0x029c:
            java.lang.String r4 = TAG
            java.lang.String r5 = "value for videoViewed is null !"
            android.util.Log.e(r4, r5)
            r10 = 0
        L_0x02a4:
            if (r10 <= 0) goto L_0x0333
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r0.bus
            if (r4 == 0) goto L_0x02c4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "percentViewed:"
            r5.append(r6)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            com.vungle.warren.model.Placement r6 = r0.placement
            java.lang.String r6 = r6.getId()
            r4.onNext(r5, r1, r6)
        L_0x02c4:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.Object r1 = r1.get(r9)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            com.vungle.warren.model.Placement r4 = r0.placement
            boolean r4 = r4.isIncentivized()
            if (r4 == 0) goto L_0x0333
            r4 = 75
            if (r10 <= r4) goto L_0x0333
            if (r1 == 0) goto L_0x0333
            java.lang.Boolean r1 = r1.getBoolean(r8)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0333
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.sendReportIncentivized
            r4 = 1
            boolean r1 = r1.getAndSet(r4)
            if (r1 != 0) goto L_0x0333
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Placement r5 = r0.placement
            java.lang.String r5 = r5.getId()
            r4.<init>((java.lang.String) r5)
            r1.add(r15, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Advertisement r5 = r0.advertisement
            java.lang.String r5 = r5.getAppID()
            r4.<init>((java.lang.String) r5)
            r1.add(r14, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r5 = r0.report
            long r5 = r5.getAdStartTime()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r4.<init>((java.lang.Number) r5)
            r1.add(r13, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r5 = r0.report
            java.lang.String r5 = r5.getUserID()
            r4.<init>((java.lang.String) r5)
            r1.add(r12, r4)
            com.vungle.warren.analytics.AdAnalytics r4 = r0.analytics
            r4.mo32325ri(r1)
        L_0x0333:
            com.vungle.warren.ui.DurationRecorder r1 = r0.durationRecorder
            r1.update()
        L_0x0338:
            java.lang.String r1 = "videoLength"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0350
            long r3 = java.lang.Long.parseLong(r2)
            r0.duration = r3
            r0.reportAction(r1, r2)
            com.vungle.warren.ui.view.WebViewAPI r1 = r0.webClient
            r2 = 1
            r1.notifyPropertiesChange(r2)
            goto L_0x0351
        L_0x0350:
            r2 = 1
        L_0x0351:
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r1 = r0.adView
            r1.setVisibility(r2)
            return r2
        L_0x0357:
            r3 = r17
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.String r4 = "consentIsImportantToVungle"
            java.lang.Object r1 = r1.get(r4)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            if (r1 != 0) goto L_0x036a
            com.vungle.warren.model.Cookie r1 = new com.vungle.warren.model.Cookie
            r1.<init>(r4)
        L_0x036a:
            com.google.gson.JsonElement r2 = r2.get(r3)
            java.lang.String r2 = r2.getAsString()
            java.lang.String r3 = "consent_status"
            r1.putValue(r3, r2)
            java.lang.String r2 = "consent_source"
            java.lang.String r3 = "vungle_modal"
            r1.putValue(r2, r3)
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "timestamp"
            r1.putValue(r3, r2)
            com.vungle.warren.persistence.Repository r2 = r0.repository
            com.vungle.warren.persistence.Repository$SaveCallback r3 = r0.repoCallback
            r2.save(r1, r3)
            r2 = 1
            return r2
        L_0x0397:
            r2 = 1
            java.lang.String r3 = "mraidClose"
            r0.reportAction(r3, r1)
            r18.closeView()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p074ui.presenter.MRAIDAdPresenter.processCommand(java.lang.String, com.google.gson.JsonObject):boolean");
    }

    public void reportAction(String str, String str2) {
        if (str.equals("videoLength")) {
            long parseLong = Long.parseLong(str2);
            this.duration = parseLong;
            this.report.setVideoLength(parseLong);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void restoreFromSave(OptionsState optionsState) {
        if (optionsState != null) {
            boolean z = optionsState.getBoolean(EXTRA_INCENTIVIZED_SENT, false);
            if (z) {
                this.sendReportIncentivized.set(z);
            }
            if (this.report == null) {
                this.adView.close();
            }
        }
    }

    public void setAdVisibility(boolean z) {
        this.webClient.setAdVisibility(z);
        if (z) {
            this.durationRecorder.start();
        } else {
            this.durationRecorder.stop();
        }
    }

    public void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    public void start() {
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(31);
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        setAdVisibility(true);
    }

    public void stop(@AdContract.AdStopReason int i) {
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        this.adView.pauseWeb();
        setAdVisibility(false);
        if (!z && z2 && !this.isDestroying.getAndSet(true)) {
            WebViewAPI webViewAPI = this.webClient;
            String str = null;
            if (webViewAPI != null) {
                webViewAPI.setMRAIDDelegate((WebViewAPI.MRAIDDelegate) null);
            }
            if (z3) {
                reportAction("mraidCloseByApi", (String) null);
            }
            this.repository.save(this.report, this.repoCallback);
            AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str, this.placement.getId());
            }
        }
    }

    public void attach(WebAdContract.WebAdView webAdView, OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = webAdView;
        webAdView.setPresenter(this);
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            if ((settings & 2) == 2) {
                z = true;
            }
            this.backEnabled = z;
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
        webAdView.setOrientation(i2);
        prepare(optionsState);
    }
}
