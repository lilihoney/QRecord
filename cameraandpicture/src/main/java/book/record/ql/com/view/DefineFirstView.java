package book.record.ql.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/6/15.
 */

public class DefineFirstView extends View {

    private static final int FIXED_HEIGHT = 5;
    private static final int FIXED_WIDTH = 8;

    private Paint framePaint;
    private Paint textPaint;
    private Paint backgroundPaint;
    private Path path;

    public DefineFirstView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private Paint getFramePaint(){
        if(framePaint != null){
            return framePaint;
        }
        framePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        framePaint.clearShadowLayer();
        framePaint.setColor(getResources().getColor(android.R.color.holo_red_dark));
        return framePaint;
    }

    private Paint getTextPaint(){
        if(textPaint != null){
            return textPaint;
        }
        textPaint = new Paint(Paint.FAKE_BOLD_TEXT_FLAG);
        return textPaint;
    }
}
