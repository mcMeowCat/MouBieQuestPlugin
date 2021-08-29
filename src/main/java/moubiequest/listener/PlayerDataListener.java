package moubiequest.listener;

import moubiequest.api.particle.ParticleTimer;
import moubiequest.api.particle.ParticleType;
import moubiequest.core.data.quest.PlayerQuestData;
import moubiequest.core.particle.TopToBottomParticle;
import moubiequest.core.particle.type.ParticleBase;
import moubiequest.core.particle.type.ParticleDustOptions;
import moubiequest.main.MouBieCat;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 有關於玩家資料的事件監聽都在這
 * @author MouBieCat
 */
public final class PlayerDataListener
        implements Listener {

    /**
     * 玩家加入伺服器事件
     * @param event 事件
     */
    @EventHandler
    public void onJoin(final @NotNull PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        MouBieCat.getInstance().getPlayerDataManager().add(player, new PlayerQuestData(player));
    }

    /**
     * 玩家離開伺服器事件
     * @param event 事件
     */
    @EventHandler
    public void onQuit(final @NotNull PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        MouBieCat.getInstance().getPlayerDataManager().remove(player);
    }

    @EventHandler
    public void onTestJoin(final @NotNull PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        final List<ParticleType> particles = new ArrayList<>();
        particles.add(new ParticleBase(Particle.DRAGON_BREATH));
        particles.add(new ParticleDustOptions(Particle.REDSTONE, new Particle.DustOptions(Color.RED, 5)));
        ParticleTimer timer = new TopToBottomParticle(player, particles);
        timer.start();
    }

}
