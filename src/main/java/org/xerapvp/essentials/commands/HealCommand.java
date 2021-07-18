package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffectType;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class HealCommand {


    @Command(name = "heal", permission = "core.heal")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtils.translate("&6&l/Heal: &6You have successfully healed your self." + ""));
            player.setHealth(player.getMaxHealth());
            player.removePotionEffect(PotionEffectType.BLINDNESS);
            player.removePotionEffect(PotionEffectType.CONFUSION);
            player.removePotionEffect(PotionEffectType.SLOW);
            player.removePotionEffect(PotionEffectType.POISON);
            player.removePotionEffect(PotionEffectType.WITHER);
            return;
        }

        if (player.hasPermission("core.heal.other")) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == player) {
                player.sendMessage(ChatUtils.translate("&cYou cannot heal this player."));
                return;
            }

            if (target != null) {
                player.sendMessage(ChatUtils.translate("&6&l(!) &6You have healed &f" + target.getName() + "&6."));
                target.sendMessage(ChatUtils.translate("&6&l/Heal: &6You have successfully healed your self."));
                target.setHealth(player.getMaxHealth());
                target.removePotionEffect(PotionEffectType.BLINDNESS);
                target.removePotionEffect(PotionEffectType.CONFUSION);
                target.removePotionEffect(PotionEffectType.SLOW);
                target.removePotionEffect(PotionEffectType.POISON);
                target.removePotionEffect(PotionEffectType.WITHER);

            } else {
                player.sendMessage(ChatUtils.exist);
            }

        }


    }


}
