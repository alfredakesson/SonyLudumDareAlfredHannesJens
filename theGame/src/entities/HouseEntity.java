package entities;

import com.supercoolnamespace.hackgame.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
	private Context ctx;
	private Bitmap building;
	private boolean drawTheScreen = true;

	public HouseEntity(Context ctx, float x, float y, float width, float height) {
		super(x, y, width, height);
		this.ctx = ctx;
		drawMatrix = new Matrix();
		
		path = new Path();
		
		this.paint = new Paint();
		
		paint.setColor(Color.BLACK);
		
		building= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.building_01);
		
		building = getResizedBitmap(building, 40*height, 40*width);
		 
		
		
	}
	
	

	@Override
	public void draw(Canvas c) {
		if (drawTheScreen)
			c.drawBitmap(building, x, y, null);
			
		
		
		
		
		
		
		
		
//		
//		drawMatrix.reset();
//	
//		drawMatrix.setRotate(rotation, x + rectF.width()/2, y - rectF.height()/2);
//		path.reset();
//		path.addRect(rectF, Direction.CW);
//		path.transform(drawMatrix);
//		
//		c.drawPath(path, paint);
//		
		
	}
	public Bitmap getResizedBitmap(Bitmap bm, float newHeight, float newWidth) {
		 
		int width = bm.getWidth();
		 
		int height = bm.getHeight();
		 
		float scaleWidth = ((float) newWidth) / width;
		 
		float scaleHeight = ((float) newHeight) / height;
		 
		// CREATE A MATRIX FOR THE MANIPULATION
		 
		Matrix matrix = new Matrix();
		 
		// RESIZE THE BIT MAP
		 
		matrix.postScale(scaleWidth, scaleHeight);
		 
		// RECREATE THE NEW BITMAP
		 
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
		 
		return resizedBitmap;
		 
		}

}
