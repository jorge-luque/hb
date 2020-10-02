package com.iab.omid.library.adcolony.adsession;

public enum ImpressionType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");
    

    /* renamed from: a */
    private final String f11135a;

    private ImpressionType(String str) {
        this.f11135a = str;
    }

    public String toString() {
        return this.f11135a;
    }
}
