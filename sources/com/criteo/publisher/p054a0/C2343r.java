package com.criteo.publisher.p054a0;

import android.content.SharedPreferences;

/* renamed from: com.criteo.publisher.a0.r */
public class C2343r {

    /* renamed from: a */
    private final SharedPreferences f7708a;

    public C2343r(SharedPreferences sharedPreferences) {
        this.f7708a = sharedPreferences;
    }

    /* renamed from: a */
    public String mo10165a(String str, String str2) {
        try {
            return this.f7708a.getString(str, str2);
        } catch (ClassCastException e) {
            C2341p.m8996a((Throwable) new IllegalStateException("Expected a String type when reading: " + str, e));
            return str2;
        }
    }

    /* renamed from: a */
    public int mo10164a(String str, int i) {
        try {
            return this.f7708a.getInt(str, i);
        } catch (ClassCastException e) {
            C2341p.m8996a((Throwable) new IllegalStateException("Expect an int type when reading " + str, e));
            return i;
        }
    }

    /* renamed from: a */
    public boolean mo10166a(String str, boolean z) {
        try {
            return this.f7708a.getBoolean(str, z);
        } catch (ClassCastException e) {
            C2341p.m8996a((Throwable) new IllegalStateException("Expect an boolean type when reading " + str, e));
            return z;
        }
    }
}
