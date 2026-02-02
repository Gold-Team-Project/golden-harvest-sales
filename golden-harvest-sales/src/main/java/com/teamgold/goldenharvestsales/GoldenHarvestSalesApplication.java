package com.teamgold.goldenharvestsales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GoldenHarvestSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldenHarvestSalesApplication.class, args);
	}

}
