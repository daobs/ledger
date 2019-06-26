package com.main.svImpl;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.main.svInf.CalService;
import com.main.svInf.DateUtil;

@Service
public class CalServiceImpl implements CalService {
	
	@Inject
	private DateUtil dateUtil;
	
	/**
	 * 캘린더 배열 크기: 42
	 */
	private int CLD_TOT = 42;

	@SuppressWarnings("deprecation")
	@Override
	public HashMap<String, Object> selectCrntCal() throws Exception {
		
		//현재 월
		String curtDt_YYYYMM = dateUtil.getCurrentDt("yyyyMM");
		//해당월 1일 요일(배열삽입시 IDX를 위해 -1 처리)
		int curtDt_firDay  = dateUtil.getFirstDayOfWeek( curtDt_YYYYMM ) -1;
		int dayArr[] = new int[42];
		//해당월 말일
		int curtDt_LASTDAY   = dateUtil.getLastDayOfWeek( curtDt_YYYYMM );
		//전월계산
		String bf_curtDt_YYYYMM = String.valueOf(Integer.parseInt( curtDt_YYYYMM) -1 );
		//전월 말일
		int bfDt_lastDay = dateUtil.getLastDayOfWeek( bf_curtDt_YYYYMM );
		//익월 캘린더 로직 시작되는 IDX
		int nowIdx = curtDt_firDay + curtDt_LASTDAY;		
		
		
		////////////////////////////////////////////////////
		// 캘린더 로직
		////////////////////////////////////////////////////
		
		//전월  캘린더 계산
		for(int i=curtDt_firDay-1, dt=bfDt_lastDay; i>=0; i--) {
			dayArr[i] = dt--;
		}
		//당월 계산
		for(int i=1, idx=curtDt_firDay; i<=curtDt_LASTDAY; i++) {
			dayArr[idx++] = i;
		}
		//익월 계산
		for(int i=nowIdx, idx=1; i<CLD_TOT; i++,idx++) {
			dayArr[i] = idx;
		}
		
		HashMap<String, Object>  map = new HashMap<String, Object> ();
		map.put("dayArr", dayArr);
		map.put("firstDt", curtDt_firDay);
		map.put("lastDt", curtDt_LASTDAY);
		
		return map;
	}

}
