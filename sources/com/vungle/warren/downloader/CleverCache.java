package com.vungle.warren.downloader;

import android.util.Base64;
import com.loopj.android.http.C4250c;
import com.vungle.warren.SizeProvider;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CleverCache implements DownloaderCache {
    static final String ASSETS_DIR = "assets";
    static final String CACHE_META = "meta";
    public static final String CACHE_TOUCH_JOURNAL = "cache_touch_timestamp";
    public static final String CC_DIR = "clever_cache";
    private static final String META_POSTFIX_EXT = ".vng_meta";
    private static final String TAG = "CleverCache";
    private final CacheManager cacheManager;
    private final HashMap<File, Long> cacheTouchTime = new HashMap<>();
    private final long expirationAge;
    private final CachePolicy<File> policy;
    private final SizeProvider sizeProvider;
    private Map<File, Integer> trackedFiles = new ConcurrentHashMap();

    public CleverCache(CacheManager cacheManager2, CachePolicy<File> cachePolicy, SizeProvider sizeProvider2, long j) {
        this.cacheManager = cacheManager2;
        this.policy = cachePolicy;
        this.sizeProvider = sizeProvider2;
        this.expirationAge = Math.max(0, j);
    }

    private synchronized void expirationCleanup() {
        long currentTimeMillis = System.currentTimeMillis() - this.expirationAge;
        File[] listFiles = getAssetsDir().listFiles();
        HashSet hashSet = new HashSet(this.cacheTouchTime.keySet());
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                long cacheUpdateTimestamp = getCacheUpdateTimestamp(file);
                hashSet.remove(file);
                if (!isProtected(file)) {
                    if (cacheUpdateTimestamp == 0 || cacheUpdateTimestamp <= currentTimeMillis) {
                        if (deleteContents(file)) {
                            this.cacheTouchTime.remove(file);
                            this.policy.remove(file);
                        }
                        "Deleted expired file " + file;
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                this.cacheTouchTime.remove((File) it.next());
            }
            this.policy.save();
            saveTouchTimestamps();
        }
    }

    private File getCacheDir() {
        File file = new File(this.cacheManager.getCache(), CC_DIR);
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File getTouchTimestampsFile() {
        return new File(getCacheDir(), CACHE_TOUCH_JOURNAL);
    }

    private void integrityCleanup(List<File> list) {
        File metaDir = getMetaDir();
        File[] listFiles = getAssetsDir().listFiles();
        if (listFiles != null) {
            ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(listFiles));
            arrayList.removeAll(list);
            arrayList.remove(metaDir);
            for (File file : arrayList) {
                deleteContents(file);
                "Deleted non tracked file " + file;
            }
        }
    }

    private boolean isProtected(File file) {
        Integer num = this.trackedFiles.get(file);
        if (num == null || num.intValue() <= 0) {
            return false;
        }
        "File is tracked and protected : " + file;
        return true;
    }

    private void loadTouchTimestamps() {
        Serializable serializable = (Serializable) FileUtility.readSerializable(getTouchTimestampsFile());
        if (serializable instanceof HashMap) {
            try {
                this.cacheTouchTime.putAll((HashMap) serializable);
            } catch (ClassCastException unused) {
                getTouchTimestampsFile().delete();
            }
        }
    }

    private void saveTouchTimestamps() {
        FileUtility.writeSerializable(getTouchTimestampsFile(), new HashMap(this.cacheTouchTime));
    }

    public synchronized void clear() {
        List<File> orderedCacheItems = this.policy.getOrderedCacheItems();
        int i = 0;
        integrityCleanup(orderedCacheItems);
        for (File next : orderedCacheItems) {
            if (next != null) {
                if (!isProtected(next)) {
                    if (deleteContents(next)) {
                        i++;
                        this.policy.remove(next);
                        this.cacheTouchTime.remove(next);
                    }
                }
            }
        }
        if (i > 0) {
            this.policy.save();
            saveTouchTimestamps();
        }
    }

    public synchronized boolean deleteAndRemove(File file) {
        if (!deleteContents(file)) {
            return false;
        }
        this.cacheTouchTime.remove(file);
        this.policy.remove(file);
        this.policy.save();
        saveTouchTimestamps();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean deleteContents(java.io.File r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            com.vungle.warren.utility.FileUtility.delete(r1)     // Catch:{ IOException -> 0x0011, all -> 0x000e }
            java.io.File r1 = r0.getMetaFile(r1)     // Catch:{ IOException -> 0x0011, all -> 0x000e }
            com.vungle.warren.utility.FileUtility.delete(r1)     // Catch:{ IOException -> 0x0011, all -> 0x000e }
            r1 = 1
            monitor-exit(r0)
            return r1
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0011:
            r1 = 0
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.CleverCache.deleteContents(java.io.File):boolean");
    }

    public synchronized File getAssetsDir() {
        File file;
        file = new File(getCacheDir(), ASSETS_DIR);
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public synchronized long getCacheUpdateTimestamp(File file) {
        Long l;
        l = this.cacheTouchTime.get(file);
        return l == null ? file.lastModified() : l.longValue();
    }

    public synchronized File getFile(String str) throws IOException {
        File file;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes(C4250c.DEFAULT_CHARSET));
            file = new File(getAssetsDir(), Base64.encodeToString(instance.digest(), 10));
            this.policy.put(file, 0);
        } catch (UnsupportedEncodingException e) {
            throw new IOException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IOException(e2);
        }
        return file;
    }

    public synchronized File getMetaDir() {
        File file;
        file = new File(getAssetsDir(), CACHE_META);
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public synchronized File getMetaFile(File file) {
        File metaDir;
        metaDir = getMetaDir();
        return new File(metaDir, file.getName() + META_POSTFIX_EXT);
    }

    public synchronized void init() {
        this.policy.load();
        loadTouchTimestamps();
        expirationCleanup();
    }

    public synchronized void onCacheHit(File file, long j) {
        this.policy.put(file, j);
        this.policy.save();
        "Cache hit " + file + " cache touch updated";
        purge();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e4, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<java.io.File> purge() {
        /*
            r11 = this;
            monitor-enter(r11)
            com.vungle.warren.SizeProvider r0 = r11.sizeProvider     // Catch:{ all -> 0x00e5 }
            long r0 = r0.getTargetSize()     // Catch:{ all -> 0x00e5 }
            java.io.File r2 = r11.getAssetsDir()     // Catch:{ all -> 0x00e5 }
            long r2 = com.vungle.warren.utility.FileUtility.size(r2)     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r4.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r5 = "Purge check current cache total: "
            r4.append(r5)     // Catch:{ all -> 0x00e5 }
            r4.append(r2)     // Catch:{ all -> 0x00e5 }
            java.lang.String r5 = " target: "
            r4.append(r5)     // Catch:{ all -> 0x00e5 }
            r4.append(r0)     // Catch:{ all -> 0x00e5 }
            r4.toString()     // Catch:{ all -> 0x00e5 }
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0031
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00e5 }
            monitor-exit(r11)
            return r0
        L_0x0031:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00e5 }
            r2.<init>()     // Catch:{ all -> 0x00e5 }
            com.vungle.warren.downloader.CachePolicy<java.io.File> r3 = r11.policy     // Catch:{ all -> 0x00e5 }
            java.util.List r3 = r3.getOrderedCacheItems()     // Catch:{ all -> 0x00e5 }
            r11.integrityCleanup(r3)     // Catch:{ all -> 0x00e5 }
            java.io.File r4 = r11.getAssetsDir()     // Catch:{ all -> 0x00e5 }
            long r4 = com.vungle.warren.utility.FileUtility.size(r4)     // Catch:{ all -> 0x00e5 }
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0051
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00e5 }
            monitor-exit(r11)
            return r0
        L_0x0051:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00e5 }
        L_0x0055:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x00e5 }
            if (r6 == 0) goto L_0x00d5
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x00e5 }
            java.io.File r6 = (java.io.File) r6     // Catch:{ all -> 0x00e5 }
            if (r6 != 0) goto L_0x0064
            goto L_0x0055
        L_0x0064:
            boolean r7 = r11.isProtected(r6)     // Catch:{ all -> 0x00e5 }
            if (r7 == 0) goto L_0x006b
            goto L_0x0055
        L_0x006b:
            long r7 = r6.length()     // Catch:{ all -> 0x00e5 }
            boolean r9 = r11.deleteContents(r6)     // Catch:{ all -> 0x00e5 }
            if (r9 == 0) goto L_0x0055
            long r4 = r4 - r7
            r2.add(r6)     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r9.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r10 = "Deleted file: "
            r9.append(r10)     // Catch:{ all -> 0x00e5 }
            java.lang.String r10 = r6.getName()     // Catch:{ all -> 0x00e5 }
            r9.append(r10)     // Catch:{ all -> 0x00e5 }
            java.lang.String r10 = " size: "
            r9.append(r10)     // Catch:{ all -> 0x00e5 }
            r9.append(r7)     // Catch:{ all -> 0x00e5 }
            java.lang.String r7 = " total: "
            r9.append(r7)     // Catch:{ all -> 0x00e5 }
            r9.append(r4)     // Catch:{ all -> 0x00e5 }
            java.lang.String r7 = " target: "
            r9.append(r7)     // Catch:{ all -> 0x00e5 }
            r9.append(r0)     // Catch:{ all -> 0x00e5 }
            r9.toString()     // Catch:{ all -> 0x00e5 }
            com.vungle.warren.downloader.CachePolicy<java.io.File> r7 = r11.policy     // Catch:{ all -> 0x00e5 }
            r7.remove(r6)     // Catch:{ all -> 0x00e5 }
            java.util.HashMap<java.io.File, java.lang.Long> r7 = r11.cacheTouchTime     // Catch:{ all -> 0x00e5 }
            r7.remove(r6)     // Catch:{ all -> 0x00e5 }
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0055
            com.vungle.warren.SizeProvider r0 = r11.sizeProvider     // Catch:{ all -> 0x00e5 }
            long r0 = r0.getTargetSize()     // Catch:{ all -> 0x00e5 }
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0055
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r3.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = "Cleaned enough total: "
            r3.append(r6)     // Catch:{ all -> 0x00e5 }
            r3.append(r4)     // Catch:{ all -> 0x00e5 }
            java.lang.String r4 = " target: "
            r3.append(r4)     // Catch:{ all -> 0x00e5 }
            r3.append(r0)     // Catch:{ all -> 0x00e5 }
            r3.toString()     // Catch:{ all -> 0x00e5 }
        L_0x00d5:
            int r0 = r2.size()     // Catch:{ all -> 0x00e5 }
            if (r0 <= 0) goto L_0x00e3
            com.vungle.warren.downloader.CachePolicy<java.io.File> r0 = r11.policy     // Catch:{ all -> 0x00e5 }
            r0.save()     // Catch:{ all -> 0x00e5 }
            r11.saveTouchTimestamps()     // Catch:{ all -> 0x00e5 }
        L_0x00e3:
            monitor-exit(r11)
            return r2
        L_0x00e5:
            r0 = move-exception
            monitor-exit(r11)
            goto L_0x00e9
        L_0x00e8:
            throw r0
        L_0x00e9:
            goto L_0x00e8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.CleverCache.purge():java.util.List");
    }

    public synchronized void setCacheLastUpdateTimestamp(File file, long j) {
        this.cacheTouchTime.put(file, Long.valueOf(j));
        saveTouchTimestamps();
    }

    public synchronized void startTracking(File file) {
        int i;
        Integer num = this.trackedFiles.get(file);
        this.policy.put(file, 0);
        this.policy.save();
        if (num != null) {
            if (num.intValue() > 0) {
                i = Integer.valueOf(num.intValue() + 1);
                this.trackedFiles.put(file, i);
                "Start tracking file: " + file + " ref count " + i;
            }
        }
        i = 1;
        this.trackedFiles.put(file, i);
        "Start tracking file: " + file + " ref count " + i;
    }

    public synchronized void stopTracking(File file) {
        Integer num = this.trackedFiles.get(file);
        if (num == null) {
            this.trackedFiles.remove(file);
            return;
        }
        Integer valueOf = Integer.valueOf(num.intValue() - 1);
        if (valueOf.intValue() <= 0) {
            this.trackedFiles.remove(file);
        }
        "Stop tracking file: " + file + " ref count " + valueOf;
    }
}
