package com.supercoolnamespace.hackgame;

import aurelienribon.tweenengine.TweenAccessor;

public class OpacityTweener implements TweenAccessor<Obscureable> {
	
	public final static int TWEEN_OPACITY = 1;

	@Override
	public int getValues(Obscureable target, int tween, float[] returnValues) {
		switch (tween) {
		case TWEEN_OPACITY:
			returnValues[0] = target.getOpacity();
			return 1;

		default:
			break;
		}
		return 0;
	}

	@Override
	public void setValues(Obscureable target, int tween, float[] newValues) {
		switch (tween) {
		case TWEEN_OPACITY:
			target.setOpacity(newValues[0]);
			break;

		default:
			break;
		}
		
	}

}
