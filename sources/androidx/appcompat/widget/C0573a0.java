package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import p075d.p081c.p082a.C3207b;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.a0 */
/* compiled from: SuggestionsAdapter */
class C0573a0 extends C3207b implements View.OnClickListener {
    /* renamed from: a */
    public static String m1505a(Cursor cursor, String str) {
        return m1504a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private static String m1504a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }
}
