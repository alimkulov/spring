package com.almas.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@ComponentScan("com.almas.spring")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic() { return new JazzMusic(); }

    @Bean
    public MusicPlayer musicPlayer(){

        List<Music> musicList=new ArrayList<>();

        musicList.add(classicalMusic());
        musicList.add(rockMusic());
        musicList.add(jazzMusic());

        return new MusicPlayer(musicList);
    }

    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }
}
