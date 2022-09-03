package pl.tvn24van.camera.extension;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.extensions.Extension;
import pl.tvn24van.camera.extension.command.CameraCommand;

public final class CameraExtension extends Extension{
	private final static Command command = new CameraCommand();

	@Override
	public void initialize() {
		MinecraftServer.getCommandManager().register(command);
	}

	@Override
	public void terminate() {
		MinecraftServer.getCommandManager().unregister(command);
	}

}
