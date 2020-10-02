package admost.sdk.model;

public class AdMostZoneFrequencyCapItem {
    public boolean isCapAvailable;
    public long timeLeftForCap;

    public AdMostZoneFrequencyCapItem(boolean z, long j) {
        this.isCapAvailable = z;
        this.timeLeftForCap = j;
    }
}
