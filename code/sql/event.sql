/* 使用event，每天删除过期未激活用户 */
SET GLOBAL event_scheduler = ON;
DROP EVENT IF EXISTS deleteUsers;
CREATE EVENT deleteUsers 
	ON SCHEDULE EVERY 1 DAY ENABLE
    DO 
		DELETE FROM users
		WHERE role = 0 AND activateDue < current_date();