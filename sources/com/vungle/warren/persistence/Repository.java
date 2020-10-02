package com.vungle.warren.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.C0769b;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.AdAssetDBAdapter;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.CookieDBAdapter;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.PlacementDBAdapter;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.VisionData;
import com.vungle.warren.model.VisionDataDBAdapter;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.vision.VisionAggregationData;
import com.vungle.warren.vision.VisionAggregationInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class Repository {
    /* access modifiers changed from: private */
    public static final String TAG = "Repository";
    public static int VERSION = 5;
    /* access modifiers changed from: private */
    public Map<Class, DBAdapter> adapters;
    private final Context appCtx;
    private final ExecutorService backgroundExecutor;
    protected DatabaseHelper dbHelper;
    /* access modifiers changed from: private */
    public final Designer designer;
    /* access modifiers changed from: private */
    public final ExecutorService uiExecutor;

    public interface LoadCallback<T> {
        void onLoaded(T t);
    }

    public interface SaveCallback {
        void onError(Exception exc);

        void onSaved();
    }

    private static class VungleDatabaseCreator implements DatabaseHelper.DatabaseFactory {
        private final Context context;

        public VungleDatabaseCreator(Context context2) {
            this.context = context2;
        }

        private void deleteDatabase(String str) {
            this.context.deleteDatabase(str);
        }

        private void dropOldFilesData() {
            deleteDatabase("vungle");
            File externalFilesDir = this.context.getExternalFilesDir((String) null);
            if (((Build.VERSION.SDK_INT >= 19 || C0769b.m2414a(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) && Environment.getExternalStorageState().equals("mounted") && externalFilesDir != null) && externalFilesDir.exists()) {
                try {
                    FileUtility.delete(new File(externalFilesDir, ".vungle"));
                } catch (IOException e) {
                    Log.e(Repository.TAG, "IOException ", e);
                }
            }
            File filesDir = this.context.getFilesDir();
            if (filesDir.exists()) {
                try {
                    FileUtility.delete(new File(filesDir, "vungle"));
                } catch (IOException e2) {
                    Log.e(Repository.TAG, "IOException ", e2);
                }
            }
            try {
                FileUtility.delete(new File(this.context.getCacheDir() + File.separator + "downloads_vungle"));
            } catch (IOException e3) {
                Log.e(Repository.TAG, "IOException ", e3);
            }
        }

        public void create(SQLiteDatabase sQLiteDatabase) {
            dropOldFilesData();
            sQLiteDatabase.execSQL(AdvertisementDBAdapter.CREATE_ADVERTISEMENT_TABLE_QUERY);
            sQLiteDatabase.execSQL(PlacementDBAdapter.CREATE_PLACEMENT_TABLE_QUERY);
            sQLiteDatabase.execSQL(CookieDBAdapter.CREATE_COOKIE_TABLE_QUERY);
            sQLiteDatabase.execSQL(ReportDBAdapter.CREATE_REPORT_TABLE_QUERY);
            sQLiteDatabase.execSQL(AdAssetDBAdapter.CREATE_ASSET_TABLE_QUERY);
            sQLiteDatabase.execSQL(VisionDataDBAdapter.CREATE_VISION_TABLE_QUERY);
        }

        public void deleteData(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS advertisement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cookie");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS placement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS report");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adAsset");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS vision_data");
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table'", (String[]) null);
            while (rawQuery != null && rawQuery.moveToNext()) {
                String string = rawQuery.getString(1);
                if (!string.equals("android_metadata") && !string.startsWith("sqlite_")) {
                    arrayList.add(string);
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            for (String str : arrayList) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            create(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 2) {
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN status INTEGER DEFAULT 1");
            }
            if (i < 3) {
                sQLiteDatabase.execSQL(VisionDataDBAdapter.CREATE_VISION_TABLE_QUERY);
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN tt_download NUMERIC DEFAULT -1");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN refresh_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN supported_template_types NUMERIC DEFAULT 0");
            }
            if (i < 4) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN header_bidding SHORT ");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN header_bidding SHORT ");
            }
            if (i < 5) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN autocache_priority NUMERIC DEFAULT 2147483647");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN ad_request_start_time NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN init_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
            }
        }
    }

    public Repository(Context context, Designer designer2, ExecutorService executorService, ExecutorService executorService2) {
        this(context, designer2, executorService, executorService2, VERSION);
    }

    /* access modifiers changed from: private */
    public void deleteAdInternal(String str) throws DatabaseHelper.DBException {
        if (!TextUtils.isEmpty(str)) {
            deleteAssetForAdId(str);
            deleteModel(Advertisement.class, str);
            try {
                this.designer.deleteAssets(str);
            } catch (IOException e) {
                Log.e(TAG, "IOException ", e);
            }
        }
    }

    private void deleteAssetForAdId(String str) throws DatabaseHelper.DBException {
        Query query = new Query(this.adapters.get(AdAsset.class).tableName());
        query.selection = "ad_identifier=?";
        query.args = new String[]{str};
        this.dbHelper.delete(query);
    }

    /* access modifiers changed from: private */
    public <T> void deleteModel(Class<T> cls, String str) throws DatabaseHelper.DBException {
        Query query = new Query(this.adapters.get(cls).tableName());
        query.selection = "item_id=?";
        query.args = new String[]{str};
        this.dbHelper.delete(query);
    }

    /* access modifiers changed from: private */
    public <T> List<T> extractModels(Class<T> cls, Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            DBAdapter dBAdapter = this.adapters.get(cls);
            while (cursor.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                arrayList.add(dBAdapter.fromContentValues(contentValues));
            }
            return arrayList;
        } finally {
            cursor.close();
        }
    }

    /* access modifiers changed from: private */
    public List<String> getAdsForPlacement(String str) {
        Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
        query.columns = new String[]{IdColumns.COLUMN_IDENTIFIER};
        query.selection = "placement_id=?";
        query.args = new String[]{str};
        Cursor query2 = this.dbHelper.query(query);
        ArrayList arrayList = new ArrayList();
        while (query2 != null && query2.moveToNext()) {
            arrayList.add(query2.getString(query2.getColumnIndex(IdColumns.COLUMN_IDENTIFIER)));
        }
        if (query2 != null) {
            query2.close();
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List<AdAsset> loadAllAdAssetModels(String str) {
        Query query = new Query(AdAssetDBAdapter.AdAssetColumns.TABLE_NAME);
        query.selection = "ad_identifier = ? ";
        query.args = new String[]{str};
        return extractModels(AdAsset.class, this.dbHelper.query(query));
    }

    /* access modifiers changed from: private */
    public <T> List<T> loadAllModels(Class<T> cls) {
        DBAdapter dBAdapter = this.adapters.get(cls);
        if (dBAdapter == null) {
            return Collections.EMPTY_LIST;
        }
        return extractModels(cls, this.dbHelper.query(new Query(dBAdapter.tableName())));
    }

    /* access modifiers changed from: private */
    public <T> T loadModel(String str, Class<T> cls) {
        DBAdapter dBAdapter = this.adapters.get(cls);
        Query query = new Query(dBAdapter.tableName());
        query.selection = "item_id = ? ";
        query.args = new String[]{str};
        Cursor query2 = this.dbHelper.query(query);
        if (query2 == null) {
            return null;
        }
        try {
            if (query2.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                return dBAdapter.fromContentValues(contentValues);
            }
            query2.close();
            return null;
        } finally {
            query2.close();
        }
    }

    /* access modifiers changed from: private */
    public List<String> loadValidPlacementIds() {
        Query query = new Query("placement");
        query.selection = "is_valid = ?";
        query.args = new String[]{"1"};
        query.columns = new String[]{IdColumns.COLUMN_IDENTIFIER};
        Cursor query2 = this.dbHelper.query(query);
        ArrayList arrayList = new ArrayList();
        if (query2 != null) {
            while (query2 != null) {
                try {
                    if (!query2.moveToNext()) {
                        break;
                    }
                    arrayList.add(query2.getString(query2.getColumnIndex(IdColumns.COLUMN_IDENTIFIER)));
                } catch (Throwable th) {
                    query2.close();
                    throw th;
                }
            }
            query2.close();
        }
        return arrayList;
    }

    private void runAndWait(Callable<Void> callable) throws DatabaseHelper.DBException {
        try {
            this.backgroundExecutor.submit(callable).get();
        } catch (ExecutionException e) {
            if (!(e.getCause() instanceof DatabaseHelper.DBException)) {
                e.printStackTrace();
                return;
            }
            throw ((DatabaseHelper.DBException) e.getCause());
        } catch (InterruptedException e2) {
            Log.e(TAG, "InterruptedException ", e2);
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: private */
    public <T> void saveModel(T t) throws DatabaseHelper.DBException {
        DBAdapter dBAdapter = this.adapters.get(t.getClass());
        this.dbHelper.insertWithConflict(dBAdapter.tableName(), dBAdapter.toContentValues(t), 5);
    }

    public void clearAllData() {
        this.dbHelper.dropDb();
        this.designer.clearCache();
    }

    public <T> void delete(final T t) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.deleteModel(t);
                return null;
            }
        });
    }

    public void deleteAdvertisement(final String str) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.deleteAdInternal(str);
                return null;
            }
        });
    }

    public FutureResult<List<String>> findAdsForPlacement(final String str) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<List<String>>() {
            public List<String> call() {
                return Repository.this.getAdsForPlacement(str);
            }
        }));
    }

    public FutureResult<Advertisement> findValidAdvertisementForPlacement(final String str) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<Advertisement>() {
            public Advertisement call() {
                String unused = Repository.TAG;
                " Searching for valid adv for pl " + str;
                Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
                query.selection = "placement_id = ? AND (state = ? OR  state = ?) AND expire_time > ?";
                query.args = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000)};
                query.limit = "1";
                query.orderBy = "state DESC";
                Cursor query2 = Repository.this.dbHelper.query(query);
                AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) Repository.this.adapters.get(Advertisement.class);
                ArrayList arrayList = new ArrayList();
                while (query2 != null && advertisementDBAdapter != null && query2.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                    arrayList.add(advertisementDBAdapter.fromContentValues(contentValues));
                }
                if (query2 != null) {
                    query2.close();
                }
                Advertisement advertisement = arrayList.size() > 0 ? (Advertisement) arrayList.get(0) : null;
                String unused2 = Repository.TAG;
                if (advertisement != null) {
                    "Found valid adv " + advertisement.getId();
                }
                return advertisement;
            }
        }));
    }

    public FutureResult<File> getAdvertisementAssetDirectory(final String str) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<File>() {
            public File call() throws Exception {
                return Repository.this.designer.getAssetDirectory(str);
            }
        }));
    }

    public FutureResult<List<String>> getAvailableBidTokens(final int i) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<List<String>>() {
            /* JADX INFO: finally extract failed */
            public List<String> call() throws Exception {
                ArrayList arrayList;
                synchronized (Repository.this) {
                    Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
                    query.selection = "bid_token != '' AND state = ? AND expire_time > ?";
                    query.columns = new String[]{AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN};
                    query.args = new String[]{String.valueOf(1), String.valueOf(System.currentTimeMillis() / 1000)};
                    query.limit = String.valueOf(i);
                    Cursor query2 = Repository.this.dbHelper.query(query);
                    arrayList = new ArrayList();
                    if (query2 != null) {
                        while (query2.moveToNext()) {
                            try {
                                arrayList.add(query2.getString(query2.getColumnIndex(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN)));
                            } catch (Throwable th) {
                                query2.close();
                                throw th;
                            }
                        }
                        query2.close();
                    }
                }
                return arrayList;
            }
        }));
    }

    public FutureResult<Collection<String>> getValidPlacementIds() {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<Collection<String>>() {
            public Collection<String> call() throws Exception {
                List access$1100;
                synchronized (Repository.this) {
                    access$1100 = Repository.this.loadValidPlacementIds();
                }
                return access$1100;
            }
        }));
    }

    public FutureResult<List<VisionAggregationData>> getVisionAggregationData(long j, int i, String str) {
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<List<VisionAggregationData>>() {
            public List<VisionAggregationData> call() {
                ArrayList arrayList = new ArrayList();
                if (!VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER.equals(str2) && !"campaign".equals(str2) && !VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE.equals(str2)) {
                    return arrayList;
                }
                Query query = new Query(VisionDataDBAdapter.VisionDataColumns.TABLE_NAME);
                String str = str2;
                query.columns = new String[]{"COUNT ( * ) as viewCount", "MAX ( timestamp ) as lastTimeStamp", str};
                query.selection = "timestamp >= ?";
                query.groupBy = str;
                query.orderBy = "_id DESC";
                query.limit = Integer.toString(i2);
                query.args = new String[]{Long.toString(j2)};
                Cursor query2 = Repository.this.dbHelper.query(query);
                if (query2 != null) {
                    while (query2.moveToNext()) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                            arrayList.add(new VisionAggregationData(contentValues.getAsString(str2), contentValues.getAsInteger("viewCount").intValue(), contentValues.getAsLong("lastTimeStamp").longValue()));
                        } finally {
                            query2.close();
                        }
                    }
                }
                return arrayList;
            }
        }));
    }

    public FutureResult<VisionAggregationInfo> getVisionAggregationInfo(final long j) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<VisionAggregationInfo>() {
            public VisionAggregationInfo call() {
                Query query = new Query(VisionDataDBAdapter.VisionDataColumns.TABLE_NAME);
                query.selection = "timestamp >= ?";
                query.orderBy = "_id DESC";
                query.args = new String[]{Long.toString(j)};
                Cursor query2 = Repository.this.dbHelper.query(query);
                VisionDataDBAdapter visionDataDBAdapter = (VisionDataDBAdapter) Repository.this.adapters.get(VisionData.class);
                if (query2 == null || visionDataDBAdapter == null) {
                    return null;
                }
                try {
                    if (query2.moveToFirst()) {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                        return new VisionAggregationInfo(query2.getCount(), visionDataDBAdapter.fromContentValues(contentValues).creative);
                    }
                    query2.close();
                    return null;
                } finally {
                    query2.close();
                }
            }
        }));
    }

    public void init() throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.dbHelper.init();
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", 3);
                Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
                query.selection = "state=?";
                query.args = new String[]{String.valueOf(2)};
                Repository.this.dbHelper.update(query, contentValues);
                return null;
            }
        });
    }

    public <T> FutureResult<T> load(final String str, final Class<T> cls) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<T>() {
            public T call() {
                return Repository.this.loadModel(str, cls);
            }
        }));
    }

    public <T> FutureResult<List<T>> loadAll(final Class<T> cls) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<List<T>>() {
            public List<T> call() {
                return Repository.this.loadAllModels(cls);
            }
        }));
    }

    public FutureResult<List<AdAsset>> loadAllAdAssets(final String str) {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<List<AdAsset>>() {
            public List<AdAsset> call() {
                return Repository.this.loadAllAdAssetModels(str);
            }
        }));
    }

    public FutureResult<List<Report>> loadAllReportToSend() {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<List<Report>>() {
            public List<Report> call() {
                List<Report> access$500 = Repository.this.loadAllModels(Report.class);
                for (Report next : access$500) {
                    next.setStatus(2);
                    try {
                        Repository.this.saveModel(next);
                    } catch (DatabaseHelper.DBException unused) {
                        return null;
                    }
                }
                return access$500;
            }
        }));
    }

    public FutureResult<List<Report>> loadReadyOrFailedReportToSend() {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<List<Report>>() {
            public List<Report> call() {
                Query query = new Query(ReportDBAdapter.ReportColumns.TABLE_NAME);
                query.selection = "status = ?  OR status = ? ";
                query.args = new String[]{String.valueOf(1), String.valueOf(3)};
                List<Report> access$600 = Repository.this.extractModels(Report.class, Repository.this.dbHelper.query(query));
                for (Report next : access$600) {
                    next.setStatus(2);
                    try {
                        Repository.this.saveModel(next);
                    } catch (DatabaseHelper.DBException unused) {
                        return null;
                    }
                }
                return access$600;
            }
        }));
    }

    public FutureResult<Collection<Placement>> loadValidPlacements() {
        return new FutureResult<>(this.backgroundExecutor.submit(new Callable<Collection<Placement>>() {
            public List<Placement> call() {
                List<Placement> access$600;
                synchronized (Repository.this) {
                    Query query = new Query("placement");
                    query.selection = "is_valid = ?";
                    query.args = new String[]{"1"};
                    access$600 = Repository.this.extractModels(Placement.class, Repository.this.dbHelper.query(query));
                }
                return access$600;
            }
        }));
    }

    public <T> void save(final T t) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.saveModel(t);
                return null;
            }
        });
    }

    public void saveAndApplyState(final Advertisement advertisement, final String str, @Advertisement.State final int i) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                String unused = Repository.TAG;
                "Setting " + i + " for adv " + advertisement.getId() + " and pl " + str;
                advertisement.setState(i);
                int i = i;
                if (i == 0 || i == 1) {
                    advertisement.setPlacementId(str);
                    Repository.this.saveModel(advertisement);
                } else if (i == 2) {
                    advertisement.setPlacementId((String) null);
                    Repository.this.saveModel(advertisement);
                } else if (i == 3 || i == 4) {
                    Repository.this.deleteAdInternal(advertisement.getId());
                }
                return null;
            }
        });
    }

    public void setMockDBHelper(DatabaseHelper databaseHelper) {
        this.dbHelper = databaseHelper;
    }

    public void setValidPlacements(final List<Placement> list) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Class<Placement> cls = Placement.class;
                synchronized (Repository.class) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(PlacementDBAdapter.PlacementColumns.COLUMN_IS_VALID, false);
                    Repository.this.dbHelper.update(new Query("placement"), contentValues);
                    for (Placement placement : list) {
                        Placement placement2 = (Placement) Repository.this.loadModel(placement.getId(), cls);
                        if (!(placement2 == null || placement2.isIncentivized() == placement.isIncentivized())) {
                            String access$300 = Repository.TAG;
                            Log.w(access$300, "Placements data for " + placement.getId() + " is different from disc, deleting old");
                            for (String access$900 : Repository.this.getAdsForPlacement(placement.getId())) {
                                Repository.this.deleteAdInternal(access$900);
                            }
                            Repository.this.deleteModel(cls, placement2.getId());
                        }
                        if (placement2 != null) {
                            placement.setWakeupTime(placement2.getWakeupTime());
                            placement.setAdSize(placement2.getAdSize());
                        }
                        placement.setValid(true);
                        Repository.this.saveModel(placement);
                    }
                }
                return null;
            }
        });
    }

    public void trimVisionData(final int i) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Query query = new Query(VisionDataDBAdapter.VisionDataColumns.TABLE_NAME);
                query.selection = "_id <= ( SELECT MAX( _id ) FROM vision_data ) - ?";
                query.args = new String[]{Integer.toString(i)};
                Repository.this.dbHelper.delete(query);
                return null;
            }
        });
    }

    public void updateAndSaveReportState(String str, String str2, int i, int i2) throws DatabaseHelper.DBException {
        final int i3 = i2;
        final String str3 = str;
        final int i4 = i;
        final String str4 = str2;
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(i3));
                Query query = new Query(ReportDBAdapter.ReportColumns.TABLE_NAME);
                query.selection = "placementId = ?  AND status = ?  AND appId = ? ";
                query.args = new String[]{str3, String.valueOf(i4), str4};
                Repository.this.dbHelper.update(query, contentValues);
                return null;
            }
        });
    }

    public Repository(Context context, Designer designer2, ExecutorService executorService, ExecutorService executorService2, int i) {
        this.adapters = new HashMap();
        this.appCtx = context.getApplicationContext();
        this.backgroundExecutor = executorService;
        this.uiExecutor = executorService2;
        this.dbHelper = new DatabaseHelper(context, i, new VungleDatabaseCreator(this.appCtx));
        this.designer = designer2;
        this.adapters.put(Placement.class, new PlacementDBAdapter());
        this.adapters.put(Cookie.class, new CookieDBAdapter());
        this.adapters.put(Report.class, new ReportDBAdapter());
        this.adapters.put(Advertisement.class, new AdvertisementDBAdapter());
        this.adapters.put(AdAsset.class, new AdAssetDBAdapter());
        this.adapters.put(VisionData.class, new VisionDataDBAdapter());
    }

    public <T> void load(final String str, final Class<T> cls, final LoadCallback<T> loadCallback) {
        this.backgroundExecutor.execute(new Runnable() {
            public void run() {
                final Object access$000 = Repository.this.loadModel(str, cls);
                Repository.this.uiExecutor.execute(new Runnable() {
                    public void run() {
                        loadCallback.onLoaded(access$000);
                    }
                });
            }
        });
    }

    public <T> void save(final T t, final SaveCallback saveCallback) {
        try {
            this.backgroundExecutor.submit(new Runnable() {
                public void run() {
                    try {
                        Repository.this.saveModel(t);
                        if (saveCallback != null) {
                            Repository.this.uiExecutor.execute(new Runnable() {
                                public void run() {
                                    saveCallback.onSaved();
                                }
                            });
                        }
                    } catch (DatabaseHelper.DBException e) {
                        if (saveCallback != null) {
                            Repository.this.uiExecutor.execute(new Runnable() {
                                public void run() {
                                    saveCallback.onError(e);
                                }
                            });
                        }
                    }
                }
            }).get();
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public <T> void deleteModel(T t) throws DatabaseHelper.DBException {
        deleteModel(t.getClass(), this.adapters.get(t.getClass()).toContentValues(t).getAsString(IdColumns.COLUMN_IDENTIFIER));
    }
}
