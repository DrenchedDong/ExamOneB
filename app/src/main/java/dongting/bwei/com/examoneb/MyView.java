package dongting.bwei.com.examoneb;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;


public class MyView extends View {

    private Paint paint;
    private Paint paint1;
    private int rn;
    private String content;
    private String title;
    private int size;
    private int color;
    private Rect rect;
    private Paint werite;
    private int width;
    private int height;
    float x = 1080 / 2;
    float y = 1776 / 2 - 200;

    public void setTitle(String title) {
        this.title = title;
    }

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyView);
        title = a.getString(R.styleable.MyView_titleText);
        size = a.getDimensionPixelSize(R.styleable.MyView_titleTextSize, 20);
        color = a.getColor(R.styleable.MyView_titleTextColor, Color.WHITE);
        a.recycle();


        rect = new Rect();
        werite = new Paint();
        werite.setAntiAlias(true);
        werite.setStyle(Paint.Style.FILL);
        werite.setColor(color);
        werite.setTextSize(size);

        werite.getTextBounds(title, 0, title.length(), rect);

        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        WindowManager wm = (WindowManager) this.getContext().getSystemService(WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();

        System.out.println(width + "------------" + height);

        int r = 300;
        if (rn!=300){
            paint.setColor(Color.BLACK);
        }
        canvas.drawCircle(x, y, r, paint);

        canvas.drawCircle(x, y, rn, paint1);
        System.out.println(x + "---------" + y);
//        getHeight() / 2 + rect.height() / 2
        canvas.drawText(title, x, y, werite);

    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (rn == 300) {
                    x = event.getX();
                    y = event.getY();

                    System.out.println("x=" + x);
                    System.out.println("y=" + y);
                    paint.setColor(Color.WHITE);
                    invalidate();

                }
//                if (x > rect.left && x < rect.right && y > rect.top && y < rect.bottom) {
//
//                }

                break;
        }
        return true;
    }


     /* Paint paint ;
    private int x;
    private int y;
    private int max;
    private float textsize;
    private int progress;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        //paint.setColor(Color.GRAY);

        //drawCircle();

    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.RoundProgressBar);

        max = mTypedArray.getInteger(R.styleable.RoundProgressBar_max, 100);
        textsize = mTypedArray.getDimension(R.styleable.RoundProgressBar_textSize, 25);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        x = MeasureSpec.getSize(widthMeasureSpec)/2;
        y = MeasureSpec.getSize(heightMeasureSpec)/2;

    }

    int radio = 10 ;
    int maxRadio = 400 ;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.GRAY);
        canvas.drawCircle(x, y,maxRadio,paint);
        paint.reset();
        paint.setColor(Color.RED);
        canvas.drawCircle(x, y,radio,paint);

        progress = radio/maxRadio*100;

        postInvalidate();
        *//**
     * 画进度百分比
     *//*
        paint.setColor(Color.BLUE);
        paint.setTextSize(30);
        paint.setStrokeWidth(0);
        paint.setTypeface(Typeface.DEFAULT_BOLD); //设置字体
        //中间的进度百分比，先转换成float在进行除法运算，不然都为0
        //int percent = (int)(((float)progress / (float)max) * 100);
        //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
        float textWidth = paint.measureText(progress + "%");

            //画出进度百分比
            canvas.drawText(progress + "%", x - textWidth / 2, y + textsize / 2, paint);
    }

    public boolean isStop = true ;

    public void drawCircle(){

        new Thread(new Runnable() {

            @Override
            public void run() {

               while (isStop){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   if(radio != 400){
                       radio += 5 ;
                       postInvalidate();
                   }else {
                       isStop = false;
                   }
               }
            }
        }).start();
    }*/
}
