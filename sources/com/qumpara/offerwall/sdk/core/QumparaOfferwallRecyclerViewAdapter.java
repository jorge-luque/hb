package com.qumpara.offerwall.sdk.core;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qumpara.lib_qumpara_ads.R$drawable;
import com.qumpara.lib_qumpara_ads.R$id;
import com.qumpara.lib_qumpara_ads.R$layout;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.qumpara.offerwall.sdk.img.FastImageView;
import java.util.ArrayList;

public class QumparaOfferwallRecyclerViewAdapter extends RecyclerView.C1043g<ViewHolder> {
    /* access modifiers changed from: private */
    public ItemClickListener mClickListener;
    private final Context mContext;
    private ViewHolder mHolder;
    private final LayoutInflater mInflater;
    private final ArrayList<QumparaOfferwallModels.OfferwallItem> mItemList;
    private int mMarginTopBottom;
    private QumparaOfferwallModels.MetaData mMetaData;
    private int mSpanCount;

    public interface ItemClickListener {
        void onItemClick(View view, int i);
    }

    public class ViewHolder extends RecyclerView.C1039c0 implements View.OnClickListener {
        ViewGroup itemAssetLayout;
        TextView itemConditionText;
        FastImageView itemImage;
        FastImageView itemPrizeImage;
        TextView itemPrizeValue;

        ViewHolder(View view) {
            super(view);
            this.itemPrizeValue = (TextView) view.findViewById(R$id.item_prize_value);
            this.itemImage = (FastImageView) view.findViewById(R$id.item_image);
            this.itemPrizeImage = (FastImageView) view.findViewById(R$id.item_prize_image);
            this.itemConditionText = (TextView) view.findViewById(R$id.item_title);
            this.itemAssetLayout = (ViewGroup) view.findViewById(R$id.item_asset_layout);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (QumparaOfferwallRecyclerViewAdapter.this.mClickListener != null) {
                QumparaOfferwallRecyclerViewAdapter.this.mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    QumparaOfferwallRecyclerViewAdapter(Context context, ArrayList<QumparaOfferwallModels.OfferwallItem> arrayList, QumparaOfferwallModels.MetaData metaData, int i, int i2) {
        this.mItemList = arrayList;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMetaData = metaData;
        this.mSpanCount = i;
        this.mMarginTopBottom = i2;
    }

    /* access modifiers changed from: package-private */
    public QumparaOfferwallModels.OfferwallItem getItem(int i) {
        return this.mItemList.get(i);
    }

    public int getItemCount() {
        return this.mItemList.size();
    }

    /* access modifiers changed from: package-private */
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        QumparaOfferwallModels.OfferwallItem offerwallItem = this.mItemList.get(i);
        if (offerwallItem != null && offerwallItem.getPrize() != null) {
            viewHolder.itemImage.setMinimumHeight(QumparaOfferwallUtil.getMinRwImageHeight(this.mContext, this.mSpanCount, this.mMarginTopBottom));
            viewHolder.itemPrizeValue.setText(offerwallItem.getPrize().getAsset().getValueAsFormatted());
            viewHolder.itemConditionText.setText(offerwallItem.getConditionText());
            QumparaOfferwallModels.MetaData metaData = this.mMetaData;
            if (!(metaData == null || metaData.getButton() == null || QumparaOfferwallUtil.isNullOrEmpty(this.mMetaData.getButton().getForeground()))) {
                try {
                    viewHolder.itemPrizeValue.setTextColor(Color.parseColor(this.mMetaData.getButton().getForeground()));
                } catch (Exception unused) {
                }
            }
            viewHolder.itemImage.setImageUrl(offerwallItem.getImage(), Integer.valueOf(R$drawable.uncomplete_img));
            viewHolder.itemPrizeImage.setImageUrl(offerwallItem.getPrize().getImage());
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.mInflater.inflate(R$layout.qumpara_offerwall_rv_item, viewGroup, false));
    }
}
