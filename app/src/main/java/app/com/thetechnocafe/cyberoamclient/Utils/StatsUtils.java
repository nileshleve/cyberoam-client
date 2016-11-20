package app.com.thetechnocafe.cyberoamclient.Utils;

import android.content.Context;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.com.thetechnocafe.cyberoamclient.Common.RealmDatabase;
import app.com.thetechnocafe.cyberoamclient.Models.SessionLogModel;

/**
 * Created by gurleensethi on 20/11/16.
 */

public class StatsUtils {

    /**
     * Return the number of realm entries
     */
    public static int getTotalTimesLoggedIn(Context context) {
        //Calculate the number of entries from realm database
        return RealmDatabase.getInstance(context).getSessionLogs().size();
    }

    /**
     * Return the total amount of data consumed
     */
    public static double getTotalDataConsumed(Context context) {
        //Get list form database
        List<SessionLogModel> list = RealmDatabase.getInstance(context).getSessionLogs();

        double totalDataConsumed = 0.0;

        //Iterate the list and store the data
        for (SessionLogModel model : list) {
            totalDataConsumed += model.getDataConsumed();
        }

        //Convert to 2 decimal places
        return ((int) (totalDataConsumed * 100)) / 100.0;
    }

    /**
     * Return the total duration logged in
     */
    public static long getTotalDurationLoggedIn(Context context) {
        //Get list form database
        List<SessionLogModel> list = RealmDatabase.getInstance(context).getSessionLogs();

        long totalLoggedInTime = 0;

        //Iterate the list and store the data
        for (SessionLogModel model : list) {
            totalLoggedInTime += model.getLoggedInDuration();
        }


        return totalLoggedInTime;
    }

    /**
     * Get total data used today
     * Get the time in long for 12:00AM of the particular day
     * Check which logs logged in time more than the 12:00AM in millis
     */
    public static double getTotalDataUsedToday(Context context) {
        //Get time in millis
        long timeInLong = TimeUtils.getTodayTimeInMillis();

        //Get list of models
        List<SessionLogModel> list = RealmDatabase.getInstance(context).getSessionLogs();

        double totalDataConsumed = 0.0;

        //Iterate and get data
        for (SessionLogModel model : list) {
            if (model.getLoggedInTime() > timeInLong) {
                totalDataConsumed += model.getDataConsumed();
            }
        }

        //Convert to 2 decimal places
        return ((int) (totalDataConsumed * 100)) / 100.0;
    }

    /**
     * Get total enrollment id used
     */
    public static int getTotalEnrollmentIdUsed(Context context) {
        //Get list of models
        List<SessionLogModel> list = RealmDatabase.getInstance(context).getSessionLogs();

        Set<String> set = new HashSet<>();

        //Iterate and get id's
        for (SessionLogModel model : list) {
            set.add(model.getUsername());
        }

        return set.size();
    }
}
