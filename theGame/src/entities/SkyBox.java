package entities;

import com.supercoolnamespace.hackgame.Obscureable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;

public class SkyBox extends RectEntity implements Obscureable {

	private Paint paint, opacityPaint;
	
	private float opacity;
	
	
	public static final float OPACITY_DAY = 0;
	public static final float OPACITY_NIGHT = 250;
	
	

	public SkyBox(float x, float y, float width, float height, int color) {
		super(x, y, width, height);

		paint = new Paint();

		paint.setColor(Color.rgb(0, 108, 255));
		
		opacityPaint = new Paint();
		
		opacityPaint.setColor(Color.BLACK);
		
		//Shader shader = new LinearGradient(0, 0, width, 0, color, Color.BLUE, TileMode.MIRROR);
		//paint.setShader(shader);

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
