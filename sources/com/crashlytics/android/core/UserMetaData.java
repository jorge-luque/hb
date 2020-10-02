package com.crashlytics.android.core;

public class UserMetaData {
    public static final UserMetaData EMPTY = new UserMetaData();
    public final String email;

    /* renamed from: id */
    public final String f7623id;
    public final String name;

    public UserMetaData() {
        this((String) null, (String) null, (String) null);
    }

    public boolean isEmpty() {
        return this.f7623id == null && this.name == null && this.email == null;
    }

    public UserMetaData(String str, String str2, String str3) {
        this.f7623id = str;
        this.name = str2;
        this.email = str3;
    }
}
