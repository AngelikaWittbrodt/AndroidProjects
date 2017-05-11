package examples.sda.httpexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkStateReceiver extends BroadcastReceiver {

    private boolean isConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() && (networkInfo.getType() == ConnectivityManager.TYPE_WIFI || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "";
        if (isConnected(context)) {
            message = "Połączono z siecią";
        } else {
            message = "Rozłączone z siecią";
        }

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
