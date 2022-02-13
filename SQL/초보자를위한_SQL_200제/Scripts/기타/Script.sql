SELECT *
	FROM emp
	left JOIN dept
	ON emp.deptno = dept.deptno AND dept.deptno = 10;