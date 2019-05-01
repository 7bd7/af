package ee.brightapps.af;

public class Af {

    private static int sCode = 1;

    public static int code() {
        return sCode++;
    }

}
