package winnersonx;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;

import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.core.audio.AudioSendHandler;

public class AudioPlayerSendHandler implements AudioSendHandler {
    private final AudioPlayer audioPlayer;
   public AudioFrame lastFrame;

    /**
     * @param audioPlayer Audio player to wrap.
     */
    public AudioPlayerSendHandler(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public boolean canProvide() {
        if (lastFrame == null) {
            lastFrame = audioPlayer.provide();

        }

        return lastFrame != null;
    }

    @Override
    public byte[] provide20MsAudio() {
        return new byte[0];
    }


    @Override
    public boolean isOpus() {
        return true;
    }

}