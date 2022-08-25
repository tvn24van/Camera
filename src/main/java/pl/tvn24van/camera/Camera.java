package pl.tvn24van.camera;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.server.play.CameraPacket;
import net.minestom.server.network.packet.server.play.RespawnPacket;

/**
	* Utility for setting Player's Camera to any type
	* that Minecraft support including the regular view
	* @author tvn24van
	*/
public final class Camera {

	public enum Type{
		CREEPER(EntityType.CREEPER),
		SPIDER(EntityType.SPIDER),
		ENDERMAN(EntityType.ENDERMAN),
		REGULAR(EntityType.PLAYER);

		private final EntityType entityType;

		Type(EntityType entityType) {
			this.entityType = entityType;
		}

		public EntityType getEntityType() {
			return entityType;
		}
	}

	public static void set(Player player, Type cameraType){

		if (cameraType.equals(Type.REGULAR)){
			player.stopSpectating();
			return;
		}

		final Entity entity = new Entity(cameraType.getEntityType());
		entity.setAutoViewable(false);
		entity.addViewer(player); // in order to work player needs to see this entity
		entity.setInstance(player.getInstance(), player.getPosition());

		final CameraPacket cameraPacket = new CameraPacket(entity);

		final RespawnPacket respawnPacket = new RespawnPacket(
				player.getDimensionType(),
				player.getDimensionType().getName().asString(),
				0,
				player.getGameMode(),
				player.getGameMode(),
				false,
				false,
				true
		);

		player.sendPackets(cameraPacket, respawnPacket);
		player.teleport(entity.getPosition());
		player.getInventory().update();
		player.setHeldItemSlot(player.getHeldSlot());
		entity.remove();
	}

}