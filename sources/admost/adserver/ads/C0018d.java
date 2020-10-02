package admost.adserver.ads;

import admost.adserver.core.C0049a;
import admost.adserver.core.C0051c;
import admost.adserver.core.C0055e;
import admost.sdk.base.AdMostAdNetwork;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.google.android.gms.drive.DriveFile;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;
import p030c.p031a.p032a.C1178a;
import p030c.p031a.p032a.C1180c;

/* renamed from: admost.adserver.ads.d */
/* compiled from: AdMostNativeAdImpl */
public class C0018d implements C0016b, View.OnClickListener {

    /* renamed from: a */
    private View f44a;

    /* renamed from: b */
    private TextView f45b;

    /* renamed from: c */
    private TextView f46c;

    /* renamed from: d */
    private TextView f47d;

    /* renamed from: e */
    private ImageView f48e;

    /* renamed from: f */
    private ImageView f49f;

    /* renamed from: g */
    private int[] f50g;

    /* renamed from: h */
    private int f51h = 0;

    /* renamed from: i */
    private Context f52i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C1178a f53j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C0017c f54k;

    /* renamed from: l */
    private String f55l;

    /* renamed from: m */
    private boolean f56m;

    /* renamed from: n */
    private boolean f57n;

    /* renamed from: admost.adserver.ads.d$a */
    /* compiled from: AdMostNativeAdImpl */
    class C0019a implements C1180c<JSONObject> {

        /* renamed from: a */
        final /* synthetic */ int f58a;

        C0019a(int i) {
            this.f58a = i;
        }

        /* renamed from: a */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.optInt("Type", 0) == 1) {
                        C0017c unused = C0018d.this.f54k = C0018d.this.m44a(jSONObject);
                        C0018d.this.f54k.f43i = this.f58a;
                        C0018d.this.m47a(C0018d.this.f54k);
                    } else if (C0018d.this.f53j != null) {
                        C0018d.this.f53j.onFail(100);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (C0018d.this.f53j != null) {
                        C0018d.this.f53j.onFail(101);
                    }
                }
            } else if (C0018d.this.f53j != null) {
                C0018d.this.f53j.onFail(100);
            }
        }

        public void onError(String str, Exception exc) {
            if (C0018d.this.f53j != null) {
                C0018d.this.f53j.onFail(101);
            }
        }
    }

    /* renamed from: admost.adserver.ads.d$b */
    /* compiled from: AdMostNativeAdImpl */
    class C0020b implements C1180c<Integer> {
        C0020b() {
        }

        /* renamed from: a */
        public void onResponse(Integer num) {
            if (num.intValue() != 0) {
                "icon downloadFile error. Response:" + num;
                if (C0018d.this.f53j != null) {
                    C0018d.this.f53j.onFail(104);
                }
            } else if (C0018d.this.f53j != null) {
                C0018d.this.f53j.onReady();
            }
        }

        public void onError(String str, Exception exc) {
            Log.e(AdMostAdNetwork.ADMOST, "downloadFile error! message : " + str);
            if (C0018d.this.f53j != null) {
                C0018d.this.f53j.onFail(104);
            }
        }
    }

    /* renamed from: admost.adserver.ads.d$c */
    /* compiled from: AdMostNativeAdImpl */
    class C0021c implements C1180c<Integer> {
        C0021c() {
        }

        /* renamed from: a */
        public void onResponse(Integer num) {
            if (num.intValue() != 0) {
                "downloadFile error. Response:" + num;
                if (C0018d.this.f53j != null) {
                    C0018d.this.f53j.onFail(104);
                }
            } else if (C0018d.this.f53j != null) {
                C0018d.this.f53j.onReady();
            }
        }

        public void onError(String str, Exception exc) {
            Log.e(AdMostAdNetwork.ADMOST, "downloadFile error! message : " + str + " , ex:" + exc);
            if (C0018d.this.f53j != null) {
                C0018d.this.f53j.onFail(104);
            }
        }
    }

    /* renamed from: admost.adserver.ads.d$d */
    /* compiled from: AdMostNativeAdImpl */
    class C0022d implements MediaPlayer.OnPreparedListener {
        C0022d() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(true);
                if (C0018d.this.mo46b()) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo39c(TextView textView) {
        this.f45b = textView;
    }

    public void destroy() {
        this.f51h = 0;
        View view = this.f44a;
        if (view instanceof VideoView) {
            ((VideoView) view).stopPlayback();
        }
        this.f53j = null;
        this.f52i = null;
        this.f44a = null;
        this.f45b = null;
        this.f46c = null;
        this.f47d = null;
        this.f48e = null;
        this.f49f = null;
    }

    public C0017c getData() {
        return this.f54k;
    }

    public void onClick(View view) {
        if (this.f50g != null && getData() != null) {
            int id = view.getId();
            int i = 0;
            while (true) {
                int[] iArr = this.f50g;
                if (i >= iArr.length) {
                    return;
                }
                if (id == iArr[i]) {
                    try {
                        if (id != this.f44a.getId() || !(this.f44a instanceof VideoView)) {
                            if (this.f48e != null && id == this.f48e.getId()) {
                                mo45a(view.getContext(), getData().f42h);
                                return;
                            } else if (id == this.f46c.getId() || id == this.f45b.getId() || id == this.f47d.getId() || id == this.f49f.getId() || id == this.f44a.getId()) {
                                mo44a();
                                return;
                            } else {
                                return;
                            }
                        } else if (((VideoView) this.f44a).isPlaying()) {
                            pause();
                            return;
                        } else {
                            resume();
                            return;
                        }
                    } catch (Exception unused) {
                        Log.w(AdMostAdNetwork.ADMOST, "Error: please check your native layout. There are some missing assets!");
                        return;
                    }
                } else {
                    i++;
                }
            }
        }
    }

    public void pause() {
        View view = this.f44a;
        if (view instanceof VideoView) {
            VideoView videoView = (VideoView) view;
            this.f51h = videoView.getCurrentPosition();
            videoView.pause();
        }
    }

    public void resume() {
        View view = this.f44a;
        if (view instanceof VideoView) {
            VideoView videoView = (VideoView) view;
            if (!videoView.isPlaying()) {
                videoView.seekTo(this.f51h);
                mo47c();
            }
        }
    }

    /* renamed from: c */
    public void mo47c() {
        View view = this.f44a;
        if (view instanceof VideoView) {
            VideoView videoView = (VideoView) view;
            if (!videoView.isPlaying()) {
                videoView.start();
            }
        }
    }

    /* renamed from: b */
    public C0023e mo36b(View view) {
        if (!this.f56m) {
            resume();
        }
        return new C0023e(this.f52i, view, this);
    }

    /* renamed from: a */
    public void mo31a(Context context, String str, Hashtable<String, Object> hashtable, int i, String str2, C1178a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f52i = applicationContext;
        this.f53j = aVar;
        this.f55l = str2;
        m48a(m46a(hashtable, str, applicationContext), i);
    }

    /* renamed from: b */
    public void mo37b(ImageView imageView) {
        this.f49f = imageView;
    }

    /* renamed from: b */
    public void mo38b(TextView textView) {
        this.f47d = textView;
    }

    /* renamed from: a */
    private void m48a(String str, int i) {
        new C0051c(C0051c.C0053b.ADMOST_ADSERVER_RESPONSE, "", new C0019a(i)).mo91a(this.f52i, str + "&ei=" + C0055e.m151a(this.f55l, "admostcrosspromo", C0055e.m154b()));
    }

    /* renamed from: b */
    public boolean mo46b() {
        return !this.f57n;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m47a(C0017c cVar) {
        if (cVar.f43i < 250) {
            C0055e.m152a(this.f52i, cVar.f35a, (C1180c<Integer>) new C0020b());
            return;
        }
        String str = cVar.f37c;
        String str2 = (str == null || str.isEmpty()) ? cVar.f36b : cVar.f37c;
        if ((str2 == null && str2.length() <= 0) || (!str2.contains("/") && this.f53j != null)) {
            this.f53j.onFail(103);
        } else if (!C0055e.m147a(this.f52i, str2).exists() || this.f53j == null) {
            C0055e.m152a(this.f52i, cVar.f35a, (C1180c<Integer>) null);
            C0055e.m152a(this.f52i, str2, (C1180c<Integer>) new C0021c());
        } else {
            this.f53j.onReady();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0017c m44a(JSONObject jSONObject) {
        C0017c cVar = new C0017c();
        jSONObject.optString("AdType", "");
        cVar.f41g = jSONObject.optString("CallToAction", "");
        cVar.f38d = jSONObject.optString("ClickUrl", "");
        cVar.f39e = jSONObject.optString("Detail", "");
        cVar.f40f = jSONObject.optString("Header", "");
        cVar.f35a = jSONObject.optString("IconUrl", "");
        jSONObject.optString("Type", "");
        cVar.f36b = jSONObject.optString("ImageUrl", "");
        cVar.f37c = jSONObject.optString("VideoUrl", "");
        return cVar;
    }

    /* renamed from: a */
    private String m46a(Hashtable<String, Object> hashtable, String str, Context context) {
        String str2;
        StringBuilder sb = new StringBuilder("?k=" + str);
        sb.append("&uId=");
        sb.append(C0049a.m124a(context).mo88b());
        sb.append("&w=1");
        sb.append("&channel=3");
        sb.append("&device_model=");
        sb.append(C0055e.m148a());
        sb.append("&os_version=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&gsm_op=");
        sb.append(C0055e.m157d(context));
        sb.append("&version=");
        sb.append(C0055e.m149a(context));
        sb.append(C0055e.m156c(context));
        if (hashtable != null && hashtable.size() > 0) {
            try {
                for (Map.Entry next : hashtable.entrySet()) {
                    Object value = next.getValue();
                    String str3 = "";
                    if (value != null) {
                        if (value instanceof String) {
                            str2 = URLEncoder.encode((String) value, "UTF8");
                        } else if (value instanceof Integer) {
                            str2 = value + str3;
                        }
                        str3 = str2;
                    }
                    sb.append("&");
                    sb.append(next.getKey());
                    sb.append("=");
                    sb.append(str3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo32a(View view) {
        this.f44a = view;
        if (view instanceof VideoView) {
            ((VideoView) view).setOnPreparedListener(new C0022d());
        }
    }

    /* renamed from: a */
    public void mo33a(ImageView imageView) {
        this.f48e = imageView;
    }

    /* renamed from: a */
    public void mo34a(TextView textView) {
        this.f46c = textView;
    }

    /* renamed from: a */
    public void mo35a(int[] iArr) {
        this.f50g = iArr;
        this.f44a.setOnClickListener(this);
        this.f45b.setOnClickListener(this);
        this.f46c.setOnClickListener(this);
        this.f47d.setOnClickListener(this);
        this.f49f.setOnClickListener(this);
        this.f48e.setOnClickListener(this);
    }

    /* renamed from: a */
    public void mo44a() {
        if (getData() != null) {
            mo45a(this.f52i, getData().f38d);
            C1178a aVar = this.f53j;
            if (aVar != null) {
                aVar.onClicked();
            }
        }
    }

    /* renamed from: a */
    public void mo45a(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                intent.addFlags(DriveFile.MODE_READ_ONLY);
                context.startActivity(intent);
            }
        }
    }
}
