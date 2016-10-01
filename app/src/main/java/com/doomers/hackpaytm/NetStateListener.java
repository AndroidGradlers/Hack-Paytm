package com.doomers.hackpaytm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.doomers.hackpaytm.HomeActivity;

public class NetStateListener extends BroadcastReceiver {
    public NetStateListener() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"called",Toast.LENGTH_LONG).show();
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE );
        NetworkInfo activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isConnected = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();
        if (isConnected) {
            Intent i = new Intent(context, HomeActivity.class);
            context.startActivity(i);
            Toast.makeText(context,"connected",Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(context,"Not connected",Toast.LENGTH_LONG).show();
    }
}
