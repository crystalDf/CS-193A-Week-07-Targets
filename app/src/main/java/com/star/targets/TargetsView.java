package com.star.targets;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TargetsView extends View {
    public TargetsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint red = new Paint();
        red.setARGB(255, 255, 0, 0);

        Paint white = new Paint();
        white.setARGB(255, 255, 255, 255);

        for (int i = 0; i < 5; i++) {
            canvas.drawOval(new RectF(getWidth() * i / 10, getHeight() * i / 10,
                    getWidth() * (10 - i) / 10, getHeight() * (10 - i) / 10),
                    ((i % 2) == 0) ? red : white);
        }
    }
}
