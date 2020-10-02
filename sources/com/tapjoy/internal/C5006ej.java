package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tapjoy.internal.ej */
public abstract class C5006ej {

    /* renamed from: c */
    public static final C5006ej f13583c = new C5006ej(C5001eg.VARINT, Boolean.class) {
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ int mo31092a(Object obj) {
            return 1;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            elVar.mo31119c(((Boolean) obj).booleanValue() ? 1 : 0);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            int d = ekVar.mo31113d();
            if (d == 0) {
                return Boolean.FALSE;
            }
            if (d == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", new Object[]{Integer.valueOf(d)}));
        }
    };

    /* renamed from: d */
    public static final C5006ej f13584d;

    /* renamed from: e */
    public static final C5006ej f13585e;

    /* renamed from: f */
    public static final C5006ej f13586f;

    /* renamed from: g */
    public static final C5006ej f13587g;

    /* renamed from: h */
    public static final C5006ej f13588h;

    /* renamed from: i */
    public static final C5006ej f13589i;

    /* renamed from: j */
    public static final C5006ej f13590j;

    /* renamed from: k */
    public static final C5006ej f13591k;

    /* renamed from: l */
    public static final C5006ej f13592l;

    /* renamed from: m */
    public static final C5006ej f13593m;

    /* renamed from: n */
    public static final C5006ej f13594n = new C5006ej(C5001eg.FIXED32, Float.class) {
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ int mo31092a(Object obj) {
            return 4;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            elVar.mo31121d(Float.floatToIntBits(((Float) obj).floatValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            return Float.valueOf(Float.intBitsToFloat(ekVar.mo31115f()));
        }
    };

    /* renamed from: o */
    public static final C5006ej f13595o = new C5006ej(C5001eg.FIXED64, Double.class) {
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ int mo31092a(Object obj) {
            return 8;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            elVar.mo31122d(Double.doubleToLongBits(((Double) obj).doubleValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            return Double.valueOf(Double.longBitsToDouble(ekVar.mo31116g()));
        }
    };

    /* renamed from: p */
    public static final C5006ej f13596p = new C5006ej(C5001eg.LENGTH_DELIMITED, String.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            int i;
            String str = (String) obj;
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt >= 128) {
                    if (charAt < 2048) {
                        i3 += 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i3 += 3;
                    } else if (charAt <= 56319 && (i = i2 + 1) < length && str.charAt(i) >= 56320 && str.charAt(i) <= 57343) {
                        i3 += 4;
                        i2 = i;
                    }
                    i2++;
                }
                i3++;
                i2++;
            }
            return i3;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            elVar.f13611a.mo31397b((String) obj);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            return ekVar.f13603a.mo31402c(ekVar.mo31117h());
        }
    };

    /* renamed from: q */
    public static final C5006ej f13597q = new C5006ej(C5001eg.LENGTH_DELIMITED, C5212iu.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            return ((C5212iu) obj).mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            elVar.mo31118a((C5212iu) obj);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            return ekVar.f13603a.mo31398b(ekVar.mo31117h());
        }
    };

    /* renamed from: a */
    final Class f13598a;

    /* renamed from: b */
    C5006ej f13599b;

    /* renamed from: r */
    private final C5001eg f13600r;

    /* renamed from: com.tapjoy.internal.ej$a */
    public static final class C5021a extends IllegalArgumentException {

        /* renamed from: a */
        public final int f13602a;

        C5021a(int i, Class cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.f13602a = i;
        }
    }

    static {
        Class<Long> cls = Long.class;
        Class<Integer> cls2 = Integer.class;
        f13584d = new C5006ej(C5001eg.VARINT, cls2) {
            /* renamed from: a */
            public final /* synthetic */ int mo31092a(Object obj) {
                int intValue = ((Integer) obj).intValue();
                if (intValue >= 0) {
                    return C5023el.m16973a(intValue);
                }
                return 10;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                int intValue = ((Integer) obj).intValue();
                if (intValue >= 0) {
                    elVar.mo31119c(intValue);
                } else {
                    elVar.mo31120c((long) intValue);
                }
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                return Integer.valueOf(ekVar.mo31113d());
            }
        };
        f13585e = new C5006ej(C5001eg.VARINT, cls2) {
            /* renamed from: a */
            public final /* synthetic */ int mo31092a(Object obj) {
                return C5023el.m16973a(((Integer) obj).intValue());
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                elVar.mo31119c(((Integer) obj).intValue());
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                return Integer.valueOf(ekVar.mo31113d());
            }
        };
        f13586f = new C5006ej(C5001eg.VARINT, cls2) {
            /* renamed from: a */
            public final /* synthetic */ int mo31092a(Object obj) {
                return C5023el.m16973a(C5023el.m16976b(((Integer) obj).intValue()));
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                elVar.mo31119c(C5023el.m16976b(((Integer) obj).intValue()));
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                int d = ekVar.mo31113d();
                return Integer.valueOf((-(d & 1)) ^ (d >>> 1));
            }
        };
        C500810 r2 = new C5006ej(C5001eg.FIXED32, cls2) {
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ int mo31092a(Object obj) {
                return 4;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                elVar.mo31121d(((Integer) obj).intValue());
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                return Integer.valueOf(ekVar.mo31115f());
            }
        };
        f13587g = r2;
        f13588h = r2;
        f13589i = new C5006ej(C5001eg.VARINT, cls) {
            /* renamed from: a */
            public final /* synthetic */ int mo31092a(Object obj) {
                return C5023el.m16975a(((Long) obj).longValue());
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                elVar.mo31120c(((Long) obj).longValue());
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                return Long.valueOf(ekVar.mo31114e());
            }
        };
        f13590j = new C5006ej(C5001eg.VARINT, cls) {
            /* renamed from: a */
            public final /* synthetic */ int mo31092a(Object obj) {
                return C5023el.m16975a(((Long) obj).longValue());
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                elVar.mo31120c(((Long) obj).longValue());
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                return Long.valueOf(ekVar.mo31114e());
            }
        };
        f13591k = new C5006ej(C5001eg.VARINT, cls) {
            /* renamed from: a */
            public final /* synthetic */ int mo31092a(Object obj) {
                return C5023el.m16975a(C5023el.m16977b(((Long) obj).longValue()));
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                elVar.mo31120c(C5023el.m16977b(((Long) obj).longValue()));
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                long e = ekVar.mo31114e();
                return Long.valueOf((-(e & 1)) ^ (e >>> 1));
            }
        };
        C501214 r1 = new C5006ej(C5001eg.FIXED64, cls) {
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ int mo31092a(Object obj) {
                return 8;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                elVar.mo31122d(((Long) obj).longValue());
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                return Long.valueOf(ekVar.mo31116g());
            }
        };
        f13592l = r1;
        f13593m = r1;
    }

    public C5006ej(C5001eg egVar, Class cls) {
        this.f13600r = egVar;
        this.f13598a = cls;
    }

    /* renamed from: c */
    public static String m16906c(Object obj) {
        return obj.toString();
    }

    /* renamed from: a */
    public int mo31102a(int i, Object obj) {
        int a = mo31092a(obj);
        if (this.f13600r == C5001eg.LENGTH_DELIMITED) {
            a += C5023el.m16973a(a);
        }
        return a + C5023el.m16973a(C5023el.m16974a(i, C5001eg.VARINT));
    }

    /* renamed from: a */
    public abstract int mo31092a(Object obj);

    /* renamed from: a */
    public abstract Object mo31094a(C5022ek ekVar);

    /* renamed from: a */
    public abstract void mo31095a(C5023el elVar, Object obj);

    /* renamed from: b */
    public final byte[] mo31108b(Object obj) {
        C5005ei.m16903a(obj, "value == null");
        C5209ir irVar = new C5209ir();
        try {
            m16905a((C5210is) irVar, obj);
            return irVar.mo31415g();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public void mo31106a(C5023el elVar, int i, Object obj) {
        elVar.mo31119c(C5023el.m16974a(i, this.f13600r));
        if (this.f13600r == C5001eg.LENGTH_DELIMITED) {
            elVar.mo31119c(mo31092a(obj));
        }
        mo31095a(elVar, obj);
    }

    /* renamed from: a */
    private void m16905a(C5210is isVar, Object obj) {
        C5005ei.m16903a(obj, "value == null");
        C5005ei.m16903a(isVar, "sink == null");
        mo31095a(new C5023el(isVar), obj);
    }

    /* renamed from: a */
    public final void mo31107a(OutputStream outputStream, Object obj) {
        C5005ei.m16903a(obj, "value == null");
        C5005ei.m16903a(outputStream, "stream == null");
        C5210is a = C5213iv.m17521a(C5213iv.m17523a(outputStream));
        m16905a(a, obj);
        a.mo31391a();
    }

    /* renamed from: a */
    public final Object mo31105a(byte[] bArr) {
        C5005ei.m16903a(bArr, "bytes == null");
        C5209ir irVar = new C5209ir();
        if (bArr != null) {
            return m16904a((C5211it) irVar.mo31390a(bArr, 0, bArr.length));
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final Object mo31104a(InputStream inputStream) {
        C5005ei.m16903a(inputStream, "stream == null");
        return m16904a(C5213iv.m17522a(C5213iv.m17524a(inputStream)));
    }

    /* renamed from: a */
    private Object m16904a(C5211it itVar) {
        C5005ei.m16903a(itVar, "source == null");
        return mo31094a(new C5022ek(itVar));
    }

    /* renamed from: a */
    public final C5006ej mo31103a() {
        C5006ej ejVar = this.f13599b;
        if (ejVar != null) {
            return ejVar;
        }
        C50176 r0 = new C5006ej(this.f13600r, List.class) {
            /* renamed from: a */
            public final /* synthetic */ int mo31102a(int i, Object obj) {
                List list = (List) obj;
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += C5006ej.this.mo31102a(i, list.get(i3));
                }
                return i2;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31106a(C5023el elVar, int i, Object obj) {
                List list = (List) obj;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    C5006ej.this.mo31106a(elVar, i, list.get(i2));
                }
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
                return Collections.singletonList(C5006ej.this.mo31094a(ekVar));
            }

            /* renamed from: a */
            public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            /* renamed from: a */
            public final /* synthetic */ int mo31092a(Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
        };
        this.f13599b = r0;
        return r0;
    }
}
