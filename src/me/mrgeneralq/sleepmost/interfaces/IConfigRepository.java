package me.mrgeneralq.sleepmost.interfaces;

import org.bukkit.World;

public interface IConfigRepository {

    public double getPercentageRequired(World world);
    public boolean containsWorld(World world);
    public String getString(String string);

    public int getCooldown();
    public boolean getMobNoTarget(World world);
    public boolean getUseExempt(World world);
    public String getPrefix();
    public void reloadConfig();
    public void addWorld(World world);
    public void removeWorld(World world);
    public void disableForWorld(World world);
    public void setFlag(World world, String flag, Object value);
    public Object getFlag(World world, String flag);
}
