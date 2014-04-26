package com.supercoolnamespace.hackgame;

import aurelienribon.tweenengine.TweenAccessor;

public class ColorTweener implements TweenAccessor<Colorable> {
	
	public final static int TWEEN_COLORS = 1;

	@Override
	public int getValues(Colorable target, int tween, float[] returnValues) {
		switch (tween) {
		case TWEEN_COLORS:
			returnValues[0] = target.getRed();
			returnValues[1] = target.getGreen();
			returnValues[2] = target.getBlue();
			return 1;

		default:
			break;
		}
		return 0;
	}

	@Override
	public void setValues(Colorable target, int tween, float[] newValues) {
		switch (tween) {
		case TWEEN_COLORS:
			target.setColors(newValues[0], newValues[1], newValues[2]);
			break;

		default:
			break;
		}
		
	}

}
