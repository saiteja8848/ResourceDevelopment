package com.epam.seleniumproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class pratice {

	 static Logger logger =LogManager.getLogger(pratice.class);
	public static void main(String args[])
	{
		logger.debug("debug");
		logger.info("{}info","\n");
		logger.error("{}error","\n");
		logger.fatal("{}fatal","\n");
		logger.warn("{}warn","\n");
	}
}
