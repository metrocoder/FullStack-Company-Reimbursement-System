package dev.edwin.app;

import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {
		Javalin app = Javalin.create(
				config->{config.enableCorsForAllOrigins();}
				).start(7000);

	}

}
