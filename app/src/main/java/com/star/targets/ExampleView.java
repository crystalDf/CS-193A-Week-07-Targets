package com.star.targets;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ExampleView extends View {
    public ExampleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawARGB(255, 255, 90, 90);

        Paint aqua = new Paint();

        aqua.setARGB(255, 0, 80, 220);

        canvas.drawRect(new RectF(10, 30, 300, 700), aqua);
        canvas.drawRect(new RectF(400, 50, getWidth(), getHeight()), aqua);

        Paint font = new Paint();

        font.setARGB(255, 0, 0, 0);
        font.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC));
        font.setTextSize(40);

        canvas.drawText("CS 193A is great", 80, 200, font);

        Bitmap heart = BitmapFactory.decodeResource(getResources(), R.mipmap.heart);
        canvas.drawBitmap(heart, 0, 0, null);

        final Bitmap[] bitmap = {null};

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL(
                            "http://g.hiphotos.baidu.com/zhidao/pic/item/18d8bc3eb13533fac43ecfa0a8d3fd1f40345bb7.jpg");

                    bitmap[0] = BitmapFactory.decodeStream(url.openStream());

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bitmap[0], 200, 200, null);
    }
}
