package admost.sdk.listener;

import admost.sdk.model.AdMostServerException;

public interface AdMostIAPListener {
    void onException(String str);

    void onValidationFail(String str, AdMostServerException adMostServerException);

    void onValidationSuccess(String str);
}
