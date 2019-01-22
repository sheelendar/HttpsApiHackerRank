package com.httpsapi.hackerrankcontest.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://github.com/a9ma2656/wiki/wiki/Country-Populations
// String url_u =
// "https://jsonmock.hackerrank.com/api/stocks/?key="+"1-January-2000&page=1";

@SpringBootApplication
public class ParseHttpsResponseGsonAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ParseHttpsResponseGsonAppApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        new HttpsMoviewTitlesHackerRank().testIt("spiderman");
      //  new HttpsClientStocksHackerRank().testIt("1-January-2000", "21-February-2000", "Monday");
       // new HttpsPopulationHackerRank().testIt("un",100090);

    }
}
