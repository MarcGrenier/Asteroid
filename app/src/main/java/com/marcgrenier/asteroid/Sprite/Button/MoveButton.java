package com.marcgrenier.asteroid.Sprite.Button;

import org.andengine.input.touch.TouchEvent;

import com.marcgrenier.asteroid.TextureMng;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.TouchAreaListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;

public class MoveButton extends CVMSprite implements TouchAreaListener{
	
	private boolean onIt=false;
	
	@SuppressWarnings("static-access")
	public MoveButton() {
		super(700, 400, 63, 63, TextureMng.getInstance().SPRITE_MOVE_BUTTON);
	}

	@Override
	public void onAreaTouched(TouchEvent touchEvent, float x, float y,CVMGameActivity activity, CVMAbstractScene scene){
		if(touchEvent.getAction() != TouchEvent.ACTION_UP && touchEvent.getAction() != TouchEvent.ACTION_OUTSIDE){
			onIt= true;
		}
		else{
			onIt=false;
		}
	}

	public boolean isOnIt() {
		return onIt;
	}

	public void setOnIt(boolean onIt) {
		this.onIt = onIt;
	}
}
