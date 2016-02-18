package com.anwei.rms.service;

/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/spring.xml" })*/
public class RoleServiceTest {
	/*@Autowired
	RoleService roleService;

	@Test
	public void testFindRoleListRoleDomain() {
		RoleDomain roleDomain = new RoleDomain();
		List<RoleDomain> list = roleService.findRoleList(roleDomain);
		for (RoleDomain r : list) {
			if (r.getPermissionList() != null) {
				System.out.println(r.getRoleName() + "||"
						+ r.getPermissionList().size());
			} else {
				System.out.println(r.getRoleName());
			}
		}
	}
*/
	public static void main(String[] args) {
		System.out.println("sd");
		System.out.println("sd");
		System.out.println("s2");
	/*	ApplicationContext ac=new ClassPathXmlApplicationContext("/config/spring.xml");
		RoleService rc=(RoleService) ac.getBean(RoleService.class);
		RoleDomain roleDomain = new RoleDomain();
		
		List<RoleDomain> list = rc.findRoleList(roleDomain);
		for (RoleDomain r : list) {
			if (r.getRolePermissionList() != null) {
				System.out.println(r.getRoleName() + "||"
						+ r.getRolePermissionList().size());
			} else {
				System.out.println(r.getRoleName());
			}
		}*/
	}
}
