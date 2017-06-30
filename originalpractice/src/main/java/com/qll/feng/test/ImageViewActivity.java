package com.qll.feng.test;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {
    private final static String TAG = "imageview_test";
    private ImageView mImageOne,mImageTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mImageOne = (ImageView)findViewById(R.id.image_first);
        mImageTwo = (ImageView)findViewById(R.id.image_second);

        if(mImageTwo.getDrawable() == null){
            Log.e(TAG,"mImageView.getDrawable() 为空");
            AnimationDrawable aDrawable = (AnimationDrawable)(mImageTwo.getDrawable());
            if(aDrawable != null){
                aDrawable.start();

            }else{
                Log.e(TAG,"aDrawable 初始化失败");
            }
        }

        mImageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageTwo.setImageDrawable(mImageOne.getDrawable());
            }
        });
    }
}
