/**
 * 문자열은 ''으로 감싼다.
 */
SELECT *
	FROM EMP e 
	WHERE e.ename = 'SCOTT';
	
/**
 * 날짜 형식 확인
 * RR과 YY의 차이는?
 * 만약 81로 입력하면 
 * RR은 1981로 인식하고 YY는 2081로 인식한다.
 * 즉 현재 세기를 기준으로 어떻게 인식하는지 차이가남.
 */
SELECT *
	FROM NLS_SESSION_PARAMETERS
	WHERE PARAMETER = 'NLS_DATE_FORMAT';
/**
 * 날짜형식도 ''로 감싸야한다.
 */	
SELECT ename, sal
	FROM EMP e 
	WHERE HIREDATE = '81/11/17';

/**
 * 세션의 파라미터를 변경하는 명령어
 * 즉 로그아웃될때 까지만 유지됨.
 */
ALTER SESSION SET nls_date_format='rr/mm/dd';

	
