package com.wooz.ads;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wooz.ads.ads.listener.AdsListener;
import com.wooz.ads.ads.manager.RewardedAdManager;
import com.wooz.ads.ads.ui.BannerAdView;

public class MainActivity extends AppCompatActivity {

    private RewardedAdManager mRewardedAdManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRewardedAdManager = new RewardedAdManager(MainActivity.this);

        initBannerAd();
        initRewardedAd();

        findViewById(R.id.button_show_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mRewardedAdManager.isLoaded()){
                    mRewardedAdManager.show();
                }
            }
        });
    }

    private void initBannerAd(){
        BannerAdView adView = findViewById(R.id.ad_view);
        adView.loadBannerAd();
    }

    private void initRewardedAd(){
        mRewardedAdManager.initRewardedAd(MainActivity.this);
        mRewardedAdManager.loadRewardedAd();
        mRewardedAdManager.setRewardedAdListener(new AdsListener.RewardedAdListener() {
            @Override
            public void onRewardedAdLoaded() {
            }

            @Override
            public void onRewardedAdOpened() {
            }

            @Override
            public void onRewardedStarted() {
            }

            @Override
            public void onRewardedAdClosed() {

            }

            @Override
            public void onRewarded(Object rewardItem) {
                Toast.makeText(MainActivity.this, "Rewarded",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedAdLeftApplication() {
            }

            @Override
            public void onRewardedAdFailedToLoad(int i) {
            }

            @Override
            public void onRewardedCompleted() {
            }
        });
    }
}
