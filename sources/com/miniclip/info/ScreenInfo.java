package com.miniclip.info;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import com.miniclip.framework.Miniclip;

public class ScreenInfo {
    private static void getMetricsOfDisplay(Point point) {
        DisplayMetrics displayMetrics = Miniclip.getActivity().getResources().getDisplayMetrics();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
    }

    @TargetApi(17)
    private static void getRealSizeOfDisplay(Point point) {
        Miniclip.getActivity().getWindowManager().getDefaultDisplay().getRealSize(point);
    }

    private static void getScreenSize(Point point) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            getRealSizeOfDisplay(point);
        } else if (i >= 13) {
            getSizeOfDisplay(point);
        } else {
            getMetricsOfDisplay(point);
        }
    }

    @TargetApi(13)
    private static void getSizeOfDisplay(Point point) {
        Miniclip.getActivity().getWindowManager().getDefaultDisplay().getSize(point);
    }

    public static float pixelsPerInch() {
        return Miniclip.getActivity().getResources().getDisplayMetrics().ydpi;
    }

    public static float screenHeight() {
        Point point = new Point();
        getScreenSize(point);
        return (float) point.y;
    }

    public static float screenWidth() {
        Point point = new Point();
        getScreenSize(point);
        return (float) point.x;
    }

    public static float windowHeight() {
        return (float) Miniclip.getActivity().findViewById(16908290).getHeight();
    }

    public static float windowWidth() {
        return (float) Miniclip.getActivity().findViewById(16908290).getWidth();
    }
}
