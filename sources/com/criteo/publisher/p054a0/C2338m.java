package com.criteo.publisher.p054a0;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.criteo.publisher.model.AdSize;

/* renamed from: com.criteo.publisher.a0.m */
public class C2338m {

    /* renamed from: c */
    private static AdSize f7702c = new AdSize(0, 0);

    /* renamed from: d */
    private static AdSize f7703d = new AdSize(0, 0);

    /* renamed from: a */
    private final Context f7704a;

    /* renamed from: b */
    private final C2322b f7705b;

    public C2338m(Context context, C2322b bVar) {
        this.f7704a = context;
        this.f7705b = bVar;
    }

    /* renamed from: h */
    private DisplayMetrics m8982h() {
        return this.f7704a.getResources().getDisplayMetrics();
    }

    /* renamed from: a */
    public void mo10154a() {
        try {
            DisplayMetrics h = m8982h();
            mo10155a(Math.round(((float) h.widthPixels) / h.density), Math.round(((float) h.heightPixels) / h.density));
        } catch (Exception e) {
            throw new Error("Screen parameters can not be empty or null", e);
        }
    }

    /* renamed from: b */
    public String mo10156b() {
        try {
            if (this.f7705b.mo10116b(this.f7704a)) {
                return "00000000-0000-0000-0000-000000000000";
            }
            return this.f7705b.mo10115a(this.f7704a);
        } catch (Exception e) {
            Log.e("DeviceUtil", "Error trying to get Advertising id: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public AdSize mo10157c() {
        return f7703d;
    }

    /* renamed from: d */
    public AdSize mo10158d() {
        return f7702c;
    }

    /* renamed from: e */
    public int mo10159e() {
        try {
            return this.f7705b.mo10116b(this.f7704a) ? 1 : 0;
        } catch (Exception e) {
            Log.e("DeviceUtil", "Error trying to check limited ad tracking: " + e.getMessage());
            return 0;
        }
    }

    /* renamed from: f */
    public boolean mo10160f() {
        DisplayMetrics h = m8982h();
        return ((float) Math.min(h.widthPixels, h.heightPixels)) >= h.density * 600.0f;
    }

    /* renamed from: g */
    public boolean mo10161g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        Log.e("ContentValues", "Unsupported Android version");
        return false;
    }

    /* renamed from: a */
    public void mo10155a(int i, int i2) {
        f7702c = new AdSize(i, i2);
        f7703d = new AdSize(i2, i);
    }
}
