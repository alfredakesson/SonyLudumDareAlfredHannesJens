package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.supercoolnamespace.hackgame.Entity;
import com.supercoolnamespace.hackgame.Offset;

public class SunEntity extends Entity{
	
	private final int SUN_RADIUS = 100;
	
	private Paint paint;
	
	private float width;
	private float height;
	
	public SunEntity(float width, float height){
		super(0,0);
		paint = new Paint();
		paint.setColor(Color.argb(255, 227, 224, 0));
		
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Canvas c, Offset theDrawOffset) {
		
		c.drawCircle((float) ((width-SUN_RADIUS) * Math.sin(rotation)) + width, (float) ((height-SUN_RADIUS) * Math.cos(rotation)) + height , SUN_RADIUS, paint);
		//theDrawOffset.getOffset(), 0);		
	}

}
