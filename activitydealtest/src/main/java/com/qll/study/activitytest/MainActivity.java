package com.qll.study.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_CODE = 1;
    private Button mFinish = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "in onCreate----------");
        setContentView(R.layout.activity_main);

        mFinish = (Button)findViewById(R.id.btn_start);

        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, TestFinishActivity.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "is onResume-----------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "is onPause------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "is onStart------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "is onStop--------------");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "is onDestroy-----------");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case TestFinishActivity.RESULT_CANCEL:
                Log.e(TAG, "onActivity Result resultCode is cancel");
                break;
            case  TestFinishActivity.RESULT_ERROR:
                Log.e(TAG, "onActivity Result resultCode is error");
                break;
            case TestFinishActivity.RESULT_SUCCESS:
                Log.e(TAG, "onActivity Result resultCode is error");
                break;
            default:
                Log.e(TAG, "onActivity Result default");
                break;
        }
    }
}
