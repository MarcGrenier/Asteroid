package com.marcgrenier.asteroid.Sprite.Button;

import org.andengine.input.touch.TouchEvent;

import com.marcgrenier.asteroid.TextureMng;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.TouchAreaListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;

public class MenuPrincipalButton extends CVMSprite implements TouchAreaListener{

	public MenuPrincipalButton() {
		super(600, 400, 167, 28, TextureMng.getInstance().SPRITE_MENUP_BUTTON);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onAreaTouched(TouchEvent touchEvent, float x, float y, CVMGameActivity activity, CVMAbstractScene scene) {
		if(touchEvent.getAction() == TouchEvent.ACTION_UP){
			activity.changeScene(1);
		}
		
	}

}
