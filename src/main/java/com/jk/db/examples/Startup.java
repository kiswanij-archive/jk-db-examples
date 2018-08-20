package com.jk.db.examples;

import java.io.IOException;

import com.jk.application.api.JKApplicationManager;

public class Startup {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		JKApplicationManager.getInstance().start();
	}

	
}
