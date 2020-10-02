package com.tapjoy.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;

/* renamed from: com.tapjoy.internal.cp */
public final class C4945cp extends ContentObserver {

    /* renamed from: a */
    public final Context f13434a;

    /* renamed from: b */
    public float f13435b;

    /* renamed from: c */
    private final AudioManager f13436c;

    /* renamed from: d */
    private final C4942cm f13437d;

    /* renamed from: e */
    private final C4944co f13438e;

    public C4945cp(Handler handler, Context context, C4942cm cmVar, C4944co coVar) {
        super(handler);
        this.f13434a = context;
        this.f13436c = (AudioManager) context.getSystemService("audio");
        this.f13437d = cmVar;
        this.f13438e = coVar;
    }

    /* renamed from: a */
    public final float mo31031a() {
        int streamVolume = this.f13436c.getStreamVolume(3);
        int streamMaxVolume = this.f13436c.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = ((float) streamVolume) / ((float) streamMaxVolume);
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    /* renamed from: b */
    public final void mo31032b() {
        this.f13438e.mo31030a(this.f13435b);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float a = mo31031a();
        if (a != this.f13435b) {
            this.f13435b = a;
            mo31032b();
        }
    }
}
