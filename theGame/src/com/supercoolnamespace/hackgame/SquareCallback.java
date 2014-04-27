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
		if(arg0 == 1){
					
		}
		if(arg0 == 2){
			iter++;
			if( iter > 1)
				se.update(200f);
			if(iter == 2){
				world.newSquare();
				Log.d("Alfred", "Här kommer man ibland");
			}
			
		}
		if(arg0 == 8){
			if(se.hidden()) {
				Log.d("GAME OVER", "XXXX GAME OVER");
				
				if (world.share.currentWorld == World.UpperWorld){
					if (se.getColor() == SquareEntity.BLUE )
						world.share.sc.higherScore();
					else 
						world.share.sc.lowerScore();
					
				}else{
					if (se.getColor() != SquareEntity.BLUE )
						world.share.sc.higherScore();
					else 
						world.share.sc.lowerScore();
				}
					
			}
			else
			{
				Log.d("GAME OVER", "XXXX STILL PLAYING!");
			}
			
			if(world == null)
			{
				Log.d("WTF", "world is null");
			}
			else if(world.drawOffset == null){
				Log.d("WTF", "drawoffset is null");
			}
			
			if(world.share.currentWorld == world.UpperWorld) {
				if(se.getColor() == SquareEntity.BLUE) {
					world.drawOffset.increment();
				}
				else if(se.getColor() == SquareEntity.RED) {
					world.drawOffset.decrease();
				}
					
			}
			else {
				if(se.getColor() == SquareEntity.BLUE) {
					world.drawOffset.decrease();
				}
				else if(se.getColor() == SquareEntity.RED) {
					world.drawOffset.increment();
				}
			}
			
			
			se.hide();
			world.removeTopSquare();	
		}
	}

}
