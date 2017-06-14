package book.record.ql.com.qrecord;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.lang.annotation.AnnotationFormatError;
import java.util.List;

import book.record.ql.com.utils.FileUtils;

public class MainActivity extends Activity {
    private final static String ROOT_PATH = Environment.getExternalStorageDirectory().getPath();
    private final static String QR_FILE_PATH = ROOT_PATH + "/qllrecord/";
    private TextView tvAllNames;
    private Button btnCreateFile;
    private ImageView img_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAllNames = (TextView)findViewById(R.id.tv_play_files_name);
        btnCreateFile = (Button)findViewById(R.id.btn_create_file);
        img_picture = (ImageView)findViewById(R.id.imageView);
        setImagePicture(ROOT_PATH + "/sensetime/0.jpg");


        List<String> oriFiles = FileUtils.getFilesName(ROOT_PATH + "/sensetime/");
        tvAllNames.setText(ROOT_PATH +"/senstime\n"+getAllFilesName(oriFiles));

        btnCreateFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*//create new folder
                FileUtils.createFile(QR_FILE_PATH);
                FileUtils.createFile(QR_FILE_PATH+"/test.jpg");

                List<String> afterFiles = FileUtils.getFilesName(Environment.getExternalStorageDirectory().getPath());
                tvAllNames.setText(QR_FILE_PATH + "\n" +getAllFilesName(afterFiles));
                btnCreateFile.setEnabled(false);*/
                setImagePicture(ROOT_PATH + "/sensetime/cut.jpg");
            }
        });


    }


    private String getAllFilesName(List<String> filesList){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < filesList.size();i++){
            stringBuffer.append("\n"+filesList.get(i));
        }
        return stringBuffer.toString();
    }

    private void setImagePicture(String filePath){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bm = BitmapFactory.decodeFile(filePath,options);
        img_picture.setImageBitmap(bm);
    }
}
