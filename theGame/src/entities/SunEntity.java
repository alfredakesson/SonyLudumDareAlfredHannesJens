package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.supercoolnamespace.hackgame.Entity;

public class SunEntity extends Entity{
	
	private final int SUN_RADIUS = 30;
	
	private Paint paint;
	
	public SunEntity(){
		paint = new Paint();
		paint.setColor(Color.argb(255, 255, 100, 100));
	}

	@Override
	public void draw(Canvas c) {
		c.drawCircle(x, y, SUN_RADIUS, paint);
		
	}

}
