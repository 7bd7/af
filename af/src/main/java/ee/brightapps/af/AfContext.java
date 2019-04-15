package ee.brightapps.af;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

public class AfContext {

    /**
     * @param defaultTime is returned if PackageInfo wasn't found by package name
     */
    public static long getAppInstallTime(Context context, long defaultTime) {
        try {
            return context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            return defaultTime;
        }
    }

    public static boolean isAppInstalled(Context context, String pkg) {
        try {
            context.getPackageManager().getPackageInfo(pkg, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * @param text - text to be copied
     * @param toast - Toast msg or null to not show a toast
     */
    public static void copyToClipboard(Context context, CharSequence text, @Nullable String toast) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText(text, text));
        if (toast != null) Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }

    public static boolean isRtl(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    /**
     * Request system for permissions
     */
    public static void requestPerms(Activity activity, int requestCode, String... perms) {
        if (!hasPerms(activity, perms)) {
            ActivityCompat.requestPermissions(activity, perms, requestCode);
        }
    }

    /**
     * Check are permissions granted
     */
    public static boolean hasPerms(Context context, String... perms) {
        if (perms == null || Build.VERSION.SDK_INT < 23) return true;
        for (String perm : perms) {
            if (ContextCompat.checkSelfPermission(context, perm) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the given grantResults are all of the permissions from it are granted
     */
    public static boolean isAllPermsGranted(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) return false;
        }
        return true;
    }

    public static boolean isBillingAllowed(Context context) {
        final String japanCode = "jp";
        if (Build.VERSION.SDK_INT <= 24) {
            return !japanCode.equalsIgnoreCase(context.getResources().getConfiguration().locale.getCountry());
        } else {
            LocaleList locales = context.getResources().getConfiguration().getLocales();
            for (int i = 0; i < locales.size(); i++) {
                if (japanCode.equalsIgnoreCase(locales.get(i).getCountry())) return false;
            }
            return true;
        }
    }

}
