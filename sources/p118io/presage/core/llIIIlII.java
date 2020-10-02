package p118io.presage.core;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: io.presage.core.llIIIlII */
public class llIIIlII implements FileFilter {
    public final /* synthetic */ Pattern IIIIIIII;

    public llIIIlII(llIIIlIl lliiilil, Pattern pattern) {
        this.IIIIIIII = pattern;
    }

    public boolean accept(File file) {
        if (file == null) {
            return false;
        }
        return this.IIIIIIII.matcher(file.getName()).matches();
    }
}
