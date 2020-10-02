package com.criteo.publisher.model;

import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p054a0.C2340o;

public abstract class AdUnit {

    /* renamed from: a */
    private final String f7848a;

    /* renamed from: b */
    private final C2321a f7849b;

    protected AdUnit(String str, C2321a aVar) {
        this.f7848a = str;
        this.f7849b = aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdUnit adUnit = (AdUnit) obj;
        if (!C2340o.m8994a(this.f7848a, adUnit.f7848a) || this.f7849b != adUnit.f7849b) {
            return false;
        }
        return true;
    }

    public String getAdUnitId() {
        return this.f7848a;
    }

    public C2321a getAdUnitType() {
        return this.f7849b;
    }

    public int hashCode() {
        return C2340o.m8993a(this.f7848a, this.f7849b);
    }
}
