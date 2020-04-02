package com.wooz.ads.ads.service;

import android.content.Context;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class GoogleBannerAdServiceImpl implements BannerAdService {

    private static final String AD_UNIT = "ca-app-pub-3940256099942544/6300978111";

    private AdView mAdView;

    public GoogleBannerAdServiceImpl(Context context) {

    }

    @Override
    public View getBannerAdView(Context context) {
        mAdView = new AdView(context);
        mAdView.setAdUnitId(AD_UNIT);
        mAdView.setAdSize(AdSize.FULL_BANNER);
        return mAdView;
    }

    @Override
    public void loadBannerAd() {
        mAdView.loadAd(new AdRequest.Builder().build());
    }
}