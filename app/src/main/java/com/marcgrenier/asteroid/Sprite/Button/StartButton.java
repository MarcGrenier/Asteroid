package com.marcgrenier.asteroid.Sprite.Button;

import org.andengine.input.touch.TouchEvent;

import com.marcgrenier.asteroid.TextureMng;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.TouchAreaListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;


public class StartButton extends CVMSprite implements TouchAreaListener{

	public StartButton() {
		super(((CVMGameActivity.CAMERA_WIDTH-310)/2), 200, 310,53, TextureMng.getInstance().SPRITE_START_BUTTON);
		
	}

	@Override
	public void onAreaTouched(TouchEvent touchEvent, float x, float y, CVMGameActivity activity, CVMAbstractScene scene) {
		if (touchEvent.getAction() == TouchEvent.ACTION_UP) {
			activity.changeScene(3, true);
		}
		
	}

}
