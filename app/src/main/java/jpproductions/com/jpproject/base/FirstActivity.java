package jpproductions.com.jpproject.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import jpproductions.com.jpproject.R;

/**
 * Created by Rui on 13/11/2015.
 */
public class FirstActivity extends Activity {

    private LinearLayout firstLl;
    private Activity activity;
    private TextView firstButton;
    private final int REQUEST_CODE = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        activity = this;

        firstLl = (LinearLayout) findViewById(R.id.firstLl);


        /* Buttons */
        firstButton = (Button) findViewById(R.id.firstButton);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearView();
            }
        });
        Button secondButton = (Button) findViewById(R.id.secondButton);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


        /* Boxs */
        View firstView = findViewById(R.id.firstView);
        firstView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boxClickImpl(R.layout.layout_box_first);
            }
        });
        View secondView = findViewById(R.id.secondView);
        secondView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boxClickImpl(R.layout.layout_box_second);
            }
        });
        View thirdView = findViewById(R.id.thirdView);
        thirdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boxClickImpl(R.layout.layout_box_third);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*  */
        if (requestCode == REQUEST_CODE
                && data != null) {

            boolean heGotTrolled = data.getBooleanExtra(SecondActivity.EXTRA_TROLLED_KEY, false);

            if (heGotTrolled) {
                trollImpl();
            }
        }
    }

    /*-------------------------------------------------------------------------*/

    private void trollImpl() {
        firstButton.setText("Clean");

        LayoutInflater inflater = LayoutInflater.from(this);
        View trolledViewInflated = inflater.inflate(R.layout.layout_trolled, null);

        firstLl.addView(trolledViewInflated);
    }

    private void boxClickImpl(int res) {
        clearView();
        firstButton.setText("Clean");

        LayoutInflater inflater = LayoutInflater.from(activity);
        View trolledViewInflated = inflater.inflate(res, null);

        firstLl.addView(trolledViewInflated);
    }

    private void clearView() {
        firstLl.removeAllViews();
        firstButton.setText("Cleaned");
    }
}
