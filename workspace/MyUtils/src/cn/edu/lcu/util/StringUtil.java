package cn.edu.lcu.util;

/**
 * @author zhou
 *
 */

public class StringUtil {
	
	/**
	 * 判断一个对象是否为Null
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * 判断一个对象是否为Null
	 * @param obj
	 * @return
	 */
	public static boolean isNull(String obj) {
		return obj == null || obj.trim().length() == 0;
	}
}
