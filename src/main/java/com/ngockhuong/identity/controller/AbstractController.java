package com.ngockhuong.identity.controller;

import com.ngockhuong.identity.config.Route;
import org.springframework.ui.ModelMap;

public abstract class AbstractController {
    protected void preRender(ModelMap model) {
        model.addAttribute("routes", Route.getRoutes());
    }
}
