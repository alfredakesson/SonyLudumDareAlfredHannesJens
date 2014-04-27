package entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.supercoolnamespace.hackgame.Entity;

public class BlueFabric extends Entity {

	private int offset = 300;
	
	public BlueFabric(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Canvas c) {
		Paint p = new Paint();
		p.setColor(Color.GREEN);
		c.drawRect(x, y, x+offset, y+200, p);
		p = new Paint();
		p.setColor(Color.BLUE);
		c.drawRect(x+120, y+50, x+260, y+150, p);
		
	}
	
	public int getOffset(){
		return offset;
	}

}
