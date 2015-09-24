package e20150914.designpatterns.structural.adapter.domain.concrete.simplePlayers;

import e20150914.designpatterns.structural.adapter.domain.concrete.MediaType;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/14/15.
 */
public class AdvancedMediaAdapterTest extends TestCase {

    @Test
    public void testAdapter(){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play(MediaType.MP3,"file.mp3");
        assertEquals(MediaType.MP3, audioPlayer.getType());
        assertEquals("file.mp3", audioPlayer.getFileName());

        audioPlayer.play(MediaType.VIDEO, "file.mp4");
        assertEquals(MediaType.VIDEO, audioPlayer.getType());
        assertEquals("file.mp4", audioPlayer.getFileName());

        audioPlayer.play(MediaType.HOLOGRAM, "file.holo");
        assertEquals(MediaType.HOLOGRAM, audioPlayer.getType());
        assertEquals("file.holo", audioPlayer.getFileName());
    }
}