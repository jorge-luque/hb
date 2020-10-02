package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountRequestCreator")
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zam();
    @SafeParcelable.VersionField(mo15202id = 1)
    private final int zalf;
    @SafeParcelable.Field(getter = "getSessionId", mo15196id = 3)
    private final int zapa;
    @SafeParcelable.Field(getter = "getSignInAccountHint", mo15196id = 4)
    private final GoogleSignInAccount zapb;
    @SafeParcelable.Field(getter = "getAccount", mo15196id = 2)
    private final Account zax;

    @SafeParcelable.Constructor
    ResolveAccountRequest(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) Account account, @SafeParcelable.Param(mo15199id = 3) int i2, @SafeParcelable.Param(mo15199id = 4) GoogleSignInAccount googleSignInAccount) {
        this.zalf = i;
        this.zax = account;
        this.zapa = i2;
        this.zapb = googleSignInAccount;
    }

    public Account getAccount() {
        return this.zax;
    }

    public int getSessionId() {
        return this.zapa;
    }

    public GoogleSignInAccount getSignInAccountHint() {
        return this.zapb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zalf);
        SafeParcelWriter.writeParcelable(parcel, 2, getAccount(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getSessionId());
        SafeParcelWriter.writeParcelable(parcel, 4, getSignInAccountHint(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }
}
