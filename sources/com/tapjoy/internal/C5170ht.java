package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* renamed from: com.tapjoy.internal.ht */
public final class C5170ht {

    /* renamed from: a */
    public static final C5170ht f14164a = new C5170ht();

    /* renamed from: b */
    public Context f14165b;

    /* renamed from: c */
    public SharedPreferences f14166c = null;

    /* renamed from: d */
    public SharedPreferences f14167d = null;

    /* renamed from: e */
    ExecutorService f14168e = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: f */
    private File f14169f;

    private C5170ht() {
    }

    /* renamed from: a */
    public static boolean m17399a(long j) {
        return j >= 3600;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m17402c() {
        boolean z;
        long b = C5271v.m17676b();
        File[] listFiles = mo31341b().listFiles();
        HashMap hashMap = new HashMap();
        if (listFiles != null) {
            for (File file : listFiles) {
                hashMap.put(file.getName(), file);
            }
        }
        SharedPreferences.Editor edit = this.f14166c.edit();
        SharedPreferences.Editor edit2 = this.f14167d.edit();
        HashMap hashMap2 = new HashMap(this.f14166c.getAll());
        HashMap hashMap3 = new HashMap(this.f14167d.getAll());
        Iterator it = hashMap2.entrySet().iterator();
        boolean z2 = false;
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) ((Map.Entry) it.next()).getKey();
            if (!hashMap3.containsKey(str)) {
                it.remove();
                edit.remove(str);
                z2 = true;
            }
        }
        Iterator it2 = hashMap3.entrySet().iterator();
        while (it2.hasNext()) {
            String str2 = (String) ((Map.Entry) it2.next()).getKey();
            if (!hashMap2.containsKey(str2)) {
                it2.remove();
                edit2.remove(str2);
                z2 = true;
            }
        }
        Iterator it3 = hashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            String str3 = (String) entry.getKey();
            if (((Long) entry.getValue()).longValue() < b) {
                it3.remove();
                edit.remove(str3);
                edit2.remove(str3);
                z2 = true;
            } else {
                hashMap.remove(str3);
            }
        }
        for (Map.Entry value : hashMap.entrySet()) {
            ((File) value.getValue()).delete();
        }
        if (hashMap2.size() > 30) {
            int size = hashMap2.size() - 30;
            LinkedList linkedList = new LinkedList(hashMap2.entrySet());
            Collections.sort(linkedList, new Comparator() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((Long) ((Map.Entry) obj).getValue()).compareTo((Long) ((Map.Entry) obj2).getValue());
                }
            });
            Iterator it4 = linkedList.iterator();
            for (int i = 0; i < size && it4.hasNext(); i++) {
                Map.Entry entry2 = (Map.Entry) it4.next();
                String str4 = (String) entry2.getKey();
                Long l = (Long) entry2.getValue();
                edit.remove(str4);
                edit2.remove(str4);
                mo31338a(str4).delete();
            }
        } else {
            z = z2;
        }
        if (z) {
            edit.commit();
            edit2.commit();
        }
    }

    /* renamed from: a */
    public final void mo31340a() {
        this.f14168e.submit(new Runnable() {
            public final void run() {
                if (C5170ht.this.f14165b != null) {
                    C5170ht.this.m17402c();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized String mo31342b(URL url) {
        String str;
        String string;
        String url2 = url.toString();
        String convertToHex = TapjoyUtil.convertToHex(C4937ch.m16776a(url2.getBytes()));
        String string2 = this.f14167d.getString(convertToHex, (String) null);
        if (string2 == null) {
            this.f14167d.edit().putString(convertToHex, url2).commit();
            return convertToHex;
        } else if (string2.equals(url2)) {
            return convertToHex;
        } else {
            int i = 0;
            do {
                i++;
                str = convertToHex + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + i;
                string = this.f14167d.getString(str, (String) null);
                if (string == null || string.equals(url2)) {
                    this.f14167d.edit().putString(str, url2).commit();
                }
                i++;
                str = convertToHex + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + i;
                string = this.f14167d.getString(str, (String) null);
                break;
            } while (string.equals(url2));
            this.f14167d.edit().putString(str, url2).commit();
            return str;
        }
    }

    /* renamed from: a */
    public final File mo31339a(URL url) {
        if (this.f14165b == null) {
            return null;
        }
        synchronized (this) {
            String b = mo31342b(url);
            File a = mo31338a(b);
            if (!a.exists()) {
                return null;
            }
            long b2 = C5271v.m17676b();
            long j = this.f14166c.getLong(b, 0);
            if (j >= b2) {
                return a;
            }
            if (j != 0) {
                this.f14166c.edit().remove(b).commit();
                this.f14167d.edit().remove(b).commit();
            }
            a.delete();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo31341b() {
        File file = this.f14169f;
        if (file == null) {
            file = new File(this.f14165b.getCacheDir(), "tapjoy_mm_cache");
            this.f14169f = file;
        }
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo31338a(String str) {
        return new File(mo31341b(), str);
    }
}
