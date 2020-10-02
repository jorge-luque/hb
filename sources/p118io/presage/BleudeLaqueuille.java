package p118io.presage;

import android.app.Activity;

/* renamed from: io.presage.BleudeLaqueuille */
public final class BleudeLaqueuille implements Bethmale {

    /* renamed from: a */
    private final VacherinSuisse f16381a;

    /* renamed from: b */
    private final Activity f16382b;

    /* renamed from: c */
    private final Bethmale f16383c;

    public BleudeLaqueuille(VacherinSuisse vacherinSuisse, Activity activity, Bethmale bethmale) {
        this.f16381a = vacherinSuisse;
        this.f16382b = activity;
        this.f16383c = bethmale;
    }

    /* renamed from: a */
    public final void mo34454a(CamembertdeNormandie camembertdeNormandie, AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
        camembertdeNormandie.mo34472a();
        camembertdeNormandie.setEnableDrag(true);
        VacherinSuisse vacherinSuisse = this.f16381a;
        if (vacherinSuisse != null) {
            vacherinSuisse.mo34726a(camembertdeNormandie);
        }
        abbayedeCiteauxentiere.mo34388e();
        this.f16382b.finish();
        abbayedeCiteauxentiere.mo34384b(this.f16383c);
        camembertdeNormandie.mo34474b();
        abbayedeCiteauxentiere.mo34378a((Bethmale) new BleudesCausses());
    }
}
