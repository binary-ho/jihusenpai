package com.jinho.jihusenpai.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GrassParser {
    public String getHtmlSource(String url){
        try {
            URL targetUrl = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream(), "UTF-8"));
            StringBuilder html = new StringBuilder();
            String current = "";
            while ((current = reader.readLine()) != null) {
                html.append(current);
            }
            reader.close();
            return html.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getDayContributionCount(String userGitHubId, String dateString) {
        String htmlSource = this.getHtmlSource("https://github.com/" + userGitHubId);
        Document document = Jsoup.parse(htmlSource);
        String calenderClassString = ".ContributionCalendar-day";
//        String dateString = "2022-09-29";
        String rectDateString = "rect[data-date=" + dateString + "]";
        String dataCountAttrString = "data-count";

        Elements dayComponent = document.select(calenderClassString).select(rectDateString);
        String dayContributionString = dayComponent.attr(dataCountAttrString);
        return  Integer.parseInt(dayContributionString);
    }

    public int getDayContributionCount(String userGitHubId) {
        String htmlSource = this.getHtmlSource("https://github.com/" + userGitHubId);
        Document document = Jsoup.parse(htmlSource);
        String calenderClassString = ".ContributionCalendar-day";
        
        // 오늘거 가져오기
        String dateString = "2022-09-29";
        String rectDateString = "rect[data-date=" + dateString + "]";
        String dataCountAttrString = "data-count";

        Elements dayComponent = document.select(calenderClassString).select(rectDateString);
        String dayContributionString = dayComponent.attr(dataCountAttrString);
        return  Integer.parseInt(dayContributionString);
    }
    
    public void getDayContributionCountAll() {}


}
