package com.crashlytics.android.ndk;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import p118io.fabric.sdk.android.p200m.p202b.C6117w;
import p118io.fabric.sdk.android.p200m.p204d.C6130a;

class NdkCrashFilesManager implements CrashFilesManager {
    private static final String NATIVE_ROOT_DIRECTORY_SUFFIX = "native";
    private static final FileFilter ONLY_DIRECTORIES_FILTER = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
    private final C6130a fileStore;

    public NdkCrashFilesManager(C6130a aVar) {
        this.fileStore = aVar;
    }

    private static TreeSet<File> getAllTimestampedDirectories(File file) {
        if (file == null || !file.isDirectory()) {
            return new TreeSet<>();
        }
        File[] listFiles = file.listFiles(ONLY_DIRECTORIES_FILTER);
        TreeSet<File> treeSet = new TreeSet<>(new Comparator<File>() {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        treeSet.addAll(Arrays.asList(listFiles));
        return treeSet;
    }

    private File getNativeRootFileDirectory() {
        return new File(this.fileStore.mo34239a(), "native");
    }

    public TreeSet<File> getAllNativeDirectories() {
        return getAllTimestampedDirectories(getNativeRootFileDirectory());
    }

    public File getNewNativeDirectory() {
        File nativeRootFileDirectory = getNativeRootFileDirectory();
        if (!nativeRootFileDirectory.isDirectory() && !nativeRootFileDirectory.mkdir()) {
            return null;
        }
        File file = new File(nativeRootFileDirectory, Long.toString(new C6117w().mo34175a()));
        if (file.mkdir()) {
            return file;
        }
        return null;
    }
}
