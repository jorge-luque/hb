package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import bolts.C1159b;
import bolts.C1166f;
import bolts.C1167g;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    /* access modifiers changed from: private */
    public final HashMap<Uri, C1159b> cachedAppLinks = new HashMap<>();

    /* access modifiers changed from: private */
    public static C1159b.C1160a getAndroidTargetFromJson(JSONObject jSONObject) {
        Uri uri = null;
        String tryGetStringFromJson = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_PACKAGE_KEY, (String) null);
        if (tryGetStringFromJson == null) {
            return null;
        }
        String tryGetStringFromJson2 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_CLASS_KEY, (String) null);
        String tryGetStringFromJson3 = tryGetStringFromJson(jSONObject, "app_name", (String) null);
        String tryGetStringFromJson4 = tryGetStringFromJson(jSONObject, "url", (String) null);
        if (tryGetStringFromJson4 != null) {
            uri = Uri.parse(tryGetStringFromJson4);
        }
        return new C1159b.C1160a(tryGetStringFromJson, tryGetStringFromJson2, uri, tryGetStringFromJson3);
    }

    /* access modifiers changed from: private */
    public static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("web");
            Uri uri2 = null;
            if (!tryGetBooleanFromJson(jSONObject2, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject2, "url", (String) null);
            if (tryGetStringFromJson != null) {
                uri2 = Uri.parse(tryGetStringFromJson);
            }
            return uri2 != null ? uri2 : uri;
        } catch (JSONException unused) {
            return uri;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return z;
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return str2;
        }
    }

    public C1167g<C1159b> getAppLinkFromUrlInBackground(final Uri uri) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(uri);
        return getAppLinkFromUrlsInBackground(arrayList).mo6185b(new C1166f<Map<Uri, C1159b>, C1159b>() {
            public C1159b then(C1167g<Map<Uri, C1159b>> gVar) throws Exception {
                return (C1159b) gVar.mo6187b().get(uri);
            }
        });
    }

    public C1167g<Map<Uri, C1159b>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        C1159b bVar;
        final HashMap hashMap = new HashMap();
        final HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Uri next : list) {
            synchronized (this.cachedAppLinks) {
                bVar = this.cachedAppLinks.get(next);
            }
            if (bVar != null) {
                hashMap.put(next, bVar);
            } else {
                if (!hashSet.isEmpty()) {
                    sb.append(',');
                }
                sb.append(next.toString());
                hashSet.add(next);
            }
        }
        if (hashSet.isEmpty()) {
            return C1167g.m4774b(hashMap);
        }
        final C1167g<TResult>.f h = C1167g.m4779h();
        Bundle bundle = new Bundle();
        bundle.putString("ids", sb.toString());
        bundle.putString(GraphRequest.FIELDS_PARAM, String.format("%s.fields(%s,%s)", new Object[]{"app_links", "android", "web"}));
        new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, (HttpMethod) null, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    h.mo6197a((Exception) error.getException());
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    h.mo6198a(hashMap);
                    return;
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (jSONObject.has(uri.toString())) {
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(uri.toString()).getJSONObject("app_links");
                            JSONArray jSONArray = jSONObject2.getJSONArray("android");
                            int length = jSONArray.length();
                            ArrayList arrayList = new ArrayList(length);
                            for (int i = 0; i < length; i++) {
                                C1159b.C1160a access$000 = FacebookAppLinkResolver.getAndroidTargetFromJson(jSONArray.getJSONObject(i));
                                if (access$000 != null) {
                                    arrayList.add(access$000);
                                }
                            }
                            C1159b bVar = new C1159b(uri, arrayList, FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jSONObject2));
                            hashMap.put(uri, bVar);
                            synchronized (FacebookAppLinkResolver.this.cachedAppLinks) {
                                FacebookAppLinkResolver.this.cachedAppLinks.put(uri, bVar);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }
                h.mo6198a(hashMap);
            }
        }).executeAsync();
        return h.mo6196a();
    }
}
