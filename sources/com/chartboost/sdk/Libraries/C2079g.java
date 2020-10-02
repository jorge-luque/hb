package com.chartboost.sdk.Libraries;

import com.tapjoy.TJAdUnitConstants;
import java.io.File;

/* renamed from: com.chartboost.sdk.Libraries.g */
public class C2079g {

    /* renamed from: a */
    public final File f6867a;

    /* renamed from: b */
    public final File f6868b;

    /* renamed from: c */
    public final File f6869c;

    /* renamed from: d */
    public final File f6870d;

    C2079g(File file) {
        File file2 = new File(file, ".chartboost");
        this.f6867a = file2;
        if (!file2.exists()) {
            this.f6867a.mkdirs();
        }
        m8198a(this.f6867a, "css");
        m8198a(this.f6867a, TJAdUnitConstants.String.HTML);
        this.f6868b = m8198a(this.f6867a, "images");
        m8198a(this.f6867a, "js");
        this.f6869c = m8198a(this.f6867a, "templates");
        this.f6870d = m8198a(this.f6867a, "videos");
    }

    /* renamed from: a */
    private static File m8198a(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2;
    }
}
