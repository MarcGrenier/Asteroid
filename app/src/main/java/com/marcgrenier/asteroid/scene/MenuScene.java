package com.marcgrenier.asteroid.scene;

import org.andengine.input.touch.TouchEvent;

import android.content.res.AssetManager;
import android.util.Log;

import com.marcgrenier.asteroid.Sprite.TitreSprite;
import com.marcgrenier.asteroid.Sprite.Button.HighScoreButton;
import com.marcgrenier.asteroid.Sprite.Button.StartButton;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;

public class MenuScene extends CVMAbstractScene {

	public MenuScene() {
		super("Sprite/Asteroid_Menu.png", 1);

		StartButton start_btn = new StartButton();
		HighScoreButton hs_btn = new HighScoreButton();
		TitreSprite titreSprite =  new TitreSprite();
		
		super.addSprite(start_btn);
		super.addSprite(hs_btn);
		super.addSprite(titreSprite);
		
	}

	@Override
	public void managedUpdate(float arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sceneTouched(TouchEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void starting() {
		this.gameActivity.setMusic("music/ambiant.mp3");
	}

}
