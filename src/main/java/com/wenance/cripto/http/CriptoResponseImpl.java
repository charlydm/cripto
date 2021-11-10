package com.wenance.cripto.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CriptoResponseImpl {
	
	public static final String LAST_PRICE_URI = "https://cex.io/api/last_price/"; 
	public static final String CONVERT_URI = "https://cex.io/api/convert/";
	public static final String SAVE_CRIPTO_URI = "http://localhost:8080/cripto";
	
	HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

	public HttpResponse<String> lastPriceResponse(String symbol) {
		HttpRequest request = HttpRequest.newBuilder()
								.uri(URI.create(LAST_PRICE_URI + symbol + "/USD"))
								.GET()
								.build();
		try {
			return client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HttpResponse<String> saveCripto(String body) {
		HttpRequest request = HttpRequest.newBuilder()
								.uri(URI.create(SAVE_CRIPTO_URI))
								.POST(BodyPublishers.ofString(body))
								.header("Content-Type", "application/json")
								.build();
		try {
			return client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HttpResponse<String> convertResponse(String symbol, HttpRequest.BodyPublisher body) {
		HttpRequest request = HttpRequest.newBuilder()
								.uri(URI.create(CONVERT_URI + symbol + "/USD"))
								.POST(body)
								.build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	public void lastPriceResponse2() {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(LAST_PRICE_URI + "BTC" + "/USD")).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
							.thenApply(HttpResponse::body)
							.thenAccept(System.out::println)
							.join();
	}
	
	CompletableFuture<HttpResponse<String>> response2 = client.sendAsync(request, BodyHandlers.ofString());
	try {
		System.out.println(response2.get().statusCode());
		System.out.println(response2.get().body());
	} catch (InterruptedException | ExecutionException e1) {
		e1.printStackTrace();
	}*/

}
