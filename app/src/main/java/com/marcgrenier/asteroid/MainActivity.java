package com.marcgrenier.asteroid;

import java.util.ArrayList;
import java.util.List;

import com.marcgrenier.asteroid.TextureMng;
import com.marcgrenier.asteroid.scene.GameOverScene;
import com.marcgrenier.asteroid.scene.GameScene;
import com.marcgrenier.asteroid.scene.HighScoreScene;
import com.marcgrenier.asteroid.scene.MenuScene;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;
import com.marcgrenier.asteroid.SoundMng;

public class MainActivity extends CVMGameActivity {
	
	public MainActivity() {
		super(TextureMng.getInstance());
		super.setSoundManager(SoundMng.getInstance());

		List<CVMAbstractScene> sceneList = new ArrayList<CVMAbstractScene>();
		
		sceneList.add(new MenuScene());
		sceneList.add(new HighScoreScene());
		sceneList.add(new GameScene());
		sceneList.add(new GameOverScene());
		
		
		super.setSceneList(sceneList);
	}

    public void stop(){
	}
}
	