package com.main.svInf;

import java.util.ArrayList;
import java.util.Date;

/**
 * 공통상수 INF
 * @author 1001
 *
 */
public interface DateUtil {
	/**
	 * 현재날짜
	 * 
	 * @author 1001
	 *
	 */
	 public String getCurrentDt();
	 
	 /**
	  * 현재날짜
	  * 
	  * @deprecated yyyy, yyyyMM, yyyyMMdd 
	  * @param FORMAT
	  * @author 1001
	  *
	  */
	 public String getCurrentDt(String date, String format);
	 
	/**
	 * 요일 반환
	 * 
	 * @param YYYYMMDD
	 * @author 1001
	 *
	 */
	 public int getDayOfWeek(String date);
	 
	 /**
	  * 요일명 반환
	  * 
	  * @param YYYYMM
	  * @author 1001
	  *
	  */
	 public String getDayOfWeekNm(String date);
	 
	 /**
	  * 해당월 1일 요일 반환
	  * 
	  * @param YYYYMM
	  * @author 1001
	  *
	  */
	 public int getFirstDayOfWeek(String date);
	 
	 /**
	  * 해당월 말일 반환
	  * 
	  * @param YYYYMM
	  * @author 1001
	  * @return MM
	  */
	 public int getLastDayOfWeek(String date);
	 
	 /**
	  * 날짜 SPLIT 년,월,일
	  * 
	  * @param YYYYMMDD
	  * @author 1001
	  *
	  */
	 public ArrayList<String> getSplitDt(String date);
	 
	 
	 /**
	  * 날짜 계산
	  * 
	  * @param YYYYMMDD
	  * @param yyyy
	  * @param mm
	  * @param dd
	  * @deprecated getDateOp(20190622, -1, -1, -1) -> 20180521
	  * @author 1001
	  *
	  */
	 public String getDateOp(String date, int yyyy, int mm, int dd);
	 
	 /**
	  * 형변환(String TO Date)
	  * 
	  * @param YYYYMMDD
	  * @author 1001
	  *
	  */
	 public Date getToDate(String str);
	 
	 
}
