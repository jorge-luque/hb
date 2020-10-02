package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeaj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzeag<MessageType extends zzeag<MessageType, BuilderType>, BuilderType extends zzeaj<MessageType, BuilderType>> implements zzedo {
    protected int zzhsq = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzecg.checkNotNull(iterable);
        if (iterable instanceof zzecv) {
            List<?> zzbfs = ((zzecv) iterable).zzbfs();
            zzecv zzecv = (zzecv) list;
            int size = list.size();
            for (Object next : zzbfs) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzecv.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzecv.size() - 1; size2 >= size; size2--) {
                        zzecv.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzeaq) {
                    zzecv.zzaj((zzeaq) next);
                } else {
                    zzecv.add((String) next);
                }
            }
        } else if (iterable instanceof zzeea) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbex()];
            zzebk zzw = zzebk.zzw(bArr);
            zzb(zzw);
            zzw.zzbdz();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final zzeaq zzbce() {
        try {
            zzeay zzfq = zzeaq.zzfq(zzbex());
            zzb(zzfq.zzbcx());
            return zzfq.zzbcw();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbcf() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzfk(int i) {
        throw new UnsupportedOperationException();
    }
}
