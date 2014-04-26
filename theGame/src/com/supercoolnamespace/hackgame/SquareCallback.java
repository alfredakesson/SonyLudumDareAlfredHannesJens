package com.supercoolnamespace.hackgame;

import android.util.Log;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;

public class SquareCallback implements TweenCallback {
	
	SquareEntity se;
	private GameLoop gameLoop;
	short iter = 0;

	public SquareCallback(SquareEntity se, GameLoop gameLoop) {
		super();
		this.se = se;
		this.gameLoop = gameLoop;
	}

	@Override
	public void onEvent(int arg0, BaseTween<?> arg1) {
		if(arg0 == 1){
			//gameLoop.newSqure();		
		}
		if(arg0 == 2){
			iter++;
			if( iter > 1)
				se.update(200f);
			if(iter == 2){
				gameLoop.newSqure();
				Log.d("Alfred", "Här kommer man ibland");
			}
			
		}
		if(arg0 == 8){
			se.hide();
			gameLoop.removeTopSqure();
		}
	}

}
