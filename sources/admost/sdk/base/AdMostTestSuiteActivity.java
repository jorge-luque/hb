package admost.sdk.base;

import admost.sdk.AdMostInterstitial;
import admost.sdk.AdMostInterstitialManager;
import admost.sdk.AdMostView;
import admost.sdk.BuildConfig;
import admost.sdk.C0164R;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostWaterfallLog;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostTestSuiteActivity extends Activity {
    private String AdNetworkString = "";
    /* access modifiers changed from: private */
    public Adapter adapterPlacement;
    /* access modifiers changed from: private */
    public Adapter adapterZone;
    /* access modifiers changed from: private */
    public AdMostView bannerAd;
    /* access modifiers changed from: private */
    public LayoutInflater inflater;
    /* access modifiers changed from: private */
    public AdMostInterstitial interstitialAd;
    /* access modifiers changed from: private */
    public int lastSelectedPlacementPos = -1;
    /* access modifiers changed from: private */
    public int lastSelectedZonePos = -1;
    /* access modifiers changed from: private */
    public Button loadButton;
    private HashSet<String> networks = new HashSet<>();
    private int responseCount = 0;
    /* access modifiers changed from: private */
    public Button showButton;
    /* access modifiers changed from: private */
    public Spinner spinnerPlacement;
    /* access modifiers changed from: private */
    public Spinner spinnerZone;
    /* access modifiers changed from: private */
    public TextView textViewError;
    /* access modifiers changed from: private */
    public ArrayList<String> zoneArray = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<String, AdMostBannerResponseBase> zoneResponseMap = new HashMap<>();

    private class Adapter extends BaseAdapter {
        private final ArrayList<Object> data = new ArrayList<>();
        private AdapterListener listener;

        Adapter(AdapterListener adapterListener) {
            this.listener = adapterListener;
        }

        /* access modifiers changed from: package-private */
        public void addItem(Object obj) {
            this.data.add(obj);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.data.clear();
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.data.size();
        }

        public Object getItem(int i) {
            return this.data.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return this.listener.onListGetView(i, view, viewGroup);
        }
    }

    private interface AdapterListener {
        View onListGetView(int i, View view, ViewGroup viewGroup);
    }

    private class HolderPlacement {
        private TextView adspaceId;
        private TextView networkName;
        private TextView noSDKError;
        private TextView placementName;
        private TextView type;
        private TextView warningText;

        HolderPlacement(View view) {
            this.networkName = (TextView) view.findViewById(C0164R.C0166id.networkName);
            this.noSDKError = (TextView) view.findViewById(C0164R.C0166id.noSDKError);
            this.type = (TextView) view.findViewById(C0164R.C0166id.type);
            this.adspaceId = (TextView) view.findViewById(C0164R.C0166id.adspaceId);
            this.warningText = (TextView) view.findViewById(C0164R.C0166id.warningText);
            this.placementName = (TextView) view.findViewById(C0164R.C0166id.placementName);
        }

        public void set(AdMostBannerResponseItem adMostBannerResponseItem) {
            String str;
            this.warningText.setVisibility(8);
            this.networkName.setText(adMostBannerResponseItem.Network);
            if (adMostBannerResponseItem.Network.indexOf(" ") > 0) {
                this.noSDKError.setText("");
                this.adspaceId.setText("");
                this.placementName.setText("");
            } else {
                TextView textView = this.noSDKError;
                if (AdMostAdNetwork.isAdNetworkAvailable(adMostBannerResponseItem.Network)) {
                    str = "";
                } else {
                    str = "NO SDK";
                }
                textView.setText(str);
                TextView textView2 = this.adspaceId;
                textView2.setText("ID: " + adMostBannerResponseItem.AdSpaceId);
                TextView textView3 = this.placementName;
                textView3.setText("Name: " + adMostBannerResponseItem.PlacementName);
            }
            this.type.setText(adMostBannerResponseItem.Type);
            if (adMostBannerResponseItem.ZoneType.equals(AdMostZoneType.FULLSCREEN)) {
                boolean z = true;
                AdMostFullScreenInterface fullScreenAdapter = AdMostAdNetworkManager.getInstance().getFullScreenAdapter(adMostBannerResponseItem, true, false);
                if (fullScreenAdapter == null || adMostBannerResponseItem.Type.equals("") || !AdMostInterstitialManager.getInstance().isInSingletonArray(fullScreenAdapter)) {
                    z = false;
                }
                if (z) {
                    AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem.WaterFallLogItem;
                    if (adMostWaterfallLog.isFilled && !adMostWaterfallLog.isShown) {
                        this.warningText.setText("Singleton Placement and loaded before.");
                        this.warningText.setVisibility(0);
                    }
                }
            }
        }
    }

    private class HolderZone {
        private TextView zoneId;
        private TextView zoneName;
        private TextView zoneType;

        HolderZone(View view) {
            this.zoneName = (TextView) view.findViewById(C0164R.C0166id.zoneName);
            this.zoneType = (TextView) view.findViewById(C0164R.C0166id.zoneType);
            this.zoneId = (TextView) view.findViewById(C0164R.C0166id.zoneId);
        }

        public void set(AdMostBannerResponseBase adMostBannerResponseBase) {
            this.zoneName.setText(adMostBannerResponseBase.zoneName);
            this.zoneType.setText(adMostBannerResponseBase.ZoneType);
            this.zoneId.setText(adMostBannerResponseBase.ZoneId);
        }
    }

    static /* synthetic */ int access$408(AdMostTestSuiteActivity adMostTestSuiteActivity) {
        int i = adMostTestSuiteActivity.responseCount;
        adMostTestSuiteActivity.responseCount = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public String getErrorName(int i) {
        if (i == 500) {
            return "ERROR_CONNECTION";
        }
        if (i == 501) {
            return "AD_ERROR_TOO_MANY_REQUEST";
        }
        switch (i) {
            case AdMost.AD_ERROR_FREQ_CAP:
                return "ERROR_FREQ_CAP";
            case AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN:
                return "AD_ERROR_FREQ_CAP_ON_SHOWN";
            case AdMost.AD_ERROR_TAG_PASSIVE:
                return "AD_ERROR_TAG_PASSIVE";
            case AdMost.AD_ERROR_ZONE_PASSIVE:
                return "AD_ERROR_ZONE_PASSIVE";
            default:
                switch (i) {
                    case 400:
                        return "ERROR_NO_FILL";
                    case AdMost.AD_ERROR_WATERFALL_EMPTY:
                        return "ERROR_WATERFALL_EMPTY";
                    case AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID:
                        return "AD_ERROR_INCOMPATIBLE_APP_ZONE_ID";
                    default:
                        return "ERROR";
                }
        }
    }

    private void keyControl() {
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            String string = applicationInfo.metaData.getString("applovin.sdk.key");
            String str = applicationInfo.packageName;
            TextView textView = (TextView) findViewById(C0164R.C0166id.applovinkeyerror);
            if (string == null) {
                textView.setText("Applovin SDK Key is not found.");
            } else if (!string.equals("LN_kr2mUpK0zI5JgqhgM2IW5FkVtb0pxOpeDsPifkic1owhcbM-efUlwDEnpFZkdNNrDnTtVFUW2ODe_ZceD6N") || str.equals("com.kokteyl.amrunity") || str.equals("com.kokteyl.mackolik") || str.equals("com.kokteyl.sahadan") || str.equals("com.masomo.drawpath")) {
                textView.setTextColor(-16777216);
                textView.setText("Applovin Key: " + string);
            } else {
                textView.setTextColor(-65536);
                textView.setText("Applovin SDK Key is not edited. Please enter your key on AndroidManifest.xml");
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load() {
        /*
            r11 = this;
            int r0 = admost.sdk.C0164R.C0166id.bannerLayout
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.removeAllViews()
            android.widget.TextView r1 = r11.textViewError
            java.lang.String r2 = ""
            r1.setText(r2)
            android.widget.Button r1 = r11.loadButton
            r2 = 0
            r1.setEnabled(r2)
            android.widget.Button r1 = r11.showButton
            r1.setEnabled(r2)
            android.widget.Button r1 = r11.showButton
            r3 = 0
            r1.setOnClickListener(r3)
            admost.sdk.base.AdMostTestSuiteActivity$Adapter r1 = r11.adapterZone
            android.widget.Spinner r3 = r11.spinnerZone
            int r3 = r3.getSelectedItemPosition()
            java.lang.Object r1 = r1.getItem(r3)
            admost.sdk.model.AdMostBannerResponseBase r1 = (admost.sdk.model.AdMostBannerResponseBase) r1
            admost.sdk.base.AdMostTestSuiteActivity$Adapter r3 = r11.adapterPlacement
            android.widget.Spinner r4 = r11.spinnerPlacement
            int r4 = r4.getSelectedItemPosition()
            java.lang.Object r3 = r3.getItem(r4)
            admost.sdk.model.AdMostBannerResponseItem r3 = (admost.sdk.model.AdMostBannerResponseItem) r3
            java.lang.String r4 = r1.ZoneType
            int r5 = r4.hashCode()
            r6 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            r7 = 1
            if (r5 == r6) goto L_0x005b
            r6 = 110066619(0x68f7bbb, float:5.3972427E-35)
            if (r5 == r6) goto L_0x0051
            goto L_0x0065
        L_0x0051:
            java.lang.String r5 = "fullscreen"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0065
            r4 = 0
            goto L_0x0066
        L_0x005b:
            java.lang.String r5 = "banner"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0065
            r4 = 1
            goto L_0x0066
        L_0x0065:
            r4 = -1
        L_0x0066:
            if (r4 == 0) goto L_0x00b0
            if (r4 == r7) goto L_0x006c
            goto L_0x00e7
        L_0x006c:
            admost.sdk.AdMostView r2 = r11.bannerAd
            if (r2 == 0) goto L_0x0073
            r2.destroy()
        L_0x0073:
            admost.sdk.AdMostView r2 = new admost.sdk.AdMostView
            java.lang.String r6 = r1.ZoneId
            java.lang.String r4 = r1.ZoneSize
            int r7 = java.lang.Integer.parseInt(r4)
            admost.sdk.base.AdMostTestSuiteActivity$13 r8 = new admost.sdk.base.AdMostTestSuiteActivity$13
            r8.<init>(r0)
            r9 = 0
            r4 = r2
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            r11.bannerAd = r2
            android.widget.Spinner r0 = r11.spinnerPlacement
            int r0 = r0.getSelectedItemPosition()
            if (r0 != 0) goto L_0x0098
            admost.sdk.AdMostView r0 = r11.bannerAd
            r0.load()
            goto L_0x00e7
        L_0x0098:
            admost.sdk.AdMostView r0 = r11.bannerAd
            java.lang.String r2 = r3.Network
            java.lang.String r4 = r3.Type
            java.lang.String r5 = r3.PlacementId
            java.lang.String r6 = r3.AdSpaceId
            int r7 = r1.ZoneRequestTimeout
            boolean r8 = r3.IsBiddingItem
            r1 = r0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r1.testAd(r2, r3, r4, r5, r6, r7)
            goto L_0x00e7
        L_0x00b0:
            admost.sdk.AdMostInterstitial r0 = r11.interstitialAd
            if (r0 == 0) goto L_0x00b7
            r0.destroy()
        L_0x00b7:
            admost.sdk.AdMostInterstitial r0 = new admost.sdk.AdMostInterstitial
            java.lang.String r4 = r1.ZoneId
            admost.sdk.base.AdMostTestSuiteActivity$12 r5 = new admost.sdk.base.AdMostTestSuiteActivity$12
            r5.<init>()
            r0.<init>(r11, r4, r5)
            r11.interstitialAd = r0
            android.widget.Spinner r0 = r11.spinnerPlacement
            int r0 = r0.getSelectedItemPosition()
            if (r0 != 0) goto L_0x00d3
            admost.sdk.AdMostInterstitial r0 = r11.interstitialAd
            r0.refreshAd(r2)
            goto L_0x00e7
        L_0x00d3:
            admost.sdk.AdMostInterstitial r0 = r11.interstitialAd
            java.lang.String r4 = r3.Network
            java.lang.String r5 = r3.Type
            java.lang.String r6 = r3.PlacementId
            java.lang.String r7 = r3.AdSpaceId
            int r8 = r1.ZoneRequestTimeout
            java.lang.String r9 = r1.SubZoneType
            boolean r10 = r3.IsBiddingItem
            r3 = r0
            r3.testAd(r4, r5, r6, r7, r8, r9, r10)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostTestSuiteActivity.load():void");
    }

    /* access modifiers changed from: private */
    public void setInfoLayout() {
        setContentView(C0164R.layout.admost_test_info);
        String[] availableAdNetworks = AdMostAdNetwork.getAvailableAdNetworks();
        for (int i = 0; i < availableAdNetworks.length; i++) {
            if (!availableAdNetworks[i].equals(AdMostAdNetwork.PREMIUM) && !availableAdNetworks[i].equals(AdMostAdNetwork.CROSSPROMOTION)) {
                AdMostAdNetworkInitInterface initAdapter = AdMostAdNetworkManager.getInstance().getInitAdapter(availableAdNetworks[i]);
                if (initAdapter == null || initAdapter.hasInitializationError) {
                    this.AdNetworkString += availableAdNetworks[i] + ", ";
                } else if (initAdapter.getVersion().equals("not implemented") || initAdapter.getVersion().equals("")) {
                    this.AdNetworkString += availableAdNetworks[i] + ", ";
                } else {
                    this.AdNetworkString += availableAdNetworks[i] + " " + initAdapter.getVersion() + ", ";
                }
            }
        }
        if (this.AdNetworkString.length() > 2) {
            String str = this.AdNetworkString;
            this.AdNetworkString = str.substring(0, str.length() - 2);
        }
        ((TextView) findViewById(C0164R.C0166id.amrVersion)).setText(BuildConfig.VERSION_NAME);
        ((TextView) findViewById(C0164R.C0166id.advID)).setText(AdMostPreferences.getInstance().getAdvId());
        ((TextView) findViewById(C0164R.C0166id.appID)).setText(AdMost.getInstance().getAppId());
        ((TextView) findViewById(C0164R.C0166id.availablenetworks)).setText(this.AdNetworkString);
        if (this.AdNetworkString.contains(AdMostAdNetwork.APPLOVIN)) {
            keyControl();
        }
        ((Button) findViewById(C0164R.C0166id.button_info)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdMostTestSuiteActivity.this.getLayout();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setLayout() {
        this.inflater = (LayoutInflater) getSystemService("layout_inflater");
        this.adapterZone = new Adapter(new AdapterListener() {
            public View onListGetView(int i, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = AdMostTestSuiteActivity.this.inflater.inflate(C0164R.layout.admost_test_row_zone, (ViewGroup) null);
                    view.setTag(new HolderZone(view));
                }
                ((HolderZone) view.getTag()).set((AdMostBannerResponseBase) AdMostTestSuiteActivity.this.adapterZone.getItem(i));
                return view;
            }
        });
        this.adapterPlacement = new Adapter(new AdapterListener() {
            public View onListGetView(int i, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = AdMostTestSuiteActivity.this.inflater.inflate(C0164R.layout.admost_test_row_placement, (ViewGroup) null);
                    view.setTag(new HolderPlacement(view));
                }
                ((HolderPlacement) view.getTag()).set((AdMostBannerResponseItem) AdMostTestSuiteActivity.this.adapterPlacement.getItem(i));
                return view;
            }
        });
        this.textViewError = (TextView) findViewById(C0164R.C0166id.textViewError);
        Spinner spinner = (Spinner) findViewById(C0164R.C0166id.spinnerZone);
        this.spinnerZone = spinner;
        spinner.setAdapter(this.adapterZone);
        Spinner spinner2 = (Spinner) findViewById(C0164R.C0166id.spinnerPlacement);
        this.spinnerPlacement = spinner2;
        spinner2.setAdapter(this.adapterPlacement);
        Button button = (Button) findViewById(C0164R.C0166id.loadButton);
        this.loadButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdMostTestSuiteActivity.this.load();
            }
        });
        this.showButton = (Button) findViewById(C0164R.C0166id.showButton);
        Collections.addAll(this.networks, AdMostAdNetwork.getAvailableAdNetworks());
        Iterator<String> it = this.zoneArray.iterator();
        while (it.hasNext()) {
            final String next = it.next();
            if (next != null && next.length() > 0) {
                new AdMostGenericRequest(AdMostGenericRequest.RequestType.ZONE_RESPONSE, next, new AdmostResponseListener<AdMostBannerResponseBase>() {
                    public void onError(String str, Exception exc) {
                        AdMostLog.m304w(AdMostTestSuiteActivity.class.getSimpleName() + " : " + str, exc);
                        AdMostTestSuiteActivity.access$408(AdMostTestSuiteActivity.this);
                        AdMostTestSuiteActivity.this.zoneResponseCompleted();
                    }

                    public void onResponse(AdMostBannerResponseBase adMostBannerResponseBase) {
                        AdMostTestSuiteActivity.access$408(AdMostTestSuiteActivity.this);
                        if (AdMostTestSuiteActivity.this.zoneResponseMap == null) {
                            AdMostTestSuiteActivity.this.zoneResponseCompleted();
                            return;
                        }
                        synchronized (AdMostTestSuiteActivity.this.zoneResponseMap) {
                            if (adMostBannerResponseBase != null) {
                                if (adMostBannerResponseBase.NetworkList != null) {
                                    try {
                                        AdMostTestSuiteActivity.this.zoneResponseMap.put(next, adMostBannerResponseBase);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    AdMostTestSuiteActivity.this.zoneResponseCompleted();
                                    return;
                                }
                            }
                            AdMostLog.m303w(AdMostTestSuiteActivity.class.getSimpleName() + " : No placement found");
                            AdMostTestSuiteActivity.this.zoneResponseCompleted();
                        }
                    }
                }).mo611go("test");
            }
        }
        ((Button) findViewById(C0164R.C0166id.button_info)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdMostTestSuiteActivity.this.setInfoLayout();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setPlacements() {
        AdMostBannerResponseBase adMostBannerResponseBase = (AdMostBannerResponseBase) this.adapterZone.getItem(this.spinnerZone.getSelectedItemPosition());
        AdMostBannerResponseItem adMostBannerResponseItem = new AdMostBannerResponseItem(new JSONObject());
        adMostBannerResponseItem.Network = "WATERFALL TEST";
        adMostBannerResponseItem.Type = "";
        adMostBannerResponseItem.AdSpaceId = "";
        this.adapterPlacement.clear();
        this.adapterPlacement.addItem(adMostBannerResponseItem);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(adMostBannerResponseBase.NetworkList);
        arrayList.addAll(adMostBannerResponseBase.NetworkListInHouse);
        ArrayList<AdMostBannerResponseItem> arrayList2 = adMostBannerResponseBase.BiddingItems;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        Collections.sort(arrayList, new Comparator<AdMostBannerResponseItem>() {
            public int compare(AdMostBannerResponseItem adMostBannerResponseItem, AdMostBannerResponseItem adMostBannerResponseItem2) {
                int compare = String.CASE_INSENSITIVE_ORDER.compare(adMostBannerResponseItem.Network, adMostBannerResponseItem2.Network);
                return compare == 0 ? adMostBannerResponseItem.Network.compareTo(adMostBannerResponseItem2.Network) : compare;
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.adapterPlacement.addItem((AdMostBannerResponseItem) it.next());
        }
    }

    private void setZone() {
        if (this.zoneResponseMap.size() < 1) {
            AdMostLog.m303w(AdMostTestSuiteActivity.class.getSimpleName() + " : No zone found");
            return;
        }
        Iterator<String> it = this.zoneArray.iterator();
        while (it.hasNext()) {
            HashMap<String, AdMostBannerResponseBase> hashMap = this.zoneResponseMap;
            this.adapterZone.addItem(hashMap.get(it.next()));
        }
        this.spinnerZone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (AdMostTestSuiteActivity.this.lastSelectedZonePos != i) {
                    AdMostTestSuiteActivity.this.setPlacements();
                    if (AdMostTestSuiteActivity.this.showButton.isEnabled()) {
                        AdMostTestSuiteActivity.this.loadButton.setEnabled(true);
                        AdMostTestSuiteActivity.this.showButton.setEnabled(false);
                        try {
                            String str = ((AdMostBannerResponseBase) AdMostTestSuiteActivity.this.spinnerZone.getSelectedItem()).ZoneType;
                            if (AdMostTestSuiteActivity.this.interstitialAd != null && str.equals(AdMostZoneType.FULLSCREEN)) {
                                AdMostTestSuiteActivity.this.interstitialAd.destroy();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                int unused = AdMostTestSuiteActivity.this.lastSelectedZonePos = i;
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinnerPlacement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (AdMostTestSuiteActivity.this.lastSelectedPlacementPos != i && AdMostTestSuiteActivity.this.showButton.isEnabled()) {
                    AdMostTestSuiteActivity.this.loadButton.setEnabled(true);
                    AdMostTestSuiteActivity.this.showButton.setEnabled(false);
                    try {
                        String str = ((AdMostBannerResponseBase) AdMostTestSuiteActivity.this.spinnerZone.getSelectedItem()).ZoneType;
                        if (AdMostTestSuiteActivity.this.interstitialAd != null && str.equals(AdMostZoneType.FULLSCREEN)) {
                            AdMostTestSuiteActivity.this.interstitialAd.destroy();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int unused = AdMostTestSuiteActivity.this.lastSelectedPlacementPos = i;
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void zoneResponseCompleted() {
        ArrayList<String> arrayList = this.zoneArray;
        if (arrayList != null && this.responseCount >= arrayList.size()) {
            setZone();
        }
    }

    public void getLayout() {
        setContentView(C0164R.layout.admost_test_view);
        Spinner spinner = (Spinner) findViewById(C0164R.C0166id.spinnerZone);
        this.spinnerZone = spinner;
        spinner.setAdapter(this.adapterZone);
        Spinner spinner2 = (Spinner) findViewById(C0164R.C0166id.spinnerPlacement);
        this.spinnerPlacement = spinner2;
        spinner2.setAdapter(this.adapterPlacement);
        Button button = (Button) findViewById(C0164R.C0166id.loadButton);
        this.loadButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdMostTestSuiteActivity.this.load();
            }
        });
        this.showButton = (Button) findViewById(C0164R.C0166id.showButton);
        ((Button) findViewById(C0164R.C0166id.button_info)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdMostTestSuiteActivity.this.setInfoLayout();
            }
        });
        this.AdNetworkString = "";
        this.textViewError = (TextView) findViewById(C0164R.C0166id.textViewError);
    }

    public void getZonesFromAPI() {
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.GET_ZONES, "", new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                AdMostLog.m303w(AdMostTestSuiteActivity.class.getSimpleName() + " : Zone request error");
                AdMostTestSuiteActivity.this.finish();
            }

            public void onResponse(JSONObject jSONObject) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("Zones");
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        onError("", (Exception) null);
                        return;
                    }
                    ArrayList unused = AdMostTestSuiteActivity.this.zoneArray = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        AdMostTestSuiteActivity.this.zoneArray.add(jSONArray.getString(i));
                    }
                    AdMostTestSuiteActivity.this.setLayout();
                } catch (Exception unused2) {
                    onError("", (Exception) null);
                }
            }
        }).mo611go("");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0164R.layout.admost_test_view);
        getWindow().setBackgroundDrawableResource(17170445);
        if (!AdMost.getInstance().isInitCompleted() || !AdMostLog.isEnabled()) {
            finish();
            return;
        }
        String[] stringArrayExtra = getIntent().getStringArrayExtra("ZONE");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            getZonesFromAPI();
            return;
        }
        for (int i = 0; i < stringArrayExtra.length; i++) {
            if (stringArrayExtra[i] != null && stringArrayExtra[i].length() > 10) {
                this.zoneArray.add(stringArrayExtra[i]);
            }
        }
        setLayout();
    }

    public void onDestroy() {
        AdMostInterstitial adMostInterstitial = this.interstitialAd;
        if (adMostInterstitial != null) {
            adMostInterstitial.destroy();
        }
        AdMostView adMostView = this.bannerAd;
        if (adMostView != null) {
            adMostView.destroy();
        }
        this.networks = null;
        this.zoneResponseMap = null;
        Spinner spinner = this.spinnerZone;
        if (spinner != null) {
            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        }
        Spinner spinner2 = this.spinnerPlacement;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        }
        this.spinnerZone = null;
        this.spinnerPlacement = null;
        this.loadButton = null;
        this.showButton = null;
        this.adapterZone = null;
        this.adapterPlacement = null;
        this.textViewError = null;
        this.inflater = null;
        this.interstitialAd = null;
        this.bannerAd = null;
        this.zoneArray = null;
        super.onDestroy();
    }
}
