package p163cz.msebera.android.httpclient.p182g0;

import java.util.NoSuchElementException;
import p163cz.msebera.android.httpclient.C5730g;
import p163cz.msebera.android.httpclient.C5911z;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.g0.p */
/* compiled from: BasicTokenIterator */
public class C5746p implements C5911z {

    /* renamed from: a */
    protected final C5730g f14840a;

    /* renamed from: b */
    protected String f14841b;

    /* renamed from: c */
    protected String f14842c;

    /* renamed from: d */
    protected int f14843d = mo33376a(-1);

    public C5746p(C5730g gVar) {
        C5886a.m18894a(gVar, "Header iterator");
        this.f14840a = gVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33376a(int i) throws ParseException {
        int i2;
        if (i >= 0) {
            i2 = mo33381c(i);
        } else if (!this.f14840a.hasNext()) {
            return -1;
        } else {
            this.f14841b = this.f14840a.nextHeader().getValue();
            i2 = 0;
        }
        int d = mo33383d(i2);
        if (d < 0) {
            this.f14842c = null;
            return -1;
        }
        int b = mo33379b(d);
        this.f14842c = mo33377a(this.f14841b, d, b);
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33379b(int i) {
        C5886a.m18891a(i, "Search position");
        int length = this.f14841b.length();
        do {
            i++;
            if (i >= length || !mo33380b(this.f14841b.charAt(i))) {
                return i;
            }
            i++;
            break;
        } while (!mo33380b(this.f14841b.charAt(i)));
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo33381c(int i) {
        C5886a.m18891a(i, "Search position");
        int length = this.f14841b.length();
        boolean z = false;
        while (!z && i < length) {
            char charAt = this.f14841b.charAt(i);
            if (mo33382c(charAt)) {
                z = true;
            } else if (mo33384d(charAt)) {
                i++;
            } else if (mo33380b(charAt)) {
                throw new ParseException("Tokens without separator (pos " + i + "): " + this.f14841b);
            } else {
                throw new ParseException("Invalid character after token (pos " + i + "): " + this.f14841b);
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo33382c(char c) {
        return c == ',';
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo33383d(int i) {
        C5886a.m18891a(i, "Search position");
        boolean z = false;
        while (!z) {
            String str = this.f14841b;
            if (str == null) {
                break;
            }
            int length = str.length();
            while (!z && i < length) {
                char charAt = this.f14841b.charAt(i);
                if (mo33382c(charAt) || mo33384d(charAt)) {
                    i++;
                } else if (mo33380b(this.f14841b.charAt(i))) {
                    z = true;
                } else {
                    throw new ParseException("Invalid character before token (pos " + i + "): " + this.f14841b);
                }
            }
            if (!z) {
                if (this.f14840a.hasNext()) {
                    this.f14841b = this.f14840a.nextHeader().getValue();
                    i = 0;
                } else {
                    this.f14841b = null;
                }
            }
        }
        if (z) {
            return i;
        }
        return -1;
    }

    public boolean hasNext() {
        return this.f14842c != null;
    }

    public final Object next() throws NoSuchElementException, ParseException {
        return nextToken();
    }

    public String nextToken() throws NoSuchElementException, ParseException {
        String str = this.f14842c;
        if (str != null) {
            this.f14843d = mo33376a(this.f14843d);
            return str;
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    public final void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo33380b(char c) {
        if (Character.isLetterOrDigit(c)) {
            return true;
        }
        if (!Character.isISOControl(c) && !mo33378a(c)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo33377a(String str, int i, int i2) {
        return str.substring(i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33378a(char c) {
        return " ,;=()<>@:\\\"/[]?{}\t".indexOf(c) >= 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo33384d(char c) {
        return c == 9 || Character.isSpaceChar(c);
    }
}
