package com.wooz.ads.ads.service;

import android.content.Context;

import com.wooz.ads.ads.listener.AdsListener;


public interface RewardedAdService {
    void setRewardedAdListener(AdsListener.RewardedAdListener listener);

    void initRewardedAd(Context context);

    void loadRewardedAd();

    boolean isLoaded();

    void show();
}
