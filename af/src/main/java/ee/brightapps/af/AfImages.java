package ee.brightapps.af;

import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

public class AfImages {

    public static void setTintRes(ImageView img, int colorRes) {
        img.setColorFilter(ContextCompat.getColor(img.getContext(), colorRes), android.graphics.PorterDuff.Mode.SRC_IN);
    }

    public static void setTint(ImageView img, int color) {
        img.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);
    }

}