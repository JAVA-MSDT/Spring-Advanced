package com.javamsdt.urlhotchecker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDetailsRequest {
    private String url;
    private int timeout;
}
