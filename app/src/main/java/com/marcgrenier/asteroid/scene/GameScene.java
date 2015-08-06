package com.marcgrenier.asteroid.scene;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

import com.marcgrenier.asteroid.Sprite.AsteroidSprite;
import com.marcgrenier.asteroid.Sprite.BalleSprite;
import com.marcgrenier.asteroid.Sprite.ShipSprite;
import com.marcgrenier.asteroid.Sprite.Button.MoveButton;
import com.marcgrenier.asteroid.Sprite.Button.RotateButton;
import com.marcgrenier.asteroid.Text.ScoreText;
import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;

import com.marcgrenier.asteroid.sqlite.entity.Score;

public class GameScene extends CVMAbstractScene{

	private ShipSprite shipSprite;
	private RotateButton rotateButton;
	private MoveButton moveButton;
	private ScoreText scoreText;
	
	private float laps_balle=0;
	private float laps_asteroid=0;
	
	private int nbAsteroid, nbMaxAsteroid = 20;

	public GameScene() {
		super("Sprite/in_game.png", 3);
		// TODO Auto-generated constructor stub		
	}

	@Override
	public void managedUpdate(float elapseTime) {
		laps_balle += elapseTime;
		laps_asteroid += elapseTime;
		
		if(laps_balle > 1){
			BalleSprite balleSprite = new BalleSprite();
			super.addSprite(balleSprite);
			laps_balle=0;
		}	
		
		if(laps_asteroid > 0.5){
			if(nbAsteroid < nbMaxAsteroid){
				nbAsteroid +=1 ;
				
				AsteroidSprite asteroidSprite = new AsteroidSprite();
				super.addSprite(asteroidSprite);
			}
			laps_asteroid=0;	
		}
		
		scoreText.actualiser();
	}

	@Override
	public void sceneTouched(TouchEvent arg0) {
		// TODO Auto-generated method stubx
	}

	@Override
	public void starting() {
		this.gameActivity.setMusic(null);		
		Score.getInstance().setPoint(0);
		
		nbAsteroid = 0;
		
		shipSprite = new ShipSprite();
		super.addSprite(shipSprite);
	
		rotateButton = new RotateButton();
		super.addSprite(rotateButton);		
		
		moveButton = new MoveButton();
		super.addSprite(moveButton);
		
		scoreText = new ScoreText();
		super.addText(scoreText);
		
	}
	
	public Sprite traverseMur(Sprite sprite){
		if(sprite.getX()<0-sprite.getWidth()){
			sprite.setX(800+sprite.getWidth());
		}
		else if(sprite.getX()>800+sprite.getWidth()){
			sprite.setX(-1*sprite.getWidth());
		}
		else if (sprite.getY()<0-sprite.getHeight()){
			sprite.setY(480+sprite.getHeight());			
		}
		else if (sprite.getY()>480+sprite.getHeight()){
			sprite.setY(-1*sprite.getHeight());
		}
		return sprite;
	}
	/*
	 *getters and setters 
	 */
	
	
	
	public ShipSprite getShipSprite() {
		return shipSprite;
	}

	public void setShipSprite(ShipSprite shipSprite) {
		this.shipSprite = shipSprite;
	}

	public RotateButton getRotateButton() {
		return rotateButton;
	}
	
	public int getNbAsteroid() {
		return nbAsteroid;
	}

	public void setNbAsteroid(int nbAsteroid) {
		this.nbAsteroid = nbAsteroid;
	}

	public MoveButton getMoveButton() {
		return moveButton;
	}

	public void setMoveButton(MoveButton moveButton) {
		this.moveButton = moveButton;
	}

	public void setRotateButton(RotateButton rotateButton) {
		this.rotateButton = rotateButton;
	}
	
	
}
