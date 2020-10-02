package com.unity3d.services.banners.configuration;

import com.unity3d.services.banners.api.BannerListener;
import com.unity3d.services.banners.api.C5340Banner;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IModuleConfiguration;

public class BannersModuleConfiguration implements IModuleConfiguration {
    private static final Class[] WEB_APP_API_CLASS_LIST = {C5340Banner.class, BannerListener.class};

    public Class[] getWebAppApiClassList() {
        return WEB_APP_API_CLASS_LIST;
    }

    public boolean initCompleteState(Configuration configuration) {
        return true;
    }

    public boolean initErrorState(Configuration configuration, String str, String str2) {
        return true;
    }

    public boolean initModuleState(Configuration configuration) {
        return true;
    }

    public boolean resetState(Configuration configuration) {
        return true;
    }
}
