package com.itec0401.backend.login.controller;

import com.itec0401.backend.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/code/{registrationId}")
    public void oauthLogin(@RequestParam String code, @PathVariable String registrationId) {
        loginService.oauthLogin(code, registrationId);
    }
}
