package book.record.ql.com.cameraandpicture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import book.record.ql.com.view.DefineFirstView;

public class DefineNewViewActivity extends AppCompatActivity {
    private DefineFirstView mDefineFirstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_new_view);

        mDefineFirstView = (DefineFirstView)findViewById(R.id.define_view);
        mDefineFirstView.setType(2);
    }
}
