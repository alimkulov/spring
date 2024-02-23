package com.almas.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component
public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private List<Music> musicList=new ArrayList<>();

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

//    private Music music1;
//    private Music music2;

   // @Autowired
//    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("classicalMusic") Music music2) {
//        this.music1 = music1;
//        this.music2 = music2;
//    }

    //    @Autowired
//    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
//        this.classicalMusic = classicalMusic;
//        this.rockMusic = rockMusic;
//    }

    //    public MusicPlayer(Music music) {
//        this.music = music;
//    }
//
//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }


    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void  playMusic() {
//        for (Music music: musicList) {
//            System.out.println("Playing: " + music.getSong());
//        }
        Random rand=new Random();
        Music music=musicList.get(rand.nextInt(musicList.size()));
        System.out.println("Playing: " + music.getSong());
    }
}