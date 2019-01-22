package com.httpsapi.hackerrankcontest.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import com.google.gson.Gson;
// https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1
// https://stackoverflow.com/questions/48448432/fragment-of-missing-code-in-the-solution-movie-titles-complete-a-challenge-more

class MovieInfo {

    private String  Poster;
    private String  Title;
    private String  Type;
    private Integer Year;
    private String  imdbID;

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        this.Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        this.Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

}

class BaseRespone {

    private String          page;
    private Integer         per_page;
    private Integer         total;
    private Integer         total_pages;
    private List<MovieInfo> data = null;

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

    public List<MovieInfo> getData() {
        return data;
    }

    public void setData(List<MovieInfo> data) {
        this.data = data;
    }

}

public class HttpsMoviewTitlesHackerRank {

    public void testIt(String subTitle) {
        int page = 1;
        Count c = new Count();
        c.count = 0;
        List<String> titleList = new ArrayList<String>();
        BaseRespone baseResponse = getMovieResponse(subTitle, page);
        titleList.addAll(printOutput(baseResponse, c));

        if (baseResponse.getTotalPages() != null) {
            page = baseResponse.getTotalPages();
        }

        for (int i = 2; i <= page; i++) {
            baseResponse = getMovieResponse(subTitle, i);
            titleList.addAll(printOutput(baseResponse, c));
        }
        Collections.sort(titleList);
        for (String title : titleList) {
            System.out.println(title);
        }
    }

    private List printOutput(BaseRespone countries, Count c) {
        List<String> titleList = new ArrayList<String>();
        try {

            for (MovieInfo data : countries.getData()) {
                titleList.add(data.getTitle());
            }
            // System.out.println(c.count);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return titleList;

    }

    private BaseRespone getMovieResponse(String subTitle, int page) {

        String url_u = " https://jsonmock.hackerrank.com/api/movies/search/?Title=" + subTitle + "&page=" + page;
        URL url;
        BaseRespone baseRespone = null;
        try {

            StringBuilder sb = new StringBuilder("");
            String input;
            Gson gson = new Gson();

            url = new URL(url_u);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            print_https_cert(con);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((input = br.readLine()) != null) {
                sb.append(input);
            }
            br.close();

            baseRespone = gson.fromJson(sb.toString(), BaseRespone.class);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return baseRespone;
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
