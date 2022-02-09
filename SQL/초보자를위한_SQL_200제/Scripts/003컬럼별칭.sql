/**
 * AS는 컬럼명을 변환시킬수 있다.
 */
SELECT empno AS 번호, ename AS 이름, sal AS "Salary"
	FROM emp;
	

/**
 * as는 select절 안에 연산이 있는경우에도 유용
 */
SELECT ename, sal * 0.1 AS 부가가치세
	FROM emp
	ORDER BY �ΰ���ġ�� desc;