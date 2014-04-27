package com.supercoolnamespace.hackgame;

import android.content.Context;

public class BackSquare extends SquareEntity {

	private float whith;

	public BackSquare(Context ctx, float x, float y, float whith) {
		super(ctx, x, y);
		this.whith= whith;
	}
	
	protected  float getRealY() {
		return whith - (y + fill);
	}

}
