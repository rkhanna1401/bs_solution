package com.bs.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvReader {

	public static String readEnv(String env) {
		Dotenv dotenv = Dotenv.load();
		return dotenv.get(env);
	}
}
