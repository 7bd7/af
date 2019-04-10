package ee.brightapps.af;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AfNetwork {

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork.isConnected();
    }

}
