/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-02-18 11:37:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `in_date` datetime DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `out_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES ('1', 'asd', '2016-01-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('2', 'asd', '2016-02-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('3', 'zxc', '2016-03-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('4', 'zxca', '2016-04-28 10:20:33', '0', '2016-07-28 10:24:45');
INSERT INTO `t_emp` VALUES ('5', 'er', '2016-04-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('6', 'fd', '2016-02-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('7', 'nfg', '2016-02-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('8', 'fert', '2016-03-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('9', 'ert', '2016-01-28 10:20:33', '1', null);
INSERT INTO `t_emp` VALUES ('10', 'ertdf', '2016-01-28 10:20:33', '1', null);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `UUID` char(22) NOT NULL,
  `PERMISSION_NAME` varchar(255) DEFAULT NULL,
  `PARENT_UUID` char(22) DEFAULT NULL,
  `ORGA_RELA_INDEX` varchar(255) DEFAULT NULL,
  `PERMISSION` varchar(255) DEFAULT NULL,
  `INSER_TTIME` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('5FDrFjMKZUtYRka4xyhx2m', '用户管理', null, '5FDrFjMKZUtYRka4xyhx2m', 'userManagement', '1454572701797');
INSERT INTO `t_permission` VALUES ('CTNyK1qWWLZCQcUF3QHcCo', '权限分配', 'Hb8aqqQf73QEyjCTGZQTEz', 'Hb8aqqQf73QEyjCTGZQTEzCTNyK1qWWLZCQcUF3QHcCo', 'addRolePermission', '1455522540018');
INSERT INTO `t_permission` VALUES ('DvAo6KpRCXaX1G7Nxe7Vfs', '删除权限', 'JDBbaA3N1A2k5bLXW2umLp', 'JDBbaA3N1A2k5bLXW2umLpDvAo6KpRCXaX1G7Nxe7Vfs', 'deletePermission', '1455525486672');
INSERT INTO `t_permission` VALUES ('Hb8aqqQf73QEyjCTGZQTEz', '角色管理', null, 'Hb8aqqQf73QEyjCTGZQTEz', 'roleManagement', '1454572687524');
INSERT INTO `t_permission` VALUES ('JDBbaA3N1A2k5bLXW2umLp', '功能管理', null, 'JDBbaA3N1A2k5bLXW2umLp', 'permissionManagement', '1454572668716');
INSERT INTO `t_permission` VALUES ('JnmS3PUZSiTjLM1bn8yirD', '222', null, 'JnmS3PUZSiTjLM1bn8yirD', '222', '1455605151028');
INSERT INTO `t_permission` VALUES ('LWuoYhT7fW7uEpYemcMEj6', '修改角色', 'Hb8aqqQf73QEyjCTGZQTEz', 'Hb8aqqQf73QEyjCTGZQTEzLWuoYhT7fW7uEpYemcMEj6', 'editRole', '1455522298639');
INSERT INTO `t_permission` VALUES ('NJK2NUrv5WjuXJq2WK2eoj', '新增角色', 'Hb8aqqQf73QEyjCTGZQTEz', 'Hb8aqqQf73QEyjCTGZQTEzNJK2NUrv5WjuXJq2WK2eoj', 'addRole', '1455522275304');
INSERT INTO `t_permission` VALUES ('Pg5hkZyeDHCLKAKrYwBsFv', '角色分配', '5FDrFjMKZUtYRka4xyhx2m', '5FDrFjMKZUtYRka4xyhx2mPg5hkZyeDHCLKAKrYwBsFv', 'addUserRole', '1455522562119');
INSERT INTO `t_permission` VALUES ('pJtid4n7cK5VadH3ujzww', '用户禁用/启用', '5FDrFjMKZUtYRka4xyhx2m', '5FDrFjMKZUtYRka4xyhx2mpJtid4n7cK5VadH3ujzww', 'isDisableUser', '1455522226095');
INSERT INTO `t_permission` VALUES ('PZwJRFWhLyxfg7TKYei3XB', '添加权限', 'JDBbaA3N1A2k5bLXW2umLp', 'JDBbaA3N1A2k5bLXW2umLpPZwJRFWhLyxfg7TKYei3XB', 'addPermission', '1455522323954');
INSERT INTO `t_permission` VALUES ('PZwJRFWhLyxfg7TKYei3XU', '角色禁用/启用', 'Hb8aqqQf73QEyjCTGZQTEz', 'Hb8aqqQf73QEyjCTGZQTEzPZwJRFWhLyxfg7TKYei3XU', 'isDisableRole', '1455522323954');
INSERT INTO `t_permission` VALUES ('TKiW5PcTZN3QaFhgwnKPy4', '用户编辑', '5FDrFjMKZUtYRka4xyhx2m', '5FDrFjMKZUtYRka4xyhx2mTKiW5PcTZN3QaFhgwnKPy4', 'updateUser', '1455522185335');
INSERT INTO `t_permission` VALUES ('Wfo2prUVPhFom8BBMk34JX', '新增用户', '5FDrFjMKZUtYRka4xyhx2m', '5FDrFjMKZUtYRka4xyhx2mWfo2prUVPhFom8BBMk34JX', 'addUser', '1455522139533');
INSERT INTO `t_permission` VALUES ('Wfo2prUVPhFom8BBMq34JX', '修改权限', 'JDBbaA3N1A2k5bLXW2umLp', 'JDBbaA3N1A2k5bLXW2umLpWfo2prUVPhFom8BBMq34JX', 'updatePermission', '1455522139533');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `UUID` char(22) NOT NULL,
  `ROLE_NAME` varchar(255) DEFAULT NULL,
  `MEMO` text,
  `DELETE_FLAG` char(1) DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('9uL5YCH8pkr7eLyUVvZap3', '权限管理员', '权限管理', '0');
INSERT INTO `t_role` VALUES ('BygkxVTiTUakGfo4GfVwLG', '用户管理员', '用户管理', '0');
INSERT INTO `t_role` VALUES ('FTkgFSF5rNzvKqKSakU7rC', '角色管理员', '角色管理', '0');
INSERT INTO `t_role` VALUES ('NstCrnT9psbLZjp1uEPk6k', '系统管理员', '负责系统的开发', '0');
INSERT INTO `t_role` VALUES ('Sn997ABpxTB4XACFU5hhS', '测试用户1分配用户查看 角色管理', '1分配用户查看 角色管理', '0');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `UUID` char(22) NOT NULL,
  `ROLE_UUID` char(22) DEFAULT NULL,
  `PERMISSION_UUID` char(22) DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('2D3v6B8h6qULSoR6Yhw3L4', 'NstCrnT9psbLZjp1uEPk6k', 'Wfo2prUVPhFom8BBMk34JX');
INSERT INTO `t_role_permission` VALUES ('3sBvAW66bmHQQ9CZvUiEt5', 'NstCrnT9psbLZjp1uEPk6k', '5FDrFjMKZUtYRka4xyhx2m');
INSERT INTO `t_role_permission` VALUES ('3SryJwEiR8tdugEbukXeA8', 'NstCrnT9psbLZjp1uEPk6k', 'Pg5hkZyeDHCLKAKrYwBsFv');
INSERT INTO `t_role_permission` VALUES ('46eSNNyTSu9YGrR7iySy8r', 'Sn997ABpxTB4XACFU5hhS', 'CTNyK1qWWLZCQcUF3QHcCo');
INSERT INTO `t_role_permission` VALUES ('4hc6vkPwrG3CVwqaJWucCe', 'BygkxVTiTUakGfo4GfVwLG', 'Pg5hkZyeDHCLKAKrYwBsFv');
INSERT INTO `t_role_permission` VALUES ('4o21hhbWc1U7UEp9BmMn4y', 'NstCrnT9psbLZjp1uEPk6k', 'PZwJRFWhLyxfg7TKYei3XU');
INSERT INTO `t_role_permission` VALUES ('7KeFKB8KVfS9QZJMw8cvTV', 'NstCrnT9psbLZjp1uEPk6k', 'JDBbaA3N1A2k5bLXW2umLp');
INSERT INTO `t_role_permission` VALUES ('8sPU949ormxEYppqrUM563', 'BygkxVTiTUakGfo4GfVwLG', 'pJtid4n7cK5VadH3ujzww');
INSERT INTO `t_role_permission` VALUES ('9WHFnoeyArktUxR4nLQoAG', 'Sn997ABpxTB4XACFU5hhS', '5FDrFjMKZUtYRka4xyhx2m');
INSERT INTO `t_role_permission` VALUES ('A4upxbyxiFVH2ab3Fqjrz5', '9uL5YCH8pkr7eLyUVvZap3', 'PZwJRFWhLyxfg7TKYei3XB');
INSERT INTO `t_role_permission` VALUES ('CkSuu2NTPYZJ4549eja8ff', 'FTkgFSF5rNzvKqKSakU7rC', 'Hb8aqqQf73QEyjCTGZQTEz');
INSERT INTO `t_role_permission` VALUES ('DPtFDmup9QVy266CQMUXW4', 'Sn997ABpxTB4XACFU5hhS', 'NJK2NUrv5WjuXJq2WK2eoj');
INSERT INTO `t_role_permission` VALUES ('E3DdcBzKyzdBr99VyRitZr', 'NstCrnT9psbLZjp1uEPk6k', 'LWuoYhT7fW7uEpYemcMEj6');
INSERT INTO `t_role_permission` VALUES ('EJgfZvBpXHtYqXVvMmwEtN', 'FTkgFSF5rNzvKqKSakU7rC', 'LWuoYhT7fW7uEpYemcMEj6');
INSERT INTO `t_role_permission` VALUES ('Eqtc67gbisVFnN97Bus8AR', 'BygkxVTiTUakGfo4GfVwLG', 'Wfo2prUVPhFom8BBMk34JX');
INSERT INTO `t_role_permission` VALUES ('GcsA23SPAAruNnYwgGHmuJ', 'FTkgFSF5rNzvKqKSakU7rC', 'CTNyK1qWWLZCQcUF3QHcCo');
INSERT INTO `t_role_permission` VALUES ('GtX7ygZWXNgP6i7q9C77Br', 'Sn997ABpxTB4XACFU5hhS', 'Hb8aqqQf73QEyjCTGZQTEz');
INSERT INTO `t_role_permission` VALUES ('HzXYx2fpY7DZpzgfGhp5iC', 'NstCrnT9psbLZjp1uEPk6k', 'PZwJRFWhLyxfg7TKYei3XB');
INSERT INTO `t_role_permission` VALUES ('KyAJJxqKhU71U2STC55mLu', 'NstCrnT9psbLZjp1uEPk6k', 'Hb8aqqQf73QEyjCTGZQTEz');
INSERT INTO `t_role_permission` VALUES ('MDMCpRJyYupc5knYPasnyE', 'FTkgFSF5rNzvKqKSakU7rC', 'NJK2NUrv5WjuXJq2WK2eoj');
INSERT INTO `t_role_permission` VALUES ('Me6v8rqkhpvSsY2HptaZJ5', 'BygkxVTiTUakGfo4GfVwLG', 'TKiW5PcTZN3QaFhgwnKPy4');
INSERT INTO `t_role_permission` VALUES ('NGCRyE4UY6XvBdQwHSckZk', 'NstCrnT9psbLZjp1uEPk6k', 'TKiW5PcTZN3QaFhgwnKPy4');
INSERT INTO `t_role_permission` VALUES ('PdcQHKoJJ3apAg4oJxNUT7', 'BygkxVTiTUakGfo4GfVwLG', '5FDrFjMKZUtYRka4xyhx2m');
INSERT INTO `t_role_permission` VALUES ('PkNjiTeMFaw44NCN9HKNXA', 'FTkgFSF5rNzvKqKSakU7rC', 'PZwJRFWhLyxfg7TKYei3XU');
INSERT INTO `t_role_permission` VALUES ('PXRLcEBezRdSnLazQaH3SH', '9uL5YCH8pkr7eLyUVvZap3', 'JDBbaA3N1A2k5bLXW2umLp');
INSERT INTO `t_role_permission` VALUES ('R7qQHv5pfJrQvPKPkPrAXa', 'NstCrnT9psbLZjp1uEPk6k', 'DvAo6KpRCXaX1G7Nxe7Vfs');
INSERT INTO `t_role_permission` VALUES ('RyFM7WVHNrVwswJLecpEQy', 'Sn997ABpxTB4XACFU5hhS', 'PZwJRFWhLyxfg7TKYei3XU');
INSERT INTO `t_role_permission` VALUES ('U6FjJm3zm5VegmBcrVi6R4', '9uL5YCH8pkr7eLyUVvZap3', 'DvAo6KpRCXaX1G7Nxe7Vfs');
INSERT INTO `t_role_permission` VALUES ('UVErWSmR81dwjaH1tX1ecf', 'NstCrnT9psbLZjp1uEPk6k', 'CTNyK1qWWLZCQcUF3QHcCo');
INSERT INTO `t_role_permission` VALUES ('VFEETs1EpfabJRhZqD1hmB', 'NstCrnT9psbLZjp1uEPk6k', 'Wfo2prUVPhFom8BBMq34JX');
INSERT INTO `t_role_permission` VALUES ('VsQQLvSW6RPA2hEXL8cw7v', 'NstCrnT9psbLZjp1uEPk6k', 'pJtid4n7cK5VadH3ujzww');
INSERT INTO `t_role_permission` VALUES ('VxV6R9HrsPZgACrAwCeV4W', 'Sn997ABpxTB4XACFU5hhS', 'LWuoYhT7fW7uEpYemcMEj6');
INSERT INTO `t_role_permission` VALUES ('WFt4wVgkrRF4BFhRwaZtEN', 'FTkgFSF5rNzvKqKSakU7rC', '5FDrFjMKZUtYRka4xyhx2m');
INSERT INTO `t_role_permission` VALUES ('WwDxbVdcPvJBzMZAbVsjZw', '9uL5YCH8pkr7eLyUVvZap3', 'Wfo2prUVPhFom8BBMq34JX');
INSERT INTO `t_role_permission` VALUES ('YV5zuAcVvtNqGKoDrSRXpj', 'NstCrnT9psbLZjp1uEPk6k', 'NJK2NUrv5WjuXJq2WK2eoj');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `UUID` char(22) NOT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `SALT` varchar(255) DEFAULT NULL,
  `DELETE_FLAG` char(1) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1tYKbCbhmQK4zEMXizH54', 'permission', 'dfd4d884c02a6d1d59d6f680600f764709271089', 'a8499a02c65cbd9d208d', '1', 'permission');
INSERT INTO `t_user` VALUES ('3kohaD3NFSTRd8aBrTervd', 'a100488', 'c952bab984534778a70f592c15c307ae4c021262', 'd11ea365b360c4f6fc93', '0', '宋安伟');
INSERT INTO `t_user` VALUES ('7T4zgN2Nr7XtBXpB8ZvBLu', 'user', '898da9aef5ef067a8f5a37b7f39673025ba07859', '5ed99d19b7b7e5cc33c9', '0', 'user');
INSERT INTO `t_user` VALUES ('HFFN1wYPWckG24HUxYMGTd', 'system', '2f6b029d97b21a8d27e0e8a49845deb625389fa6', '43d68cf498558b44c9ec', '0', '系统管理员');
INSERT INTO `t_user` VALUES ('V8GvHBS1ZTfZ4JdxnekqD8', 'role', '46223f2b93d66d97452b45d96bbb2bd5a2fe0300', '747326355af8bcc94e09', '0', 'role');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `UUID` char(22) NOT NULL,
  `USER_UUID` char(22) DEFAULT NULL,
  `ROLE_UUID` char(22) DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('2gZfcXdzg1MUWFFAqpy4Pk', 'HFFN1wYPWckG24HUxYMGTd', 'NstCrnT9psbLZjp1uEPk6k');
INSERT INTO `t_user_role` VALUES ('6hpocW3barKmFNH1zKMnDV', 'dwqNGjBziamJahuBR5iZ6', 'NstCrnT9psbLZjp1uEPk6k');
INSERT INTO `t_user_role` VALUES ('A3bNz2fA7ea4WpUWFqvW5d', 'SJpu4GBPVX48TRYsM9zhAv', '3EzB3heDKwNFpU9GzTq9LU');
INSERT INTO `t_user_role` VALUES ('C7GULkdWp89Nh8CNQVpbbL', '5NNQvgEge4AYbjYn54sShy', '3EzB3heDKwNFpU9GzTq9LU');
INSERT INTO `t_user_role` VALUES ('Cj3gtSeaBjEMGXiNGFboKK', '1tYKbCbhmQK4zEMXizH54', '9uL5YCH8pkr7eLyUVvZap3');
INSERT INTO `t_user_role` VALUES ('MKGSwPrBZNiPY5dthCwjYA', 'SJpu4GBPVX48TRYsM9zhAv', 'NstCrnT9psbLZjp1uEPk6k');
INSERT INTO `t_user_role` VALUES ('R6iNGgeFjhzsiZkkMrN3t4', 'V8GvHBS1ZTfZ4JdxnekqD8', 'FTkgFSF5rNzvKqKSakU7rC');
INSERT INTO `t_user_role` VALUES ('VjTkonU3RPLbAuugFNk3Jr', '3kohaD3NFSTRd8aBrTervd', 'NstCrnT9psbLZjp1uEPk6k');
INSERT INTO `t_user_role` VALUES ('Xu1BQE8HGY94JzDwkig5yv', '7T4zgN2Nr7XtBXpB8ZvBLu', 'BygkxVTiTUakGfo4GfVwLG');
