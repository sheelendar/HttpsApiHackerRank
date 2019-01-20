package com.httpsapi.hackerrankcontest.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import com.google.gson.Gson;

class CData {

    private String       name;
    private String       nativeName;
    private List<String> topLevelDomain = null;
    private String       alpha2Code;
    private String       numericCode;
    private String       alpha3Code;
    private List<String> currencies     = null;
    private List<String> callingCodes   = null;
    private String       capital;
    private List<String> altSpellings   = null;
    private String       relevance;
    private String       region;
    private String       subregion;
    private List<String> language       = null;
    private List<String> languages      = null;
    private Translations translations;
    private Integer      population;
    private List<Double> latlng         = null;
    private String       demonym;
    private List<String> borders        = null;
    private List<String> timezones      = null;
    private Integer      area;
    private Double       gini;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getGini() {
        return gini;
    }

    public void setGini(Double gini) {
        this.gini = gini;
    }

}

class Country {

    private Integer     page;
    private Integer     per_page;
    private Integer     total;
    private Integer     total_pages;
    private List<CData> data = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
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

    public List<CData> getData() {
        return data;
    }

    public void setData(List<CData> data) {
        this.data = data;
    }

}

class Translations {

    private String de;
    private String es;
    private String fr;
    private String it;
    private String ja;
    private String nl;
    private String hr;

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

}

class Count {
    public int count;
}

public class HttpsPopulationHackerRank {

    public void testIt(String sub, long populatoin) {
        int page = 1;
        Count c = new Count();
        c.count = 0;
        Country countries = getCountries(sub, page);
        printOutput(countries, populatoin, c);

        if (countries.getTotalPages() != null) {
            page = countries.getTotalPages();
        }

        for (int i = 2; i <= page; i++) {
            countries = getCountries("", 1);
            printOutput(countries, populatoin, c);
        }
        System.out.print(c.count);
    }

    private void printOutput(Country countries, long populatoin, Count c) {
        try {

            for (CData data : countries.getData()) {
                if (data.getPopulation() > populatoin) {
                    c.count++;
                }
            }
          //  System.out.println(c.count);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private Country getCountries(String sub, int page) {

        String url_u = "https://jsonmock.hackerrank.com/api/countries/search?name=" + sub + "&page=" + page;
        URL url;
        Country countries = null;
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

            countries = gson.fromJson(sb.toString(), Country.class);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return countries;
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
