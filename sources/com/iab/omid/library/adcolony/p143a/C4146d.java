package com.iab.omid.library.adcolony.p143a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* renamed from: com.iab.omid.library.adcolony.a.d */
public final class C4146d extends ContentObserver {

    /* renamed from: a */
    private final Context f11108a;

    /* renamed from: b */
    private final AudioManager f11109b;

    /* renamed from: c */
    private final C4143a f11110c;

    /* renamed from: d */
    private final C4145c f11111d;

    /* renamed from: e */
    private float f11112e;

    public C4146d(Handler handler, Context context, C4143a aVar, C4145c cVar) {
        super(handler);
        this.f11108a = context;
        this.f11109b = (AudioManager) context.getSystemService("audio");
        this.f11110c = aVar;
        this.f11111d = cVar;
    }

    /* renamed from: a */
    private boolean m13875a(float f) {
        return f != this.f11112e;
    }

    /* renamed from: c */
    private float m13876c() {
        return this.f11110c.mo28429a(this.f11109b.getStreamVolume(3), this.f11109b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m13877d() {
        this.f11111d.mo28431a(this.f11112e);
    }

    /* renamed from: a */
    public void mo28432a() {
        this.f11112e = m13876c();
        m13877d();
        this.f11108a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public void mo28433b() {
        this.f11108a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float c = m13876c();
        if (m13875a(c)) {
            this.f11112e = c;
            m13877d();
        }
    }
}
