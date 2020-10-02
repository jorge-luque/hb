package p118io.presage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: io.presage.iu */
public final class C6550iu implements Serializable {

    /* renamed from: a */
    public static final CamembertauCalvados f17091a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final Pattern f17092b;

    /* renamed from: io.presage.iu$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.iu$CamembertdeNormandie */
    static final class CamembertdeNormandie implements Serializable {

        /* renamed from: a */
        public static final CamembertauCalvados f17093a = new CamembertauCalvados((byte) 0);
        private static final long serialVersionUID = 0;

        /* renamed from: b */
        private final String f17094b;

        /* renamed from: c */
        private final int f17095c;

        /* renamed from: io.presage.iu$CamembertdeNormandie$CamembertauCalvados */
        public static final class CamembertauCalvados {
            private CamembertauCalvados() {
            }

            public /* synthetic */ CamembertauCalvados(byte b) {
                this();
            }
        }

        public CamembertdeNormandie(String str, int i) {
            this.f17094b = str;
            this.f17095c = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f17094b, this.f17095c);
            C6514hl.m21414a((Object) compile, "Pattern.compile(pattern, flags)");
            return new C6550iu(compile);
        }
    }

    public C6550iu(Pattern pattern) {
        this.f17092b = pattern;
    }

    private final Object writeReplace() {
        String pattern = this.f17092b.pattern();
        C6514hl.m21414a((Object) pattern, "nativePattern.pattern()");
        return new CamembertdeNormandie(pattern, this.f17092b.flags());
    }

    /* renamed from: a */
    public final boolean mo35561a(CharSequence charSequence) {
        return this.f17092b.matcher(charSequence).find();
    }

    /* renamed from: b */
    public final List<String> mo35562b(CharSequence charSequence) {
        Matcher matcher = this.f17092b.matcher(charSequence);
        if (!matcher.find()) {
            return C6446ey.m21315a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int i = 0;
        do {
            arrayList.add(charSequence.subSequence(i, matcher.start()).toString());
            i = matcher.end();
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i, charSequence.length()).toString());
        return arrayList;
    }

    public final String toString() {
        String pattern = this.f17092b.toString();
        C6514hl.m21414a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C6550iu(java.lang.String r2) {
        /*
            r1 = this;
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            p118io.presage.C6514hl.m21414a((java.lang.Object) r2, (java.lang.String) r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.C6550iu.<init>(java.lang.String):void");
    }
}
