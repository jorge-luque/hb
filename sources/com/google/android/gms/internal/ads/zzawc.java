package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzawc {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Clock zzbnt;
    private final String zzdmj;
    @GuardedBy("lock")
    private boolean zzdnt = false;
    @GuardedBy("lock")
    private long zzdnx = -1;
    private final zzawo zzdtl;
    @GuardedBy("lock")
    private final LinkedList<zzawb> zzdtm;
    private final String zzdtn;
    @GuardedBy("lock")
    private long zzdto = -1;
    @GuardedBy("lock")
    private long zzdtp = -1;
    @GuardedBy("lock")
    private long zzdtq = 0;
    @GuardedBy("lock")
    private long zzdtr = -1;
    @GuardedBy("lock")
    private long zzdts = -1;

    zzawc(Clock clock, zzawo zzawo, String str, String str2) {
        this.zzbnt = clock;
        this.zzdtl = zzawo;
        this.zzdtn = str;
        this.zzdmj = str2;
        this.zzdtm = new LinkedList<>();
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzdtn);
            bundle.putString("slotid", this.zzdmj);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzdtr);
            bundle.putLong("tresponse", this.zzdts);
            bundle.putLong("timp", this.zzdto);
            bundle.putLong("tload", this.zzdtp);
            bundle.putLong("pcc", this.zzdtq);
            bundle.putLong("tfetch", this.zzdnx);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzdtm.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzawb) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzan(boolean z) {
        synchronized (this.lock) {
            if (this.zzdts != -1) {
                this.zzdtp = this.zzbnt.elapsedRealtime();
            }
        }
    }

    public final void zze(zzuj zzuj) {
        synchronized (this.lock) {
            long elapsedRealtime = this.zzbnt.elapsedRealtime();
            this.zzdtr = elapsedRealtime;
            this.zzdtl.zza(zzuj, elapsedRealtime);
        }
    }

    public final void zzey(long j) {
        synchronized (this.lock) {
            this.zzdts = j;
            if (j != -1) {
                this.zzdtl.zzb(this);
            }
        }
    }

    public final void zzvr() {
        synchronized (this.lock) {
            if (this.zzdts != -1 && this.zzdto == -1) {
                this.zzdto = this.zzbnt.elapsedRealtime();
                this.zzdtl.zzb(this);
            }
            this.zzdtl.zzvr();
        }
    }

    public final void zzvs() {
        synchronized (this.lock) {
            if (this.zzdts != -1) {
                zzawb zzawb = new zzawb(this);
                zzawb.zzvq();
                this.zzdtm.add(zzawb);
                this.zzdtq++;
                this.zzdtl.zzvs();
                this.zzdtl.zzb(this);
            }
        }
    }

    public final void zzvt() {
        synchronized (this.lock) {
            if (this.zzdts != -1 && !this.zzdtm.isEmpty()) {
                zzawb last = this.zzdtm.getLast();
                if (last.zzvo() == -1) {
                    last.zzvp();
                    this.zzdtl.zzb(this);
                }
            }
        }
    }

    public final String zzvu() {
        return this.zzdtn;
    }
}
