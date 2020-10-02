package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface Leaderboard extends Freezable<Leaderboard> {
    public static final int SCORE_ORDER_LARGER_IS_BETTER = 1;
    public static final int SCORE_ORDER_SMALLER_IS_BETTER = 0;

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    Game getGame();

    Uri getIconImageUri();

    @KeepName
    @Deprecated
    String getIconImageUrl();

    String getLeaderboardId();

    int getScoreOrder();

    ArrayList<LeaderboardVariant> getVariants();
}
