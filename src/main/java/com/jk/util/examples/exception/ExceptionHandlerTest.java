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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.jk.util.JKExcelUtil;
import com.jk.util.exceptions.handler.JKExceptionHandlerFactory;
import com.jk.util.exceptions.handler.JKExceptionUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionHandlerTest.
 */
public class ExceptionHandlerTest {
	static {
		JKExceptionHandlerFactory.getInstance().registerHanders("com.jk.util.examples.exception");
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			FileInputStream in=new FileInputStream("missingfile.dat");
		} catch (FileNotFoundException e) {
			JKExceptionUtil.handle(e);
		}
	}
}
