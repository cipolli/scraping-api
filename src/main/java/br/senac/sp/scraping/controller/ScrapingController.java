package br.senac.sp.scraping.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scraping")
public class ScrapingController {
	
	@GetMapping
	public String helloWord(@RequestParam String url) throws IOException {	
		StringBuilder result = new StringBuilder();
		System.out.println("urlToRead");d  
		System.out.println(url);
		URL urlObj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
		conn.setRequestMethod("GET");
		try ( BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
			for (String line; (line = reader.readLine()) != null;) {
				result.append(line);
			}
		}
		return result.toString();
	}
}
