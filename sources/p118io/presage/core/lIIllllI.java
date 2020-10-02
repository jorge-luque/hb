package p118io.presage.core;

import android.content.Context;
import com.tapjoy.TapjoyConstants;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.presage.core.lIIllIll;

/* renamed from: io.presage.core.lIIllllI */
public class lIIllllI {
    public static final String IIIIIIlI = C6312i0.IIIIIIII;
    public static final String IIIIIIll = C6312i0.IIIIIIIl;
    public static final String IIIIIlII = C6312i0.IIIIIIlI;
    public static final String IIIIIlIl = C6312i0.IIIIIIll;
    public static final String IIIIIllI = C6312i0.IIIIIlII;
    public static final String IIIIIlll = C6312i0.IIIIIlIl;
    public static final String IIIIlIII = C6312i0.IIIIIllI;
    public static final String IIIIlIIl = C6312i0.IIIIIlll;
    public static final String IIIIlIlI = C6312i0.IIIIlIII;
    public static final String IIIIlIll = C6312i0.IIIIlIIl;
    public static final String IIIIllII = C6312i0.IIIIlIlI;
    public static final String IIIIllIl = C6312i0.IIIIlIll;
    public static final String IIIIlllI = C6312i0.IIIIllII;
    public static final String IIIIllll = C6312i0.IIIIllIl;
    public static final String IIIlIIII = C6312i0.IIIIlllI;
    public static final String IIIlIIIl = C6312i0.IIIIllll;
    public static final String IIIlIIlI = C6312i0.IIIlIIII;
    public static final String IIIlIIll = C6312i0.IIIlIIIl;
    public static final String IIIlIlII = C6312i0.IIIlIIlI;
    public static final String IIIlIlIl = C6312i0.IIIlIIll;
    public static final String IIIlIllI = C6312i0.IIIlIlII;
    public static final String IIIlIlll = C6312i0.IIIlIlIl;
    public static final String IIIllIII = C6312i0.IIIlIllI;
    public static final String IIIllIIl = C6312i0.IIIllIlI;
    public static final String IIIllIlI = C6312i0.IIIllIll;
    public static final String IIIllIll = C6312i0.IIIlllII;
    public static final String IIIlllII = C6312i0.IIIlllIl;
    public static final String IIIlllIl = C6312i0.IIIllllI;
    public static final String IIIllllI = C6312i0.IIIlllll;
    public static final String IIIlllll = C6312i0.IIlIIIII;
    public static final String IIlIIIII = C6312i0.IIlIIIIl;
    public static final String IIlIIIIl = C6312i0.IIlIIIlI;
    public static final String IIlIIIlI = C6312i0.IIlIIIll;
    public static final String IIlIIIll = C6312i0.IIlIIlII;
    public static final String IIlIIlII = C6312i0.IIlIIlIl;
    public static final String IIlIIlIl = C6312i0.IIlIIllI;
    public static final String IIlIIllI = C6312i0.IIlIIlll;
    public static final String IIlIIlll = C6312i0.IIlIlIII;
    public static final String IIlIlIII = C6312i0.IIlIlIIl;
    public static final String IIlIlIIl = C6312i0.IIlIlIlI;
    public static final String IIlIlIlI = C6312i0.IIlIlIll;
    public static final String IIlIlIll = C6312i0.IIlIllII;
    public static final String IIlIllII = C6312i0.IIlIllIl;
    public Context IIIIIIII;
    public int IIIIIIIl = 3;

    static {
        String str = C6312i0.IIIlIlll;
        String str2 = C6312i0.IIIllIII;
        String str3 = C6312i0.IIIllIIl;
    }

    public lIIllllI(Context context) {
        this.IIIIIIII = context;
    }

    public JSONObject IIIIIIII(lIIllIll liillill) {
        Set<llIllIll> set;
        String str;
        String str2;
        Set<IIllllll> set2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IIIIIIlI, liillill.IIIIIIII);
            jSONObject.put(IIIIIIll, liillill.IIIIIlIl);
            jSONObject.put(IIIIIlII, liillill.IIIIIlII);
            if (liillill.IIIIlIIl && (set2 = liillill.IIIIlIll) != null && !set2.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (IIllllll next : liillill.IIIIlIll) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IIIIIllI, next.IIIIIIII());
                    jSONObject2.put(IIIIIlll, next.IIIIlIII);
                    jSONObject2.put(IIIIlIII, next.IIIIlIIl);
                    jSONObject2.put(IIIIlIIl, next.IIIIlIlI);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(IIIIIlIl, jSONArray);
                if (liillill.IIIIlIlI != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(IIIIlIll, liillill.IIIIlIlI.IIIIIIII);
                    jSONObject3.put(IIIIllII, liillill.IIIIlIlI.IIIIIIIl);
                    jSONObject.put(IIIIlIlI, jSONObject3);
                }
                String str3 = liillill.IIIIIIIl;
                if (str3 != null && !str3.isEmpty()) {
                    jSONObject.put(IIIIllIl, liillill.IIIIIIIl);
                }
            }
            Set<C6350r2> set3 = liillill.IIIIllII;
            if (set3 != null && !set3.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (C6350r2 IIIIIIII2 : liillill.IIIIllII) {
                    jSONArray2.put(IIIIIIII(IIIIIIII2));
                }
                jSONObject.put(IIIlIlII, jSONArray2);
            }
            if (!liillill.IIIIllIl.isEmpty() && !liillill.IIIIlllI.isEmpty()) {
                JSONObject jSONObject4 = new JSONObject();
                JSONArray jSONArray3 = new JSONArray();
                for (Integer intValue : liillill.IIIIllIl) {
                    jSONArray3.put(intValue.intValue());
                }
                jSONObject4.put(IIIIllll, jSONArray3);
                JSONArray jSONArray4 = new JSONArray();
                for (Integer intValue2 : liillill.IIIIlllI) {
                    jSONArray4.put(intValue2.intValue());
                }
                jSONObject4.put(IIIlIIII, jSONArray4);
                jSONObject.put(IIIIlllI, jSONObject4);
            }
            if (liillill.IIIIIIlI && (str2 = liillill.IIIIIIll) != null && !str2.isEmpty()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(IIIlIIlI, liillill.IIIIIIlI);
                jSONObject5.put(IIIlIIll, liillill.IIIIIIll);
                jSONObject.put(IIIlIIIl, jSONObject5);
            }
            if (liillill.IIIIllll && (set = liillill.IIIlIIIl) != null && !set.isEmpty() && (str = liillill.IIIlIIII) != null && !str.isEmpty()) {
                jSONObject.put(IIIllIll, liillill.IIIlIIII);
                JSONArray jSONArray5 = new JSONArray();
                for (llIllIll next2 : liillill.IIIlIIIl) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(IIIllIlI, next2.IIIIIIII);
                    jSONObject6.put(IIIlllII, next2.IIIIIIIl);
                    jSONArray5.put(jSONObject6);
                }
                jSONObject.put(IIIllIIl, jSONArray5);
            }
            if (!(liillill.IIIlIIlI == 0 || liillill.IIIlIIll == null || liillill.IIIlIlII == null)) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(IIIllllI, liillill.IIIlIIlI);
                jSONObject7.put(IIIlllll, liillill.IIIlIIll);
                jSONObject7.put(IIlIIIII, liillill.IIIlIlII);
                jSONObject7.put(IIlIIIIl, liillill.IIIlIlIl);
                jSONObject7.put(IIlIIIlI, liillill.IIIlIllI);
                jSONObject.put(IIIlllIl, jSONObject7);
            }
            JSONObject jSONObject8 = new JSONObject();
            IIIIllII iIIIllII = liillill.IIIlIlll;
            if (iIIIllII != null) {
                int i = iIIIllII.IIIIIIII;
                if (i != 0) {
                    if (i == 1) {
                        jSONObject8.put(IIlIIlII, i);
                        jSONObject8.put(IIlIIlIl, liillill.IIIlIlll.IIIIIIIl);
                        jSONObject8.put(IIlIIllI, liillill.IIIlIlll.IIIIIIll);
                        jSONObject8.put(IIlIIlll, liillill.IIIlIlll.IIIIIIlI);
                        jSONObject8.put(IIlIlIII, liillill.IIIlIlll.IIIIIlII);
                        jSONObject8.put(IIlIlIIl, liillill.IIIlIlll.IIIIIlIl);
                        jSONObject.put(IIlIIIll, jSONObject8);
                        return jSONObject;
                    }
                }
            }
            jSONObject8.put(IIlIIlII, 0);
            jSONObject.put(IIlIIIll, jSONObject8);
            return jSONObject;
        } catch (JSONException e) {
            throw new lIIlllIl(e);
        }
    }

    public final IIllllll IIIIIIIl(JSONObject jSONObject) {
        Context context = this.IIIIIIII;
        int i = jSONObject.getInt(IIIIIllI);
        int i2 = jSONObject.getInt(IIIIIlll);
        long j = jSONObject.getLong(IIIIlIII);
        long optLong = jSONObject.optLong(IIIIlIIl, 0);
        switch (i) {
            case 1:
                return new IlIlIIIl(context, i2, j, optLong);
            case 2:
                return new IlIlIIII(context, i2, j, optLong);
            case 3:
                return new IlIllIlI(context, i2, j, optLong);
            case 4:
                return new IlIllIll(context, i2, j, optLong);
            case 5:
                return new IlIIllll(context, i2, j, optLong);
            case 8:
                return new IlIlIlII(context, i2, j, optLong);
            case 9:
                return new IlIlIlll(context, i2, j, optLong);
            case 10:
                return new IlIlllIl(context, i2, j, optLong);
            case 11:
                return new IlIllllI(context, i2, j, optLong);
            case 12:
                return new IlIIlIll(context, i2, j, optLong);
            case 13:
                return new IlIlIllI(context, i2, j, optLong);
            case 14:
                return new IlIlIlIl(context, i2, j, optLong);
            case 15:
                return new IlIllIIl(context, i2, j, optLong);
            case 16:
                return new IllIIIII(context, i2, j, optLong);
            case 17:
                return new IlIIlIII(context, i2, j, optLong);
            case 18:
                return new IlIIlllI(context, i2, j, optLong);
            case 19:
                return new IlIIllIl(context, i2, j, optLong);
            case 20:
                return new IlIIlIlI(context, i2, j, optLong);
            case 21:
                return new IlIlIIlI(context, i2, j, optLong);
            case 22:
                return new IlIlllII(context, i2, j, optLong);
            case 23:
                return new IlIlIIll(context, i2, j, optLong);
            case 24:
                return new IlIllIII(context, i2, j, optLong);
            case 25:
                return new IlIIllII(context, i2, j, optLong);
            case 26:
                return new IlIIlIIl(context, i2, j, optLong);
            default:
                return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p118io.presage.core.C6350r2 IIIIIIlI(org.json.JSONObject r6) {
        /*
            r5 = this;
            java.lang.String r0 = IIIlIlIl
            int r0 = r6.getInt(r0)
            java.lang.String r1 = IIIlIllI
            boolean r1 = r6.getBoolean(r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 5
            if (r0 != r3) goto L_0x0024
            if (r1 == 0) goto L_0x0024
            java.lang.String r3 = IIIlIlll
            long r3 = r6.getLong(r3)
            java.lang.Long r6 = java.lang.Long.valueOf(r3)
        L_0x0020:
            r2.add(r6)
            goto L_0x0046
        L_0x0024:
            int r3 = r5.IIIIIIIl
            r4 = 2
            if (r3 < r4) goto L_0x0046
            r3 = 6
            if (r0 != r3) goto L_0x0046
            if (r1 == 0) goto L_0x0046
            java.lang.String r3 = IIIlIlll
            long r3 = r6.getLong(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.add(r3)
            java.lang.String r3 = IIIllIII
            int r6 = r6.getInt(r3)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0020
        L_0x0046:
            android.content.Context r6 = r5.IIIIIIII
            java.lang.Object[] r2 = r2.toArray()
            switch(r0) {
                case 1: goto L_0x0081;
                case 2: goto L_0x007b;
                case 3: goto L_0x0075;
                case 4: goto L_0x006f;
                case 5: goto L_0x0069;
                case 6: goto L_0x0063;
                case 7: goto L_0x005d;
                case 8: goto L_0x0057;
                case 9: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            r0 = 0
            goto L_0x0086
        L_0x0051:
            io.presage.core.o2 r0 = new io.presage.core.o2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x0057:
            io.presage.core.m2 r0 = new io.presage.core.m2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x005d:
            io.presage.core.j2 r0 = new io.presage.core.j2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x0063:
            io.presage.core.h2 r0 = new io.presage.core.h2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x0069:
            io.presage.core.i2 r0 = new io.presage.core.i2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x006f:
            io.presage.core.q2 r0 = new io.presage.core.q2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x0075:
            io.presage.core.n2 r0 = new io.presage.core.n2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x007b:
            io.presage.core.l2 r0 = new io.presage.core.l2
            r0.<init>(r6, r1, r2)
            goto L_0x0086
        L_0x0081:
            io.presage.core.k2 r0 = new io.presage.core.k2
            r0.<init>(r6, r1, r2)
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.lIIllllI.IIIIIIlI(org.json.JSONObject):io.presage.core.r2");
    }

    public final JSONObject IIIIIIII(C6350r2 r2Var) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IIIlIlIl, r2Var.IIIIIIII());
        jSONObject.put(IIIlIllI, r2Var.IIIIIIIl);
        if (r2Var.IIIIIIII() == 5 && r2Var.IIIIIIIl) {
            jSONObject.put(IIIlIlll, ((C6314i2) r2Var).IIIIIIll.IIIIIIlI());
        } else if (r2Var.IIIIIIII() == 6 && r2Var.IIIIIIIl) {
            C6310h2 h2Var = (C6310h2) r2Var;
            jSONObject.put(IIIlIlll, h2Var.IIIIIIll.IIIIIIll());
            jSONObject.put(IIIllIII, h2Var.IIIIIIll.IIIIIIIl());
        }
        return jSONObject;
    }

    public lIIllIll IIIIIIII(JSONObject jSONObject) {
        IIIIllII iIIIllII;
        int i;
        boolean z;
        try {
            lIIllIll.IIIIIIII iiiiiiii = new lIIllIll.IIIIIIII();
            iiiiiiii.IIIIIIII.IIIIIIII = jSONObject.getString(IIIIIIlI);
            boolean unused = iiiiiiii.IIIIIIII.IIIIIlIl = jSONObject.getBoolean(IIIIIIll);
            iiiiiiii.IIIIIIII.IIIIIlII = jSONObject.getLong(IIIIIlII);
            JSONObject optJSONObject = jSONObject.optJSONObject(IIlIlIlI);
            if (optJSONObject != null) {
                String string = optJSONObject.getString(IIlIlIll);
                String optString = optJSONObject.optString(IIlIllII, "");
                boolean unused2 = iiiiiiii.IIIIIIII.IIIIIllI = true;
                iiiiiiii.IIIIIIII.IIIIIlll = string;
                iiiiiiii.IIIIIIII.IIIIlIII = optString;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(IIIIIlIl);
            if (optJSONArray != null) {
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        IIllllll IIIIIIIl2 = IIIIIIIl(optJSONArray.getJSONObject(i2));
                        if (IIIIIIIl2 != null) {
                            hashSet.add(IIIIIIIl2);
                        }
                    } catch (Exception e) {
                        lIIIIlIl.IIIIIIII(e, 1);
                    }
                }
                if (!hashSet.isEmpty()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(IIIIlIlI);
                    lIIllIll.IIIIIIIl iIIIIIIl = new lIIllIll.IIIIIIIl(jSONObject2.getInt(IIIIlIll), jSONObject2.getLong(IIIIllII));
                    String string2 = jSONObject.getString(IIIIllIl);
                    boolean unused3 = iiiiiiii.IIIIIIII.IIIIlIIl = true;
                    iiiiiiii.IIIIIIII.IIIIlIll = hashSet;
                    iiiiiiii.IIIIIIII.IIIIlIlI = iIIIIIIl;
                    iiiiiiii.IIIIIIII.IIIIIIIl = string2;
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(IIIlIlII);
            if (optJSONArray2 != null) {
                HashSet hashSet2 = new HashSet();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    try {
                        C6350r2 IIIIIIlI2 = IIIIIIlI(optJSONArray2.getJSONObject(i3));
                        if (IIIIIIlI2 != null) {
                            hashSet2.add(IIIIIIlI2);
                        }
                    } catch (Exception e2) {
                        lIIIIlIl.IIIIIIII(e2, 1);
                    }
                }
                if (!hashSet2.isEmpty()) {
                    iiiiiiii.IIIIIIII.IIIIllII = hashSet2;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(IIIIlllI);
            if (optJSONObject2 != null) {
                HashSet hashSet3 = new HashSet();
                HashSet hashSet4 = new HashSet();
                if (this.IIIIIIIl >= 3) {
                    JSONArray jSONArray = optJSONObject2.getJSONArray(IIIIllll);
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        hashSet3.add(Integer.valueOf(jSONArray.getInt(i4)));
                    }
                } else if (optJSONObject2.getBoolean(IIIIllll)) {
                    hashSet3.add(1);
                }
                if (!hashSet3.isEmpty()) {
                    JSONArray jSONArray2 = optJSONObject2.getJSONArray(IIIlIIII);
                    for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                        hashSet4.add(Integer.valueOf(jSONArray2.getInt(i5)));
                    }
                    iiiiiiii.IIIIIIII.IIIIllIl = hashSet3;
                    iiiiiiii.IIIIIIII.IIIIlllI = hashSet4;
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(IIIlIIIl);
            if (optJSONObject3 != null && z) {
                String string3 = optJSONObject3.getString(IIIlIIll);
                boolean unused4 = iiiiiiii.IIIIIIII.IIIIIIlI = (z = optJSONObject3.getBoolean(IIIlIIlI));
                iiiiiiii.IIIIIIII.IIIIIIll = string3;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray(IIIllIIl);
            if (optJSONArray3 != null) {
                HashSet hashSet5 = new HashSet();
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    try {
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i6);
                        hashSet5.add(new llIllIll(jSONObject3.getInt(IIIllIlI), jSONObject3.getInt(IIIlllII)));
                    } catch (Exception e3) {
                        lIIIIlIl.IIIIIIII(e3, 1);
                    }
                }
                boolean z2 = !hashSet5.isEmpty();
                if (z2) {
                    String string4 = jSONObject.getString(IIIllIll);
                    boolean unused5 = iiiiiiii.IIIIIIII.IIIIllll = z2;
                    iiiiiiii.IIIIIIII.IIIlIIIl = hashSet5;
                    iiiiiiii.IIIIIIII.IIIlIIII = string4;
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(IIIlllIl);
            if (!(optJSONObject4 == null || (i = optJSONObject4.getInt(IIIllllI)) == 0)) {
                String string5 = optJSONObject4.getString(IIIlllll);
                String string6 = optJSONObject4.getString(IIlIIIII);
                int i7 = optJSONObject4.getInt(IIlIIIIl);
                int optInt = optJSONObject4.optInt(IIlIIIlI, 0);
                iiiiiiii.IIIIIIII.IIIlIIlI = i;
                iiiiiiii.IIIIIIII.IIIlIIll = string5;
                iiiiiiii.IIIIIIII.IIIlIlII = string6;
                iiiiiiii.IIIIIIII.IIIlIlIl = i7;
                iiiiiiii.IIIIIIII.IIIlIllI = optInt;
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject(IIlIIIll);
            if (optJSONObject5 != null) {
                int i8 = optJSONObject5.getInt(IIlIIlII);
                if (i8 == 0) {
                    iIIIllII = new IIIIllII(0);
                } else if (i8 != 1) {
                    iIIIllII = new IIIIllII(0);
                } else {
                    iiiiiiii.IIIIIIII.IIIlIlll = new IIIIllII(i8, optJSONObject5.optInt(IIlIIlIl, 0), optJSONObject5.optLong(IIlIIllI, TapjoyConstants.PAID_APP_TIME), optJSONObject5.optLong(IIlIIlll, 910000), optJSONObject5.optLong(IIlIlIII, 30000), optJSONObject5.optInt(IIlIlIIl, 1));
                    return iiiiiiii.IIIIIIII();
                }
            } else {
                iIIIllII = new IIIIllII(0);
            }
            iiiiiiii.IIIIIIII.IIIlIlll = iIIIllII;
            return iiiiiiii.IIIIIIII();
        } catch (JSONException e4) {
            throw new lIIlllIl(e4);
        }
    }
}
