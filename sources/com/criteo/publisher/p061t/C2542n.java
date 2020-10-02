package com.criteo.publisher.p061t;

import android.content.Context;
import android.util.AtomicFile;
import com.criteo.publisher.p054a0.C2330h;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.criteo.publisher.t.n */
class C2542n {

    /* renamed from: a */
    private final Context f8079a;

    /* renamed from: b */
    private final C2330h f8080b;

    /* renamed from: c */
    private final C2547q f8081c;

    /* renamed from: com.criteo.publisher.t.n$a */
    class C2543a implements FilenameFilter {
        C2543a(C2542n nVar) {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".csm");
        }
    }

    C2542n(Context context, C2330h hVar, C2547q qVar) {
        this.f8079a = context;
        this.f8080b = hVar;
        this.f8081c = qVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo10583a(String str) {
        return new File(mo10582a(), m9558b(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Collection<File> mo10584b() {
        File[] listFiles = mo10582a().listFiles(new C2543a(this));
        if (listFiles == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(listFiles);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2561y mo10581a(File file) {
        return new C2561y(m9557b(file), new AtomicFile(file), this.f8081c);
    }

    /* renamed from: b */
    private String m9558b(String str) {
        return str + ".csm";
    }

    /* renamed from: b */
    private String m9557b(File file) {
        String name = file.getName();
        return name.substring(0, name.length() - 4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo10582a() {
        return this.f8079a.getDir(this.f8080b.mo10132e(), 0);
    }
}
