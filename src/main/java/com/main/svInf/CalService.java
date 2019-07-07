package com.main.svInf;

import java.util.HashMap;

public interface CalService {
    public HashMap<String, Object> selectCrntCal(String nwDt, int clickCnt) throws Exception;
}
