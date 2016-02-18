package com.anwei.rms.common.auth.jcaptcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.ImageFilter;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.deformation.ImageDeformationByFilters;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

/**
 * 仿照JCaptcha2.0编写GMail验证码样式的图片引擎.
 */
public class GMailEngine extends ListImageCaptchaEngine {
	@Override
	protected void buildInitialFactories() {
		int minWordLength = 4;
		int maxWordLength = 4;
		int fontSize = 22;
		int imageWidth = 100;
		int imageHeight = 40;
		int[] R = new int[] { 0, 0 };
		int[] G = new int[] { 0, 0 };
		int[] B = new int[] { 0, 0 };
		// 在页面上将显示的内容
		WordGenerator dictionnaryWords = new RandomWordGenerator("1234567890");
		RandomRangeColorGenerator colors = new RandomRangeColorGenerator(R, G, B);
		// 设置字符以及干扰线颜色
		RandomRangeColorGenerator lineColors = new RandomRangeColorGenerator(R, G, B);
		// 添加干扰线(可选取圆点干扰实现类BaffleTextDecorator LineTextDecorator),new BaffleTextDecorator(1,lineColors)
		TextPaster randomPaster = new DecoratedRandomTextPaster(minWordLength, maxWordLength, colors, true, new TextDecorator[] {});
		RandomRangeColorGenerator backColorGenerator = new RandomRangeColorGenerator(new int[] { 75, 255 },
				new int[] { 75, 255 }, new int[] { 75, 255 });
		// 背景描绘
		//BackgroundGenerator background = new UniColorBackgroundGenerator(imageWidth, imageHeight, Color.white);

		 BackgroundGenerator background = new
		 UniColorBackgroundGenerator(imageWidth, imageHeight, Color.white);
		FontGenerator font = new RandomFontGenerator(fontSize, fontSize,
				new Font[] { new Font("nyala", Font.BOLD, fontSize), new Font("Bell MT", Font.PLAIN, fontSize),
						new Font("Credit valley", Font.BOLD, fontSize), new Font("Arial", 0, 10),
						new Font("Tahoma", 0, 10), new Font("Verdana", 0, 10), new Font("Helvetica", 0, 10),
						new Font("宋体", 0, 10), new Font("黑体", 0, 10), new Font("幼圆", 0, 10) });

		ImageDeformation postDef = new ImageDeformationByFilters(new ImageFilter[] {});
		ImageDeformation backDef = new ImageDeformationByFilters(new ImageFilter[] {});
		ImageDeformation textDef = new ImageDeformationByFilters(new ImageFilter[] {});

		WordToImage word2image = new DeformedComposedWordToImage(font, background, randomPaster, backDef, textDef,
				postDef);
		addFactory(new GimpyFactory(dictionnaryWords, word2image));
	}

}