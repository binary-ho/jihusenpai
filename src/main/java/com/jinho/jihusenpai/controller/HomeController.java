package com.jinho.jihusenpai.controller;

import com.jinho.jihusenpai.service.GrassParserService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        GrassParserService grassParserService = new GrassParserService();
        System.out.println("grassParserService = " + grassParserService.getTodayContributionCount("binary-ho"));
        System.out.println("grassParserService = " + grassParserService.getYesterdayContributionCount("binary-ho"));
        return "home";
    }
}
