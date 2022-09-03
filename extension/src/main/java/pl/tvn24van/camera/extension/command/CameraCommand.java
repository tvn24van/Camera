package pl.tvn24van.camera.extension.command;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentEnum;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestom.server.command.builder.condition.Conditions;
import net.minestom.server.entity.Player;
import pl.tvn24van.camera.Camera;

public class CameraCommand extends Command {

	public CameraCommand(){
		super("camera");

		ArgumentEnum<Camera.Type> cameraTypeArgument = ArgumentType.Enum("type", Camera.Type.class)
				.setFormat(ArgumentEnum.Format.LOWER_CASED);

		ArgumentEntity targetArgument = ArgumentType.Entity("player")
				.singleEntity(true).onlyPlayers(true);

		setDefaultExecutor((sender, context) -> {/*TODO help*/});

		addConditionalSyntax(Conditions::playerOnly, (sender, context) -> {
			Camera.set(sender.asPlayer(), context.get(cameraTypeArgument));
		}, cameraTypeArgument);

		addSyntax((sender, context) -> {
			Player target = context.get(targetArgument).findFirstPlayer(sender);
			Camera.set(target, context.get(cameraTypeArgument));
		}, cameraTypeArgument, targetArgument);

	}

}
