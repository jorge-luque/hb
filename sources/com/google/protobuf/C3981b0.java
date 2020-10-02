package com.google.protobuf;

/* renamed from: com.google.protobuf.b0 */
/* compiled from: TextFormatEscaper */
final class C3981b0 {

    /* renamed from: com.google.protobuf.b0$a */
    /* compiled from: TextFormatEscaper */
    static class C3982a implements C3983b {

        /* renamed from: a */
        final /* synthetic */ C3995f f10743a;

        C3982a(C3995f fVar) {
            this.f10743a = fVar;
        }

        /* renamed from: a */
        public byte mo28067a(int i) {
            return this.f10743a.mo28114d(i);
        }

        public int size() {
            return this.f10743a.size();
        }
    }

    /* renamed from: com.google.protobuf.b0$b */
    /* compiled from: TextFormatEscaper */
    private interface C3983b {
        /* renamed from: a */
        byte mo28067a(int i);

        int size();
    }

    /* renamed from: a */
    static String m13250a(C3983b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i = 0; i < bVar.size(); i++) {
            byte a = bVar.mo28067a(i);
            if (a == 34) {
                sb.append("\\\"");
            } else if (a == 39) {
                sb.append("\\'");
            } else if (a != 92) {
                switch (a) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a >= 32 && a <= 126) {
                            sb.append((char) a);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((a >>> 6) & 3) + 48));
                            sb.append((char) (((a >>> 3) & 7) + 48));
                            sb.append((char) ((a & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    static String m13251a(C3995f fVar) {
        return m13250a((C3983b) new C3982a(fVar));
    }

    /* renamed from: a */
    static String m13252a(String str) {
        return m13251a(C3995f.m13320a(str));
    }
}
