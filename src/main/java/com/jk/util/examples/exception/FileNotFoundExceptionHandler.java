package com.jk.util.examples.exception;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.jk.util.exceptions.handler.ExceptionHandler;
import com.jk.util.exceptions.handler.JKExceptionHandler;

@ExceptionHandler
public class FileNotFoundExceptionHandler implements JKExceptionHandler<FileNotFoundException> {
	Logger logger = Logger.getLogger(getClass().getName());

	public void handle(FileNotFoundException throwable, boolean throwRuntimeException) {
		JOptionPane.showMessageDialog(null, "The file your requested is not found");
		logger.log(Level.WARNING, "File not found : ", throwable);
		if (throwRuntimeException) {
			throw new RuntimeException(throwable);
		}
	}
}
