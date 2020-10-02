package p118io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.branch.referral.util.LinkProperties */
public class LinkProperties implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C6044a();

    /* renamed from: a */
    private final ArrayList<String> f15705a;

    /* renamed from: b */
    private String f15706b;

    /* renamed from: c */
    private String f15707c;

    /* renamed from: d */
    private String f15708d;

    /* renamed from: e */
    private int f15709e;

    /* renamed from: f */
    private final HashMap<String, String> f15710f;

    /* renamed from: g */
    private String f15711g;

    /* renamed from: h */
    private String f15712h;

    /* renamed from: io.branch.referral.util.LinkProperties$a */
    static class C6044a implements Parcelable.Creator {
        C6044a() {
        }

        public LinkProperties createFromParcel(Parcel parcel) {
            return new LinkProperties(parcel, (C6044a) null);
        }

        public LinkProperties[] newArray(int i) {
            return new LinkProperties[i];
        }
    }

    /* synthetic */ LinkProperties(Parcel parcel, C6044a aVar) {
        this(parcel);
    }

    /* renamed from: a */
    public LinkProperties mo34043a(String str, String str2) {
        this.f15710f.put(str, str2);
        return this;
    }

    /* renamed from: b */
    public String mo34045b() {
        return this.f15712h;
    }

    /* renamed from: c */
    public String mo34046c() {
        return this.f15711g;
    }

    /* renamed from: d */
    public HashMap<String, String> mo34047d() {
        return this.f15710f;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String mo34049e() {
        return this.f15706b;
    }

    /* renamed from: f */
    public int mo34050f() {
        return this.f15709e;
    }

    /* renamed from: g */
    public String mo34051g() {
        return this.f15708d;
    }

    /* renamed from: h */
    public ArrayList<String> mo34052h() {
        return this.f15705a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15706b);
        parcel.writeString(this.f15707c);
        parcel.writeString(this.f15708d);
        parcel.writeString(this.f15711g);
        parcel.writeString(this.f15712h);
        parcel.writeInt(this.f15709e);
        parcel.writeSerializable(this.f15705a);
        parcel.writeInt(this.f15710f.size());
        for (Map.Entry next : this.f15710f.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public LinkProperties() {
        this.f15705a = new ArrayList<>();
        this.f15706b = "Share";
        this.f15710f = new HashMap<>();
        this.f15707c = "";
        this.f15708d = "";
        this.f15709e = 0;
        this.f15711g = "";
        this.f15712h = "";
    }

    /* renamed from: a */
    public String mo34044a() {
        return this.f15707c;
    }

    private LinkProperties(Parcel parcel) {
        this();
        this.f15706b = parcel.readString();
        this.f15707c = parcel.readString();
        this.f15708d = parcel.readString();
        this.f15711g = parcel.readString();
        this.f15712h = parcel.readString();
        this.f15709e = parcel.readInt();
        this.f15705a.addAll((ArrayList) parcel.readSerializable());
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f15710f.put(parcel.readString(), parcel.readString());
        }
    }
}
