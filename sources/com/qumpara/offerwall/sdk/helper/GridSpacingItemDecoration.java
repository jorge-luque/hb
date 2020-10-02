package com.qumpara.offerwall.sdk.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.C1053n {
    private int headerNum;
    private boolean includeEdge;
    private int spacingLeftRight;
    private int spacingTopBottom;
    private int spanCount;

    public GridSpacingItemDecoration(int i, int i2, int i3, boolean z, int i4) {
        this.spanCount = i;
        this.spacingTopBottom = i2;
        this.spacingLeftRight = i3;
        this.includeEdge = z;
        this.headerNum = i4;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C1070z zVar) {
        int e = recyclerView.mo5311e(view) - this.headerNum;
        if (e >= 0) {
            int i = this.spanCount;
            int i2 = e % i;
            if (this.includeEdge) {
                int i3 = this.spacingLeftRight;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (e < i) {
                    rect.top = this.spacingTopBottom;
                }
                rect.bottom = this.spacingTopBottom;
                return;
            }
            int i4 = this.spacingLeftRight;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (e >= i) {
                rect.top = this.spacingTopBottom;
                return;
            }
            return;
        }
        rect.left = 0;
        rect.right = 0;
        rect.top = 0;
        rect.bottom = 0;
    }
}
