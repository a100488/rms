package com.anwei.rms.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.CharacterIterator;
import java.text.ParseException;
import java.text.StringCharacterIterator;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public final class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static final String COMMA = ",";

    public static final String TILDE = "~";

    public static final String DOT = ".";

    public static final String SLASH = "/";

    public static final String BACKWARD_SLASH = "\\";

    public static final String SEMICOLON = ";";

    public static final String COLON = ":";

    public static final String QUOTE = "'";

    public static final String DOUBLE_QUOTE = "\"";

    public static final String EXCLAMATION = "!";

    public static final String QUESTION = "?";

    public static final String AT = "@";

    public static final String SHARP = "#";

    public static final String DOLLAR = "$";

    public static final String PERCENT = "%";

    public static final String CARET = "^";

    public static final String AND ="&";

    public static final String ASTERISK = "*";

    public static final String LEFT_PARENTHESE = "(";

    public static final String RIGHT_PARENTHESE = ")";

    public static final String LEFT_SQUARE_BRACKET = "[";

    public static final String RIGHT_SQUARE_BRACKET = "]";

    public static final String LEFT_ANGLE_BRACKET = "<";

    public static final String RIGHT_ANGLE_BRACKET = ">";

    public static final String LEFT_BRACE = "{";

    public static final String RIGHT_BRACE = "}";

    public static final String HYPHEN = "-";

    public static final String BLANK = "";

    public static final String UNDERLINE = "_";

    public static final String PLUS = "+";

    public static final String EQUAL = "=";

    public static final String ZERO = "0";

    private static final Pattern IP_ADDRESS_REGEX_PATTERN = Pattern
            .compile("(\\d|[01]?\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d|[01]?\\d\\d|2[0-4]\\d|25[0-5])){3}");

    private static final Pattern CURRENCY_REGEX_PATTERN = Pattern
            .compile("(?!(^-0$)|(^-?0\\.0+$))(^-?(0|[1-9]\\d{0,2}(,\\d{3})*))($|\\.\\d+$)");

    @SuppressWarnings("serial")
    private static final Map<Integer, String> IDENTITY_CARD_LOCAL_MAP = new HashMap<Integer, String>() {
        {
            put(11, "北京");
            put(12, "天津");
            put(13, "河北");
            put(14, "山西");
            put(15, "内蒙");
            put(21, "辽宁");
            put(22, "吉林");
            put(23, "黑龙");
            put(31, "上海");
            put(32, "江苏");
            put(33, "浙江");
            put(34, "安徽");
            put(35, "福建");
            put(36, "江西");
            put(37, "山东");
            put(41, "河南");
            put(42, "湖北");
            put(43, "湖南");
            put(44, "广东");
            put(45, "广西");
            put(46, "海南");
            put(50, "重庆");
            put(51, "四川");
            put(52, "贵州");
            put(53, "云南");
            put(54, "西藏");
            put(61, "陕西");
            put(62, "甘肃");
            put(63, "青海");
            put(64, "宁夏");
            put(65, "新疆");
            put(71, "台湾");
            put(81, "香港");
            put(82, "澳门");
            put(91, "国外");
        }
    };

    private static final Pattern IDENTITY_CARD_15_REGEX_PATTERN  = Pattern.compile("^(\\d){15}$");

    private static final Pattern IDENTITY_CARD_18_REGEX_PATTERN  = Pattern.compile("^\\d{17}(\\d|x)$");

    private static final String IDENTITY_CARD_18_REPLACE_REGEX_PATTERN = "x$";

    private static final int[] IDENTITY_CARD_18_CALC_ARRAY = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    private static final String[] IDENTITY_CARD_18_CODE_ARRAY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    private static final Pattern TIME_REGEX_PATTERN = Pattern.compile("^(20|21|22|23|[0-1]?\\d):[0-5]\\d(:[0-5]\\d)?$");

    private StringUtils() {}

    public static boolean isAllZeros(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static String[] trimAll(String[] strs) {
        String[] arstr = strs;
        if (strs == null || strs.length == 0) {
            arstr = new String[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arstr[i] = trim(strs[i]);
            }
        }
        return arstr;
    }

    public static String trimWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String trimLeadingWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String trimTrailingWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String[] deleteWhitespaceAll(String[] strs) {
        String[] arstr = strs;
        if (strs == null || strs.length == 0) {
            arstr = new String[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arstr[i] = deleteWhitespace(strs[i]);
            }
        }
        return arstr;
    }

    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && sb.charAt(0) == leadingCharacter) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String trimTrailingCharacter(String str, char trailingCharacter) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == trailingCharacter) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean isJustLength(String str, int length) {
        if (str == null) {
            return false;
        }
        if (length == str.length()) {
            return true;
        }
        return false;
    }

    public static boolean isGreaterThanEqualsLength(String str, int length) {
        if (str == null) {
            return false;
        }
        if (length <= str.length()) {
            return true;
        }
        return false;
    }

    public static boolean isLessThanEqualsLength(String str, int length) {
        if (str == null) {
            return false;
        }
        if (str.length() <= length) {
            return true;
        }
        return false;
    }

    public static boolean isGreaterThanLength(String str, int length) {
        if (str == null) {
            return false;
        }
        if (length < str.length()) {
            return true;
        }
        return false;
    }

    public static boolean isLessThanLength(String str, int length) {
        if (str == null) {
            return false;
        }
        if (str.length() < length) {
            return true;
        }
        return false;
    }

    public static boolean isWithinLength(String str, int minLength, int maxLength) {
        if (str == null) {
            return false;
        }
        if (minLength <= str.length() && str.length() <= maxLength) {
            return true;
        }
        return false;
    }

    public static boolean isJustByteSize(String _str, int _size) {
        return isJustByteSize(_str, _size, "UTF-8");
    }

    public static boolean isJustByteSize(String str, int size, String charset) {
        if (str == null) {
            return false;
        }
        try {
            int resize = getByteLength(str, charset);
            if (resize == size) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return false;
    }

    public static boolean isGreaterThanEqualsByteSize(String str, int size) {
        return isGreaterThanEqualsByteSize(str, size, "UTF-8");
    }

    public static boolean isGreaterThanEqualsByteSize(String str, int size, String charset) {
        if (str == null) {
            return false;
        }
        try {
            int resize = getByteLength(str, charset);
            if (size <= resize) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return false;
    }

    public static boolean isLessThanEqualsByteSize(String str, int size) {
        return isLessThanEqualsByteSize(str, size, null);
    }

    public static boolean isLessThanEqualsByteSize(String str, int size, String charset) {
        if (str == null) {
            return false;
        }
        try {
            int resize = getByteLength(str, charset);
            if (resize <= size) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return false;
    }

    public static boolean isGreaterThanByteSize(String str, int size) {
        return isGreaterThanByteSize(str, size, "UTF-8");
    }

    public static boolean isGreaterThanByteSize(String str, int size, String charset) {
        if (str == null) {
            return false;
        }
        try {
            int resize = getByteLength(str, charset);
            if (size < resize) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return false;
    }

    public static boolean isLessThanByteSize(String str, int size) {
        return isLessThanByteSize(str, size, "UTF-8");
    }

    public static boolean isLessThanByteSize(String str, int size, String charset) {
        if (str == null) {
            return false;
        }
        try {
            int resize = getByteLength(str, charset);
            if (resize < size) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return false;
    }

    public static boolean isWithinByteSize(String str, int minSize, int maxSize) {
        if (str == null) {
            return false;
        }
        return isWithinByteSize(str, minSize, maxSize, "UTF-8");
    }

    public static boolean isWithinByteSize(String str, int minSize, int maxSize, String charset) {
        if (str == null) {
            return false;
        }
        try {
            int size = getByteLength(str, charset);
            if (minSize <= size && size <= maxSize) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return false;
    }

    public static boolean match(String str, String patternStr) {
        if (str == null || patternStr == null) {
            return false;
        }
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(patternStr);
        } catch (PatternSyntaxException e) {
        }
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean containsWildCard(String _str) {
        if (isEmpty(_str)) {
            return false;
        }
        if (_str.indexOf("*") != -1) {
            return true;
        }
        return false;
    }

    public static boolean isDecimalNumberString(String valueStr, boolean isSkip) {
        StringBuilder patternString = new StringBuilder("^(-?)0$|");
        patternString.append("^(-?)([1-9](\\d)*)$|");
        patternString.append(!isSkip ? "^(-?)(0(\\.(\\d)+))$|"
                : "^(-?)(0(\\.(\\d)*))$|"
                        + "^(-?)(\\.(\\d)+)$|");
        patternString.append(!isSkip ? "^(-?)([1-9](\\d)*)(\\.(\\d)+)$"
                : "^(-?)([1-9](\\d)*)(\\.(\\d)*)$");
        return match(valueStr, patternString.toString());
    }

    public static boolean hasNotForbiddenChar(String str, char... forbiddenChars) {
        boolean result = true;
        if (str == null || forbiddenChars == null) {
            result = false;
        } else {
            for (char forbiddenChar : forbiddenChars) {
                if (0 <= str.indexOf(forbiddenChar)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean hasAllowedCharOnly(String str, char... allowedChars) {
        boolean result = false;
        if (isEmpty(str) || allowedChars == null) {
            result = false;
        } else if (allowedChars.length == 0) {
            result = false;
        } else {
            for (char value : str.toCharArray()) {
                for (char allowedChar : allowedChars) {
                    result = (value == allowedChar);
                    if (result) {
                        break;
                    }
                }
                if (result == false) {
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isIpAddress(String str) {
        if (str == null) {
            return false;
        }
        return IP_ADDRESS_REGEX_PATTERN.matcher(str).matches();
    }

    public static boolean isEnclosed(String str, String left, String right) {
        if (str == null || right == null || left == null) {
            return false;
        }
        return str.startsWith(left) && str.endsWith(right);
    }

    public static boolean isQuotedString(String str) {
        return isEnclosed(str, "\"", "\"");
    }

    public static boolean isCurrencyFormat(String str) {
        if (str == null) {
            return false;
        } else if (StringUtils.equals(EMPTY, str)) {
            return true;
        }

        if (!CURRENCY_REGEX_PATTERN.matcher((CharSequence) str).matches()) {
            return false;
        }
        return true;
    }

    public static String sandwich(String str, String addStr) {
        String restr = null;
        if (str != null) {
            StringBuilder newRestr = new StringBuilder();
            String newAddStr = StringUtils.defaultString(addStr);
            newRestr.append(newAddStr);
            newRestr.append(str);
            newRestr.append(newAddStr);
            restr = newRestr.toString();
        }
        return restr;
    }

    public static String trancateString(String str, int byteLength) {
        String restr = str;
        if (!(isEmpty(str) || byteLength < 0)) {
            restr = EMPTY;
            byte[] bytData = null;
            int bytCnt = 0;
            StringBuilder newRestr = new StringBuilder();
            CharacterIterator iter = new StringCharacterIterator(str);
            for (char c = iter.first(); c != CharacterIterator.DONE; c = iter.next()) {
                try {
                    bytData = String.valueOf(c).getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                }
                bytCnt += bytData.length;
                if (byteLength < bytCnt) {
                    break;
                } else {
                    newRestr.append(String.valueOf(c));
                }
            }
            restr = newRestr.toString();
        }
        return restr;
    }

    public static String trancateString(String str, int byteLength, String charset)
            throws UnsupportedEncodingException {
        String restr = str;
        if (!(isEmpty(str) || byteLength < 0)) {
            restr = EMPTY;
            byte[] bytData = null;
            int bytCnt = 0;
            StringBuilder newRestr = new StringBuilder();
            CharacterIterator iter = new StringCharacterIterator(str);
            for (char c = iter.first(); c != CharacterIterator.DONE; c = iter.next()) {
                bytData = String.valueOf(c).getBytes(charset);
                bytCnt += bytData.length;
                if (byteLength < bytCnt) {
                    break;
                } else {
                    newRestr.append(String.valueOf(c));
                }
            }
            restr = newRestr.toString();
        }
        return restr;
    }

    public static int getByteSize(String str) {
        int size = -1;
        try {
            size = getByteSize(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return size;
    }

    public static int getByteSize(String str, String charset)
            throws UnsupportedEncodingException {
        int size = -1;
        if (str != null && charset != null) {
            byte[] bytesize = str.getBytes(charset);
            size = bytesize.length;
        }
        return size;
    }

    public static int compareTo(String str1, String str2) {
        int resultCode = 0;
        if (str1 == null && str2 == null) {
            resultCode = 0;

        } else if (str1 != null && str2 != null) {
            resultCode = str1.compareTo(str2);
        } else {
            resultCode = -1;
        }
        return resultCode;
    }

    public static BigDecimal createBigDecimal(String valueStr) {
        BigDecimal res = null;
        try {
            res = NumberUtils.createBigDecimal(valueStr);
        } catch (NumberFormatException e) {
            res = null;
        }
        return res;
    }
    
    public static int getInt(String valueStr) {
        try {
            return Integer.parseInt(valueStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int searchLowerAlpha(String str) {
        if (str == null) {
            return -1;
        }
        int pos = -1;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if ('a' <= c && c <= 'z') {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static int getByteLength(String str, String encoding)
            throws UnsupportedEncodingException {
        if (isEmpty(str)) {
            return 0;
        }
        byte[] bytes = null;
        if (encoding == null || "".equals(encoding)) {
            bytes = str.getBytes();
        } else {
            try {
                bytes = str.getBytes(encoding);
            } catch (UnsupportedEncodingException e) {
                throw e;
            }
        }
        return bytes == null ? 0 : bytes.length;
    }

    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        for (int j = 0; j < substring.length(); j++) {
            int i = index + j;
            if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || str.length() == 0 || sub.length() == 0) {
            return 0;
        }
        int count = 0;
        int pos = 0;
        int idx;
        while ((idx = str.indexOf(sub, pos)) != -1) {
            ++count;
            pos = idx + sub.length();
        }
        return count;
    }

    public static String getFilename(String path) {
        if (path == null) {
            return null;
        }
        int separatorIndex = path.lastIndexOf(SLASH);
        return (separatorIndex != -1 ? path.substring(separatorIndex + 1) : path);
    }

    public static String getFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        int extIndex = path.lastIndexOf(DOT);
        if (extIndex == -1) {
            return null;
        }
        int folderIndex = path.lastIndexOf(SLASH);
        if (folderIndex > extIndex) {
            return null;
        }
        return path.substring(extIndex + 1);
    }

    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        int extIndex = path.lastIndexOf(DOT);
        if (extIndex == -1) {
            return path;
        }
        int folderIndex = path.lastIndexOf(SLASH);
        if (folderIndex > extIndex) {
            return path;
        }
        return path.substring(0, extIndex);
    }

    public static String applyRelativePath(String path, String relativePath) {
        int separatorIndex = path.lastIndexOf(SLASH);
        if (separatorIndex != -1) {
            String newPath = path.substring(0, separatorIndex);
            if (!relativePath.startsWith(SLASH)) {
                newPath += SLASH;
            }
            return newPath + relativePath;
        }
        else {
            return relativePath;
        }
    }

    private static String upgradeIdentityCard(String input) {
        String output;
        if (IDENTITY_CARD_15_REGEX_PATTERN.matcher(input).matches()) {
            int calcValue = 0;
            input = input.substring(0, 6) + "19" + input.substring(6, input.length());
            for (int count = 0; count < input.length(); count++) {
                calcValue += Integer.parseInt(input.substring(count, count + 1)) * IDENTITY_CARD_18_CALC_ARRAY[count];
            }
            input += IDENTITY_CARD_18_CODE_ARRAY[calcValue % 11];
            output = input;
        } else {
            output = StringUtils.SHARP;
        }
        return output;
    }

    public static boolean isIdentityCardFormat(String str) {
        int calcValue = 0;
        String target;
        if (str.length() == 15) {
            target = upgradeIdentityCard(str);
        } else {
            target = str;
        }
        target = StringUtils.lowerCase(target);
        if (!IDENTITY_CARD_18_REGEX_PATTERN.matcher(target).matches()) {
            return false;
        }
        target = StringUtils.replacePattern(target, IDENTITY_CARD_18_REPLACE_REGEX_PATTERN, "a");
        if (IDENTITY_CARD_LOCAL_MAP.get(Integer.parseInt(target.substring(0,2))) == null) {
            return false;
        }
        String birthday = new StringBuilder(target.substring(6, 10))
                .append(StringUtils.HYPHEN)
                .append(target.substring(10, 12))
                .append(StringUtils.HYPHEN)
                .append(target.substring(12, 14))
                .toString();
        try {
            DateFormatUtils.ISO_DATE_FORMAT.parse(birthday);
        } catch (ParseException pe) {
            return false;
        }
        for (int count = 17; count >= 0; count--) {
            calcValue += (Math.pow(2, count) % 11) * Integer.parseInt(String.valueOf(target.charAt(17 - count)), 11);
        }
        if(calcValue % 11 != 1) {
            return false;
        }
        return true;
    }

    public static boolean isTimeFormat(String str) {
        if (str == null) {
            return false;
        }
        return TIME_REGEX_PATTERN.matcher(str).matches();
    }

    public static boolean isDateTimeFormat(String str, String format) {
        if (str == null || format == null) {
            return false;
        }
        try {
            DateTimeFormatter.ofPattern(format).parse(str);
            DateUtils.parseDateStrictly(str, format);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // time1-time2(小时数)
    public static Double timeDifference(String time1,String time2){
    	//FIXME ？bug
    	if (time1 == null || time1 == null) {
			return null;
		}
    	String time1Array[] = time1.split(StringUtils.COLON);
    	String time2Array[] = time2.split(StringUtils.COLON);
    	Double time1Hour = Double.parseDouble(time1Array[0]);
    	Double time1Minute = Double.parseDouble(time1Array[1]);
    	Double time2Hour = Double.parseDouble(time2Array[0]);
    	Double time2Minute = Double.parseDouble(time2Array[1]);
    	return ((time1Hour * 60 + time1Minute) - (time2Hour * 60 + time2Minute))/60;
    }
    
    public static boolean equalsIgnoreCase(final String cs1, final String cs2) {
    	
        if (cs1 == cs2) {
            return true;
        }
        if (cs1 == null || cs2 == null) {
            return false;
        }
        
        return cs1.equalsIgnoreCase(cs2);
    }
    
    public static String repeat(final String cs1, final int times) {
    	
    	if(StringUtils.isEmpty(cs1)
    		|| times <= 0) {
    		return "";
    	}
    	
    	StringBuilder buff = new StringBuilder();
    	
    	for (int i=0;i<times;i++) {
    		buff.append(cs1);
    	}
    	
        return buff.toString();
    }
}
