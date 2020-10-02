package com.ogury.p159cm;

import com.loopj.android.http.C4250c;
import com.ogury.core.OguryError;
import com.ogury.p159cm.ConsentActivity;
import com.ogury.p159cm.OguryChoiceManager;
import com.ogury.p159cm.aabba;
import java.net.URLDecoder;
import java.util.Date;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.abbba */
public abstract class abbba {

    /* renamed from: a */
    public static final aaaaa f12082a = new aaaaa((baaca) null);

    /* renamed from: com.ogury.cm.abbba$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }

        /* renamed from: a */
        public static abbba m15133a() {
            aacca aacca = aacca.f12035a;
            int a = aacca.m15027a();
            return a != 1 ? a != 2 ? new abbbb() : new abbbc() : new abbbb();
        }

        /* renamed from: a */
        public static void m15134a(JSONObject jSONObject) {
            accbb.m15218b(jSONObject, "jsonObject");
            if (jSONObject.has("cacheFor")) {
                aacca aacca = aacca.f12035a;
                aacca.m15029a(new Date().getTime() + (jSONObject.optLong("cacheFor") * 1000));
            }
        }

        /* renamed from: b */
        public static void m15135b(JSONObject jSONObject) {
            accbb.m15218b(jSONObject, "jsonObject");
            if (jSONObject.has("crashReportUrl")) {
                aacca aacca = aacca.f12035a;
                accca c = aacca.m15037c();
                String optString = jSONObject.optString("crashReportUrl");
                accbb.m15215a((Object) optString, "jsonObject.optString(CRASH_REPORT_URL)");
                c.mo29546c(optString);
            }
        }
    }

    /* renamed from: a */
    public abstract String mo29479a();

    /* renamed from: a */
    public final void mo29480a(String str, boolean z) {
        boolean z2;
        JSONObject optJSONObject;
        abbca abbca;
        String str2 = str;
        accbb.m15218b(str2, "response");
        try {
            aacca aacca = aacca.f12035a;
            aacca.m15044i();
            JSONObject a = ConsentActivity.aaaaa.m14882a(str);
            if (a != null) {
                boolean z3 = true;
                if (a.has("error")) {
                    aacca aacca2 = aacca.f12035a;
                    String string = a.getString("error");
                    accbb.m15215a((Object) string, "jsonObject.getString(\"error\")");
                    aacca.m15031a(new abbca(false, new OguryError(1004, aabba.aaaaa.m14999b(string))));
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (z) {
                        if (!a.has("config")) {
                            aacca aacca3 = aacca.f12035a;
                            abbca = new abbca(false, new OguryError(1004, "No config field"));
                        } else if (!a.has("form")) {
                            aacca aacca4 = aacca.f12035a;
                            abbca = new abbca(false, new OguryError(1004, "No form filed"));
                        } else if (!a.optJSONObject("form").has("secureToken")) {
                            aacca aacca5 = aacca.f12035a;
                            abbca = new abbca(false, new OguryError(1004, "No secureToken filed"));
                        }
                        aacca.m15031a(abbca);
                        z3 = false;
                    }
                    if (z3) {
                        JSONObject optJSONObject2 = a.optJSONObject("form");
                        JSONObject optJSONObject3 = a.optJSONObject("config");
                        if (optJSONObject3 != null && optJSONObject3.has("fairChoice") && (optJSONObject = optJSONObject3.optJSONObject("fairChoice")) != null && optJSONObject.optBoolean("activated")) {
                            String optString = optJSONObject.optString("productId");
                            String optString2 = optJSONObject.optString("productType");
                            abcbc abcbc = abcbc.f12099a;
                            accbb.m15215a((Object) optString, "productID");
                            accbb.m15215a((Object) optString2, "skuType");
                            abcbc.activateProduct(new acaaa(optString, optString2));
                        }
                        if (optJSONObject2 != null) {
                            aacca aacca6 = aacca.f12035a;
                            String optString3 = optJSONObject2.optString("secureToken");
                            accbb.m15215a((Object) optString3, "formObject.optString(\"secureToken\")");
                            aacca.m15036b(optString3);
                            if (a.optJSONObject("form").has("showFormat")) {
                                JSONObject optJSONObject4 = a.optJSONObject("form");
                                String optString4 = optJSONObject4 != null ? optJSONObject4.optString("showFormat") : null;
                                if (optString4 != null) {
                                    if (!accbb.m15217a((Object) optString4, (Object) "null")) {
                                        aacca aacca7 = aacca.f12035a;
                                        aacca.m15038c(optString4);
                                    }
                                }
                                aacca aacca8 = aacca.f12035a;
                                optString4 = "";
                                aacca.m15038c(optString4);
                            }
                        }
                        aacca aacca9 = aacca.f12035a;
                        String jSONObject = a.toString();
                        accbb.m15215a((Object) jSONObject, "jsonResponse.toString()");
                        aacca.m15032a(jSONObject);
                    }
                }
            } else if (z) {
                aacca aacca10 = aacca.f12035a;
                aacca.m15031a(new abbca(false, new OguryError(1004, "Json response is null")));
                return;
            }
            aacca aacca11 = aacca.f12035a;
            if (!aacca.m15045j()) {
                return;
            }
            if (baacc.m15252a(str2, "consent=", false, 2, (Object) null)) {
                String decode = URLDecoder.decode(str2, C4250c.DEFAULT_CHARSET);
                if (decode == null) {
                    aacca aacca12 = aacca.f12035a;
                    aacca.m15031a(new abbca(false, new OguryError(1004, "Decoded Json is null")));
                    return;
                }
                mo29481a(ConsentActivity.aaaaa.m14882a(babac.m15263a(decode, "consent=", (String) null, 2, (Object) null)));
                return;
            }
            mo29481a(ConsentActivity.aaaaa.m14882a(str));
        } catch (OguryError e) {
            aacca aacca13 = aacca.f12035a;
            aacca.m15031a(new abbca(false, e));
            aaccc aaccc = aaccc.f12045a;
            aaccc.m15048a("Error while parsing json config: ", e);
        } catch (Exception e2) {
            aacca aacca14 = aacca.f12035a;
            aacca.m15031a(new abbca(false, new OguryError(1004, String.valueOf(e2.getMessage()))));
            aaccc aaccc2 = aaccc.f12045a;
            aaccc.m15048a("Error while parsing json config: ", e2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo29481a(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null && jSONObject.has("sdk") && jSONObject.has("response") && jSONObject.optJSONObject("response").has(mo29479a())) {
            if (jSONObject == null) {
                accbb.m15214a();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("response");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("sdk");
            accbb.m15215a((Object) optJSONObject2, "jsonResponse.optJSONObject(SDK)");
            String optString = optJSONObject2.optString("formPath");
            if (optString == null || optString.length() == 0) {
                z = true;
            }
            if (!z) {
                aacca aacca = aacca.f12035a;
                aacca.m15037c().mo29547d(optString);
            }
            aacca aacca2 = aacca.f12035a;
            aacca.m15034b().mo29435b(optJSONObject.optBoolean("gdprApplies", true));
            if (optJSONObject.has("lastOpt")) {
                aacca aacca3 = aacca.f12035a;
                ababa b = aacca.m15034b();
                String optString2 = optJSONObject.optString("lastOpt");
                accbb.m15215a((Object) optString2, "responseObject.optString(LAST_OPT)");
                accbb.m15218b(optString2, "receiver$0");
                b.mo29431a(accbb.m15217a((Object) optString2, (Object) OguryChoiceManager.Answer.FULL_APPROVAL.toString()) ? OguryChoiceManager.Answer.FULL_APPROVAL : accbb.m15217a((Object) optString2, (Object) OguryChoiceManager.Answer.PARTIAL_APPROVAL.toString()) ? OguryChoiceManager.Answer.PARTIAL_APPROVAL : accbb.m15217a((Object) optString2, (Object) OguryChoiceManager.Answer.REFUSAL.toString()) ? OguryChoiceManager.Answer.REFUSAL : OguryChoiceManager.Answer.NO_ANSWER);
            }
            if (optJSONObject2.has("editAvailable")) {
                aacca aacca4 = aacca.f12035a;
                aacca.m15037c().mo29542a(optJSONObject2.optBoolean("editAvailable"));
            }
            aaaaa.m15135b(optJSONObject2);
            aaaaa.m15134a(optJSONObject2);
            return true;
        }
        aacca aacca5 = aacca.f12035a;
        aacca.m15031a(new abbca(false, new OguryError(1004, "Json not valid")));
        return false;
    }
}
