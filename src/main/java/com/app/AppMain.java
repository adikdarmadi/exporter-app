package com.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;

public class AppMain {

	@Parameter(names = "-h", help = true, description = "Show Help Menu")
	private boolean help = false;

	@Parameter(names = "-t", description = "Result Of File Type", required = false)
	private String type;

	@Parameter(names = "-f", description = "File to Process", required = false)
	private String file;

	@Parameter(names = "-o", description = "Location Destination", required = false)
	private String location;

	public static void main(String[] args) throws IOException {

		AppMain jct = new AppMain();
		JCommander jCommander = new JCommander(jct, args);
		if (jct.help) {

			jCommander.setProgramName("Exporter App");
			jCommander.usage();
			return;

		} else if (jct.file != null && jct.type != null && jct.location != null) {

			exportFile(jct.file, jct.type, jct.location);

		} else if (jct.file != null && jct.type != null) {

			exportFile(jct.file, jct.type, null);

		} else if (jct.file != null && jct.location != null) {

			exportFile(jct.file, null, jct.location);

		} else if (jct.file != null) {

			exportFile(jct.file, null, null);

		} else {

			System.out.println("Command not found");

		}

	}

	public static void exportFile(String file, String type, String location) throws IOException {
		String typeReplace = "";
		String formatType = "";
		if (type == null || type.equalsIgnoreCase("text")) {
			typeReplace = "text";
			formatType = ".txt";
		} else {
			typeReplace = type.toLowerCase();
			formatType = ".json";
		}

		String locationReplace = "";
		if (location == null) {

			locationReplace = typeReplace + "-" + generateRandomString() + formatType;
		} else {
			locationReplace = location;
		}

		if (typeReplace.equalsIgnoreCase("text")) {
			FileReader fr = new FileReader(file);

			int i;
			PrintWriter out;
			try {
				out = new PrintWriter(locationReplace);
				while ((i = fr.read()) != -1)
					out.print((char) i);

				out.close();
				System.out.println("file text successed exported to " + locationReplace);
			} catch (FileNotFoundException e) {
				System.err.println("File doesn't exist");
				e.printStackTrace();
			}
		} else if (typeReplace.equalsIgnoreCase("json")) {

			Gson gson = new Gson();

			List<LogModel> logModel = createLogModel(file);

			try (FileWriter writer = new FileWriter(locationReplace)) {
				gson.toJson(logModel, writer);
				System.out.println("file json successed exported to " + locationReplace);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("command not valid");
		}
	}

	private static List<LogModel> createLogModel(String file) throws IOException {

		List<LogModel> tmpLogModel = new ArrayList<>();

		List<String> lines = Files.readAllLines(new File(file).toPath());

		for (String line : lines) {
			tmpLogModel.add(new LogModel(line));
		}

		return tmpLogModel;

	}

	public static String generateRandomString() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}
}
