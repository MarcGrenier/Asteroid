package ca.qc.cvm.asteroid;

import org.andengine.entity.IEntity;
import org.andengine.entity.IEntityFactory;
import org.andengine.entity.particle.ParticleSystem;
import org.andengine.entity.particle.emitter.PointParticleEmitter;
import org.andengine.entity.particle.initializer.BlendFunctionParticleInitializer;
import org.andengine.entity.particle.initializer.VelocityParticleInitializer;
import org.andengine.entity.particle.modifier.AlphaParticleModifier;
import org.andengine.entity.particle.modifier.ColorParticleModifier;
import org.andengine.entity.particle.modifier.ExpireParticleInitializer;
import org.andengine.entity.sprite.Sprite;

import android.opengl.GLES20;

import ca.qc.cvm.cvmandengine.scene.CVMAbstractScene;
import ca.qc.cvm.cvmandengine.util.CVMParticleSystemUtils;

public class ParticlesFactory {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addExplosion(float x, float y, final CVMAbstractScene scene) {
		
		float minRate = 5; // nombre de particules minimum par seconde
		float maxRate = 20; // nombre de particules maximum par seconde
		int maxParticles = 30; // nombre de particules maximum 
		
		// L'endroit où sont créées les particules
		final PointParticleEmitter pointEmitter = new PointParticleEmitter(x, y);
		
		final ParticleSystem particleSystem = new ParticleSystem(new IEntityFactory<Sprite>() {
			@Override
			public Sprite create(final float pX, final float pY) {
				return new Sprite(pX, pY, TextureMng.getInstance().getTextureById(TextureMng.PARTICLE_POINT),
								  scene.getVertexBufferObjectManager());
			}
		}, pointEmitter, minRate, maxRate, maxParticles);
		
		particleSystem.addParticleInitializer(new BlendFunctionParticleInitializer<Sprite>(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE));
		
		// Chaque particule aura une vélocité variable entre -20 et 20 sur les deux axes
		particleSystem.addParticleInitializer(new VelocityParticleInitializer(-20, 20, -20, 20));
		
		// disparait après 3 sec
		particleSystem.addParticleInitializer(new ExpireParticleInitializer(3));
		particleSystem.addParticleModifier(new AlphaParticleModifier(0, 3f, 1, 0));
		
		CVMParticleSystemUtils.setParticleSystemDuration(scene, particleSystem, 3, 5);
		
		//seconde min, seconde max, redFrom, redTo, greenFrom, greenTO, blueFrom, blueTo 
		particleSystem.addParticleModifier(new ColorParticleModifier<IEntity>(0, 0.3f, 1f, 0f, 1f, 0, 1f, 1));
		
		
		scene.attachChild(particleSystem);
		
		
		
		
		
	}
}
