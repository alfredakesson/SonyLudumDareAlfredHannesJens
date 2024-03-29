package com.supercoolnamespace.hackgame;

import android.util.Log;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;

public class SquareCallback implements TweenCallback {

	SquareEntity se;
	private World world;
	short iter = 0;

	public SquareCallback(SquareEntity squareEntity, World world) {
		super();
		this.se = squareEntity;
		this.world = world;
	}

	@Override
	public void onEvent(int arg0, BaseTween<?> arg1) {
		if (arg0 == 1) {

		}
		if (arg0 == 2) {
			iter++;
			if (iter > 1)
				se.update(200f);
			if (iter == 2) {
				world.newSquare();
				Log.d("Alfred", "Här kommer man ibland");
			}

		}
		if (arg0 == 8) {
			if (se.hidden()) {
				Log.d("GAME OVER", "XXXX GAME OVER");

				
				if (world.share.currentWorld == World.UpperWorld){
					if (se.getColor() <= SquareEntity.BLUE_TRIANGLE ){
						world.share.sc.higherScore(se.getColor());
						world.drawOffset.increment(se.getColor());
					}
					else{ 
						world.share.sc.lowerScore(se.getColor() - 3);
						world.drawOffset.decrease(se.getColor() - 3);

					}
				}else{
					if (se.getColor() > SquareEntity.BLUE_TRIANGLE ){
						world.share.sc.higherScore(se.getColor() - 3);
						world.drawOffset.increment(se.getColor() - 3);
					}

					else{ 
						world.share.sc.lowerScore(se.getColor());
						world.drawOffset.decrease(se.getColor());
					}

				}
			} 

		} else {
			Log.d("GAME OVER", "XXXX STILL PLAYING!");
		}

		se.hide();
		//world.removeTopSquare();
	}
}
