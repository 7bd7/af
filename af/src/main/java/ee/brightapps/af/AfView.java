package ee.brightapps.af;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AfView {

    public static void setVisibility(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public static View inflate(@LayoutRes int res, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
    }

    public static View inflate(@LayoutRes int res, Context context) {
        return LayoutInflater.from(context).inflate(res, null, false);
    }

    public static <T extends View> T withOnClick(T view, final Runnable onClick) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.run();
            }
        });
        return view;
    }

    public static void show(View v) {
        setVisibility(v, true);
    }

    public static void hide(View v) {
        setVisibility(v, false);
    }

    public static boolean isVisible(View v) {
        return v.getVisibility() == View.VISIBLE;
    }

    public static void toggleVisible(View v) {
        setVisibility(v, !isVisible(v));
    }

}
