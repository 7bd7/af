package ee.brightapps.af;

import android.os.AsyncTask;
import android.os.Looper;

public class AfThreads {

    public static void runInBg(Runnable r) {
        if (isUi()) AsyncTask.THREAD_POOL_EXECUTOR.execute(r);
        else r.run();
    }

    private static boolean isUi() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

}
