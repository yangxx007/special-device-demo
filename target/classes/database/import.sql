INSERT INTO `SysPermission` (`id`,`available`,`name`,`parentId`,`parentIds`,`permission`,`resourceType`,`url`) VALUES (1,0,'用户管理',0,'0/','userInfo:view','menu','userInfo/userList');
INSERT INTO `SysPermission` (`id`,`available`,`name`,`parentId`,`parentIds`,`permission`,`resourceType`,`url`) VALUES (2,0,'用户添加',1,'0/1','userInfo:add','button','userInfo/userAdd');
INSERT INTO `SysPermission` (`id`,`available`,`name`,`parentId`,`parentIds`,`permission`,`resourceType`,`url`) VALUES (3,0,'用户删除',1,'0/1','userInfo:del','button','userInfo/userDel');
INSERT INTO `SysRole` (`id`,`available`,`description`,`role`) VALUES (1,0,'管理员','admin');
INSERT INTO `SysRole` (`id`,`available`,`description`,`role`) VALUES (2,0,'用户','user');
INSERT INTO `SysRole` (`id`,`available`,`description`,`role`) VALUES (3,0,'受理人','acceptor');
INSERT INTO `SysRole` (`id`,`available`,`description`,`role`) VALUES (4,0,'审批人','approver');
INSERT INTO `SysRole` (`id`,`available`,`description`,`role`) VALUES (5,0,'监管人','supervisor');
INSERT INTO `SysRolePermission` (`permissionId`,`roleId`) VALUES  (1,1),(2,1),(3,1);
INSERT INTO `UserInfo` (`username`,`name`,`password`,`salt`,`state`,`createtime`) VALUES ('admin', '管理员','d3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0, 0);
INSERT INTO `SysUserRole`(`uid`,`roleId`) VALUES (1,1);



