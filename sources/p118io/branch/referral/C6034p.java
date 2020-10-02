package p118io.branch.referral;

import android.text.TextUtils;
import com.crashlytics.android.answers.shim.AnswersOptionalLogger;
import com.crashlytics.android.answers.shim.KitEvent;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.p */
/* compiled from: ExtendedAnswerProvider */
class C6034p {
    C6034p() {
    }

    /* renamed from: a */
    public void mo33936a(String str, JSONObject jSONObject, String str2) {
        try {
            KitEvent kitEvent = new KitEvent(str);
            if (jSONObject != null) {
                m19390a(kitEvent, jSONObject, "");
                kitEvent.putAttribute(C6028l.BranchIdentity.mo33920a(), str2);
                AnswersOptionalLogger.get().logKitEvent(kitEvent);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m19390a(KitEvent kitEvent, JSONObject jSONObject, String str) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!next.startsWith("+")) {
                if (obj instanceof JSONObject) {
                    m19390a(kitEvent, (JSONObject) obj, str + next + ".");
                } else if (obj instanceof JSONArray) {
                    m19389a(kitEvent, (JSONArray) obj, next + ".");
                } else {
                    m19388a(kitEvent, str, next, jSONObject.getString(next));
                }
            }
        }
    }

    /* renamed from: a */
    private void m19389a(KitEvent kitEvent, JSONArray jSONArray, String str) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            m19388a(kitEvent, str, "~" + Integer.toString(i), jSONArray.getString(i));
        }
    }

    /* renamed from: a */
    private void m19388a(KitEvent kitEvent, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (str2.startsWith("~")) {
            kitEvent.putAttribute(str.replaceFirst("~", "") + str2.replaceFirst("~", ""), str3);
            return;
        }
        if (str2.equals("$" + C6028l.IdentityID.mo33920a())) {
            kitEvent.putAttribute(C6028l.ReferringBranchIdentity.mo33920a(), str3);
        }
    }
}
