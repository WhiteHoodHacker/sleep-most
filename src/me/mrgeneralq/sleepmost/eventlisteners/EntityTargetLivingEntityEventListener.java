package me.mrgeneralq.sleepmost.eventlisteners;

import me.mrgeneralq.sleepmost.interfaces.ISleepFlag;
import me.mrgeneralq.sleepmost.interfaces.ISleepFlagService;
import me.mrgeneralq.sleepmost.interfaces.ISleepService;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class EntityTargetLivingEntityEventListener implements Listener{

	private final ISleepService sleepService;
	private final ISleepFlagService sleepFlagService;

	public EntityTargetLivingEntityEventListener(ISleepService sleepService, ISleepFlagService sleepFlagService) {
		this.sleepService = sleepService;
		this.sleepFlagService  = sleepFlagService;
	}

	@EventHandler
	public void onMobTarget(EntityTargetLivingEntityEvent event) {

		//check if target is a player
		if(!(event.getTarget() instanceof Player))
			return;

		//cast player
		Player player = (Player) event.getTarget();
		World world = player.getWorld();

		//check if player is asleep
		if(!player.isSleeping())
			return;

		//check if mob targeting is enabled for world
		ISleepFlag<Boolean> mobNoTargetFlag = sleepFlagService.getSleepFlag("mob-no-target");
		Boolean value = mobNoTargetFlag.getValue(world);

		if(!value)
			return;

		// cancel the event
		event.setCancelled(true);
	}

}
