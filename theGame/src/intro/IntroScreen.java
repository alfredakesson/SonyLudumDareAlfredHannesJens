package intro;

import com.supercoolnamespace.hackgame.MainThread;
import com.supercoolnamespace.hackgame.Screen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.view.MotionEvent;

public class IntroScreen extends Screen {

	private float timeLeft = 3f;

	private Paint paint;

	private String[] strings = { "One World", "Connected", "Under the", "Same Sun" };

	public boolean isDead = false;

	private Paint textPaint;

	private float timeLeftToChange = 0;

	private int currentString = 0;
	
	private int textOffsetX, textOffsetY;

	public boolean isDead() {
		return isDead;
	}

	public IntroScreen(Context context, MainThread callback) {
		super(context, callback);
		paint = new Paint();
		paint.setColor(Color.BLACK);

		textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setTextSize((float) (displaySize.x*0.3));

		timeLeftToChange = 2f;
		
		computeOffset();
	}
	


	public void draw(Canvas c, float delta) {

		timeLeftToChange -= delta;

		if (timeLeftToChange < 0) {

			if (currentString < strings.length-1) {
				currentString++;
				timeLeftToChange = 2f;
				computeOffset();
				
			}
		}
	
		c.drawRect(0, c.getHeight(), c.getWidth(), 0, paint);

		if(currentString %2 ==0){
			c.rotate(180, c.getWidth()/2, c.getHeight()/2);
		}
		
		c.rotate( 90);
		
		

		c.drawText(strings[currentString],textOffsetX,-textOffsetY, textPaint);
		
	

		c.rotate(-90);
		
		if(currentString %2 ==0){
			c.rotate(180, c.getWidth()/2, c.getHeight()/2);
		}
		
		

	}
	
	public void computeOffset(){
		Rect bounds = new Rect();
		textPaint.getTextBounds(strings[currentString], 0, strings[currentString].length(), bounds);
		textOffsetX =  displaySize.y/2 - bounds.width()/2;
		textOffsetY = displaySize.x/2 - bounds.height()/2;
	}


	public void touch(MotionEvent event) {
		callback.goToGame();
		isDead = true;

	}

}
