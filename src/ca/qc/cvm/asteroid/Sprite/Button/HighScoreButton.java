package ca.qc.cvm.asteroid.Sprite.Button;

import org.andengine.input.touch.TouchEvent;

import android.util.Log;

import ca.qc.cvm.asteroid.TextureMng;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.TouchAreaListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;


public class HighScoreButton extends CVMSprite implements TouchAreaListener{

	public HighScoreButton() {
		super(((CVMGameActivity.CAMERA_WIDTH-199)/2), 300, 199,60, TextureMng.getInstance().SPRITE_HIGHSCORE_BUTTON);
	}

	@Override
	public void onAreaTouched(TouchEvent touchEvent, float x, float y,CVMGameActivity activity, CVMAbstractScene scene) {
		if(touchEvent.getAction()==TouchEvent.ACTION_UP){
			activity.changeScene(2,true);
			
		}
	}
}
