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

	public void drawRemovedSquares(Canvas c) {

		if (currentWorld == World.UpperWorld) {
			currentWorld = World.LowerWorld;
		} else if (currentWorld == World.LowerWorld) {
			currentWorld = World.UpperWorld;
		}

		// Draw as many of the the squares removed during the time on the other
		// side of the mud
		// The rest will be spawned during the game

		squaresToDraw = removedEntities;
		removedEntities = new ArrayList<Integer>();

		for (int s = 0; s < squaresToDraw.size(); s++) {
			int square = squaresToDraw.remove(0);

			switch (square) {
			case SquareEntity.BLUE:
				if (currentWorld == World.LowerWorld) {

				} else {

				}
				break;
			case SquareEntity.RED:
				if (currentWorld == World.LowerWorld) {

				} else {

				}
				break;
			default:
				// do nothing;
				break;
			}
			if (s == MAX_NBR_SQUARES_TO_DRAW) {
				break;
			}
		}
	}

	public int getColor() {
		return 0;
	}

}
