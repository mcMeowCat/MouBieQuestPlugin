package moubiequest.core.particle.type;

import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 ItemStack
 * @author MouBieCat
 */
public final class ParticleItemStack
        extends ParticleTypeAbstract<ItemStack> {

    /**
     * 建構子
     * @param particle       特效類型
     * @param particleObject 特效資料物件
     */
    public ParticleItemStack(final @NotNull Particle particle, final @NotNull ItemStack particleObject) {
        super(particle, particleObject);
    }

}
