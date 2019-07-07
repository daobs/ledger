package com.main.svImpl;

import org.springframework.stereotype.Service;

import com.main.svInf.ComUtil;

@Service
public class ComUtilImpl implements ComUtil {

	@Override
	public Boolean isTrimEmp(String target) {
		if( target == null ) {
			return true;
		}
		
		if( "".equals(target.trim()) ) {
			return true;
		}
		return false;
	}

}
