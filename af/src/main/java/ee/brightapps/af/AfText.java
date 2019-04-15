package ee.brightapps.af;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class AfText {

    /**
     * @param text - text to be copied
     * @param toast - Toast msg or null to not show a toast
     */
    public static void copyToClipboard(Context context, CharSequence text, @Nullable String toast) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText(text, text));
        if (toast != null) Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }

}
