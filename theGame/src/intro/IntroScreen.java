package intro;

import com.supercoolnamespace.hackgame.MainThread;
import com.supercoolnamespace.hackgame.Screen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable.Callback;
import android.view.MotionEvent;

public class IntroScreen extends Screen{

	private float timeLeft = 3f;

	private Paint paint;
	
	public boolean isDead = false;
	
	
	public boolean isDead(){
		return isDead;
	}
	
	public IntroScreen(Context context, MainThread callback){
		super(context, callback);
		paint = new Paint();
		paint.setColor(Color.BLACK);
	}

	public void draw(Canvas c, float delta){
		timeLeft -= delta;
		if(timeLeft < 0){
			isDead = true;
			return;
		}
		
		c.drawRect(0, c.getHeight(), c.getWidth(), 0, paint);
	}

	public void touch(MotionEvent event) {
		callback.goToGame();
		isDead = true;
		
	}

}
