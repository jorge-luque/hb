package admost.sdk.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AdMostWaterfallLog implements Parcelable {
    public static final Parcelable.Creator<AdMostWaterfallLog> CREATOR = new Parcelable.Creator<AdMostWaterfallLog>() {
        public AdMostWaterfallLog createFromParcel(Parcel parcel) {
            return new AdMostWaterfallLog(parcel);
        }

        public AdMostWaterfallLog[] newArray(int i) {
            return new AdMostWaterfallLog[i];
        }
    };
    public boolean addPlacementsAboveLastECPM;
    public int addPlacementsAboveLastECPMValue;
    public boolean addedBecauseOfAlwaysInWaterfall;
    public String defaultFPStatus;
    public long failedAt;
    public long filledAt;
    public boolean isBidFill;
    public boolean isBidRequested;
    public boolean isBidTimeout;
    public boolean isCached;
    public boolean isDefaultForFP;
    public boolean isDefaultForFPHead;
    public boolean isFilled;
    public boolean isRandomItem;
    public boolean isReplacedForRandomSelectedOtherOne;
    public boolean isShown;
    public boolean isTried;
    public int numberOfItemInFPList;
    public int positionInFPList;
    public int requestCount;
    public int responseCount;
    public long triedAt;
    public long triedAt2;

    AdMostWaterfallLog() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isRandomItem ? (byte) 1 : 0);
        parcel.writeByte(this.isDefaultForFP ? (byte) 1 : 0);
        parcel.writeString(this.defaultFPStatus);
        parcel.writeByte(this.isReplacedForRandomSelectedOtherOne ? (byte) 1 : 0);
        parcel.writeInt(this.positionInFPList);
        parcel.writeInt(this.numberOfItemInFPList);
        parcel.writeByte(this.isFilled ? (byte) 1 : 0);
        parcel.writeLong(this.filledAt);
        parcel.writeLong(this.failedAt);
        parcel.writeByte(this.isTried ? (byte) 1 : 0);
        parcel.writeLong(this.triedAt);
        parcel.writeLong(this.triedAt2);
        parcel.writeInt(this.requestCount);
        parcel.writeInt(this.responseCount);
        parcel.writeByte(this.addedBecauseOfAlwaysInWaterfall ? (byte) 1 : 0);
        parcel.writeByte(this.addPlacementsAboveLastECPM ? (byte) 1 : 0);
        parcel.writeInt(this.addPlacementsAboveLastECPMValue);
        parcel.writeByte(this.isShown ? (byte) 1 : 0);
        parcel.writeByte(this.isCached ? (byte) 1 : 0);
        parcel.writeByte(this.isDefaultForFPHead ? (byte) 1 : 0);
        parcel.writeByte(this.isBidTimeout ? (byte) 1 : 0);
        parcel.writeByte(this.isBidRequested ? (byte) 1 : 0);
        parcel.writeByte(this.isBidFill ? (byte) 1 : 0);
    }

    protected AdMostWaterfallLog(Parcel parcel) {
        boolean z = true;
        this.isRandomItem = parcel.readByte() != 0;
        this.isDefaultForFP = parcel.readByte() != 0;
        this.defaultFPStatus = parcel.readString();
        this.isReplacedForRandomSelectedOtherOne = parcel.readByte() != 0;
        this.positionInFPList = parcel.readInt();
        this.numberOfItemInFPList = parcel.readInt();
        this.isFilled = parcel.readByte() != 0;
        this.filledAt = parcel.readLong();
        this.failedAt = parcel.readLong();
        this.isTried = parcel.readByte() != 0;
        this.triedAt = parcel.readLong();
        this.triedAt2 = parcel.readLong();
        this.requestCount = parcel.readInt();
        this.responseCount = parcel.readInt();
        this.addedBecauseOfAlwaysInWaterfall = parcel.readByte() != 0;
        this.addPlacementsAboveLastECPM = parcel.readByte() != 0;
        this.addPlacementsAboveLastECPMValue = parcel.readInt();
        this.isShown = parcel.readByte() != 0;
        this.isCached = parcel.readByte() != 0;
        this.isDefaultForFPHead = parcel.readByte() != 0;
        this.isBidTimeout = parcel.readByte() != 0;
        this.isBidRequested = parcel.readByte() != 0;
        this.isBidFill = parcel.readByte() == 0 ? false : z;
    }
}
