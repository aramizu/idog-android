package br.com.aramizu.idog.network.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

    @SuppressLint("MissingPermission")
    public static boolean isNetworkNotConnected(Context context) {
        Boolean isConnected = false;
        ConnectivityManager conectivtyManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(conectivtyManager != null) {
            NetworkInfo[] info = conectivtyManager.getAllNetworkInfo();
            if(info != null) {
                for (NetworkInfo anInfo : info) {
                    if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                        isConnected = true;
                    }
                }
            }
        }
        return !isConnected;
    }
}