package ca.qc.cvm.asteroid.Text;

import org.andengine.util.color.Color;

import android.util.Log;

import ca.qc.cvm.cvmandengine.entity.CVMText;
import ca.qc.cvm.cvmandengine.entity.ManagedUpdateListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;
import ca.qc.cvm.sqlite.entity.Score;

public class ScoreText extends CVMText{
	
	public ScoreText() {
		super(100, 20, 40,"0     ", Color.WHITE);
	}

	public void actualiser() {
		if (super.getText() != null) {
			super.getText().setText(String.valueOf(Score.getInstance().getPoint()));
		}
	}
	
	
}
