package admost.sdk.base;

import admost.sdk.model.AdMostAdPolicyItem;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostFrequencyCappingItem;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostPolicyManager {
    private static final String ACTION_TYPE_CAP_FREQ = "cap_freq";
    private static final String ACTION_TYPE_NO_AD = "no_ad";
    private static final String ACTION_TYPE_SET_INTERVAL = "set_interval";
    private static AdMostPolicyManager instance;
    private static final Object lock = new Object();
    private static final Object policyListLock = new Object();
    private ArrayList<AdMostAdPolicyItem> tagPolicies;
    private ArrayList<AdMostAdPolicyItem> zonePolicies;

    private AdMostPolicyManager() {
    }

    public static AdMostPolicyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostPolicyManager();
                }
            }
        }
        return instance;
    }

    private void parseData(JSONArray jSONArray, JSONArray jSONArray2) {
        synchronized (policyListLock) {
            this.zonePolicies = new ArrayList<>();
            int i = 0;
            if (jSONArray != null) {
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    try {
                        this.zonePolicies.add(new AdMostAdPolicyItem(jSONArray.getJSONObject(i2)));
                        i2++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.tagPolicies = new ArrayList<>();
            if (jSONArray2 != null) {
                while (i < jSONArray2.length()) {
                    try {
                        this.tagPolicies.add(new AdMostAdPolicyItem(jSONArray2.getJSONObject(i)));
                        i++;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteAllPolicyData() {
        AdMostPreferences.getInstance().setPolicies((JSONArray) null, (JSONArray) null);
        parseData((JSONArray) null, (JSONArray) null);
    }

    /* access modifiers changed from: package-private */
    public AdMostFrequencyCappingItem getCappingForTag(String str) {
        if (AdMost.getInstance().getConfiguration() == null || !AdMost.getInstance().getConfiguration().hasPolicy()) {
            return null;
        }
        AdMostFrequencyCappingItem adMostFrequencyCappingItem = new AdMostFrequencyCappingItem();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            synchronized (policyListLock) {
                if (!(this.tagPolicies == null || str == null)) {
                    for (int i = 0; i < this.tagPolicies.size(); i++) {
                        AdMostAdPolicyItem adMostAdPolicyItem = this.tagPolicies.get(i);
                        if (adMostAdPolicyItem.ItemId.equals(str) && adMostAdPolicyItem.ActiveUntil > currentTimeMillis) {
                            if (adMostAdPolicyItem.ActionType.equals(ACTION_TYPE_CAP_FREQ)) {
                                if (adMostAdPolicyItem.ActionDetail < adMostFrequencyCappingItem.ZoneFcapDaily || adMostFrequencyCappingItem.ZoneFcapDaily == 0) {
                                    adMostFrequencyCappingItem.ZoneFcapDaily = adMostAdPolicyItem.ActionDetail;
                                }
                            } else if (adMostAdPolicyItem.ActionType.equals(ACTION_TYPE_SET_INTERVAL) && (adMostAdPolicyItem.ActionDetail > adMostFrequencyCappingItem.ZoneImpressionInterval || adMostFrequencyCappingItem.ZoneImpressionInterval == 0)) {
                                adMostFrequencyCappingItem.ZoneImpressionInterval = adMostAdPolicyItem.ActionDetail;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adMostFrequencyCappingItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasTagPolicyForNoAd(java.lang.String r9) {
        /*
            r8 = this;
            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()
            admost.sdk.base.AdMostConfiguration r0 = r0.getConfiguration()
            boolean r0 = r0.hasPolicy()
            r1 = 0
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            java.lang.Object r0 = policyListLock
            monitor-enter(r0)
            java.util.ArrayList<admost.sdk.model.AdMostAdPolicyItem> r4 = r8.tagPolicies     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0050
            if (r9 == 0) goto L_0x0050
            r4 = 0
        L_0x0021:
            java.util.ArrayList<admost.sdk.model.AdMostAdPolicyItem> r5 = r8.tagPolicies     // Catch:{ all -> 0x0052 }
            int r5 = r5.size()     // Catch:{ all -> 0x0052 }
            if (r4 >= r5) goto L_0x004e
            java.util.ArrayList<admost.sdk.model.AdMostAdPolicyItem> r5 = r8.tagPolicies     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x0052 }
            admost.sdk.model.AdMostAdPolicyItem r5 = (admost.sdk.model.AdMostAdPolicyItem) r5     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = r5.ItemId     // Catch:{ all -> 0x0052 }
            boolean r6 = r6.equals(r9)     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x004b
            java.lang.String r6 = r5.ActionType     // Catch:{ all -> 0x0052 }
            java.lang.String r7 = "no_ad"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x004b
            long r5 = r5.ActiveUntil     // Catch:{ all -> 0x0052 }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x004b
            r1 = 1
            goto L_0x004e
        L_0x004b:
            int r4 = r4 + 1
            goto L_0x0021
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            return r1
        L_0x0050:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            return r1
        L_0x0052:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0055:
            throw r9
        L_0x0056:
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostPolicyManager.hasTagPolicyForNoAd(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasZonePolicyForNoAd(java.lang.String r9) {
        /*
            r8 = this;
            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()
            admost.sdk.base.AdMostConfiguration r0 = r0.getConfiguration()
            r1 = 0
            if (r0 == 0) goto L_0x005f
            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()
            admost.sdk.base.AdMostConfiguration r0 = r0.getConfiguration()
            boolean r0 = r0.hasPolicy()
            if (r0 != 0) goto L_0x001a
            goto L_0x005f
        L_0x001a:
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            java.lang.Object r0 = policyListLock
            monitor-enter(r0)
            java.util.ArrayList<admost.sdk.model.AdMostAdPolicyItem> r4 = r8.zonePolicies     // Catch:{ all -> 0x005c }
            if (r4 == 0) goto L_0x005a
            if (r9 == 0) goto L_0x005a
            r4 = 0
        L_0x002b:
            java.util.ArrayList<admost.sdk.model.AdMostAdPolicyItem> r5 = r8.zonePolicies     // Catch:{ all -> 0x005c }
            int r5 = r5.size()     // Catch:{ all -> 0x005c }
            if (r4 >= r5) goto L_0x0058
            java.util.ArrayList<admost.sdk.model.AdMostAdPolicyItem> r5 = r8.zonePolicies     // Catch:{ all -> 0x005c }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x005c }
            admost.sdk.model.AdMostAdPolicyItem r5 = (admost.sdk.model.AdMostAdPolicyItem) r5     // Catch:{ all -> 0x005c }
            java.lang.String r6 = r5.ItemId     // Catch:{ all -> 0x005c }
            boolean r6 = r6.equals(r9)     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x0055
            java.lang.String r6 = r5.ActionType     // Catch:{ all -> 0x005c }
            java.lang.String r7 = "no_ad"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x0055
            long r5 = r5.ActiveUntil     // Catch:{ all -> 0x005c }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0055
            r1 = 1
            goto L_0x0058
        L_0x0055:
            int r4 = r4 + 1
            goto L_0x002b
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return r1
        L_0x005a:
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return r1
        L_0x005c:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            throw r9
        L_0x005f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostPolicyManager.hasZonePolicyForNoAd(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public void restoreDataFromCache() {
        JSONObject allPolicies = AdMostPreferences.getInstance().getAllPolicies();
        if (allPolicies != null) {
            parseData(allPolicies.optJSONArray("ZoneAdPolicies"), allPolicies.optJSONArray("TagAdPolicies"));
        }
    }

    /* access modifiers changed from: package-private */
    public void setPolicyData(JSONObject jSONObject) {
        if (AdMost.getInstance().getConfiguration() != null && AdMost.getInstance().getConfiguration().hasPolicy()) {
            JSONArray optJSONArray = jSONObject.optJSONArray("ZoneAdPolicies");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("TagAdPolicies");
            parseData(optJSONArray, optJSONArray2);
            AdMostPreferences.getInstance().setPolicies(optJSONArray, optJSONArray2);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateZoneFrequencyCappingPolicies(AdMostBannerResponseBase adMostBannerResponseBase) {
        if (AdMost.getInstance().getConfiguration() != null && AdMost.getInstance().getConfiguration().hasPolicy()) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                synchronized (policyListLock) {
                    if (this.zonePolicies != null) {
                        boolean z = false;
                        boolean z2 = false;
                        for (int i = 0; i < this.zonePolicies.size(); i++) {
                            AdMostAdPolicyItem adMostAdPolicyItem = this.zonePolicies.get(i);
                            if (adMostAdPolicyItem.ItemId.equals(adMostBannerResponseBase.ZoneId) && adMostAdPolicyItem.ActiveUntil > currentTimeMillis) {
                                if (adMostAdPolicyItem.ActionType.equals(ACTION_TYPE_CAP_FREQ)) {
                                    if (!z || adMostAdPolicyItem.ActionDetail < adMostBannerResponseBase.ZoneFcapDaily) {
                                        adMostBannerResponseBase.ZoneFcapDaily = adMostAdPolicyItem.ActionDetail;
                                        z = true;
                                    }
                                } else if (adMostAdPolicyItem.ActionType.equals(ACTION_TYPE_SET_INTERVAL) && (!z2 || adMostAdPolicyItem.ActionDetail > adMostBannerResponseBase.ZoneImpressionInterval)) {
                                    adMostBannerResponseBase.ZoneImpressionInterval = adMostAdPolicyItem.ActionDetail;
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
