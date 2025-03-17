package com.javamsdt.urlhotchecker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class UrlDetailsResponse {
    private String url;
    private String hostAddress;
    private String canonicalHostName;
    private String hostName;
    private boolean isReachable;
    private String responseMessage;
    private Map<String, String> urlDetails;
    private Map<String, List<String>> headerDetails;
    private int statusCode;
    private String errorMessage;

}
