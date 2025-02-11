package com.epam.engx.cleancode.functions.task2;


import java.util.Map;


public class SitePage {

    private static final String HTTP = "http://";
    private static final String EDITABLE = "/?edit=true";
    private static final String DOMAIN = "mysite.com";


    private String siteGroup;
    private String userGroup;

    public SitePage(String siteGroup, String userGroup) {
        this.siteGroup = siteGroup;
        this.userGroup = userGroup;
    }

    public String getEditablePageUrl(Map<String, String> parameters) {
        String url = "";
        for (Map.Entry<String, String> param : parameters.entrySet())
            url += "&" + param.getKey() + "=" + param.getValue();
        return HTTP + DOMAIN + EDITABLE + url + getAttributes();
    }

    private String getAttributes() {
        return "&siteGrp=" + siteGroup + "&userGrp=" + userGroup;
    }


}
