package admost.sdk.base;

import admost.sdk.listener.AdMostErrorListener;
import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdMostLog {
    private static final Logger LOGGER = Logger.getLogger("com.admost");
    private static final String LOGTAG = "ADMOST";
    private static final AdMostLogHandler LOG_HANDLER = new AdMostLogHandler();
    private static AdMostErrorListener errorListener = null;
    private static boolean isEnabled = false;
    private static boolean isHTTPLoggingEnabled;

    private static final class AdMostLogHandler extends Handler {
        private static final Map<Level, Integer> LOG_LEVEL_MAP;

        static {
            HashMap hashMap = new HashMap(7);
            LOG_LEVEL_MAP = hashMap;
            hashMap.put(Level.FINEST, 4);
            LOG_LEVEL_MAP.put(Level.FINER, 6);
            LOG_LEVEL_MAP.put(Level.FINE, 2);
            LOG_LEVEL_MAP.put(Level.CONFIG, 3);
            LOG_LEVEL_MAP.put(Level.INFO, 4);
            LOG_LEVEL_MAP.put(Level.WARNING, 5);
            LOG_LEVEL_MAP.put(Level.SEVERE, 6);
        }

        private AdMostLogHandler() {
        }

        public void close() {
        }

        public void flush() {
        }

        public boolean isLoggable(LogRecord logRecord) {
            if (logRecord.getLevel() == Level.FINEST || logRecord.getLevel() == Level.FINER) {
                return true;
            }
            if (!AdMostLog.isEnabled() || !super.isLoggable(logRecord)) {
                return false;
            }
            return true;
        }

        public void publish(LogRecord logRecord) {
            if (isLoggable(logRecord)) {
                int intValue = LOG_LEVEL_MAP.containsKey(logRecord.getLevel()) ? LOG_LEVEL_MAP.get(logRecord.getLevel()).intValue() : 2;
                String str = logRecord.getMessage() + "\n";
                Throwable thrown = logRecord.getThrown();
                if (thrown != null) {
                    str = str + Log.getStackTraceString(thrown);
                }
                Log.println(intValue, "ADMOST", str);
            }
        }
    }

    private static class PrettyLogger {
        private static final String BOTTOM_BORDER = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
        private static final String BOTTOM_BORDER_SMALL = "└──────────────────────────────────┘";
        private static final char BOTTOM_LEFT_CORNER = '└';
        private static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
        private static final char HORIZONTAL_LINE = '│';
        private static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
        private static final char MIDDLE_CORNER = '├';
        private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
        private static final String SMALL_DIVIDER = "──────────────────────────────────";
        private static final String TOP_BORDER = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
        private static final String TOP_BORDER_SMALL = "┌──────────────────────────────────┐";
        private static final char TOP_LEFT_CORNER = '┌';

        private PrettyLogger() {
        }
    }

    static {
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.ALL);
        LOG_HANDLER.setLevel(Level.FINE);
        LogManager.getLogManager().addLogger(LOGGER);
        addHandler(LOGGER, LOG_HANDLER);
    }

    private AdMostLog() {
    }

    private static void addHandler(Logger logger, Handler handler) {
        Handler[] handlers = logger.getHandlers();
        int length = handlers.length;
        int i = 0;
        while (i < length) {
            if (!handlers[i].equals(handler)) {
                i++;
            } else {
                return;
            }
        }
        logger.addHandler(handler);
    }

    public static void all(String str) {
        all(str, (Throwable) null);
    }

    public static void allError(String str) {
        allError(str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m294d(String str) {
        m295d(str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m296e(String str) {
        m297e(str, (Throwable) null);
    }

    private static String getStringWithLength(int i, char c) {
        if (i <= 0) {
            return "";
        }
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    /* renamed from: i */
    public static void m299i(String str) {
        m300i(str, (Throwable) null);
    }

    public static boolean isAdNetworkLogsEnabled() {
        return isEnabled() && AdMost.getInstance().getConfiguration().isAdNetworkLogsEnabled();
    }

    public static boolean isEnabled() {
        return isEnabled && AdMost.getInstance().getConfiguration() != null && AdMost.getInstance().getConfiguration().isAdminModeEnabled();
    }

    public static boolean isIsHTTPLoggingEnabled() {
        return isHTTPLoggingEnabled;
    }

    public static void json(String str, String str2) {
        if (str == null || str.length() <= 0) {
            jsonInternal("Empty JSON", (Throwable) null, (Level) null);
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                printFormattedJson(new JSONObject(trim).toString(2), str2);
            } else if (trim.startsWith("[")) {
                printFormattedJson(new JSONArray(trim).toString(2), str2);
            } else {
                jsonInternal("Invalid JSON", (Throwable) null, (Level) null);
            }
        } catch (JSONException unused) {
            jsonInternal("Invalid JSON", (Throwable) null, (Level) null);
        }
    }

    private static void jsonInternal(String str, Throwable th, Level level) {
        if (level == null) {
            LOGGER.log(Level.CONFIG, str, th);
        } else {
            LOGGER.log(level, str, th);
        }
    }

    public static void log(String str) {
        m299i(str);
    }

    public static void logAvailableNetworks() {
        m299i("┌──────────────────────────────────┐");
        m299i(9474 + " Available Ad Networks" + getStringWithLength(7, ' ') + 9474);
        m299i("│──────────────────────────────────│");
        for (String str : AdMostAdNetwork.getAvailableAdNetworks()) {
            m299i("│ » " + str + getStringWithLength((36 - str.length()) - 10, ' ') + 9474);
        }
        m299i("└──────────────────────────────────┘");
    }

    private static void printFormattedJson(String str, String str2) {
        String[] split = str.split(System.getProperty("line.separator"));
        jsonInternal("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────", (Throwable) null, (Level) null);
        if (!str2.equals("")) {
            jsonInternal("│ " + str2, (Throwable) null, (Level) null);
            jsonInternal("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄", (Throwable) null, (Level) null);
        }
        for (String str3 : split) {
            jsonInternal("│ " + str3, (Throwable) null, (Level) null);
        }
        jsonInternal("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────", (Throwable) null, (Level) null);
    }

    public static void setErrorListener(AdMostErrorListener adMostErrorListener) {
        errorListener = adMostErrorListener;
    }

    public static void setHTTPLogging(boolean z) {
        isHTTPLoggingEnabled = z;
    }

    static void setLogEnabled(boolean z) {
        isEnabled = z;
        AdMostPreferences.getInstance().setLogEnabled(Boolean.valueOf(z));
    }

    static void setLogEnabledFromOldValue() {
        isEnabled = AdMostPreferences.getInstance().isLogEnabled();
    }

    public static void setLogLevel(Level level) {
        if (level == null) {
            LOG_HANDLER.setLevel(Level.ALL);
        } else {
            LOG_HANDLER.setLevel(level);
        }
    }

    /* renamed from: v */
    public static void m301v(String str) {
        m302v(str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m303w(String str) {
        m304w(str, (Throwable) null);
    }

    public static void all(String str, Throwable th) {
        LOGGER.log(Level.FINEST, str, th);
    }

    public static void allError(String str, Throwable th) {
        LOGGER.log(Level.FINER, str, th);
    }

    /* renamed from: d */
    public static void m295d(String str, Throwable th) {
        LOGGER.log(Level.CONFIG, str, th);
    }

    /* renamed from: e */
    public static void m297e(String str, Throwable th) {
        m298e(str, th, false);
    }

    /* renamed from: i */
    public static void m300i(String str, Throwable th) {
        LOGGER.log(Level.INFO, str, th);
    }

    /* renamed from: v */
    public static void m302v(String str, Throwable th) {
        LOGGER.log(Level.FINE, str, th);
    }

    /* renamed from: w */
    public static void m304w(String str, Throwable th) {
        LOGGER.log(Level.WARNING, str, th);
    }

    /* renamed from: e */
    public static void m298e(String str, Throwable th, boolean z) {
        AdMostErrorListener adMostErrorListener;
        if (z && (adMostErrorListener = errorListener) != null && (th instanceof Exception)) {
            adMostErrorListener.onError((Exception) th);
        }
        LOGGER.log(Level.SEVERE, str, th);
    }

    public static void json(JSONObject jSONObject, String str) {
        json(jSONObject, str, (Level) null);
    }

    public static void json(JSONObject jSONObject, String str, Level level) {
        if (isHTTPLoggingEnabled) {
            if (jSONObject == null || jSONObject.length() <= 0) {
                jsonInternal("Empty JSON", (Throwable) null, level);
            }
            try {
                printFormattedJson(jSONObject.toString(2), str);
            } catch (JSONException unused) {
                jsonInternal("Invalid JSON", (Throwable) null, level);
            }
        }
    }

    public static void json(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            jsonInternal("Empty JSON", (Throwable) null, (Level) null);
        }
        try {
            printFormattedJson(jSONArray.toString(2), str);
        } catch (JSONException unused) {
            jsonInternal("Invalid JSON", (Throwable) null, (Level) null);
        }
    }
}
