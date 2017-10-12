package com.dream.william.net;

import com.dream.william.BuildConfig;
import com.hylaa.lib.net.ServiceFactory;

/**
 * Created by william on 10/12/17.
 */
public class NetService {

    private static final String URL_DEV = "https://api.douban.com/v2/movie/";
    private static final String URL_TEST = "https://api.douban.com/v2/movie/";

    private static final NetService ourInstance = new NetService();

    private final ServiceFactory mServiceFactory;
    private final ServiceInterface mServiceInterface;

    public static NetService getInstance() {
        return ourInstance;
    }

    private NetService() {
        String url = BuildConfig.DEBUG ? URL_DEV : URL_TEST;
        mServiceFactory = new ServiceFactory();
        mServiceInterface = mServiceFactory.createService(ServiceInterface.class, url, null);
    }

    public ServiceInterface getServiceInterface() {
        return mServiceInterface;
    }

}
