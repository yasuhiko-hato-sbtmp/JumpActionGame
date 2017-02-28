package jp.techacademy.yasuhiko.hato.jumpactiongame;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;

/**
 * @author hatoy37
 * @date 2/27/17
 */

public class SoundManager {

    private SoundPool mSoundPool;
    private int mSoundIdJump;
    private int mSoundIdStar;
    private int mSoundIdDie;

    private Context mContext;
    private MediaPlayer mMediaPlayer;


    public SoundManager(Context context) {
        mContext = context;

        // for SEs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    // USAGE_MEDIA
                    // USAGE_GAME
                    .setUsage(AudioAttributes.USAGE_GAME)
                    // CONTENT_TYPE_MUSIC
                    // CONTENT_TYPE_SPEECH, etc.
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            mSoundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    // ストリーム数に応じて
                    .setMaxStreams(2)
                    .build();

            mSoundIdJump = mSoundPool.load(mContext, R.raw.jump, 1);
            mSoundIdStar = mSoundPool.load(mContext, R.raw.star, 1);
            mSoundIdDie = mSoundPool.load(mContext, R.raw.die, 1);

            // load が終わったか確認する場合
            mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                @Override
                public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                    Log.d("debug", "sampleId=" + sampleId);
                    Log.d("debug", "status=" + status);
                }
            });
        }

    }

    public void playSoundJump() {
        mSoundPool.play(mSoundIdJump, 1.0f, 1.0f, 0, 0, 1);
    }
    public void playSoundStar() {
        mSoundPool.play(mSoundIdStar, 1.0f, 1.0f, 0, 0, 1);
    }
    public void playSoundDie() {
        mSoundPool.play(mSoundIdDie, 1.0f, 1.0f, 0, 0, 1);
    }

    public void startBgmFloating(){
        mMediaPlayer = MediaPlayer.create(mContext, R.raw.bgm_floating);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }
    public void startBgmClear(){
        mMediaPlayer = MediaPlayer.create(mContext, R.raw.bgm_clear);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }
    public void stopBgm(){
        if(mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }


}
