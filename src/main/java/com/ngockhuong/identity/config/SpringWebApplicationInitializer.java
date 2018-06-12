package com.ngockhuong.identity.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.io.File;

public class SpringWebApplicationInitializer implements WebApplicationInitializer {

    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ApplicationContextConfig.class);

        // Dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(applicationContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        dispatcher.setInitParameter("contextClass", applicationContext.getClass().getName());

        servletContext.addListener(new ContextLoaderListener(applicationContext));

        // Config upload file
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(null,
                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
        dispatcher.setMultipartConfig(multipartConfigElement);

        // UTF-8 Character Filter
        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
    }
}
