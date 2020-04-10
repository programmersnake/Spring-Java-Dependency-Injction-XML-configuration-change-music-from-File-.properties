import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private String music;
    private String name;
    private int volume;

    public void setMusic(String music) {
        this.music = music;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void play(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.tld");
        Music musicpl=null;
        if(music.equals("RockMusic"))
            musicpl = context.getBean("RockMusicBean", RockMusic.class);
        else if(music.equals("PopMusic"))
            musicpl = context.getBean("PopMusicBean", PopMusic.class);
        else
            musicpl = context.getBean("ClassicalMusicBean", ClassicalMusic.class);
        musicpl.play();
    }
}
