package ca.qc.cvm.asteroid.Sprite;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;

import ca.qc.cvm.asteroid.R;
import ca.qc.cvm.asteroid.TextureMng;
import ca.qc.cvm.asteroid.scene.GameScene;
import ca.qc.cvm.cvmandengine.entity.CVMSprite;
import ca.qc.cvm.cvmandengine.entity.CollisionListener;
import ca.qc.cvm.cvmandengine.entity.ManagedUpdateListener;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.ui.CVMGameActivity;

public class ShipSprite extends CVMSprite implements  ManagedUpdateListener, CollisionListener{
	
	public float posX=380, posY=180;
	
	private double deplX=0, deplY=0;
	private float rotation=0;
	
	private boolean animated = false;

	
	@SuppressWarnings("static-access")
	public ShipSprite() {
		super(380, 180, 66, 66, TextureMng.getInstance().SPRITE_SHIP);
	}

	@Override
	public void managedUpdate(float arg0, CVMGameActivity activity,	CVMAbstractScene scene) {
		if(!animated){
			animated=true;
			
			AnimatedSprite s = ((AnimatedSprite)this.getSprite());
			s.animate(100,true);
		}
		
		GameScene gm = (GameScene)scene;
		
		this.ajustDegre(gm);
		
		this.calculDepl(gm.getMoveButton().isOnIt());
		
		this.actualisationPosition(gm);
	}
	
	@Override
	public void collidedWith(CVMGameActivity activity, CVMAbstractScene scene,CVMSprite sprite) {
		
		if(sprite instanceof AsteroidSprite){
			GameScene gm = (GameScene) scene;
			
			gm.getMoveButton().setOnIt(false);
			gm.getRotateButton().setOnIt(false);
			
			activity.changeScene(4,false);
		}
	}
	
	public void actualisationPosition(GameScene gm){
		if (gm.getMoveButton().isOnIt()){
			posX += deplX*2;
			posY += deplY*2;
			
			this.getSprite().setPosition(posX,posY);
			
			Sprite temp = (gm.traverseMur(this.getSprite()));
			
			posX = temp.getX();
			posY = temp.getY();
			
			this.getSprite().setPosition(posX, posY);
		}
	}
	
	public void calculDepl(boolean onIt){
		
		if(onIt){
			deplX = Math.sin(Math.toRadians(rotation));			
			deplY = Math.cos(Math.toRadians(rotation))*-1;
		}
		else{
			deplX=0;
			deplY=0;
		}
	}
	
	public void ajustDegre(GameScene gm){
		if(gm.getRotateButton().isOnIt()){
			if (gm.getRotateButton().getPlace()=='r'){
				if(rotation==360){
					rotation = 0;
				}
				rotation += 5;
			}
			else if (gm.getRotateButton().getPlace()=='l'){
				if(rotation==0){					
					rotation = 360;
				}
				rotation -= 5;
			}
		}
		
		this.getSprite().setRotation(rotation);
	}
	
}