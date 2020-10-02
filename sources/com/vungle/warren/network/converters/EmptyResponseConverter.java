package com.vungle.warren.network.converters;

import p113i.C3484b0;

public class EmptyResponseConverter implements Converter<C3484b0, Void> {
    public Void convert(C3484b0 b0Var) {
        b0Var.close();
        return null;
    }
}
