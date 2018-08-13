package com.jk.db.examples;

import com.jk.application.api.ApplicationManager;
import com.jk.application.api.ApplicationSuperFactory;
import com.jk.desktop.ui.UIDesktopWidgetFactory;
import com.jk.util.JK;

public class Startup {
	public static void main(String[] args) {
		JK.debug();
		ApplicationSuperFactory.getInstance().setUIWidgetFactorty(new UIDesktopWidgetFactory());
		ApplicationManager.getInstance().start();
	}
}
