package com.applovin.mediation;

public class MaxReward {
    public static final int DEFAULT_AMOUNT = 0;
    public static final String DEFAULT_LABEL = "";

    /* renamed from: a */
    private final String f6785a;

    /* renamed from: b */
    private final int f6786b;

    private MaxReward(int i, String str) {
        if (i >= 0) {
            this.f6785a = str;
            this.f6786b = i;
            return;
        }
        throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
    }

    public static MaxReward create(int i, String str) {
        return new MaxReward(i, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    public final int getAmount() {
        return this.f6786b;
    }

    public final String getLabel() {
        return this.f6785a;
    }

    public String toString() {
        return "MaxReward{amount=" + this.f6786b + ", label='" + this.f6785a + '\'' + '}';
    }
}
