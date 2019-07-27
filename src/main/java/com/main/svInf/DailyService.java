package com.main.svInf;

import java.util.HashMap;

public interface DailyService {
    public HashMap<String, Object> selectDaily(String nwDt, int clickCnt) throws Exception;
}
