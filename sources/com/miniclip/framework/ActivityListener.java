package com.miniclip.framework;

import android.content.Intent;
import android.os.Bundle;

public interface ActivityListener {
    void onActivityResult(int i, int i2, Intent intent);

    void onDestroy();

    void onLowMemory();

    void onNewIntent(Intent intent);

    void onPause();

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onRestart();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void onWindowFocusChanged(boolean z);
}
