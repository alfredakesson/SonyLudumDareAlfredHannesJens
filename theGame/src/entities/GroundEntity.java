package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

import com.supercoolnamespace.hackgame.Entity;
import com.supercoolnamespace.hackgame.Offset;

public class GroundEntity extends Entity{
	
	private float width, height;
	
	private RectF oval;
	
	private Paint paint;

	public GroundEntity(float x, float y, float width, float height, float screenHeight) {
		super(x, y);
		
		float offset = (height - screenHeight)/2;
		oval = new RectF((int)x-width/2, (int)y-offset, (int)(x+width/2), (int)(y+height));
		
		
		paint = new Paint();
		
		paint.setColor(Color.rgb(222, 156, 28));
		
		//paint.setShader(new RadialGradient(0, 0, height/3, Color.BLACK, Color.rgb(179, 97, 39), Shader.TileMode.CLAMP));
	}

	@Override
	public void draw(Canvas c, Offset theDrawOffset) {
		
		oval.offset(theDrawOffset.getOffset(), 0);
		c.drawOval(oval, paint);
		oval.offset(-theDrawOffset.getOffset(), 0);
	}
	

}
