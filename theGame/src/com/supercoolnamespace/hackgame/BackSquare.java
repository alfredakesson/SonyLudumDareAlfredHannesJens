package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.util.Log;

public class BackSquare extends SquareEntity {

	private float whith;

	public BackSquare(Context ctx, float x, float y, float whith, int color) {
		super(ctx, x, y, color);
		this.whith= whith;
	}
	
	protected  float getRealY() {
		Log.d("Alfred", "the y: " + y);
		return whith - (y + fill);
	}

}
