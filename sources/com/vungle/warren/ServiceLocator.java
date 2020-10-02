package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import com.vungle.warren.analytics.VungleAnalytics;
import com.vungle.warren.downloader.AssetDownloader;
import com.vungle.warren.downloader.CleverCache;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.downloader.DownloaderCache;
import com.vungle.warren.downloader.LRUCachePolicy;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.Designer;
import com.vungle.warren.persistence.GraphicDesigner;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobCreator;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.ReconfigJob;
import com.vungle.warren.tasks.VungleJobCreator;
import com.vungle.warren.tasks.utility.JobRunnerThreadPriorityHelper;
import com.vungle.warren.utility.ConcurrencyTimeoutProvider;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.NetworkProvider;
import com.vungle.warren.utility.SDKExecutors;
import com.vungle.warren.utility.TimeoutProvider;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class ServiceLocator {
    @SuppressLint({"StaticFieldLeak"})
    private static ServiceLocator INSTANCE;
    /* access modifiers changed from: private */
    public static final ReconfigJob.ReconfigCall RECONFIG_CALL = new ReconfigJob.ReconfigCall() {
        public void reConfigVungle() {
            Vungle.reConfigure();
        }
    };
    static final VungleStaticApi VUNGLE_STATIC_API = new VungleStaticApi() {
        public Collection<String> getValidPlacements() {
            return Vungle.getValidPlacements();
        }

        public boolean isInitialized() {
            return Vungle.isInitialized();
        }
    };
    private Map<Class, Object> cache = new HashMap();
    private Map<Class, Creator> creators = new HashMap();
    /* access modifiers changed from: private */
    public final Context ctx;

    private abstract class Creator<T> {
        private Creator() {
        }

        /* access modifiers changed from: package-private */
        public abstract T create();

        /* access modifiers changed from: package-private */
        public boolean isSingleton() {
            return true;
        }
    }

    private ServiceLocator(Context context) {
        this.ctx = context.getApplicationContext();
        buildCreators();
    }

    private void buildCreators() {
        this.creators.put(JobCreator.class, new Creator() {
            public JobCreator create() {
                Class<VungleApiClient> cls = VungleApiClient.class;
                return new VungleJobCreator((Repository) ServiceLocator.this.getOrBuild(Repository.class), (Designer) ServiceLocator.this.getOrBuild(Designer.class), (VungleApiClient) ServiceLocator.this.getOrBuild(cls), new VungleAnalytics((VungleApiClient) ServiceLocator.this.getOrBuild(cls)), ServiceLocator.RECONFIG_CALL, (AdLoader) ServiceLocator.this.getOrBuild(AdLoader.class), ServiceLocator.VUNGLE_STATIC_API);
            }
        });
        this.creators.put(JobRunner.class, new Creator() {
            public JobRunner create() {
                return new VungleJobRunner((JobCreator) ServiceLocator.this.getOrBuild(JobCreator.class), ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getJobExecutor(), new JobRunnerThreadPriorityHelper(), NetworkProvider.getInstance(ServiceLocator.this.ctx));
            }
        });
        this.creators.put(AdLoader.class, new Creator() {
            public AdLoader create() {
                return new AdLoader((Executors) ServiceLocator.this.getOrBuild(Executors.class), (Repository) ServiceLocator.this.getOrBuild(Repository.class), (VungleApiClient) ServiceLocator.this.getOrBuild(VungleApiClient.class), (CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class), (Downloader) ServiceLocator.this.getOrBuild(Downloader.class), (RuntimeValues) ServiceLocator.this.getOrBuild(RuntimeValues.class), (VungleStaticApi) ServiceLocator.this.getOrBuild(VungleStaticApi.class), (VisionController) ServiceLocator.this.getOrBuild(VisionController.class), (OperationSequence) ServiceLocator.this.getOrBuild(OperationSequence.class));
            }
        });
        this.creators.put(Downloader.class, new Creator() {
            public Downloader create() {
                return new AssetDownloader((DownloaderCache) ServiceLocator.this.getOrBuild(DownloaderCache.class), AssetDownloader.VERIFICATION_WINDOW, 4, NetworkProvider.getInstance(ServiceLocator.this.ctx), ((Executors) ServiceLocator.this.getOrBuild(Executors.class)).getUIExecutor());
            }
        });
        this.creators.put(VungleApiClient.class, new Creator() {
            public VungleApiClient create() {
                return new VungleApiClient(ServiceLocator.this.ctx, (CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class), (Repository) ServiceLocator.this.getOrBuild(Repository.class));
            }
        });
        this.creators.put(Repository.class, new Creator() {
            public Repository create() {
                Executors executors = (Executors) ServiceLocator.this.getOrBuild(Executors.class);
                return new Repository(ServiceLocator.this.ctx, (Designer) ServiceLocator.this.getOrBuild(Designer.class), executors.getIOExecutor(), executors.getUIExecutor());
            }
        });
        this.creators.put(Designer.class, new Creator() {
            public Designer create() {
                return new GraphicDesigner((CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class));
            }
        });
        this.creators.put(CacheManager.class, new Creator() {
            public CacheManager create() {
                return new CacheManager(ServiceLocator.this.ctx);
            }
        });
        this.creators.put(Executors.class, new Creator() {
            public Executors create() {
                return new SDKExecutors();
            }
        });
        this.creators.put(RuntimeValues.class, new Creator() {
            public RuntimeValues create() {
                return new RuntimeValues();
            }
        });
        this.creators.put(VungleStaticApi.class, new Creator() {
            public VungleStaticApi create() {
                return ServiceLocator.VUNGLE_STATIC_API;
            }
        });
        this.creators.put(PresentationFactory.class, new Creator() {
            /* access modifiers changed from: package-private */
            public boolean isSingleton() {
                return false;
            }

            public PresentationFactory create() {
                return new AdvertisementPresentationFactory((AdLoader) ServiceLocator.this.getOrBuild(AdLoader.class), (VungleStaticApi) ServiceLocator.this.getOrBuild(VungleStaticApi.class), (Repository) ServiceLocator.this.getOrBuild(Repository.class), (VungleApiClient) ServiceLocator.this.getOrBuild(VungleApiClient.class), (JobRunner) ServiceLocator.this.getOrBuild(JobRunner.class), (RuntimeValues) ServiceLocator.this.getOrBuild(RuntimeValues.class));
            }
        });
        this.creators.put(DownloaderCache.class, new Creator() {
            /* access modifiers changed from: package-private */
            public Object create() {
                CacheManager cacheManager = (CacheManager) ServiceLocator.this.getOrBuild(CacheManager.class);
                return new CleverCache(cacheManager, new LRUCachePolicy(cacheManager, CleverCache.CC_DIR), new DownloaderSizeProvider(cacheManager, (RuntimeValues) ServiceLocator.this.getOrBuild(RuntimeValues.class), 0.1f), TimeUnit.DAYS.toMillis(90));
            }
        });
        this.creators.put(VisionController.class, new Creator() {
            public VisionController create() {
                return new VisionController((Repository) ServiceLocator.this.getOrBuild(Repository.class), NetworkProvider.getInstance(ServiceLocator.this.ctx));
            }
        });
        this.creators.put(TimeoutProvider.class, new Creator() {
            public TimeoutProvider create() {
                return new ConcurrencyTimeoutProvider();
            }
        });
        this.creators.put(OperationSequence.class, new Creator() {
            public OperationSequence create() {
                return new OperationSequence();
            }
        });
    }

    static synchronized void deInit() {
        synchronized (ServiceLocator.class) {
            INSTANCE = null;
        }
    }

    static synchronized ServiceLocator getInstance(Context context) {
        ServiceLocator serviceLocator;
        synchronized (ServiceLocator.class) {
            if (INSTANCE == null) {
                INSTANCE = new ServiceLocator(context);
            }
            serviceLocator = INSTANCE;
        }
        return serviceLocator;
    }

    /* access modifiers changed from: private */
    public <T> T getOrBuild(Class<T> cls) {
        Class serviceClass = getServiceClass(cls);
        T t = this.cache.get(serviceClass);
        if (t != null) {
            return t;
        }
        Creator creator = this.creators.get(serviceClass);
        if (creator != null) {
            T create = creator.create();
            if (creator.isSingleton()) {
                this.cache.put(serviceClass, create);
            }
            return create;
        }
        throw new IllegalArgumentException("Unknown class");
    }

    private Class getServiceClass(Class cls) {
        for (Class next : this.creators.keySet()) {
            if (next.isAssignableFrom(cls)) {
                return next;
            }
        }
        throw new IllegalArgumentException("Unknown dependency for " + cls);
    }

    /* access modifiers changed from: package-private */
    public synchronized <T> void bindService(Class<T> cls, T t) {
        this.cache.put(getServiceClass(cls), t);
    }

    /* access modifiers changed from: package-private */
    public synchronized <T> T getService(Class<T> cls) {
        return getOrBuild(cls);
    }
}
