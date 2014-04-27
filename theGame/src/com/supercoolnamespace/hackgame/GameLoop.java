package com.supercoolnamespace.hackgame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import entities.BlueFabric;
import entities.GroundEntity;
import entities.HouseEntity;
import entities.RedFabric;
import entities.SkyBox;
import entities.SunEntity;

public class GameLoop extends Screen{

	private static final String TAG = MainActivity.class.getSimpleName();
	
	private Offset theDrawOffset;
	private Entity blueHause;
	
	private World upperWorld;
	private World lowerWorld;

	private Point displaySize;

	public boolean sunUp;

	private final float NIGHT_START_ANGLE = 0f;
	private final float DAWN_TIME = 0.5f;

	private final int SKY_DAY = Color.rgb(135, 206, 235);
	private final int SKY_NIGHT = Color.rgb(18, 129, 255);

	private SunEntity sunEntity;
	private HouseEntity houseEntity;
	private GroundEntity groundEntity;

	private ArrayList<SkyBox> skyboxes;
	private ArrayList<HouseEntity> houses;
	private SharedResurces share;

	private Context context;


	private TweenManager colorManager;

	private RedFabric redHause;

	

	public GameLoop(Context context) {
		super(context, null);
		this.context = context;
		
		// Get the screen size of the device
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		displaySize = new Point();
		display.getSize(displaySize);
		share = new SharedResurces(context);
		
		upperWorld = new UpperWorld(context, displaySize,share);
		lowerWorld = new LowerWorld(context, displaySize,share);
		
		
		theDrawOffset = new Offset();
		
		
		Tween.registerAccessor(Entity.class, new EntityTweener());

		Tween.registerAccessor(SkyBox.class, new OpacityTweener());
		

		sunEntity = new SunEntity(displaySize.x / 2, displaySize.y / 2);
		groundEntity = new GroundEntity(displaySize.x / 2, 0, 50, 3000,
				displaySize.y);
		sunUp = true;

		// Create the skyboxes
		skyboxes = new ArrayList<SkyBox>();

		skyboxes.add(new SkyBox(0, 0, displaySize.x / 2, displaySize.y, SKY_DAY));

		skyboxes.add(new SkyBox(displaySize.x / 2, 0, displaySize.x / 2,
				displaySize.y, SKY_DAY));
		
		skyboxes.get(1).setOpacity(SkyBox.OPACITY_DAY);

		// Create the houses
		houses = new ArrayList<HouseEntity>();
		HouseEntity tempHouse = new HouseEntity(context, 10, 20, 2, 2);

		tempHouse.setRotation(-3);
		houses.add(tempHouse);

		//tempHouse = new HouseEntity(context, 100, 50, 5, 50);
		//tempHouse.setRotation(4);
		//houses.add(tempHouse);

		//houseEntity = new entities.HouseEntity(context, 100, 100, 50, 50);
		colorManager = new TweenManager();
		blueHause = new BlueFabric(550,1400);
		redHause = new RedFabric(220, 200);


		
		
	}

	

	public void draw(Canvas c, float delta) {


		for (SkyBox sb : skyboxes) {
			sb.draw(c);
		}

		drawSun(c);
		sunEntity.setRotation(sunEntity.getRotation() + 0.3f*delta);///CHANGE THIS VALUE LATER!!!!
		sunEntity.draw(c);

		groundEntity.draw(c);

		for (HouseEntity he : houses) {
			he.draw(c);
		}

		
		if(sunUp)
			upperWorld.drawAllSquares(c, delta);
		else
			lowerWorld.drawAllSquares(c, delta);

		colorManager.update(delta);
		
		blueHause.draw(c);
		redHause.draw(c);
		//manager.update(delta);

	}

	private void drawSun(Canvas c) {
		if (!sunUp && Math.sin(sunEntity.rotation + NIGHT_START_ANGLE) > 0) {

			Tween.to(skyboxes.get(1), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_DAY).start(colorManager);
			Tween.to(skyboxes.get(0), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_NIGHT).start(colorManager);
			sunUp = true;
			upperWorld = new UpperWorld(context, displaySize,share);
			share.updateWorld(c);
		}

		if (sunUp && Math.sin(sunEntity.rotation + NIGHT_START_ANGLE) < 0) {
			Tween.to(skyboxes.get(0), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_DAY).start(colorManager);
			Tween.to(skyboxes.get(1), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_NIGHT).start(colorManager);

			sunUp = false;
			lowerWorld = new LowerWorld(context, displaySize,share);
			share.updateWorld(c);;
		}
	
		
	}



	@Override
	public void touch(MotionEvent event) {
		float y = event.getY();
		float x = event.getX();
		Log.d("GAMELOP", "screen: " + displaySize.x + " " + displaySize.y );
		Log.d("GAMELOOP", "Is pressed! coords: (" + x + "," + y + ")");
		upperWorld.handleTouch(x, y);
		lowerWorld.handleTouch(x, y);

		
	}



	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}



}
