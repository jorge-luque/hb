package admost.sdk.base;

import admost.sdk.base.AdMostConfiguration;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostAdNetworkMeta;
import admost.sdk.model.AdMostExperiment;
import admost.sdk.model.AdMostServerException;
import admost.sdk.model.FloorPriceConfig;
import admost.sdk.model.RandomizerConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostExperimentManager {
    public static final String CONTEXT_ALL = "all";
    public static final String EXPERIMENT_REMOVED_PLACEMENT = "RemovedByExperiment";
    public static final String EXPERIMENT_TYPE_ALL = "all";
    public static final String EXPERIMENT_TYPE_EXISTING_USER = "existing";
    public static final String EXPERIMENT_TYPE_NEW_INSTALL = "new";
    public static final String FIRST_REQUEST_FOR_NETWORK = "FirstRequestNetworks";
    public static final String REQUEST_ALL = "all";
    public static final String REQUEST_FIRST_INIT = "firstInit";
    public static final String REQUEST_FIRST_NETWORK = "firstNetwork";
    public static final String REQUEST_FIRST_ZONE = "firstZone";
    public static final String TYPE_ADML_WEIGHT = "use_adml_weight";
    public static final String TYPE_ALGORITHM = "algorithm";
    public static final String TYPE_FP = "fp";
    public static final String TYPE_INIT_PARAMS = "init_params";
    public static final String TYPE_NETWORK = "network";
    public static final String TYPE_NETWORK_EXCLUDE = "network_excl";
    public static final String TYPE_NETWORK_INCLUDE = "network_incl";
    public static final String TYPE_RANDOMIZER = "randomizer";
    public static final String TYPE_ZONE = "zone";
    private static AdMostExperimentManager instance;
    private static final Object lock = new Object();
    private ConcurrentHashMap<String, AdMostAdNetworkMeta> adMostAdNetworkMetaCache = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, JSONObject> adMostExperimentDataCache = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public Observer countryResponseObserver;
    private String currentExperiment;
    private Vector<AdMostExperiment.AdMostExperimentDetail> currentExperimentDetails = new Vector<>();
    private String currentGroup;
    private ConcurrentHashMap<String, Boolean> isFirstRequestForZoneNetwork = new ConcurrentHashMap<>();
    private boolean joinExperimentCompleted;

    public static AdMostExperimentManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostExperimentManager();
                }
            }
        }
        return instance;
    }

    private JSONObject getSuitableExperiment(String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (!hasExperiment()) {
            return null;
        }
        String str4 = str + "*" + str3 + "*" + str2 + "*" + z + "*" + z2 + "*" + z3;
        if (this.adMostExperimentDataCache.containsKey(str4)) {
            return this.adMostExperimentDataCache.get(str4);
        }
        int i = 0;
        while (i < this.currentExperimentDetails.size()) {
            try {
                AdMostExperiment.AdMostExperimentDetail adMostExperimentDetail = this.currentExperimentDetails.get(i);
                if (!adMostExperimentDetail.Type.equals(str) || !adMostExperimentDetail.isExperimentItemApplicable(str2, str3, z, z2, z3)) {
                    i++;
                } else {
                    this.adMostExperimentDataCache.put(str4, adMostExperimentDetail.Json);
                    return adMostExperimentDetail.Json;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.currentExperiment;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hasExperiment() {
        /*
            r1 = this;
            java.lang.String r0 = r1.currentGroup
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r1.currentExperiment
            if (r0 == 0) goto L_0x0018
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0018
            java.lang.String r0 = r1.currentGroup
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostExperimentManager.hasExperiment():boolean");
    }

    private boolean hasZoneNetworkRequestedBefore(String str) {
        for (String contains : this.isFirstRequestForZoneNetwork.keySet()) {
            if (contains.contains(str + "*")) {
                return true;
            }
        }
        return false;
    }

    private boolean isDataInGroup(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (str != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            if (str.equals(jSONArray.getString(i))) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean isZoneNetworkFirstRequest(String str, String str2) {
        String str3 = str + "*" + str2;
        if (this.isFirstRequestForZoneNetwork.containsKey(str3)) {
            return this.isFirstRequestForZoneNetwork.get(str3).booleanValue();
        }
        boolean isFirstRequestForZoneNetwork2 = AdMostPreferences.getInstance().isFirstRequestForZoneNetwork(str3);
        this.isFirstRequestForZoneNetwork.put(str3, Boolean.valueOf(isFirstRequestForZoneNetwork2));
        return isFirstRequestForZoneNetwork2;
    }

    /* access modifiers changed from: private */
    public void keepExperimentAndGroup(String str, String str2) {
        AdMostLog.m299i("Storing EXPERIMENT to preferences : " + str + " GROUP : " + str2);
        this.currentExperiment = str;
        this.currentGroup = str2;
        AdMostPreferences.getInstance().keepExperimentAndGroup(str, str2);
    }

    private void makeExperimentRequest() {
        C02033 r0 = new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                if (exc != null) {
                    try {
                        if (exc.getCause() != null && (exc.getCause() instanceof AdMostServerException)) {
                            if (((AdMostServerException) exc.getCause()).ServerResponseCode == 401) {
                                AdMostLog.m299i("EXPERIMENT detail request response is 401");
                                AdMostExperimentManager.this.keepExperimentAndGroup("", "");
                                return;
                            } else if (((AdMostServerException) exc.getCause()).ServerResponseCode == 404) {
                                AdMostLog.m299i("EXPERIMENT detail request response is 404");
                                AdMostExperimentManager.this.keepExperimentAndGroup("", "");
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                AdMostExperimentManager.this.restoreExperiments(true, (JSONObject) null);
            }

            public void onResponse(JSONObject jSONObject) {
                if (jSONObject == null || jSONObject.length() <= 0) {
                    AdMostExperimentManager.this.restoreExperiments(true, (JSONObject) null);
                } else {
                    AdMostExperimentManager.this.restoreExperiments(false, jSONObject);
                }
            }
        };
        if (AdMostUtil.isNetworkAvailable(AdMost.getInstance().getContext()) == 1) {
            new AdMostGenericRequest(AdMostGenericRequest.RequestType.EXPERIMENT, "", r0).mo611go("");
            return;
        }
        restoreExperiments(true, (JSONObject) null);
    }

    private void markRemovedPlacements(JSONObject jSONObject, JSONArray jSONArray, boolean z) {
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray("Data");
            if (jSONArray2 != null) {
                if (jSONArray2.length() > 0) {
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONArray jSONArray3 = jSONArray2.getJSONObject(i).getJSONArray("Placements");
                        if (jSONArray3 != null && jSONArray3.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                                String string = jSONArray3.getJSONObject(i2).getString("Network");
                                if ((z && isDataInGroup(string, jSONArray)) || (!z && !isDataInGroup(string, jSONArray))) {
                                    jSONArray3.getJSONObject(i2).put(EXPERIMENT_REMOVED_PLACEMENT, "1");
                                }
                            }
                        }
                    }
                }
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray("BidPlacements");
            if (jSONArray4 != null && jSONArray4.length() > 0) {
                for (int i3 = 0; i3 < jSONArray4.length(); i3++) {
                    String string2 = jSONArray4.getJSONObject(i3).getString("Network");
                    if ((z && isDataInGroup(string2, jSONArray)) || (!z && !isDataInGroup(string2, jSONArray))) {
                        jSONArray4.getJSONObject(i3).put(EXPERIMENT_REMOVED_PLACEMENT, "1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void overrideJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    overrideJSONObject((JSONObject) obj, jSONObject2.getJSONObject(next));
                } else if (!(obj instanceof JSONArray)) {
                    jSONObject2.put(next, obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AdMostExperiment pickAnExperiment(ArrayList<AdMostExperiment> arrayList, int i, int i2) {
        if (arrayList.size() <= 0 || i2 > 100) {
            return null;
        }
        AdMostPreferences.getInstance().addToExperimentsTriedBefore(arrayList);
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            i3 += arrayList.get(i4).Meta.Percentage;
            if (i < i3) {
                return arrayList.get(i4);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void restoreExperiments(boolean z, JSONObject jSONObject) {
        if (z) {
            AdmostResponseCache fromCache = AdMostGenericRequest.getFromCache(AdMostGenericRequest.RequestType.EXPERIMENT, "EXPERIMENT");
            if (fromCache == null || fromCache.getJsonObject() == null) {
                setInitCompleted();
                return;
            }
            jSONObject = fromCache.getJsonObject();
        }
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Params");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.currentExperimentDetails.add(new AdMostExperiment.AdMostExperimentDetail(jSONArray.getJSONObject(i)));
                }
                Collections.sort(this.currentExperimentDetails, new AdMostExperiment.CustomComparatorContext());
                for (int i2 = 0; i2 < this.currentExperimentDetails.size(); i2++) {
                    this.currentExperimentDetails.get(i2).Context.RequestSortValue + " - " + this.currentExperimentDetails.get(i2).Type + " - " + this.currentExperimentDetails.get(i2).Context.Request;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setInitCompleted();
        }
    }

    private void sendOldImpressions() {
        AdMostImpressionManager.getInstance().sendImpression();
    }

    private void setInitCompleted() {
        AdMost.getInstance().initCompleted("EXPERIMENT");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0108 A[Catch:{ Exception -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0119 A[ADDED_TO_REGION, Catch:{ Exception -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0133 A[Catch:{ Exception -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0134 A[Catch:{ Exception -> 0x0139 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject updateZoneParameters(org.json.JSONObject r18) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            java.lang.String r1 = "*"
            java.lang.String r2 = "Placements"
            java.lang.String r9 = "Zone"
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            org.json.JSONObject r3 = r0.getJSONObject(r9)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r4 = "Id"
            java.lang.String r11 = r3.optString(r4)     // Catch:{ Exception -> 0x0139 }
            boolean r3 = r8.hasZoneNetworkRequestedBefore(r11)     // Catch:{ Exception -> 0x0139 }
            if (r3 != 0) goto L_0x0021
            r14 = 1
            goto L_0x0022
        L_0x0021:
            r14 = 0
        L_0x0022:
            java.lang.String r3 = "isFirstRequestForZone"
            r10.put(r3, r14)     // Catch:{ Exception -> 0x0139 }
            boolean r3 = r17.hasExperiment()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r15 = "updatedData"
            if (r3 != 0) goto L_0x0033
            r10.put(r15, r0)     // Catch:{ Exception -> 0x0139 }
            return r10
        L_0x0033:
            java.lang.String r3 = "Data"
            org.json.JSONArray r3 = r0.optJSONArray(r3)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r4 = ""
            r6 = r4
            if (r3 == 0) goto L_0x0087
            r5 = 0
        L_0x003f:
            int r7 = r3.length()     // Catch:{ Exception -> 0x0139 }
            if (r5 >= r7) goto L_0x0087
            r7 = 0
        L_0x0046:
            org.json.JSONObject r12 = r3.getJSONObject(r5)     // Catch:{ Exception -> 0x0139 }
            org.json.JSONArray r12 = r12.getJSONArray(r2)     // Catch:{ Exception -> 0x0139 }
            int r12 = r12.length()     // Catch:{ Exception -> 0x0139 }
            if (r7 >= r12) goto L_0x0084
            org.json.JSONObject r12 = r3.getJSONObject(r5)     // Catch:{ Exception -> 0x0139 }
            org.json.JSONArray r12 = r12.getJSONArray(r2)     // Catch:{ Exception -> 0x0139 }
            org.json.JSONObject r12 = r12.getJSONObject(r7)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r13 = "Network"
            java.lang.String r12 = r12.optString(r13, r4)     // Catch:{ Exception -> 0x0139 }
            boolean r13 = r8.isZoneNetworkFirstRequest(r11, r12)     // Catch:{ Exception -> 0x0139 }
            if (r13 == 0) goto L_0x0081
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0139 }
            r13.<init>()     // Catch:{ Exception -> 0x0139 }
            r13.append(r6)     // Catch:{ Exception -> 0x0139 }
            r13.append(r1)     // Catch:{ Exception -> 0x0139 }
            r13.append(r12)     // Catch:{ Exception -> 0x0139 }
            r13.append(r1)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r6 = r13.toString()     // Catch:{ Exception -> 0x0139 }
        L_0x0081:
            int r7 = r7 + 1
            goto L_0x0046
        L_0x0084:
            int r5 = r5 + 1
            goto L_0x003f
        L_0x0087:
            boolean r1 = r6.equals(r4)     // Catch:{ Exception -> 0x0139 }
            r12 = 0
            if (r1 != 0) goto L_0x009e
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0139 }
            java.lang.String r2 = r18.toString()     // Catch:{ Exception -> 0x0139 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r2 = "FirstRequestNetworks"
            r1.put(r2, r6)     // Catch:{ Exception -> 0x0139 }
            r13 = r1
            goto L_0x009f
        L_0x009e:
            r13 = r12
        L_0x009f:
            java.lang.String r2 = "zone"
            r4 = 0
            r6 = 0
            r7 = 0
            r1 = r17
            r3 = r11
            r5 = r14
            org.json.JSONObject r1 = r1.getSuitableExperiment(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x00c0
            if (r13 != 0) goto L_0x00b9
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x0139 }
            java.lang.String r2 = r18.toString()     // Catch:{ Exception -> 0x0139 }
            r13.<init>(r2)     // Catch:{ Exception -> 0x0139 }
        L_0x00b9:
            org.json.JSONObject r2 = r13.getJSONObject(r9)     // Catch:{ Exception -> 0x0139 }
            r8.overrideJSONObject(r1, r2)     // Catch:{ Exception -> 0x0139 }
        L_0x00c0:
            java.lang.String r2 = "network_incl"
            r4 = 0
            r6 = 0
            r7 = 0
            r1 = r17
            r3 = r11
            r5 = r14
            org.json.JSONObject r1 = r1.getSuitableExperiment(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r9 = "Networks"
            if (r1 == 0) goto L_0x00eb
            boolean r2 = r1.has(r9)     // Catch:{ Exception -> 0x0139 }
            if (r2 == 0) goto L_0x00eb
            org.json.JSONArray r2 = r1.getJSONArray(r9)     // Catch:{ Exception -> 0x0139 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x0139 }
            if (r2 <= 0) goto L_0x00eb
            org.json.JSONArray r1 = r1.getJSONArray(r9)     // Catch:{ Exception -> 0x0139 }
            r16 = r12
            r12 = r1
            r1 = r16
            goto L_0x0100
        L_0x00eb:
            java.lang.String r2 = "network_excl"
            r4 = 0
            r6 = 0
            r7 = 0
            r1 = r17
            r3 = r11
            r5 = r14
            org.json.JSONObject r1 = r1.getSuitableExperiment(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x00ff
            org.json.JSONArray r1 = r1.getJSONArray(r9)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0100
        L_0x00ff:
            r1 = r12
        L_0x0100:
            if (r12 == 0) goto L_0x0119
            int r2 = r12.length()     // Catch:{ Exception -> 0x0139 }
            if (r2 <= 0) goto L_0x0119
            if (r13 != 0) goto L_0x0114
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0139 }
            java.lang.String r2 = r18.toString()     // Catch:{ Exception -> 0x0139 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            r13 = r1
        L_0x0114:
            r1 = 0
            r8.markRemovedPlacements(r13, r12, r1)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0131
        L_0x0119:
            if (r1 == 0) goto L_0x0131
            int r2 = r1.length()     // Catch:{ Exception -> 0x0139 }
            if (r2 <= 0) goto L_0x0131
            if (r13 != 0) goto L_0x012d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0139 }
            java.lang.String r3 = r18.toString()     // Catch:{ Exception -> 0x0139 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0139 }
            r13 = r2
        L_0x012d:
            r2 = 1
            r8.markRemovedPlacements(r13, r1, r2)     // Catch:{ Exception -> 0x0139 }
        L_0x0131:
            if (r13 != 0) goto L_0x0134
            goto L_0x0135
        L_0x0134:
            r0 = r13
        L_0x0135:
            r10.put(r15, r0)     // Catch:{ Exception -> 0x0139 }
            goto L_0x013d
        L_0x0139:
            r0 = move-exception
            r0.printStackTrace()
        L_0x013d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostExperimentManager.updateZoneParameters(org.json.JSONObject):org.json.JSONObject");
    }

    /* access modifiers changed from: package-private */
    public void clearZoneNetworkFirstRequestMap(String str) {
        for (String next : this.isFirstRequestForZoneNetwork.keySet()) {
            if (next.contains(str + "*")) {
                keepZoneNetworkFirstRequest(str, next.split("\\*")[1], true);
            }
        }
    }

    public AdMostAdNetworkMeta getAdNetworkMeta(String str, String str2, boolean z, boolean z2, boolean z3) {
        String str3 = str + "*" + str2 + "*" + z + "*" + z2 + "*" + z3;
        if (this.adMostAdNetworkMetaCache.containsKey(str3)) {
            return this.adMostAdNetworkMetaCache.get(str3);
        }
        AdMostAdNetworkMeta adNetworkMeta = AdMost.getInstance().getConfiguration().getAdNetworkMeta(str);
        if (adNetworkMeta != null) {
            JSONObject suitableExperiment = getSuitableExperiment(TYPE_NETWORK, str2, str, z, z2, z3);
            if (suitableExperiment == null) {
                this.adMostAdNetworkMetaCache.put(str3, adNetworkMeta);
            } else {
                try {
                    AdMostAdNetworkMeta adMostAdNetworkMeta = (AdMostAdNetworkMeta) adNetworkMeta.clone();
                    adMostAdNetworkMeta.enrichWithExperimentJSON(suitableExperiment);
                    this.adMostAdNetworkMetaCache.put(str3, adMostAdNetworkMeta);
                    return adMostAdNetworkMeta;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return adNetworkMeta;
    }

    /* access modifiers changed from: package-private */
    public JSONObject getAlgorithmParams(JSONObject jSONObject) {
        JSONObject suitableExperiment;
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject updateZoneParameters = updateZoneParameters(jSONObject);
            boolean z = updateZoneParameters.getBoolean("isFirstRequestForZone");
            int i = 1;
            jSONObject2.put(TYPE_ALGORITHM, 1);
            jSONObject2.put("isFirstRequestForZone", z);
            jSONObject2.put("updatedData", updateZoneParameters.getJSONObject("updatedData"));
            JSONObject jSONObject3 = jSONObject.getJSONObject("Zone");
            if (!hasExperiment() || jSONObject3 == null || (suitableExperiment = getSuitableExperiment(TYPE_ALGORITHM, jSONObject3.optString("Id"), (String) null, z, false, false)) == null) {
                if (jSONObject3 != null && jSONObject3.optBoolean("FPHeadEnabled", false)) {
                    i = 2;
                }
                jSONObject2.put(TYPE_ALGORITHM, i);
                return jSONObject2;
            }
            jSONObject2.put(TYPE_ALGORITHM, suitableExperiment.optInt("Value", 1));
            return jSONObject2;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* access modifiers changed from: package-private */
    public String getCurrentExperiment() {
        String str = this.currentExperiment;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    public String getCurrentGroup() {
        String str = this.currentGroup;
        return str == null ? "" : str;
    }

    public FloorPriceConfig getFloorPriceConfig(String str, boolean z, String str2) {
        JSONObject suitableExperiment;
        FloorPriceConfig floorPriceConfig = AdMost.getInstance().getConfiguration().getFloorPriceConfig();
        if (!hasExperiment() || floorPriceConfig == null || (suitableExperiment = getSuitableExperiment("fp", str, str2, z, isZoneNetworkFirstRequest(str, str2), false)) == null) {
            return floorPriceConfig;
        }
        try {
            FloorPriceConfig floorPriceConfig2 = (FloorPriceConfig) floorPriceConfig.clone();
            floorPriceConfig2.enrichWithExperimentJSON(suitableExperiment);
            return floorPriceConfig2;
        } catch (Exception e) {
            e.printStackTrace();
            return floorPriceConfig;
        }
    }

    public AdMostConfiguration.InitParams getInitParams(String str, boolean z) {
        JSONObject suitableExperiment;
        AdMostConfiguration.InitParams initParams = AdMost.getInstance().getConfiguration().getInitParams();
        if (!hasExperiment() || initParams == null || (suitableExperiment = getSuitableExperiment(TYPE_INIT_PARAMS, str, (String) null, z, false, false)) == null) {
            return initParams;
        }
        try {
            AdMostConfiguration.InitParams initParams2 = (AdMostConfiguration.InitParams) initParams.clone();
            initParams2.enrichWithExperimentJSON(suitableExperiment);
            return initParams2;
        } catch (Exception e) {
            e.printStackTrace();
            return initParams;
        }
    }

    public RandomizerConfig getRandomizerConfig(String str, boolean z) {
        JSONObject suitableExperiment;
        RandomizerConfig randomizerConfig = AdMost.getInstance().getConfiguration().getRandomizerConfig();
        if (!hasExperiment() || randomizerConfig == null || (suitableExperiment = getSuitableExperiment(TYPE_RANDOMIZER, str, (String) null, z, false, false)) == null) {
            return randomizerConfig;
        }
        try {
            RandomizerConfig randomizerConfig2 = (RandomizerConfig) randomizerConfig.clone();
            randomizerConfig2.enrichWithExperimentJSON(suitableExperiment);
            return randomizerConfig2;
        } catch (Exception e) {
            e.printStackTrace();
            return randomizerConfig;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008b, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void joinExperiment(final org.json.JSONArray r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.joinExperimentCompleted     // Catch:{ all -> 0x0267 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r12)
            return
        L_0x0007:
            admost.sdk.base.AdMostPreferences r0 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ all -> 0x0267 }
            java.util.concurrent.ConcurrentHashMap r0 = r0.getFirstRequestForZoneNetwork()     // Catch:{ all -> 0x0267 }
            r12.isFirstRequestForZoneNetwork = r0     // Catch:{ all -> 0x0267 }
            admost.sdk.base.AdMostPreferences r0 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ all -> 0x0267 }
            java.lang.String r0 = r0.getExperimentAndGroup()     // Catch:{ all -> 0x0267 }
            java.lang.String r1 = "\\*"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ all -> 0x0267 }
            int r1 = r0.length     // Catch:{ all -> 0x0267 }
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x0031
            java.lang.String r1 = ""
            r2 = r0[r4]     // Catch:{ all -> 0x0267 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0267 }
            if (r1 != 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r13 == 0) goto L_0x024a
            int r2 = r13.length()     // Catch:{ all -> 0x0267 }
            if (r2 > 0) goto L_0x003c
            goto L_0x024a
        L_0x003c:
            if (r1 == 0) goto L_0x00d8
            r1 = 0
        L_0x003f:
            int r2 = r13.length()     // Catch:{ Exception -> 0x0245 }
            if (r1 >= r2) goto L_0x008b
            admost.sdk.model.AdMostExperiment r2 = new admost.sdk.model.AdMostExperiment     // Catch:{ Exception -> 0x0245 }
            org.json.JSONObject r5 = r13.getJSONObject(r1)     // Catch:{ Exception -> 0x0245 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0245 }
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r5 = r2.Meta     // Catch:{ Exception -> 0x0245 }
            java.lang.String r5 = r5.f253Id     // Catch:{ Exception -> 0x0245 }
            r6 = r0[r4]     // Catch:{ Exception -> 0x0245 }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x0245 }
            if (r5 == 0) goto L_0x0088
            boolean r1 = r2.isExperimentApplicable()     // Catch:{ Exception -> 0x0245 }
            if (r1 == 0) goto L_0x008b
            r1 = 0
        L_0x0061:
            java.util.Vector<admost.sdk.model.AdMostExperiment$AdMostExperimentGroup> r5 = r2.Groups     // Catch:{ Exception -> 0x0245 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0245 }
            if (r1 >= r5) goto L_0x008b
            java.util.Vector<admost.sdk.model.AdMostExperiment$AdMostExperimentGroup> r5 = r2.Groups     // Catch:{ Exception -> 0x0245 }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ Exception -> 0x0245 }
            admost.sdk.model.AdMostExperiment$AdMostExperimentGroup r5 = (admost.sdk.model.AdMostExperiment.AdMostExperimentGroup) r5     // Catch:{ Exception -> 0x0245 }
            java.lang.String r5 = r5.Name     // Catch:{ Exception -> 0x0245 }
            r6 = r0[r3]     // Catch:{ Exception -> 0x0245 }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x0245 }
            if (r5 == 0) goto L_0x0085
            r1 = r0[r4]     // Catch:{ Exception -> 0x0245 }
            r12.currentExperiment = r1     // Catch:{ Exception -> 0x0245 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0245 }
            r12.currentGroup = r0     // Catch:{ Exception -> 0x0245 }
            r0 = 1
            goto L_0x008c
        L_0x0085:
            int r1 = r1 + 1
            goto L_0x0061
        L_0x0088:
            int r1 = r1 + 1
            goto L_0x003f
        L_0x008b:
            r0 = 0
        L_0x008c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0245 }
            r1.<init>()     // Catch:{ Exception -> 0x0245 }
            java.lang.String r2 = "We have an EXPERIMENT : "
            r1.append(r2)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r2 = r12.currentExperiment     // Catch:{ Exception -> 0x0245 }
            r1.append(r2)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r2 = " GROUP : "
            r1.append(r2)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r2 = r12.currentGroup     // Catch:{ Exception -> 0x0245 }
            r1.append(r2)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0245 }
            admost.sdk.base.AdMostLog.m299i(r1)     // Catch:{ Exception -> 0x0245 }
            if (r0 != 0) goto L_0x00d8
            r12.sendOldImpressions()     // Catch:{ Exception -> 0x0245 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0245 }
            r0.<init>()     // Catch:{ Exception -> 0x0245 }
            java.lang.String r1 = "EXPERIMENT deleted : "
            r0.append(r1)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r1 = r12.currentExperiment     // Catch:{ Exception -> 0x0245 }
            r0.append(r1)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r1 = " GROUP : "
            r0.append(r1)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r1 = r12.currentGroup     // Catch:{ Exception -> 0x0245 }
            r0.append(r1)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0245 }
            admost.sdk.base.AdMostLog.m296e(r0)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = ""
            java.lang.String r1 = ""
            r12.keepExperimentAndGroup(r0, r1)     // Catch:{ Exception -> 0x0245 }
        L_0x00d8:
            boolean r0 = r12.hasExperiment()     // Catch:{ Exception -> 0x0245 }
            if (r0 != 0) goto L_0x0256
            admost.sdk.base.AdMostPreferences r0 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = r0.getCountry()     // Catch:{ Exception -> 0x0245 }
            if (r0 == 0) goto L_0x0220
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0245 }
            if (r0 == 0) goto L_0x00f2
            goto L_0x0220
        L_0x00f2:
            admost.sdk.base.AdMostAnalyticsManager r0 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ Exception -> 0x0245 }
            r0.getUserId()     // Catch:{ Exception -> 0x0245 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0245 }
            r0.<init>()     // Catch:{ Exception -> 0x0245 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0245 }
            r1.<init>()     // Catch:{ Exception -> 0x0245 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0245 }
            r2.<init>()     // Catch:{ Exception -> 0x0245 }
            admost.sdk.base.AdMostPreferences r5 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ Exception -> 0x0245 }
            java.util.ArrayList r5 = r5.getExperimentsTriedBefore()     // Catch:{ Exception -> 0x0245 }
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0113:
            int r9 = r13.length()     // Catch:{ Exception -> 0x0245 }
            if (r4 >= r9) goto L_0x0175
            admost.sdk.model.AdMostExperiment r9 = new admost.sdk.model.AdMostExperiment     // Catch:{ Exception -> 0x0245 }
            org.json.JSONObject r10 = r13.getJSONObject(r4)     // Catch:{ Exception -> 0x0245 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0245 }
            boolean r10 = r9.isExperimentApplicable()     // Catch:{ Exception -> 0x0245 }
            if (r10 == 0) goto L_0x0172
            if (r5 == 0) goto L_0x0134
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r10 = r9.Meta     // Catch:{ Exception -> 0x0245 }
            java.lang.String r10 = r10.f253Id     // Catch:{ Exception -> 0x0245 }
            boolean r10 = r5.contains(r10)     // Catch:{ Exception -> 0x0245 }
            if (r10 != 0) goto L_0x0172
        L_0x0134:
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r10 = r9.Meta     // Catch:{ Exception -> 0x0245 }
            java.lang.String r10 = r10.AudienceType     // Catch:{ Exception -> 0x0245 }
            java.lang.String r11 = "new"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0245 }
            if (r10 == 0) goto L_0x0149
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r10 = r9.Meta     // Catch:{ Exception -> 0x0245 }
            int r10 = r10.Percentage     // Catch:{ Exception -> 0x0245 }
            int r6 = r6 + r10
            r0.add(r9)     // Catch:{ Exception -> 0x0245 }
            goto L_0x0172
        L_0x0149:
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r10 = r9.Meta     // Catch:{ Exception -> 0x0245 }
            java.lang.String r10 = r10.AudienceType     // Catch:{ Exception -> 0x0245 }
            java.lang.String r11 = "existing"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0245 }
            if (r10 == 0) goto L_0x015e
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r10 = r9.Meta     // Catch:{ Exception -> 0x0245 }
            int r10 = r10.Percentage     // Catch:{ Exception -> 0x0245 }
            int r7 = r7 + r10
            r1.add(r9)     // Catch:{ Exception -> 0x0245 }
            goto L_0x0172
        L_0x015e:
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r10 = r9.Meta     // Catch:{ Exception -> 0x0245 }
            java.lang.String r10 = r10.AudienceType     // Catch:{ Exception -> 0x0245 }
            java.lang.String r11 = "all"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0245 }
            if (r10 == 0) goto L_0x0172
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r10 = r9.Meta     // Catch:{ Exception -> 0x0245 }
            int r10 = r10.Percentage     // Catch:{ Exception -> 0x0245 }
            int r8 = r8 + r10
            r2.add(r9)     // Catch:{ Exception -> 0x0245 }
        L_0x0172:
            int r4 = r4 + 1
            goto L_0x0113
        L_0x0175:
            int r13 = r2.size()     // Catch:{ Exception -> 0x0245 }
            if (r13 > 0) goto L_0x01a4
            int r13 = r0.size()     // Catch:{ Exception -> 0x0245 }
            if (r13 > 0) goto L_0x018b
            admost.sdk.base.AdMostAnalyticsManager r13 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ Exception -> 0x0245 }
            boolean r13 = r13.isNewUser()     // Catch:{ Exception -> 0x0245 }
            if (r13 != 0) goto L_0x019b
        L_0x018b:
            int r13 = r1.size()     // Catch:{ Exception -> 0x0245 }
            if (r13 > 0) goto L_0x01a4
            admost.sdk.base.AdMostAnalyticsManager r13 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ Exception -> 0x0245 }
            boolean r13 = r13.isNewUser()     // Catch:{ Exception -> 0x0245 }
            if (r13 != 0) goto L_0x01a4
        L_0x019b:
            java.lang.String r13 = ""
            java.lang.String r4 = ""
            r12.keepExperimentAndGroup(r13, r4)     // Catch:{ Exception -> 0x0245 }
            r12.joinExperimentCompleted = r3     // Catch:{ Exception -> 0x0245 }
        L_0x01a4:
            admost.sdk.base.AdMostAnalyticsManager r13 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ Exception -> 0x0245 }
            boolean r13 = r13.isNewUser()     // Catch:{ Exception -> 0x0245 }
            if (r13 == 0) goto L_0x01bb
            admost.sdk.base.AdMostPreferences r13 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ Exception -> 0x0245 }
            int r13 = r13.getExperimentPercentile()     // Catch:{ Exception -> 0x0245 }
            admost.sdk.model.AdMostExperiment r13 = r12.pickAnExperiment(r0, r13, r6)     // Catch:{ Exception -> 0x0245 }
            goto L_0x01c7
        L_0x01bb:
            admost.sdk.base.AdMostPreferences r13 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ Exception -> 0x0245 }
            int r13 = r13.getExperimentPercentile()     // Catch:{ Exception -> 0x0245 }
            admost.sdk.model.AdMostExperiment r13 = r12.pickAnExperiment(r1, r13, r7)     // Catch:{ Exception -> 0x0245 }
        L_0x01c7:
            if (r13 != 0) goto L_0x01d8
            java.util.Random r13 = new java.util.Random     // Catch:{ Exception -> 0x0245 }
            r13.<init>()     // Catch:{ Exception -> 0x0245 }
            r0 = 100
            int r13 = r13.nextInt(r0)     // Catch:{ Exception -> 0x0245 }
            admost.sdk.model.AdMostExperiment r13 = r12.pickAnExperiment(r2, r13, r8)     // Catch:{ Exception -> 0x0245 }
        L_0x01d8:
            if (r13 == 0) goto L_0x0256
            r12.sendOldImpressions()     // Catch:{ Exception -> 0x0245 }
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r0 = r13.Meta     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = r0.f253Id     // Catch:{ Exception -> 0x0245 }
            r12.currentExperiment = r0     // Catch:{ Exception -> 0x0245 }
            java.util.Random r0 = new java.util.Random     // Catch:{ Exception -> 0x0245 }
            r0.<init>()     // Catch:{ Exception -> 0x0245 }
            java.util.Vector<admost.sdk.model.AdMostExperiment$AdMostExperimentGroup> r1 = r13.Groups     // Catch:{ Exception -> 0x0245 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0245 }
            int r0 = r0.nextInt(r1)     // Catch:{ Exception -> 0x0245 }
            java.util.Vector<admost.sdk.model.AdMostExperiment$AdMostExperimentGroup> r13 = r13.Groups     // Catch:{ Exception -> 0x0245 }
            java.lang.Object r13 = r13.get(r0)     // Catch:{ Exception -> 0x0245 }
            admost.sdk.model.AdMostExperiment$AdMostExperimentGroup r13 = (admost.sdk.model.AdMostExperiment.AdMostExperimentGroup) r13     // Catch:{ Exception -> 0x0245 }
            java.lang.String r13 = r13.Name     // Catch:{ Exception -> 0x0245 }
            r12.currentGroup = r13     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = r12.currentExperiment     // Catch:{ Exception -> 0x0245 }
            r12.keepExperimentAndGroup(r0, r13)     // Catch:{ Exception -> 0x0245 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0245 }
            r13.<init>()     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = "just joined to an EXPERIMENT : "
            r13.append(r0)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = r12.currentExperiment     // Catch:{ Exception -> 0x0245 }
            r13.append(r0)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = " GROUP : "
            r13.append(r0)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = r12.currentGroup     // Catch:{ Exception -> 0x0245 }
            r13.append(r0)     // Catch:{ Exception -> 0x0245 }
            r13.toString()     // Catch:{ Exception -> 0x0245 }
            goto L_0x0256
        L_0x0220:
            admost.sdk.base.AdMostExperimentManager$1 r0 = new admost.sdk.base.AdMostExperimentManager$1     // Catch:{ Exception -> 0x0245 }
            r0.<init>(r13)     // Catch:{ Exception -> 0x0245 }
            r12.countryResponseObserver = r0     // Catch:{ Exception -> 0x0245 }
            admost.sdk.base.AdMostCountryResponseObservable r0 = admost.sdk.base.AdMostCountryResponseObservable.getInstance()     // Catch:{ Exception -> 0x0245 }
            java.util.Observer r1 = r12.countryResponseObserver     // Catch:{ Exception -> 0x0245 }
            r0.addObserver(r1)     // Catch:{ Exception -> 0x0245 }
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Exception -> 0x0245 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0245 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0245 }
            admost.sdk.base.AdMostExperimentManager$2 r1 = new admost.sdk.base.AdMostExperimentManager$2     // Catch:{ Exception -> 0x0245 }
            r1.<init>(r13)     // Catch:{ Exception -> 0x0245 }
            r4 = 1500(0x5dc, double:7.41E-321)
            r0.postDelayed(r1, r4)     // Catch:{ Exception -> 0x0245 }
            monitor-exit(r12)
            return
        L_0x0245:
            r13 = move-exception
            r13.printStackTrace()     // Catch:{ all -> 0x0267 }
            goto L_0x0256
        L_0x024a:
            if (r1 == 0) goto L_0x024f
            r12.sendOldImpressions()     // Catch:{ all -> 0x0267 }
        L_0x024f:
            java.lang.String r13 = ""
            java.lang.String r0 = ""
            r12.keepExperimentAndGroup(r13, r0)     // Catch:{ all -> 0x0267 }
        L_0x0256:
            boolean r13 = r12.hasExperiment()     // Catch:{ all -> 0x0267 }
            if (r13 == 0) goto L_0x0260
            r12.makeExperimentRequest()     // Catch:{ all -> 0x0267 }
            goto L_0x0263
        L_0x0260:
            r12.setInitCompleted()     // Catch:{ all -> 0x0267 }
        L_0x0263:
            r12.joinExperimentCompleted = r3     // Catch:{ all -> 0x0267 }
            monitor-exit(r12)
            return
        L_0x0267:
            r13 = move-exception
            monitor-exit(r12)
            goto L_0x026b
        L_0x026a:
            throw r13
        L_0x026b:
            goto L_0x026a
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostExperimentManager.joinExperiment(org.json.JSONArray):void");
    }

    /* access modifiers changed from: package-private */
    public void keepZoneNetworkFirstRequest(String str, String str2, boolean z) {
        String str3 = str + "*" + str2;
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.isFirstRequestForZoneNetwork;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str3) || this.isFirstRequestForZoneNetwork.get(str3).booleanValue() != z) {
            this.isFirstRequestForZoneNetwork.put(str3, Boolean.valueOf(z));
            AdMostPreferences.getInstance().keepFirstRequestForZoneNetwork(str3, z);
        }
    }

    public boolean useADMLWeight(String str, boolean z, String str2) {
        JSONObject suitableExperiment;
        if (!hasExperiment() || (suitableExperiment = getSuitableExperiment(TYPE_ADML_WEIGHT, str, str2, z, false, false)) == null) {
            return false;
        }
        try {
            return suitableExperiment.optBoolean(TYPE_ADML_WEIGHT, false);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
