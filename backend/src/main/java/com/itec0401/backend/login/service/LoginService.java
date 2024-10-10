package com.itec0401.backend.login.service;

public interface LoginService {
    void oauthLogin(String code, String registrationId);
}
