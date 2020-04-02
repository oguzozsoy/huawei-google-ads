package com.wooz.ads.ads.manager;

import android.app.Activity;
import android.content.Context;

import com.wooz.ads.ads.factory.AdsFactory;
import com.wooz.ads.ads.listener.AdsListener;
import com.wooz.ads.ads.service.RewardedAdService;


public class RewardedAdManager {
    private static final String TAG = "RewardedAdManager";
    private RewardedAdService mRewardedAdService;

    public RewardedAdManager(Activity activity) {
        mRewardedAdService = AdsFactory.getRewardedAdService(activity);
    }

    public void setRewardedAdListener(AdsListener.RewardedAdListener listener) {
        mRewardedAdService.setRewardedAdListener(listener);
    }

    public void initRewardedAd(Context context) {
        mRewardedAdService.initRewardedAd(context);
    }

    public void loadRewardedAd() {
        mRewardedAdService.loadRewardedAd();
    }

    public boolean isLoaded() {
        return mRewardedAdService.isLoaded();
    }

    public void show() {
        mRewardedAdService.show();
    }
}
