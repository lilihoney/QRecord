package com.qll.feng.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class NewProgressBarActivity extends Activity {

    String path = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_progress_bar);

        File file = new File(path);

    }


}
