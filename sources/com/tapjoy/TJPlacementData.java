package com.tapjoy;

import com.tapjoy.internal.C3166jq;
import java.io.Serializable;

public class TJPlacementData implements Serializable {

    /* renamed from: a */
    private String f13062a;

    /* renamed from: b */
    private String f13063b;

    /* renamed from: c */
    private String f13064c;

    /* renamed from: d */
    private String f13065d;

    /* renamed from: e */
    private String f13066e;

    /* renamed from: f */
    private String f13067f;

    /* renamed from: g */
    private int f13068g;

    /* renamed from: h */
    private String f13069h;

    /* renamed from: i */
    private String f13070i;

    /* renamed from: j */
    private int f13071j;

    /* renamed from: k */
    private boolean f13072k;

    /* renamed from: l */
    private String f13073l;

    /* renamed from: m */
    private boolean f13074m;

    /* renamed from: n */
    private String f13075n;

    /* renamed from: o */
    private String f13076o;

    /* renamed from: p */
    private boolean f13077p = true;

    /* renamed from: q */
    private boolean f13078q = false;

    public TJPlacementData(String str, String str2) {
        setKey(str);
        updateUrl(str2);
        setPlacementType(TapjoyConstants.TJC_APP_PLACEMENT);
    }

    public String getAuctionMediationURL() {
        return this.f13066e;
    }

    public String getBaseURL() {
        return this.f13064c;
    }

    public String getCallbackID() {
        return this.f13075n;
    }

    public String getContentViewId() {
        return this.f13076o;
    }

    public String getHttpResponse() {
        return this.f13067f;
    }

    public int getHttpStatusCode() {
        return this.f13068g;
    }

    public String getKey() {
        return this.f13062a;
    }

    public String getMediationURL() {
        return this.f13065d;
    }

    public String getPlacementName() {
        return this.f13069h;
    }

    public String getPlacementType() {
        return this.f13070i;
    }

    public String getRedirectURL() {
        return this.f13073l;
    }

    public String getUrl() {
        return this.f13063b;
    }

    public int getViewType() {
        return this.f13071j;
    }

    public boolean hasProgressSpinner() {
        return this.f13072k;
    }

    public boolean isBaseActivity() {
        return this.f13077p;
    }

    public boolean isPreloadDisabled() {
        return this.f13078q;
    }

    public boolean isPrerenderingRequested() {
        return this.f13074m;
    }

    public void resetPlacementRequestData() {
        setHttpResponse((String) null);
        setHttpStatusCode(0);
        setRedirectURL((String) null);
        setHasProgressSpinner(false);
        setPrerenderingRequested(false);
        setPreloadDisabled(false);
        setContentViewId((String) null);
    }

    public void setAuctionMediationURL(String str) {
        this.f13066e = str;
    }

    public void setBaseURL(String str) {
        this.f13064c = str;
    }

    public void setContentViewId(String str) {
        this.f13076o = str;
    }

    public void setHasProgressSpinner(boolean z) {
        this.f13072k = z;
    }

    public void setHttpResponse(String str) {
        this.f13067f = str;
    }

    public void setHttpStatusCode(int i) {
        this.f13068g = i;
    }

    public void setKey(String str) {
        this.f13062a = str;
    }

    public void setMediationURL(String str) {
        this.f13065d = str;
    }

    public void setPlacementName(String str) {
        this.f13069h = str;
    }

    public void setPlacementType(String str) {
        this.f13070i = str;
    }

    public void setPreloadDisabled(boolean z) {
        this.f13078q = z;
    }

    public void setPrerenderingRequested(boolean z) {
        this.f13074m = z;
    }

    public void setRedirectURL(String str) {
        this.f13073l = str;
    }

    public void setViewType(int i) {
        this.f13071j = i;
    }

    public void updateUrl(String str) {
        this.f13063b = str;
        if (!C3166jq.m10436c(str)) {
            setBaseURL(str.substring(0, str.indexOf(47, str.indexOf("//") + 3)));
        }
    }

    public TJPlacementData(String str, String str2, String str3) {
        setBaseURL(str);
        setHttpResponse(str2);
        this.f13075n = str3;
        this.f13077p = false;
        setPlacementType(TapjoyConstants.TJC_APP_PLACEMENT);
    }
}
