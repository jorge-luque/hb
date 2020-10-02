package p118io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C6028l;

/* renamed from: io.branch.referral.util.ContentMetadata */
public class ContentMetadata implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C6042a();

    /* renamed from: a */
    C6045a f15673a;

    /* renamed from: b */
    public Double f15674b;

    /* renamed from: c */
    public Double f15675c;

    /* renamed from: d */
    public C6046b f15676d;

    /* renamed from: e */
    public String f15677e;

    /* renamed from: f */
    public String f15678f;

    /* renamed from: g */
    public String f15679g;

    /* renamed from: h */
    public C6047c f15680h;

    /* renamed from: i */
    public C6043b f15681i;

    /* renamed from: j */
    public String f15682j;

    /* renamed from: k */
    public Double f15683k;

    /* renamed from: l */
    public Double f15684l;

    /* renamed from: m */
    public Integer f15685m;

    /* renamed from: n */
    public Double f15686n;

    /* renamed from: o */
    public String f15687o;

    /* renamed from: p */
    public String f15688p;

    /* renamed from: q */
    public String f15689q;

    /* renamed from: r */
    public String f15690r;

    /* renamed from: s */
    public String f15691s;

    /* renamed from: t */
    public Double f15692t;

    /* renamed from: u */
    public Double f15693u;

    /* renamed from: v */
    private final ArrayList<String> f15694v;

    /* renamed from: w */
    private final HashMap<String, String> f15695w;

    /* renamed from: io.branch.referral.util.ContentMetadata$a */
    static class C6042a implements Parcelable.Creator {
        C6042a() {
        }

        public ContentMetadata createFromParcel(Parcel parcel) {
            return new ContentMetadata(parcel, (C6042a) null);
        }

        public ContentMetadata[] newArray(int i) {
            return new ContentMetadata[i];
        }
    }

    /* renamed from: io.branch.referral.util.ContentMetadata$b */
    public enum C6043b {
        OTHER,
        NEW,
        GOOD,
        FAIR,
        POOR,
        USED,
        REFURBISHED,
        EXCELLENT;

        /* renamed from: a */
        public static C6043b[] m19536a() {
            return (C6043b[]) f15704i.clone();
        }

        /* renamed from: a */
        public static C6043b m19535a(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (C6043b bVar : m19536a()) {
                    if (bVar.name().equalsIgnoreCase(str)) {
                        return bVar;
                    }
                }
            }
            return null;
        }
    }

    /* synthetic */ ContentMetadata(Parcel parcel, C6042a aVar) {
        this(parcel);
    }

    /* renamed from: a */
    public JSONObject mo34038a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f15673a != null) {
                jSONObject.put(C6028l.ContentSchema.mo33920a(), this.f15673a.name());
            }
            if (this.f15674b != null) {
                jSONObject.put(C6028l.Quantity.mo33920a(), this.f15674b);
            }
            if (this.f15675c != null) {
                jSONObject.put(C6028l.Price.mo33920a(), this.f15675c);
            }
            if (this.f15676d != null) {
                jSONObject.put(C6028l.PriceCurrency.mo33920a(), this.f15676d.toString());
            }
            if (!TextUtils.isEmpty(this.f15677e)) {
                jSONObject.put(C6028l.SKU.mo33920a(), this.f15677e);
            }
            if (!TextUtils.isEmpty(this.f15678f)) {
                jSONObject.put(C6028l.ProductName.mo33920a(), this.f15678f);
            }
            if (!TextUtils.isEmpty(this.f15679g)) {
                jSONObject.put(C6028l.ProductBrand.mo33920a(), this.f15679g);
            }
            if (this.f15680h != null) {
                jSONObject.put(C6028l.ProductCategory.mo33920a(), this.f15680h.mo34057a());
            }
            if (this.f15681i != null) {
                jSONObject.put(C6028l.Condition.mo33920a(), this.f15681i.name());
            }
            if (!TextUtils.isEmpty(this.f15682j)) {
                jSONObject.put(C6028l.ProductVariant.mo33920a(), this.f15682j);
            }
            if (this.f15683k != null) {
                jSONObject.put(C6028l.Rating.mo33920a(), this.f15683k);
            }
            if (this.f15684l != null) {
                jSONObject.put(C6028l.RatingAverage.mo33920a(), this.f15684l);
            }
            if (this.f15685m != null) {
                jSONObject.put(C6028l.RatingCount.mo33920a(), this.f15685m);
            }
            if (this.f15686n != null) {
                jSONObject.put(C6028l.RatingMax.mo33920a(), this.f15686n);
            }
            if (!TextUtils.isEmpty(this.f15687o)) {
                jSONObject.put(C6028l.AddressStreet.mo33920a(), this.f15687o);
            }
            if (!TextUtils.isEmpty(this.f15688p)) {
                jSONObject.put(C6028l.AddressCity.mo33920a(), this.f15688p);
            }
            if (!TextUtils.isEmpty(this.f15689q)) {
                jSONObject.put(C6028l.AddressRegion.mo33920a(), this.f15689q);
            }
            if (!TextUtils.isEmpty(this.f15690r)) {
                jSONObject.put(C6028l.AddressCountry.mo33920a(), this.f15690r);
            }
            if (!TextUtils.isEmpty(this.f15691s)) {
                jSONObject.put(C6028l.AddressPostalCode.mo33920a(), this.f15691s);
            }
            if (this.f15692t != null) {
                jSONObject.put(C6028l.Latitude.mo33920a(), this.f15692t);
            }
            if (this.f15693u != null) {
                jSONObject.put(C6028l.Longitude.mo33920a(), this.f15693u);
            }
            if (this.f15694v.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put(C6028l.ImageCaptions.mo33920a(), jSONArray);
                Iterator<String> it = this.f15694v.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            if (this.f15695w.size() > 0) {
                for (String next : this.f15695w.keySet()) {
                    jSONObject.put(next, this.f15695w.get(next));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C6045a aVar = this.f15673a;
        String str = "";
        parcel.writeString(aVar != null ? aVar.name() : str);
        parcel.writeSerializable(this.f15674b);
        parcel.writeSerializable(this.f15675c);
        C6046b bVar = this.f15676d;
        parcel.writeString(bVar != null ? bVar.name() : str);
        parcel.writeString(this.f15677e);
        parcel.writeString(this.f15678f);
        parcel.writeString(this.f15679g);
        C6047c cVar = this.f15680h;
        parcel.writeString(cVar != null ? cVar.mo34057a() : str);
        C6043b bVar2 = this.f15681i;
        if (bVar2 != null) {
            str = bVar2.name();
        }
        parcel.writeString(str);
        parcel.writeString(this.f15682j);
        parcel.writeSerializable(this.f15683k);
        parcel.writeSerializable(this.f15684l);
        parcel.writeSerializable(this.f15685m);
        parcel.writeSerializable(this.f15686n);
        parcel.writeString(this.f15687o);
        parcel.writeString(this.f15688p);
        parcel.writeString(this.f15689q);
        parcel.writeString(this.f15690r);
        parcel.writeString(this.f15691s);
        parcel.writeSerializable(this.f15692t);
        parcel.writeSerializable(this.f15693u);
        parcel.writeSerializable(this.f15694v);
        parcel.writeSerializable(this.f15695w);
    }

    public ContentMetadata() {
        this.f15694v = new ArrayList<>();
        this.f15695w = new HashMap<>();
    }

    private ContentMetadata(Parcel parcel) {
        this();
        this.f15673a = C6045a.m19546a(parcel.readString());
        this.f15674b = (Double) parcel.readSerializable();
        this.f15675c = (Double) parcel.readSerializable();
        this.f15676d = C6046b.m19548a(parcel.readString());
        this.f15677e = parcel.readString();
        this.f15678f = parcel.readString();
        this.f15679g = parcel.readString();
        this.f15680h = C6047c.m19550a(parcel.readString());
        this.f15681i = C6043b.m19535a(parcel.readString());
        this.f15682j = parcel.readString();
        this.f15683k = (Double) parcel.readSerializable();
        this.f15684l = (Double) parcel.readSerializable();
        this.f15685m = (Integer) parcel.readSerializable();
        this.f15686n = (Double) parcel.readSerializable();
        this.f15687o = parcel.readString();
        this.f15688p = parcel.readString();
        this.f15689q = parcel.readString();
        this.f15690r = parcel.readString();
        this.f15691s = parcel.readString();
        this.f15692t = (Double) parcel.readSerializable();
        this.f15693u = (Double) parcel.readSerializable();
        this.f15694v.addAll((ArrayList) parcel.readSerializable());
        this.f15695w.putAll((HashMap) parcel.readSerializable());
    }
}
