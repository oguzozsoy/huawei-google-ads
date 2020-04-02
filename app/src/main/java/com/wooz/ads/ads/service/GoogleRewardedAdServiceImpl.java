package com.wooz.ads.ads.service;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.wooz.ads.ads.listener.AdsListener;

public class GoogleRewardedAdServiceImpl implements
        RewardedAdService, RewardedVideoAdListener {

    private static final String TAG = "GoogleRewardedAdService";

    private static final String AD_MOB_APP_ID = "ca-app-pub-3940256099942544~3347511713";
    private static final String AD_UNIT = "ca-app-pub-3940256099942544/5224354917";

    private AdsListener.RewardedAdListener rewardedAdListener;
    private RewardedVideoAd mRewardedVideoAd;

    public GoogleRewardedAdServiceImpl(Activity activity){

    }


    @Override
    public void loadRewardedAd(){
        mRewardedVideoAd.loadAd(AD_UNIT, new AdRequest.Builder().build());
        mRewardedVideoAd.setRewardedVideoAdListener(this);
    }

    @Override
    public boolean isLoaded() {
        return mRewardedVideoAd.isLoaded();
    }

    @Override
    public void show() {
        mRewardedVideoAd.show();
    }

    @Override
    public void initRewardedAd(Context context){
        MobileAds.initialize(context, AD_MOB_APP_ID);
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context);
    }

    @Override
    public void setRewardedAdListener(AdsListener.RewardedAdListener listener) {
        this.rewardedAdListener = listener;
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        rewardedAdListener.onRewardedAdLoaded();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        rewardedAdListener.onRewardedAdOpened();
    }

    @Override
    public void onRewardedVideoStarted() {
        rewardedAdListener.onRewardedStarted();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        rewardedAdListener.onRewardedAdClosed();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        rewardedAdListener.onRewarded(rewardItem);
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        rewardedAdListener.onRewardedAdLeftApplication();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        rewardedAdListener.onRewardedAdFailedToLoad(i);
    }

    @Override
    public void onRewardedVideoCompleted() {
        rewardedAdListener.onRewardedCompleted();
    }
}