package admost.sdk.model;

import org.json.JSONObject;

public class AdMostBannerResponseType1 extends AdMostBannerResponseBase {
    public AdMostBannerResponseType1(JSONObject jSONObject, boolean z, boolean z2) throws Exception {
        super(jSONObject, z, z2);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0332 A[Catch:{ Exception -> 0x03b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0350 A[Catch:{ Exception -> 0x03b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0374 A[Catch:{ Exception -> 0x03b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02cb A[Catch:{ Exception -> 0x03b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.HashMap<java.lang.String, java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem>> setupFloorPrice(java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r23) {
        /*
            r22 = this;
            r1 = r22
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x03b7 }
            r0.<init>()     // Catch:{ Exception -> 0x03b7 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x03b7 }
            r3.<init>()     // Catch:{ Exception -> 0x03b7 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x03b7 }
            r4.<init>()     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.base.AdMostFloorPriceManager r5 = admost.sdk.base.AdMostFloorPriceManager.getInstance()     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r6 = r1.ZoneId     // Catch:{ Exception -> 0x03b7 }
            int r5 = r5.getLastEcpmForZone(r6)     // Catch:{ Exception -> 0x03b7 }
            r7 = 0
        L_0x001c:
            int r8 = r23.size()     // Catch:{ Exception -> 0x03b7 }
            r9 = 1
            if (r7 >= r8) goto L_0x007d
            r8 = r23
            java.lang.Object r10 = r8.get(r7)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r10 = (admost.sdk.model.AdMostBannerResponseItem) r10     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r15 = r10.Network     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.base.AdMostExperimentManager r11 = admost.sdk.base.AdMostExperimentManager.getInstance()     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r13 = r1.ZoneId     // Catch:{ Exception -> 0x03b7 }
            boolean r14 = r1.IsFirstRequestForZone     // Catch:{ Exception -> 0x03b7 }
            boolean r16 = r1.isFirstRequestForNetwork(r15)     // Catch:{ Exception -> 0x03b7 }
            r17 = 0
            r12 = r15
            r6 = r15
            r15 = r16
            r16 = r17
            admost.sdk.model.AdMostAdNetworkMeta r11 = r11.getAdNetworkMeta(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x03b7 }
            if (r11 == 0) goto L_0x007a
            boolean r11 = r11.isFloorPriceEnabled()     // Catch:{ Exception -> 0x03b7 }
            if (r11 == 0) goto L_0x007a
            java.lang.Object r11 = r0.get(r6)     // Catch:{ Exception -> 0x03b7 }
            if (r11 != 0) goto L_0x005b
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x03b7 }
            r11.<init>()     // Catch:{ Exception -> 0x03b7 }
            r0.put(r6, r11)     // Catch:{ Exception -> 0x03b7 }
        L_0x005b:
            boolean r11 = r10.AlwaysInWaterfall     // Catch:{ Exception -> 0x03b7 }
            if (r11 != 0) goto L_0x0076
            int r11 = r10.Weight     // Catch:{ Exception -> 0x03b7 }
            int r12 = r10.FPValue     // Catch:{ Exception -> 0x03b7 }
            int r11 = r11 + r12
            int r11 = r11 / 2
            r10.Weight = r11     // Catch:{ Exception -> 0x03b7 }
            r10.WeightWithoutMultiplier = r11     // Catch:{ Exception -> 0x03b7 }
            r1.SortNeeded = r9     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x03b7 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ Exception -> 0x03b7 }
            r6.add(r10)     // Catch:{ Exception -> 0x03b7 }
            goto L_0x007a
        L_0x0076:
            admost.sdk.model.AdMostWaterfallLog r6 = r10.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            r6.addedBecauseOfAlwaysInWaterfall = r9     // Catch:{ Exception -> 0x03b7 }
        L_0x007a:
            int r7 = r7 + 1
            goto L_0x001c
        L_0x007d:
            java.util.Set r6 = r0.entrySet()     // Catch:{ Exception -> 0x03b7 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x03b7 }
        L_0x0085:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x03b7 }
            if (r7 == 0) goto L_0x03b4
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x03b7 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x03b7 }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ Exception -> 0x03b7 }
            if (r7 == 0) goto L_0x00ad
            int r10 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            if (r10 <= r9) goto L_0x00ad
            admost.sdk.model.AdMostBannerResponseBase$CustomComparatorFPValue r10 = new admost.sdk.model.AdMostBannerResponseBase$CustomComparatorFPValue     // Catch:{ Exception -> 0x03b7 }
            r10.<init>()     // Catch:{ Exception -> 0x03b7 }
            java.util.Collections.sort(r7, r10)     // Catch:{ Exception -> 0x03b7 }
        L_0x00ad:
            admost.sdk.base.AdMostFloorPriceManager r10 = admost.sdk.base.AdMostFloorPriceManager.getInstance()     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r11 = r1.ZoneId     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.FpDefaultItem r10 = r10.getPersistedDefault(r8, r11)     // Catch:{ Exception -> 0x03b7 }
            r11 = 0
        L_0x00b8:
            int r12 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            if (r11 >= r12) goto L_0x0101
            java.lang.Object r12 = r7.get(r11)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r12 = (admost.sdk.model.AdMostBannerResponseItem) r12     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r13 = r12.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            r13.positionInFPList = r11     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r13 = r12.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            int r14 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            r13.numberOfItemInFPList = r14     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r13 = r10.Placement     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r14 = ""
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x03b7 }
            if (r13 == 0) goto L_0x00de
            boolean r13 = r12.FPDefault     // Catch:{ Exception -> 0x03b7 }
            if (r13 != 0) goto L_0x00e8
        L_0x00de:
            java.lang.String r13 = r10.Placement     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r14 = r12.PlacementId     // Catch:{ Exception -> 0x03b7 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x03b7 }
            if (r13 == 0) goto L_0x00fe
        L_0x00e8:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x03b7 }
            r3.put(r8, r13)     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r13 = r10.Status     // Catch:{ Exception -> 0x03b7 }
            r4.put(r8, r13)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r13 = r12.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            r13.isDefaultForFP = r9     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r12 = r12.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r13 = r10.Status     // Catch:{ Exception -> 0x03b7 }
            r12.defaultFPStatus = r13     // Catch:{ Exception -> 0x03b7 }
        L_0x00fe:
            int r11 = r11 + 1
            goto L_0x00b8
        L_0x0101:
            java.lang.Object r10 = r4.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r15 = "first_request"
            if (r10 != 0) goto L_0x0141
            admost.sdk.base.AdMostFloorPriceManager r10 = admost.sdk.base.AdMostFloorPriceManager.getInstance()     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r11 = r1.ZoneId     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r13 = "first_request"
            java.lang.String r14 = ""
            r16 = 0
            r12 = r8
            r2 = r15
            r15 = r16
            r10.setPersistedDefault(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x03b7 }
            r4.put(r8, r2)     // Catch:{ Exception -> 0x03b7 }
            int r10 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            int r10 = r10 / 2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x03b7 }
            r3.put(r8, r10)     // Catch:{ Exception -> 0x03b7 }
            int r10 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            int r10 = r10 / 2
            java.lang.Object r10 = r7.get(r10)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r10 = (admost.sdk.model.AdMostBannerResponseItem) r10     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r11 = r10.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            r11.isDefaultForFP = r9     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r10 = r10.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            r10.defaultFPStatus = r2     // Catch:{ Exception -> 0x03b7 }
            goto L_0x0142
        L_0x0141:
            r2 = r15
        L_0x0142:
            admost.sdk.base.AdMostExperimentManager r10 = admost.sdk.base.AdMostExperimentManager.getInstance()     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r12 = r1.ZoneId     // Catch:{ Exception -> 0x03b7 }
            boolean r13 = r1.IsFirstRequestForZone     // Catch:{ Exception -> 0x03b7 }
            boolean r14 = r1.isFirstRequestForNetwork(r8)     // Catch:{ Exception -> 0x03b7 }
            r15 = 0
            r11 = r8
            admost.sdk.model.AdMostAdNetworkMeta r10 = r10.getAdNetworkMeta(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostAdNetworkMeta$NetworkFloorPriceConfig r11 = r10.getFloorPrice()     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.base.AdMostExperimentManager r12 = admost.sdk.base.AdMostExperimentManager.getInstance()     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r13 = r1.ZoneId     // Catch:{ Exception -> 0x03b7 }
            boolean r14 = r1.IsFirstRequestForZone     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.FloorPriceConfig r12 = r12.getFloorPriceConfig(r13, r14, r8)     // Catch:{ Exception -> 0x03b7 }
            if (r12 != 0) goto L_0x016d
            java.lang.String r0 = "Please setup FPConfig parameter on init. <<< FPConfig is null >>>"
            admost.sdk.base.AdMostLog.m303w(r0)     // Catch:{ Exception -> 0x03b7 }
            r2 = 0
            return r2
        L_0x016d:
            r13 = 99999(0x1869f, float:1.40128E-40)
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
        L_0x0176:
            int r9 = r11.PlacementCount     // Catch:{ Exception -> 0x03b7 }
            r19 = r6
            java.lang.String r6 = "1"
            if (r14 >= r9) goto L_0x0282
            java.lang.Object r9 = r4.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x03b7 }
            boolean r9 = r9.equals(r2)     // Catch:{ Exception -> 0x03b7 }
            if (r9 == 0) goto L_0x01ab
            java.lang.Object r9 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x03b7 }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x03b7 }
            r20 = r2
            int r2 = r11.PlacementCount     // Catch:{ Exception -> 0x03b7 }
            r21 = r0
            admost.sdk.model.FloorPriceConfig$FirstRequestConfig r0 = r12.FirstRequest     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.TailIndexDefault     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2 - r0
            r0 = 1
            int r2 = r2 - r0
            int r2 = r2 - r14
            admost.sdk.model.FloorPriceConfig$FirstRequestConfig r0 = r12.FirstRequest     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.Gap     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2 * r0
            int r9 = r9 - r2
            goto L_0x022f
        L_0x01ab:
            r21 = r0
            r20 = r2
            java.lang.Object r0 = r4.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r2 = "no_fill"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x03b7 }
            if (r0 == 0) goto L_0x01cd
            java.lang.Object r0 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0 + r14
            int r2 = r12.HeadIndexOnNoFill     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0 - r2
        L_0x01cb:
            r9 = r0
            goto L_0x01e1
        L_0x01cd:
            java.lang.Object r0 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x03b7 }
            int r2 = r11.PlacementCount     // Catch:{ Exception -> 0x03b7 }
            int r9 = r12.TailIndexOnFill     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2 - r9
            r9 = 1
            int r2 = r2 - r9
            int r0 = r0 - r2
            int r0 = r0 + r14
            goto L_0x01cb
        L_0x01e1:
            java.lang.Object r0 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x03b7 }
            if (r9 >= r0) goto L_0x0209
            java.lang.Object r0 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r2 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2 - r9
            int r9 = r12.UpperGap     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2 * r9
            int r9 = r0 - r2
            goto L_0x022f
        L_0x0209:
            java.lang.Object r0 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x03b7 }
            if (r9 <= r0) goto L_0x022f
            java.lang.Object r0 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r2 = r3.get(r8)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x03b7 }
            int r9 = r9 - r2
            int r2 = r12.LowerGap     // Catch:{ Exception -> 0x03b7 }
            int r9 = r9 * r2
            int r9 = r9 + r0
        L_0x022f:
            if (r9 >= 0) goto L_0x0233
            int r15 = r15 + 1
        L_0x0233:
            int r0 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            if (r9 < r0) goto L_0x023b
            int r16 = r16 + 1
        L_0x023b:
            int r0 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            if (r9 >= r0) goto L_0x0274
            if (r9 < 0) goto L_0x0274
            java.lang.Object r0 = r7.get(r9)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r0 = (admost.sdk.model.AdMostBannerResponseItem) r0     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r0 = r0.FPEnabledItem     // Catch:{ Exception -> 0x03b7 }
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x03b7 }
            if (r0 != 0) goto L_0x0274
            java.lang.Object r0 = r7.get(r9)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r0 = (admost.sdk.model.AdMostBannerResponseItem) r0     // Catch:{ Exception -> 0x03b7 }
            r0.FPEnabledItem = r6     // Catch:{ Exception -> 0x03b7 }
            int r13 = java.lang.Math.min(r9, r13)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r0 = r7.get(r9)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r0 = (admost.sdk.model.AdMostBannerResponseItem) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.Weight     // Catch:{ Exception -> 0x03b7 }
            r2 = r18
            if (r0 <= r2) goto L_0x0276
            java.lang.Object r0 = r7.get(r9)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r0 = (admost.sdk.model.AdMostBannerResponseItem) r0     // Catch:{ Exception -> 0x03b7 }
            int r0 = r0.Weight     // Catch:{ Exception -> 0x03b7 }
            r18 = r0
            goto L_0x0278
        L_0x0274:
            r2 = r18
        L_0x0276:
            r18 = r2
        L_0x0278:
            int r14 = r14 + 1
            r6 = r19
            r2 = r20
            r0 = r21
            goto L_0x0176
        L_0x0282:
            r21 = r0
            r2 = r18
            if (r15 <= 0) goto L_0x02c7
            r0 = 0
        L_0x0289:
            int r8 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            if (r0 >= r8) goto L_0x02c7
            java.lang.Object r8 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r8 = (admost.sdk.model.AdMostBannerResponseItem) r8     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r8 = r8.FPEnabledItem     // Catch:{ Exception -> 0x03b7 }
            boolean r8 = r8.equals(r6)     // Catch:{ Exception -> 0x03b7 }
            if (r8 != 0) goto L_0x02c4
            java.lang.Object r8 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r8 = (admost.sdk.model.AdMostBannerResponseItem) r8     // Catch:{ Exception -> 0x03b7 }
            r8.FPEnabledItem = r6     // Catch:{ Exception -> 0x03b7 }
            int r13 = java.lang.Math.min(r0, r13)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r8 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r8 = (admost.sdk.model.AdMostBannerResponseItem) r8     // Catch:{ Exception -> 0x03b7 }
            int r8 = r8.Weight     // Catch:{ Exception -> 0x03b7 }
            if (r8 <= r2) goto L_0x02bb
            java.lang.Object r2 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2.Weight     // Catch:{ Exception -> 0x03b7 }
        L_0x02bb:
            r18 = r2
            int r15 = r15 + -1
            if (r15 > 0) goto L_0x02c2
            goto L_0x02c9
        L_0x02c2:
            r2 = r18
        L_0x02c4:
            int r0 = r0 + 1
            goto L_0x0289
        L_0x02c7:
            r18 = r2
        L_0x02c9:
            if (r16 <= 0) goto L_0x0321
            int r0 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            r2 = 1
            int r0 = r0 - r2
            r2 = r18
        L_0x02d3:
            if (r0 < 0) goto L_0x0323
            java.lang.Object r8 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r8 = (admost.sdk.model.AdMostBannerResponseItem) r8     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r8 = r8.FPEnabledItem     // Catch:{ Exception -> 0x03b7 }
            boolean r8 = r8.equals(r6)     // Catch:{ Exception -> 0x03b7 }
            if (r8 != 0) goto L_0x031b
            boolean r8 = r1.RestrictUpper     // Catch:{ Exception -> 0x03b7 }
            if (r8 == 0) goto L_0x02ef
            if (r0 > r13) goto L_0x02ef
            r8 = 99999(0x1869f, float:1.40128E-40)
            if (r13 != r8) goto L_0x031e
            goto L_0x02f2
        L_0x02ef:
            r8 = 99999(0x1869f, float:1.40128E-40)
        L_0x02f2:
            java.lang.Object r9 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r9 = (admost.sdk.model.AdMostBannerResponseItem) r9     // Catch:{ Exception -> 0x03b7 }
            r9.FPEnabledItem = r6     // Catch:{ Exception -> 0x03b7 }
            int r9 = java.lang.Math.min(r0, r13)     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r11 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r11 = (admost.sdk.model.AdMostBannerResponseItem) r11     // Catch:{ Exception -> 0x03b7 }
            int r11 = r11.Weight     // Catch:{ Exception -> 0x03b7 }
            if (r11 <= r2) goto L_0x0310
            java.lang.Object r2 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2     // Catch:{ Exception -> 0x03b7 }
            int r2 = r2.Weight     // Catch:{ Exception -> 0x03b7 }
        L_0x0310:
            r18 = r2
            int r16 = r16 + -1
            if (r16 > 0) goto L_0x0317
            goto L_0x0321
        L_0x0317:
            r13 = r9
            r2 = r18
            goto L_0x031e
        L_0x031b:
            r8 = 99999(0x1869f, float:1.40128E-40)
        L_0x031e:
            int r0 = r0 + -1
            goto L_0x02d3
        L_0x0321:
            r2 = r18
        L_0x0323:
            boolean r0 = r1.AddPlacementsAboveLastECPM     // Catch:{ Exception -> 0x03b7 }
            if (r0 == 0) goto L_0x036d
            if (r2 >= r5) goto L_0x036d
            r0 = -1
            r2 = 0
            r8 = -1
        L_0x032c:
            int r9 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            if (r2 >= r9) goto L_0x034e
            java.lang.Object r9 = r7.get(r2)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r9 = (admost.sdk.model.AdMostBannerResponseItem) r9     // Catch:{ Exception -> 0x03b7 }
            int r11 = r9.Weight     // Catch:{ Exception -> 0x03b7 }
            if (r11 <= r5) goto L_0x034b
            if (r8 == r0) goto L_0x034a
            int r9 = r9.Weight     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r11 = r7.get(r8)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r11 = (admost.sdk.model.AdMostBannerResponseItem) r11     // Catch:{ Exception -> 0x03b7 }
            int r11 = r11.Weight     // Catch:{ Exception -> 0x03b7 }
            if (r9 >= r11) goto L_0x034b
        L_0x034a:
            r8 = r2
        L_0x034b:
            int r2 = r2 + 1
            goto L_0x032c
        L_0x034e:
            if (r8 < 0) goto L_0x036d
            java.lang.Object r0 = r7.get(r8)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r0 = (admost.sdk.model.AdMostBannerResponseItem) r0     // Catch:{ Exception -> 0x03b7 }
            r0.FPEnabledItem = r6     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r0 = r7.get(r8)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r0 = (admost.sdk.model.AdMostBannerResponseItem) r0     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r0 = r0.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            r2 = 1
            r0.addPlacementsAboveLastECPM = r2     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r0 = r7.get(r8)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r0 = (admost.sdk.model.AdMostBannerResponseItem) r0     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostWaterfallLog r0 = r0.WaterFallLogItem     // Catch:{ Exception -> 0x03b7 }
            r0.addPlacementsAboveLastECPMValue = r5     // Catch:{ Exception -> 0x03b7 }
        L_0x036d:
            r0 = 0
        L_0x036e:
            int r2 = r7.size()     // Catch:{ Exception -> 0x03b7 }
            if (r0 >= r2) goto L_0x03ad
            java.lang.Object r2 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2     // Catch:{ Exception -> 0x03b7 }
            java.lang.String r2 = r2.FPEnabledItem     // Catch:{ Exception -> 0x03b7 }
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x03b7 }
            if (r2 != 0) goto L_0x03a9
            java.lang.Object r2 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2     // Catch:{ Exception -> 0x03b7 }
            r8 = 1
            r2.MarkedAsDeleted = r8     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r2 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2     // Catch:{ Exception -> 0x03b7 }
            r2.InFPBoosterList = r8     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r2 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2     // Catch:{ Exception -> 0x03b7 }
            boolean r9 = r10.isExtraBoosterNetwork()     // Catch:{ Exception -> 0x03b7 }
            r2.IsExtraBoosterNetwork = r9     // Catch:{ Exception -> 0x03b7 }
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r2 = r1.NetworkListNotInWaterfall     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r9 = r7.get(r0)     // Catch:{ Exception -> 0x03b7 }
            r2.add(r9)     // Catch:{ Exception -> 0x03b7 }
            goto L_0x03aa
        L_0x03a9:
            r8 = 1
        L_0x03aa:
            int r0 = r0 + 1
            goto L_0x036e
        L_0x03ad:
            r6 = r19
            r0 = r21
            r9 = 1
            goto L_0x0085
        L_0x03b4:
            r21 = r0
            return r21
        L_0x03b7:
            r0 = move-exception
            r0.printStackTrace()
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.model.AdMostBannerResponseType1.setupFloorPrice(java.util.ArrayList):java.util.HashMap");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        ((admost.sdk.model.AdMostBannerResponseItem) r11.get(r14)).Weight = r15 * r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepareWaterfall(org.json.JSONObject r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            boolean r2 = admost.sdk.base.AdMostUtil.checkRandomizerBypass(r21)     // Catch:{ Exception -> 0x02b3 }
            r1.Randomize = r2     // Catch:{ Exception -> 0x02b3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b3 }
            r2.<init>()     // Catch:{ Exception -> 0x02b3 }
            r1.NetworkList = r2     // Catch:{ Exception -> 0x02b3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b3 }
            r2.<init>()     // Catch:{ Exception -> 0x02b3 }
            r1.NetworkListInHouse = r2     // Catch:{ Exception -> 0x02b3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b3 }
            r2.<init>()     // Catch:{ Exception -> 0x02b3 }
            r1.NetworkListNotInWaterfall = r2     // Catch:{ Exception -> 0x02b3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b3 }
            r2.<init>()     // Catch:{ Exception -> 0x02b3 }
            r1.BiddingItems = r2     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.base.AdMostPreferences r2 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ Exception -> 0x02b3 }
            r3 = -1
            if (r2 == 0) goto L_0x0036
            admost.sdk.base.AdMostPreferences r2 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ Exception -> 0x02b3 }
            int r2 = r2.getPercentile()     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0037
        L_0x0036:
            r2 = -1
        L_0x0037:
            admost.sdk.AdMostBiddingManager r4 = admost.sdk.AdMostBiddingManager.getInstance()     // Catch:{ Exception -> 0x02b3 }
            r4.appendTestData(r0)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r4 = "BidPlacements"
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ Exception -> 0x02b3 }
            r5 = 100
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x00a8
            r8 = 0
        L_0x004b:
            int r9 = r4.length()     // Catch:{ Exception -> 0x02b3 }
            if (r8 >= r9) goto L_0x00a8
            org.json.JSONObject r9 = r4.getJSONObject(r8)     // Catch:{ Exception -> 0x02b3 }
            if (r9 == 0) goto L_0x00a5
            admost.sdk.model.AdMostBannerResponseItem r10 = new admost.sdk.model.AdMostBannerResponseItem     // Catch:{ Exception -> 0x02b3 }
            r10.<init>((org.json.JSONObject) r9)     // Catch:{ Exception -> 0x02b3 }
            r10.IsBiddingItem = r6     // Catch:{ Exception -> 0x02b3 }
            r1.enrichResponseItemWithZoneData(r10)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r9 = r10.Status     // Catch:{ Exception -> 0x02b3 }
            boolean r9 = r1.isStatusSuitable(r9, r7)     // Catch:{ Exception -> 0x02b3 }
            if (r9 == 0) goto L_0x00a5
            int r9 = r10.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            if (r9 == 0) goto L_0x00a0
            if (r2 == r3) goto L_0x00a0
            boolean r9 = admost.sdk.base.AdMostLog.isEnabled()     // Catch:{ Exception -> 0x02b3 }
            if (r9 == 0) goto L_0x0076
            goto L_0x00a0
        L_0x0076:
            int r9 = r10.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            int r11 = r10.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            int r9 = r9 + r11
            if (r9 <= r5) goto L_0x008f
            int r9 = r10.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            if (r9 <= r2) goto L_0x0089
            int r9 = r10.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            int r11 = r10.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            int r9 = r9 + r11
            int r9 = r9 - r5
            if (r2 >= r9) goto L_0x00a5
        L_0x0089:
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r9 = r1.BiddingItems     // Catch:{ Exception -> 0x02b3 }
            r9.add(r10)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x00a5
        L_0x008f:
            int r9 = r10.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            if (r9 > r2) goto L_0x00a5
            int r9 = r10.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            int r11 = r10.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            int r9 = r9 + r11
            if (r2 >= r9) goto L_0x00a5
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r9 = r1.BiddingItems     // Catch:{ Exception -> 0x02b3 }
            r9.add(r10)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x00a5
        L_0x00a0:
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r9 = r1.BiddingItems     // Catch:{ Exception -> 0x02b3 }
            r9.add(r10)     // Catch:{ Exception -> 0x02b3 }
        L_0x00a5:
            int r8 = r8 + 1
            goto L_0x004b
        L_0x00a8:
            java.lang.String r4 = "Data"
            org.json.JSONArray r0 = r0.optJSONArray(r4)     // Catch:{ Exception -> 0x02b3 }
            if (r0 == 0) goto L_0x02b7
            admost.sdk.base.AdMostExperimentManager r4 = admost.sdk.base.AdMostExperimentManager.getInstance()     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r8 = r1.ZoneId     // Catch:{ Exception -> 0x02b3 }
            boolean r9 = r1.IsFirstRequestForZone     // Catch:{ Exception -> 0x02b3 }
            r10 = 0
            boolean r4 = r4.useADMLWeight(r8, r9, r10)     // Catch:{ Exception -> 0x02b3 }
            r8 = 0
        L_0x00be:
            int r9 = r0.length()     // Catch:{ Exception -> 0x02b3 }
            if (r8 >= r9) goto L_0x0259
            org.json.JSONObject r9 = r0.getJSONObject(r8)     // Catch:{ Exception -> 0x02b3 }
            if (r9 == 0) goto L_0x0248
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b3 }
            r11.<init>()     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r12 = "Placements"
            org.json.JSONArray r12 = r9.optJSONArray(r12)     // Catch:{ Exception -> 0x02b3 }
            if (r12 == 0) goto L_0x013e
            r13 = 0
        L_0x00d8:
            int r14 = r12.length()     // Catch:{ Exception -> 0x02b3 }
            if (r13 >= r14) goto L_0x013e
            admost.sdk.model.AdMostBannerResponseItem r14 = new admost.sdk.model.AdMostBannerResponseItem     // Catch:{ Exception -> 0x02b3 }
            org.json.JSONObject r15 = r12.getJSONObject(r13)     // Catch:{ Exception -> 0x02b3 }
            r14.<init>((org.json.JSONObject) r15)     // Catch:{ Exception -> 0x02b3 }
            r1.enrichResponseItemWithZoneData(r14)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r15 = r14.Status     // Catch:{ Exception -> 0x02b3 }
            boolean r15 = r1.isStatusSuitable(r15, r7)     // Catch:{ Exception -> 0x02b3 }
            if (r15 == 0) goto L_0x013a
            int r15 = r14.ADMLWeight     // Catch:{ Exception -> 0x02b3 }
            if (r15 <= 0) goto L_0x0104
            if (r4 == 0) goto L_0x0104
            int r15 = r14.ADMLWeight     // Catch:{ Exception -> 0x02b3 }
            r14.Weight = r15     // Catch:{ Exception -> 0x02b3 }
            int r15 = r14.ADMLWeight     // Catch:{ Exception -> 0x02b3 }
            r14.PureWeight = r15     // Catch:{ Exception -> 0x02b3 }
            int r15 = r14.ADMLWeight     // Catch:{ Exception -> 0x02b3 }
            r14.FPValue = r15     // Catch:{ Exception -> 0x02b3 }
        L_0x0104:
            int r15 = r14.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            if (r15 == 0) goto L_0x0137
            if (r2 == r3) goto L_0x0137
            boolean r15 = admost.sdk.base.AdMostLog.isEnabled()     // Catch:{ Exception -> 0x02b3 }
            if (r15 == 0) goto L_0x0111
            goto L_0x0137
        L_0x0111:
            int r15 = r14.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            int r3 = r14.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            int r15 = r15 + r3
            if (r15 <= r5) goto L_0x0128
            int r3 = r14.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            if (r3 <= r2) goto L_0x0124
            int r3 = r14.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            int r15 = r14.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            int r3 = r3 + r15
            int r3 = r3 - r5
            if (r2 >= r3) goto L_0x013a
        L_0x0124:
            r11.add(r14)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x013a
        L_0x0128:
            int r3 = r14.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            if (r3 > r2) goto L_0x013a
            int r3 = r14.ActivePercentageOrigin     // Catch:{ Exception -> 0x02b3 }
            int r15 = r14.ActivePercentage     // Catch:{ Exception -> 0x02b3 }
            int r3 = r3 + r15
            if (r2 >= r3) goto L_0x013a
            r11.add(r14)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x013a
        L_0x0137:
            r11.add(r14)     // Catch:{ Exception -> 0x02b3 }
        L_0x013a:
            int r13 = r13 + 1
            r3 = -1
            goto L_0x00d8
        L_0x013e:
            int r3 = r11.size()     // Catch:{ Exception -> 0x02b3 }
            if (r3 <= 0) goto L_0x0248
            boolean r3 = r1.FPEnabled     // Catch:{ Exception -> 0x02b3 }
            if (r3 == 0) goto L_0x0155
            java.util.HashMap r3 = r1.setupFloorPrice(r11)     // Catch:{ Exception -> 0x02b3 }
            if (r10 == 0) goto L_0x0154
            int r12 = r10.size()     // Catch:{ Exception -> 0x02b3 }
            if (r12 != 0) goto L_0x0155
        L_0x0154:
            r10 = r3
        L_0x0155:
            boolean r3 = r1.SortNeeded     // Catch:{ Exception -> 0x02b3 }
            if (r3 == 0) goto L_0x0167
            int r3 = r11.size()     // Catch:{ Exception -> 0x02b3 }
            if (r3 <= r6) goto L_0x0167
            admost.sdk.model.AdMostBannerResponseBase$CustomComparatorWeight r3 = new admost.sdk.model.AdMostBannerResponseBase$CustomComparatorWeight     // Catch:{ Exception -> 0x02b3 }
            r3.<init>()     // Catch:{ Exception -> 0x02b3 }
            java.util.Collections.sort(r11, r3)     // Catch:{ Exception -> 0x02b3 }
        L_0x0167:
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r3 = r1.NetworkListNotInWaterfall     // Catch:{ Exception -> 0x02b3 }
            if (r3 == 0) goto L_0x0175
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r3 = r1.NetworkListNotInWaterfall     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.AdMostBannerResponseBase$CustomComparatorWeight r12 = new admost.sdk.model.AdMostBannerResponseBase$CustomComparatorWeight     // Catch:{ Exception -> 0x02b3 }
            r12.<init>()     // Catch:{ Exception -> 0x02b3 }
            java.util.Collections.sort(r3, r12)     // Catch:{ Exception -> 0x02b3 }
        L_0x0175:
            boolean r3 = r1.Randomize     // Catch:{ Exception -> 0x02b3 }
            if (r3 == 0) goto L_0x01fd
            admost.sdk.base.AdMostExperimentManager r3 = admost.sdk.base.AdMostExperimentManager.getInstance()     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r12 = r1.ZoneId     // Catch:{ Exception -> 0x02b3 }
            boolean r13 = r1.IsFirstRequestForZone     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.RandomizerConfig r3 = r3.getRandomizerConfig(r12, r13)     // Catch:{ Exception -> 0x02b3 }
            if (r3 == 0) goto L_0x01fd
            r12 = 0
            r14 = 0
        L_0x018a:
            int r15 = r11.size()     // Catch:{ Exception -> 0x02b3 }
            if (r14 >= r15) goto L_0x01fd
            java.lang.Object r15 = r11.get(r14)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.AdMostBannerResponseItem r15 = (admost.sdk.model.AdMostBannerResponseItem) r15     // Catch:{ Exception -> 0x02b3 }
            boolean r15 = r15.MarkedAsDeleted     // Catch:{ Exception -> 0x02b3 }
            if (r15 != 0) goto L_0x01ea
            java.lang.Object r15 = r11.get(r14)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.AdMostBannerResponseItem r15 = (admost.sdk.model.AdMostBannerResponseItem) r15     // Catch:{ Exception -> 0x02b3 }
            int r15 = r15.Weight     // Catch:{ Exception -> 0x02b3 }
            double r5 = (double) r15     // Catch:{ Exception -> 0x02b3 }
            int r16 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r16 >= 0) goto L_0x01a8
            r12 = r5
        L_0x01a8:
            r22 = r0
        L_0x01aa:
            java.util.ArrayList<admost.sdk.model.RandomizerConfig$RandomizerConfigParam> r0 = r3.Parameters     // Catch:{ Exception -> 0x02b3 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x02b3 }
            if (r7 >= r0) goto L_0x01ec
            java.util.ArrayList<admost.sdk.model.RandomizerConfig$RandomizerConfigParam> r0 = r3.Parameters     // Catch:{ Exception -> 0x02b3 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.RandomizerConfig$RandomizerConfigParam r0 = (admost.sdk.model.RandomizerConfig.RandomizerConfigParam) r0     // Catch:{ Exception -> 0x02b3 }
            int r0 = r0.Multiplier     // Catch:{ Exception -> 0x02b3 }
            r17 = r2
            java.util.ArrayList<admost.sdk.model.RandomizerConfig$RandomizerConfigParam> r2 = r3.Parameters     // Catch:{ Exception -> 0x02b3 }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.RandomizerConfig$RandomizerConfigParam r2 = (admost.sdk.model.RandomizerConfig.RandomizerConfigParam) r2     // Catch:{ Exception -> 0x02b3 }
            int r2 = r2.Percentage     // Catch:{ Exception -> 0x02b3 }
            r18 = r3
            double r2 = (double) r2
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r12
            r19 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r2 = r2 / r19
            int r19 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r19 < 0) goto L_0x01e3
            java.lang.Object r2 = r11.get(r14)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2     // Catch:{ Exception -> 0x02b3 }
            int r15 = r15 * r0
            r2.Weight = r15     // Catch:{ Exception -> 0x02b3 }
            goto L_0x01f0
        L_0x01e3:
            int r7 = r7 + 1
            r2 = r17
            r3 = r18
            goto L_0x01aa
        L_0x01ea:
            r22 = r0
        L_0x01ec:
            r17 = r2
            r18 = r3
        L_0x01f0:
            int r14 = r14 + 1
            r0 = r22
            r2 = r17
            r3 = r18
            r5 = 100
            r6 = 1
            r7 = 0
            goto L_0x018a
        L_0x01fd:
            r22 = r0
            r17 = r2
            r0 = 0
            r2 = 0
        L_0x0203:
            int r3 = r11.size()     // Catch:{ Exception -> 0x02b3 }
            if (r0 >= r3) goto L_0x021f
            java.lang.Object r3 = r11.get(r0)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.AdMostBannerResponseItem r3 = (admost.sdk.model.AdMostBannerResponseItem) r3     // Catch:{ Exception -> 0x02b3 }
            boolean r3 = r3.MarkedAsDeleted     // Catch:{ Exception -> 0x02b3 }
            if (r3 != 0) goto L_0x021c
            java.lang.Object r3 = r11.get(r0)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.AdMostBannerResponseItem r3 = (admost.sdk.model.AdMostBannerResponseItem) r3     // Catch:{ Exception -> 0x02b3 }
            int r3 = r3.Weight     // Catch:{ Exception -> 0x02b3 }
            int r2 = r2 + r3
        L_0x021c:
            int r0 = r0 + 1
            goto L_0x0203
        L_0x021f:
            java.lang.String r0 = "Priority"
            r3 = 0
            int r0 = r9.optInt(r0, r3)     // Catch:{ Exception -> 0x02b3 }
            r3 = 0
        L_0x0227:
            int r5 = r11.size()     // Catch:{ Exception -> 0x02b3 }
            if (r3 >= r5) goto L_0x024c
            admost.sdk.model.AdMostBannerResponseItem r5 = r1.getRandomItem(r11, r2, r3)     // Catch:{ Exception -> 0x02b3 }
            if (r5 == 0) goto L_0x0245
            r6 = 10
            if (r0 <= r6) goto L_0x023d
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r6 = r1.NetworkListInHouse     // Catch:{ Exception -> 0x02b3 }
            r6.add(r5)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0242
        L_0x023d:
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r6 = r1.NetworkList     // Catch:{ Exception -> 0x02b3 }
            r6.add(r5)     // Catch:{ Exception -> 0x02b3 }
        L_0x0242:
            int r5 = r5.Weight     // Catch:{ Exception -> 0x02b3 }
            int r2 = r2 - r5
        L_0x0245:
            int r3 = r3 + 1
            goto L_0x0227
        L_0x0248:
            r22 = r0
            r17 = r2
        L_0x024c:
            int r8 = r8 + 1
            r0 = r22
            r2 = r17
            r3 = -1
            r5 = 100
            r6 = 1
            r7 = 0
            goto L_0x00be
        L_0x0259:
            boolean r0 = r1.FPEnabled     // Catch:{ Exception -> 0x02b3 }
            if (r0 == 0) goto L_0x02b7
            if (r10 == 0) goto L_0x02b7
            java.util.Set r0 = r10.entrySet()     // Catch:{ Exception -> 0x02b3 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02b3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b3 }
            r2.<init>()     // Catch:{ Exception -> 0x02b3 }
        L_0x026c:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x02b3 }
            if (r3 == 0) goto L_0x029d
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x02b3 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x02b3 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x02b3 }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ Exception -> 0x02b3 }
            int r4 = r3.size()     // Catch:{ Exception -> 0x02b3 }
            r5 = 1
            int r4 = r4 - r5
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x02b3 }
            admost.sdk.model.AdMostBannerResponseItem r3 = (admost.sdk.model.AdMostBannerResponseItem) r3     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r4 = r3.FPEnabledItem     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x02b3 }
            if (r4 != 0) goto L_0x026c
            r2.add(r3)     // Catch:{ Exception -> 0x02b3 }
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r4 = r1.NetworkListNotInWaterfall     // Catch:{ Exception -> 0x02b3 }
            r4.remove(r3)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x026c
        L_0x029d:
            int r0 = r2.size()     // Catch:{ Exception -> 0x02b3 }
            r3 = 1
            if (r0 <= r3) goto L_0x02ac
            admost.sdk.model.AdMostBannerResponseBase$CustomComparatorPureWeight r0 = new admost.sdk.model.AdMostBannerResponseBase$CustomComparatorPureWeight     // Catch:{ Exception -> 0x02b3 }
            r0.<init>()     // Catch:{ Exception -> 0x02b3 }
            java.util.Collections.sort(r2, r0)     // Catch:{ Exception -> 0x02b3 }
        L_0x02ac:
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r0 = r1.NetworkListInHouse     // Catch:{ Exception -> 0x02b3 }
            r3 = 0
            r0.addAll(r3, r2)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x02b7
        L_0x02b3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.model.AdMostBannerResponseType1.prepareWaterfall(org.json.JSONObject):void");
    }
}
