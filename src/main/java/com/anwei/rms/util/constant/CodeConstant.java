package com.anwei.rms.util.constant;

import java.util.Properties;

import com.anwei.rms.util.PropertiesUtils;

public final class CodeConstant {
	
	private static final Properties properties = PropertiesUtils.getProperties("config/system.properties");
	
	/**
	 * 加密策略
	 */
	public static final String HASH_ALGORITHM= properties.getProperty("hash_algorithm");
	/**
	 * 加密次数
	 */
	public static final String HASH_INTERATIONS= properties.getProperty("hash_interations");
	/**
	 * 盐加密次数
	 */
	public static final String SALT_SIZE= properties.getProperty("salt_size");
	/**
	 * 开发人员密码
	 */
	public static final String SYSTEM_PASSWORD= properties.getProperty("system_password");
	/**
	 * 启用
	 */
	public static final String CODE_CONSTANT_DELETEFLAG_0= "0";
	/**
	 * 禁用
	 */
	public static final String CODE_CONSTANT_DELETEFLAG_1= "1";
}
