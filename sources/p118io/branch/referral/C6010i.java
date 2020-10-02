package p118io.branch.referral;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import com.facebook.share.internal.ShareConstants;
import com.ogury.p159cm.OguryChoiceManager;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.i */
/* compiled from: BranchUtil */
public class C6010i {

    /* renamed from: a */
    static boolean f15388a = false;

    /* renamed from: a */
    public static boolean m19310a(Context context) {
        boolean parseBoolean;
        if (f15388a) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("io.branch.sdk.TestMode")) {
                Resources resources = context.getResources();
                parseBoolean = Boolean.parseBoolean(resources.getString(resources.getIdentifier("io.branch.sdk.TestMode", "string", context.getPackageName())));
            } else {
                parseBoolean = applicationInfo.metaData.getBoolean("io.branch.sdk.TestMode", false);
            }
            return parseBoolean;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    static JSONObject m19311b(JSONObject jSONObject) {
        return m19309a(jSONObject);
    }

    /* renamed from: a */
    static JSONObject m19309a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(ShareConstants.FEED_SOURCE_PARAM, "android");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
