package com.almas.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
      //  ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);

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

//        Computer computer=context.getBean("computer", Computer.class);
//        System.out.println(computer);

        MusicPlayer musicPlayer=context.getBean("musicPlayer",MusicPlayer.class);
        musicPlayer.playMusic();

//        ClassicalMusic classicalMusic1=context.getBean("classicalMusic",ClassicalMusic.class);
//        ClassicalMusic classicalMusic2=context.getBean("classicalMusic",ClassicalMusic.class);
//        System.out.println(classicalMusic1==classicalMusic2);
        context.close();
    }
}
