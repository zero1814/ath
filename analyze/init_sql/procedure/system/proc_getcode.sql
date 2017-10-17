DROP PROCEDURE
IF EXISTS `proc_getcode`;
DELIMITER ; 
CREATE PROCEDURE `proc_getcode` (IN p_code_start VARCHAR(100))
BEGIN
DECLARE p_date CHAR (6);
DECLARE p_now CHAR (6);
DECLARE p_return VARCHAR (30);
DECLARE p_nowno INT;
SET p_now = DATE_FORMAt(now(), '%y%m%d');
SET p_date = ifnull(
	(
		SELECT
			a.date_apply
		FROM
			sm_code a
		WHERE
			a.code_start = p_code_start
	),
	''
);
IF (p_date = '') THEN
	INSERT INTO `sm_code` (
		`uid`,
		`code_start`,
		`date_apply`,
		`min_number`,
		`now_number`
	)
VALUES
	(
		REPLACE (uuid(), '-', ''),
		p_code_start,
		p_now,
		100000,
		100000
	);
SET p_date = p_now;
END
IF;
IF (p_date != p_now) THEN
IF length(p_date) != 6 THEN
SET p_now = '';
ELSE
	UPDATE sm_code
SET now_number = min_number,
 date_apply = p_now
WHERE
	code_start = p_code_start
AND flag_date = 1;
END
IF;
END
IF;
START TRANSACTION;
SET p_return = (
	SELECT
		now_number
	FROM
		sm_code zwwc
	WHERE
		zwwc.code_start = p_code_start FOR UPDATE
);
SET p_return = p_return + 1;

UPDATE sm_code
SET now_number = p_return
WHERE
	code_start = p_code_start;
COMMIT;
SELECT
	concat(
		p_code_start,
		p_now,
		p_return
	) AS webcode;
END;
DELIMITER;