package com.miniclip.mcgoliath;

import android.content.Context;
import com.miniclip.framework.AbstractActivityListener;
import com.miniclip.framework.Miniclip;
import java.io.File;
import java.io.PrintStream;

public class MCGoliath extends AbstractActivityListener {
    public static String goliathFile = "mcgoliath_info.goliath";
    private int goliathInstanceID;

    public MCGoliath(String str, String str2, String str3, String str4, String str5, String str6) {
        this.goliathInstanceID = -1;
        this.goliathInstanceID = newGoliath(str, str2, str3, str4, str5, str6);
        PrintStream printStream = System.out;
        printStream.println("New Goliath (" + this.goliathInstanceID + ")");
    }

    private static native String goliathApiKey(int i);

    private static native String goliathGameID(int i);

    private static native String goliathHmacKey(int i);

    private static native String goliathHost(int i);

    private static native int goliathMaxNumberOfEventsPerPackage(int i);

    private static native String goliathPathForSaveFile(int i);

    private static native int goliathSerializationInterval(int i);

    private static native int goliathTransmissionInterval(int i);

    private static native String goliathVersion(int i);

    private static native int newGoliath(String str, String str2, String str3, String str4, String str5, String str6);

    private static native void postEventToGoliath(int i, String str, String str2);

    private static native void setGoliathApiKey(int i, String str);

    private static native void setGoliathGameID(int i, String str);

    private static native void setGoliathHmacKey(int i, String str);

    private static native void setGoliathHost(int i, String str);

    private static native void setGoliathMaxNumberOfEventsPerPackage(int i, int i2);

    private static native void setGoliathPathForSaveFile(int i, String str);

    private static native void setGoliathSerializationInterval(int i, int i2);

    private static native void setGoliathTransmissionInterval(int i, int i2);

    private static native void setGoliathVersion(int i, String str);

    private static native void startGoliath(int i);

    private static native void stopGoliath(int i);

    public String getApiKey() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathApiKey(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return null;
    }

    public String getGameID() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathGameID(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return null;
    }

    public String getHmacKey() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathHmacKey(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return null;
    }

    public String getHost() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathHost(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return null;
    }

    public int getMaxNumberOfEventsPerPackage() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathMaxNumberOfEventsPerPackage(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return -1;
    }

    public String getPathForSaveFile() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathPathForSaveFile(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return null;
    }

    public int getSerializationInterval() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathSerializationInterval(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return -1;
    }

    public int getTransmissionInterval() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathTransmissionInterval(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return -1;
    }

    public String getVersion() {
        int i = this.goliathInstanceID;
        if (i >= 0) {
            return goliathVersion(i);
        }
        System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        return null;
    }

    public void init() {
        Miniclip.addListener(this);
    }

    public void onStart() {
        start();
    }

    public void onStop() {
        stop();
    }

    public void postEvent(String str, String str2) {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            postEventToGoliath(i, str, str2);
        }
    }

    public void setApiKey(String str) {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathApiKey(i, str);
        }
    }

    public void setGameID(String str) {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathGameID(i, str);
        }
    }

    public void setHmacKey(String str) {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathHmacKey(i, str);
        }
    }

    public void setHost(String str) {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathHost(i, str);
        }
    }

    public void setMaxNumberOfEventsPerPackage(int i) {
        int i2 = this.goliathInstanceID;
        if (i2 < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathMaxNumberOfEventsPerPackage(i2, i);
        }
    }

    public void setPathForSaveFile(String str) {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathPathForSaveFile(i, str);
        }
    }

    public void setSerializationInterval(int i) {
        int i2 = this.goliathInstanceID;
        if (i2 < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathSerializationInterval(i2, i);
        }
    }

    public void setTransmissionInterval(int i) {
        int i2 = this.goliathInstanceID;
        if (i2 < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathTransmissionInterval(i2, i);
        }
    }

    public void setVersion(String str) {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
        } else {
            setGoliathVersion(i, str);
        }
    }

    public boolean start() {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
            return false;
        }
        startGoliath(i);
        return true;
    }

    public boolean stop() {
        int i = this.goliathInstanceID;
        if (i < 0) {
            System.out.println("ERROR: Cannot access MCGoliath: it was not properly initialized!");
            return false;
        }
        stopGoliath(i);
        return true;
    }

    public MCGoliath(String str, String str2, String str3, String str4, String str5, Context context) {
        this.goliathInstanceID = -1;
        if (context == null) {
            System.out.println("MCGoliath ERROR: Could not create MCGoliath --> Context was null.");
            return;
        }
        init();
        this.goliathInstanceID = newGoliath(str, str2, str3, str4, str5, new File(context.getCacheDir(), goliathFile).getPath());
        PrintStream printStream = System.out;
        printStream.println("New Goliath (" + this.goliathInstanceID + ") at path: " + getPathForSaveFile());
        start();
    }

    public MCGoliath(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, (Context) Miniclip.getActivity());
    }
}
