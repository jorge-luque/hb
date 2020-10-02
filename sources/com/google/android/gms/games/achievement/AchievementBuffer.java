package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class AchievementBuffer extends AbstractDataBuffer<Achievement> {
    public AchievementBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Achievement get(int i) {
        return new AchievementRef(this.mDataHolder, i);
    }
}
