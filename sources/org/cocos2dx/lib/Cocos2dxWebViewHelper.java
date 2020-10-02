package org.cocos2dx.lib;

import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.FrameLayout;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cocos2dxWebViewHelper {
    private static final String TAG = "Cocos2dxWebViewHelper";
    /* access modifiers changed from: private */
    public static Cocos2dxActivity sCocos2dxActivity;
    private static Handler sHandler;
    /* access modifiers changed from: private */
    public static FrameLayout sLayout;
    private static int viewTag;
    /* access modifiers changed from: private */
    public static SparseArray<Cocos2dxWebView> webViews;

    public Cocos2dxWebViewHelper(FrameLayout frameLayout) {
        sLayout = frameLayout;
        sHandler = new Handler(Looper.myLooper());
        sCocos2dxActivity = (Cocos2dxActivity) Cocos2dxActivity.getContext();
        webViews = new SparseArray<>();
    }

    public static void _didFailLoading(int i, String str) {
        didFailLoading(i, str);
    }

    public static void _didFinishLoading(int i, String str) {
        didFinishLoading(i, str);
    }

    public static void _onJsCallback(int i, String str) {
        onJsCallback(i, str);
    }

    public static boolean _shouldStartLoading(int i, String str) {
        return !shouldStartLoading(i, str);
    }

    public static <T> T callInMainThread(Callable<T> callable) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(callable);
        sHandler.post(futureTask);
        return futureTask.get();
    }

    public static boolean canGoBack(final int i) {
        try {
            return ((Boolean) callInMainThread(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                    return Boolean.valueOf(cocos2dxWebView != null && cocos2dxWebView.canGoBack());
                }
            })).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            return false;
        }
    }

    public static boolean canGoForward(final int i) {
        try {
            return ((Boolean) callInMainThread(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                    return Boolean.valueOf(cocos2dxWebView != null && cocos2dxWebView.canGoForward());
                }
            })).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            return false;
        }
    }

    public static int createWebView() {
        final int i = viewTag;
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = new Cocos2dxWebView(Cocos2dxWebViewHelper.sCocos2dxActivity, i);
                Cocos2dxWebViewHelper.sLayout.addView(cocos2dxWebView, new FrameLayout.LayoutParams(-2, -2));
                Cocos2dxWebViewHelper.webViews.put(i, cocos2dxWebView);
            }
        });
        int i2 = viewTag;
        viewTag = i2 + 1;
        return i2;
    }

    private static native void didFailLoading(int i, String str);

    private static native void didFinishLoading(int i, String str);

    public static void evaluateJS(final int i, final String str) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.loadUrl("javascript:" + str);
                }
            }
        });
    }

    public static float getOpacityWebView(final int i) {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1.0f;
        }
        FutureTask futureTask = new FutureTask(new Callable<Float>() {
            public Float call() throws Exception {
                Object obj;
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    try {
                        obj = cocos2dxWebView.getClass().getMethod("getAlpha", new Class[0]).invoke(cocos2dxWebView, new Object[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return (Float) obj;
                }
                obj = null;
                return (Float) obj;
            }
        });
        sCocos2dxActivity.runOnUiThread(futureTask);
        try {
            return ((Float) futureTask.get()).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 1.0f;
        }
    }

    public static void goBack(final int i) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.goBack();
                }
            }
        });
    }

    public static void goForward(final int i) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.goForward();
                }
            }
        });
    }

    public static void loadData(int i, String str, String str2, String str3, String str4) {
        final int i2 = i;
        final String str5 = str4;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i2);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.loadDataWithBaseURL(str5, str6, str7, str8, (String) null);
                }
            }
        });
    }

    public static void loadFile(final int i, final String str) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.loadUrl(str);
                }
            }
        });
    }

    public static void loadHTMLString(final int i, final String str, final String str2) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.loadDataWithBaseURL(str2, str, (String) null, (String) null, (String) null);
                }
            }
        });
    }

    public static void loadUrl(final int i, final String str, final boolean z) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.getSettings().setCacheMode(z ? 2 : -1);
                    cocos2dxWebView.loadUrl(str);
                }
            }
        });
    }

    private static native void onJsCallback(int i, String str);

    public static void reload(final int i) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.reload();
                }
            }
        });
    }

    public static void removeWebView(final int i) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    Cocos2dxWebViewHelper.webViews.remove(i);
                    Cocos2dxWebViewHelper.sLayout.removeView(cocos2dxWebView);
                }
            }
        });
    }

    public static void setBackgroundTransparent(final int i) {
        if (Build.VERSION.SDK_INT > 10) {
            sCocos2dxActivity.runOnUiThread(new Runnable() {
                public void run() {
                    Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                    if (cocos2dxWebView != null) {
                        cocos2dxWebView.setBackgroundColor(0);
                        try {
                            cocos2dxWebView.getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(cocos2dxWebView, new Object[]{1, null});
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void setJavascriptInterfaceScheme(final int i, final String str) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.setJavascriptInterfaceScheme(str);
                }
            }
        });
    }

    public static void setOpacityWebView(final int i, final float f) {
        if (Build.VERSION.SDK_INT > 10) {
            sCocos2dxActivity.runOnUiThread(new Runnable() {
                public void run() {
                    Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                    if (cocos2dxWebView != null) {
                        try {
                            cocos2dxWebView.getClass().getMethod("setAlpha", new Class[]{Float.TYPE}).invoke(cocos2dxWebView, new Object[]{Float.valueOf(f)});
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void setScalesPageToFit(final int i, final boolean z) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.setScalesPageToFit(z);
                }
            }
        });
    }

    public static void setVisible(final int i, final boolean z) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.setVisibility(z ? 0 : 8);
                }
            }
        });
    }

    public static void setWebViewRect(int i, int i2, int i3, int i4, int i5) {
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final int i9 = i4;
        final int i10 = i5;
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i6);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.setWebViewRect(i7, i8, i9, i10);
                }
            }
        });
    }

    private static native boolean shouldStartLoading(int i, String str);

    public static void stopLoading(final int i) {
        sCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(i);
                if (cocos2dxWebView != null) {
                    cocos2dxWebView.stopLoading();
                }
            }
        });
    }
}
