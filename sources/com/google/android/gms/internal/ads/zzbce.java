package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzq;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbce extends zzbbi implements TextureView.SurfaceTextureListener, zzbdc {
    private Surface zzbiu;
    private final zzbca zzeak;
    private final boolean zzeal;
    private int zzeaq;
    private int zzear;
    private int zzeat;
    private int zzeau;
    private zzbbv zzeav;
    private final boolean zzeaw;
    private zzbbf zzeay;
    private final zzbbx zzebj;
    private String[] zzebw;
    private final zzbby zzeet;
    private zzbcu zzeeu;
    private String zzeev;
    private boolean zzeew;
    private int zzeex = 1;
    private boolean zzeey;
    private boolean zzeez;
    private float zzefa;

    public zzbce(Context context, zzbca zzbca, zzbbx zzbbx, boolean z, boolean z2, zzbby zzbby) {
        super(context);
        this.zzeal = z2;
        this.zzebj = zzbbx;
        this.zzeak = zzbca;
        this.zzeaw = z;
        this.zzeet = zzbby;
        setSurfaceTextureListener(this);
        this.zzeak.zzb(this);
    }

    private final void zza(Surface surface, boolean z) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zza(surface, z);
        } else {
            zzazw.zzfc("Trying to set surface before player is initalized.");
        }
    }

    private final void zzaaa() {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaw(false);
        }
    }

    private final void zzo(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzefa != f) {
            this.zzefa = f;
            requestLayout();
        }
    }

    private final zzbcu zzzs() {
        return new zzbcu(this.zzebj.getContext(), this.zzeet);
    }

    private final String zzzt() {
        return zzq.zzkw().zzr(this.zzebj.getContext(), this.zzebj.zzzk().zzbnd);
    }

    private final boolean zzzu() {
        return this.zzeeu != null && !this.zzeew;
    }

    private final boolean zzzv() {
        return zzzu() && this.zzeex != 1;
    }

    private final void zzzw() {
        String str;
        if (this.zzeeu == null && (str = this.zzeev) != null && this.zzbiu != null) {
            if (str.startsWith("cache:")) {
                zzbdl zzfh = this.zzebj.zzfh(this.zzeev);
                if (zzfh instanceof zzbea) {
                    zzbcu zzaan = ((zzbea) zzfh).zzaan();
                    this.zzeeu = zzaan;
                    if (zzaan.zzaah() == null) {
                        zzazw.zzfc("Precached video player has been released.");
                        return;
                    }
                } else if (zzfh instanceof zzbdx) {
                    zzbdx zzbdx = (zzbdx) zzfh;
                    String zzzt = zzzt();
                    ByteBuffer byteBuffer = zzbdx.getByteBuffer();
                    boolean zzaal = zzbdx.zzaal();
                    String url = zzbdx.getUrl();
                    if (url == null) {
                        zzazw.zzfc("Stream cache URL is null.");
                        return;
                    }
                    zzbcu zzzs = zzzs();
                    this.zzeeu = zzzs;
                    zzzs.zza(new Uri[]{Uri.parse(url)}, zzzt, byteBuffer, zzaal);
                } else {
                    String valueOf = String.valueOf(this.zzeev);
                    zzazw.zzfc(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzeeu = zzzs();
                String zzzt2 = zzzt();
                Uri[] uriArr = new Uri[this.zzebw.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzebw;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzeeu.zza(uriArr, zzzt2);
            }
            this.zzeeu.zza((zzbdc) this);
            zza(this.zzbiu, false);
            int playbackState = this.zzeeu.zzaah().getPlaybackState();
            this.zzeex = playbackState;
            if (playbackState == 3) {
                zzzx();
            }
        }
    }

    private final void zzzx() {
        if (!this.zzeey) {
            this.zzeey = true;
            zzaxa.zzdwf.post(new zzbcd(this));
            zzyo();
            this.zzeak.zzfa();
            if (this.zzeez) {
                play();
            }
        }
    }

    private final void zzzy() {
        zzo(this.zzeaq, this.zzear);
    }

    private final void zzzz() {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaw(true);
        }
    }

    public final int getCurrentPosition() {
        if (zzzv()) {
            return (int) this.zzeeu.zzaah().zzem();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzzv()) {
            return (int) this.zzeeu.zzaah().getDuration();
        }
        return 0;
    }

    public final int getVideoHeight() {
        return this.zzear;
    }

    public final int getVideoWidth() {
        return this.zzeaq;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a A[LOOP:0: B:30:0x007a->B:35:0x0095, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.zzefa
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbbv r2 = r10.zzeav
            if (r2 != 0) goto L_0x002a
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            float r0 = r10.zzefa
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x002a
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x002a:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzbbv r0 = r10.zzeav
            if (r0 == 0) goto L_0x0034
            r0.zzm(r11, r12)
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a2
            int r0 = r10.zzeat
            if (r0 <= 0) goto L_0x0040
            if (r0 != r11) goto L_0x0046
        L_0x0040:
            int r0 = r10.zzeau
            if (r0 <= 0) goto L_0x009e
            if (r0 == r12) goto L_0x009e
        L_0x0046:
            boolean r0 = r10.zzeal
            if (r0 == 0) goto L_0x009e
            boolean r0 = r10.zzzu()
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzbcu r0 = r10.zzeeu
            com.google.android.gms.internal.ads.zzgt r0 = r0.zzaah()
            long r2 = r0.zzem()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x009e
            boolean r2 = r0.zzek()
            if (r2 == 0) goto L_0x0067
            goto L_0x009e
        L_0x0067:
            r2 = 1
            r10.zza((float) r1, (boolean) r2)
            r0.zzg(r2)
            long r1 = r0.zzem()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzq.zzld()
            long r3 = r3.currentTimeMillis()
        L_0x007a:
            boolean r5 = r10.zzzu()
            if (r5 == 0) goto L_0x0097
            long r5 = r0.zzem()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0097
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzq.zzld()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x007a
        L_0x0097:
            r1 = 0
            r0.zzg(r1)
            r10.zzyo()
        L_0x009e:
            r10.zzeat = r11
            r10.zzeau = r12
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbce.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzeaw) {
            zzbbv zzbbv = new zzbbv(getContext());
            this.zzeav = zzbbv;
            zzbbv.zza(surfaceTexture, i, i2);
            this.zzeav.start();
            SurfaceTexture zzzc = this.zzeav.zzzc();
            if (zzzc != null) {
                surfaceTexture = zzzc;
            } else {
                this.zzeav.zzzb();
                this.zzeav = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzbiu = surface;
        if (this.zzeeu == null) {
            zzzw();
        } else {
            zza(surface, true);
            if (!this.zzeet.zzedr) {
                zzzz();
            }
        }
        if (this.zzeaq == 0 || this.zzear == 0) {
            zzo(i, i2);
        } else {
            zzzy();
        }
        zzaxa.zzdwf.post(new zzbck(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzzb();
            this.zzeav = null;
        }
        if (this.zzeeu != null) {
            zzaaa();
            Surface surface = this.zzbiu;
            if (surface != null) {
                surface.release();
            }
            this.zzbiu = null;
            zza((Surface) null, true);
        }
        zzaxa.zzdwf.post(new zzbcm(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzm(i, i2);
        }
        zzaxa.zzdwf.post(new zzbcj(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeak.zzc(this);
        this.zzebg.zza(surfaceTexture, this.zzeay);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzawr.zzeg(sb.toString());
        zzaxa.zzdwf.post(new zzbcl(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void pause() {
        if (zzzv()) {
            if (this.zzeet.zzedr) {
                zzaaa();
            }
            this.zzeeu.zzaah().zzg(false);
            this.zzeak.zzzq();
            this.zzebh.zzzq();
            zzaxa.zzdwf.post(new zzbch(this));
        }
    }

    public final void play() {
        if (zzzv()) {
            if (this.zzeet.zzedr) {
                zzzz();
            }
            this.zzeeu.zzaah().zzg(true);
            this.zzeak.zzzp();
            this.zzebh.zzzp();
            this.zzebg.zzyq();
            zzaxa.zzdwf.post(new zzbci(this));
            return;
        }
        this.zzeez = true;
    }

    public final void seekTo(int i) {
        if (zzzv()) {
            this.zzeeu.zzaah().seekTo((long) i);
        }
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzeev = str;
            this.zzebw = new String[]{str};
            zzzw();
        }
    }

    public final void stop() {
        if (zzzu()) {
            this.zzeeu.zzaah().stop();
            if (this.zzeeu != null) {
                zza((Surface) null, true);
                zzbcu zzbcu = this.zzeeu;
                if (zzbcu != null) {
                    zzbcu.zza((zzbdc) null);
                    this.zzeeu.release();
                    this.zzeeu = null;
                }
                this.zzeex = 1;
                this.zzeew = false;
                this.zzeey = false;
                this.zzeez = false;
            }
        }
        this.zzeak.zzzq();
        this.zzebh.zzzq();
        this.zzeak.onStop();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaab() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzys();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaac() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzyp();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaad() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaae() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzyq();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaaf() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzyr();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaag() {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzfa();
        }
    }

    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzeev = str;
            this.zzebw = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzzw();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzebj.zza(z, j);
    }

    public final void zzde(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdl(i);
        }
    }

    public final void zzdf(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdm(i);
        }
    }

    public final void zzdg(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdg(i);
        }
    }

    public final void zzdh(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzaak().zzdh(i);
        }
    }

    public final void zzdi(int i) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzdi(i);
        }
    }

    public final void zzdj(int i) {
        if (this.zzeex != i) {
            this.zzeex = i;
            if (i == 3) {
                zzzx();
            } else if (i == 4) {
                if (this.zzeet.zzedr) {
                    zzaaa();
                }
                this.zzeak.zzzq();
                this.zzebh.zzzq();
                zzaxa.zzdwf.post(new zzbcg(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdk(int i) {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfi(String str) {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzm("ExoPlayerAdapter error", str);
        }
    }

    public final void zzn(int i, int i2) {
        this.zzeaq = i;
        this.zzear = i2;
        zzzy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i, int i2) {
        zzbbf zzbbf = this.zzeay;
        if (zzbbf != null) {
            zzbbf.zzk(i, i2);
        }
    }

    public final String zzyk() {
        String str = this.zzeaw ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    public final void zzyo() {
        zza(this.zzebh.getVolume(), false);
    }

    private final void zza(float f, boolean z) {
        zzbcu zzbcu = this.zzeeu;
        if (zzbcu != null) {
            zzbcu.zzb(f, z);
        } else {
            zzazw.zzfc("Trying to set volume before player is initalized.");
        }
    }

    public final void zzb(boolean z, long j) {
        if (this.zzebj != null) {
            zzbab.zzdzv.execute(new zzbco(this, z, j));
        }
    }

    public final void zza(zzbbf zzbbf) {
        this.zzeay = zzbbf;
    }

    public final void zza(float f, float f2) {
        zzbbv zzbbv = this.zzeav;
        if (zzbbv != null) {
            zzbbv.zzb(f, f2);
        }
    }

    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzazw.zzfc(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeew = true;
        if (this.zzeet.zzedr) {
            zzaaa();
        }
        zzaxa.zzdwf.post(new zzbcf(this, sb2));
    }
}
