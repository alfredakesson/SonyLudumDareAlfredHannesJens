package entities;

import com.supercoolnamespace.hackgame.Obscureable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SkyBox extends RectEntity implements Obscureable {

	private Paint paint, opacityPaint;
	
	private float opacity;
	
	
	public static final float OPACITY_DAY = 0;
	public static final float OPACITY_NIGHT = 200;
	
	

	public SkyBox(float x, float y, float width, float height, int color) {
		super(x, y, width, height);

		paint = new Paint();

		paint.setColor(color);
		
		opacityPaint = new Paint();
		
		opacityPaint.setColor(Color.BLACK);

	}

	@Override
	public void draw(Canvas c) {
		c.drawRect(rectF, paint);
		c.drawRect(rectF, opacityPaint);
	}

	public void setOpacity(float newOpacity) {
		this.opacity = newOpacity;
		opacityPaint.setAlpha((int)newOpacity);
	}

	@Override
	public float getOpacity(){
		return opacity;
	}

}
