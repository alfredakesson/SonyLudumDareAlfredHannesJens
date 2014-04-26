package entities;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.supercoolnamespace.hackgame.Entity;

public abstract class RectEntity extends Entity {

	protected RectF rectF;

	public RectEntity(float x, float y, float width, float height) {
		super(x, y);

		rectF = new RectF(x, y + height, x + width, y);
		
		

	}

	@Override
	public abstract void draw(Canvas c);
	
	

}
