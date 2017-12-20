package com.ym.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ym.entity.UFunction;

public class SortFunUtil {

	//Fun排序
	public static void SortFun(List<UFunction> list){
		
		Collections.sort(list, new Comparator<UFunction>() {

			@Override
			public int compare(UFunction f1, UFunction f2) {
				// TODO Auto-generated method stub
				int a = f1.getId();
				int b = f2.getId();
				return a - b;
			}
		});
		
	}
	
}
