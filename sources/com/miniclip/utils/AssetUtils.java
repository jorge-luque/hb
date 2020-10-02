package com.miniclip.utils;

import com.miniclip.framework.Miniclip;

public class AssetUtils {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[SYNTHETIC, Splitter:B:18:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] checksum(java.lang.String r6, boolean r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "md5Checksum: "
            r1 = 0
            r2 = 0
            if (r7 == 0) goto L_0x0013
            android.app.Activity r7 = com.miniclip.framework.Miniclip.getActivity()     // Catch:{ Exception -> 0x0039 }
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch:{ Exception -> 0x0039 }
            java.io.InputStream r6 = r7.open(r6)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0019
        L_0x0013:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0039 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0039 }
            r6 = r7
        L_0x0019:
            java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r8)     // Catch:{ Exception -> 0x0034 }
            r7.reset()     // Catch:{ Exception -> 0x0034 }
            r8 = 32768(0x8000, float:4.5918E-41)
            byte[] r3 = new byte[r8]     // Catch:{ Exception -> 0x0034 }
        L_0x0025:
            int r4 = r6.read(r3, r2, r8)     // Catch:{ Exception -> 0x0034 }
            if (r4 <= 0) goto L_0x002f
            r7.update(r3, r2, r4)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0025
        L_0x002f:
            byte[] r1 = r7.digest()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0054
        L_0x0034:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x003b
        L_0x0039:
            r6 = move-exception
            r7 = r1
        L_0x003b:
            java.io.PrintStream r8 = java.lang.System.err
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r6 = r6.getMessage()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r8.println(r6)
            r6 = r7
        L_0x0054:
            if (r6 == 0) goto L_0x0073
            r6.close()     // Catch:{ Exception -> 0x005a }
            goto L_0x0073
        L_0x005a:
            r6 = move-exception
            java.io.PrintStream r7 = java.lang.System.err
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r6 = r6.getMessage()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.println(r6)
        L_0x0073:
            if (r1 == 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            byte[] r1 = new byte[r2]
        L_0x0078:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miniclip.utils.AssetUtils.checksum(java.lang.String, boolean, java.lang.String):byte[]");
    }

    public static boolean isDirectoryInApk(String str) {
        try {
            if (Miniclip.getActivity().getAssets().list(str).length > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] md5Checksum(String str, boolean z) {
        return checksum(str, z, "MD5");
    }
}
