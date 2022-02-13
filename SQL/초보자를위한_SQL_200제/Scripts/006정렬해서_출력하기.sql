/**
 * order by절은 맨마지막에 위치하며 맨마지막에 실행된다.
 */
SELECT ename, sal
	FROM emp
	ORDER BY sal ASC;
	
/**
 * 위처럼 order by가 가장 나중에 실행되기 떄문에 별칭을 이용해도 가능.
 */
SELECT ename, sal AS 월급
	FROM emp
	ORDER BY 월급 ASC;