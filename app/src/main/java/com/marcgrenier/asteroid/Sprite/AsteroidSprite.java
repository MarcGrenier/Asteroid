package com.marcgrenier.asteroid.Sprite;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;

import com.marcgrenier.asteroid.ParticlesFactory;
import com.marcgrenier.asteroid.TextureMng;
import com.marcgrenier.asteroid.scene.GameScene;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.ManagedUpdateListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;
import com.marcgrenier.asteroid.SoundMng;
import com.marcgrenier.asteroid.sqlite.entity.Score;

public class AsteroidSprite extends CVMSprite implements ManagedUpdateListener{
	
	private float posX;
	private float posY;
	
	private double rotation = Math.random() * 360;
	
	private double deplX = Math.sin(Math.toRadians((rotation)));
	private double deplY = Math.cos(Math.toRadians((rotation))) * -1;
	
	private boolean started = false;
	
	@SuppressWarnings("static-access")
	public AsteroidSprite() {
		super(0, 0, 50, 50, TextureMng.getInstance().SPRITE_ASTEROID);
	}

	@Override
	public void managedUpdate(float arg0, CVMGameActivity activity,	CVMAbstractScene scene) {
		
		GameScene gm = (GameScene) scene;
		
		if(!started){			
			
			this.initAsteroid();
			
			started=true;
			AnimatedSprite s = ((AnimatedSprite)this.getSprite());
			s.animate(100,true);
		}
		
		this.actualisationPosition(gm);
		
	}
	
	public void explode(CVMAbstractScene scene){
		scene.removeSprite(this);
		
		SoundMng.getInstance().playSound(SoundMng.soundExplosion);
		
		GameScene gm = (GameScene) scene;
		gm.setNbAsteroid(gm.getNbAsteroid()-1);
	
		ParticlesFactory.addExplosion(posX, posY, scene);
		
		Score.getInstance().setPoint(Score.getInstance().getPoint()+50);		
	}
	
	public void actualisationPosition(GameScene gm){
		posX+=deplX;
		posY+=deplY;
		
		this.getSprite().setPosition(posX, posY);
		
		Sprite temp = (gm.traverseMur(this.getSprite()));
		
		posX = temp.getX();
		posY = temp.getY();
		
		this.getSprite().setPosition(posX, posY);
		
	}
	
	public void initAsteroid(){
		double temp = Math.random()*3;
		int rand = (int) temp;
		
		if(rand%3==0){
			posX = rand * 800/4;
			posY = 0 - 50;
		}
		else if(rand%3==1){
			posX = 800 + 50;
			posY = rand * 480/4;
		}
		else if(rand%3==2){
			posX = 0 - 50;
			posY = rand * 480/4;
		}
		
		super.getSprite().setPosition(posX,posY);
		super.getSprite().setRotation((float) rotation);	
	}

}
