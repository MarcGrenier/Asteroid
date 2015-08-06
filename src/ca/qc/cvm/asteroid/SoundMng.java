package ca.qc.cvm.asteroid;

import ca.qc.cvm.cvmandengine.CVMSoundManager;
import ca.qc.cvm.cvmandengine.entity.CVMSound;

public class SoundMng extends CVMSoundManager{
	public static int musicHome = 1;
	public static int soundLaser = 2;
	public static int soundExplosion = 3;
	
	private static SoundMng instance;

	public SoundMng() {
		//super.addSound(new CVMSound(musicHome, "music/theme.mp3"));
		super.addSound(new CVMSound(soundLaser, "music/laser1.wav"));
		super.addSound(new CVMSound(soundExplosion, "music/explosion.wav"));
		
	}
	
	public static SoundMng getInstance() {
		if (instance == null) {
			instance = new SoundMng();
		}
		
		return instance;
	}
	

}
