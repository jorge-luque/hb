package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;

public class Cocos2dxTypefaces {
    private static final HashMap<String, Typeface> sTypefaceCache = new HashMap<>();

    public static synchronized Typeface get(Context context, String str) {
        Typeface typeface;
        Typeface typeface2;
        synchronized (Cocos2dxTypefaces.class) {
            if (!sTypefaceCache.containsKey(str)) {
                if (str.startsWith("/")) {
                    typeface2 = Typeface.createFromFile(str);
                } else {
                    typeface2 = Typeface.createFromAsset(context.getAssets(), str);
                }
                sTypefaceCache.put(str, typeface2);
            }
            typeface = sTypefaceCache.get(str);
        }
        return typeface;
    }
}
