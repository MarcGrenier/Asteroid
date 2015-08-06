package com.marcgrenier.asteroid.Text;

import org.andengine.util.color.Color;

import ca.qc.cvm.cvmandengine.entity.CVMText;

public class UsagerText extends CVMText{

	public UsagerText(int pos, String displayText) {
		super(100, 80 + pos*40, 30, displayText, Color.WHITE);
		// TODO Auto-generated constructor stub
	}
	
}
