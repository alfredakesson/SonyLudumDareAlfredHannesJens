package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

import com.supercoolnamespace.hackgame.Entity;

public class GroundEntity extends Entity{
	
	private float width, height;
	
	private RectF oval;
	
	private Paint paint;

	public GroundEntity(float x, float y, float width, float height) {
		super(x, y);
		oval = new RectF((int)x-width/2, (int)y, (int)(x+width/2), (int)(y+height));
		
		
		paint = new Paint();
		
		paint.setShader(new RadialGradient(0, 0, height/3, Color.BLACK, Color.rgb(179, 97, 39), Shader.TileMode.CLAMP));
	}

	@Override
	public void draw(Canvas c) {
		
		
		c.drawOval(oval, paint);
		
	}
	

}
