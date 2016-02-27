package uk.co.jatra.appstart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class InstallReceiver extends BroadcastReceiver {
    private static final String TAG = InstallReceiver.class.getSimpleName();

    public InstallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Received " + intent.toString());
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")
                && intent.getData().equals(Uri.parse("package:"+MainActivity.ZIPCAR_APP))) {
            MainActivity.launchApp(context, MainActivity.ZIPCAR_APP);
        }
    }
}
