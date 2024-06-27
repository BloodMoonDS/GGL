package com.bloodiey.GGL;

import javax.swing.JOptionPane;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
	    handle(e);
	  }

	  public void handle(Throwable throwable) {
	    try {	
	    	JOptionPane.showMessageDialog(null, "ERROR: "+ throwable);
	    	FileSaver sav = new FileSaver();
			sav.Writefile("SoundClip Error", "Exception: " + throwable);
	      // insert your e-mail code here
	    } catch (Throwable t) {
	      // don't let the exception get thrown out, will cause infinite looping!
	    }
	  }

	  public static void registerExceptionHandler() {
	    Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
	    System.setProperty("sun.awt.exception.handler", ExceptionHandler.class.getName());
	  }
}
