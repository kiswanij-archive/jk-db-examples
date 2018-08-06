package com.jk.util.examples.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.jk.util.JKExcelUtil;
import com.jk.util.exceptions.handler.JKExceptionHandlerFactory;
import com.jk.util.exceptions.handler.JKExceptionUtil;

public class ExceptionHandlerTest {
	static {
		JKExceptionHandlerFactory.getInstance().registerHanders("com.jk.util.examples.exception");
	}

	public static void main(String[] args) {
		try {
			FileInputStream in=new FileInputStream("missingfile.dat");
		} catch (FileNotFoundException e) {
			JKExceptionUtil.handle(e);
		}
	}
}
