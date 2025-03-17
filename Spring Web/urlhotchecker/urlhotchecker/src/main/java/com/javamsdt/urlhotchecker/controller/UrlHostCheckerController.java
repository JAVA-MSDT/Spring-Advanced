package com.javamsdt.urlhotchecker.controller;


import com.javamsdt.urlhotchecker.model.HostDetailsResponse;
import com.javamsdt.urlhotchecker.model.UrlDetailsRequest;
import com.javamsdt.urlhotchecker.model.UrlDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class UrlHostCheckerController {

    private static final String MALFORMED_ERROR_MESSAGE = "MalformedURLException: please match the url example: http://example.com";
    private static final String PROTOCOL_ERROR_MESSAGE = "ProtocolException: please add http:// protocol in the url example: http://example.com";
    private static final String TIMEOUT_ERROR_MESSAGE = "TimeoutException: Cannot connect to the desired url";
    private static final String IO_ERROR_MESSAGE = "IOException: Cannot connect to the desired url";
    private static final String UNKNOWN_HOST_ERROR_MESSAGE = "UnknownHostException: Cannot connect to the desired url";
    public static final String CANNOT_REACH_HOST = "Cannot reach the targeted host";


    /**
     * Method to check the availability of a host without any protocols
     * Request example {"url": "example.com","timeout": 1000}
     *
     * @param details details
     * @return response
     */
    @RequestMapping("/checkHostAvailability")
    @PostMapping
    public HostDetailsResponse hostDetailsResponse(@RequestBody UrlDetailsRequest details) {
        return fillHostDetailsResponse(details);
    }

    /**
     * Method to check the availability of an url with a protocol
     * Request example {"url": "http://example.com","timeout": 1000}
     *
     * @param details details
     * @return response
     */
    @RequestMapping("/checkUrlAvailability")
    @PostMapping
    public UrlDetailsResponse urlDetailsResponse(@RequestBody UrlDetailsRequest details) {
        return fillUrlDetailsResponse(details);
    }

    private UrlDetailsResponse fillUrlDetailsResponse(UrlDetailsRequest details) {
        UrlDetailsResponse responseDetails = new UrlDetailsResponse();
        URL url;
        HttpURLConnection connection;
        try {
            url = new URL(details.getUrl());
            InetAddress hostDetails = InetAddress.getByName(url.getHost());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(details.getTimeout() <= 0 ? 1000 : details.getTimeout());
            connection.connect();
            responseDetails.setUrl(url.toString());
            responseDetails.setHostName(url.getHost());
            responseDetails.setHostAddress(hostDetails.getHostAddress());
            responseDetails.setCanonicalHostName(hostDetails.getCanonicalHostName());
            responseDetails.setStatusCode(connection.getResponseCode());
            responseDetails.setResponseMessage(connection.getResponseMessage());
            responseDetails.setReachable(true);
            responseDetails.setUrlDetails(urlDetails(url));
            responseDetails.setHeaderDetails(getNonNullKeyMap(connection.getHeaderFields()));

        } catch (MalformedURLException e) {
            log.error(String.format("URL: %s, Message: %s ", details.getUrl(), MALFORMED_ERROR_MESSAGE), e);
            setUrlResponseError(responseDetails, MALFORMED_ERROR_MESSAGE, details.getUrl());
        } catch (ProtocolException e) {
            log.error(String.format("URL: %s, Message: %s ", details.getUrl(), PROTOCOL_ERROR_MESSAGE), e);
            setUrlResponseError(responseDetails, PROTOCOL_ERROR_MESSAGE, details.getUrl());
        } catch (SocketTimeoutException e) {
            log.error(String.format("URL: %s, Message: %s ", details.getUrl(), TIMEOUT_ERROR_MESSAGE), e);
            setUrlResponseError(responseDetails, TIMEOUT_ERROR_MESSAGE, details.getUrl());
        } catch (IOException e) {
            log.error(String.format("URL: %s, Message: %s ", details.getUrl(), IO_ERROR_MESSAGE), e);
            setUrlResponseError(responseDetails, IO_ERROR_MESSAGE, details.getUrl());
        }
        return responseDetails;

    }

    private HostDetailsResponse fillHostDetailsResponse(UrlDetailsRequest details) {
        HostDetailsResponse responseDetails = new HostDetailsResponse();

        try {
            InetAddress inetAddress = InetAddress.getByName(details.getUrl());
            boolean isReachable = inetAddress.isReachable(details.getTimeout() <= 0 ? 1000 : details.getTimeout());
            responseDetails.setHost(details.getUrl());
            responseDetails.setHostAddress(inetAddress.getHostAddress());
            responseDetails.setCanonicalHostName(inetAddress.getCanonicalHostName());
            responseDetails.setHostName(inetAddress.getHostName());
            responseDetails.setReachable(isReachable);
            responseDetails.setHostInfo(hostInfo(inetAddress));
            responseDetails.setErrorMessage(isReachable ? null : CANNOT_REACH_HOST);
        } catch (UnknownHostException e) {
            log.error(String.format("Host: %s, Message: %s ", details.getUrl(), UNKNOWN_HOST_ERROR_MESSAGE), e);
            setHostResponseError(responseDetails, UNKNOWN_HOST_ERROR_MESSAGE, details.getUrl());
        } catch (IOException e) {
            log.error(String.format("Host: %s, Message: %s ", details.getUrl(), IO_ERROR_MESSAGE), e);
            setHostResponseError(responseDetails, IO_ERROR_MESSAGE, details.getUrl());
        }
        return responseDetails;
    }

    private Map<String, List<String>> getNonNullKeyMap(Map<String, List<String>> map) {
        return map.entrySet()
                .stream()
                .filter(mapKey -> mapKey.getKey() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, Boolean> hostInfo(InetAddress inetAddress) {
        Map<String, Boolean> hostInfo = new HashMap<>();
        hostInfo.put("isAnyLocalAddress", inetAddress.isAnyLocalAddress());
        hostInfo.put("isLoopbackAddress", inetAddress.isLoopbackAddress());
        hostInfo.put("isLinkLocalAddress", inetAddress.isLinkLocalAddress());
        hostInfo.put("isMulticastAddress", inetAddress.isMulticastAddress());
        hostInfo.put("isMCGlobal", inetAddress.isMCGlobal());
        hostInfo.put("isMCLinkLocal", inetAddress.isMCLinkLocal());
        hostInfo.put("isMCNodeLocal", inetAddress.isMCNodeLocal());
        hostInfo.put("isMCOrgLocal", inetAddress.isMCOrgLocal());
        hostInfo.put("isMCSiteLocal", inetAddress.isMCSiteLocal());
        return hostInfo;
    }

    private Map<String, String> urlDetails(URL url) {
        Map<String, String> urlDetails = new HashMap<>();
        urlDetails.put("protocol", url.getProtocol());
        urlDetails.put("host", url.getHost());
        urlDetails.put("port", String.valueOf(url.getPort()));
        urlDetails.put("default port", String.valueOf(url.getDefaultPort()));
        return urlDetails;
    }

    private void setUrlResponseError(UrlDetailsResponse responseDetails, String error, String url) {
        responseDetails.setReachable(false);
        responseDetails.setErrorMessage(error);
        responseDetails.setUrl(url);
    }

    private void setHostResponseError(HostDetailsResponse hostDetailsResponse, String error, String url) {
        hostDetailsResponse.setReachable(false);
        hostDetailsResponse.setErrorMessage(error);
        hostDetailsResponse.setHost(url);
    }
}
