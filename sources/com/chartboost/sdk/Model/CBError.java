package com.chartboost.sdk.Model;

public final class CBError {

    /* renamed from: a */
    private final C2085b f6882a;

    /* renamed from: b */
    private final String f6883b;

    public enum CBClickError {
        URI_INVALID,
        URI_UNRECOGNIZED,
        AGE_GATE_FAILURE,
        NO_HOST_ACTIVITY,
        INTERNAL
    }

    public enum CBImpressionError {
        INTERNAL,
        INTERNET_UNAVAILABLE,
        TOO_MANY_CONNECTIONS,
        WRONG_ORIENTATION,
        FIRST_SESSION_INTERSTITIALS_DISABLED,
        NETWORK_FAILURE,
        NO_AD_FOUND,
        SESSION_NOT_STARTED,
        IMPRESSION_ALREADY_VISIBLE,
        NO_HOST_ACTIVITY,
        USER_CANCELLATION,
        INVALID_LOCATION,
        VIDEO_UNAVAILABLE,
        VIDEO_ID_MISSING,
        ERROR_PLAYING_VIDEO,
        INVALID_RESPONSE,
        ASSETS_DOWNLOAD_FAILURE,
        ERROR_CREATING_VIEW,
        ERROR_DISPLAYING_VIEW,
        INCOMPATIBLE_API_VERSION,
        ERROR_LOADING_WEB_VIEW,
        ASSET_PREFETCH_IN_PROGRESS,
        ACTIVITY_MISSING_IN_MANIFEST,
        EMPTY_LOCAL_VIDEO_LIST,
        END_POINT_DISABLED,
        HARDWARE_ACCELERATION_DISABLED,
        PENDING_IMPRESSION_ERROR,
        VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION,
        ASSET_MISSING,
        WEB_VIEW_PAGE_LOAD_TIMEOUT,
        WEB_VIEW_CLIENT_RECEIVED_ERROR,
        INTERNET_UNAVAILABLE_AT_SHOW
    }

    /* renamed from: com.chartboost.sdk.Model.CBError$a */
    static /* synthetic */ class C2084a {

        /* renamed from: a */
        static final /* synthetic */ int[] f6886a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.chartboost.sdk.Model.CBError$b[] r0 = com.chartboost.sdk.Model.CBError.C2085b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6886a = r0
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.MISCELLANEOUS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6886a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.UNEXPECTED_RESPONSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6886a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.PUBLIC_KEY_MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6886a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.INTERNET_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6886a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.HTTP_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6886a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.NETWORK_FAILURE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6886a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.INVALID_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Model.CBError.C2084a.<clinit>():void");
        }
    }

    /* renamed from: com.chartboost.sdk.Model.CBError$b */
    public enum C2085b {
        MISCELLANEOUS,
        INTERNET_UNAVAILABLE,
        INVALID_RESPONSE,
        UNEXPECTED_RESPONSE,
        NETWORK_FAILURE,
        PUBLIC_KEY_MISSING,
        HTTP_NOT_FOUND
    }

    public CBError(C2085b bVar, String str) {
        this.f6882a = bVar;
        this.f6883b = str;
    }

    /* renamed from: a */
    public C2085b mo9114a() {
        return this.f6882a;
    }

    /* renamed from: b */
    public String mo9115b() {
        return this.f6883b;
    }

    /* renamed from: c */
    public CBImpressionError mo9116c() {
        int i = C2084a.f6886a[this.f6882a.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return CBImpressionError.INTERNAL;
        }
        if (i == 4) {
            return CBImpressionError.INTERNET_UNAVAILABLE;
        }
        if (i != 5) {
            return CBImpressionError.NETWORK_FAILURE;
        }
        return CBImpressionError.NO_AD_FOUND;
    }
}
