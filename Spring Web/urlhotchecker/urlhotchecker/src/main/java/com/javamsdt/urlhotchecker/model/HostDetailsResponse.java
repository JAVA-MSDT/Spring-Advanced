package com.javamsdt.urlhotchecker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class HostDetailsResponse {
    private String host;
    private String hostAddress;
    private String canonicalHostName;
    private String hostName;
    private boolean isReachable;
    private Map<String, Boolean> hostInfo;
    private String errorMessage;

}
