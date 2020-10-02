package com.applovin.impl.sdk.p050b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.b.f */
public final class C1844f {

    /* renamed from: a */
    private static SharedPreferences f6115a;

    /* renamed from: b */
    private final SharedPreferences f6116b;

    public C1844f(C1941j jVar) {
        this.f6116b = jVar.mo8527E().getSharedPreferences("com.applovin.sdk.preferences." + jVar.mo8599t(), 0);
    }

    /* renamed from: a */
    private static SharedPreferences m7055a(Context context) {
        if (f6115a == null) {
            f6115a = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f6115a;
    }

    /* renamed from: a */
    public static <T> T m7056a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        T t2;
        long j;
        int i;
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    t2 = Boolean.valueOf(t != null ? sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()) : sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    t2 = Float.valueOf(t != null ? sharedPreferences.getFloat(str, ((Float) t).floatValue()) : sharedPreferences.getFloat(str, 0.0f));
                } else if (cls3.equals(cls)) {
                    if (t != null) {
                        i = sharedPreferences.getInt(str, t.getClass().equals(cls2) ? ((Long) t).intValue() : ((Integer) t).intValue());
                    } else {
                        i = sharedPreferences.getInt(str, 0);
                    }
                    t2 = Integer.valueOf(i);
                } else if (cls2.equals(cls)) {
                    if (t != null) {
                        j = sharedPreferences.getLong(str, t.getClass().equals(cls3) ? ((Integer) t).longValue() : ((Long) t).longValue());
                    } else {
                        j = sharedPreferences.getLong(str, 0);
                    }
                    t2 = Long.valueOf(j);
                } else {
                    t2 = String.class.equals(cls) ? sharedPreferences.getString(str, (String) t) : Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) t) : t;
                }
                if (t2 != null) {
                    return cls.cast(t2);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t;
        } catch (Throwable th) {
            C1977q.m7747c("SharedPreferencesManager", "Error getting value for key: " + str, th);
            return t;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: a */
    public static <T> void m7057a(C1843e<T> eVar, Context context) {
        m7055a(context).edit().remove(eVar.mo8312a()).apply();
    }

    /* renamed from: a */
    public static <T> void m7058a(C1843e<T> eVar, T t, Context context) {
        m7059a(eVar.mo8312a(), t, m7055a(context), (SharedPreferences.Editor) null);
    }

    /* renamed from: a */
    private static <T> void m7059a(String str, T t, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z = true;
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        } else if (t instanceof String) {
            editor.putString(str, (String) t);
        } else if (t instanceof Set) {
            editor.putStringSet(str, (Set) t);
        } else {
            C1977q.m7751i("SharedPreferencesManager", "Unable to put default value of invalid type: " + t);
            z = false;
        }
        if (z && !z2) {
            editor.apply();
        }
    }

    /* renamed from: b */
    public static <T> T m7060b(C1843e<T> eVar, T t, Context context) {
        return m7056a(eVar.mo8312a(), t, (Class) eVar.mo8313b(), m7055a(context));
    }

    /* renamed from: a */
    public void mo8315a(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().clear().apply();
    }

    /* renamed from: a */
    public <T> void mo8316a(C1843e<T> eVar) {
        this.f6116b.edit().remove(eVar.mo8312a()).apply();
    }

    /* renamed from: a */
    public <T> void mo8317a(C1843e<T> eVar, T t) {
        mo8318a(eVar, t, this.f6116b);
    }

    /* renamed from: a */
    public <T> void mo8318a(C1843e<T> eVar, T t, SharedPreferences sharedPreferences) {
        mo8320a(eVar.mo8312a(), t, sharedPreferences);
    }

    /* renamed from: a */
    public <T> void mo8319a(String str, T t, SharedPreferences.Editor editor) {
        m7059a(str, t, (SharedPreferences) null, editor);
    }

    /* renamed from: a */
    public <T> void mo8320a(String str, T t, SharedPreferences sharedPreferences) {
        m7059a(str, t, sharedPreferences, (SharedPreferences.Editor) null);
    }

    /* renamed from: b */
    public <T> T mo8321b(C1843e<T> eVar, T t) {
        return mo8322b(eVar, t, this.f6116b);
    }

    /* renamed from: b */
    public <T> T mo8322b(C1843e<T> eVar, T t, SharedPreferences sharedPreferences) {
        return m7056a(eVar.mo8312a(), t, (Class) eVar.mo8313b(), sharedPreferences);
    }
}
