package com.qll.feng.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.targetClass;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    private ListView targetList = null;
    private static final TargetDemo[] targetDemos = new TargetDemo[]{
            new TargetDemo("NewProgressBarActivity",R.string.new_progress_bar,NewProgressBarActivity.class),
            new TargetDemo("ImageViewActivity",R.string.image_view_test,ImageViewActivity.class)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        targetList = (ListView)findViewById(R.id.list_activites);
        targetList.setAdapter(new TargetListAdapter());
        targetList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,targetDemos[position].targetClass));
            }
        });

    }


    public static class TargetDemo{
        private final String demoName;
        private final int desc;
        private Class<? extends Activity> targetClass;

        public TargetDemo(String demoName,int desc,Class<? extends Activity> targetClass){
            this.demoName = demoName;
            this.desc = desc;
            this.targetClass = targetClass;
        }
    }

    private class TargetListAdapter extends BaseAdapter{
        public TargetListAdapter(){
            super();
        }

        @Override
        public int getCount() {
            return targetDemos.length;
        }

        @Override
        public Object getItem(int position) {
            return targetDemos[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = View.inflate(MainActivity.this,R.layout.list_item,null);
            TextView tv_title = (TextView)convertView.findViewById(R.id.tv_name);
            tv_title.setText(targetDemos[position].demoName);
            return convertView;
        }
    }
}
