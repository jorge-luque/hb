package com.vungle.warren;

import android.util.Log;
import com.tapjoy.TJAdUnitConstants;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.SendReportsJob;
import java.util.Map;

public class AdEventListener implements AdContract.AdvertisementPresenter.EventListener {
    private static final String TAG = "com.vungle.warren.AdEventListener";
    private final AdLoader adLoader;
    private boolean adRewarded;
    private Advertisement advertisement;
    private final JobRunner jobRunner;
    private int percentViewed = -1;
    private Placement placement;
    private final String placementId;
    private final PlayAdCallback playAdCallback;
    private final Map<String, Boolean> playOperations;
    private final Repository repository;
    private boolean successfulView;
    private final VisionController visionController;

    AdEventListener(String str, Map<String, Boolean> map, PlayAdCallback playAdCallback2, Repository repository2, AdLoader adLoader2, JobRunner jobRunner2, VisionController visionController2, Placement placement2, Advertisement advertisement2) {
        this.placementId = str;
        this.playOperations = map;
        this.playAdCallback = playAdCallback2;
        this.repository = repository2;
        this.adLoader = adLoader2;
        this.jobRunner = jobRunner2;
        this.visionController = visionController2;
        this.placement = placement2;
        this.advertisement = advertisement2;
        map.put(str, true);
    }

    public void onError(VungleException vungleException, String str) {
        if (this.advertisement == null) {
            this.advertisement = this.repository.findValidAdvertisementForPlacement(str).get();
        }
        if (this.advertisement == null || vungleException.getExceptionCode() != 27) {
            if (!(this.advertisement == null || vungleException.getExceptionCode() == 15 || vungleException.getExceptionCode() == 25)) {
                try {
                    this.repository.saveAndApplyState(this.advertisement, str, 4);
                } catch (DatabaseHelper.DBException unused) {
                    vungleException = new VungleException(26);
                }
            }
            onFinished();
            PlayAdCallback playAdCallback2 = this.playAdCallback;
            if (playAdCallback2 != null) {
                playAdCallback2.onError(str, vungleException);
                return;
            }
            return;
        }
        this.adLoader.dropCache(this.advertisement.getId());
    }

    /* access modifiers changed from: protected */
    public void onFinished() {
        this.playOperations.put(this.placementId, false);
    }

    public void onNext(String str, String str2, String str3) {
        boolean z;
        Class<Placement> cls = Placement.class;
        if (this.advertisement == null) {
            Advertisement advertisement2 = this.repository.findValidAdvertisementForPlacement(this.placementId).get();
            this.advertisement = advertisement2;
            if (advertisement2 == null) {
                Log.e(TAG, "No Advertisement for ID");
                onFinished();
                PlayAdCallback playAdCallback2 = this.playAdCallback;
                if (playAdCallback2 != null) {
                    playAdCallback2.onError(this.placementId, new VungleException(10));
                    return;
                }
                return;
            }
        }
        if (this.placement == null) {
            Placement placement2 = this.repository.load(this.placementId, cls).get();
            this.placement = placement2;
            if (placement2 == null) {
                Log.e(TAG, "No Placement for ID");
                onFinished();
                PlayAdCallback playAdCallback3 = this.playAdCallback;
                if (playAdCallback3 != null) {
                    playAdCallback3.onError(this.placementId, new VungleException(13));
                    return;
                }
                return;
            }
        }
        try {
            boolean z2 = false;
            if (str.equals(TJAdUnitConstants.String.VIDEO_START)) {
                this.repository.saveAndApplyState(this.advertisement, str3, 2);
                if (this.playAdCallback != null) {
                    this.playAdCallback.onAdStart(str3);
                }
                this.percentViewed = 0;
                Placement placement3 = this.repository.load(this.placementId, cls).get();
                this.placement = placement3;
                if (placement3 != null && placement3.isAutoCached()) {
                    this.adLoader.loadEndless(this.placement, 0);
                }
            } else if (str.equals("end")) {
                "Cleaning up metadata and assets for placement " + str3 + " and advertisement " + this.advertisement.getId();
                this.repository.saveAndApplyState(this.advertisement, str3, 3);
                this.repository.updateAndSaveReportState(str3, this.advertisement.getAppID(), 0, 1);
                this.jobRunner.execute(SendReportsJob.makeJobInfo(false));
                onFinished();
                if (this.playAdCallback != null) {
                    PlayAdCallback playAdCallback4 = this.playAdCallback;
                    if (!this.successfulView) {
                        if (this.percentViewed < 80) {
                            z = false;
                            if (str2 != null && str2.equals("isCTAClicked")) {
                                z2 = true;
                            }
                            playAdCallback4.onAdEnd(str3, z, z2);
                            this.playAdCallback.onAdEnd(str3);
                        }
                    }
                    z = true;
                    z2 = true;
                    playAdCallback4.onAdEnd(str3, z, z2);
                    this.playAdCallback.onAdEnd(str3);
                }
                if (this.visionController.isEnabled()) {
                    this.visionController.reportData(this.advertisement.getCreativeId(), this.advertisement.getCampaignId(), this.advertisement.getAdvertiserAppId());
                }
            } else if (this.placement.isIncentivized() && str.equals("successfulView")) {
                this.successfulView = true;
                if (!this.adRewarded) {
                    this.adRewarded = true;
                    if (this.playAdCallback != null) {
                        this.playAdCallback.onAdRewarded(str3);
                    }
                }
            } else if (this.placement.isIncentivized() && str.startsWith("percentViewed")) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    this.percentViewed = Integer.parseInt(split[1]);
                }
                if (!this.adRewarded && this.percentViewed >= 80) {
                    this.adRewarded = true;
                    if (this.playAdCallback != null) {
                        this.playAdCallback.onAdRewarded(str3);
                    }
                }
            } else if ("open".equals(str) && this.playAdCallback != null) {
                if ("adClick".equals(str2)) {
                    this.playAdCallback.onAdClick(str3);
                } else if ("adLeftApplication".equals(str2)) {
                    this.playAdCallback.onAdLeftApplication(str3);
                }
            }
        } catch (DatabaseHelper.DBException unused) {
            onError(new VungleException(26), str3);
        }
    }
}
