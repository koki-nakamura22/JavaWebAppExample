package org.example.myapp;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		packages("org.example.myapp");
	}
}
