package com.wooz.ads.ads.factory;

import android.app.Activity;
import android.content.Context;

import com.wooz.ads.ads.service.BannerAdService;
import com.wooz.ads.ads.service.GoogleBannerAdServiceImpl;
import com.wooz.ads.ads.service.GoogleRewardedAdServiceImpl;
import com.wooz.ads.ads.service.HuaweiBannerAdServiceImpl;
import com.wooz.ads.ads.service.HuaweiRewardedAdServiceImpl;
import com.wooz.ads.ads.service.RewardedAdService;
import com.wooz.ads.ads.util.MobileServiceType;
import com.wooz.ads.ads.util.MobileServiceUtil;


public class AdsFactory {

    public static RewardedAdService getRewardedAdService(Activity activity) {
        if (MobileServiceUtil.getMobileServiceType(activity) == MobileServiceType.GOOGLE_SERVICES) {
            return new GoogleRewardedAdServiceImpl(activity);
        } else {
            return new HuaweiRewardedAdServiceImpl(activity);
        }
    }

    public static BannerAdService getBannerAdService(Context context) {
        if (MobileServiceUtil.getMobileServiceType(context) == MobileServiceType.GOOGLE_SERVICES) {
            return new GoogleBannerAdServiceImpl(context);
        } else {
            return new HuaweiBannerAdServiceImpl(context);
        }
    }
}
