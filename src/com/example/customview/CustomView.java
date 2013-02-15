package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class CustomView extends View {
	private int x;
	private int y;
	private Paint paint;
	private RectF rect;

	public CustomView(Context context) {
		super(context);
		x = 200;
		y = 200;
		rect = new RectF();
		paint = new Paint();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		rect.set(x,y,100,100);
		paint.setColor(Color.GREEN);
		canvas.drawRect(rect, paint);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
