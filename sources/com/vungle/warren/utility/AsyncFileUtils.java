package com.vungle.warren.utility;

import android.os.AsyncTask;
import java.io.File;

public class AsyncFileUtils {

    public static class ExistenceOperation {
        private final FileExistenceTask task;

        ExistenceOperation(FileExistenceTask fileExistenceTask) {
            this.task = fileExistenceTask;
        }

        public void cancel() {
            this.task.clear();
            this.task.cancel(true);
        }
    }

    public interface FileExistCallback {
        void status(boolean z);
    }

    private static class FileExistenceTask extends AsyncTask<Void, Void, Boolean> {
        private FileExistCallback callback;
        private final File file;

        public FileExistenceTask(File file2, FileExistCallback fileExistCallback) {
            this.file = file2;
            this.callback = fileExistCallback;
        }

        /* access modifiers changed from: private */
        public synchronized void clear() {
            this.callback = null;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... voidArr) {
            File file2 = this.file;
            return Boolean.valueOf(file2 != null && file2.exists());
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            synchronized (this) {
                if (this.callback != null) {
                    this.callback.status(bool.booleanValue());
                }
            }
        }
    }

    public static ExistenceOperation isFileExistAsync(File file, FileExistCallback fileExistCallback) {
        FileExistenceTask fileExistenceTask = new FileExistenceTask(file, fileExistCallback);
        ExistenceOperation existenceOperation = new ExistenceOperation(fileExistenceTask);
        fileExistenceTask.execute(new Void[0]);
        return existenceOperation;
    }
}
