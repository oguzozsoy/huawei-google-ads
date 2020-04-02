package com.wooz.ads.ads.service;

import android.content.Context;
import android.view.View;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

public class HuaweiBannerAdServiceImpl implements BannerAdService {

    private static final String AD_ID = "testw6vs28auh3";

    private BannerView mBannerView;

    public HuaweiBannerAdServiceImpl(Context context) {
        HwAds.init(context);
    }

    @Override
    public View getBannerAdView(Context context) {
        mBannerView = new BannerView(context);
        mBannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
        mBannerView.setAdId(AD_ID);
        return mBannerView;

    }

    @Override
    public void loadBannerAd() {
        mBannerView.loadAd(new AdParam.Builder().build());
    }
}
