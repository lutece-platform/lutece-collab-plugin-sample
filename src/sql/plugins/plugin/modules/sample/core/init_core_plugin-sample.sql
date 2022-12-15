
--
-- Data for table core_admin_right
--
DELETE FROM core_admin_right WHERE id_right = 'PLUGIN_SAMPLE_MANAGEMENT';
INSERT INTO core_admin_right (id_right,name,level_right,admin_url,description,is_updatable,plugin_name,id_feature_group,icon_url,documentation_url, id_order ) VALUES 
('PLUGIN_SAMPLE_MANAGEMENT','plugin-sample.adminFeature.ManageSample.name',1,'jsp/admin/plugins/plugin-sample/ManageProjects.jsp','plugin-sample.adminFeature.ManageSample.description',0,'plugin-sample',NULL,NULL,NULL,4);


--
-- Data for table core_user_right
--
DELETE FROM core_user_right WHERE id_right = 'PLUGIN_SAMPLE_MANAGEMENT';
INSERT INTO core_user_right (id_right,id_user) VALUES ('PLUGIN_SAMPLE_MANAGEMENT',1);

