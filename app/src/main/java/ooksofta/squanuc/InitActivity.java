package ooksofta.squanuc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class InitActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        getSharedPreferences(ApplicationConstants.SHARED_PREFERENCES_NAME, 0).registerOnSharedPreferenceChangeListener(this);


        
        // TODO go to login activity, not main
        // TODO encapsulate it
        SharedPreferences settings = getSharedPreferences(ApplicationConstants.SHARED_PREFERENCES_NAME, 0);
        boolean isLoggedIn = settings.getBoolean("isLoggedIn", false);
        if (!isLoggedIn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_init, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_logout) {
            Utils.putBoolean(this, "isLoggedIn", false);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("isLoggedIn")) {

            // TODO go to login activity, not main
            // TODO encapsulate it
            SharedPreferences settings = getSharedPreferences(ApplicationConstants.SHARED_PREFERENCES_NAME, 0);
            boolean isLoggedIn = settings.getBoolean("isLoggedIn", false);
            if (!isLoggedIn) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
