package com.ogury.p159cm;

import java.util.List;

/* renamed from: com.ogury.cm.acccc */
public class acccc {
    /* renamed from: a */
    private static <T extends Throwable> T m15230a(T t) {
        return accbb.m15213a(t, acccc.class.getName());
    }

    /* renamed from: a */
    public static List m15231a(Object obj) {
        if (!(obj instanceof baaaa) || (obj instanceof baaab)) {
            return m15232b(obj);
        }
        String name = obj == null ? "null" : obj.getClass().getName();
        throw ((ClassCastException) m15230a(new ClassCastException(name + " cannot be cast to " + "kotlin.collections.MutableList")));
    }

    /* renamed from: b */
    private static List m15232b(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw ((ClassCastException) m15230a(e));
        }
    }
}
