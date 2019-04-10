package ee.brightapps.af;

import android.view.View;

public class AfView {

    public static void setVisibility(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

}
