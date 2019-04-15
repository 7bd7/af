package ee.brightapps.af;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.util.TypedValue;

import java.io.IOException;

public class AfGraphics {

    public static int dpToPx(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static Bitmap getCircleBitmap(Context context, Bitmap b, int sizeDp) {
        if (b == null) return null;
        RoundedBitmapDrawable d = RoundedBitmapDrawableFactory.create(context.getResources(), b);
        d.setCircular(true);//very important line!
        return getBitmap(context, d, sizeDp, sizeDp);
    }

    public static Bitmap getCircleBitmap(Context context, @DrawableRes int drawableRes, int sizeDp) {
        return getCircleBitmap(context, getBitmap(context, drawableRes, sizeDp, sizeDp), sizeDp);
    }

    public static Bitmap getBitmap(Context context, Drawable d, int wDp, int hDp) {
        if (d == null) return null;
        Bitmap out = Bitmap.createBitmap(AfGraphics.dpToPx(context, wDp), AfGraphics.dpToPx(context, hDp),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(out);
        d.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        d.draw(canvas);
        return out;
    }

    public static Bitmap getBitmap(Context context, @DrawableRes int drawableRes, int wDp, int hDp) {
        return getBitmap(context, ContextCompat.getDrawable(context, drawableRes), wDp, hDp);
    }

    public static Bitmap getBitmap(Context context, @Nullable String uri, int wDp, int hDp) {
        if (TextUtils.isEmpty(uri)) return null;
        try {
            Bitmap b = MediaStore.Images.Media.getBitmap(context.getContentResolver(), Uri.parse(uri));
            return Bitmap.createScaledBitmap(b, wDp, hDp, false);
        } catch (IOException e) {
            return null;
        }
    }

}
