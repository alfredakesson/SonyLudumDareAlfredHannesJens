package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;

public class HouseEntity extends RectEntity{
	
	private Matrix drawMatrix;
	
	private Path path;
	
	private Paint paint;

	public HouseEntity(float x, float y, float width, float height) {
		super(x, y, width, height);
		drawMatrix = new Matrix();
		
		path = new Path();
		
		this.paint = new Paint();
		
		paint.setColor(Color.BLACK);
		
		
	}

	@Override
	public void draw(Canvas c) {
		
		// Funkar f�r att g�ra en roterad rectF, men �r inte s� bra att g�ra det varje g�ng den ska ritas ut
		//G�r mer effektivt!!
		drawMatrix.reset();
	
		drawMatrix.setRotate(rotation, x + rectF.width()/2, y - rectF.height()/2);
		path.reset();
		path.addRect(rectF, Direction.CW);
		path.transform(drawMatrix);
		
		c.drawPath(path, paint);
		
		
	}

}
