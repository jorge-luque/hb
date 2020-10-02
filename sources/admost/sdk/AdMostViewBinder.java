package admost.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;

public class AdMostViewBinder implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public AdMostViewBinder createFromParcel(Parcel parcel) {
            return new AdMostViewBinder(parcel);
        }

        public AdMostViewBinder[] newArray(int i) {
            return new AdMostViewBinder[i];
        }
    };
    public final int attributionId;
    public final int backImageId;
    public final int callToActionId;
    public final boolean fixed;
    public final int iconImageId;
    public LayoutInflater inflater;
    public final int layoutId;
    public final int mainImageId;
    public boolean preventClicks;
    public final int privacyIconId;
    public final boolean rounded;
    public final int textId;
    public final int titleId;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.layoutId);
        parcel.writeInt(this.titleId);
        parcel.writeInt(this.textId);
        parcel.writeInt(this.attributionId);
        parcel.writeInt(this.callToActionId);
        parcel.writeInt(this.mainImageId);
        parcel.writeInt(this.iconImageId);
        parcel.writeInt(this.backImageId);
        parcel.writeInt(this.fixed ? 1 : 0);
        parcel.writeInt(this.rounded ? 1 : 0);
        parcel.writeInt(this.privacyIconId);
        parcel.writeInt(this.preventClicks ? 1 : 0);
    }

    private AdMostViewBinder(Builder builder) {
        this.layoutId = builder.layoutId;
        this.titleId = builder.titleId;
        this.textId = builder.textId;
        this.attributionId = builder.attributionId;
        this.callToActionId = builder.callToActionId;
        this.mainImageId = builder.mainImageId;
        this.iconImageId = builder.iconImageId;
        this.backImageId = builder.backImageId;
        this.fixed = builder.fixed;
        this.rounded = builder.rounded;
        this.privacyIconId = builder.privacyIconId;
        this.preventClicks = builder.preventClicks;
        this.inflater = builder.inflater;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int attributionId;
        /* access modifiers changed from: private */
        public int backImageId;
        /* access modifiers changed from: private */
        public int callToActionId;
        /* access modifiers changed from: private */
        public boolean fixed = false;
        /* access modifiers changed from: private */
        public int iconImageId;
        /* access modifiers changed from: private */
        public LayoutInflater inflater;
        /* access modifiers changed from: private */
        public final int layoutId;
        /* access modifiers changed from: private */
        public int mainImageId;
        /* access modifiers changed from: private */
        public boolean preventClicks;
        /* access modifiers changed from: private */
        public int privacyIconId;
        /* access modifiers changed from: private */
        public boolean rounded = false;
        /* access modifiers changed from: private */
        public int textId;
        /* access modifiers changed from: private */
        public int titleId;

        public Builder(int i) {
            this.layoutId = i;
        }

        public final Builder attributionId(int i) {
            this.attributionId = i;
            return this;
        }

        public final Builder backImageId(int i) {
            this.backImageId = i;
            return this;
        }

        public final AdMostViewBinder build() {
            return new AdMostViewBinder(this);
        }

        public final Builder callToActionId(int i) {
            this.callToActionId = i;
            return this;
        }

        public final Builder iconImageId(int i) {
            this.iconImageId = i;
            return this;
        }

        public final Builder isFixed(boolean z) {
            this.fixed = z;
            return this;
        }

        public final Builder isRoundedMode(boolean z) {
            this.rounded = z;
            return this;
        }

        public final Builder mainImageId(int i) {
            this.mainImageId = i;
            return this;
        }

        public final Builder preventClicks(boolean z) {
            this.preventClicks = z;
            return this;
        }

        public final Builder privacyIconId(int i) {
            this.privacyIconId = i;
            return this;
        }

        public final Builder textId(int i) {
            this.textId = i;
            return this;
        }

        public final Builder titleId(int i) {
            this.titleId = i;
            return this;
        }

        public Builder(int i, LayoutInflater layoutInflater) {
            this.layoutId = i;
            this.inflater = layoutInflater;
        }
    }

    private AdMostViewBinder(Parcel parcel) {
        this.layoutId = parcel.readInt();
        this.titleId = parcel.readInt();
        this.textId = parcel.readInt();
        this.attributionId = parcel.readInt();
        this.callToActionId = parcel.readInt();
        this.mainImageId = parcel.readInt();
        this.iconImageId = parcel.readInt();
        this.backImageId = parcel.readInt();
        boolean z = false;
        this.fixed = parcel.readInt() == 1;
        this.rounded = parcel.readInt() == 1;
        this.privacyIconId = parcel.readInt();
        this.preventClicks = parcel.readInt() == 1 ? true : z;
    }
}
