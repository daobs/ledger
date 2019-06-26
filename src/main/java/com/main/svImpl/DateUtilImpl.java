package com.main.svImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.main.svInf.DateUtil;

/**
 * 공통상수 SV
 * 
 * @author 1001
 *
 */
@Service
public class DateUtilImpl implements DateUtil {

	/**
	 * 현재날짜
	 * 
	 * @author 1001
	 *
	 */
	@Override
	public String getCurrentDt() {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date currentTime = new Date();
		String curDt = mSimpleDateFormat.format(currentTime);

		return curDt;
	}

	/**
	 * 현재날짜
	 * 
	 * @deprecated yyyy, yyyyMM, yyyyMMdd
	 * @param FORMAT
	 * @author 1001
	 *
	 */
	@Override
	public String getCurrentDt(String format) {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
		Date currentTime = new Date();
		String curDt = mSimpleDateFormat.format(currentTime);

		return curDt;
	}

	/**
	 * 요일 반환
	 * 
	 * @deprecated 1:일, 2:월 ...
	 * @param YYYYMMDD
	 * @author 1001
	 *
	 */
	@Override
	public int getDayOfWeek(String date) {
		int dayCd = 0;

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
			Date nDate = dateFormat.parse(date);

			Calendar cal = Calendar.getInstance();
			cal.setTime(nDate);

			dayCd = cal.get(Calendar.DAY_OF_WEEK);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dayCd;
	}

	/**
	 * 해당월 1일 요일 반환
	 * 
	 * @param YYYYMM
	 * @author 1001
	 *
	 */
	@Override
	public int getFirstDayOfWeek(String date) {
		String dateMM = date.concat("01");
		return this.getDayOfWeek(dateMM);
	}

	/**
	 * 요일명 반환
	 * 
	 * @param YYYYMMDD
	 * @author 1001
	 *
	 */
	@Override
	public String getDayOfWeekNm(String date) {
		String dayNm = "";

		int dtCd = this.getDayOfWeek(date);

		switch (dtCd) {
		case 1:
			dayNm = "일";
			break;
		case 2:
			dayNm = "월";
			break;
		case 3:
			dayNm = "화";
			break;
		case 4:
			dayNm = "수";
			break;
		case 5:
			dayNm = "목";
			break;
		case 6:
			dayNm = "금";
			break;
		case 7:
			dayNm = "토";
			break;
		default:
			break;
		}

		return dayNm;
	}

	/**
	 * 해당월 말일 반환
	 * 
	 * @param YYYYMM
	 * @author 1001
	 * @return MM
	 */
	@Override
	public int getLastDayOfWeek(String date) {
		ArrayList<String> dateArr = this.getSplitDt(date);
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(dateArr.get(0)), Integer.parseInt(dateArr.get(1)), 0);

		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 날짜 SPLIT 년,월,일
	 * 
	 * @param YYYYMM || YYYYMMDD
	 * @author 1001
	 *
	 */
	@Override
	public ArrayList<String> getSplitDt(String date) {
		ArrayList<String> dtArr = new ArrayList<String>();

		switch (date.length()) {

		case 6:// YYYYMM
			dtArr.add(date.substring(0, 4));
			dtArr.add(date.substring(4, 6));
			break;
		case 8:// YYYYDD
			dtArr.add(date.substring(0, 4));
			dtArr.add(date.substring(4, 6));
			dtArr.add(date.substring(6, 8));
			break;
		default:
			break;
		}

		return dtArr;
	}

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
	@Override
	public String getDateOp(String date, int yyyy, int mm, int dd) {

		  Calendar cal = new GregorianCalendar(Locale.KOREA); 
		  cal.setTime(this.getToDate(date));
		  cal.add(Calendar.YEAR, yyyy); // 1년을 더한다. 
		  cal.add(Calendar.MONTH, mm); // 한달을 더한다. 
		  cal.add(Calendar.DAY_OF_YEAR, dd); // 하루를 더한다. 
		  
		  SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd"); 
		  String strDate = fm.format(cal.getTime());
		  
		return strDate;
	}

	/**
	 * 형변환(String TO Date)
	 * 
	 * @param YYYYMMDD
	 * @author 1001
	 *
	 */
	@Override
	public Date getToDate(String str) {

		Date toDt = null;

		try {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			toDt = transFormat.parse(str);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return toDt;
	}

}
