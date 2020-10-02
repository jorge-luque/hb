package com.vungle.warren.utility;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class FileUtility {
    private static final String TAG = "FileUtility";
    protected static final List<Class<?>> allowedClasses = Arrays.asList(new Class[]{LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class});

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void delete(File file) throws IOException {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File delete : listFiles) {
                        delete(delete);
                    }
                } else {
                    return;
                }
            }
            if (!file.delete()) {
                throw new FileNotFoundException("Failed to delete file: " + file);
            }
        }
    }

    private static String getIndentString(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("|  ");
        }
        return sb.toString();
    }

    public static void printDirectoryTree(File file) {
    }

    private static void printDirectoryTree(File file, int i, StringBuilder sb) {
        if (file != null) {
            if (file.isDirectory()) {
                sb.append(getIndentString(i));
                sb.append("+--");
                sb.append(file.getName());
                sb.append("/\n");
                if (file.listFiles() != null) {
                    for (File file2 : file.listFiles()) {
                        if (file2.isDirectory()) {
                            printDirectoryTree(file2, i + 1, sb);
                        } else {
                            printFile(file2, i + 1, sb);
                        }
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("folder is not a Directory");
        }
    }

    private static void printFile(File file, int i, StringBuilder sb) {
        sb.append(getIndentString(i));
        sb.append("+--");
        sb.append(file.getName());
        sb.append(10);
    }

    static ArrayList<String> readAllLines(String str) {
        File file = new File(str);
        if (file.exists()) {
            Object readSerializable = readSerializable(file);
            if (readSerializable instanceof ArrayList) {
                return (ArrayList) readSerializable;
            }
        }
        return new ArrayList<>();
    }

    public static HashMap<String, String> readMap(String str) {
        Object readSerializable = readSerializable(new File(str));
        if (readSerializable instanceof HashMap) {
            return (HashMap) readSerializable;
        }
        return new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r6v14, types: [java.io.Closeable, java.io.ObjectInputStream, com.vungle.warren.utility.SafeObjectInputStream] */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T readSerializable(java.io.File r6) {
        /*
            boolean r0 = r6.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003e, ClassNotFoundException -> 0x0033, all -> 0x002e }
            r0.<init>(r6)     // Catch:{ IOException -> 0x003e, ClassNotFoundException -> 0x0033, all -> 0x002e }
            com.vungle.warren.utility.SafeObjectInputStream r6 = new com.vungle.warren.utility.SafeObjectInputStream     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0028, all -> 0x0023 }
            java.util.List<java.lang.Class<?>> r2 = allowedClasses     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0028, all -> 0x0023 }
            r6.<init>(r0, r2)     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0028, all -> 0x0023 }
            java.lang.Object r1 = r6.readObject()     // Catch:{ IOException -> 0x0021, ClassNotFoundException -> 0x001f }
            closeQuietly(r6)
            closeQuietly(r0)
            return r1
        L_0x001f:
            r2 = move-exception
            goto L_0x0036
        L_0x0021:
            r2 = move-exception
            goto L_0x0041
        L_0x0023:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L_0x0050
        L_0x0028:
            r2 = move-exception
            r6 = r1
            goto L_0x0036
        L_0x002b:
            r2 = move-exception
            r6 = r1
            goto L_0x0041
        L_0x002e:
            r6 = move-exception
            r0 = r1
            r1 = r6
            r6 = r0
            goto L_0x0050
        L_0x0033:
            r2 = move-exception
            r6 = r1
            r0 = r6
        L_0x0036:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x004f }
            java.lang.String r4 = "ClassNotFoundException"
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x004f }
            goto L_0x0048
        L_0x003e:
            r2 = move-exception
            r6 = r1
            r0 = r6
        L_0x0041:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x004f }
            java.lang.String r4 = "IOIOException"
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x004f }
        L_0x0048:
            closeQuietly(r6)
            closeQuietly(r0)
            return r1
        L_0x004f:
            r1 = move-exception
        L_0x0050:
            closeQuietly(r6)
            closeQuietly(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.utility.FileUtility.readSerializable(java.io.File):java.lang.Object");
    }

    public static long size(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File size : listFiles) {
                j += size(size);
            }
        }
        return j;
    }

    public static void writeAllLines(String str, ArrayList<String> arrayList) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        if (!arrayList.isEmpty()) {
            writeSerializable(file, arrayList);
        }
    }

    public static void writeMap(String str, HashMap<String, String> hashMap) {
        File file = new File(str);
        if (!hashMap.isEmpty()) {
            writeSerializable(file, hashMap);
        }
    }

    public static void writeSerializable(File file, Serializable serializable) {
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            file.delete();
        }
        if (serializable != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2.writeObject(serializable);
                        objectOutputStream2.reset();
                        closeQuietly(objectOutputStream2);
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        try {
                            Log.e(TAG, "IOIOException", e);
                            closeQuietly(objectOutputStream);
                            closeQuietly(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            closeQuietly(objectOutputStream);
                            closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = objectOutputStream2;
                        closeQuietly(objectOutputStream);
                        closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.e(TAG, "IOIOException", e);
                    closeQuietly(objectOutputStream);
                    closeQuietly(fileOutputStream);
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                Log.e(TAG, "IOIOException", e);
                closeQuietly(objectOutputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                closeQuietly(objectOutputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
            closeQuietly(fileOutputStream);
        }
    }
}
