package com.qumpara.offerwall.sdk.core;

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

public class QumparaOfferwallLog {
    private static final Logger LOGGER = Logger.getLogger("com.qumpara");
    private static final String LOGTAG = "QUMPARA_OFFERWALL";
    private static final QumparaLogHandler LOG_HANDLER = new QumparaLogHandler();
    private static boolean isEnabled = false;
    private static boolean isHTTPLoggingEnabled;

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

    private static final class QumparaLogHandler extends Handler {
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

        private QumparaLogHandler() {
        }

        public void close() {
        }

        public void flush() {
        }

        public boolean isLoggable(LogRecord logRecord) {
            if (logRecord.getLevel() == Level.FINEST || logRecord.getLevel() == Level.FINER) {
                return true;
            }
            if (!QumparaOfferwallLog.isEnabled() || !super.isLoggable(logRecord)) {
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
                Log.println(intValue, QumparaOfferwallLog.LOGTAG, str);
            }
        }
    }

    static {
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.ALL);
        LOG_HANDLER.setLevel(Level.FINE);
        LogManager.getLogManager().addLogger(LOGGER);
        addHandler(LOGGER, LOG_HANDLER);
    }

    private QumparaOfferwallLog() {
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
    public static void m16485d(String str) {
        m16486d(str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m16487e(String str) {
        m16488e(str, (Throwable) null);
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
    public static void m16490i(String str) {
        m16491i(str, (Throwable) null);
    }

    public static boolean isAdNetworkLogsEnabled() {
        return isEnabled();
    }

    public static boolean isEnabled() {
        return isEnabled;
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
        m16490i(str);
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

    public static void setEnabled() {
        isEnabled = true;
    }

    public static void setHTTPLogging(boolean z) {
        isHTTPLoggingEnabled = z;
    }

    public static void setLogLevel(Level level) {
        if (level == null) {
            LOG_HANDLER.setLevel(Level.ALL);
        } else {
            LOG_HANDLER.setLevel(level);
        }
    }

    /* renamed from: v */
    public static void m16492v(String str) {
        m16493v(str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m16494w(String str) {
        m16495w(str, (Throwable) null);
    }

    public static void all(String str, Throwable th) {
        LOGGER.log(Level.FINEST, str, th);
    }

    public static void allError(String str, Throwable th) {
        LOGGER.log(Level.FINER, str, th);
    }

    /* renamed from: d */
    public static void m16486d(String str, Throwable th) {
        LOGGER.log(Level.CONFIG, str, th);
    }

    /* renamed from: e */
    public static void m16488e(String str, Throwable th) {
        m16489e(str, th, false);
    }

    /* renamed from: i */
    public static void m16491i(String str, Throwable th) {
        LOGGER.log(Level.INFO, str, th);
    }

    /* renamed from: v */
    public static void m16493v(String str, Throwable th) {
        LOGGER.log(Level.FINE, str, th);
    }

    /* renamed from: w */
    public static void m16495w(String str, Throwable th) {
        LOGGER.log(Level.WARNING, str, th);
    }

    /* renamed from: e */
    public static void m16489e(String str, Throwable th, boolean z) {
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
