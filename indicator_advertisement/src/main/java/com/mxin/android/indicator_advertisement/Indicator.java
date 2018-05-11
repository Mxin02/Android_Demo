package com.mxin.android.indicator_advertisement;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 1\没有办法无限滚动
 * 2\自动滚动,当滚动到最后一个点的时候,会滚出范围
 * 3\代码没有进行封装
 *
 * 封装属性
 */
public class Indicator extends View{

    /**前景色的圆点**/
    private Paint mForePaint;
    /**背景色的圆点**/
    private Paint mBgPaint;
    /**Indicator数量**/
    private int mNumber = 4;
    /**Indicator半径**/
    private int mRadius = 10;
    /**Indicator的背景色画笔颜色**/
    private int mBgColor = Color.RED;
    /**Indicator的前景色画笔颜色**/
    private int mForeColor = Color.BLUE;

    /**移动的偏移量**/
    private float mOffset;

    /***
     * 设置偏移量的方法
     */
    public void setOffset(int position, float positionOffset) {

        position %= mNumber;
        mOffset = position * 3 * mRadius + positionOffset * 3 * mRadius;
        //重绘
        invalidate();
    }

    public Indicator(Context context) {
        super(context);
    }

    public Indicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();

        //找到自定义封装的属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Indicator);
        mNumber = typedArray.getInteger(R.styleable.Indicator_setNumber,mNumber);
    }


    private void initPaint() {
        //初始化前景色画笔
        mForePaint = new Paint();
        mForePaint.setAntiAlias(true);
        mForePaint.setStyle(Paint.Style.FILL);
        mForePaint.setColor(mForeColor);
        mForePaint.setStrokeWidth(2);



        //初始化背景色画笔
        mBgPaint = new Paint();
        mBgPaint.setAntiAlias(true);
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setColor(mBgColor);
        mBgPaint.setStrokeWidth(2);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i<mNumber ;i++){

            canvas.drawCircle(60 + i * mRadius * 3,60,mRadius,mBgPaint);
        }
        canvas.drawCircle(60 + mOffset,60,mRadius,mForePaint);
    }

}
