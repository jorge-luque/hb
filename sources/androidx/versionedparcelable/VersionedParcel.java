package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p075d.p080b.C3191a;

public abstract class VersionedParcel {

    /* renamed from: a */
    protected final C3191a<String, Method> f3173a;

    /* renamed from: b */
    protected final C3191a<String, Method> f3174b;

    /* renamed from: c */
    protected final C3191a<String, Class> f3175c;

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(C3191a<String, Method> aVar, C3191a<String, Method> aVar2, C3191a<String, Class> aVar3) {
        this.f3173a = aVar;
        this.f3174b = aVar2;
        this.f3175c = aVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6143a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6144a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6147a(CharSequence charSequence);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6148a(String str);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6149a(boolean z);

    /* renamed from: a */
    public void mo6150a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6151a(byte[] bArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo6152a(int i);

    /* renamed from: a */
    public boolean mo6153a(boolean z, int i) {
        if (!mo6152a(i)) {
            return z;
        }
        return mo6166d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract VersionedParcel mo6155b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo6156b(int i);

    /* renamed from: b */
    public void mo6162b(boolean z, int i) {
        mo6156b(i);
        mo6149a(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo6164c(int i);

    /* renamed from: c */
    public boolean mo6165c() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract boolean mo6166d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract byte[] mo6167e();

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract CharSequence mo6168f();

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract int mo6169g();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract <T extends Parcelable> T mo6170h();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public abstract String mo6171i();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public <T extends C1154b> T mo6172j() {
        String i = mo6171i();
        if (i == null) {
            return null;
        }
        return mo6140a(i, mo6155b());
    }

    /* renamed from: a */
    public int mo6137a(int i, int i2) {
        if (!mo6152a(i2)) {
            return i;
        }
        return mo6169g();
    }

    /* renamed from: b */
    public void mo6163b(byte[] bArr, int i) {
        mo6156b(i);
        mo6151a(bArr);
    }

    /* renamed from: a */
    public String mo6142a(String str, int i) {
        if (!mo6152a(i)) {
            return str;
        }
        return mo6171i();
    }

    /* renamed from: b */
    public void mo6160b(CharSequence charSequence, int i) {
        mo6156b(i);
        mo6147a(charSequence);
    }

    /* renamed from: a */
    public byte[] mo6154a(byte[] bArr, int i) {
        if (!mo6152a(i)) {
            return bArr;
        }
        return mo6167e();
    }

    /* renamed from: b */
    public void mo6157b(int i, int i2) {
        mo6156b(i2);
        mo6164c(i);
    }

    /* renamed from: a */
    public <T extends Parcelable> T mo6138a(T t, int i) {
        if (!mo6152a(i)) {
            return t;
        }
        return mo6170h();
    }

    /* renamed from: b */
    public void mo6161b(String str, int i) {
        mo6156b(i);
        mo6148a(str);
    }

    /* renamed from: a */
    public CharSequence mo6141a(CharSequence charSequence, int i) {
        if (!mo6152a(i)) {
            return charSequence;
        }
        return mo6168f();
    }

    /* renamed from: b */
    public void mo6158b(Parcelable parcelable, int i) {
        mo6156b(i);
        mo6144a(parcelable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6145a(C1154b bVar) {
        if (bVar == null) {
            mo6148a((String) null);
            return;
        }
        m4707b(bVar);
        VersionedParcel b = mo6155b();
        mo6146a(bVar, b);
        b.mo6143a();
    }

    /* renamed from: b */
    public void mo6159b(C1154b bVar, int i) {
        mo6156b(i);
        mo6145a(bVar);
    }

    /* renamed from: b */
    private void m4707b(C1154b bVar) {
        try {
            mo6148a(m4704a((Class<? extends C1154b>) bVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(bVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* renamed from: b */
    private Method m4706b(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method method = this.f3173a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f3173a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* renamed from: a */
    public <T extends C1154b> T mo6139a(T t, int i) {
        if (!mo6152a(i)) {
            return t;
        }
        return mo6172j();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T extends C1154b> T mo6140a(String str, VersionedParcel versionedParcel) {
        try {
            return (C1154b) m4706b(str).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    /* renamed from: b */
    private Method m4705b(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f3174b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class a = m4704a((Class<? extends C1154b>) cls);
        System.currentTimeMillis();
        Method declaredMethod = a.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.f3174b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T extends C1154b> void mo6146a(T t, VersionedParcel versionedParcel) {
        try {
            m4705b((Class) t.getClass()).invoke((Object) null, new Object[]{t, versionedParcel});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    /* renamed from: a */
    private Class m4704a(Class<? extends C1154b> cls) throws ClassNotFoundException {
        Class cls2 = this.f3175c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f3175c.put(cls.getName(), cls3);
        return cls3;
    }
}
