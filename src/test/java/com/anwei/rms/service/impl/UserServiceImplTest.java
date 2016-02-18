package com.anwei.rms.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anwei.rms.pojo.domain.UserDomain;
import com.anwei.rms.pojo.entity.User;
import com.anwei.rms.service.UserService;
import com.anwei.rms.util.DigestUtils;
import com.anwei.rms.util.EncodeUtils;
import com.anwei.rms.util.MyUtils;
import com.anwei.rms.util.constant.CodeConstant;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/spring.xml"})
public class UserServiceImplTest {
	@Autowired
	UserService userService;
	@Test
	public void testSelect() {
		UserDomain user=new UserDomain();
		user.setUserName("a100488");
		user.setPassword("a100488");
		userService.insertUser(user);
		
	}
	@Test
	public void test2(){
		//6b1a15022dc2c07ebc7b
		//d27dacac38217a41926334a48ace4299ce97e6d9
		String aa=MyUtils.getPasswordShaCode("a100488", "895ed16b0a3690279661");
	System.out.println(aa);
	
	}
	 void entryptPassword(User login, String password) {
		byte[] salt = DigestUtils.generateSalt(Integer.parseInt(CodeConstant.SALT_SIZE));
		String saltStr=EncodeUtils.encodeHex(salt);
		System.out.println(saltStr);
		login.setSalt(saltStr);
		String passwordStr=	MyUtils.getPasswordShaCode(password,saltStr);
		login.setPassword(passwordStr);
		System.out.println(passwordStr);
	}
	
}
