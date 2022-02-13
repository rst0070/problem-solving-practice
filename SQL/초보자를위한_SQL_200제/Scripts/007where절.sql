/**
 * where절을 이용해 검색의 조건을 지정한다.
 * 
 */
SELECT ename, sal, job
	FROM emp
	WHERE sal >= 3000;
	
/**
 * 비교연산자
 * BETWEEN . AND .
 * IS NULL
 * IN
 */

SELECT *
	FROM emp
	WHERE sal BETWEEN 2000 AND 3000;
	
/**
 * where 절에는 별칭을 사용할 수 없다.
 * sql문의 실행순서 때문인데
 * 1. from절
 * 2. where절
 * 3. select절
 */