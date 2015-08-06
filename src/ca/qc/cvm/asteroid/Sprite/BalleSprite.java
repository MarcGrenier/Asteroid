package ca.qc.cvm.asteroid.Sprite;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;

import ca.qc.cvm.asteroid.TextureMng;
import ca.qc.cvm.asteroid.scene.GameScene;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.CollisionListener;
import ca.qc.cvm.cvmandengine.entity.ManagedUpdateListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;
import ca.qc.cvm.asteroid.SoundMng;

public class BalleSprite extends CVMSprite implements CollisionListener , ManagedUpdateListener{

	private float posX= 0 ,posY=0;
	private double deplX=1, deplY=1;
	private boolean anim=false;
	
	@SuppressWarnings("static-access")
	public BalleSprite() {
		super(0, 0, 25, 24, TextureMng.getInstance().SPRITE_BALLE);
	}

	@Override
	public void collidedWith(CVMGameActivity activity, CVMAbstractScene scene,CVMSprite sprite) {
		if(sprite instanceof AsteroidSprite){
			((AsteroidSprite)sprite).explode(scene);
			scene.removeSprite(this);
		}
		
	}

	@Override
	public void managedUpdate(float elapseTime, CVMGameActivity activity,	CVMAbstractScene scene) {
		GameScene gm = (GameScene) scene;
		Sprite ship = gm.getShipSprite().getSprite();
		
		
		if(!anim){
			this.getSprite().setRotation(ship.getRotation()+90);
			
			this.setDeplX(Math.sin(Math.toRadians(ship.getRotation())));
			this.setDeplY(Math.cos(Math.toRadians(ship.getRotation()))*-1);
	
			this.posX=ship.getX()+16;
			this.posY=ship.getY();
		
			
			anim=true;
			AnimatedSprite s = ((AnimatedSprite)this.getSprite());
			s.animate(200,true);
			
			SoundMng.getInstance().playSound(SoundMng.soundLaser);
		}
		
		posX+=deplX;
		posY+=deplY;
		
		
		if(posX<-32 || posX>800 || posY<-32 || posY>480)
		{
			scene.removeSprite(this);
		}
		else{
			this.getSprite().setPosition(posX, posY);
		}
		
		
	}

	public double getDeplX() {
		return deplX;
	}

	public void setDeplX(double deplX) {
		this.deplX = deplX *10;
	}

	public double getDeplY() {
		return deplY;
	}

	public void setDeplY(double deplY) {
		this.deplY = deplY *10;
	}

}
