package me.bluedyaishela.quantumpotion;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Potion implements Listener {

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event){
        Player player = event.getPlayer();

        if (player == null){
            return;
        }
        // Contenu de l'inventaire du joueur
        ItemStack[] inventory = player.getInventory().getContents();

        // Item qu'on a récupéré
        ItemStack itemPickup = event.getItem().getItemStack();



        for (int i = 0; i < inventory.length; i++) {


            if (inventory[i] == null) {
                continue;
            }

            // Vérifie si l'item récupéré est une potion
            if (itemPickup.getType() != Material.POTION){
                continue;

            }

            // Vérifie si l'item qu'on a dans l'inventaire est le meme que celui qu'on a récupéré
            if (!inventory[i].isSimilar(itemPickup)){
                continue;
            }

            int amountPotionIventory = inventory[i].getAmount();
            int amountPotionPickup = itemPickup.getAmount();
            // calcul du nombre de potion total
            int totalAmountPotion = amountPotionIventory + amountPotionPickup;

            if (totalAmountPotion <= 16){
                inventory[i].setAmount(totalAmountPotion);
                player.updateInventory();
                return;
            }

        }

    }
}
