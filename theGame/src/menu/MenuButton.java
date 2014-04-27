package menu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class MenuButton {

	private Rect rect;

	private Paint paint;
	
	private String text;
	
	private Paint textPaint;
	
	private int textOffset;

	public MenuButton(int x, int y, int width, int height, String text,  Paint paint) {
		rect = new Rect(x, y, x + width, y + height);
		this.paint = paint;
		
		textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setTextSize(height - 50);
		
		this.text = text;
		
		Rect bounds = new Rect();
		
		textPaint.getTextBounds(text, 0, text.length(), bounds);
		
	}

	public void draw(Canvas c) {
		c.rotate(90);
		
		c.drawRect(rect, paint);
		
		
		c.drawText(text, rect.left, rect.top, textPaint);

		c.rotate(-90);
	}

}
