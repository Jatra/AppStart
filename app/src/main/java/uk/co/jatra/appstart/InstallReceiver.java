package uk.co.jatra.appstart;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
            launchApp(context, MainActivity.ZIPCAR_APP);
        }
    }

    private void launchApp(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();

        Intent it = pm.getLaunchIntentForPackage(packageName);
        try {
            if (it != null) {
                context.startActivity(it);
            }
        } catch (ActivityNotFoundException e) {
        }
    }

}
