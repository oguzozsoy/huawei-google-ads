package com.wooz.ads.ads.service;

import android.app.Activity;
import android.content.Context;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.reward.Reward;
import com.huawei.hms.ads.reward.RewardAd;
import com.huawei.hms.ads.reward.RewardAdLoadListener;
import com.huawei.hms.ads.reward.RewardAdStatusListener;
import com.wooz.ads.ads.listener.AdsListener;


public class HuaweiRewardedAdServiceImpl implements RewardedAdService {

    private static final String TAG = "HuaweiRewardedRewardedA";

    private static final String AD_ID = "testx9dtjwj8hp";
    private AdsListener.RewardedAdListener rewardedAdListener;
    private RewardAd mRewardAd;

    private Activity mActivity;

    public HuaweiRewardedAdServiceImpl(Activity activity) {
        this.mActivity = activity;
        HwAds.init(activity);
    }

    @Override
    public void setRewardedAdListener(AdsListener.RewardedAdListener listener) {
        this.rewardedAdListener = listener;
    }

    @Override
    public void initRewardedAd(Context context) {
        mRewardAd = new RewardAd(context, AD_ID);
    }


    @Override
    public void loadRewardedAd() {
        RewardAdLoadListener rewardAdLoadListener = new RewardAdLoadListener() {
            @Override
            public void onRewardAdFailedToLoad(int i) {
                rewardedAdListener.onRewardedAdFailedToLoad(i);
            }

            @Override
            public void onRewardedLoaded() {
                rewardedAdListener.onRewardedAdLoaded();
            }
        };
        mRewardAd.loadAd(new AdParam.Builder().build(), rewardAdLoadListener);
    }

    @Override
    public boolean isLoaded() {
        return mRewardAd.isLoaded();
    }

    @Override
    public void show() {
        mRewardAd.show(mActivity, new RewardAdStatusListener() {
            @Override
            public void onRewardAdClosed() {
                rewardedAdListener.onRewardedAdClosed();
            }

            @Override
            public void onRewardAdFailedToShow(int i) {
            }

            @Override
            public void onRewardAdOpened() {
                rewardedAdListener.onRewardedAdOpened();
            }

            @Override
            public void onRewarded(Reward reward) {
                rewardedAdListener.onRewarded(reward);
            }
        });
    }
}
