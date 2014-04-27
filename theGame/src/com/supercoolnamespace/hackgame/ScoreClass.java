package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScoreClass {
	
	Context con ;
	int currentBalance = 5;
	int currentScore = 0;
	
	public ScoreClass(Context con) {
		this.con = con;
	}
	
	public void setScore(int nbr){
		currentBalance = nbr;
		Log.d("ALfred", "Nu score" + currentBalance);
	    Intent intent = new Intent("com.supercoolnamespace.IT_A_BOY");
	    intent.putExtra(Intent.EXTRA_TEXT, "" + nbr);
		con.sendBroadcast(intent);
	}
	
	public void resetScore(){
		setScore(0);
	}
	
	public void lowerScore(){
		currentScore++;
		setScore(currentBalance - 1);
	}
	
	public void higherScore(){
		currentScore++;
		setScore(currentBalance + 1);
	}
	
	
	

}
