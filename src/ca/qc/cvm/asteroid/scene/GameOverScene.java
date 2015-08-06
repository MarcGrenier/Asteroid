package ca.qc.cvm.asteroid.scene;

import java.util.List;

import org.andengine.input.touch.TouchEvent;
import org.andengine.ui.dialog.StringInputDialogBuilder;
import org.andengine.util.call.Callback;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;


import ca.qc.cvm.asteroid.R;
import ca.qc.cvm.asteroid.Sprite.Button.MenuPrincipalButton;
import ca.qc.cvm.asteroid.Text.UsagerText;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.sqlite.entity.Score;
import ca.qc.cvm.sqlite.entity.Usager;
import ca.qc.cvm.sqlite.model.ModelUsager;

public class GameOverScene extends CVMAbstractScene{

	private Dialog sidb;
	private Context context;
	
	public GameOverScene() {
		super("Sprite/in_game.png", 4);		
		
		MenuPrincipalButton menuP = new MenuPrincipalButton();
		super.addSprite(menuP);
	}

	@Override
	public void managedUpdate(float arg0) {
		
	}

	@Override
	public void sceneTouched(TouchEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void starting() {
		this.gameActivity.setMusic("music/ambiant.mp3");
		context = this.gameActivity;
		
		this.gameActivity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				sidb = new StringInputDialogBuilder(context,
						R.string.titre_entre,
						R.string.message,
						R.string.error,
						android.R.drawable.ic_menu_info_details,
						new Callback<String>() {
							@Override
							public void onCallback(String nom) {								
								sidb.hide();
								
								affichageFinal(nom);
							}
						}
				, new OnCancelListener(){

					@Override
					public void onCancel(DialogInterface dialog) {
						afficherTop5();
						
					} }).create();
				sidb.show();
			}
		});
		
	}

	public void affichageFinal(String nom){
		String temp = "";
		if(nom.length()>15){
			for (int p= 0; p<15;p++){
				temp += nom.charAt(p);
			}
			nom = temp;
		}
		
		ajoutDB(new Usager(nom, Score.getInstance().getPoint(), 0));
		afficherTop5();
	}
	
	public void ajoutDB(Usager user){
		ModelUsager modelUsager = new ModelUsager(this.gameActivity);
		
		modelUsager.openDatabase();
		
		modelUsager.addUsager(user);
		
		modelUsager.closeDatabase();
	}
	

	public void afficherTop5(){
		ModelUsager modelUsager =  new ModelUsager(this.gameActivity);
		modelUsager.openDatabase();
		List<Usager> listUsager = modelUsager.fetchUsager();
		modelUsager.closeDatabase();
		
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
