package com.anwei.rms.common.auth.jcaptcha;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
/**
 * @ClassName: ManageableImageCaptchaService 
 * @Description: 验证码service 
 * @author leao 
 * @date 2015年12月25日 下午2:36:42
 */
public class ManageableImageCaptchaService extends DefaultManageableImageCaptchaService {
	public ManageableImageCaptchaService(com.octo.captcha.service.captchastore.CaptchaStore captchaStore,
			com.octo.captcha.engine.CaptchaEngine captchaEngine, int minGuarantedStorageDelayInSeconds,
			int maxCaptchaStoreSize, int captchaStoreLoadBeforeGarbageCollection) {
		super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize,
				captchaStoreLoadBeforeGarbageCollection);
	}

	public boolean hasCapcha(String id, String userCaptchaResponse) {
		return store.getCaptcha(id).validateResponse(userCaptchaResponse);
	}
}
