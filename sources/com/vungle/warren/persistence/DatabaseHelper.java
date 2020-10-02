package com.vungle.warren.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "vungle_db";
    private final DatabaseFactory databaseFactory;

    public static class DBException extends Exception {
        public DBException(String str) {
            super(str);
        }
    }

    public interface DatabaseFactory {
        void create(SQLiteDatabase sQLiteDatabase);

        void deleteData(SQLiteDatabase sQLiteDatabase);

        void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    public DatabaseHelper(Context context, int i, DatabaseFactory databaseFactory2) {
        super(context.getApplicationContext(), DB_NAME, (SQLiteDatabase.CursorFactory) null, i);
        this.databaseFactory = databaseFactory2;
    }

    private synchronized SQLiteDatabase loadWritableDB() {
        return getWritableDatabase();
    }

    public void delete(Query query) throws DBException {
        try {
            loadWritableDB().delete(query.tableName, query.selection, query.args);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public synchronized void dropDb() {
        this.databaseFactory.deleteData(loadWritableDB());
        close();
        onCreate(loadWritableDB());
    }

    public void execSQL(String str) throws DBException {
        try {
            loadWritableDB().execSQL(str);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public void init() {
        loadWritableDB();
    }

    public long insertWithConflict(String str, ContentValues contentValues, int i) throws DBException {
        try {
            return loadWritableDB().insertWithOnConflict(str, (String) null, contentValues, i);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.databaseFactory.create(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.databaseFactory.onDowngrade(sQLiteDatabase, i, i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.databaseFactory.onUpgrade(sQLiteDatabase, i, i2);
    }

    public Cursor query(Query query) {
        return loadWritableDB().query(query.tableName, query.columns, query.selection, query.args, query.groupBy, query.having, query.orderBy, query.limit);
    }

    public Cursor queryRaw(String str, String[] strArr) {
        return loadWritableDB().rawQuery(str, strArr);
    }

    public long update(Query query, ContentValues contentValues) throws DBException {
        try {
            return (long) loadWritableDB().update(query.tableName, contentValues, query.selection, query.args);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
}
