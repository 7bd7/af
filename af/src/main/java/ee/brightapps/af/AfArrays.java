package ee.brightapps.af;

import android.support.annotation.NonNull;

import java.util.Arrays;

public class AfArrays {

    /**
     * Concat N arrays (or array and any number of objects) of any <b>Object</b> subclass together in the order of adding as parameters
     */
    @SafeVarargs
    public static <T> T[] concat(T[] first, T... second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * Concat two arrays (or array and any number of objects) of <b>int</b> together in the order of adding as parameters
     */
    public static int[] concat(int[] first, int... second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * Concat two arrays (or array and any number of objects) of <b>long</b> together in the order of adding as parameters
     */
    public static long[] concat(long[] first, long... second) {
        long[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * Concat two arrays (or array and any number of objects) of <b>float</b> together in the order of adding as parameters
     */
    public static float[] concat(float[] first, float... second) {
        float[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * Concat two arrays (or array and any number of objects) of <b>double</b> together in the order of adding as parameters
     */
    public static double[] concat(double[] first, double... second) {
        double[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * Concat two arrays (or array and any number of objects) of <b>boolean</b> together in the order of adding as parameters
     */
    public static boolean[] concat(boolean[] first, boolean... second) {
        boolean[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static int indexOf(@NonNull Object object, Object... arr) {
        for (int i = 0; i < arr.length; i++) {
            if (object.equals(arr[i])) return i;
        }
        return -1;
    }

}
