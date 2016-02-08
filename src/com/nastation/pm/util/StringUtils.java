package com.nastation.pm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ִ�������
 * 
 * @author Kris zhang.kris@gmail.com
 * @version 2008-12-17
 */
public class StringUtils {

	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * ���ò���ָ����pattern, ������ת���ַ���
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new java.util.Date());
	}

	/**
	 * ����Ĭ�ϵ�pattern, ������ת���ַ���
	 * 
	 * @see StringUtils#DEFAULT_DATE_PATTERN
	 * @param date
	 * @return
	 */
	public static String toString(Date date) {
		return toString(date, DEFAULT_DATE_PATTERN);
	}

	/**
	 * ���ò���ָ����pattern, ���ַ���ת������
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String date, String pattern)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(date);
	}

	/**
	 * ����Ĭ�ϵ�pattern, ���ַ���ת������
	 * 
	 * @see StringUtils#DEFAULT_DATE_PATTERN
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String date) throws ParseException {
		return toDate(date, DEFAULT_DATE_PATTERN);
	}

	/**
	 * �ж��Ƿ�Ϊ��
	 * 
	 * <pre>
	 * Checks if a String is empty (&quot;&quot;) or null.
	 * 
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty(&quot;&quot;)        = true
	 * StringUtils.isEmpty(&quot; &quot;)       = false
	 * StringUtils.isEmpty(&quot;bob&quot;)     = false
	 * StringUtils.isEmpty(&quot;  bob  &quot;) = false
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		if (str.length() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * check if the string is not empty.
	 * 
	 * @param str
	 * @return
	 * @see #isEmpty(String)
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * �Ƚ������ַ����Ƿ����.
	 * 
	 * <pre>
	 * Compares two Strings, returning true if they are equal.
	 * nulls are handled without exceptions. Two null references are considered to be equal. The comparison is case sensitive.
	 * 
	 * StringUtils.equals(null, null)   = false
	 * StringUtils.equals(null, &quot;abc&quot;)  = false
	 * StringUtils.equals(&quot;abc&quot;, null)  = false
	 * StringUtils.equals(&quot;abc&quot;, &quot;abc&quot;) = true
	 * StringUtils.equals(&quot;abc&quot;, &quot;ABC&quot;) = false
	 * StringUtils.equals(&quot;abc&quot;, &quot; abc &quot;) = false
	 * </pre>
	 * 
	 * @param str1
	 * @param str2
	 * @return true if the Strings are equal, case sensitive
	 */
	public static boolean equals(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		if (!str1.equals(str2)) {
			return false;
		}
		return true;
	}

	/**
	 * �ж�һ���ַ����ĳ����Ƿ����ָ��ֵ
	 * 
	 * <pre>
	 * lengthGreaterThan(null, 3) == false
	 * lengthGreaterThan(&quot;kris&quot;, -1) == false
	 * lengthGreaterThan(&quot;kris&quot;, 3) == true
	 * lengthGreaterThan(&quot;kris&quot;, 5) == false
	 * lengthGreaterThan(&quot; &quot;, 0) == true
	 * lengthGreaterThan(&quot;&quot;, 0) == false
	 * 
	 * 
	 * </pre>
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public static boolean lengthGreaterThan(String str, int size) {
		if (str == null) {
			return false;
		}
		if (size < 0) {
			return false;
		}
		if (str.length() > size) {
			return true;
		}
		return false;
	}

	/**
	 * �Ƿ�Ϊ<b>�Ϸ�</b>��Email
	 * 
	 * @return
	 */
	public static boolean isValidateEmail(String email) {
		if (email == null) {
			return false;
		}
		Pattern p = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * �Ƿ�Ϊ<b>���Ϸ�</b>��Email
	 * 
	 * @return
	 */
	public static boolean isNotValidateEmail(String email) {
		return !isValidateEmail(email);
	}

	/**
	 * �ж��Ƿ�Ϊ��
	 * 
	 * <pre>
	 * Checks if a String is empty (&quot;&quot;) or null.
	 * ��isEmpty()�����Ĳ�ͬ���ڣ�
	 * StringUtils.isEmpty(&quot; &quot;)       = false
	 * 
	 * StringUtils.isBlank(&quot; &quot;)       = true
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null) {
			return true;
		}
		if (str.trim().length() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * @see #isBlank(String)
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	/**
	 * �Ƶ������е�ʱ��
	 * <p>
	 * ���磺removeTime(2008-12-25 11:28:00.0) ��� 2008-12-25
	 */
	public static String removeTime(String str) {
		if (str == null || str.length() < 10) {
			return str;
		}
		return str.substring(0, 10);
	}

	/**
	 * ���ص�ǰ���ڵ��ַ�����ʽ����ʽΪĬ�ϸ�ʽ��
	 * 
	 * @return
	 * @see StringUtils#DEFAULT_DATE_PATTERN
	 */
	public static String getCurrDate() {
		return toString(new Date());
	}

	public static String removeNull(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}

	/**
	 * �ѻس��滻��&lt;br&gt;html��ǩ
	 * 
	 * @return
	 */
	public static String replaceNewLineToBr(String str) {
		if (str == null) {
			return str;
		}
		return str.replaceAll("\n", "<br />");
	}

	/**
	 * ȥ��html��>��<
	 * 
	 * @param str
	 * @return
	 */
	public static String removeHtmlTag(String str) {
		if (str == null) {
			return str;
		}
		Pattern pattern = Pattern.compile("<");
		Matcher matcher = pattern.matcher(str);
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sbr, "&lt;");
		}
		matcher.appendTail(sbr);

		StringBuffer sbr2 = new StringBuffer();
		Pattern pattern2 = Pattern.compile(">");
		Matcher matcher2 = pattern2.matcher(sbr);
		while (matcher2.find()) {
			matcher2.appendReplacement(sbr2, "&gt;");
		}
		matcher2.appendTail(sbr2);
		return sbr2.toString();
	}

	public static void main(String[] args) {
		// System.out.println("==" +
		// replaceNewLineToBr("hello\\\r\\\n\nkris\r\n"));
		System.out.println("=="
				+ removeHtmlTag("<<<<a>> href=\"index.html\">��ҳ</a>"));
	}

}
