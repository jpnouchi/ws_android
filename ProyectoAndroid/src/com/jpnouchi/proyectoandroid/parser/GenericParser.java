package com.jpnouchi.proyectoandroid.parser;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public interface GenericParser<T> {
	public List<T> parse();
}
