package com.jinho.jihusenpai.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GrassParserService {
    private String getHtmlSource(String url){
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

    private Document getHTMLDocument(String userGitHubId) {
        String htmlSource = this.getHtmlSource("https://github.com/" + userGitHubId);
        return Jsoup.parse(htmlSource);
    }

    private int getContributionCount(String userGitHubId, String dateString) {
        Document document = this.getHTMLDocument(userGitHubId);
        String calenderClassString = ".ContributionCalendar-day";

        DateService dateService = new DateService();
        String rectDateString = "rect[data-date=" + dateString + "]";
        String dataCountAttrString = "data-count";

        Elements dayComponent = document.select(calenderClassString).select(rectDateString);
        String dayContributionString = dayComponent.attr(dataCountAttrString);
        return  Integer.parseInt(dayContributionString);
    }

    public int getTodayContributionCount(String userGitHubId) {
        DateService dateService = new DateService();
        String dateString = dateService.getTodayDateString();
        return getContributionCount(userGitHubId, dateString);
    }

    public int getYesterdayContributionCount(String userGitHubId) {
        DateService dateService = new DateService();
        String dateString = dateService.getYesterdayDateString();
        return getContributionCount(userGitHubId, dateString);
    }
}
