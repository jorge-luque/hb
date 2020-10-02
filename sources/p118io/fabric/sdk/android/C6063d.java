package p118io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* renamed from: io.fabric.sdk.android.d */
/* compiled from: FabricContext */
class C6063d extends ContextWrapper {

    /* renamed from: a */
    private final String f15985a;

    /* renamed from: b */
    private final String f15986b;

    public C6063d(Context context, String str, String str2) {
        super(context);
        this.f15986b = str;
        this.f15985a = str2;
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f15985a);
    }

    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.f15985a);
        file.mkdirs();
        return new File(file, str);
    }

    @TargetApi(8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f15985a);
    }

    @TargetApi(8)
    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.f15985a);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f15985a);
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return super.getSharedPreferences(this.f15986b + ":" + str, i);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @TargetApi(11)
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }
}
