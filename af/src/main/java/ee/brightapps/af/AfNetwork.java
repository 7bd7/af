package ee.brightapps.af;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AfNetwork {

    //TODO: possible NullPointerException if Connectivity manager not checked for null
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork.isConnected();
        }
        return false;
    }

}
