package com.marcgrenier.asteroid.Sprite.Button;

import org.andengine.input.touch.TouchEvent;

import com.marcgrenier.asteroid.TextureMng;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.TouchAreaListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;

public class RotateButton extends CVMSprite implements TouchAreaListener{

	private boolean onIt = false;
	
	//n pour none, r pour right et l pour left
	private char place = 'n';
	
	@SuppressWarnings("static-access")
	public RotateButton() {
		super(20, 400, 142, 63, TextureMng.getInstance().SPRITE_ROT_BUTTON);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onAreaTouched(TouchEvent touchEvent, float x, float y, CVMGameActivity activity, CVMAbstractScene scene) {
		
		if(touchEvent.getAction() != TouchEvent.ACTION_UP && touchEvent.getAction() != TouchEvent.ACTION_OUTSIDE)
		{
			onIt= true;
			if(x>=0 && x<63){
				place='l';
			}
			else if (x>=79 && x<142){
				place='r';
			}
			else{
				place = 'n';
			}
		}
		else{
			onIt=false;
			place='n';
		}
	}


	public boolean isOnIt() {
		return onIt;
	}

	public void setOnIt(boolean onIt) {
		this.onIt = onIt;
	}

	public char getPlace() {
		return place;
	}

	public void setPlace(char place) {
		this.place = place;
	}

}
