package com.almas.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

//        Music rockMusic=context.getBean("musicBean", Music.class);
//
//       Music music=context.getBean("musicBean", Music.class);
//       MusicPlayer musicPlayer=new MusicPlayer(music);
//       musicPlayer.playMusic();
//
//       Music classicalMusic=context.getBean("classicalMusic",Music.class);
//       MusicPlayer musicPlayer2=new MusicPlayer(classicalMusic);
//       musicPlayer2.playMusic();

//        MusicPlayer musicPlayer=context.getBean("musicPlayer",MusicPlayer.class);
//        musicPlayer.playMusic();

        Computer computer=context.getBean("computer", Computer.class);
        System.out.println(computer);

        context.close();
    }
}
