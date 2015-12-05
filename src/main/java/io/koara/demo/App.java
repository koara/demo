package io.koara.demo;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.koara.Parser;
import io.koara.ast.Document;
import io.koara.renderer.HtmlRenderer;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class App {

	public static void main(String[] args) {
		int port = (System.getenv("PORT") != null) ? Integer.parseInt(System.getenv("PORT")) : 8080;
		
		port(port);
		get("/", (req, res) -> { 
			Map<String, Object> attrs = new HashMap<>();
			attrs.put("input", "");
			attrs.put("modules", new String[]{"paragraphs", "headings", "lists", "links", "images", "formatting", "blockquotes", "code"});
			return new ModelAndView(attrs, "index.ftl"); 
		}, new FreeMarkerEngine());
		
		post("/", (req, res) -> {
			String[] moduleArr = req.queryParamsValues("modules");
			if(moduleArr == null) { moduleArr = new String[]{};}
			
//			List<String> modules = new ArrayList<>();
 
			Parser parser = new Parser();
			Document document = parser.parse(req.queryParams("input"));
			HtmlRenderer renderer = new HtmlRenderer();
			document.accept(renderer);

			Map<String, Object> attrs = new HashMap<>();
			attrs.put("input", req.queryParams("input"));
			attrs.put("modules", moduleArr);
			attrs.put("output", renderer.getOutput());
			return new ModelAndView(attrs, "index.ftl"); 
		}, new FreeMarkerEngine());
	}
	
	
	
	
}
