package ee.brightapps.af;

import android.support.annotation.NonNull;

import java.util.Arrays;

public class AfArrays {

    @SafeVarargs
    public static <T> T[] concat(T[] first, T... second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * @return -1 if Object object not fount in array
     */
    public static int indexOf(@NonNull Object object, Object... arr) {
        for (int i = 0; i < arr.length; i++) {
            if (object.equals(arr[i])) return i;
        }
        return -1;
    }

}
