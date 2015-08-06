package ca.qc.cvm.asteroid;

import java.util.ArrayList;
import java.util.List;

import ca.qc.cvm.asteroid.TextureMng;
import ca.qc.cvm.asteroid.scene.GameOverScene;
import ca.qc.cvm.asteroid.scene.GameScene;
import ca.qc.cvm.asteroid.scene.HighScoreScene;
import ca.qc.cvm.asteroid.scene.MenuScene;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;
import ca.qc.cvm.asteroid.SoundMng;

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
	