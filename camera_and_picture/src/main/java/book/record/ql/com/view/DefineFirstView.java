package book.record.ql.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Administrator on 2017/6/15.
 */

public class DefineFirstView extends View {

    public final static int SMALL_HORIZONTAL_FRAME = 1;
    public final static int SMALL_VERTICAL_FRAME = 2;
    public final static int LARGE_VERTICAL_FRAME = 3;


    private int type = SMALL_HORIZONTAL_FRAME;
    private Paint backPaint = null;
    private Paint guideRectPaint = null;
    private Path backgroundPath = null;
    private Rect mGuide = null;


    public DefineFirstView(Context context, AttributeSet attrs){
        super(context,attrs);
        addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                backgroundPath = new Path();
                backgroundPath.addRect(new RectF(new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight())), Path.Direction.CCW);
                mGuide = getGuideFrame(getMeasuredWidth(), getMeasuredHeight());
                backgroundPath.addRect(new RectF(mGuide), Path.Direction.CW);
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();

        canvas.drawPath(backgroundPath , getBackPaint());

        Path linePath = new Path();
        linePath.lineTo(0,100);
        canvas.drawPath(linePath,getGuideRectPaint());
    }

    public void setType(int type){
        this.type = type;
    }

    private Rect getGuideFrame(int width,int height){
        if(width == 0 || height == 0){
            return null;
        }
        //绘制一个rect
        int trueWidth = 0;
        int trueHeight = 0;
        switch(type){
            case SMALL_HORIZONTAL_FRAME:
                trueWidth = (int)(width * 0.8);
                trueHeight = trueWidth *5/8;
                break;
            case SMALL_VERTICAL_FRAME:
                trueHeight = height *3/5;
                trueWidth = trueHeight *5/8;
                break;
            case LARGE_VERTICAL_FRAME:
                trueHeight = height*4/5;
                trueWidth = width *4/5;
                break;
        }
        int left = (width - trueWidth)/2;
        int top = (height - trueHeight)/2;
        return new Rect(left,top,left + trueWidth,top + trueHeight);
    }

    private Paint getBackPaint(){
        if(backPaint != null){
            return backPaint;
        }

        backPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backPaint.setColor(Color.BLUE);
        backPaint.setAlpha(200);//设置透明度
//        backPaint.setStyle(Paint.Style.FILL);//全部填充
        backPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        return backPaint;
    }

    private Paint getGuideRectPaint(){
        if(guideRectPaint != null){
            return guideRectPaint;
        }
        guideRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        guideRectPaint.setStyle(Paint.Style.STROKE);
        guideRectPaint.setStrokeWidth(20);
        guideRectPaint.setColor(Color.BLUE);
        return guideRectPaint;
    }
}
