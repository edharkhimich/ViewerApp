package kdevgroup.com.viewerapp.title;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import kdevgroup.com.viewerapp.R;
import kdevgroup.com.viewerapp.common.FragmentFactory;

public class TitleActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        FragmentFactory.changeFragment(getSupportFragmentManager(), R.id.container, new TitleFragment(), false, null);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        doubleBackToExitPressedOnce = true;

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 1000);
    }
}

