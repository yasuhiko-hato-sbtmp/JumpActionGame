package jp.techacademy.yasuhiko.hato.jumpactiongame;

/**
 * Created by hatoy37 on 2/22/17.
 */

public interface ActivityRequestHandler {
    public void showAds(boolean show);

    public void playSoundJump();
    public void playSoundStar();
    public void playSoundDie();
    public void startBgmFloating();
    public void startBgmClear();
    public void stopBgm();
}
