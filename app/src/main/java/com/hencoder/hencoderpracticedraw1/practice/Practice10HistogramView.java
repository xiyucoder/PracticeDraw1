package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.TableModel;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    List<TableModel> tableModels = new ArrayList<>();

    {
        tableModels.add(new TableModel("Froyo",0.01));
        tableModels.add(new TableModel("GB",0.05));
        tableModels.add(new TableModel("ICS", 0.05));
        tableModels.add(new TableModel("JB",0.6));
        tableModels.add(new TableModel("KitKat",0.8));
        tableModels.add(new TableModel("L", 0.9));
        tableModels.add(new TableModel("M", 0.55));

    }
    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        float lineTopX = 100;
        float lineTopY = height*3/4;
        float lineBottomX = width-100;
        float lineBottomY = height*3/4;
        float blank = 20;
        float distance = ((lineBottomX-100)-(tableModels.size()+1)*blank)/tableModels.size();

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        //画坐标轴
        path.moveTo(100,50);
        path.lineTo(lineTopX, lineTopY);
        path.lineTo(lineBottomX,lineBottomY);
        canvas.drawPath(path,paint);

        //画圆柱
        RectF rectF;
        RectF rectText;

        for (int i =0;i<tableModels.size();i++){
            TableModel tableModel = tableModels.get(i);
            float left = 100+(i+1)*blank+i*distance;
            float top =(float) (lineBottomY-(lineTopY-50)*tableModel.percent);
            float right = left+distance;
            float bottom = lineBottomY;
            paint.setColor(Color.GREEN);
            paint.setStyle(Paint.Style.FILL);
            rectF = new RectF(left,top,right,bottom);
            canvas.drawRect(rectF,paint);
            rectText = new RectF(left,bottom,right,bottom+30);
            setTextView(tableModel,canvas,paint,rectText);
        }

    }

    private void setTextView(TableModel tableModel, Canvas canvas, Paint paint, RectF rectText) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.TRANSPARENT);
        canvas.drawRoundRect(rectText, 0, 0, paint);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(24);
        String res = tableModel.name;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float baseline = rectText.centerY() - (fontMetrics.top / 2) - (fontMetrics.bottom / 2);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(res, rectText.centerX(), baseline, paint);


    }
}
