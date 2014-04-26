package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SkyBox extends RectEntity{
	
	private Paint paint;

	public SkyBox(float x, float y, float width, float height, int color) {
		super(x, y, width, height);
		
		paint = new Paint();
		
		paint.setColor(color);
		
	}

	@Override
	public void draw(Canvas c) {
		c.drawRect(rectF, paint);
		
	}

	
	
}
