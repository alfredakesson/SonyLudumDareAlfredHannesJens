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
		c.drawRect(x + theDrawOffset.getOffset(), y, x+300 + theDrawOffset.getOffset(), y+200, p);

	}

}
