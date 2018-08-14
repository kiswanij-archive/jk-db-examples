package com.jk.db.examples;

import java.util.Properties;

import com.jk.application.api.ApplicationManager;
import com.jk.application.api.ApplicationSuperFactory;
import com.jk.desktop.JKDesktopExceptionHandler;
import com.jk.desktop.swing.SwingUtility;
import com.jk.desktop.swing.comp.panels.JKPanel;
import com.jk.desktop.ui.UIDesktopWidgetFactory;
import com.jk.desktop.ui.UIPanelFactoryImpl;
import com.jk.exceptions.handler.JKExceptionHandlerFactory;
import com.jk.ui.widgets.UIPanel;
import com.jk.util.JK;

public class Startup {
	public static void main(String[] args) {
		JK.debug();
		ApplicationSuperFactory.getInstance().setUIWidgetFactorty(new UIDesktopWidgetFactory());
		JKExceptionHandlerFactory.getInstance().setDefaultExceptionHandler(new JKDesktopExceptionHandler());
		
		UIPanelFactoryImpl imp=new UIPanelFactoryImpl();
//		UIPanel pnl = imp.createMasterDetailWithListPanel("sec_users", new Properties());
//		SwingUtility.showPanelFrame((JKPanel<?>) pnl, "");
		
		ApplicationManager.getInstance().start();
	}
}
