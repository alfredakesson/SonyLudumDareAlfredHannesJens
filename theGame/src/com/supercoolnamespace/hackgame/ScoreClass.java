package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.content.Intent;

public class ScoreClass {
	
	Context con ;
	int currentScore = 6;
	
	public ScoreClass(Context con) {
		this.con = con;
	}
	
	public void setScore(int nbr){
		currentScore = nbr;
	    Intent intent = new Intent("com.supercoolnamespace.IT_A_BOY");
	    intent.putExtra(Intent.EXTRA_TEXT, "" + nbr);
		con.sendBroadcast(intent);
	}
	
	public void resetScore(){
		setScore(6);
	}
	
	public void lowerScore(){
		setScore(currentScore -1);
	}
	
	
	

}
