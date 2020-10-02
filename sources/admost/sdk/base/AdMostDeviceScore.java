package admost.sdk.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.p004v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.places.model.PlaceFields;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.HashMap;
import java.util.Map;

public class AdMostDeviceScore {
    private static final int MAX_SCORE_ITEM = 100;
    private static HashMap<ScoreItem, AdMostDeviceScore> itemList = getItemList();
    private static int totalScore;
    private int coefficient;
    private int score;

    enum ScoreItem {
        NUM_OF_PROCESSORS,
        DEVICE_TOTAL_MEMORY,
        PROCESS_FREE_MEMORY,
        PROCESS_AVAILABLE_MEMORY,
        OS_VERSION,
        DISPLAY_AREA
    }

    public AdMostDeviceScore(int i, int i2) {
        this.score = Math.min(Math.max(0, i), 100);
        this.coefficient = i2;
    }

    public static synchronized void addDeviceScore(ScoreItem scoreItem, AdMostDeviceScore adMostDeviceScore) {
        synchronized (AdMostDeviceScore.class) {
            getItemList().put(scoreItem, adMostDeviceScore);
            totalScore += adMostDeviceScore.coefficient * 100;
        }
    }

    public static synchronized int calculateDeviceScore(Context context) {
        synchronized (AdMostDeviceScore.class) {
            boolean z = false;
            totalScore = 0;
            if (context == null) {
                return 0;
            }
            if (isNetworkConnected(context)) {
                if (getMobileNetworkQuality(context) != 2) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager == null) {
                        return 0;
                    }
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    Runtime runtime = Runtime.getRuntime();
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if ((applicationInfo.flags & 1048576) == 1048576) {
                        z = true;
                    }
                    try {
                        addDeviceScore(ScoreItem.NUM_OF_PROCESSORS, new AdMostDeviceScore((runtime.availableProcessors() + 2) * 10, 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        int max = Math.max(5, ((int) (getInMB(runtime.maxMemory()) - getInMB(runtime.totalMemory() - runtime.freeMemory()))) - 20) * 2;
                        int i = 400 / max;
                        if (max >= 100) {
                            i = 2;
                        }
                        addDeviceScore(ScoreItem.PROCESS_FREE_MEMORY, new AdMostDeviceScore(max, i));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        if (Build.VERSION.SDK_INT > 19) {
                            addDeviceScore(ScoreItem.DEVICE_TOTAL_MEMORY, new AdMostDeviceScore(getTotalDeviceMemory(activityManager) / 35, 2));
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    try {
                        int memoryClass = activityManager.getMemoryClass();
                        if (z) {
                            int largeMemoryClass = activityManager.getLargeMemoryClass();
                            ScoreItem scoreItem = ScoreItem.PROCESS_AVAILABLE_MEMORY;
                            double d = (double) largeMemoryClass;
                            Double.isNaN(d);
                            addDeviceScore(scoreItem, new AdMostDeviceScore((int) Math.floor(d / 5.12d), 2));
                            try {
                                addDeviceScore(ScoreItem.OS_VERSION, new AdMostDeviceScore(((Build.VERSION.SDK_INT - 14) * 8) - 15, 6));
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            try {
                                addDeviceScore(ScoreItem.DISPLAY_AREA, new AdMostDeviceScore((displayMetrics.widthPixels * displayMetrics.heightPixels) / 25000, 2));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            int deviceScore = getDeviceScore();
                            return deviceScore;
                        }
                        ScoreItem scoreItem2 = ScoreItem.PROCESS_AVAILABLE_MEMORY;
                        double d2 = (double) memoryClass;
                        Double.isNaN(d2);
                        addDeviceScore(scoreItem2, new AdMostDeviceScore((int) Math.floor(d2 / 2.56d), 2));
                        addDeviceScore(ScoreItem.OS_VERSION, new AdMostDeviceScore(((Build.VERSION.SDK_INT - 14) * 8) - 15, 6));
                        addDeviceScore(ScoreItem.DISPLAY_AREA, new AdMostDeviceScore((displayMetrics.widthPixels * displayMetrics.heightPixels) / 25000, 2));
                        int deviceScore2 = getDeviceScore();
                        return deviceScore2;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            AdMostLog.m294d("The device is not able to get the ads in terms of network quality. Network connectivity: " + isNetworkConnected(context) + " , Is 2G Mobile: " + getMobileNetworkQuality(context));
            return 0;
        }
    }

    public static synchronized void clearItemList() {
        synchronized (AdMostDeviceScore.class) {
            if (itemList != null) {
                itemList.clear();
            }
        }
    }

    private static int getDeviceScore() {
        int i = 0;
        if (totalScore == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : getItemList().entrySet()) {
            AdMostDeviceScore adMostDeviceScore = (AdMostDeviceScore) next.getValue();
            int i2 = adMostDeviceScore.score * adMostDeviceScore.coefficient;
            i += i2;
            sb.append("name: ");
            sb.append(((ScoreItem) next.getKey()).name());
            sb.append(" score: ");
            sb.append(adMostDeviceScore.score);
            sb.append(" coefficient: ");
            sb.append(adMostDeviceScore.coefficient);
            sb.append(" total_item: ");
            sb.append(i2);
            sb.append("\n");
        }
        double d = (double) i;
        Double.isNaN(d);
        double d2 = (double) totalScore;
        Double.isNaN(d2);
        int floor = (int) Math.floor(((d * 1.0d) / d2) * 100.0d);
        sb.append("score: ");
        sb.append(i);
        sb.append(" totalScore:");
        sb.append(totalScore);
        sb.append(" score/total: ");
        sb.append(floor);
        AdMostLog.m294d(sb.toString());
        return floor;
    }

    public static long getInMB(long j) {
        return (j / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static synchronized HashMap<ScoreItem, AdMostDeviceScore> getItemList() {
        HashMap<ScoreItem, AdMostDeviceScore> hashMap;
        synchronized (AdMostDeviceScore.class) {
            if (itemList == null) {
                itemList = new HashMap<>();
            }
            hashMap = itemList;
        }
        return hashMap;
    }

    public static int getMobileNetworkQuality(Context context) {
        if (!isMobileConnected(context)) {
            return -1;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
        if (telephonyManager == null) {
            return 0;
        }
        int networkType = telephonyManager.getNetworkType();
        if (networkType == 1 || networkType == 2 || networkType == 4 || networkType == 7 || networkType == 11 || networkType == 16) {
            return 2;
        }
        return 0;
    }

    private static int getTotalDeviceMemory(ActivityManager activityManager) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return ((int) (memoryInfo.totalMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
        }
        return 0;
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null || !networkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkConnected(Context context) {
        return isWifiConnected(context) || isMobileConnected(context);
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }
}
