package com.mourad.soignemoibureau.model;

import java.util.Map;

public class SessionData {
    private static final SessionData instance = new SessionData();

    private Map<String, Object> adminData;

    private SessionData() {}

    public static SessionData getInstance() {
        return instance;
    }

    public Map<String, Object> getAdminData() {
        return adminData;
    }

    public void setAdminData(Map<String, Object> adminData) {
        this.adminData = adminData;
    }
}
