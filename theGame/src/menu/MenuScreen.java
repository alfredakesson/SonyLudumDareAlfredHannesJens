package menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.supercoolnamespace.hackgame.MainThread;
import com.supercoolnamespace.hackgame.Screen;

public class MenuScreen extends Screen {

	private Rect menuButton;

	private Paint paint, textPaint;
	private Paint backgroundPaint;

	private float xOffset, xSize;
	

	public MenuScreen(Context context, MainThread callback) {
		super(context, callback);
		paint = new Paint();
		paint.setColor(Color.RED);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(Color.BLACK);

		xOffset = (float) (0.9 * displaySize.x);

		xSize = displaySize.x - 2 * xOffset;
		
		
		this.callback = callback;
		
		textPaint = new Paint();
		textPaint.setTextSize(50);
		textPaint.setColor(Color.WHITE);
		
	}

	public void touch(MotionEvent event) {
		callback.goToMovie();
		System.out.println("change!!");
	}

	public boolean isDead() {

		return false;
	}

	public void draw(Canvas c, float delta) {
		c.drawRect(0, 0, c.getWidth(), c.getHeight(), backgroundPaint);

		for (int i = 0; i < 3; i++) {
			int top = 100 + 200 * i;
			c.drawRect(xOffset, top, xOffset + xSize, top - 100, paint);
			c.drawText("MUHUHU", xOffset, top, textPaint);
		}

	}

}
