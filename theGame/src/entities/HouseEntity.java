package entities;

import android.graphics.Canvas;
import android.graphics.Matrix;

public class HouseEntity extends RectEntity{
	
	private Matrix drawMatrix;

	public HouseEntity(float x, float y, float width, float height) {
		super(x, y, width, height);
		drawMatrix = new Matrix();
	}

	@Override
	public void draw(Canvas c) {
		drawMatrix.reset();
		
		drawMatrix.setRotate(rotation);
		
		
		
	}

}
