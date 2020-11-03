package com.selenium.automation.achala.Utilities;

import java.io.IOException;

import com.selenium.automation.achala.Supporters.PropertiesReaders;

public class POJOReaders {
	private static  PropertiesReaders prconf;
	
	public static PropertiesReaders getconfPropertiesReaders() throws IOException {
		prconf = new PropertiesReaders(FilePaths.confilepath);
		return prconf;
	}
	/*
	 * public static PropertiesReaders getorproPropertiesReaders() throws
	 * IOException { PropertiesReaders pror = new
	 * PropertiesReaders(FilePaths.orfilepath); return pror; }
	 */

}
