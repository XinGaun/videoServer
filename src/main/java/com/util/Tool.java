package com.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import com.google.gson.Gson;

public class Tool {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static boolean isEmpty(Object o) {
		if(o == null) return true;

		String s = o.toString();
		if (s.trim().length() == 0) return true;
		return false;
	}
	
	public static String clearNull(String s) {
		if(s == null) return "";
		return s;
	}

	/**
	 * Execute program on a file.
	 * @param program : Full path of a program.
	 * @param file : Full path of a file.
	 */
	public static void executeProgram(String program, String file) {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try {
			p = r.exec(program+" \""+file+"\"");
			p.waitFor();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void sleep() {
		sleep(1);
	}

	public static void sleep(int s) {
		try {Thread.sleep(1000*s);} catch (InterruptedException e) {}
	}

	public static File getResourceDirectory(String resourcePath) throws Exception {
		File resourceFile;
		URL url = ClassLoader.class.getResource(resourcePath);

		if(url == null) {
			System.out.println("Failed to find resource in bin, the resource may be loaded from tomcat");

			url = Thread.currentThread().getContextClassLoader().getResource("/");

			if(url == null) throw new Exception("Failed to load resource in tomcat.");

			resourceFile = new File(new File(url.toURI()), resourcePath);
			if (!resourceFile.exists()) throw new Exception ("Resource file: "+resourceFile+" doesnt exist.");

			return resourceFile;
		} else {
			try {
				resourceFile = new File(url.toURI());
				if (!resourceFile.exists()) throw new Exception ("Resource file: "+resourceFile+" doesnt exist.");

				return resourceFile;
			} catch (URISyntaxException e) {
				throw new Exception ("Failed to load resource: "+resourcePath+" due to URI syntaxt error "+e.getMessage());
			}
		}
	}

	public static String truncate(String s, int length) {
		if(s != null && s.trim().length()>length)
			return s.trim().substring(0, length-1);
		return s;
	}

	public static String trim(String s) {
		if(s==null) return s;
		return s.trim();
	}

	public static String toJson(Object o) {
		return new Gson().toJson(o);
	}

	public static String md5(String input) {
		byte[] source = input.getBytes();
		String s = null;
		char hexDigits[] = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'}; 
		try{
			java.security.MessageDigest md = java.security.MessageDigest.getInstance( "MD5" );
			md.update( source );
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			} 
			s = new String(str);

		}catch( Exception e ){
			e.printStackTrace();
		}
		return s;
	}

	public static String _10_to_62(int number, int length){
		char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		int rest=number;  
		Stack<Character> stack=new Stack<Character>();  
		StringBuilder result=new StringBuilder(0);  
		while(rest!=0){  
			stack.add(charSet[new Long((rest-(rest/62)*62)).intValue()]);  
			rest=rest/62;  
		}  
		for(;!stack.isEmpty();){  
			result.append(stack.pop());  
		}  
		int result_length = result.length();  
		StringBuilder temp0 = new StringBuilder();  
		for(int i = 0; i < length - result_length; i++){  
			temp0.append('0');  
		}  

		return temp0.toString() + result.toString();  
	}

	public static int _62_to_10(String ident62) {  
		int decimal = 0;
		int base = 62;
		int keisu = 0;
		int cnt = 0;

		byte ident[] = ident62.getBytes();  
		for ( int i = ident.length - 1; i >= 0; i-- ) {  
			int num = 0;  
			if ( ident[i] > 48 && ident[i] <= 57 ) {  
				num = ident[i] - 48;  
			}  
			else if ( ident[i] >= 65 && ident[i] <= 90 ) {  
				num = ident[i] - 65 + 10;  
			}  
			else if ( ident[i] >= 97 && ident[i] <= 122 ) {  
				num = ident[i] - 97 + 10 + 26;  
			}  
			keisu = (int) java.lang.Math.pow( (double) base, (double) cnt );  
			decimal += num * keisu;  
			cnt++;  
		}  
		return decimal;  
	}

	public static String toFixByteString(String s, int byteLength){
		String newString = "";
		try {
			if(s.getBytes("UTF-8").length <= byteLength){
				return s;
			}
			else{
				byte[] sub = Arrays.copyOfRange(s.getBytes("UTF-8"), 0, (byteLength));
				newString = new String(sub,"UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (newString);
	}

	public static String toFixedLengthFloatString(String s, int length){
		if(s.indexOf(".") < 0) s = s+".0";
		while(s.length()<length) {
			s = s+"0";
		}
		return s;
	}

	public static String toFixLengthInteger(int i, int length){
		String s = ""+i;
		while(s.length()<length) {
			s = "0"+s;
		}
		return s;
	}

	public static boolean isAllUpper(String s) {
		for(char c : s.toCharArray()) {
			if(!Character.isLetter(c) || Character.isLowerCase(c)) {
				return false;
			}
		}
		return true;
	}

	public static String addURLTime(String url, long timemilli) {
		int indexSt = url.indexOf("&st=");
		int indexStTime = url.indexOf("=", indexSt);
		int indexStTimeEnd = url.indexOf("&", indexStTime);
		String sttimestring = url.substring(indexStTime+1, indexStTimeEnd);
		Long newsttimestring = new Long(sttimestring)+timemilli;

		int indexEt = url.indexOf("&et=");
		int indexEtTime = url.indexOf("=", indexEt);
		int indexEtTimeEnd = url.indexOf("&", indexEtTime);
		String ettimestring = url.substring(indexEtTime+1, indexEtTimeEnd);
		Long newettimestring = new Long(ettimestring)+timemilli;

		url = url.replaceFirst(sttimestring, newsttimestring.toString());
		url = url.replaceFirst(ettimestring, newettimestring.toString());

		return url;
	}

	public static void createFolder(File folder) throws IOException {
		if(folder != null && !folder.exists()) {
			createFolder(folder.getParentFile());
			folder.mkdir();

			try {
				Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
				//add owners permission
				perms.add(PosixFilePermission.OWNER_READ);
				perms.add(PosixFilePermission.OWNER_WRITE);
				perms.add(PosixFilePermission.OWNER_EXECUTE);
				//add group permissions
				perms.add(PosixFilePermission.GROUP_READ);
				perms.add(PosixFilePermission.GROUP_EXECUTE);
				//add others permissions
				perms.add(PosixFilePermission.OTHERS_READ);
				perms.add(PosixFilePermission.OTHERS_EXECUTE);

				Files.setPosixFilePermissions(Paths.get(folder.toURI()), perms);
			} catch (Exception e) {
			}
		}
	}

	public static InetAddress getSystemIP() throws UnknownHostException {
		return InetAddress.getLocalHost();
	}

	public static Field getField(Class<?> clazz, String fieldName) {
		Class<?> tmpClass = clazz;
		do {
			for ( Field field : tmpClass.getDeclaredFields() ) {
				String candidateName = field.getName();
				if ( ! candidateName.equals(fieldName) ) {
					continue;
				}
				field.setAccessible(true);
				return field;
			}
			tmpClass = tmpClass.getSuperclass();
		} while ( clazz != null );
		throw new RuntimeException("Field '" + fieldName +
				"' not found on class " + clazz);
	}

	public static List<Field> getFields(Class<?> clazz) {
		List<Field> fields = new ArrayList<>();
		List<String> fieldnames = new ArrayList<>();
		Class<?> tmpClass = clazz;
		do {
			for ( Field field : tmpClass.getDeclaredFields() ) {
				String candidateName = field.getName();
				if(!fieldnames.contains(candidateName)) {
					fieldnames.add(candidateName);
					field.setAccessible(true);
					fields.add(field);
				}
			}
			tmpClass = tmpClass.getSuperclass();
		} while ( tmpClass != null );
		return fields;
	}

	public static String convert2Printable(String s) {
		if(s==null) s = "";
		s = s.trim();
		s = s.replaceAll(",", " ");
		s = s.replaceAll("\"", " ");
		s = s.replaceAll("'", " ");
		return s;
	}

	public static Map<String, Object> serializeMapDate(Map<String, Object> from) {
		Map<String, Object> to = new TreeMap<String, Object>();
		for (Entry<String, Object> entry : from.entrySet()) {
			Object v = entry.getValue();
			if(v instanceof Date) {
				v = ((Date)v).getTime();
			}
			to.put(entry.getKey(), v);
		}
		return to;
	}

	public static double getNumDouble(double d,int n) {
		BigDecimal bg = new BigDecimal(d);  
		double f1 = bg.setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	
	public static boolean isValidReading(Double d) {
		if(d == null) return false;
		if(d.isNaN()) return false;
		if(d.isInfinite()) return false;
		if(d < 0) return false;
		
		return true;
	}
	
	public static List<List<String>> splitTimelist(String[] keys, long winSize) {
		Arrays.sort(keys);
		
		List<List<String>> output = new ArrayList<>();
		List<String> timelist = new ArrayList<>();
		for (String key : keys) {
			if(timelist.isEmpty()) timelist.add(key);
			else {
				if(Long.parseLong(key) - Long.parseLong(timelist.get(0)) <= winSize) { // still within window
					timelist.add(key);
				} else { // new window
					output.add(timelist);
					timelist = new ArrayList<>();
					timelist.add(key);
				}
			}
		}
		if(!timelist.isEmpty()) output.add(timelist);
		
		return output;
	}
}
