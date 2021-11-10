package com.wenance.cripto;

import java.util.Timer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CriptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriptoApplication.class, args);
		
		Timer timer = new Timer();
		MyTaskTimer taskTimer = new MyTaskTimer();
		timer.schedule(taskTimer,1,10000);
	}

}
