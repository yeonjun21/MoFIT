package projectmofit.mofit.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MyPageController {

    // TODO 마이페이지 조회(본인 페이지만 조회 가능해야), 내 모임 조회

    @GetMapping("/{id}")
    public String myPage(@PathVariable int id) {


        return "";
    }
}
