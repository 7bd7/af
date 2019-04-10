package ee.brightapps.af;

public class AfTime {

    /**
     * Convert millis to human readable time period string, i.e. 3 d. 3:10:15
     */
    public static String toReadablePeriod(long millis) {
        // NOT TESTED CODE SNIPPED - TEST IT!
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = millis / daysInMilli;
        millis = millis % daysInMilli;

        long elapsedHours = millis / hoursInMilli;
        millis = millis % hoursInMilli;

        long elapsedMinutes = millis / minutesInMilli;
        millis = millis % minutesInMilli;

        long elapsedSeconds = millis / secondsInMilli;

        return elapsedDays + "d." + elapsedHours + ":" + elapsedMinutes + ":" + elapsedSeconds;
    }

}
