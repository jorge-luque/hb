package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzt;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@SafeParcelable.Class(creator = "QueryCreator")
@SafeParcelable.Reserved({1000})
public class Query extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zzb();
    @SafeParcelable.Field(mo15196id = 7)
    private final List<DriveSpace> zzby;
    @SafeParcelable.Field(mo15196id = 1)
    private final zzr zzlm;
    @SafeParcelable.Field(mo15196id = 3)
    private final String zzln;
    @SafeParcelable.Field(mo15196id = 4)
    private final SortOrder zzlo;
    @SafeParcelable.Field(mo15196id = 5)
    final List<String> zzlp;
    @SafeParcelable.Field(mo15196id = 6)
    final boolean zzlq;
    @SafeParcelable.Field(mo15196id = 8)
    final boolean zzlr;

    private Query(zzr zzr, String str, SortOrder sortOrder, List<String> list, boolean z, Set<DriveSpace> set, boolean z2) {
        this(zzr, str, sortOrder, list, z, (List<DriveSpace>) new ArrayList(set), z2);
    }

    public Filter getFilter() {
        return this.zzlm;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzln;
    }

    public SortOrder getSortOrder() {
        return this.zzlo;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzlm, this.zzlo, this.zzln, this.zzby});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlm, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzln, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzlo, i, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzlp, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzlq);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzby, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzlr);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final Set<DriveSpace> zzbi() {
        return this.zzby == null ? new HashSet() : new HashSet(this.zzby);
    }

    @SafeParcelable.Constructor
    Query(@SafeParcelable.Param(mo15199id = 1) zzr zzr, @SafeParcelable.Param(mo15199id = 3) String str, @SafeParcelable.Param(mo15199id = 4) SortOrder sortOrder, @SafeParcelable.Param(mo15199id = 5) List<String> list, @SafeParcelable.Param(mo15199id = 6) boolean z, @SafeParcelable.Param(mo15199id = 7) List<DriveSpace> list2, @SafeParcelable.Param(mo15199id = 8) boolean z2) {
        this.zzlm = zzr;
        this.zzln = str;
        this.zzlo = sortOrder;
        this.zzlp = list;
        this.zzlq = z;
        this.zzby = list2;
        this.zzlr = z2;
    }

    @VisibleForTesting
    public static class Builder {
        private String zzln;
        private SortOrder zzlo;
        private List<String> zzlp = Collections.emptyList();
        private boolean zzlq;
        private boolean zzlr;
        private final List<Filter> zzls = new ArrayList();
        private Set<DriveSpace> zzlt = Collections.emptySet();

        public Builder() {
        }

        public Builder addFilter(Filter filter) {
            Preconditions.checkNotNull(filter, "Filter may not be null.");
            if (!(filter instanceof zzt)) {
                this.zzls.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new zzr(zzx.zzmv, (Iterable<Filter>) this.zzls), this.zzln, this.zzlo, this.zzlp, this.zzlq, this.zzlt, this.zzlr);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzln = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzlo = sortOrder;
            return this;
        }

        public Builder(Query query) {
            this.zzls.add(query.getFilter());
            this.zzln = query.getPageToken();
            this.zzlo = query.getSortOrder();
            this.zzlp = query.zzlp;
            this.zzlq = query.zzlq;
            query.zzbi();
            this.zzlt = query.zzbi();
            this.zzlr = query.zzlr;
        }
    }
}
