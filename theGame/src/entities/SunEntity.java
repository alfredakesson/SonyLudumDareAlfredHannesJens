package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.supercoolnamespace.hackgame.Entity;

public class SunEntity extends Entity{
	
	private final int SUN_RADIUS = 30;
	
	private Paint paint;
	
	private float width;
	private float height;
	
	public SunEntity(float width, float height){
		super(0,0);
		paint = new Paint();
		paint.setColor(Color.argb(255, 255, 100, 100));
		
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Canvas c) {
		

		c.drawCircle((float) (width * Math.sin(rotation)) + width/2, (float) (height * Math.cos(rotation)) + height/2 , SUN_RADIUS, paint);
		
	}

}
