
--
-- Structure for table plugin_sample_project_
--

DROP TABLE IF EXISTS plugin_sample_project_;
CREATE TABLE plugin_sample_project_ (
id_project int AUTO_INCREMENT,
title varchar(50) default '' NOT NULL,
description varchar(255) default '' NOT NULL,
range_of_publication_date date NOT NULL,
date varchar(255) default '',
choice varchar(255) default '',
PRIMARY KEY (id_project)
);
