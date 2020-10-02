package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzln;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzku {
    private static final int zzawy = zzov.zzbj("nam");
    private static final int zzawz = zzov.zzbj("trk");
    private static final int zzaxa = zzov.zzbj("cmt");
    private static final int zzaxb = zzov.zzbj("day");
    private static final int zzaxc = zzov.zzbj("ART");
    private static final int zzaxd = zzov.zzbj("too");
    private static final int zzaxe = zzov.zzbj("alb");
    private static final int zzaxf = zzov.zzbj("com");
    private static final int zzaxg = zzov.zzbj("wrt");
    private static final int zzaxh = zzov.zzbj("lyr");
    private static final int zzaxi = zzov.zzbj("gen");
    private static final int zzaxj = zzov.zzbj("covr");
    private static final int zzaxk = zzov.zzbj("gnre");
    private static final int zzaxl = zzov.zzbj("grp");
    private static final int zzaxm = zzov.zzbj("disk");
    private static final int zzaxn = zzov.zzbj("trkn");
    private static final int zzaxo = zzov.zzbj("tmpo");
    private static final int zzaxp = zzov.zzbj("cpil");
    private static final int zzaxq = zzov.zzbj("aART");
    private static final int zzaxr = zzov.zzbj("sonm");
    private static final int zzaxs = zzov.zzbj("soal");
    private static final int zzaxt = zzov.zzbj("soar");
    private static final int zzaxu = zzov.zzbj("soaa");
    private static final int zzaxv = zzov.zzbj("soco");
    private static final int zzaxw = zzov.zzbj("rtng");
    private static final int zzaxx = zzov.zzbj("pgap");
    private static final int zzaxy = zzov.zzbj("sosn");
    private static final int zzaxz = zzov.zzbj("tvsh");
    private static final int zzaya = zzov.zzbj("----");
    private static final String[] zzayb = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzlt zza(int i, String str, zzos zzos) {
        int readInt = zzos.readInt();
        if (zzos.readInt() == zzki.zzavf) {
            zzos.zzbj(8);
            return new zzlt(str, (String) null, zzos.zzbk(readInt - 16));
        }
        String valueOf = String.valueOf(zzki.zzar(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzlt zzb(int i, String str, zzos zzos) {
        int readInt = zzos.readInt();
        if (zzos.readInt() == zzki.zzavf && readInt >= 22) {
            zzos.zzbj(10);
            int readUnsignedShort = zzos.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzos.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzlt(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzki.zzar(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    public static zzln.zza zzd(zzos zzos) {
        int position = zzos.getPosition() + zzos.readInt();
        int readInt = zzos.readInt();
        int i = readInt >>> 24;
        zzlu zzlu = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & readInt;
            if (i2 == zzaxa) {
                int readInt2 = zzos.readInt();
                if (zzos.readInt() == zzki.zzavf) {
                    zzos.zzbj(8);
                    String zzbk = zzos.zzbk(readInt2 - 16);
                    zzlu = new zzlp("und", zzbk, zzbk);
                } else {
                    String valueOf = String.valueOf(zzki.zzar(readInt));
                    Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                }
                zzos.zzbi(position);
                return zzlu;
            }
            if (i2 != zzawy) {
                if (i2 != zzawz) {
                    if (i2 != zzaxf) {
                        if (i2 != zzaxg) {
                            if (i2 == zzaxb) {
                                zzlt zza = zza(readInt, "TDRC", zzos);
                                zzos.zzbi(position);
                                return zza;
                            } else if (i2 == zzaxc) {
                                zzlt zza2 = zza(readInt, "TPE1", zzos);
                                zzos.zzbi(position);
                                return zza2;
                            } else if (i2 == zzaxd) {
                                zzlt zza3 = zza(readInt, "TSSE", zzos);
                                zzos.zzbi(position);
                                return zza3;
                            } else if (i2 == zzaxe) {
                                zzlt zza4 = zza(readInt, "TALB", zzos);
                                zzos.zzbi(position);
                                return zza4;
                            } else if (i2 == zzaxh) {
                                zzlt zza5 = zza(readInt, "USLT", zzos);
                                zzos.zzbi(position);
                                return zza5;
                            } else if (i2 == zzaxi) {
                                zzlt zza6 = zza(readInt, "TCON", zzos);
                                zzos.zzbi(position);
                                return zza6;
                            } else if (i2 == zzaxl) {
                                zzlt zza7 = zza(readInt, "TIT1", zzos);
                                zzos.zzbi(position);
                                return zza7;
                            }
                        }
                    }
                    zzlt zza8 = zza(readInt, "TCOM", zzos);
                    zzos.zzbi(position);
                    return zza8;
                }
            }
            zzlt zza9 = zza(readInt, "TIT2", zzos);
            zzos.zzbi(position);
            return zza9;
        }
        try {
            if (readInt == zzaxk) {
                int zze = zze(zzos);
                String str = (zze <= 0 || zze > zzayb.length) ? null : zzayb[zze - 1];
                if (str != null) {
                    zzlu = new zzlt("TCON", (String) null, str);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                }
                return zzlu;
            } else if (readInt == zzaxm) {
                zzlt zzb = zzb(readInt, "TPOS", zzos);
                zzos.zzbi(position);
                return zzb;
            } else if (readInt == zzaxn) {
                zzlt zzb2 = zzb(readInt, "TRCK", zzos);
                zzos.zzbi(position);
                return zzb2;
            } else if (readInt == zzaxo) {
                zzlu zza10 = zza(readInt, "TBPM", zzos, true, false);
                zzos.zzbi(position);
                return zza10;
            } else if (readInt == zzaxp) {
                zzlu zza11 = zza(readInt, "TCMP", zzos, true, true);
                zzos.zzbi(position);
                return zza11;
            } else if (readInt == zzaxj) {
                int readInt3 = zzos.readInt();
                if (zzos.readInt() == zzki.zzavf) {
                    int zzaq = zzki.zzaq(zzos.readInt());
                    String str2 = zzaq == 13 ? "image/jpeg" : zzaq == 14 ? "image/png" : null;
                    if (str2 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(zzaq);
                        Log.w("MetadataUtil", sb.toString());
                    } else {
                        zzos.zzbj(4);
                        int i3 = readInt3 - 16;
                        byte[] bArr = new byte[i3];
                        zzos.zze(bArr, 0, i3);
                        zzlu = new zzlo(str2, (String) null, 3, bArr);
                    }
                } else {
                    Log.w("MetadataUtil", "Failed to parse cover art attribute");
                }
                zzos.zzbi(position);
                return zzlu;
            } else if (readInt == zzaxq) {
                zzlt zza12 = zza(readInt, "TPE2", zzos);
                zzos.zzbi(position);
                return zza12;
            } else if (readInt == zzaxr) {
                zzlt zza13 = zza(readInt, "TSOT", zzos);
                zzos.zzbi(position);
                return zza13;
            } else if (readInt == zzaxs) {
                zzlt zza14 = zza(readInt, "TSO2", zzos);
                zzos.zzbi(position);
                return zza14;
            } else if (readInt == zzaxt) {
                zzlt zza15 = zza(readInt, "TSOA", zzos);
                zzos.zzbi(position);
                return zza15;
            } else if (readInt == zzaxu) {
                zzlt zza16 = zza(readInt, "TSOP", zzos);
                zzos.zzbi(position);
                return zza16;
            } else if (readInt == zzaxv) {
                zzlt zza17 = zza(readInt, "TSOC", zzos);
                zzos.zzbi(position);
                return zza17;
            } else if (readInt == zzaxw) {
                zzlu zza18 = zza(readInt, "ITUNESADVISORY", zzos, false, false);
                zzos.zzbi(position);
                return zza18;
            } else if (readInt == zzaxx) {
                zzlu zza19 = zza(readInt, "ITUNESGAPLESS", zzos, false, true);
                zzos.zzbi(position);
                return zza19;
            } else if (readInt == zzaxy) {
                zzlt zza20 = zza(readInt, "TVSHOWSORT", zzos);
                zzos.zzbi(position);
                return zza20;
            } else if (readInt == zzaxz) {
                zzlt zza21 = zza(readInt, "TVSHOW", zzos);
                zzos.zzbi(position);
                return zza21;
            } else if (readInt == zzaya) {
                String str3 = null;
                String str4 = null;
                int i4 = -1;
                int i5 = -1;
                while (zzos.getPosition() < position) {
                    int position2 = zzos.getPosition();
                    int readInt4 = zzos.readInt();
                    int readInt5 = zzos.readInt();
                    zzos.zzbj(4);
                    if (readInt5 == zzki.zzavd) {
                        str3 = zzos.zzbk(readInt4 - 12);
                    } else if (readInt5 == zzki.zzave) {
                        str4 = zzos.zzbk(readInt4 - 12);
                    } else {
                        if (readInt5 == zzki.zzavf) {
                            i4 = position2;
                            i5 = readInt4;
                        }
                        zzos.zzbj(readInt4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4)) {
                    if (i4 != -1) {
                        zzos.zzbi(i4);
                        zzos.zzbj(16);
                        zzlu = new zzlp("und", str4, zzos.zzbk(i5 - 16));
                    }
                }
                zzos.zzbi(position);
                return zzlu;
            }
        } finally {
            zzos.zzbi(position);
        }
        String valueOf2 = String.valueOf(zzki.zzar(readInt));
        if (valueOf2.length() != 0) {
            "Skipped unknown metadata entry: ".concat(valueOf2);
        } else {
            new String("Skipped unknown metadata entry: ");
        }
        zzos.zzbi(position);
        return null;
    }

    private static int zze(zzos zzos) {
        zzos.zzbj(4);
        if (zzos.readInt() == zzki.zzavf) {
            zzos.zzbj(8);
            return zzos.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzlu zza(int i, String str, zzos zzos, boolean z, boolean z2) {
        int zze = zze(zzos);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze < 0) {
            String valueOf = String.valueOf(zzki.zzar(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
            return null;
        } else if (z) {
            return new zzlt(str, (String) null, Integer.toString(zze));
        } else {
            return new zzlp("und", str, Integer.toString(zze));
        }
    }
}
