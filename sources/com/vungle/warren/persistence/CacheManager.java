package com.vungle.warren.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import android.os.StatFs;
import androidx.core.content.C0769b;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CacheManager {
    private static final String COM_VUNGLE_SDK = "com.vungle.sdk";
    private static final String PATH_ID = "cache_path";
    private static final String PATH_IDS = "cache_paths";
    private static final String VUNGLE_DIR = "vungle_cache";
    private boolean changed;
    private final Context context;
    private File current;
    private Set<Listener> listeners = new HashSet();
    private List<FileObserver> observers = new ArrayList();
    private List<File> old = new ArrayList();
    private final SharedPreferences prefs;

    public interface Listener {
        void onCacheChanged();
    }

    public CacheManager(Context context2) {
        this.context = context2;
        this.prefs = context2.getSharedPreferences(COM_VUNGLE_SDK, 0);
    }

    private void check() {
        File file = this.current;
        if (file == null || !file.exists() || !this.current.isDirectory() || !this.current.canWrite()) {
            selectFileDest();
        }
    }

    private synchronized void observeDirectory(File file) {
        if (file != null) {
            this.observers.clear();
            this.observers.add(new FileObserver(file.getPath(), OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) {
                public void onEvent(int i, String str) {
                    stopWatching();
                    CacheManager.this.selectFileDest();
                }
            });
            while (file.getParent() != null) {
                final String name = file.getName();
                this.observers.add(new FileObserver(file.getParent(), 256) {
                    public void onEvent(int i, String str) {
                        if (name.equals(str)) {
                            stopWatching();
                            CacheManager.this.selectFileDest();
                        }
                    }
                });
                file = file.getParentFile();
            }
            for (FileObserver startWatching : this.observers) {
                startWatching.startWatching();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void selectFileDest() {
        boolean z;
        File file = null;
        if (this.current == null) {
            String string = this.prefs.getString(PATH_ID, (String) null);
            this.current = string != null ? new File(string) : null;
        }
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        File filesDir = this.context.getFilesDir();
        File[] fileArr = new File[2];
        fileArr[0] = new File((Build.VERSION.SDK_INT >= 19 || C0769b.m2414a(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) && Environment.getExternalStorageState().equals("mounted") && externalFilesDir != null ? externalFilesDir : filesDir, VUNGLE_DIR);
        fileArr[1] = new File(filesDir, VUNGLE_DIR);
        Iterator it = Arrays.asList(fileArr).iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            File file2 = (File) it.next();
            if (file2.exists() && file2.isFile() && !file2.delete()) {
                break;
            }
            if (!file2.exists()) {
                z2 = file2.mkdirs();
                z = z2;
                continue;
            } else if (!file2.isDirectory() || !file2.canWrite()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                file = file2;
                break;
            }
        }
        File cacheDir = this.context.getCacheDir();
        Set<String> stringSet = this.prefs.getStringSet(PATH_IDS, new HashSet());
        if (file != null) {
            stringSet.add(file.getPath());
        }
        stringSet.add(cacheDir.getPath());
        this.prefs.edit().putStringSet(PATH_IDS, stringSet).apply();
        this.old.clear();
        for (String next : stringSet) {
            if (file == null || !file.getPath().equals(next)) {
                this.old.add(new File(next));
            }
        }
        if (z2 || ((file != null && !file.equals(this.current)) || (this.current != null && !this.current.equals(file)))) {
            this.current = file;
            if (file != null) {
                this.prefs.edit().putString(PATH_ID, this.current.getPath()).apply();
            }
            for (Listener onCacheChanged : this.listeners) {
                onCacheChanged.onCacheChanged();
            }
            this.changed = true;
        }
        observeDirectory(externalFilesDir);
    }

    public synchronized void addListener(Listener listener) {
        check();
        this.listeners.add(listener);
        if (this.changed) {
            listener.onCacheChanged();
        }
    }

    public long getBytesAvailable() {
        long j;
        long j2;
        File cache = getCache();
        if (cache == null) {
            return -1;
        }
        StatFs statFs = new StatFs(cache.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j = (long) statFs.getBlockSize();
            j2 = (long) statFs.getAvailableBlocks();
        }
        return j * j2;
    }

    public synchronized File getCache() {
        check();
        return this.current;
    }

    public synchronized List<File> getOldCaches() {
        check();
        return this.old;
    }

    public synchronized void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }
}
