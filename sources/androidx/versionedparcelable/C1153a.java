package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import p075d.p080b.C3191a;

/* renamed from: androidx.versionedparcelable.a */
/* compiled from: VersionedParcelParcel */
class C1153a extends VersionedParcel {

    /* renamed from: d */
    private final SparseIntArray f3176d;

    /* renamed from: e */
    private final Parcel f3177e;

    /* renamed from: f */
    private final int f3178f;

    /* renamed from: g */
    private final int f3179g;

    /* renamed from: h */
    private final String f3180h;

    /* renamed from: i */
    private int f3181i;

    /* renamed from: j */
    private int f3182j;

    /* renamed from: k */
    private int f3183k;

    C1153a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C3191a(), new C3191a(), new C3191a());
    }

    /* renamed from: a */
    public boolean mo6152a(int i) {
        while (this.f3182j < this.f3179g) {
            int i2 = this.f3183k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f3177e.setDataPosition(this.f3182j);
            int readInt = this.f3177e.readInt();
            this.f3183k = this.f3177e.readInt();
            this.f3182j += readInt;
        }
        if (this.f3183k == i) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void mo6156b(int i) {
        mo6143a();
        this.f3181i = i;
        this.f3176d.put(i, this.f3177e.dataPosition());
        mo6164c(0);
        mo6164c(i);
    }

    /* renamed from: c */
    public void mo6164c(int i) {
        this.f3177e.writeInt(i);
    }

    /* renamed from: d */
    public boolean mo6166d() {
        return this.f3177e.readInt() != 0;
    }

    /* renamed from: e */
    public byte[] mo6167e() {
        int readInt = this.f3177e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f3177e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public CharSequence mo6168f() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f3177e);
    }

    /* renamed from: g */
    public int mo6169g() {
        return this.f3177e.readInt();
    }

    /* renamed from: h */
    public <T extends Parcelable> T mo6170h() {
        return this.f3177e.readParcelable(C1153a.class.getClassLoader());
    }

    /* renamed from: i */
    public String mo6171i() {
        return this.f3177e.readString();
    }

    private C1153a(Parcel parcel, int i, int i2, String str, C3191a<String, Method> aVar, C3191a<String, Method> aVar2, C3191a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f3176d = new SparseIntArray();
        this.f3181i = -1;
        this.f3182j = 0;
        this.f3183k = -1;
        this.f3177e = parcel;
        this.f3178f = i;
        this.f3179g = i2;
        this.f3182j = i;
        this.f3180h = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public VersionedParcel mo6155b() {
        Parcel parcel = this.f3177e;
        int dataPosition = parcel.dataPosition();
        int i = this.f3182j;
        if (i == this.f3178f) {
            i = this.f3179g;
        }
        int i2 = i;
        return new C1153a(parcel, dataPosition, i2, this.f3180h + "  ", this.f3173a, this.f3174b, this.f3175c);
    }

    /* renamed from: a */
    public void mo6143a() {
        int i = this.f3181i;
        if (i >= 0) {
            int i2 = this.f3176d.get(i);
            int dataPosition = this.f3177e.dataPosition();
            this.f3177e.setDataPosition(i2);
            this.f3177e.writeInt(dataPosition - i2);
            this.f3177e.setDataPosition(dataPosition);
        }
    }

    /* renamed from: a */
    public void mo6151a(byte[] bArr) {
        if (bArr != null) {
            this.f3177e.writeInt(bArr.length);
            this.f3177e.writeByteArray(bArr);
            return;
        }
        this.f3177e.writeInt(-1);
    }

    /* renamed from: a */
    public void mo6148a(String str) {
        this.f3177e.writeString(str);
    }

    /* renamed from: a */
    public void mo6144a(Parcelable parcelable) {
        this.f3177e.writeParcelable(parcelable, 0);
    }

    /* renamed from: a */
    public void mo6149a(boolean z) {
        this.f3177e.writeInt(z ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6147a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f3177e, 0);
    }
}
