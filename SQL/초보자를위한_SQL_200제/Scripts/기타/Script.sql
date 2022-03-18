SELECT *
	FROM emp
	left JOIN dept
	ON emp.deptno = dept.deptno AND dept.deptno = 10;
	
SELECT job
	FROM emp
UNION ALL
SELECT name
	FROM email;
	
SELECT *
	FROM email;
	
SELECT * 
	FROM emp;
	//GROUP BY job;