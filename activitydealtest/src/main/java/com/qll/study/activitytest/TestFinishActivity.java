package com.qll.study.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestFinishActivity extends AppCompatActivity {

    private static final String TAG = "finish_Test";

    public static final int RESULT_CANCEL = 2;
    public static final int RESULT_ERROR = 3;
    public static final int RESULT_SUCCESS = 4;

    private Button mFinish = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, TAG +  "is onCreate----------");

        setContentView(R.layout.activity_test_finish);

        mFinish = (Button)findViewById(R.id.btn_back);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, TAG +  "   ----setResult----------");
                setResult(RESULT_SUCCESS);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, TAG +  " start call onPause ----------");
        setResult(RESULT_CANCEL);
        if(!isFinishing()){
            Log.e(TAG, "  ------isFinishing is false when onPause");
            finish();
        }else{
            Log.e(TAG, TAG +  "  -----is finishing when onPause");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, TAG +  "is onDestroy----------");
    }
}
