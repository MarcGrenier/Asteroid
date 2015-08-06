package ca.qc.cvm.asteroid;

import ca.qc.cvm.cvmandengine.CVMTextureManager;
import ca.qc.cvm.cvmandengine.entity.CVMTexture;

public class TextureMng extends CVMTextureManager {
	public static final int SPRITE_TITRE = 10;
	
	public static final int SPRITE_SHIP = 100;
	public static final int SPRITE_ASTEROID = 101;
	public static final int SPRITE_BALLE = 102;
	
	public static final int PARTICLE_POINT = 200;
	
	public static final int SPRITE_START_BUTTON = 300;
	public static final int SPRITE_HIGHSCORE_BUTTON = 301;
	public static final int SPRITE_MOVE_BUTTON = 302;
	public static final int SPRITE_ROT_BUTTON = 303;
	public static final int SPRITE_MENUP_BUTTON = 304;
	
	
	private static TextureMng instance;
	
	private TextureMng() {
		// Création des ressources
		super.addTexture(new CVMTexture(SPRITE_START_BUTTON,"Button/btn_nouvelle_partie.png",310,53));
		super.addTexture(new CVMTexture(SPRITE_HIGHSCORE_BUTTON,"Button/btn_highscore.png",199,60));
		super.addTexture(new CVMTexture(SPRITE_MENUP_BUTTON, "Button/btn_menuP.png", 167, 28));
		
		super.addTexture(new CVMTexture(SPRITE_ROT_BUTTON, "Button/btn_rot.png", 142, 63));
		super.addTexture(new CVMTexture(SPRITE_MOVE_BUTTON,"Button/btn_move_forward.png",63,63));
		
		super.addTexture(new CVMTexture(SPRITE_TITRE, "Sprite/titre.png", 640, 400));
		
		super.addTexture(new CVMTexture(PARTICLE_POINT, "particles/particle_point.png", 32, 32));
		//constructeur pour animation
		super.addTexture(new CVMTexture(SPRITE_ASTEROID, "Sprite/asteroid.png", 500, 150,10,3));
		super.addTexture(new CVMTexture(SPRITE_BALLE, "Sprite/balle.png", 125,24,5,1));
		super.addTexture(new CVMTexture(SPRITE_SHIP, "Sprite/ship_animation.png", 198, 66,3,1));
	}
	
	public static TextureMng getInstance() {
		if (instance == null) {
			instance = new TextureMng();
		}
		
		return instance;
	}
}
