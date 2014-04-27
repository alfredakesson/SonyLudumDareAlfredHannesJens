package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.supercoolnamespace.hackgame.Entity;

public class RedFabric extends Entity {

	public RedFabric(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Canvas c) {
		Paint p = new Paint();
		p.setColor(Color.GREEN);
		c.drawRect(x, y, x+300, y+200, p);
		p = new Paint();
		p.setColor(Color.RED);
		c.drawRect(x+40, y+50, x+180, y+150, p);
	}

}
