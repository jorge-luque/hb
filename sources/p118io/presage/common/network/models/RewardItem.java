package p118io.presage.common.network.models;

import java.io.Serializable;
import p118io.presage.C6514hl;

/* renamed from: io.presage.common.network.models.RewardItem */
public final class RewardItem implements Serializable {

    /* renamed from: a */
    private String f16926a;

    /* renamed from: b */
    private String f16927b;

    public RewardItem(String str, String str2) {
        this.f16926a = str;
        this.f16927b = str2;
    }

    public static /* synthetic */ RewardItem copy$default(RewardItem rewardItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rewardItem.f16926a;
        }
        if ((i & 2) != 0) {
            str2 = rewardItem.f16927b;
        }
        return rewardItem.copy(str, str2);
    }

    public final String component1() {
        return this.f16926a;
    }

    public final String component2() {
        return this.f16927b;
    }

    public final RewardItem copy(String str, String str2) {
        return new RewardItem(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardItem)) {
            return false;
        }
        RewardItem rewardItem = (RewardItem) obj;
        return C6514hl.m21416a((Object) this.f16926a, (Object) rewardItem.f16926a) && C6514hl.m21416a((Object) this.f16927b, (Object) rewardItem.f16927b);
    }

    public final String getName() {
        return this.f16926a;
    }

    public final String getValue() {
        return this.f16927b;
    }

    public final int hashCode() {
        String str = this.f16926a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f16927b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final void setName(String str) {
        this.f16926a = str;
    }

    public final void setValue(String str) {
        this.f16927b = str;
    }

    public final String toString() {
        return "RewardItem(name=" + this.f16926a + ", value=" + this.f16927b + ")";
    }
}
