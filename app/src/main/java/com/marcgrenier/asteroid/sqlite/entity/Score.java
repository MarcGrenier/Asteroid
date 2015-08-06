package com.marcgrenier.asteroid.sqlite.entity;

public class Score {

	private int point;
	
	private static Score score;

	public Score() {
		
	}

	public static Score getInstance() {
		if (score == null) {
			score = new Score();
		}
		
		return score; 
	}
	
		
	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}

}
