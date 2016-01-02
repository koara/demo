package io.koara.demo;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import io.koara.Module;
import io.koara.Parser;
import io.koara.ast.Document;
import io.koara.renderer.Html5Renderer;
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
			
			Module[] modules = new Module[moduleArr.length];
			for(int i=0; i<moduleArr.length;i++) {
				modules[i] = Module.valueOf(moduleArr[i].toUpperCase());
			}
			
			Parser parser = new Parser();
			parser.setModules(modules);
			
			Document document = parser.parse(req.queryParams("input").trim());
			Html5Renderer renderer = new Html5Renderer();
			document.accept(renderer);

			Map<String, Object> attrs = new HashMap<>();
			attrs.put("input", req.queryParams("input"));
			attrs.put("modules", moduleArr);
			attrs.put("output", renderer.getOutput());
			return new ModelAndView(attrs, "index.ftl"); 
		}, new FreeMarkerEngine());
	}
	
	
	
	
}
