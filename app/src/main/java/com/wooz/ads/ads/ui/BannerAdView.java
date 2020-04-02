package com.wooz.ads.ads.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wooz.ads.ads.manager.BannerAdManager;


public class BannerAdView extends LinearLayout {
    private static final String TAG = "BannerAdView";
    private BannerAdManager mBannerAdManager;

    public BannerAdView(Context context) {
        super(context);
    }

    public BannerAdView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        mBannerAdManager = new BannerAdManager(context);
        View view = mBannerAdManager.getBannerAdView(context);
        LayoutParams params =
                new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        BannerAdView.this.addView(view);

    }

    public void loadBannerAd() {
        mBannerAdManager.loadBannerAd();
    }
}
