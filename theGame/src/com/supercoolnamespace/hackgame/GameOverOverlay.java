package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class GameOverOverlay extends Screen {
	
	private final int STATE_FIRST = 1;
	
	private final int STATE_SECOND = 2;

	private float timeLeft = 3f;

	private Paint paint;

	private String[] strings = { "One World", "Connected", "Yes" };

	public boolean isDead = false;

	private Paint textPaint;

	private float timeLeftToChange = 0;
	
	private int textOffsetX, textOffsetY;
	
	private String winString;
	
	private String playAgainString = "Play Again?";
	
	private int currentState;

	public boolean isDead() {
		return isDead;
	}

	public GameOverOverlay(Context context, MainThread callback, int boxes) {
		super(context, callback);
		paint = new Paint();
		paint.setColor(Color.BLACK);

		textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setTextSize((float) (displaySize.x*0.3));

		timeLeftToChange = 2f;
		
		winString = boxes + " boxes";
		
		currentState = STATE_FIRST;
		
		computeOffset(winString);
	}
	


	public void draw(Canvas c, float delta) {

		timeLeftToChange -= delta;

		if (timeLeftToChange < 0&& currentState == STATE_FIRST) {

				timeLeftToChange = 2f;
				computeOffset(playAgainString);
				currentState = STATE_SECOND;
	
		}
	
		c.drawRect(0, c.getHeight(), c.getWidth(), 0, paint);

		if(currentState == STATE_SECOND){
			c.rotate(180, c.getWidth()/2, c.getHeight()/2);
		}
		
		c.rotate( 90);
		
		
		if(currentState == STATE_FIRST){
			c.drawText(winString,textOffsetX,-textOffsetY, textPaint);
		} else {
			c.drawText(playAgainString,textOffsetX,-textOffsetY, textPaint);
		}
	

		c.rotate(-90);
		
		if(currentState == STATE_SECOND){
			c.rotate(180, c.getWidth()/2, c.getHeight()/2);
		}
		
		

	}
	
	public void computeOffset(String compString){
		Rect bounds = new Rect();
		textPaint.getTextBounds(compString, 0, compString.length(), bounds);
		textOffsetX =  displaySize.y/2 - bounds.width()/2;
		textOffsetY = displaySize.x/2 - bounds.height()/2;
	}


	public void touch(MotionEvent event) {
		callback.goToGame();
		isDead = true;

	}

}

