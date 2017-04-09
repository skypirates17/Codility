package com.gap.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class ObjectList {
	private String codeFirst = "mm";
	private String codeSecond = "kh";
	private String directoryFirst = "C:\\_MM\\AFSMM_DevelopmentBuild\\";
	private String directorySecond = "C:\\_KH\\afs1db\\";
	private String idListLocation = "C:\\_MODULES\\idList.txt";
	private String resultLocation = "C:\\_MODULES\\objects.csv";
	public static void main(String[] args) throws Exception {
		new ObjectList();
	}
	public ObjectList() throws Exception {
		Map<String, String> idList = readList(new File(idListLocation));
		Map<String, File> fileListFirst = getFiles(new File(directoryFirst));
		Map<String, File> fileListSecond = getFiles(new File(directorySecond));
		Map<String, List<String>> objectListFirst = getObjectList(codeFirst, idList, fileListFirst);
		Map<String, List<String>> objectListSecond = getObjectList(codeSecond, idList, fileListSecond);
		printResult(new File(resultLocation), idList, codeFirst, codeSecond, objectListFirst, objectListSecond);
		System.out.println("Done");
	}
	private Map<String, String> readList(File start) throws Exception {
		System.out.println("Reading ID List...");
		Map<String, String> map = new LinkedHashMap<String, String>();
		try(BufferedReader reader = new BufferedReader(new FileReader(start))) {
			String read = "";
			while((read = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(read.trim(), ",");
				String key = "";
				while(tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken().trim().replace("/", "\\");
					if(key.isEmpty()) {
						key = token;
					} else {
						map.put(key, token);
					}
				}
			}
		} catch(Exception ex) {
			throw ex;
		}
		return map;
	}
	private Map<String, File> getFiles(File start) throws Exception {
		System.out.println("Getting files...");
		Map<String, File> map = new LinkedHashMap<String, File>();
		loopDir(start, map);
		return map;
	}
	private void loopDir(File start, Map<String, File> map) throws Exception {
		File[] folders = start.listFiles();
		for(File folder : folders) {
			if(folder.isDirectory()) {
				File[] files = folder.listFiles();
				for(File file : files) {
					if(!file.isDirectory()) {
						String fileName = file.getName().trim();
						boolean isJavaFile = fileName.trim().endsWith(".java");
						boolean isJspFile = fileName.trim().endsWith(".jsp");
						boolean isXmlFile = fileName.trim().endsWith(".xml");
						if(isJavaFile || isJspFile || isXmlFile) {
							map.put(fileName, file);
						}
					}
				}
				loopDir(folder, map);
			}
		}
	}
	private Map<String, List<String>> getObjectList(String code, Map<String, String> idList, Map<String, File> fileMap) throws Exception {
		System.out.println("Getting Object List...");
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		for(Entry<String, String> entry : idList.entrySet()) {
			String id = entry.getKey();
			String jsp = entry.getValue();
			map.put(id + " : " + code, listObjects(id, jsp, fileMap));
		}
		return map;
	}
	private List<String> listObjects(String id, String jspFile, Map<String, File> fileMap) throws Exception {
		List<String> list = new ArrayList<String>();
		for(Entry<String, File> entryFile : fileMap.entrySet()) {
			String fileName = entryFile.getKey();
			File file = entryFile.getValue();
			boolean isJspOfId = file.getAbsolutePath().trim().replace(".jsp", "").endsWith(jspFile);
			if(isJspOfId || isRelatedFile(file, id)) {
				list.add(fileName);
				list.addAll(scanFileForRelatedObjects(file, fileMap, true));
			}
		}
		List<String> returnList = new ArrayList<String>(new HashSet<String>(list));
		Collections.sort(returnList);
		return returnList;
	}
	private boolean isRelatedFile(File file, String id) throws Exception {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String read = "";
			while((read = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(read.trim(), "\"");
				while(tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken().trim();
					if(id.equals(token)) {
						return true;
					}
				}
			}
			return false;
		} catch(Exception ex) {
			throw ex;
		}
	}
	private List<String> scanFileForRelatedObjects(File file, Map<String, File> fileMap, boolean includeService) throws Exception {
		List<String> objects = new ArrayList<String>();
		String fileName = file.getName().trim();
		boolean isJavaFile = fileName.endsWith(".java");
		boolean isJspFile = fileName.endsWith(".jsp");
		if(isJavaFile || isJspFile) {
			try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
				if(isJspFile) {
					objects.addAll(scanForJspf(reader));
				}
				if(isJavaFile) {
					objects.addAll(scanForClasses(reader, fileMap, includeService));
				}
			} catch(Exception ex) {
				throw ex;
			}
		}
		return objects;
	}
	private List<String> scanForJspf(BufferedReader reader) throws Exception {
		List<String> fragments = new ArrayList<String>();
		String read = "";
		while((read = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(read.trim(), "\"\\/");
			while(tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken().trim();
				boolean isJspf = token.endsWith(".jspf");
				boolean isNotHeaderOrFooter = !"_headerNew.jspf".equals(token) && !"_footerNew.jspf".equals(token);
				boolean isNotSubHeaderOrSubFooter = !"_subHeader.jspf".equals(token) && !"_subFooter.jspf".equals(token);
				if(isJspf && isNotHeaderOrFooter && isNotSubHeaderOrSubFooter) {
					fragments.add(token);
				}
			}
		}
		return fragments;
	}
	private List<String> scanForClasses(BufferedReader reader, Map<String, File> fileMap, boolean includeService) throws Exception {
		List<String> classes = new ArrayList<String>();
		boolean isAutowired = false;
		String read = "";
		while((read = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(read.trim(), " (){}");
			while(tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken().trim();
				if("@Autowired".equals(token)) {
					isAutowired = true;
					continue;
				}
				if(isAutowired) {
					boolean isNotJavaKeyword = !"private".equals(token) && !"public".equals(token);
					boolean isInterface = token.startsWith("I");
					boolean isService = token.endsWith("Service");
					boolean isMapper = token.endsWith("Mapper");
					if(isNotJavaKeyword) {
						String objectName = token + ".java";
						classes.add(objectName);
						if(isInterface && isService) {
							classes.add(objectName.substring(1));
						}
						if(isInterface && isService && includeService) {
							classes.addAll(scanFileForRelatedObjects(fileMap.get(objectName.substring(1)), fileMap, false));
						}
						if(isMapper) {
							classes.add(token + ".xml");
						}
						isAutowired = false;
						continue;
					}
				}
			}
		}
		return classes;
	}
	private void printResult(File output,
			Map<String, String> idList,
			String codeFirst,
			String codeSecond,
			Map<String, List<String>> objectListFirst,
			Map<String, List<String>> objectListSecond) throws Exception {
		System.out.println("Saving result...");
		try(PrintWriter writer = new PrintWriter(output)) {
			for(Entry<String, String> idEntry : idList.entrySet()) {
				String keyFirst = idEntry.getKey() + " : " + codeFirst;
				String keySecond = idEntry.getKey() + " : " + codeSecond;
				StringBuilder builder = new StringBuilder();
				builder.append(keyFirst);
				builder.append(',');
				builder.append(keySecond);
				writer.println(builder.toString());
				builder.setLength(0);
				
				builder.append("\"");
				for(String file : objectListFirst.get(keyFirst)) {
					builder.append(file);
					builder.append("\n");
				}
				builder.append("\",");
				builder.append("\"");
				for(String file : objectListSecond.get(keySecond)) {
					builder.append(file);
					builder.append("\n");
				}
				builder.append("\"");
				writer.println(builder.toString());
			}
		} catch(Exception ex) {
			throw ex;
		}
	}
}
