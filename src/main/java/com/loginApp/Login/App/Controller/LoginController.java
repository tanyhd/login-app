package com.loginApp.Login.App.Controller;

import com.loginApp.Login.App.dto.UserDto;
import com.loginApp.Login.App.model.User;
import com.loginApp.Login.App.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @Valid
            @ModelAttribute("user")
            UserDto userDto,
            BindingResult result,
            Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null) {
            result.rejectValue("email", null, "User already registered");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/registration";
        }

        userService.saveUser(userDto);
        return "redirect:/registration?success";
    }


}
