package com.vungle.warren.utility;

import java.util.concurrent.ExecutorService;

public interface Executors {
    ExecutorService getApiExecutor();

    ExecutorService getBackgroundExecutor();

    ExecutorService getIOExecutor();

    ExecutorService getJobExecutor();

    ExecutorService getUIExecutor();
}
