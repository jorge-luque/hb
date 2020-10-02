package com.tapjoy.internal;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.EOFException;

/* renamed from: com.tapjoy.internal.ix */
final class C5217ix implements C5211it {

    /* renamed from: a */
    public final C5209ir f14325a = new C5209ir();

    /* renamed from: b */
    public final C5223jc f14326b;

    /* renamed from: c */
    boolean f14327c;

    C5217ix(C5223jc jcVar) {
        if (jcVar != null) {
            this.f14326b = jcVar;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final void mo31392a(long j) {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f14327c) {
            while (true) {
                C5209ir irVar = this.f14325a;
                if (irVar.f14311b < j) {
                    if (this.f14326b.mo31394b(irVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                throw new EOFException();
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: b */
    public final long mo31394b(C5209ir irVar, long j) {
        if (irVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f14327c) {
            C5209ir irVar2 = this.f14325a;
            if (irVar2.f14311b == 0 && this.f14326b.mo31394b(irVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return this.f14325a.mo31394b(irVar, Math.min(j, this.f14325a.f14311b));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: c */
    public final byte mo31400c() {
        mo31392a(1);
        return this.f14325a.mo31400c();
    }

    public final void close() {
        if (!this.f14327c) {
            this.f14327c = true;
            this.f14326b.close();
            C5209ir irVar = this.f14325a;
            try {
                irVar.mo31407d(irVar.f14311b);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* renamed from: d */
    public final void mo31407d(long j) {
        if (!this.f14327c) {
            while (j > 0) {
                C5209ir irVar = this.f14325a;
                if (irVar.f14311b == 0 && this.f14326b.mo31394b(irVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f14325a.f14311b);
                this.f14325a.mo31407d(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: e */
    public final int mo31408e() {
        mo31392a(4);
        return C5226je.m17565a(this.f14325a.mo31405d());
    }

    /* renamed from: f */
    public final long mo31412f() {
        mo31392a(8);
        return this.f14325a.mo31412f();
    }

    public final String toString() {
        return "buffer(" + this.f14326b + ")";
    }

    /* renamed from: c */
    public final String mo31402c(long j) {
        mo31392a(j);
        return this.f14325a.mo31402c(j);
    }

    /* renamed from: b */
    public final boolean mo31399b() {
        if (!this.f14327c) {
            return this.f14325a.mo31399b() && this.f14326b.mo31394b(this.f14325a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C5212iu mo31398b(long j) {
        mo31392a(j);
        return this.f14325a.mo31398b(j);
    }
}
