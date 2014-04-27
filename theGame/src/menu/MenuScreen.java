package menu;

import java.util.ArrayList;

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
	
	private ArrayList<MenuButton> buttons;

	public MenuScreen(Context context, MainThread callback) {
		super(context, callback);
		paint = new Paint();
		paint.setColor(Color.RED);
		backgroundPaint = new Paint();
		backgroundPaint.setColor(Color.BLACK);

		xOffset = (float) (0.9 * displaySize.y);

		xSize = displaySize.y - 2 * xOffset;
		
		
		this.callback = callback;
		
		textPaint = new Paint();
		textPaint.setTextSize(50);
		textPaint.setColor(Color.WHITE);
		
		buttons = new ArrayList<MenuButton>();
		
		for (int i = 0; i < 1; i++) {
			int top = 100 + 400 * i;
			
			buttons.add(new MenuButton(-30, -30, (int)xSize, 300, "start game", paint));
			//c.drawText("MUHUHU", xOffset, top, textPaint);
		}
		
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


		
		for(MenuButton mb : buttons){
			mb.draw(c);
		}

	}

}
