package ooksofta.squanuc;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by jsanchez on 9/14/15.
 */
public class Utils {

    public static void putBoolean(Activity activity, String key, boolean newValue) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(ApplicationConstants.SHARED_PREFERENCES_NAME, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, newValue);
        edit.commit();
    }
}
