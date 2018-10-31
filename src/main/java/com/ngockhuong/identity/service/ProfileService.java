package com.ngockhuong.identity.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ngockhuong.identity.model.Profile;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class ProfileService {
    private static final String dataFileName = "profile.json";

    public Profile getProfile(HttpServletRequest request) throws IOException {
        String path = "/app/data";
//        String path = request.getServletContext().getRealPath("data");
        File dirFile = new File(path);

        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        ObjectMapper mapper = new ObjectMapper();
        Profile profile = mapper.readValue(new File(path + File.separator + dataFileName), Profile.class);

        return profile;
    }

    public String convertProfileToJson(Profile profile) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(profile);

        return json;
    }

    public void saveProfile(HttpServletRequest request, Profile profile) throws IOException {
        String path = "/app/data";
//        String path = request.getServletContext().getRealPath("data");
        File dirFile = new File(path);

        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File(path + File.separator + dataFileName), profile);
    }
}
