package org.cocos2dx.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.android.vending.expansion.zipfile.APKExpansionSupport;
import com.android.vending.expansion.zipfile.ZipResourceFile;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class Cocos2dxHelper {
    private static final int BOOST_TIME = 7;
    public static final String PREFS_NAME = "Cocos2dxPrefsFile";
    private static final int RUNNABLES_PER_FRAME = 5;
    private static final String TAG = "Cocos2dxHelper";
    private static SharedPreferences.Editor editor = null;
    private static boolean needsToSaveSharedPreferences = false;
    private static Set<PreferenceManager.OnActivityResultListener> onActivityResultListeners = new LinkedHashSet();
    private static boolean sAccelerometerEnabled;
    private static Activity sActivity;
    private static boolean sActivityVisible;
    private static AssetManager sAssetManager;
    private static String sAssetsPath = "";
    private static Cocos2dxMusic sCocos2dMusic;
    private static Cocos2dxSound sCocos2dSound;
    private static Cocos2dxAccelerometer sCocos2dxAccelerometer;
    private static Cocos2dxHelperListener sCocos2dxHelperListener;
    private static boolean sCompassEnabled;
    private static boolean sInited = false;
    private static ZipResourceFile sOBBFile = null;
    private static String sPackageName;
    private static Vibrator sVibrateService = null;
    private static SharedPreferences settings;

    public interface Cocos2dxHelperListener {
        void runOnGLThread(Runnable runnable);

        void showDialog(String str, String str2);
    }

    public static void addOnActivityResultListener(PreferenceManager.OnActivityResultListener onActivityResultListener) {
        onActivityResultListeners.add(onActivityResultListener);
    }

    public static byte[] conversionEncoding(byte[] bArr, String str, String str2) {
        try {
            return new String(bArr, str).getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteValueForKey(String str) {
        editor.remove(str);
        needsToSaveSharedPreferences = true;
    }

    public static void disableAccelerometer() {
        sAccelerometerEnabled = false;
        getAccelerometer().disable();
    }

    public static void enableAccelerometer() {
        sAccelerometerEnabled = true;
        getAccelerometer().enableAccel();
    }

    public static void enableCompass() {
        sCompassEnabled = true;
        getAccelerometer().enableCompass();
    }

    public static void end() {
        sCocos2dMusic.end();
        getSound().end();
    }

    public static int fastLoading(int i) {
        return -1;
    }

    public static void flushSharedPreferences() {
        needsToSaveSharedPreferences = false;
        editor.apply();
    }

    public static float[] getAccelValue() {
        return getAccelerometer().accelerometerValues;
    }

    private static Cocos2dxAccelerometer getAccelerometer() {
        if (sCocos2dxAccelerometer == null) {
            sCocos2dxAccelerometer = new Cocos2dxAccelerometer(sActivity);
        }
        return sCocos2dxAccelerometer;
    }

    public static Activity getActivity() {
        return sActivity;
    }

    public static AssetManager getAssetManager() {
        return sAssetManager;
    }

    public static String getAssetsPath() {
        String str = "";
        if (sAssetsPath.equals(str)) {
            String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + sPackageName;
            String[] list = new File(str2).list(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith("main.") && str.endsWith(".obb");
                }
            });
            if (list != null && list.length > 0) {
                str = str2 + "/" + list[0];
            }
            if (new File(str).exists()) {
                sAssetsPath = str;
            } else {
                sAssetsPath = sActivity.getApplicationInfo().sourceDir;
            }
        }
        return sAssetsPath;
    }

    public static float getBackgroundMusicVolume() {
        return sCocos2dMusic.getBackgroundVolume();
    }

    public static boolean getBoolForKey(String str, boolean z) {
        try {
            return settings.getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            Object obj = settings.getAll().get(str);
            if (obj instanceof String) {
                return Boolean.parseBoolean(obj.toString());
            }
            if (obj instanceof Integer) {
                if (((Integer) obj).intValue() != 0) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Float)) {
                return z;
            } else {
                if (((Float) obj).floatValue() != 0.0f) {
                    return true;
                }
                return false;
            }
        }
    }

    public static String getCocos2dxPackageName() {
        return sPackageName;
    }

    public static String getCocos2dxWritablePath() {
        return sActivity.getFilesDir().getAbsolutePath();
    }

    public static float[] getCompassValue() {
        return getAccelerometer().compassFieldValues;
    }

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getDPI() {
        Display defaultDisplay;
        if (sActivity == null) {
            return -1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = sActivity.getWindowManager();
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return -1;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return (int) (displayMetrics.density * 160.0f);
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static double getDoubleForKey(String str, double d) {
        return (double) getFloatForKey(str, (float) d);
    }

    public static float getEffectsVolume() {
        return getSound().getEffectsVolume();
    }

    public static float getFloatForKey(String str, float f) {
        try {
            return settings.getFloat(str, f);
        } catch (Exception e) {
            e.printStackTrace();
            Object obj = settings.getAll().get(str);
            if (obj instanceof String) {
                return Float.parseFloat(obj.toString());
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
                return f;
            }
            return 1.0f;
        }
    }

    public static int getIntegerForKey(String str, int i) {
        try {
            return settings.getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            Object obj = settings.getAll().get(str);
            if (obj instanceof String) {
                return Integer.parseInt(obj.toString());
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            if (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
                return i;
            }
            return 1;
        }
    }

    public static long[] getObbAssetFileDescriptor(String str) {
        AssetFileDescriptor assetFileDescriptor;
        long[] jArr = new long[3];
        if (!(getObbFile() == null || (assetFileDescriptor = getObbFile().getAssetFileDescriptor(str)) == null)) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = assetFileDescriptor.getParcelFileDescriptor();
                jArr[0] = (long) ((Integer) parcelFileDescriptor.getClass().getMethod("getFd", new Class[0]).invoke(parcelFileDescriptor, new Object[0])).intValue();
                jArr[1] = assetFileDescriptor.getStartOffset();
                jArr[2] = assetFileDescriptor.getLength();
            } catch (NoSuchMethodException unused) {
                Log.e(TAG, "Accessing file descriptor directly from the OBB is only supported from Android 3.1 (API level 12) and above.");
            } catch (IllegalAccessException e) {
                Log.e(TAG, e.toString());
            } catch (InvocationTargetException e2) {
                Log.e(TAG, e2.toString());
            }
        }
        return jArr;
    }

    public static ZipResourceFile getObbFile() {
        if (sOBBFile == null) {
            int i = 1;
            try {
                i = Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(getCocos2dxPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            try {
                sOBBFile = APKExpansionSupport.getAPKExpansionZipFile(Cocos2dxActivity.getContext(), i, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return sOBBFile;
    }

    public static Set<PreferenceManager.OnActivityResultListener> getOnActivityResultListeners() {
        return onActivityResultListeners;
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    private static Cocos2dxSound getSound() {
        if (sCocos2dSound == null) {
            sCocos2dSound = new Cocos2dxSound(sActivity);
        }
        return sCocos2dSound;
    }

    public static String getStringForKey(String str, String str2) {
        try {
            return settings.getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return settings.getAll().get(str).toString();
        }
    }

    public static int getTemperature() {
        return -1;
    }

    public static String getVersion() {
        try {
            return Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(Cocos2dxActivity.getContext().getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void init(Activity activity) {
        Class<String> cls = String.class;
        sActivity = activity;
        sCocos2dxHelperListener = (Cocos2dxHelperListener) activity;
        if (!sInited) {
            boolean hasSystemFeature = activity.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            "isSupportLowLatency:" + hasSystemFeature;
            int i = 44100;
            int i2 = 192;
            if (Build.VERSION.SDK_INT >= 17) {
                AudioManager audioManager = (AudioManager) activity.getSystemService("audio");
                Class cls2 = AudioManager.class;
                String str = (String) Cocos2dxReflectionHelper.invokeInstanceMethod(audioManager, "getProperty", new Class[]{cls}, new Object[]{Cocos2dxReflectionHelper.getConstantValue(cls2, "PROPERTY_OUTPUT_SAMPLE_RATE")});
                String str2 = (String) Cocos2dxReflectionHelper.invokeInstanceMethod(audioManager, "getProperty", new Class[]{cls}, new Object[]{Cocos2dxReflectionHelper.getConstantValue(cls2, "PROPERTY_OUTPUT_FRAMES_PER_BUFFER")});
                try {
                    i = Integer.parseInt(str);
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "parseInt failed", e);
                }
                "sampleRate: " + i + ", framesPerBuffer: " + i2;
            }
            nativeSetAudioDeviceInfo(hasSystemFeature, i, i2);
            sPackageName = activity.getApplicationInfo().packageName;
            sCocos2dMusic = new Cocos2dxMusic(activity);
            AssetManager assets = activity.getAssets();
            sAssetManager = assets;
            nativeSetContext(activity, assets);
            Cocos2dxBitmap.setContext(activity);
            sVibrateService = (Vibrator) activity.getSystemService("vibrator");
            sInited = true;
            SharedPreferences sharedPreferences = sActivity.getSharedPreferences(PREFS_NAME, 0);
            settings = sharedPreferences;
            editor = sharedPreferences.edit();
        }
    }

    public static boolean isActivityVisible() {
        return sActivityVisible;
    }

    public static boolean isBackgroundMusicPlaying() {
        return sCocos2dMusic.isBackgroundMusicPlaying();
    }

    private static native void nativeSetAudioDeviceInfo(boolean z, int i, int i2);

    private static native void nativeSetContext(Context context, AssetManager assetManager);

    /* access modifiers changed from: private */
    public static native void nativeSetEditTextDialogResult(byte[] bArr);

    public static void onEnterBackground() {
        getSound().onEnterBackground();
        sCocos2dMusic.onEnterBackground();
    }

    public static void onEnterForeground() {
        getSound().onEnterForeground();
        sCocos2dMusic.onEnterForeground();
    }

    public static void onPause() {
        if (needsToSaveSharedPreferences) {
            needsToSaveSharedPreferences = false;
            SharedPreferences.Editor editor2 = editor;
            if (editor2 != null) {
                editor2.apply();
            }
        }
        sActivityVisible = false;
        if (sAccelerometerEnabled) {
            getAccelerometer().disable();
        }
    }

    public static void onResume() {
        sActivityVisible = true;
        if (sAccelerometerEnabled) {
            getAccelerometer().enableAccel();
        }
        if (sCompassEnabled) {
            getAccelerometer().enableCompass();
        }
    }

    public static boolean openURL(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            sActivity.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void pauseAllEffects() {
        getSound().pauseAllEffects();
    }

    public static void pauseBackgroundMusic() {
        sCocos2dMusic.pauseBackgroundMusic();
    }

    public static void pauseEffect(int i) {
        getSound().pauseEffect(i);
    }

    public static void playBackgroundMusic(String str, boolean z) {
        sCocos2dMusic.playBackgroundMusic(str, z);
    }

    public static int playEffect(String str, boolean z, float f, float f2, float f3) {
        return getSound().playEffect(str, z, f, f2, f3);
    }

    public static void preloadBackgroundMusic(String str) {
        sCocos2dMusic.preloadBackgroundMusic(str);
    }

    public static void preloadEffect(String str) {
        getSound().preloadEffect(str);
    }

    public static void resumeAllEffects() {
        getSound().resumeAllEffects();
    }

    public static void resumeBackgroundMusic() {
        sCocos2dMusic.resumeBackgroundMusic();
    }

    public static void resumeEffect(int i) {
        getSound().resumeEffect(i);
    }

    public static void rewindBackgroundMusic() {
        sCocos2dMusic.rewindBackgroundMusic();
    }

    public static void runOnGLThread(Runnable runnable) {
        ((Cocos2dxActivity) sActivity).runOnGLThread(runnable);
    }

    public static void setAccelerometerInterval(float f) {
        getAccelerometer().setInterval(f);
    }

    static void setAudioFocus(boolean z) {
        sCocos2dMusic.setAudioFocus(z);
        getSound().setAudioFocus(z);
    }

    public static void setBackgroundMusicVolume(float f) {
        sCocos2dMusic.setBackgroundVolume(f);
    }

    public static void setBoolForKey(String str, boolean z) {
        editor.putBoolean(str, z);
        needsToSaveSharedPreferences = true;
    }

    public static void setDoubleForKey(String str, double d) {
        editor.putFloat(str, (float) d);
        needsToSaveSharedPreferences = true;
    }

    public static void setEditTextDialogResult(String str) {
        try {
            final byte[] bytes = str.getBytes("UTF8");
            sCocos2dxHelperListener.runOnGLThread(new Runnable() {
                public void run() {
                    Cocos2dxHelper.nativeSetEditTextDialogResult(bytes);
                }
            });
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static void setEffectsVolume(float f) {
        getSound().setEffectsVolume(f);
    }

    public static int setFPS(int i) {
        return -1;
    }

    public static void setFloatForKey(String str, float f) {
        editor.putFloat(str, f);
        needsToSaveSharedPreferences = true;
    }

    public static void setIntegerForKey(String str, int i) {
        editor.putInt(str, i);
        needsToSaveSharedPreferences = true;
    }

    public static void setKeepScreenOn(boolean z) {
        ((Cocos2dxActivity) sActivity).setKeepScreenOn(z);
    }

    public static int setLowPowerMode(boolean z) {
        return -1;
    }

    public static int setResolutionPercent(int i) {
        return -1;
    }

    public static void setStringForKey(String str, String str2) {
        editor.putString(str, str2);
        needsToSaveSharedPreferences = true;
    }

    private static void showDialog(String str, String str2) {
        sCocos2dxHelperListener.showDialog(str, str2);
    }

    public static void stopAllEffects() {
        getSound().stopAllEffects();
    }

    public static void stopBackgroundMusic() {
        sCocos2dMusic.stopBackgroundMusic();
    }

    public static void stopEffect(int i) {
        getSound().stopEffect(i);
    }

    public static void terminateProcess() {
        Process.killProcess(Process.myPid());
    }

    public static void unloadEffect(String str) {
        getSound().unloadEffect(str);
    }

    public static void vibrate(float f) {
        sVibrateService.vibrate((long) (f * 1000.0f));
    }

    public static boolean willPlayBackgroundMusic() {
        return sCocos2dMusic.willPlayBackgroundMusic();
    }
}
