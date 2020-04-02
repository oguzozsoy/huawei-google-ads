package com.wooz.ads.ads.service;

import android.content.Context;
import android.view.View;

public interface BannerAdService {

    View getBannerAdView(Context context);

    void loadBannerAd();
}
