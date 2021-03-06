package jp.techacademy.yasuhiko.hato.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by hatoy37 on 2/22/17.
 */

public class Ufo extends GameObject {
    // 横幅、高さ
    public static final float UFO_WIDTH = 2.0f;
    public static final float UFO_HEIGHT = 1.3f;

    public Ufo(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(UFO_WIDTH, UFO_HEIGHT);
    }
}
