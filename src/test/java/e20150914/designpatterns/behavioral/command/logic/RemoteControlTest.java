package e20150914.designpatterns.behavioral.command.logic;

import e20150914.designpatterns.behavioral.command.domain.abs.Command;
import e20150914.designpatterns.behavioral.command.domain.concrete.PauseCommand;
import e20150914.designpatterns.behavioral.command.domain.concrete.PlayCommand;
import e20150914.designpatterns.behavioral.command.domain.concrete.StopCommand;
import e20150914.designpatterns.behavioral.command.domain.concrete.Video;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class RemoteControlTest extends TestCase {

    @Test
    public void testCommand(){
        Video video = new Video();
        RemoteControl remote = new RemoteControl();

        Command play = new PlayCommand();
        play.setVideo(video);

        Command pause = new PauseCommand();
        pause.setVideo(video);

        Command stop = new StopCommand();
        stop.setVideo(video);

        remote.setCommand(play);
        remote.pressButton();
        assertEquals("Playing", video.getState());

        remote.setCommand(pause);
        remote.pressButton();
        assertEquals("Paused",video.getState());

        remote.setCommand(stop);
        remote.pressButton();
        assertEquals("Stopped",video.getState());

    }

}