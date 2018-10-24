package com.google.utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.qameta.allure.Step;

public class Config {

	private static Properties configFile;
	private static String PATH = "./src/test/resources/configuration.properties";

	static {
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(PATH);
			configFile = new Properties();
			configFile.load(inStream);
			inStream.close();
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

	@Step("getPropertyFromFile with key=[{0}]")
	public static String getPropertyFromFile(String key) {

		if (configFile.containsKey(key)) {
			return configFile.getProperty(key);
		} else {
			System.out.println("########### - " + "Key " + key + " is not present in properties file");
			throw new RuntimeException("Key " + key + " is not present in properties file");
		}
	}

	@Step("getPropertyFromSystem with key=[{0}]")
	public static String getPropertyFromSystem(String key) {

		String returnValue = null;
		try {
			returnValue = System.getProperty(key);
		} catch (Exception e) {
		}

		return returnValue;
	}

	@Step("getOS")
	public static String getOS() {

		String OS = getPropertyFromSystem("os.name").toLowerCase();

		if (OS.indexOf("mac") >= 0) {
			return "ios_";
		} else if (OS.indexOf("win") >= 0) {
			return "win_";
		} else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
			return "nix_";
		} else if (OS.indexOf("sunos") >= 0) {
			return "sunos_";
		} else {
			return null;
		}
	}

	@Step("getPWD")
	public static String getPropertyFromSystem_PWD() {

		// return System.getProperty("user.dir");
		return getPropertyFromSystem("user.dir");
	}

	@Step("getPropertyFromTerminal with key=[{0}]")
	public static String getPropertyFromTerminal(String key) {

		// read - -DdriverType / -Dusr / -Dpsw
		String returnValue = null;
		try {
			returnValue = System.getProperties().getProperty(key);
		} catch (Exception e) {
		}

		return returnValue;
	}

	private static String[][] merge(String[][] in, String[] inStr) {
		String[][] out = new String[in.length + 1][];
		int i = 0;
		for (; i <= in.length - 1; i++)
			out[i] = in[i];

		out[i] = inStr;
		return out;
	}

	// read file
	public static String[][] readCSVFile(String csvFile) {
		String[][] resTemp = null; // out
		String line = ""; // temp

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(getPropertyFromFile("pathToCsvFile") + csvFile));
			try {
				while ((line = br.readLine()) != null) {
					// use comma as separator
					String[] brLine = line.split(getPropertyFromFile("cvsSplitBy"));
					if (resTemp == null) { // (resTemp.length == 1)
						resTemp = new String[1][];
						resTemp[0] = brLine;
					} else
						resTemp = merge(resTemp, brLine);
				}
				br.close();
				return resTemp;
			} catch (IOException e) {
				return resTemp;
			}
		} catch (FileNotFoundException e) {
			return null;
		}
	}
}