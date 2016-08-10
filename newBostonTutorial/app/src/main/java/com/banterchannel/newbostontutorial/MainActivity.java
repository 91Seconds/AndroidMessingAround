package com.banterchannel.newbostontutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout mainLayout = getRelativeLayout();
        setContentView(mainLayout);

    }
    @StringRes
    StringRes youSaid;

    @NonNull
    private RelativeLayout getRelativeLayout() {
        Button redButton = new Button(this);
        EditText userName = new EditText(this);
        redButton.setBackgroundColor(0xFF0011);
        redButton.setText("Fark");
        redButton.setAllCaps(false);

        redButton.setId(1);
        redButton.setOnClickListener(e -> {
            Intent i = new Intent(getApplicationContext(), GridActivity.class);
            startActivity(i);

            GridActivity next = new GridActivity();
            Log.i(TAG, "button clicked: userName=" + String.valueOf(userName.getText()));
            //next.onCreate(new Bundle());
        });
        userName.setId((2));

        RelativeLayout mainLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams UserNameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        UserNameDetails.addRule(RelativeLayout.ABOVE,redButton.getId());
        UserNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        UserNameDetails.setMargins(0,0,0,50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        Resources r = getResources();
        int px = (int)(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics()));
        userName.setWidth(px);

        mainLayout.addView(redButton, buttonDetails);
        mainLayout.addView(userName, UserNameDetails);

        return mainLayout;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }
}
