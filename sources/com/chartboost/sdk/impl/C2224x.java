package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.File;
import java.io.IOException;

/* renamed from: com.chartboost.sdk.impl.x */
public class C2224x {

    /* renamed from: b */
    private static C2224x f7489b = new C2224x(new Handler(Looper.getMainLooper()));

    /* renamed from: a */
    public final Handler f7490a;

    public C2224x(Handler handler) {
        this.f7490a = handler;
    }

    /* renamed from: e */
    public static C2224x m8805e() {
        return f7489b;
    }

    /* renamed from: a */
    public File mo9547a() {
        return Environment.getExternalStorageDirectory();
    }

    /* renamed from: b */
    public String mo9550b() {
        return Environment.getExternalStorageState();
    }

    /* renamed from: c */
    public String mo9551c() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: d */
    public boolean mo9552d() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: a */
    public boolean mo9548a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    public AdvertisingIdClient.Info mo9546a(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException, IllegalStateException {
        return AdvertisingIdClient.getAdvertisingIdInfo(context);
    }

    /* renamed from: a */
    public boolean mo9549a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }

    /* renamed from: a */
    public Bitmap mo9545a(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, (BitmapFactory.Options) null);
    }
}
