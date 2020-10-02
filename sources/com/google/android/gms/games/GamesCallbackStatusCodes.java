package com.google.android.gms.games;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class GamesCallbackStatusCodes {
    @Deprecated
    public static final int CLIENT_RECONNECT_REQUIRED = 2;
    public static final int INTERNAL_ERROR = 1;
    public static final int MULTIPLAYER_DISABLED = 6003;

    /* renamed from: OK */
    public static final int f8638OK = 0;
    public static final int REAL_TIME_CONNECTION_FAILED = 7000;
    public static final int REAL_TIME_MESSAGE_SEND_FAILED = 7001;
    public static final int REAL_TIME_ROOM_NOT_JOINED = 7004;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public @interface OnJoinedRoomStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public @interface OnLeftRoomStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public @interface OnRealTimeMessageSentStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public @interface OnRoomConnectedStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public @interface OnRoomCreatedStatusCodes {
    }

    private GamesCallbackStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        if (i == 0) {
            return "OK";
        }
        if (i == 1) {
            return "INTERNAL_ERROR";
        }
        if (i == 2) {
            return "CLIENT_RECONNECT_REQUIRED";
        }
        if (i == 6003) {
            return "MULTIPLAYER_DISABLED";
        }
        if (i == 7004) {
            return "REAL_TIME_ROOM_NOT_JOINED";
        }
        if (i == 7000) {
            return "REAL_TIME_CONNECTION_FAILED";
        }
        if (i == 7001) {
            return "REAL_TIME_MESSAGE_SEND_FAILED";
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("unknown games callback status code: ");
        sb.append(i);
        return sb.toString();
    }
}
