
SELECT ename, sal*12 AS 연봉
	FROM EMP e
	WHERE sal*12 >= 36000;

/**
 * null 값이 있다면 그것과 연산되는 값도 null값이 된다.
 * 왜냐하면 그것을 표현할 방법을 모르기 때문
 */
SELECT sal + comm, sal, comm
	FROM EMP e;
/**
 * NVL함수를 이용하면 null값을 대신할 값을 정할 수 있다.
 */
SELECT sal + NVL(comm, 0)
	FROM EMP e 
	WHERE ename = 'KING';
	
/**
 * between and문은 앞쪽에 하한값, 뒤쪽에 상한값이 위치해야한다.
 */
SELECT ename, sal
	FROM EMP e 
	WHERE sal BETWEEN 3000 AND 2000;
	

SELECT * FROM EMP e 
	WHERE ename LIKE 'S%';

SELECT *
	FROM EMP e 
	WHERE comm IS NULL;

SELECT *
	FROM EMP e 
	WHERE comm IS NULL AND sal > 2000;

SELECT *
	FROM EMP e 
	WHERE job IN ('MANAGER', 'ANALYST');



