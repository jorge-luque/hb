package org.cocos2dx.cpp;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.widget.GameRequestDialog;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* renamed from: org.cocos2dx.cpp.c */
/* compiled from: FacebookManager */
public class C6717c {

    /* renamed from: e */
    private static C6717c f17559e;

    /* renamed from: a */
    public AppActivity f17560a;

    /* renamed from: b */
    public GameRequestDialog f17561b;

    /* renamed from: c */
    public CallbackManager f17562c = null;

    /* renamed from: d */
    private boolean f17563d = false;

    /* renamed from: org.cocos2dx.cpp.c$a */
    /* compiled from: FacebookManager */
    class C6718a implements FacebookCallback<LoginResult> {
        C6718a() {
        }

        /* renamed from: a */
        public void onSuccess(LoginResult loginResult) {
            C6717c.this.m21971f();
        }

        public void onCancel() {
            AppActivity.connectedToFacebook(false, "", "", "", "");
        }

        public void onError(FacebookException facebookException) {
            AppActivity.connectedToFacebook(false, "", "", "", "");
        }
    }

    /* renamed from: org.cocos2dx.cpp.c$b */
    /* compiled from: FacebookManager */
    class C6719b implements GraphRequest.Callback {

        /* renamed from: org.cocos2dx.cpp.c$b$a */
        /* compiled from: FacebookManager */
        class C6720a implements GraphRequest.Callback {

            /* renamed from: a */
            final /* synthetic */ String f17565a;

            C6720a(C6719b bVar, String str) {
                this.f17565a = str;
            }

            public void onCompleted(GraphResponse graphResponse) {
                try {
                    JSONArray jSONArray = graphResponse.getJSONObject().getJSONArray("data");
                    String str = "";
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getJSONObject(i).getString("id");
                        if (i == 0) {
                            str = string;
                        } else {
                            str = str + "," + string;
                        }
                    }
                    AppActivity.connectedToFacebook(true, AccessToken.getCurrentAccessToken().getToken(), AccessToken.getCurrentAccessToken().getUserId(), this.f17565a, str);
                } catch (Exception unused) {
                    AppActivity.connectedToFacebook(false, "", "", "", "");
                }
            }
        }

        C6719b(C6717c cVar) {
        }

        public void onCompleted(GraphResponse graphResponse) {
            try {
                String string = graphResponse.getJSONObject().getString("name");
                Bundle bundle = new Bundle();
                bundle.putInt("limit", 1000);
                bundle.putString(GraphRequest.FIELDS_PARAM, "id");
                new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/friends", bundle, HttpMethod.GET, new C6720a(this, string)).executeAsync();
            } catch (Exception unused) {
                AppActivity.connectedToFacebook(false, "", "", "", "");
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.c$c */
    /* compiled from: FacebookManager */
    class C6721c implements FacebookCallback<GameRequestDialog.Result> {
        C6721c(C6717c cVar) {
        }

        /* renamed from: a */
        public void onSuccess(GameRequestDialog.Result result) {
            if (result != null) {
                List<String> requestRecipients = result.getRequestRecipients();
                if (requestRecipients == null) {
                    AppActivity.facebookFriendsInvited(0);
                } else {
                    AppActivity.facebookFriendsInvited(requestRecipients.size());
                }
            } else {
                AppActivity.facebookFriendsInvited(-1);
            }
        }

        public void onCancel() {
            AppActivity.facebookFriendsInvited(0);
        }

        public void onError(FacebookException facebookException) {
            AppActivity.facebookFriendsInvited(-1);
        }
    }

    /* renamed from: d */
    private void m21969d() {
        GameRequestDialog gameRequestDialog = new GameRequestDialog((Activity) this.f17560a);
        this.f17561b = gameRequestDialog;
        gameRequestDialog.registerCallback(this.f17562c, new C6721c(this));
    }

    /* renamed from: e */
    public static synchronized C6717c m21970e() {
        C6717c cVar;
        synchronized (C6717c.class) {
            if (f17559e == null) {
                f17559e = new C6717c();
            }
            cVar = f17559e;
        }
        return cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m21971f() {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "name");
        new GraphRequest(AccessToken.getCurrentAccessToken(), "me", bundle, HttpMethod.GET, new C6719b(this)).executeAsync();
    }

    /* renamed from: b */
    public void mo35857b() {
        if (!this.f17563d) {
            this.f17563d = true;
            FacebookSdk.sdkInitialize(this.f17560a.getApplicationContext());
            this.f17562c = CallbackManager.Factory.create();
            LoginManager.getInstance().registerCallback(this.f17562c, new C6718a());
            m21969d();
        }
    }

    /* renamed from: c */
    public void mo35858c() {
        LoginManager.getInstance().logOut();
    }

    /* renamed from: a */
    public void mo35855a() {
        mo35857b();
        if (AccessToken.getCurrentAccessToken() != null) {
            m21971f();
            return;
        }
        LoginManager.getInstance().logInWithReadPermissions((Activity) this.f17560a, (Collection<String>) Arrays.asList(new String[]{"public_profile", "user_friends"}));
    }

    /* renamed from: a */
    public void mo35856a(String str, String str2) {
        this.f17561b.show(new GameRequestContent.Builder().setTitle(str).setMessage(str2).build());
    }
}
