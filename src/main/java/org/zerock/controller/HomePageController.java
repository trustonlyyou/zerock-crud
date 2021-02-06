package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    private final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @GetMapping("/")
    public String homePage() {
        logger.info("Client request URL : '/' ");
        return "index";
    }
}
