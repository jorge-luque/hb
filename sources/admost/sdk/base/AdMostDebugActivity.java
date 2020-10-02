package admost.sdk.base;

import admost.sdk.C0164R;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdMostDebugActivity extends Activity {
    ArrayList<AdMostBannerResponseItem> NETWORK;
    ArrayList<AdMostBannerResponseItem> NETWORK_BIDDING;
    ArrayList<AdMostBannerResponseItem> NETWORK_INHOUSE;
    ArrayList<AdMostBannerResponseItem> NETWORK_NOTINWATERFALL;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0164R.layout.admost_debug_dialog);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setLayout(-1, -2);
        setFinishOnTouchOutside(true);
        this.NETWORK = getIntent().getParcelableArrayListExtra("NETWORK");
        this.NETWORK_INHOUSE = getIntent().getParcelableArrayListExtra("NETWORK_INHOUSE");
        this.NETWORK_NOTINWATERFALL = getIntent().getParcelableArrayListExtra("NETWORK_NOTINWATERFALL");
        ArrayList<AdMostBannerResponseItem> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("NETWORK_BIDDING");
        this.NETWORK_BIDDING = parcelableArrayListExtra;
        if (!(this.NETWORK == null && this.NETWORK_INHOUSE == null && parcelableArrayListExtra == null) && AdMost.getInstance().isInitStarted()) {
            int i = -999;
            ListView listView = (ListView) findViewById(C0164R.C0166id.listView);
            ((TextView) findViewById(C0164R.C0166id.sdkVersion)).setText(AdMost.getInstance().getVersion());
            ((TextView) findViewById(C0164R.C0166id.closeButton)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AdMostDebugActivity.this.finish();
                }
            });
            ArrayList arrayList = new ArrayList();
            String currentExperiment = AdMostExperimentManager.getInstance().getCurrentExperiment();
            String currentGroup = AdMostExperimentManager.getInstance().getCurrentGroup();
            if (currentExperiment != null && currentExperiment.length() > 0 && currentGroup != null && currentGroup.length() > 0) {
                arrayList.add(getString(C0164R.string.AMR_experiment_detail, new Object[]{currentExperiment, currentGroup}));
            }
            ArrayList<AdMostBannerResponseItem> arrayList2 = this.NETWORK_BIDDING;
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add("------- BIDDING LIST -------");
                for (int i2 = 0; i2 < this.NETWORK_BIDDING.size(); i2++) {
                    AdMostBannerResponseItem adMostBannerResponseItem = this.NETWORK_BIDDING.get(i2);
                    if (AdMostAdNetwork.isAdNetworkAvailable(adMostBannerResponseItem.Network)) {
                        arrayList.add(adMostBannerResponseItem);
                    }
                }
            }
            ArrayList<AdMostBannerResponseItem> arrayList3 = this.NETWORK_NOTINWATERFALL;
            if (arrayList3 != null && arrayList3.size() > 0) {
                boolean z = false;
                for (int i3 = 0; i3 < this.NETWORK_NOTINWATERFALL.size(); i3++) {
                    AdMostBannerResponseItem adMostBannerResponseItem2 = this.NETWORK_NOTINWATERFALL.get(i3);
                    if (AdMostAdNetwork.isAdNetworkAvailable(adMostBannerResponseItem2.Network) && adMostBannerResponseItem2.WaterFallLogItem.isTried) {
                        if (!z) {
                            arrayList.add("------- EXTRA ITEMS -------");
                            z = true;
                        }
                        boolean z2 = adMostBannerResponseItem2.IsTestItem && adMostBannerResponseItem2.Priority == 0;
                        int i4 = adMostBannerResponseItem2.Priority;
                        if (i != i4) {
                            if (!z2) {
                                arrayList.add("PRIORITY " + adMostBannerResponseItem2.Priority);
                            } else {
                                arrayList.add("SINGLE ITEM TEST");
                            }
                            i = i4;
                        }
                        arrayList.add(adMostBannerResponseItem2);
                    }
                }
            }
            ArrayList<AdMostBannerResponseItem> arrayList4 = this.NETWORK;
            if (arrayList4 != null && arrayList4.size() > 0) {
                arrayList.add("------- WATERFALL LIST -------");
                for (int i5 = 0; i5 < this.NETWORK.size(); i5++) {
                    AdMostBannerResponseItem adMostBannerResponseItem3 = this.NETWORK.get(i5);
                    if (AdMostAdNetwork.isAdNetworkAvailable(adMostBannerResponseItem3.Network)) {
                        boolean z3 = adMostBannerResponseItem3.IsTestItem && adMostBannerResponseItem3.Priority == 0;
                        int i6 = adMostBannerResponseItem3.Priority;
                        if (i != i6) {
                            if (!z3) {
                                arrayList.add("PRIORITY " + adMostBannerResponseItem3.Priority);
                            } else {
                                arrayList.add("SINGLE ITEM TEST");
                            }
                            i = i6;
                        }
                        arrayList.add(adMostBannerResponseItem3);
                    }
                }
            }
            ArrayList<AdMostBannerResponseItem> arrayList5 = this.NETWORK_INHOUSE;
            if (arrayList5 != null && arrayList5.size() > 0) {
                arrayList.add("------- AFTER SECOND RUN -------");
                for (int i7 = 0; i7 < this.NETWORK_INHOUSE.size(); i7++) {
                    AdMostBannerResponseItem adMostBannerResponseItem4 = this.NETWORK_INHOUSE.get(i7);
                    if (AdMostAdNetwork.isAdNetworkAvailable(adMostBannerResponseItem4.Network)) {
                        boolean z4 = adMostBannerResponseItem4.IsTestItem && adMostBannerResponseItem4.Priority == 0;
                        int i8 = adMostBannerResponseItem4.Priority;
                        if (i != i8) {
                            if (!z4) {
                                arrayList.add("PRIORITY " + adMostBannerResponseItem4.Priority);
                            } else {
                                arrayList.add("SINGLE ITEM TEST");
                            }
                            i = i8;
                        }
                        arrayList.add(adMostBannerResponseItem4);
                    }
                }
            }
            listView.setAdapter(new AdmostDebugLogAdapter(this, arrayList));
            return;
        }
        finish();
    }
}
