package com.wooz.ads.ads.manager;

import android.content.Context;
import android.view.View;

import com.wooz.ads.ads.factory.AdsFactory;
import com.wooz.ads.ads.service.BannerAdService;


public class BannerAdManager {
    private static final String TAG = "BannerAdManager";
    private BannerAdService mBannerAdService;

    public BannerAdManager(Context context) {
        mBannerAdService = AdsFactory.getBannerAdService(context);
    }

    public View getBannerAdView(Context context) {
        return mBannerAdService.getBannerAdView(context);
    }

    public void loadBannerAd() {
        mBannerAdService.loadBannerAd();
    }
}
