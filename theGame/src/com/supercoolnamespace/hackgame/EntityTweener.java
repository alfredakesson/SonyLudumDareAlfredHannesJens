package com.supercoolnamespace.hackgame;

import aurelienribon.tweenengine.TweenAccessor;

public class EntityTweener implements TweenAccessor<Entity> {

	public static final int POSITION_X = 1;
	public static final int POSITION_Y = 2;
	public static final int POSITION_XY = 3;
	public static final int ROTATION = 4;
	public static final int VAR = 5;
	public static final int X_AND_OPACITY = 6;

	@Override
	public int getValues(Entity target, int tweenType, float[] returnValues) {

		switch (tweenType) {
		case POSITION_X:
			returnValues[0] = target.getX();
			return 1;
		case POSITION_Y:
			returnValues[0] = target.getY();
			return 1;
		case POSITION_XY:
			returnValues[0] = target.getX();
			returnValues[1] = target.getY();
			return 2;
			
		case ROTATION:
			returnValues[0] = target.getRotation();
			return 1;
			
		case X_AND_OPACITY:
			returnValues[0] = target.getX();
			returnValues[1] = target.getOpacity();
			return 2;
			

		default:
			return -1;
		}
	}

	@Override
	public void setValues(Entity target, int tweenType, float[] newValues) {
		
		switch (tweenType) {
		case POSITION_X:
			target.setX(newValues[0]);
			break;
		case POSITION_Y:
			target.setY(newValues[1]);
			break;
		case POSITION_XY:
			target.setX(newValues[0]);
			target.setY(newValues[1]);
			break;
			
		case ROTATION:
			target.setRotation(newValues[0]);
			break;
		case X_AND_OPACITY:
			target.setX(newValues[0]);
			target.setOpacity(newValues[1]);
			
		default:
			break;
		}
	}

}
