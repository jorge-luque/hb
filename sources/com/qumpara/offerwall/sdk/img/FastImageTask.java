package com.qumpara.offerwall.sdk.img;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

public class FastImageTask implements Runnable {
    private static final int BITMAP_READY = 0;
    private boolean cancelled = false;
    private Context context;
    private FastImage image;
    private OnCompleteHandler onCompleteHandler;

    public static class OnCompleteHandler extends Handler {
        public void handleMessage(Message message) {
            onComplete((Bitmap) message.obj);
        }

        public void onComplete(Bitmap bitmap) {
        }
    }

    public static abstract class OnCompleteListener {
        public abstract void onComplete();

        public void onComplete(Bitmap bitmap) {
            onComplete();
        }
    }

    public FastImageTask(Context context2, FastImage fastImage) {
        this.image = fastImage;
        this.context = context2;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void complete(Bitmap bitmap) {
        OnCompleteHandler onCompleteHandler2 = this.onCompleteHandler;
        if (onCompleteHandler2 != null && !this.cancelled) {
            onCompleteHandler2.sendMessage(onCompleteHandler2.obtainMessage(0, bitmap));
        }
    }

    public void run() {
        FastImage fastImage = this.image;
        if (fastImage != null) {
            complete(fastImage.getBitmap(this.context));
            this.context = null;
        }
    }

    public void setOnCompleteHandler(OnCompleteHandler onCompleteHandler2) {
        this.onCompleteHandler = onCompleteHandler2;
    }
}
