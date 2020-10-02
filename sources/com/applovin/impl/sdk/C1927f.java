package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.C1638c;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.sdk.network.C1968f;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.places.model.PlaceFields;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.f */
public class C1927f implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    private final C1941j f6370a;

    /* renamed from: b */
    private final AppLovinCommunicator f6371b;

    C1927f(C1941j jVar) {
        this.f6370a = jVar;
        this.f6371b = AppLovinCommunicator.getInstance(jVar.mo8527E());
        if (!jVar.mo8584e()) {
            this.f6371b.mo7129a(jVar);
            this.f6371b.subscribe((AppLovinCommunicatorSubscriber) this, C1638c.f5100a);
        }
    }

    /* renamed from: a */
    private void m7404a(Bundle bundle, String str) {
        if (!this.f6370a.mo8584e()) {
            if (!"log".equals(str)) {
                C1977q v = this.f6370a.mo8602v();
                v.mo8742b("CommunicatorService", "Sending message " + bundle + " for topic: " + str + "...");
            }
            this.f6371b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this, this.f6370a.mo8576b(C1841c.f6066fe).contains(str)));
        }
    }

    /* renamed from: a */
    public void mo8505a(C1697a aVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        bundle.putString("id", aVar.mo7766b());
        bundle.putString("network_name", aVar.mo7813E());
        bundle.putString("max_ad_unit_id", aVar.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", aVar.mo7769e());
        bundle.putString("ad_format", aVar.getFormat().getLabel());
        m7404a(bundle, "max_ad_events");
    }

    /* renamed from: a */
    public void mo8506a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("adapter_class", str);
        bundle.putInt("init_status", initializationStatus.getCode());
        m7404a(bundle, "adapter_initialization_status");
    }

    /* renamed from: a */
    public void mo8507a(String str, String str2, int i, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("url", str2);
        bundle.putInt("code", i);
        bundle.putBundle("body", C1993i.m7870a(obj));
        m7404a(bundle, "receive_http_response");
    }

    /* renamed from: a */
    public void mo8508a(JSONObject jSONObject, boolean z) {
        Bundle c = C1993i.m7903c(C1993i.m7901b(C1993i.m7901b(jSONObject, "communicator_settings", new JSONObject(), this.f6370a), "safedk_settings", new JSONObject(), this.f6370a));
        Bundle bundle = new Bundle();
        bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f6370a.mo8599t());
        bundle.putString("applovin_random_token", this.f6370a.mo8590k());
        bundle.putString(TapjoyConstants.TJC_DEVICE_TYPE_NAME, AppLovinSdkUtils.isTablet(this.f6370a.mo8527E()) ? "tablet" : PlaceFields.PHONE);
        bundle.putString("init_success", String.valueOf(z));
        bundle.putBundle("settings", c);
        bundle.putBoolean("debug_mode", ((Boolean) this.f6370a.mo8549a(C1841c.f6020eK)).booleanValue());
        m7404a(bundle, "safedk_init");
    }

    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            Map<String, String> a = C1993i.m7877a(messageData.getBundle("query_params"));
            Map<String, Object> map = BundleUtils.toMap(messageData.getBundle("post_body"));
            Map<String, String> a2 = C1993i.m7877a(messageData.getBundle("headers"));
            String string = messageData.getString("id", "");
            if (!map.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f6370a.mo8599t());
            }
            this.f6370a.mo8535N().mo8678a(new C1968f.C1970a().mo8703c(messageData.getString("url")).mo8705d(messageData.getString("backup_url")).mo8698a(a).mo8704c(map).mo8702b(a2).mo8699a(((Boolean) this.f6370a.mo8549a(C1841c.f6020eK)).booleanValue()).mo8697a(string).mo8700a());
        }
    }
}
