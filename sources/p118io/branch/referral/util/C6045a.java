package p118io.branch.referral.util;

import android.text.TextUtils;

/* renamed from: io.branch.referral.util.a */
/* compiled from: BranchContentSchema */
public enum C6045a {
    COMMERCE_AUCTION,
    COMMERCE_BUSINESS,
    COMMERCE_OTHER,
    COMMERCE_PRODUCT,
    COMMERCE_RESTAURANT,
    COMMERCE_SERVICE,
    COMMERCE_TRAVEL_FLIGHT,
    COMMERCE_TRAVEL_HOTEL,
    COMMERCE_TRAVEL_OTHER,
    GAME_STATE,
    MEDIA_IMAGE,
    MEDIA_MIXED,
    MEDIA_MUSIC,
    MEDIA_OTHER,
    MEDIA_VIDEO,
    OTHER,
    TEXT_ARTICLE,
    TEXT_BLOG,
    TEXT_OTHER,
    TEXT_RECIPE,
    TEXT_REVIEW,
    TEXT_SEARCH_RESULTS,
    TEXT_STORY,
    TEXT_TECHNICAL_DOC;

    /* renamed from: a */
    public static C6045a[] m19547a() {
        return (C6045a[]) f15737y.clone();
    }

    /* renamed from: a */
    public static C6045a m19546a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (C6045a aVar : m19547a()) {
                if (aVar.name().equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }
}
