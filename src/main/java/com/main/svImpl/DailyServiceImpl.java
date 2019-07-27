package com.main.svImpl;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.main.svInf.DailyService;
import com.main.svInf.DateUtil;

@Service
public class DailyServiceImpl implements DailyService {

	@Inject
	private DateUtil dateUtil;
	@Override
	public HashMap<String, Object> selectDaily(String nwDt, int clickCnt) throws Exception {
		//현재 월
		String curtDt_YYYYMM = dateUtil.getCurrentDt(null,"yyyyMM");
		
		HashMap<String, Object>  map = new HashMap<String, Object> ();
		map.put("curtDt", curtDt_YYYYMM);
		
		return map;
	}

}
