package ee.brightapps.af;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

public class AfText {

    public static void copyToClipboard(Context context, String text, String toastMsg) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText("random", text));
        Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show();
    }

}
