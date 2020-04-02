package com.wooz.ads.ads.util;

import android.content.Context;

import com.google.android.gms.common.GoogleApiAvailability;

public class MobileServiceUtil {

    private static final String TAG = "MobileServiceUtil";

    public static MobileServiceType getMobileServiceType(Context context){
        if(com.google.android.gms.common.ConnectionResult.SUCCESS ==
                GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)){
            return MobileServiceType.GOOGLE_SERVICES;
        }
        else{
            return MobileServiceType.HUAWEI_SERVICES;
        }
    }
}
