package com.google.android.gms.drive;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import java.util.List;

public final class OpenFileActivityOptions {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    public final String zzba;
    public final String[] zzbb;
    public final DriveId zzbd;
    public final FilterHolder zzbe;

    public static class Builder {
        private final OpenFileActivityBuilder zzbf = new OpenFileActivityBuilder();

        public OpenFileActivityOptions build() {
            this.zzbf.zzg();
            return new OpenFileActivityOptions(this.zzbf.getTitle(), this.zzbf.zzs(), this.zzbf.zzt(), this.zzbf.zzu());
        }

        public Builder setActivityStartFolder(DriveId driveId) {
            this.zzbf.setActivityStartFolder(driveId);
            return this;
        }

        public Builder setActivityTitle(String str) {
            this.zzbf.setActivityTitle(str);
            return this;
        }

        public Builder setMimeType(List<String> list) {
            this.zzbf.setMimeType((String[]) list.toArray(new String[0]));
            return this;
        }

        public Builder setSelectionFilter(Filter filter) {
            this.zzbf.setSelectionFilter(filter);
            return this;
        }
    }

    private OpenFileActivityOptions(String str, String[] strArr, Filter filter, DriveId driveId) {
        FilterHolder filterHolder;
        this.zzba = str;
        this.zzbb = strArr;
        if (filter == null) {
            filterHolder = null;
        } else {
            filterHolder = new FilterHolder(filter);
        }
        this.zzbe = filterHolder;
        this.zzbd = driveId;
    }
}
