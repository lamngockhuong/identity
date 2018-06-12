package com.ngockhuong.identity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ngockhuong.identity.config.Route;
import com.ngockhuong.identity.model.Profile;
import com.ngockhuong.identity.model.Social;
import com.ngockhuong.identity.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class HomeController extends AbstractController {

    @Autowired
    ProfileService service;

    @RequestMapping(Route.home)
    public ModelAndView index(HttpServletRequest request, ModelMap model) {
        preRender(model);

        Profile profile = null;

        try {
            profile = service.getProfile(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = null;

        if (profile == null) {
            modelAndView = new ModelAndView("redirect:" + Route.cpanel);
        } else {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("profile", profile);
        }

        return modelAndView;
    }
}
