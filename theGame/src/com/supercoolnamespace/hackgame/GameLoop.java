package com.supercoolnamespace.hackgame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import entities.GroundEntity;
import entities.HouseEntity;
import entities.SkyBox;
import entities.SunEntity;

public class GameLoop {

	private static final String TAG = MainActivity.class.getSimpleName();

	private TweenManager manager;
	private Point displaySize;

	public boolean sunUp;

	private final int SKY_DAY = Color.rgb(13, 2, 110);
	private final int SKY_NIGHT = Color.rgb(18, 129, 255);

	private SquareEntity square;
	private SunEntity sunEntity;
	private HouseEntity houseEntity;
	private GroundEntity groundEntity;

	private ArrayList<SkyBox> skyboxes;
	private ArrayList<HouseEntity> houses;

	private Entity controlSquare;

	public GameLoop(Context context) {

		// Get the screen size of the device
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		displaySize = new Point();
		display.getSize(displaySize);

		// Create the sun
		sunEntity = new SunEntity(displaySize.x / 2, displaySize.y / 2);
		groundEntity = new GroundEntity(displaySize.x / 2, 0, 50, 3000,
				displaySize.y);
		sunUp = true;

		// Create the skyboxes
		skyboxes = new ArrayList<SkyBox>();
		skyboxes.add(new SkyBox(0, 0, displaySize.x / 2, displaySize.y, Color
				.rgb(167, 199, 240)));
		skyboxes.add(new SkyBox(displaySize.x / 2, 0, displaySize.x / 2,
				displaySize.y, Color.rgb(24, 8, 102)));

		// Create the houses
		houses = new ArrayList<HouseEntity>();
		HouseEntity tempHouse = new HouseEntity(400, 50, 300, 150);
		tempHouse.setRotation(-3);
		houses.add(tempHouse);
		tempHouse = new HouseEntity(100, 50, 300, 150);
		tempHouse.setRotation(4);
		houses.add(tempHouse);
		houseEntity = new entities.HouseEntity(100, 100, 50, 50);

		// Create treadmill with squares
		manager = new TweenManager();
		controlSquare = new SquareEntity(context, 200, 200);
		/*Tween.to(controlSquare, EntityTweener.POSITION_XY, 0.5f).target(
				controlSquare.x, controlSquare.y + 200).start();*/

	}

	public void draw(Canvas c, float delta) {

		if (!sunUp && Math.sin(sunEntity.rotation) > 0) {
			skyboxes.get(0).setColors(Color.red(SKY_DAY), Color.green(SKY_DAY),
					Color.blue(SKY_DAY));
			skyboxes.get(1).setColors(Color.red(SKY_NIGHT),
					Color.green(SKY_NIGHT), Color.blue(SKY_NIGHT));
			sunUp = true;
		}

		if (sunUp && Math.sin(sunEntity.rotation) < 0) {
			skyboxes.get(1).setColors(Color.red(SKY_DAY), Color.green(SKY_DAY),
					Color.blue(SKY_DAY));
			skyboxes.get(0).setColors(Color.red(SKY_NIGHT),
					Color.green(SKY_NIGHT), Color.blue(SKY_NIGHT));
			sunUp = false;
		}

		for (SkyBox sb : skyboxes) {
			sb.draw(c);
		}

		houseEntity.setRotation(houseEntity.getRotation() + delta);


		sunEntity.setRotation(sunEntity.getRotation() + delta);
		sunEntity.draw(c);

		groundEntity.draw(c);
		houseEntity.draw(c);

		for (HouseEntity he : houses) {
			he.draw(c);
		}

	}
}
