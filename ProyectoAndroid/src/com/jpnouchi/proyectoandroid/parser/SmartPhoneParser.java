package com.jpnouchi.proyectoandroid.parser;

import com.jpnouchi.proyectoandroid.model.SmartPhone;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

public interface SmartPhoneParser extends GenericParser<SmartPhone> {
    public String getJsonData(String url) throws URISyntaxException,ClientProtocolException, IOException;

}
