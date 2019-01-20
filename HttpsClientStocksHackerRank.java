package com.httpsapi.hackerrankcontest.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import com.google.gson.Gson;

//https://github.com/a9ma2656/wiki/wiki/Country-Populations
//String url_u =
//"https://jsonmock.hackerrank.com/api/stocks/?key="+"1-January-2000&page=1";
class Stock {

    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;

    public Stock() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

}

class Stocks {

    private String      page;
    private Integer     per_page;
    private Integer     total;
    private Integer     total_pages;
    private List<Stock> data = null;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return per_page;
    }

    public void setPer_page(Integer perPage) {
        this.per_page = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return total_pages;
    }

    public void setTotal_pages(Integer totalPages) {
        this.total_pages = totalPages;
    }

    public List<Stock> getData() {
        return data;
    }

    public void setData(List<Stock> data) {
        this.data = data;
    }

}

public class HttpsClientStocksHackerRank {

    public Map<String, Stock> stockMap = new HashMap<String, Stock>();

    public void testIt(String firstDate, String lastDate, String weekDay) {
        int page = 1;
        Stocks stocks = getStocks("", page);

        if (stocks.getTotalPages() != null) {
            page = stocks.getTotalPages();
        }
        saveInMap(stocks);
        try {

            for (int i = 2; i <= page; i++) {
                stocks = getStocks("", 1);
                saveInMap(stocks);

            }

            printOutput(firstDate, lastDate, weekDay, stocks);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    private void saveInMap(Stocks stocks) {
        for (Stock stock : stocks.getData()) {
            stockMap.put(stock.getDate(), stock);
        }
    }

    private void printOutput(String firstDate, String lastDate, String weekDay, Stocks stocks) {
        try {
            String days[] = { "Monday", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
            int day = Arrays.asList(days).indexOf(weekDay) + 2;
            String fDate = firstDate;

            DateFormat format = new SimpleDateFormat("d-MMMM-yyyy", Locale.ENGLISH);
            Date olddate = format.parse(fDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(olddate);
            int dayOfW = day - calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfW >= 0) {
                calendar.add(Calendar.DAY_OF_WEEK, dayOfW);
            } else {
                calendar.add(Calendar.DAY_OF_WEEK, 7 + dayOfW);
                // calendar.add(Calendar.DAY_OF_WEEK,day);
            }

            fDate = format.format(calendar.getTime());

            while (true) {

                if (stockMap.containsKey(fDate)) {

                    if (format.parse(fDate).after(format.parse(lastDate))) {
                        break;
                    }
                    System.out.print(stockMap.get(fDate).getDate());
                    System.out.print(" " + stockMap.get(fDate).getHigh());
                    System.out.println(" " + stockMap.get(fDate).getLow());

                }
                olddate = format.parse(fDate);
                calendar = Calendar.getInstance();
                calendar.setTime(olddate);
                calendar.add(Calendar.DAY_OF_YEAR, 7);

                fDate = format.format(calendar.getTime());
            }

        } catch (ParseException e) {

            e.printStackTrace();
        }

    }

    private Stocks getStocks(String key, int page) {
        String https_url = "https://jsonmock.hackerrank.com/api/stocks/?";
        String url_u = "https://jsonmock.hackerrank.com/api/stocks/?key=" + key + "&page=" + page;
        URL url;
        Stocks stocks = null;
        try {
            url = new URL(url_u);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            print_https_cert(con);

            // dump all the content
            StringBuilder sb = new StringBuilder("");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;

            while ((input = br.readLine()) != null) {
                sb.append(input);
                // System.out.println(input);
            }
            br.close();

            Gson gson = new Gson();

            stocks = gson.fromJson(sb.toString(), Stocks.class);

            /*
             * for (Stock st : stocks.getData()) { System.out.print(" Date " +
             * st.getDate()); System.out.print(" Low " + st.getLow());
             * System.out.print(" High " + st.getHigh()); }
             */
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return stocks;
    }

    private void print_https_cert(HttpsURLConnection con) {
        if (con != null) {
            try {
                System.out.println("Response Code : " + con.getResponseCode());
                System.out.println("Cipher Suite : " + con.getCipherSuite());
                System.out.println("\n");
                Certificate[] certs = con.getServerCertificates();
                for (Certificate cert : certs) {
                    System.out.println("Cert Type : " + cert.getType());
                    System.out.println("Cert Hash Code : " + cert.hashCode());
                    System.out.println("Cert Public Key Algorithm : " + cert.getPublicKey().getAlgorithm());
                    System.out.println("Cert Public Key Format : " + cert.getPublicKey().getFormat());
                    System.out.println("\n");
                }

            } catch (SSLPeerUnverifiedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
