package jp.techacademy.yasuhiko.hato.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by hatoy37 on 2/22/17.
 */

public class Enemy extends GameObject {

    public static final float ENEMY_WIDTH = 1.0f;
    public static final float ENEMY_HEIGHT = 1.0f;

    public static final float ENEMY_MOVE_VELOCITY = 2.0f;


    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        velocity.y = ENEMY_MOVE_VELOCITY;
    }

    // 座標を更新する
    public void update(float deltaTime) {
        setX(getX());
        setY(getY() - velocity.y * deltaTime);
    }


}
