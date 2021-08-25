package moubiequest.api.data.quest;

/**
 * 有關玩家粒子特效管理介面
 * @author MouBieCat
 */
public interface ParticleData {

    /**
     * 獲取玩家是否能看見其他玩家的特效
     * @return 是否可看見
     */
    boolean isViewParticle();

    /**
     * 設定玩家是否能看見其他玩家的特效
     * @param status 狀態
     */
    void setViewParticle(final boolean status);

}
