package me.bluedyaishela.quantumpotion;

import org.bukkit.plugin.java.JavaPlugin;

public final class QuantumPotion extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Le plugin viens de s'allumer.");

        this.getServer().getPluginManager().registerEvents(new Potion(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Le plugin viens de s'eteindre.");
    }
}
