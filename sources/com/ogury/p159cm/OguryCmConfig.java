package com.ogury.p159cm;

/* renamed from: com.ogury.cm.OguryCmConfig */
public final class OguryCmConfig {
    private final int tcfVersion;

    public OguryCmConfig() {
        this(2);
    }

    public OguryCmConfig(int i) {
        this.tcfVersion = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OguryCmConfig(int i, int i2, baaca baaca) {
        this((i2 & 1) != 0 ? 2 : i);
    }

    public static /* synthetic */ OguryCmConfig copy$default(OguryCmConfig oguryCmConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = oguryCmConfig.tcfVersion;
        }
        return oguryCmConfig.copy(i);
    }

    public final int component1() {
        return this.tcfVersion;
    }

    public final OguryCmConfig copy(int i) {
        return new OguryCmConfig(i);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof OguryCmConfig) {
                if (this.tcfVersion == ((OguryCmConfig) obj).tcfVersion) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int getTcfVersion() {
        return this.tcfVersion;
    }

    public final int hashCode() {
        return this.tcfVersion;
    }

    public final String toString() {
        return "OguryCmConfig(tcfVersion=" + this.tcfVersion + ")";
    }
}
