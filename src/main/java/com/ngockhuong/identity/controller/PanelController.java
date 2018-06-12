package com.ngockhuong.identity.controller;

import com.ngockhuong.identity.config.Route;
import com.ngockhuong.identity.model.Profile;
import com.ngockhuong.identity.model.Social;
import com.ngockhuong.identity.service.ProfileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@PropertySource("classpath:config.properties")
public class PanelController extends AbstractController {

    @Autowired
    ProfileService service;

    @Autowired
    Environment env;

    @RequestMapping(value = Route.cpanel, method = RequestMethod.GET)
    public ModelAndView cpanel(HttpServletRequest request, ModelMap model) {
        preRender(model);

        Profile profile = null;

        try {
            profile = service.getProfile(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (profile == null) {
            profile = new Profile();
        }

        // Init social
        Social social = profile.getSocial();

        if (social == null) {
            social = new Social();
        }

        // Prepare social data for the form
        String socials = social.toFormList();

        ModelAndView modelAndView = new ModelAndView("cpanel");
        modelAndView.addObject("profile", profile);
        modelAndView.addObject("socials", socials);

        return modelAndView;
    }

    @RequestMapping(value = Route.cpanel, method = RequestMethod.POST)
    public String saveProfile(
        HttpServletRequest request,
        @ModelAttribute("profile") Profile profile,
        @RequestParam("avatar") MultipartFile file,
        @RequestParam("socials") String socials,
        @RequestParam("robot") String robot,
        BindingResult result,
        ModelMap model
    ) {
        // Prepare and upload the avatar
        String filename = file.getOriginalFilename();
        String avatarDirPath = env.getProperty("avatarDirPath");
        String dirPath = request.getServletContext().getRealPath(avatarDirPath);
        String avatar = env.getProperty("defaultAvatarName") + "." + FilenameUtils.getExtension(filename).toLowerCase();
        File dirFile = new File(dirPath);

        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        try {
            file.transferTo(new File(dirPath + File.separator + avatar));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!filename.isEmpty()) {
            avatar = avatarDirPath + "/" + avatar;
        } else {
            avatar = env.getProperty("defaultAvatar");
        }

        // Preprocessing social data
        socials = socials.replaceAll(":", "=")
                .replaceAll("'", "");

        try {
            // Profile data
            Social social = new Social();
            social.getFromProperties(socials);

            profile.setSocial(social);
            profile.setAvatar(avatar);

            // Save profile data to json file
            service.saveProfile(request, profile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:" + Route.home;
    }
}
