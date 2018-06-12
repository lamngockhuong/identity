package com.ngockhuong.identity.config;

import java.util.HashMap;

public class Route {
    private static HashMap<String, String> routes;

    public static final String host = "/identity";
    public static final String home = "/";
    public static final String cpanel = "/cpanel";

    static {
        if (routes == null) {
            routes = new HashMap<String, String>();

            routes.put("host", host);
            routes.put("home", host + home);
            routes.put("cpanel", host + cpanel);
        }
    }

    public static HashMap<String, String> getRoutes() {
        return routes;
    }

    public static String getRoute(String name) {
        return routes.get(name);
    }
}
