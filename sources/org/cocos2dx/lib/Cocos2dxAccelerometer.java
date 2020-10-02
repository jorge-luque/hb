package org.cocos2dx.lib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.view.WindowManager;

public class Cocos2dxAccelerometer implements SensorEventListener {
    static final float ALPHA = 0.25f;
    private static final String TAG = Cocos2dxAccelerometer.class.getSimpleName();
    final float[] accelerometerValues = new float[3];
    final float[] compassFieldValues = new float[3];
    private final Sensor mAccelerometer;
    private final Sensor mCompass;
    private final Context mContext;
    private final int mNaturalOrientation;
    private final SensorManager mSensorManager;

    public Cocos2dxAccelerometer(Context context) {
        this.mContext = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mAccelerometer = sensorManager.getDefaultSensor(1);
        this.mCompass = this.mSensorManager.getDefaultSensor(2);
        this.mNaturalOrientation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    public static native void onSensorChanged(float f, float f2, float f3, long j);

    public void disable() {
        this.mSensorManager.unregisterListener(this);
    }

    public void enableAccel() {
        this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
    }

    public void enableCompass() {
        this.mSensorManager.registerListener(this, this.mCompass, 1);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float[] fArr2 = this.accelerometerValues;
            fArr2[0] = f;
            fArr2[1] = f2;
            fArr2[2] = f3;
            int i = this.mContext.getResources().getConfiguration().orientation;
            if (i == 2 && this.mNaturalOrientation != 0) {
                float f4 = -f2;
                f2 = f;
                f = f4;
            } else if (i == 1 && this.mNaturalOrientation != 0) {
                float f5 = f2;
                f2 = -f;
                f = f5;
            }
            int rotation = Cocos2dxHelper.getActivity().getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 2 || rotation == 3) {
                f = -f;
                f2 = -f2;
            }
            Cocos2dxGLSurfaceView.queueAccelerometer(f, f2, f3, sensorEvent.timestamp);
        } else if (sensorEvent.sensor.getType() == 2) {
            float[] fArr3 = this.compassFieldValues;
            float[] fArr4 = sensorEvent.values;
            fArr3[0] = fArr4[0];
            fArr3[1] = fArr4[1];
            fArr3[2] = fArr4[2];
        }
    }

    public void setInterval(float f) {
        if (Build.VERSION.SDK_INT < 11) {
            this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
        } else {
            this.mSensorManager.registerListener(this, this.mAccelerometer, (int) (f * 1000000.0f));
        }
    }
}
