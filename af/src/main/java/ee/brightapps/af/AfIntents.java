package ee.brightapps.af;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.widget.Toast;

public class AfIntents {

    /**
     * @return if intent can be started
     */
    public static boolean safeStartForResult(Activity activity, Intent intent, int requestCode) {
        return safeStartInner(activity, intent, true, requestCode);
    }

    /**
     * @return if intent can be started
     */
    public static boolean safeStart(Context context, Intent intent) {
        return safeStartInner(context, intent, false, -1);
    }

    private static boolean safeStartInner(Context context, Intent intent, boolean forResult, int requestCode) {
        //check can start
        if (intent == null || intent.resolveActivity(context.getPackageManager()) == null) {
            return false;
        }
        //try start
        try {
            if (forResult) ((Activity) context).startActivityForResult(intent, requestCode);
            else context.startActivity(intent);
            return true;
        } catch (SecurityException ex) {// Happens sometimes on fantastic devices :)
            return false;
        }
    }

    public static void startOrChooser(Context context, Intent intent) {
        if (!AfIntents.safeStart(context, intent)) {
            context.startActivity(Intent.createChooser(intent, null));
        }
    }

    public static void startOrToast(Context context, Intent intent) {
        if (!AfIntents.safeStart(context, intent)) {
            Toast.makeText(context, R.string.af_no_apps_found, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    public static Intent openContact(Context context, String lookupKey) {
        Uri lookupUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);
        Cursor c = context.getContentResolver().query(lookupUri,
                new String[]{ContactsContract.Contacts._ID}, null, null, null);
        if (c == null || !c.moveToNext()) return null;
        try {
            return new Intent(Intent.ACTION_VIEW, Uri.withAppendedPath(
                    ContactsContract.Contacts.CONTENT_URI, String.valueOf(c.getLong(0))));
        } finally {
            c.close();
        }
    }

    public static Intent openAppPrefs(String packageName) {
        return new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", packageName, null));
    }

    public static Intent runApp(Context context, String packageName) {
        return context.getPackageManager().getLaunchIntentForPackage(packageName);
    }

    public static Intent openUrl(String url) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    }

    public static Intent openOnGooglePlay(String packageName) {
        return openUrl("https://play.google.com/store/apps/details?id=" + packageName);
    }

    public static Intent shareApp(String appName, String appPackage) {
        String text = appName + "\n" + "https://play.google.com/store/apps/details?id=" + appPackage;
        return shareText(text, null);
    }

    public static Intent shareText(CharSequence text, @Nullable String chooserTitle) {
        Intent shareIntent = new Intent()
                .setAction(Intent.ACTION_SEND)
                .putExtra(Intent.EXTRA_TEXT, text)
                .setType("text/plain");
        return Intent.createChooser(shareIntent, chooserTitle);
    }

    public static Intent emailTo(String address, String subject, String text) {
        return new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", address, null))
                .putExtra(Intent.EXTRA_SUBJECT, subject)
                .putExtra(Intent.EXTRA_TEXT, text);
    }

    public static Intent dial(String number) {
        return new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
    }

    @RequiresPermission(Manifest.permission.CALL_PHONE)
    public static Intent call(String number) {
        return new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", number, null));
    }

}
