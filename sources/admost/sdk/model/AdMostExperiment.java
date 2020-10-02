package admost.sdk.model;

import admost.sdk.base.AdMostExperimentManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostExperiment {
    public Vector<AdMostExperimentGroup> Groups;
    public AdMostExperimentMeta Meta;

    public static class AdMostExperimentContext {
        public boolean ForAllNetworks;
        public boolean ForAllZones;
        public ArrayList<String> Networks;
        public String Request;
        public int RequestSortValue;
        public ArrayList<String> Zones;

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0077 A[SYNTHETIC, Splitter:B:31:0x0077] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AdMostExperimentContext(org.json.JSONObject r7) {
            /*
                r6 = this;
                r6.<init>()
                if (r7 != 0) goto L_0x0006
                return
            L_0x0006:
                java.lang.String r0 = "RequestType"
                java.lang.String r1 = ""
                java.lang.String r0 = r7.optString(r0, r1)     // Catch:{ Exception -> 0x0099 }
                r6.Request = r0     // Catch:{ Exception -> 0x0099 }
                java.lang.String r1 = "firstNetwork"
                boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0099 }
                r1 = 1
                if (r0 == 0) goto L_0x001b
                r0 = 4
                goto L_0x0034
            L_0x001b:
                java.lang.String r0 = r6.Request     // Catch:{ Exception -> 0x0099 }
                java.lang.String r2 = "firstZone"
                boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x0027
                r0 = 3
                goto L_0x0034
            L_0x0027:
                java.lang.String r0 = r6.Request     // Catch:{ Exception -> 0x0099 }
                java.lang.String r2 = "firstInit"
                boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x0033
                r0 = 2
                goto L_0x0034
            L_0x0033:
                r0 = 1
            L_0x0034:
                r6.RequestSortValue = r0     // Catch:{ Exception -> 0x0099 }
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0099 }
                r0.<init>()     // Catch:{ Exception -> 0x0099 }
                r6.Zones = r0     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = "Zones"
                org.json.JSONArray r0 = r7.optJSONArray(r0)     // Catch:{ Exception -> 0x0099 }
                r2 = 0
                if (r0 == 0) goto L_0x005f
                int r3 = r0.length()     // Catch:{ Exception -> 0x0062 }
                if (r3 <= 0) goto L_0x005f
                r3 = 0
            L_0x004d:
                int r4 = r0.length()     // Catch:{ Exception -> 0x0062 }
                if (r3 >= r4) goto L_0x0068
                java.util.ArrayList<java.lang.String> r4 = r6.Zones     // Catch:{ Exception -> 0x0062 }
                java.lang.String r5 = r0.getString(r3)     // Catch:{ Exception -> 0x0062 }
                r4.add(r5)     // Catch:{ Exception -> 0x0062 }
                int r3 = r3 + 1
                goto L_0x004d
            L_0x005f:
                r6.ForAllZones = r1     // Catch:{ Exception -> 0x0062 }
                goto L_0x0068
            L_0x0062:
                r0 = move-exception
                r6.ForAllZones = r1     // Catch:{ Exception -> 0x0099 }
                r0.printStackTrace()     // Catch:{ Exception -> 0x0099 }
            L_0x0068:
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0099 }
                r0.<init>()     // Catch:{ Exception -> 0x0099 }
                r6.Networks = r0     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = "Networks"
                org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch:{ Exception -> 0x0099 }
                if (r7 == 0) goto L_0x008f
                int r0 = r7.length()     // Catch:{ Exception -> 0x0092 }
                if (r0 <= 0) goto L_0x008f
            L_0x007d:
                int r0 = r7.length()     // Catch:{ Exception -> 0x0092 }
                if (r2 >= r0) goto L_0x009d
                java.util.ArrayList<java.lang.String> r0 = r6.Networks     // Catch:{ Exception -> 0x0092 }
                java.lang.String r3 = r7.getString(r2)     // Catch:{ Exception -> 0x0092 }
                r0.add(r3)     // Catch:{ Exception -> 0x0092 }
                int r2 = r2 + 1
                goto L_0x007d
            L_0x008f:
                r6.ForAllNetworks = r1     // Catch:{ Exception -> 0x0092 }
                goto L_0x009d
            L_0x0092:
                r7 = move-exception
                r6.ForAllNetworks = r1     // Catch:{ Exception -> 0x0099 }
                r7.printStackTrace()     // Catch:{ Exception -> 0x0099 }
                goto L_0x009d
            L_0x0099:
                r7 = move-exception
                r7.printStackTrace()
            L_0x009d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: admost.sdk.model.AdMostExperiment.AdMostExperimentContext.<init>(org.json.JSONObject):void");
        }
    }

    public static class AdMostExperimentDetail {
        public AdMostExperimentContext Context;
        public JSONObject Json;
        public String Type;

        public AdMostExperimentDetail(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.Type = jSONObject.optString("Type", "");
                    this.Json = jSONObject.optJSONObject("Value");
                    this.Context = new AdMostExperimentContext(jSONObject.optJSONObject("Context"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public boolean isExperimentItemApplicable(String str, String str2, boolean z, boolean z2, boolean z3) {
            ArrayList<String> arrayList;
            if (!z && this.Context.Request.equals(AdMostExperimentManager.REQUEST_FIRST_ZONE)) {
                return false;
            }
            if (this.Type.equals("fp") || this.Type.equals(AdMostExperimentManager.TYPE_NETWORK)) {
                if (!z2 && this.Context.Request.equals(AdMostExperimentManager.REQUEST_FIRST_NETWORK)) {
                    return false;
                }
                AdMostExperimentContext adMostExperimentContext = this.Context;
                if (!adMostExperimentContext.ForAllNetworks && str2 != null && ((arrayList = adMostExperimentContext.Networks) == null || !arrayList.contains(str2))) {
                    return false;
                }
            }
            if (this.Type.equals(AdMostExperimentManager.TYPE_NETWORK) && !z3 && this.Context.Request.equals(AdMostExperimentManager.REQUEST_FIRST_INIT)) {
                return false;
            }
            AdMostExperimentContext adMostExperimentContext2 = this.Context;
            if (adMostExperimentContext2.ForAllZones || str == null) {
                return true;
            }
            ArrayList<String> arrayList2 = adMostExperimentContext2.Zones;
            if (arrayList2 != null && arrayList2.contains(str)) {
                return true;
            }
            return false;
        }
    }

    public static class AdMostExperimentGroup {
        public String Name;

        public AdMostExperimentGroup(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.Name = jSONObject.optString("Name", "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class AdMostExperimentMeta {
        public String AudienceType;
        public ArrayList<String> Countries = new ArrayList<>();
        public long EndsAt;

        /* renamed from: Id */
        public String f253Id;
        public String Name;
        public int Percentage;
        public long StartedAt;

        public AdMostExperimentMeta(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.f253Id = jSONObject.optString("ID", "");
                    this.Name = jSONObject.optString("Name", "");
                    this.Percentage = jSONObject.optInt("Percentage", 0);
                    this.StartedAt = jSONObject.optLong("StartedAt", 0) * 1000;
                    this.EndsAt = jSONObject.optLong("EndsAt", 0) * 1000;
                    this.AudienceType = jSONObject.optString("Audience", "all");
                    JSONArray optJSONArray = jSONObject.optJSONArray("Country");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            this.Countries.add(optJSONArray.getString(i));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class CustomComparatorContext implements Comparator<AdMostExperimentDetail> {
        public int compare(AdMostExperimentDetail adMostExperimentDetail, AdMostExperimentDetail adMostExperimentDetail2) {
            return Integer.valueOf(adMostExperimentDetail2.Context.RequestSortValue).compareTo(Integer.valueOf(adMostExperimentDetail.Context.RequestSortValue));
        }
    }

    public AdMostExperiment(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Meta = new AdMostExperimentMeta(jSONObject.optJSONObject("Meta"));
                JSONArray jSONArray = jSONObject.getJSONArray("Groups");
                this.Groups = new Vector<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.Groups.add(new AdMostExperimentGroup(jSONArray.getJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = r5.Groups;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isExperimentApplicable() {
        /*
            r5 = this;
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r0 = r5.Meta
            long r0 = r0.EndsAt
            long r2 = java.lang.System.currentTimeMillis()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0040
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r0 = r5.Meta
            long r0 = r0.StartedAt
            long r2 = java.lang.System.currentTimeMillis()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0040
            java.util.Vector<admost.sdk.model.AdMostExperiment$AdMostExperimentGroup> r0 = r5.Groups
            if (r0 == 0) goto L_0x0040
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0040
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r0 = r5.Meta
            java.util.ArrayList<java.lang.String> r0 = r0.Countries
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x003e
            admost.sdk.model.AdMostExperiment$AdMostExperimentMeta r0 = r5.Meta
            java.util.ArrayList<java.lang.String> r0 = r0.Countries
            admost.sdk.base.AdMostPreferences r1 = admost.sdk.base.AdMostPreferences.getInstance()
            java.lang.String r1 = r1.getCountry()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0040
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.model.AdMostExperiment.isExperimentApplicable():boolean");
    }
}
