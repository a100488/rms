package com.anwei.rms.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.anwei.rms.util.constant.CodeConstant;

public class MyUtils {
	/**
	 * 根据盐和先有密码 获得加密后的密码
	 * @param password 密码
	 * @param salt 盐
	 * @return
	 */
	public static String getPasswordShaCode(String password, String salt) {
		SimpleHash hash = new SimpleHash(CodeConstant.HASH_ALGORITHM, password, ByteSource.Util.bytes(salt), Integer.parseInt(CodeConstant.HASH_INTERATIONS));
		return hash.toHex();
	}
}
