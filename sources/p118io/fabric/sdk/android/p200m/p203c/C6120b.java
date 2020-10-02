package p118io.fabric.sdk.android.p200m.p203c;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6096k;

/* renamed from: io.fabric.sdk.android.m.c.b */
/* compiled from: EventsFilesManager */
public abstract class C6120b<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final C6096k currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final C6123c eventStorage;
    protected volatile long lastRollOverTime;
    protected final List<C6124d> rollOverListeners = new CopyOnWriteArrayList();
    protected final C6119a<T> transform;

    /* renamed from: io.fabric.sdk.android.m.c.b$a */
    /* compiled from: EventsFilesManager */
    class C6121a implements Comparator<C6122b> {
        C6121a(C6120b bVar) {
        }

        /* renamed from: a */
        public int compare(C6122b bVar, C6122b bVar2) {
            return (int) (bVar.f16101b - bVar2.f16101b);
        }
    }

    /* renamed from: io.fabric.sdk.android.m.c.b$b */
    /* compiled from: EventsFilesManager */
    static class C6122b {

        /* renamed from: a */
        final File f16100a;

        /* renamed from: b */
        final long f16101b;

        public C6122b(File file, long j) {
            this.f16100a = file;
            this.f16101b = j;
        }
    }

    public C6120b(Context context2, C6119a<T> aVar, C6096k kVar, C6123c cVar, int i) throws IOException {
        this.context = context2.getApplicationContext();
        this.transform = aVar;
        this.eventStorage = cVar;
        this.currentTimeProvider = kVar;
        this.lastRollOverTime = kVar.mo34175a();
        this.defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i) throws IOException {
        if (!this.eventStorage.mo34233a(i, getMaxByteSizePerFile())) {
            C6090i.m19730a(this.context, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.eventStorage.mo34228a()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())}));
            rollFileOver();
        }
    }

    private void triggerRollOverOnListeners(String str) {
        for (C6124d onRollOver : this.rollOverListeners) {
            try {
                onRollOver.onRollOver(str);
            } catch (Exception e) {
                C6090i.m19731a(this.context, "One of the roll over listeners threw an exception", (Throwable) e);
            }
        }
    }

    public void deleteAllEventsFiles() {
        C6123c cVar = this.eventStorage;
        cVar.mo34231a(cVar.mo34235c());
        this.eventStorage.mo34236d();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> c = this.eventStorage.mo34235c();
        int maxFilesToKeep = getMaxFilesToKeep();
        if (c.size() > maxFilesToKeep) {
            int size = c.size() - maxFilesToKeep;
            C6090i.m19746c(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(maxFilesToKeep), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C6121a(this));
            for (File next : c) {
                treeSet.add(new C6122b(next, parseCreationTimestampFromFileName(next.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C6122b) it.next()).f16100a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.eventStorage.mo34231a((List<File>) arrayList);
        }
    }

    public void deleteSentFiles(List<File> list) {
        this.eventStorage.mo34231a(list);
    }

    /* access modifiers changed from: protected */
    public abstract String generateUniqueRollOverFileName();

    public List<File> getBatchOfFilesToSend() {
        return this.eventStorage.mo34229a(1);
    }

    public long getLastRollOverTime() {
        return this.lastRollOverTime;
    }

    /* access modifiers changed from: protected */
    public int getMaxByteSizePerFile() {
        return 8000;
    }

    /* access modifiers changed from: protected */
    public int getMaxFilesToKeep() {
        return this.defaultMaxFilesToKeep;
    }

    public long parseCreationTimestampFromFileName(String str) {
        String[] split = str.split(ROLL_OVER_FILE_NAME_SEPARATOR);
        if (split.length != 3) {
            return 0;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void registerRollOverListener(C6124d dVar) {
        if (dVar != null) {
            this.rollOverListeners.add(dVar);
        }
    }

    public boolean rollFileOver() throws IOException {
        String str;
        boolean z = true;
        if (!this.eventStorage.mo34234b()) {
            str = generateUniqueRollOverFileName();
            this.eventStorage.mo34230a(str);
            C6090i.m19730a(this.context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.lastRollOverTime = this.currentTimeProvider.mo34175a();
        } else {
            str = null;
            z = false;
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    public void writeEvent(T t) throws IOException {
        byte[] bytes = this.transform.toBytes(t);
        rollFileOverIfNeeded(bytes.length);
        this.eventStorage.mo34232a(bytes);
    }
}
