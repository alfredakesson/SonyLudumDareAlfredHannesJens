package entities;

import com.supercoolnamespace.hackgame.Colorable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SkyBox extends RectEntity implements Colorable {

	private Paint paint;
	
	private float red, green, blue;

	public SkyBox(float x, float y, float width, float height, int color) {
		super(x, y, width, height);

		paint = new Paint();
		
		red = Color.red(color);
		green = Color.green(color);
		blue = Color.blue(color);

		paint.setColor(color);

	}

	@Override
	public void draw(Canvas c) {
		c.drawRect(rectF, paint);
	}

	public void setColors(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		paint.setColor(Color.rgb((int)red, (int)green, (int)blue));
	}

	@Override
	public float getRed() {

		return red;
	}

	@Override
	public float getGreen() {
		return green;
	}

	@Override
	public float getBlue() {
		return blue;
	}

}
