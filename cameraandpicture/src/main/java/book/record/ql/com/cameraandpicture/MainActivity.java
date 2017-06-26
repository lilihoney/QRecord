package book.record.ql.com.cameraandpicture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView demoList;
    private List<String> openList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoList = (ListView)findViewById(R.id.lv_demo_list);
        demoList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData()));
        demoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,DefineNewViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,DefineButtonActivity.class));                        break;
                }
            }
        });
    }

    private List<String> getData(){
        if(openList == null){
            openList = new ArrayList<String>();
        }
        openList.add("DefineViewActivity");
        openList.add("DefineButtonActivity");

        return openList;
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        demoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class<?> targetClass = null;
                switch(position){
                    case 0:
                        targetClass = DefineNewViewActivity.class;
                        break;
                    case 1:
                        targetClass = DefineButtonActivity.class;
                        break;
                }
                if(targetClass != null){
                    startActivity(new Intent(MainActivity.this,targetClass.getClass()));
                }
            }
        });
    }*/
}
