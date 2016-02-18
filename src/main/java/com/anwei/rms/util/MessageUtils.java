package com.anwei.rms.util;

import java.util.Locale;

import org.springframework.web.context.ContextLoader;

public final class MessageUtils {

    private MessageUtils() {}

    public static String getMessage(Locale locale, String msgId, Object... params) {

        // 妥当性验证
        if (StringUtils.isEmpty(msgId)) {
            return null;
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return ContextLoader.getCurrentWebApplicationContext().getMessage(msgId, params, locale);
    }

    public static String getMessage(String msgId, Object... params) {
        return MessageUtils.getMessage(null, msgId, params);
    }
}
