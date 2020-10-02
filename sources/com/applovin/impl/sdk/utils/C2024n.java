package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.utils.n */
public class C2024n implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final int f6719a;

    /* renamed from: b */
    private final float f6720b;

    /* renamed from: c */
    private final SensorManager f6721c;

    /* renamed from: d */
    private final Sensor f6722d;

    /* renamed from: e */
    private final Sensor f6723e = this.f6721c.getDefaultSensor(4);

    /* renamed from: f */
    private final C1941j f6724f;

    /* renamed from: g */
    private float[] f6725g;

    /* renamed from: h */
    private float f6726h;

    public C2024n(C1941j jVar) {
        this.f6724f = jVar;
        SensorManager sensorManager = (SensorManager) jVar.mo8527E().getSystemService("sensor");
        this.f6721c = sensorManager;
        this.f6722d = sensorManager.getDefaultSensor(9);
        this.f6719a = ((Integer) jVar.mo8549a(C1841c.f6051ep)).intValue();
        this.f6720b = ((Float) jVar.mo8549a(C1841c.f6050eo)).floatValue();
        jVar.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        jVar.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void mo8806a() {
        this.f6721c.unregisterListener(this);
        if (((Boolean) this.f6724f.mo8526D().mo8302a(C1841c.f6048em)).booleanValue()) {
            this.f6721c.registerListener(this, this.f6722d, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f6719a));
        }
        if (((Boolean) this.f6724f.mo8526D().mo8302a(C1841c.f6049en)).booleanValue()) {
            this.f6721c.registerListener(this, this.f6723e, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f6719a));
        }
    }

    /* renamed from: b */
    public float mo8807b() {
        return this.f6726h;
    }

    /* renamed from: c */
    public float mo8808c() {
        float[] fArr = this.f6725g;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos((double) (fArr[2] / 9.81f)));
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f6721c.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo8806a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f6725g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f = this.f6726h * this.f6720b;
            this.f6726h = f;
            this.f6726h = f + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }
}
