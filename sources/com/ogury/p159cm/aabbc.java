package com.ogury.p159cm;

import com.ogury.p159cm.ConsentActivity;

/* renamed from: com.ogury.cm.aabbc */
public final class aabbc {

    /* renamed from: a */
    public static final aabbc f12011a = new aabbc();

    private aabbc() {
    }

    /* renamed from: a */
    public static String m15001a(int i) {
        aabca aabca = aabca.f12012a;
        String a = aabca.m15003a(i);
        if (a != null) {
            String obj = babac.m15267c(a).toString();
            if (obj != null) {
                String substring = obj.substring(1);
                accbb.m15215a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
            throw new acbab("null cannot be cast to non-null type java.lang.String");
        }
        throw new acbab("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: a */
    public static String m15002a(String str) {
        accbb.m15218b(str, "responseArray");
        int i = 0;
        Object[] array = ConsentActivity.aaaaa.m14881a(ConsentActivity.aaaaa.m14884b(str)).toArray(new Integer[0]);
        if (array != null) {
            int length = array.length;
            String str2 = "";
            while (i < length) {
                int intValue = ((Number) array[i]).intValue();
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                aabca aabca = aabca.f12012a;
                String a = aabca.m15003a(intValue);
                if (a != null) {
                    sb.append(babac.m15267c(a).toString());
                    str2 = sb.toString();
                    i++;
                } else {
                    throw new acbab("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return str2;
        }
        throw new acbab("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
