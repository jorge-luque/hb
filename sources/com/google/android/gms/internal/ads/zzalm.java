package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzalm extends zzalo {
    private static final zzaob zzdgk = new zzaob();
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzdgj;

    private final <NetworkExtrasT extends com.google.ads.mediation.NetworkExtras, ServerParametersT extends MediationServerParameters> zzalq zzdi(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzalm.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzamt(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.zzdgj.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzaml((com.google.android.gms.ads.mediation.MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } else {
                if (Adapter.class.isAssignableFrom(cls)) {
                    return new zzaml((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
                sb.append("Could not instantiate mediation adapter: ");
                sb.append(str);
                sb.append(" (not a valid adapter).");
                zzazw.zzfc(sb.toString());
                throw new RemoteException();
            }
        } catch (Throwable unused) {
            return zzdj(str);
        }
    }

    private final zzalq zzdj(String str) throws RemoteException {
        try {
            zzazw.zzed("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new zzaml((com.google.android.gms.ads.mediation.MediationAdapter) new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new zzaml((com.google.android.gms.ads.mediation.MediationAdapter) new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new zzaml((com.google.android.gms.ads.mediation.MediationAdapter) new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new zzamt(customEventAdapter, (CustomEventExtras) this.zzdgj.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            zzazw.zzd(sb.toString(), th);
        }
    }

    public final zzalq zzdg(String str) throws RemoteException {
        return zzdi(str);
    }

    public final boolean zzdh(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzalm.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            zzazw.zzfc(sb.toString());
            return false;
        }
    }

    public final zzanv zzdk(String str) throws RemoteException {
        return zzaob.zzds(str);
    }

    public final void zzf(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzdgj = map;
    }
}
