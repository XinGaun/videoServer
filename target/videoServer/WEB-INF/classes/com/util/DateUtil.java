package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.eclipse.jetty.util.StringUtil;


public class DateUtil {
	public static String YYYY_MM_DD="yyyy-MM-dd";
	public static String YYYY_MM_DD_SS="yyyy-MM-dd HH:mm:ss";
	/**获取日期**/
	public static String getCurDateStr(String str){
		SimpleDateFormat sf=new SimpleDateFormat(str);
		return sf.format(new Date());
	}
	/**拼接当前日期最小日期*/
	public static String setMinHHmmss(String dateStr){
		if(dateStr==null||StringUtils.isEmpty(dateStr)||dateStr.length()>10){
			return dateStr;
		}
		return dateStr.trim()+" 00:00:00";
	}
	/**拼接当前日期最大日期*/
	public static String setMaxHHmmss(String dateStr){
		if(dateStr==null||StringUtils.isEmpty(dateStr)||dateStr.length()>10){
			return dateStr;
		}
		return dateStr.trim()+" 23:59:59";
	}
	/**datetostr*/
	public static String dateToStr(Date date,String type){
		SimpleDateFormat format=new SimpleDateFormat(type);
		return format.format(date);
	}
	/**strToDate
	 * @throws ParseException
	 */
	public static Date strToDate(String dateStr,String type) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat(type);
		return format.parse(dateStr);
	}
	/**日期相差多少天*/
	public static long getDayDifDate(Date date,Date date1){
		long difVal=Math.abs(date.getTime()-date1.getTime())/1000/60/60/24;
		return difVal;
	}
	/**日期相差多少分钟*/
	public static long getDayDifMin(Date date,Date date1){
		long difVal=(date.getTime()-date1.getTime())/1000/60;
		return difVal;
	}
	/**日期相差多少天*/
	public static long getDayDifDate(String str,String str1,String type) throws ParseException{
		return getDayDifDate(strToDate(str,type),strToDate(str1,type));
	}
	
	/**
	 * 得到标准GMT+8(北京时间)时间
	 * @author hcb
	 */
	public static String getGMTTime(){
		Calendar cd = Calendar.getInstance();  
		SimpleDateFormat sdf = new SimpleDateFormat("MMMd.yyyy HH:mm:ss", Locale.US);  
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8")); // 设置时区为GMT  
		String str = sdf.format(cd.getTime()); 
		System.out.println(str+"str");
		return str;
	}
	
	
	static String DEFAULT_TIMEZONE = "GMT+8";
	//static String DEFAULT_FORMAT = "d-MMM-yyyy HH:mm (z)";
	//static String DEFAULT_FORMAT = "EEE d MMM yyyy HH:mm:ss";
	static String DEFAULT_FORMAT = "MMMd.yyyy HH:mm:ss";

	/**
	 * 转换时间时区
	 * @param convertString  需要转的时间字符串
	 * @param format  格式话字符串 例如d-MMM-yyyy HH:mm (z)
	 * @param sourceTimeZone 源时间时区
	 * @param targetTimeZone 目标时间时区
	 * @return
	 * @author hcb
	 */
	public static String ConverDateGMT(String convertString,String format,String sourceTimeZone,String targetTimeZone)
	{

		Date date=null;

		if(isEmpty(sourceTimeZone)){
			sourceTimeZone = DEFAULT_TIMEZONE;
		}

		if(isEmpty(targetTimeZone)){
			//targetTimeZone = DEFAULT_TIMEZONE;
			targetTimeZone = Calendar.getInstance().getTimeZone().getID();
		}

		if(isEmpty(format)){
			format = DEFAULT_FORMAT; 
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
		//获取传入的时间值
		Long time = null;
		try {
			time = new Date(sdf.parse(convertString).getTime()).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		//获取源时区时间相对的GMT时间
		Long sourceRelativelyGMT=time-TimeZone.getTimeZone(sourceTimeZone).getRawOffset();

		//GMT时间+目标时间时区的偏移量获取目标时间
		Long targetTime=sourceRelativelyGMT+TimeZone.getTimeZone(targetTimeZone).getRawOffset();

		
		return sdf.format(new Date(targetTime));

	}

	//eg:转换为当地时区的日期格式
	public static void main(String[] args) {
			String converDateGMT = ConverDateGMT(getGMTTime(),null,null , "GMT-5");
			System.out.println(converDateGMT);
			/*System.out.println(getDay(getGMTTime()));
			System.out.println(converDateGMT);
			System.out.println(getGMTTime());
			System.out.println(getOneTime(getGMTTime(), "9:00"));
			Date date = new Date();
			System.out.println(date.getDay()+"i hava weekedday");*/
			
			//System.out.println(getCurDate("GMT+10"));
		//getOneMonthDate("Aug.2017");
		//System.out.println(getOneMonthDate(getCurMonth()));
		
	}
	
	/**
	 * 获取指定一个月的所有日期 和星期数
	 * @return 包含 MMMd.yyyy E 的list集合
	 */
	public static List<String> getOneMonthDate(String monthYear) {

		SimpleDateFormat sdf = new SimpleDateFormat("MMM.yyyy", Locale.US);
		SimpleDateFormat sdf2 = new SimpleDateFormat("MMMd.yyyy", Locale.US);
		int year = -1;
		int month = -1;		
		try {
			Date parse = sdf.parse(monthYear);
			year = parse.getYear()+1900;
			month = parse.getMonth();			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		Calendar cal = Calendar.getInstance();
		// 不加下面2行，就是取当前时间前一个月的第一天及最后一天
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month+1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		/**
		 * 判断如果是当前月的话 则只生成到今天为止的日期数据
		 */
		int lastDay = 0;
		if (monthYear.equals(getCurMonth())) {
			Date today = new Date();
			lastDay = today.getDate()-1;			
		}else {
			Date lastDate = cal.getTime();// 当前月最后一天
			lastDay = lastDate.getDate();
		}
		List<String> dayList = new ArrayList<String>();
		for (int i = 1; i <= lastDay; i++) {
			cal.set(Calendar.DAY_OF_MONTH, i);
			Date date = cal.getTime();
			String dateStr = sdf2.format(date);
			int week = date.getDay();
			String day = dateStr+" "+week;
			dayList.add(day);
		}
		
		return dayList;
	}
	
	/**
	 * 得到当前月  MMM.yyyy
	 */
	public static String getCurMonth(){
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMd.yyyy HH:mm:ss", Locale.US); 
		SimpleDateFormat sdf = new SimpleDateFormat("MMM.yyyy", Locale.US);
		String string = "";
		try {
			string = sdf.format(sdf1.parse(getGMTTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	} 

	/**
	 * Check empty string
	 * <pre>
	 *   null: true
	 *   "": true
	 *   " ":true
	 * </>
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isEmpty(String value) {
		boolean emptyFlg = false;
		if (null == value || value.trim().length() <= 0) {
			emptyFlg = true;
		}
		return emptyFlg;
	}
	
	/**
	 * 
	 * @author hcb
	 * @return 两个时间相隔的分钟数
	 */
	public static long relativeTime(String nowdate,String loginDate){
		long min = -1;
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT, Locale.US);
		try {
			Date parse = sdf.parse(nowdate);
			Date parse2 = sdf.parse(loginDate);
			min = getDayDifMin(parse, parse2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return min;
	}
	
	/**
	 * 拼接成给定日期需要的固定时间点
	 */
	public static String getOneTime(String date,String oclock){
		String substring = date.substring(0,date.indexOf(" "));
		return substring+" "+oclock;
		
	}
	/**
	 * 得到指定日期的星期数
	 * @author hcb
	 */
	static SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT, Locale.US);
	public static int getDay(String date){
		Date parse = null;
		try {
			parse = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return parse.getDay();
		
	}
	
	/**
	 * 得到指点时间的年份
	 * @author hcb
	 */
	public static String getYear(String date){
		Date parse = null;
		try {
			parse = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return parse.getYear()+1900+"";
	}
	/**
	 * 得到指定时区当天的日期
	 * @author hcb
	 */
	public static String getCurDate(String timeZome){
		if (StringUtil.isBlank(timeZome)) {
			timeZome = DEFAULT_TIMEZONE;
		}
		if(!timeZome.startsWith("-")){
			timeZome="+"+timeZome;
		}
		String curDate = ConverDateGMT(getGMTTime(), null, null, "GMT"+timeZome)+"";
		return curDate.substring(0,curDate.indexOf(" "));
	}
	
}
