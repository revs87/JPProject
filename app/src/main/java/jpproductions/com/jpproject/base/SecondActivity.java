package jpproductions.com.jpproject.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import jpproductions.com.jpproject.R;

/**
 * Created by Rui on 13/11/2015.
 */
public class SecondActivity extends Activity {

    //    /** Standard activity result: operation canceled. */
//    public static final int RESULT_CANCELED    = 0;
//    /** Standard activity result: operation succeeded. */
//    public static final int RESULT_OK          = -1;
    public static final String EXTRA_TROLLED_KEY = "heGotTrolled";

    private boolean heGotTrolled;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }

    private void init() {
        final TextView clickMe = (TextView) findViewById(R.id.clickMeTv);
        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMe.setText("TROLLED !!!");
                heGotTrolled = true;
            }
        });
        heGotTrolled = false;
    }

    @Override
    public void onBackPressed() {
        if (heGotTrolled) {
            Intent data = new Intent();
            data.putExtra(EXTRA_TROLLED_KEY, heGotTrolled);
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
