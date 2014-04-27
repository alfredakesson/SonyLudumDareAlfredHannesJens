package com.supercoolnamespace.hackgame;

import java.util.ArrayList;

import android.graphics.Canvas;

public class SharedResurces {
	
	private ArrayList<Integer> removedEntities;
	
	public SharedResurces() {
		removedEntities = new ArrayList<Integer>();
	}
	
	public void addSquare(int square) {
		removedEntities.add(square);
	}

	public void drawRemovedSquares(Canvas c) {
		
		// Draw the squares removed during the time on the other side of the mud
		
		for(int s = 0; s < removedEntities.size(); s++) {
			int square = removedEntities.get(0);
			
			switch (square) {
			case SquareEntity.BLUE:
				break;
			case SquareEntity.RED:
				break;
			default:
				// do nothing;
				break;
			}
			
		}
		
		
		removedEntities = new ArrayList<Integer>();
	}

}
