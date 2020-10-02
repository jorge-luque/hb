package p118io.branch.indexing;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C5997f;
import p118io.branch.referral.C6028l;
import p118io.branch.referral.util.ContentMetadata;
import p118io.branch.referral.util.LinkProperties;

/* renamed from: io.branch.indexing.BranchUniversalObject */
public class BranchUniversalObject implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C5973a();

    /* renamed from: a */
    private String f15261a;

    /* renamed from: b */
    private String f15262b;

    /* renamed from: c */
    private String f15263c;

    /* renamed from: d */
    private String f15264d;

    /* renamed from: e */
    private String f15265e;

    /* renamed from: f */
    private ContentMetadata f15266f;

    /* renamed from: g */
    private C5974b f15267g;

    /* renamed from: h */
    private final ArrayList<String> f15268h;

    /* renamed from: i */
    private long f15269i;

    /* renamed from: j */
    private C5974b f15270j;

    /* renamed from: k */
    private long f15271k;

    /* renamed from: io.branch.indexing.BranchUniversalObject$a */
    static class C5973a implements Parcelable.Creator {
        C5973a() {
        }

        public BranchUniversalObject createFromParcel(Parcel parcel) {
            return new BranchUniversalObject(parcel, (C5973a) null);
        }

        public BranchUniversalObject[] newArray(int i) {
            return new BranchUniversalObject[i];
        }
    }

    /* renamed from: io.branch.indexing.BranchUniversalObject$b */
    public enum C5974b {
        PUBLIC,
        PRIVATE;

        /* renamed from: a */
        public static C5974b[] m19147a() {
            return (C5974b[]) f15274c.clone();
        }
    }

    /* synthetic */ BranchUniversalObject(Parcel parcel, C5973a aVar) {
        this(parcel);
    }

    /* renamed from: a */
    public BranchUniversalObject mo33783a(String str) {
        this.f15264d = str;
        return this;
    }

    /* renamed from: b */
    public BranchUniversalObject mo33786b(String str) {
        this.f15263c = str;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f15271k);
        parcel.writeString(this.f15261a);
        parcel.writeString(this.f15262b);
        parcel.writeString(this.f15263c);
        parcel.writeString(this.f15264d);
        parcel.writeString(this.f15265e);
        parcel.writeLong(this.f15269i);
        parcel.writeInt(this.f15267g.ordinal());
        parcel.writeSerializable(this.f15268h);
        parcel.writeParcelable(this.f15266f, i);
        parcel.writeInt(this.f15270j.ordinal());
    }

    public BranchUniversalObject() {
        this.f15266f = new ContentMetadata();
        this.f15268h = new ArrayList<>();
        this.f15261a = "";
        this.f15262b = "";
        this.f15263c = "";
        this.f15264d = "";
        C5974b bVar = C5974b.PUBLIC;
        this.f15267g = bVar;
        this.f15270j = bVar;
        this.f15269i = 0;
        this.f15271k = System.currentTimeMillis();
    }

    /* renamed from: a */
    public JSONArray mo33785a() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f15268h.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    /* renamed from: b */
    public boolean mo33787b() {
        return this.f15267g == C5974b.PUBLIC;
    }

    /* renamed from: b */
    private C5997f m19141b(Context context, LinkProperties linkProperties) {
        C5997f fVar = new C5997f(context);
        m19140a(fVar, linkProperties);
        return fVar;
    }

    /* renamed from: a */
    public String mo33784a(Context context, LinkProperties linkProperties) {
        return m19141b(context, linkProperties).mo33858b();
    }

    /* renamed from: a */
    private C5997f m19140a(C5997f fVar, LinkProperties linkProperties) {
        if (linkProperties.mo34052h() != null) {
            fVar.mo33889a(linkProperties.mo34052h());
        }
        if (linkProperties.mo34049e() != null) {
            fVar.mo33860d(linkProperties.mo34049e());
        }
        if (linkProperties.mo34044a() != null) {
            fVar.mo33856a(linkProperties.mo34044a());
        }
        if (linkProperties.mo34046c() != null) {
            fVar.mo33859c(linkProperties.mo34046c());
        }
        if (linkProperties.mo34051g() != null) {
            fVar.mo33861e(linkProperties.mo34051g());
        }
        if (linkProperties.mo34045b() != null) {
            fVar.mo33857b(linkProperties.mo34045b());
        }
        if (linkProperties.mo34050f() > 0) {
            fVar.mo33855a(linkProperties.mo34050f());
        }
        if (!TextUtils.isEmpty(this.f15263c)) {
            fVar.mo33888a(C6028l.ContentTitle.mo33920a(), this.f15263c);
        }
        if (!TextUtils.isEmpty(this.f15261a)) {
            fVar.mo33888a(C6028l.CanonicalIdentifier.mo33920a(), this.f15261a);
        }
        if (!TextUtils.isEmpty(this.f15262b)) {
            fVar.mo33888a(C6028l.CanonicalUrl.mo33920a(), this.f15262b);
        }
        JSONArray a = mo33785a();
        if (a.length() > 0) {
            fVar.mo33888a(C6028l.ContentKeyWords.mo33920a(), a);
        }
        if (!TextUtils.isEmpty(this.f15264d)) {
            fVar.mo33888a(C6028l.ContentDesc.mo33920a(), this.f15264d);
        }
        if (!TextUtils.isEmpty(this.f15265e)) {
            fVar.mo33888a(C6028l.ContentImgUrl.mo33920a(), this.f15265e);
        }
        if (this.f15269i > 0) {
            String a2 = C6028l.ContentExpiryTime.mo33920a();
            fVar.mo33888a(a2, "" + this.f15269i);
        }
        String a3 = C6028l.PublicallyIndexable.mo33920a();
        fVar.mo33888a(a3, "" + mo33787b());
        JSONObject a4 = this.f15266f.mo34038a();
        try {
            Iterator<String> keys = a4.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                fVar.mo33888a(next, a4.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap<String, String> d = linkProperties.mo34047d();
        for (String next2 : d.keySet()) {
            fVar.mo33888a(next2, d.get(next2));
        }
        return fVar;
    }

    private BranchUniversalObject(Parcel parcel) {
        this();
        this.f15271k = parcel.readLong();
        this.f15261a = parcel.readString();
        this.f15262b = parcel.readString();
        this.f15263c = parcel.readString();
        this.f15264d = parcel.readString();
        this.f15265e = parcel.readString();
        this.f15269i = parcel.readLong();
        this.f15267g = C5974b.m19147a()[parcel.readInt()];
        ArrayList arrayList = (ArrayList) parcel.readSerializable();
        if (arrayList != null) {
            this.f15268h.addAll(arrayList);
        }
        this.f15266f = (ContentMetadata) parcel.readParcelable(ContentMetadata.class.getClassLoader());
        this.f15270j = C5974b.m19147a()[parcel.readInt()];
    }
}
