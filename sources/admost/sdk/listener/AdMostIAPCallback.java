package admost.sdk.listener;

import admost.sdk.model.AdMostServerException;

@Deprecated
public interface AdMostIAPCallback {
    void onException();

    void onValidationFail(AdMostServerException adMostServerException);

    void onValidationSuccess();
}
