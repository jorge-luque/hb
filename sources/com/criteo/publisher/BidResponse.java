package com.criteo.publisher;

public final class BidResponse {

    /* renamed from: a */
    private final double f7624a;

    /* renamed from: b */
    private final BidToken f7625b;

    /* renamed from: c */
    private final boolean f7626c;

    protected BidResponse(double d, BidToken bidToken, boolean z) {
        this.f7624a = d;
        this.f7625b = bidToken;
        this.f7626c = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BidResponse.class != obj.getClass()) {
            return false;
        }
        BidResponse bidResponse = (BidResponse) obj;
        if (Double.compare(bidResponse.f7624a, this.f7624a) != 0 || this.f7626c != bidResponse.f7626c) {
            return false;
        }
        BidToken bidToken = this.f7625b;
        BidToken bidToken2 = bidResponse.f7625b;
        if (bidToken != null) {
            return bidToken.equals(bidToken2);
        }
        if (bidToken2 == null) {
            return true;
        }
        return false;
    }

    public BidToken getBidToken() {
        return this.f7625b;
    }

    public double getPrice() {
        return this.f7624a;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f7624a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        BidToken bidToken = this.f7625b;
        return ((i + (bidToken != null ? bidToken.hashCode() : 0)) * 31) + (this.f7626c ? 1 : 0);
    }

    public boolean isBidSuccess() {
        return this.f7626c;
    }

    protected BidResponse() {
        this.f7624a = 0.0d;
        this.f7625b = null;
        this.f7626c = false;
    }
}
