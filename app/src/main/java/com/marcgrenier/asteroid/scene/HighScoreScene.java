package com.marcgrenier.asteroid.scene;

import java.util.List;

import org.andengine.input.touch.TouchEvent;

import com.marcgrenier.asteroid.Text.UsagerText;

import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import com.marcgrenier.asteroid.sqlite.entity.Usager;
import com.marcgrenier.asteroid.sqlite.model.ModelUsager;

public class HighScoreScene extends CVMAbstractScene{
	
	public HighScoreScene() {
		super("Sprite/in_game.png", 2);
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
		ModelUsager modelUsager = new ModelUsager(this.gameActivity);    	
		modelUsager.openDatabase();
		
		List<Usager> listUsager = modelUsager.fetchUsager();
		modelUsager.closeDatabase();
		
		afficherTop5(listUsager);
	}

	public void afficherTop5(List<Usager> listUsager){

		for(int i=0;i<listUsager.size() && i<6;i++){
			Usager temp  = listUsager.get(i);
			
			String afficher = String.valueOf(i+1)+ "-  " + temp.getNom();
			
			for(int k=0;k< 30-temp.getNom().length();k++){
				afficher += " ";
			}
			
			afficher += String.valueOf(temp.getScore());
			
			UsagerText userText = new UsagerText(i,afficher);
			super.addText(userText);
		}
	}
	
}
