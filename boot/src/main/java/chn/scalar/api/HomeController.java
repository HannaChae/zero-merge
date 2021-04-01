package chn.scalar.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return String.format("Web Server Started At %s ", new SimpleDateFormat("MM-dd HH:mm").format(new Date()));
    }
}
