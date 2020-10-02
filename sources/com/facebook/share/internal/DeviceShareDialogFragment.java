package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.C0909b;
import androidx.fragment.app.C0911c;
import androidx.fragment.app.C0937k;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.common.C2707R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment extends C0909b {
    private static final String DEVICE_SHARE_ENDPOINT = "device/share";
    private static final String EXTRA_ERROR = "error";
    private static final String REQUEST_STATE_KEY = "request_state";
    public static final String TAG = "DeviceShareDialogFragment";
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private volatile ScheduledFuture codeExpiredFuture;
    private TextView confirmationCode;
    private volatile RequestState currentRequestState;
    /* access modifiers changed from: private */
    public Dialog dialog;
    private ProgressBar progressBar;
    private ShareContent shareContent;

    private static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() {
            public RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            public RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };
        private long expiresIn;
        private String userCode;

        RequestState() {
        }

        public int describeContents() {
            return 0;
        }

        public long getExpiresIn() {
            return this.expiresIn;
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setExpiresIn(long j) {
            this.expiresIn = j;
        }

        public void setUserCode(String str) {
            this.userCode = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.userCode);
            parcel.writeLong(this.expiresIn);
        }

        protected RequestState(Parcel parcel) {
            this.userCode = parcel.readString();
            this.expiresIn = parcel.readLong();
        }
    }

    private void detach() {
        if (isAdded()) {
            C0937k a = getFragmentManager().mo4778a();
            a.mo4667a((Fragment) this);
            a.mo4664a();
        }
    }

    private void finishActivity(int i, Intent intent) {
        if (this.currentRequestState != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra("error");
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.getErrorMessage(), 0).show();
        }
        if (isAdded()) {
            C0911c activity = getActivity();
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public void finishActivityWithError(FacebookRequestError facebookRequestError) {
        detach();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        finishActivity(-1, intent);
    }

    private static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
        }
        return scheduledThreadPoolExecutor;
    }

    private Bundle getGraphParametersForShareContent() {
        ShareContent shareContent2 = this.shareContent;
        if (shareContent2 == null) {
            return null;
        }
        if (shareContent2 instanceof ShareLinkContent) {
            return WebDialogParameters.create((ShareLinkContent) shareContent2);
        }
        if (shareContent2 instanceof ShareOpenGraphContent) {
            return WebDialogParameters.create((ShareOpenGraphContent) shareContent2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.codeExpiredFuture = getBackgroundExecutor().schedule(new Runnable() {
            public void run() {
                DeviceShareDialogFragment.this.dialog.dismiss();
            }
        }, requestState.getExpiresIn(), TimeUnit.SECONDS);
    }

    private void startShare() {
        Bundle graphParametersForShareContent = getGraphParametersForShareContent();
        if (graphParametersForShareContent == null || graphParametersForShareContent.size() == 0) {
            finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        graphParametersForShareContent.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        graphParametersForShareContent.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest((AccessToken) null, DEVICE_SHARE_ENDPOINT, graphParametersForShareContent, HttpMethod.POST, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    DeviceShareDialogFragment.this.finishActivityWithError(error);
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                RequestState requestState = new RequestState();
                try {
                    requestState.setUserCode(jSONObject.getString("user_code"));
                    requestState.setExpiresIn(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY));
                    DeviceShareDialogFragment.this.setCurrentRequestState(requestState);
                } catch (JSONException unused) {
                    DeviceShareDialogFragment.this.finishActivityWithError(new FacebookRequestError(0, "", "Malformed server response"));
                }
            }
        }).executeAsync();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.dialog = new Dialog(getActivity(), C2707R.style.com_facebook_auth_dialog);
        View inflate = getActivity().getLayoutInflater().inflate(C2707R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.progressBar = (ProgressBar) inflate.findViewById(C2707R.C2709id.progress_bar);
        this.confirmationCode = (TextView) inflate.findViewById(C2707R.C2709id.confirmation_code);
        ((Button) inflate.findViewById(C2707R.C2709id.cancel_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DeviceShareDialogFragment.this.dialog.dismiss();
            }
        });
        ((TextView) inflate.findViewById(C2707R.C2709id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(C2707R.string.com_facebook_device_auth_instructions)));
        this.dialog.setContentView(inflate);
        startShare();
        return this.dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) == null)) {
            setCurrentRequestState(requestState);
        }
        return onCreateView;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.codeExpiredFuture != null) {
            this.codeExpiredFuture.cancel(true);
        }
        finishActivity(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
    }
}
