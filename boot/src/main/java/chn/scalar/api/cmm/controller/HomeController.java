package chn.scalar.api.cmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

// import com.example.demo.usr.domain.User;


@Controller
@SessionAttributes({"ctx", "mem", "cmm", "prdt", "board", "adm"})
public class HomeController {
    @Autowired HttpSession session;
    @Autowired HttpServletRequest request;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home(HttpSession session, HttpServletRequest request) {
        logger.info("ctx");
        String ctx = request.getContextPath();
        return "index";
    }

    @GetMapping("/move/{dir}/{page}")
    public String move(@PathVariable String dir, @PathVariable String page) {
        logger.info("이동 : " + dir + "/" + page);
        return String.format("views:%s/%s", dir, page);
    }
}