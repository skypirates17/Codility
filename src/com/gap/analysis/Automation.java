package com.gap.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Automation {
	//jsp.svn-base
	private static final File folderKH = new File(
			"C:\\_KH\\afs1db\\WebContent\\WEB-INF\\jsp\\kh\\");
	private static final File folderMM = new File(
			"C:\\_MM\\AFSMM_DevelopmentBuild\\WebContent\\WEB-INF\\jsp\\mm\\");
	private static final String filePath = "C:\\_MODULES\\ids.txt";

	public static void main(String[] args) throws IOException {
		System.out.println("################################ FOR KH");
		for (String id : getIdList()) {
			findIdKH(id);
		}
		
		
		System.out.println("################################ FOR MM");
		for (String id : getIdList()) {
			findIdMM(id);
		}

	}

	static void findIdKH(String id) throws IOException {
		walk(folderKH, id);
	}

	static void findIdMM(String id) throws IOException {
		walk(folderMM, id);
	}

	static String findInFile(File file, String id) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file)));
		try {
			List<String> functionList = new ArrayList<String>();
			boolean isExist = false;
			String fileContent;
			while ((fileContent = bufferedReader.readLine()) != null) {

				if (fileContent.contains("function")
						&& !fileContent.contains(").ready(")
						&& !fileContent.contains("<hp:")
						&& !fileContent.contains("function=")
						&& !fileContent.contains("/*")
						&& !fileContent.contains("//")) {
					functionList.add(fileContent.replace("               ", "")
							.replace("  ", " ").replace("  ", " ")
							.replace("  ", " ").replace("{", "")
							.replace("function ", "").replace(" ", "")
							.replace("}", ""));
				}

				if (fileContent.contains("\"" + id + "\"")) {
					isExist = true;
				}
			}

			if (isExist) {
				if (file.getName().toString().contains("svn-base")) {
					throw new Exception("");
				}
				
				System.err.println("\n" + id + ":" + file.getName());
				Collections.sort(functionList);
				for (String function : functionList) {
					if (isMajorFunction(function)) {
						System.out.println(function.trim());
					}
				}
			}

			bufferedReader.close();

		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			bufferedReader.close();
		}

		return null;
	}
	
	static boolean isMajorFunction(String functionName) {
		// check method name if it contains the ff text,
		// meaning it is not a major functions
		functionName = functionName.toLowerCase().trim();
		return !(functionName.contains("nextpage") || functionName.contains("previouspage")
				|| functionName.contains("gotopage") || functionName.contains("disable")
				|| functionName.contains("enable") || functionName.contains("color")
				|| functionName.contains("hide") || functionName.contains("hidden")
				|| functionName.contains("checkall") || functionName.contains("uncheckall")
				|| functionName.contains("showpanel")  || functionName.contains("$")
				|| functionName.contains("checkbox") || functionName.contains("error")
				|| functionName.contains("success")  || functionName.contains("timeout")
				|| functionName.contains("scroll")  || functionName.contains("ctrl")
				|| functionName.contains("key") || functionName.contains("window")
				|| functionName.contains("function") || functionName.contains("beforeclose")
				|| functionName.contains("zoom") || functionName.contains("%")
				|| functionName.contains("javascript"));
	}

	static List<String> getIdList() throws IOException {

		List<String> list = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filePath)));
		try {
			String fileContent;
			while ((fileContent = bufferedReader.readLine()) != null) {
				list.add(fileContent);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			bufferedReader.close();
		}

		return list;

	}

	static String walk(File file, String id) {

		File[] list = file.listFiles();

		if (list == null) {
			return null;
		}

		for (File f : list) {
			if (f.isDirectory()) {
				String fileName = walk(f, id);
				if (fileName != null) {
					return fileName;
				}
			} else {
				try {
					String fileName = findInFile(f, id);
					if (fileName != null) {
						return fileName;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		return null;
	}
}
