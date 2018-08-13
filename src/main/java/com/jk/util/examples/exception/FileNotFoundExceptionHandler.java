/*
 * Copyright 2002-2018 Jalal Kiswani. 
 * E-mail: Kiswani.Jalal@Gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jk.util.examples.exception;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.jk.util.exceptions.handler.ExceptionHandler;
import com.jk.util.exceptions.handler.JKExceptionHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class FileNotFoundExceptionHandler.
 */
@ExceptionHandler
public class FileNotFoundExceptionHandler implements JKExceptionHandler<FileNotFoundException> {
	
	/** The logger. */
	Logger logger = Logger.getLogger(getClass().getName());

	/* (non-Javadoc)
	 * @see com.jk.util.exceptions.handler.JKExceptionHandler#handle(java.lang.Throwable, boolean)
	 */
	public void handle(FileNotFoundException throwable, boolean throwRuntimeException) {
		JOptionPane.showMessageDialog(null, "The file your requested is not found");
		logger.log(Level.WARNING, "File not found : ", throwable);
		if (throwRuntimeException) {
			throw new RuntimeException(throwable);
		}
	}
}
