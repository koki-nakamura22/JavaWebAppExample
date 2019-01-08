package org.example.myapp;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class TestAPI {

	@Path("/text")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String text() {
		return "Hello, World!!";
	}

	@Path("/map")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> map() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "000");
        map.put("b", "111");
        return map;
	}
	
	public class Human {
		public String name;
		public Integer age;
		public Human(String name, Integer age) {
			this.name = name;
			this.age = age;
		}
	}

	@Path("/pojo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Human pojo() {
		return new Human("Nakamura", 26);
	}
}
