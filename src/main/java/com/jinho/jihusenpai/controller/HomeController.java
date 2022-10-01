package com.jinho.jihusenpai.controller;

import com.jinho.jihusenpai.service.GrassParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        GrassParser grassParser = new GrassParser();
        String userGitHubId = "binary-ho";
        String htmlSource = grassParser.getHtmlSource("https://github.com/" + userGitHubId);

        Document document = Jsoup.parse(htmlSource);
        String calenderClassString = ".ContributionCalendar-day";
        String dateString = "2022-09-29";
        String rectDateString = "rect[data-date=" + dateString + "]";
        String dataCountAttrString = "data-count";

        Elements dayComponent = document.select(calenderClassString).select(rectDateString);
        String dayContributionString = dayComponent.attr(dataCountAttrString);
        int dayContributionCount = Integer.parseInt(dayContributionString);

        System.out.println(dayContributionCount);
        return "home";
    }
}
