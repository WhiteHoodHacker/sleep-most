package me.mrgeneralq.sleepmost.events;

import me.mrgeneralq.sleepmost.enums.SleepSkipCause;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SleepSkipEvent extends Event {

	private final static HandlerList handlers = new HandlerList();
	private final World world;
	private final SleepSkipCause cause;

	public SleepSkipEvent(World world, SleepSkipCause cause){
		this.world = world;
		this.cause = cause;
	}
	public SleepSkipCause getCause() {
		return cause;
	}
	public World getWorld(){
		return this.world;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
