DROP PROCEDURE
IF EXISTS sync_db_detail;

CREATE PROCEDURE sync_db_detail ()
BEGIN
	#添加数据表列表到sm_table
	INSERT INTO systemmodule.sm_table (
		uid,
		db_code,
		table_code,
		table_name,
		type,
		remark
	) SELECT
		REPLACE (uuid(), '-', ''),
		TABLE_SCHEMA,
		TABLE_NAME,
		TABLE_NAME,
		'table',
		TABLE_COMMENT
	FROM
		information_schema.`TABLES`
	WHERE
		TABLE_SCHEMA IN (
			SELECT
				db_code
			FROM
				systemmodule.sm_database
		)
	AND TABLE_NAME NOT IN (
		SELECT
			table_name
		FROM
			systemmodule.sm_table
	);

#添加数据表字段到sm_field
INSERT INTO systemmodule.sm_filed (
	`uid`,
	table_code,
	field_code,
	field_name,
	field_type,
	field_length,
	numeric_scale,
	is_nullable,
	field_default,
	field_key,
	sort_add,
	sort_edit,
	sort_chart,
	sort_book,
	sort_inquery,
	create_user,
	create_time,
	update_user,
	update_time
) SELECT
	REPLACE (uuid(), '-', ''),
	a.TABLE_NAME table_code,
	a.TABLE_NAME table_name,
	a.column_name column_code,
	a.column_name column_name,
	(
		CASE a.IS_Nullable
		WHEN 'YES' THEN
			0
		ELSE
			1
		END
	) is_nullable,
	a.Data_type,
	ifnull(
		a.CHARACTER_MAXIMUM_LENGTH,
		ifnull(NUMERIC_PRECISION, 0)
	) column_length,
	ifnull(a.NUMERIC_SCALE, 0) length_scale,
	a.COLUMN_COMMENT column_note,
	a.ORDINAL_POSITION sort_add,
	a.ORDINAL_POSITION sort_edit,
	a.ORDINAL_POSITION sort_chart,
	a.ORDINAL_POSITION sort_book,
	a.ORDINAL_POSITION sort_inquery,
	'db',
	now(),
	'db',
	now()
FROM
	information_schema. COLUMNS a
WHERE
	a.TABLE_SCHEMA IN (
		SELECT
			db_code
		FROM
			systemmodule.sm_database
	)
AND concat(a.TABLE_NAME, a.column_name) NOT IN (
	SELECT
		concat(table_name, field_code)
	FROM
		systemmodule.sm_filed
);


END