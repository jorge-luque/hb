package admost.sdk.base;

import admost.sdk.model.AdMostBannerResponseItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class AdmostDebugLogAdapter extends BaseAdapter {
    static final int HEADER = 1;
    static final int ROW = 0;
    ArrayList<Object> bannerResponseItemList;
    StringBuilder builder = new StringBuilder();

    /* renamed from: c */
    Context f252c;
    LayoutInflater inflater;

    public static class ViewHolder {
        public TextView FPValue;
        public TextView PureWeight;
        public TextView Weight;
        public TextView bannerName;
        public TextView details;
        public LinearLayout ecpmLay;
        public TextView isCached;
        public TextView isFilled;
        public TextView isShown;
        public TextView networkName;
        public TextView priorityLevel;
    }

    public AdmostDebugLogAdapter(Context context, ArrayList<Object> arrayList) {
        this.f252c = context;
        this.bannerResponseItemList = arrayList;
    }

    private static String getFormattedString(int i, int i2) {
        String valueOf = String.valueOf(i);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2 - valueOf.length(); i3++) {
            sb.append(" ");
        }
        sb.append(valueOf);
        return sb.toString();
    }

    public int getCount() {
        return this.bannerResponseItemList.size();
    }

    public Object getItem(int i) {
        return this.bannerResponseItemList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return getItem(i) instanceof AdMostBannerResponseItem ? 0 : 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: admost.sdk.base.AdmostDebugLogAdapter$ViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r18, android.view.View r19, android.view.ViewGroup r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            int r2 = r17.getItemViewType(r18)
            r3 = 1
            r4 = 0
            if (r19 != 0) goto L_0x00a4
            admost.sdk.base.AdmostDebugLogAdapter$ViewHolder r5 = new admost.sdk.base.AdmostDebugLogAdapter$ViewHolder
            r5.<init>()
            android.content.Context r6 = r0.f252c
            java.lang.String r7 = "layout_inflater"
            java.lang.Object r6 = r6.getSystemService(r7)
            android.view.LayoutInflater r6 = (android.view.LayoutInflater) r6
            r0.inflater = r6
            if (r2 == 0) goto L_0x0036
            if (r2 == r3) goto L_0x0025
            r1 = r19
            goto L_0x00a0
        L_0x0025:
            int r7 = admost.sdk.C0164R.layout.admost_debug_list_header
            android.view.View r1 = r6.inflate(r7, r1, r4)
            int r6 = admost.sdk.C0164R.C0166id.priorityLevel
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.priorityLevel = r6
            goto L_0x00a0
        L_0x0036:
            int r7 = admost.sdk.C0164R.layout.admost_debug_list_row
            android.view.View r1 = r6.inflate(r7, r1, r4)
            int r6 = admost.sdk.C0164R.C0166id.bannerName
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.bannerName = r6
            int r6 = admost.sdk.C0164R.C0166id.details
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.details = r6
            int r6 = admost.sdk.C0164R.C0166id.FPValue
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.FPValue = r6
            int r6 = admost.sdk.C0164R.C0166id.PureWeight
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.PureWeight = r6
            int r6 = admost.sdk.C0164R.C0166id.Weight
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.Weight = r6
            int r6 = admost.sdk.C0164R.C0166id.isCached
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.isCached = r6
            int r6 = admost.sdk.C0164R.C0166id.isShown
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.isShown = r6
            int r6 = admost.sdk.C0164R.C0166id.isFilled
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.isFilled = r6
            int r6 = admost.sdk.C0164R.C0166id.networkName
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.networkName = r6
            int r6 = admost.sdk.C0164R.C0166id.ecpmLay
            android.view.View r6 = r1.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r5.ecpmLay = r6
        L_0x00a0:
            r1.setTag(r5)
            goto L_0x00ad
        L_0x00a4:
            java.lang.Object r1 = r19.getTag()
            r5 = r1
            admost.sdk.base.AdmostDebugLogAdapter$ViewHolder r5 = (admost.sdk.base.AdmostDebugLogAdapter.ViewHolder) r5
            r1 = r19
        L_0x00ad:
            if (r2 == 0) goto L_0x00c6
            if (r2 == r3) goto L_0x00b3
            goto L_0x02d1
        L_0x00b3:
            java.lang.Object r2 = r17.getItem(r18)
            java.lang.String r2 = (java.lang.String) r2
            int r3 = admost.sdk.C0164R.C0166id.priorityLevel
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setText(r2)
            goto L_0x02d1
        L_0x00c6:
            java.lang.Object r2 = r17.getItem(r18)
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2
            android.widget.TextView r6 = r5.networkName
            android.widget.TextView r7 = r5.bannerName
            android.widget.TextView r8 = r5.isFilled
            android.widget.TextView r9 = r5.isCached
            android.widget.TextView r10 = r5.isShown
            android.widget.TextView r11 = r5.PureWeight
            android.widget.TextView r12 = r5.FPValue
            android.widget.TextView r13 = r5.Weight
            android.widget.TextView r14 = r5.details
            android.widget.LinearLayout r5 = r5.ecpmLay
            android.graphics.drawable.Drawable r15 = r9.getBackground()
            java.lang.String r16 = "#8e44ad"
            int r3 = android.graphics.Color.parseColor(r16)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            r15.setColorFilter(r3, r4)
            android.graphics.drawable.Drawable r3 = r10.getBackground()
            java.lang.String r4 = "#f1c40f"
            int r4 = android.graphics.Color.parseColor(r4)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.SRC_IN
            r3.setColorFilter(r4, r15)
            r3 = 8
            r10.setVisibility(r3)
            r9.setVisibility(r3)
            r8.setVisibility(r3)
            admost.sdk.model.AdMostWaterfallLog r4 = r2.WaterFallLogItem
            boolean r15 = r4.isTried
            if (r15 == 0) goto L_0x016c
            boolean r4 = r4.isFilled
            if (r4 == 0) goto L_0x013e
            java.lang.String r4 = "F"
            r8.setText(r4)
            android.graphics.drawable.Drawable r4 = r8.getBackground()
            java.lang.String r15 = "#27ae60"
            int r15 = android.graphics.Color.parseColor(r15)
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_IN
            r4.setColorFilter(r15, r3)
            r3 = 0
            r8.setVisibility(r3)
            admost.sdk.model.AdMostWaterfallLog r4 = r2.WaterFallLogItem
            boolean r4 = r4.isCached
            if (r4 == 0) goto L_0x0135
            r9.setVisibility(r3)
            goto L_0x013a
        L_0x0135:
            r3 = 8
            r9.setVisibility(r3)
        L_0x013a:
            r3 = 8
            r4 = 0
            goto L_0x0173
        L_0x013e:
            java.lang.String r3 = "N"
            r8.setText(r3)
            android.graphics.drawable.Drawable r3 = r8.getBackground()
            java.lang.String r4 = "#e74c3c"
            int r4 = android.graphics.Color.parseColor(r4)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.SRC_IN
            r3.setColorFilter(r4, r15)
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isCached
            if (r3 == 0) goto L_0x0162
            r3 = 8
            r8.setVisibility(r3)
            r4 = 0
            r9.setVisibility(r4)
            goto L_0x0173
        L_0x0162:
            r3 = 8
            r4 = 0
            r8.setVisibility(r4)
            r9.setVisibility(r3)
            goto L_0x0173
        L_0x016c:
            r4 = 0
            r8.setVisibility(r3)
            r9.setVisibility(r3)
        L_0x0173:
            admost.sdk.model.AdMostWaterfallLog r8 = r2.WaterFallLogItem
            boolean r8 = r8.isShown
            if (r8 == 0) goto L_0x017d
            r10.setVisibility(r4)
            goto L_0x0180
        L_0x017d:
            r10.setVisibility(r3)
        L_0x0180:
            java.lang.String r3 = r2.Network
            r6.setText(r3)
            java.lang.String r3 = r2.PlacementName
            r7.setText(r3)
            int r3 = r2.FPValue
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r12.setText(r3)
            int r3 = r2.PureWeight
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r11.setText(r3)
            int r3 = r2.Weight
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r13.setText(r3)
            java.lang.StringBuilder r3 = r0.builder
            r4 = 0
            r3.setLength(r4)
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isRandomItem
            if (r3 == 0) goto L_0x01b8
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r4 = "/RND * "
            r3.append(r4)
        L_0x01b8:
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isReplacedForRandomSelectedOtherOne
            if (r3 == 0) goto L_0x01c5
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r4 = "/RND REPLACED * "
            r3.append(r4)
        L_0x01c5:
            java.lang.String r3 = r2.FPEnabledItem
            java.lang.String r4 = "1"
            if (r3 == 0) goto L_0x01d8
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01d8
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r6 = "/FP * "
            r3.append(r6)
        L_0x01d8:
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isDefaultForFP
            java.lang.String r6 = " * "
            if (r3 == 0) goto L_0x01f5
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r7 = "/FPD - "
            r3.append(r7)
            java.lang.StringBuilder r3 = r0.builder
            admost.sdk.model.AdMostWaterfallLog r7 = r2.WaterFallLogItem
            java.lang.String r7 = r7.defaultFPStatus
            r3.append(r7)
            java.lang.StringBuilder r3 = r0.builder
            r3.append(r6)
        L_0x01f5:
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isDefaultForFPHead
            if (r3 == 0) goto L_0x0202
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r7 = "/FPD - fp_head *"
            r3.append(r7)
        L_0x0202:
            java.lang.String r3 = r2.FPEnabledItem
            if (r3 == 0) goto L_0x022b
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x022b
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r4 = "FP current/total : "
            r3.append(r4)
            admost.sdk.model.AdMostWaterfallLog r4 = r2.WaterFallLogItem
            int r4 = r4.positionInFPList
            r7 = 1
            int r4 = r4 + r7
            r3.append(r4)
            java.lang.String r4 = "/"
            r3.append(r4)
            admost.sdk.model.AdMostWaterfallLog r4 = r2.WaterFallLogItem
            int r4 = r4.numberOfItemInFPList
            r3.append(r4)
            r3.append(r6)
        L_0x022b:
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.addedBecauseOfAlwaysInWaterfall
            if (r3 == 0) goto L_0x0238
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r4 = "/AIW * "
            r3.append(r4)
        L_0x0238:
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.addPlacementsAboveLastECPM
            if (r3 == 0) goto L_0x024f
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r4 = "/ALE - "
            r3.append(r4)
            admost.sdk.model.AdMostWaterfallLog r4 = r2.WaterFallLogItem
            int r4 = r4.addPlacementsAboveLastECPMValue
            r3.append(r4)
            r3.append(r6)
        L_0x024f:
            boolean r3 = r2.IsBiddingItem
            if (r3 == 0) goto L_0x02ab
            r3 = 8
            r5.setVisibility(r3)
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isBidRequested
            if (r3 == 0) goto L_0x0265
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r4 = "/BID-REQ * "
            r3.append(r4)
        L_0x0265:
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isBidFill
            if (r3 == 0) goto L_0x0284
            java.lang.StringBuilder r3 = r0.builder
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            double r6 = r2.BiddingPriceFromNetworkInCent
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            r7 = 0
            r5[r7] = r6
            java.lang.String r6 = "/BID-FILL * : %.2f"
            java.lang.String r4 = java.lang.String.format(r4, r6, r5)
            r3.append(r4)
        L_0x0284:
            admost.sdk.model.AdMostWaterfallLog r3 = r2.WaterFallLogItem
            boolean r3 = r3.isBidTimeout
            if (r3 == 0) goto L_0x0291
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r4 = "/BID-TIMEOUT * "
            r3.append(r4)
        L_0x0291:
            java.lang.StringBuilder r3 = r0.builder
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "/BID-Score : "
            r4.append(r5)
            double r5 = r2.BidScore
            r4.append(r5)
            java.lang.String r2 = r4.toString()
            r3.append(r2)
            r2 = 0
            goto L_0x02af
        L_0x02ab:
            r2 = 0
            r5.setVisibility(r2)
        L_0x02af:
            java.lang.StringBuilder r3 = r0.builder
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = ""
            boolean r5 = r3.equals(r4)
            if (r5 != 0) goto L_0x02c4
            r14.setVisibility(r2)
            r14.setText(r3)
            goto L_0x02cc
        L_0x02c4:
            r3 = 8
            r14.setVisibility(r3)
            r14.setText(r4)
        L_0x02cc:
            java.lang.StringBuilder r3 = r0.builder
            r3.setLength(r2)
        L_0x02d1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdmostDebugLogAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int getViewTypeCount() {
        return 2;
    }
}
