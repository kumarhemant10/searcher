INSERT INTO `config_columns` ( `index_id`, `column_display_name`, `column_name`, `search`, `display`, `active`,`last_modified_by`,`last_modified_datetime`,`created_by`,`created_datetime`) VALUES
	( 1, 'Play Name', 'play_name', b'1', b'1', b'1','hemant',now(),'hemant',now()),
	( 1, 'Speech Number', 'speech_number', b'1', b'1', b'1','hemant',now(),'hemant',now()),
	( 1, 'Line Number', 'line_number', b'1', b'1', b'1','hemant',now(),'hemant',now()),
	( 1, 'Speaker', 'speaker', b'1', b'1', b'1','hemant',now(),'hemant',now()),
	( 1, 'Text Entry', 'text_entry', b'1', b'1', b'1','hemant',now(),'hemant',now()),
	( 1, 'Line Id', 'line_id', b'1', b'1', b'1','hemant',now(),'hemant',now()),
	( 1, 'Type', 'type', b'1', b'1', b'1','hemant',now(),'hemant',now());
	
INSERT INTO `config_index` (`index_name`, `index_url`, `active`,`last_modified_by`,`last_modified_datetime`,`created_by`,`created_datetime`) VALUES
	('Ecommere-data', 'kibana_sample_data_ecommerce',b'1','hemant',now(),'hemant',now()),
	( 'sample-logs', 'kibana_sample_data_logs',b'1','hemant',now(),'hemant',now());
	