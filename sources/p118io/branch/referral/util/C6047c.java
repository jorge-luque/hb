package p118io.branch.referral.util;

import android.text.TextUtils;

/* renamed from: io.branch.referral.util.c */
/* compiled from: ProductCategory */
public enum C6047c {
    ANIMALS_AND_PET_SUPPLIES("Animals & Pet Supplies"),
    APPAREL_AND_ACCESSORIES("Apparel & Accessories"),
    ARTS_AND_ENTERTAINMENT("Arts & Entertainment"),
    BABY_AND_TODDLER("Baby & Toddler"),
    BUSINESS_AND_INDUSTRIAL("Business & Industrial"),
    CAMERAS_AND_OPTICS("Cameras & Optics"),
    ELECTRONICS("Electronics"),
    FOOD_BEVERAGES_AND_TOBACCO("Food, Beverages & Tobacco"),
    FURNITURE("Furniture"),
    HARDWARE("Hardware"),
    HEALTH_AND_BEAUTY("Health & Beauty"),
    HOME_AND_GARDEN("Home & Garden"),
    LUGGAGE_AND_BAGS("Luggage & Bags"),
    MATURE("Mature"),
    f15932p("Media"),
    OFFICE_SUPPLIES("Office Supplies"),
    RELIGIOUS_AND_CEREMONIAL("Religious & Ceremonial"),
    SOFTWARE("Software"),
    SPORTING_GOODS("Sporting Goods"),
    TOYS_AND_GAMES("Toys & Games"),
    VEHICLES_AND_PARTS("Vehicles & Parts");
    

    /* renamed from: a */
    private String f15940a;

    private C6047c(String str) {
        this.f15940a = str;
    }

    /* renamed from: b */
    public static C6047c[] m19551b() {
        return (C6047c[]) f15939w.clone();
    }

    /* renamed from: a */
    public String mo34057a() {
        return this.f15940a;
    }

    /* renamed from: a */
    public static C6047c m19550a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (C6047c cVar : m19551b()) {
                if (cVar.f15940a.equalsIgnoreCase(str)) {
                    return cVar;
                }
            }
        }
        return null;
    }
}
