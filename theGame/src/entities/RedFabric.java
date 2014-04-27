package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.supercoolnamespace.hackgame.Entity;
import com.supercoolnamespace.hackgame.Offset;

public class RedFabric extends Entity {

	public RedFabric(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Canvas c, Offset theDrawOffset) {
		Paint p = new Paint();
		p.setColor(Color.rgb(20, 20, 20));
		c.drawRect(x, y, x+300, y+200, p);
		p = new Paint();
		//p.setColor(Color.RED);
		//c.drawRect(x+40, y+50, x+180, y+150, p);
	}

}
