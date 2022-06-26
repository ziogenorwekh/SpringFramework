package com.example.springframwork.controller;

import com.example.springframwork.dao.User;
import com.example.springframwork.exception.NotNullParameterException;
import com.example.springframwork.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
@Slf4j
@SessionAttributes("userInfo")
public class UserController {


    private final UserService userService;
    private final MessageSource messages;

    @Autowired
    public UserController(UserService userService, MessageSource messages) {
        this.userService = userService;
        this.messages = messages;
    }

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        // setAllowedFields 메서드는 설정한 필드 외의 HTTP 파라미터가 오면 바인딩에서 제외된다.
//        // 지금은 email 만 변경할 수 있다.
//        // 이거하면 회원가입에서 문제 일어난다. 왜냐하면 모든 Post 에서 email 만 허용했기 때문에
//        dataBinder.setAllowedFields("email");
//    }

    @GetMapping("/")
    public String userList(Model model) {
        // osName 긁어온다.
//        @Value("#{systemProperties['os.name']}") String osName
        List<User> userList = userService.getAll();
//        log.debug(osName);
        model.addAttribute("userList", userList);
        return "userList";
    }

    @GetMapping("/signUp")
    public String getSignUp(@SessionAttribute(value = "userInfo", required = false) User user, Model model) {
        model.addAttribute("user", user);
        return "signUp";
    }

    // form data 는 애초에 id 태그로 받는게 아니라
    // name 태그로 받는 것
    @PostMapping("/signUp")
    // 498 p modelAttribute 의 오류
    public String signUp(@ModelAttribute User user, Model model,
                         RedirectAttributes attributes, SessionStatus sessionStatus) {
        try {
            log.debug(user.toString());
            log.debug(user.getEmail() == null ? "isNull" : "isNotNull");
            userService.add(user);
            // 불필요한 세션은 지워줘야 합니다.
            sessionStatus.setComplete();
            return userList(model);
        } catch (NotNullParameterException e) {
            attributes.addFlashAttribute("message",
                    messages.getMessage("signup.failure", null, Locale.getDefault()));
            model.addAttribute("userInfo", user);
            return "redirect:/signUp";
        }
    }

    @GetMapping("/viewUser")
    public String view(int id, Model model, HttpSession session) {
        User byOneUser = userService.getByOneUser(id);
        log.error(byOneUser.getName());
        model.addAttribute("user", byOneUser);
        session.setAttribute("id", id);
        return "viewUser";
    }

    @PostMapping("/viewUser")
    public String views(@ModelAttribute User user, Model model,
                        @SessionAttribute("id") int id, SessionStatus sessionStatus) {
        user.setId(id);
        userService.userUpdate(user);
        model.addAttribute("user", user);
        if (!sessionStatus.isComplete()) {
            log.info("session Exist");
        }
        sessionStatus.setComplete();
        if (sessionStatus.isComplete()) {
            log.info("session is complete");
        }
        return "redirect:/viewUser?id=" + user.getId();
//        return "redirect:/viewUser";
    }

    @PostMapping("/viewUserOnlyEmail")
    public String viewUser(@SessionAttribute("id") int id, SessionStatus sessionStatus
            , @ModelAttribute User user, Model model) {
        user.setId(id);
        userService.userUpdate(user);
        model.addAttribute("user", user);
        sessionStatus.setComplete();
        return "redirect:/viewUser?id=" + user.getId();
    }

    // 이렇게도 가능
//    @GetMapping("/viewUser")
//    public User viewObject(String name) {
//        log.debug("viewObject : " + name);
//        return userService.getByOneUser(name);
//    }

    @GetMapping("/testResponse")
    @ResponseBody
    public String response() {
        return "<html><body>안녕 컨트롤러야</body></html>";
    }


}
