package com.supercoolnamespace.hackgame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;

public class SharedResurces {

	private final static int MAX_NBR_SQUARES_TO_DRAW = 4;

	public int currentWorld = World.UpperWorld;

	private ArrayList<Integer> removedEntities;
	private ArrayList<Integer> squaresToDraw;
	ScoreClass sc;

	public SharedResurces(Context con) {
		removedEntities = new ArrayList<Integer>();
		sc = new ScoreClass(con);
	}

	public void addSquare(int square) {
		removedEntities.add(square);
	}

	public void updateWorld(Canvas c) {

		if (currentWorld == World.UpperWorld) {
			currentWorld = World.LowerWorld;
		} else if (currentWorld == World.LowerWorld) {
			currentWorld = World.UpperWorld;
		}

		squaresToDraw = removedEntities;
		removedEntities = new ArrayList<Integer>();

	}

	public int getColor() {
		if(squaresToDraw == null || squaresToDraw.size() < 1) {
			return -1;
		}
		else {
			return squaresToDraw.remove(0);
		}
	}

}
