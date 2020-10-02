package com.vungle.warren.error;

public class VungleException extends Exception {
    public static final int AD_EXPIRED = 4;
    public static final int AD_FAILED_TO_DOWNLOAD = 11;
    public static final int AD_UNABLE_TO_PLAY = 10;
    public static final int ALREADY_PLAYING_ANOTHER_AD = 15;
    public static final int APPLICATION_CONTEXT_REQUIRED = 7;
    public static final int ASSET_DOWNLOAD_ERROR = 24;
    public static final int ASSET_DOWNLOAD_RECOVERABLE = 23;
    public static final int CONFIGURATION_ERROR = 3;
    public static final int DB_ERROR = 26;
    public static final int DIRECT_DOWNLOAD_VALIDATION_ERROR = 5;
    public static final int INCORRECT_BANNER_API_USAGE = 30;
    public static final int INCORRECT_DEFAULT_API_USAGE = 29;
    public static final int INVALID_SIZE = 28;
    public static final int MISSING_REQUIRED_ARGUMENTS_FOR_INIT = 6;
    public static final int NETWORK_ERROR = 20;
    public static final int NO_AUTO_CACHED_PLACEMENT = 12;
    public static final int NO_SERVE = 1;
    public static final int NO_SPACE_TO_DOWNLOAD_ASSETS = 19;
    public static final int NO_SPACE_TO_INIT = 16;
    public static final int NO_SPACE_TO_LOAD_AD = 17;
    public static final int NO_SPACE_TO_LOAD_AD_AUTO_CACHED = 18;
    public static final int OPERATION_CANCELED = 25;
    public static final int OPERATION_ONGOING = 8;
    public static final int PLACEMENT_NOT_FOUND = 13;
    public static final int RENDER_ERROR = 27;
    public static final int SERVER_ERROR = 21;
    public static final int SERVER_RETRY_ERROR = 14;
    public static final int SERVER_TEMPORARY_UNAVAILABLE = 22;
    public static final int UNKNOWN_ERROR = 2;
    public static final int VUNGLE_NOT_INTIALIZED = 9;
    public static final int WEBVIEW_RENDER_UNRESPONSIVE = 32;
    public static final int WEB_CRASH = 31;
    @ExceptionCode
    private final int exceptionCode;

    public @interface ExceptionCode {
    }

    public VungleException(@ExceptionCode int i) {
        this.exceptionCode = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && VungleException.class == obj.getClass() && this.exceptionCode == ((VungleException) obj).exceptionCode) {
            return true;
        }
        return false;
    }

    @ExceptionCode
    public int getExceptionCode() {
        return this.exceptionCode;
    }

    public String getLocalizedMessage() {
        switch (this.exceptionCode) {
            case 1:
                return "No advertisements are available for your current bid. Please try again later.";
            case 2:
                return "Unknown Error Occurred.";
            case 3:
                return "Configuration Error Occurred. Please check your appID and placementIDs, and try again when network connectivity is available.";
            case 4:
                return "The advertisement in the cache has expired and can no longer be played. Please load another ad";
            case 5:
                return "The App for Advertisement does not exist in the App store for DirectDownload. Please load another ad";
            case 6:
                return "Please ensure all parameter for init marked as NonNull are provided, as they are essential for functioning of our SDK";
            case 7:
                return "Please provide Application context so our SDK can continue to support our API beyond Activity lifecycle";
            case 8:
                return "There is already an ongoing operation for the action you requested. Please wait until the operation finished before starting another.";
            case 9:
                return "Vungle is not initialized/no longer initialized. Please call Vungle.init() to reinitialize.";
            case 10:
                return "Unable to play advertisement";
            case 11:
                return "Advertisement failed to download";
            case 12:
                return "No auto-cached Placement on config";
            case 13:
                return "Placement is not valid";
            case 14:
                return "Remote Server responded with http Retry-After, SDK will retry this request.";
            case 15:
                return "Vungle is already playing different ad.";
            case 16:
                return "There is not enough file system size on a device to initialize VungleSDK";
            case 17:
                return "There is not enough file system size on a device to request an ad.";
            case 18:
                return "There is not enough file system size on a device to request an ad for auto cache.";
            case 19:
                return "There is not enough file system size on a device to download assets for an ad.";
            case 20:
                return "Network error. Try again later";
            case 21:
                return "Server error";
            case 22:
                return "Server temporary unavailable. Try again later";
            case 23:
                return "Assets download failed. Try again later";
            case 24:
                return "Assets download failed.";
            case 25:
                return "Operation was canceled";
            case 26:
                return "Database error";
            case 27:
                return "Render error";
            case 28:
                return "Ad size is invalid";
            case 29:
                return "Cannot request or play Banner Ads from Vungle API, please use Banner.loadAd() or Banner.getBanner()";
            case 30:
                return "Cannot request or play MREC, Flexfeed or FullScreen Ads from Banner API, please use Vungle.loadAd(), Vungle.playAd() or Vungle.getNativeAd()";
            case 31:
                return "Android web view has crashed";
            case 32:
                return "Android web view render became unresponsive, please clean-up your Webview process if any";
            default:
                throw new IllegalStateException("Unknown Exception Code");
        }
    }

    public int hashCode() {
        return this.exceptionCode;
    }

    public static int getExceptionCode(Throwable th) {
        if (th instanceof VungleException) {
            return ((VungleException) th).getExceptionCode();
        }
        return -1;
    }
}
