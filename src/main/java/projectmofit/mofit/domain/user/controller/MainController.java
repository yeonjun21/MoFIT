package projectmofit.mofit.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @ModelAttribute("regions")
    public List<String> regions() {
        List<String> regions = new ArrayList<>();
        regions.add("강남구"); regions.add("강동구"); regions.add("강북구");
        regions.add("강서구"); regions.add("관악구"); regions.add("광진구");
        regions.add("구로구"); regions.add("금천구"); regions.add("노원구");
        regions.add("도봉구"); regions.add("동대문구"); regions.add("동작구");
        regions.add("마포구"); regions.add("서대문구"); regions.add("서초구");
        regions.add("성동구"); regions.add("성북구"); regions.add("송파구");
        regions.add("양천구"); regions.add("영등포구"); regions.add("용산구");
        regions.add("은평구"); regions.add("종로구"); regions.add("중구");
        regions.add("중랑구");
        return regions;
    }
}
