package book.record.ql.com.qrecord;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.text.BoringLayout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import book.record.ql.com.utils.DisplayUtil;
import book.record.ql.com.utils.FileUtils;

import static android.R.attr.x;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends Activity {
    private final static String ROOT_PATH = Environment.getExternalStorageDirectory().getPath();
    private final static String QR_FILE_PATH = ROOT_PATH + "/qllrecord/";
    private TextView tvAllNames,tvScreen;
    private Button btnCreateFile;
    private ImageView img_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAllNames = (TextView)findViewById(R.id.tv_play_files_name);
        btnCreateFile = (Button)findViewById(R.id.btn_create_file);
        img_picture = (ImageView)findViewById(R.id.imageView);

        List<String> oriFiles = FileUtils.getFilesName(ROOT_PATH + "/imagetest/");
        tvAllNames.setText(ROOT_PATH +"/imagetest\n"+getAllFilesName(oriFiles));

        int i = 0;
        btnCreateFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*//create new folder
                FileUtils.createFile(QR_FILE_PATH);
                FileUtils.createFile(QR_FILE_PATH+"/test.jpg");

                List<String> afterFiles = FileUtils.getFilesName(Environment.getExternalStorageDirectory().getPath());
                tvAllNames.setText(QR_FILE_PATH + "\n" +getAllFilesName(afterFiles));
                btnCreateFile.setEnabled(false);*/
                setImagePicture(ROOT_PATH + "/imagetest/cut.jpg");
            }
        });


        tvScreen = (TextView)findViewById(R.id.tv_screen);
        // tvScreen.getTextSize()返回的是pixels
        tvScreen.setTextSize(18);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();

        StringBuffer screenBuffer = new StringBuffer();
        screenBuffer.append("density = "+ dm.density+"\n"
                +"densityDpi = " + dm.densityDpi + "\n widthPixels = "+ dm.widthPixels
                +"\n heightPixels = " + dm.heightPixels
                + "\n xdpi = " + dm.xdpi + "\n ydpi = " + dm.ydpi
                + "\n scaledDensity = " + dm.scaledDensity
                + "\n screenWidth = " + display.getWidth()
                + "\n screenHeight = " + display.getHeight()
                + "\n xdp = " + DisplayUtil.pxToDp(this,dm.xdpi)
                + "\n ydp = " + DisplayUtil.pxToDp(this,dm.xdpi)
                + "\n text size is = " +tvScreen.getTextSize()
                + "\n text px to sp = " + DisplayUtil.pxToSp(this,tvScreen.getTextSize()));
        tvScreen.setText(screenBuffer.toString());

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
