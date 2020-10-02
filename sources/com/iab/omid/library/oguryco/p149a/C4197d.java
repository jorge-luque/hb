package com.iab.omid.library.oguryco.p149a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* renamed from: com.iab.omid.library.oguryco.a.d */
public final class C4197d extends ContentObserver {

    /* renamed from: a */
    private final Context f11261a;

    /* renamed from: b */
    private final AudioManager f11262b;

    /* renamed from: c */
    private final C4194a f11263c;

    /* renamed from: d */
    private final C4196c f11264d;

    /* renamed from: e */
    private float f11265e;

    public C4197d(Handler handler, Context context, C4194a aVar, C4196c cVar) {
        super(handler);
        this.f11261a = context;
        this.f11262b = (AudioManager) context.getSystemService("audio");
        this.f11263c = aVar;
        this.f11264d = cVar;
    }

    /* renamed from: a */
    private boolean m14104a(float f) {
        return f != this.f11265e;
    }

    /* renamed from: c */
    private float m14105c() {
        return this.f11263c.mo28617a(this.f11262b.getStreamVolume(3), this.f11262b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m14106d() {
        this.f11264d.mo28619a(this.f11265e);
    }

    /* renamed from: a */
    public final void mo28620a() {
        this.f11265e = m14105c();
        m14106d();
        this.f11261a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public final void mo28621b() {
        this.f11261a.getContentResolver().unregisterContentObserver(this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float c = m14105c();
        if (m14104a(c)) {
            this.f11265e = c;
            m14106d();
        }
    }
}
