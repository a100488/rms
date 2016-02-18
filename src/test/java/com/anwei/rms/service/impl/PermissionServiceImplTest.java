package com.anwei.rms.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anwei.rms.pojo.domain.PermissionDomain;
import com.anwei.rms.service.PermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/spring.xml"})
public class PermissionServiceImplTest {
	@Autowired
	PermissionService permissionService;
	@Test
	public void test() {
		

		List<PermissionDomain>  list=	permissionService.findPermissionList(null);
		System.out.println(list.size());
	}

}
