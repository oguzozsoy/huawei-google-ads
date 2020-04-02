package com.wooz.ads.ads.listener;

public class AdsListener {

    public interface RewardedAdListener {
        void onRewardedAdLoaded();

        void onRewardedAdOpened();

        void onRewardedStarted();

        void onRewardedAdClosed();

        void onRewarded(Object rewardItem);

        void onRewardedAdLeftApplication();

        void onRewardedAdFailedToLoad(int i);

        void onRewardedCompleted();
    }

}
