# spring framework project

SpringBoot + JPA를 활용한 CRUD (주소록) 샘플 애플리케이션입니다.

<h2>1. build and run</h2>
<h2>2. urls</h2>
<h2>3. h2 db console<h2>

----------------------------------------------------------------------------------------------------------------

<h3> build and run</h3>
<p>프로젝트 루트(hello)로 이동 후 명령어 입력<br>
<code>./gradlew clean bootJar test</code>
<p>

<p>./build/libs에 생성 된 hello-{version}-SNAPSHOT.jar 파일 실행<br>
<code>java -jar hello-{version}-SNAPSHOT.jar --spring.profiles.active=local</code>
<p>

<p>./gradlew test로 생성된 테스트 케이스 결과 확인 html <br>
<code>cd ./build/reports/tests/test | cd ./build/reports/tests/test/packges
</code>
<p>

<h3> urls </h3>
<p>
<strong>GET: http://localhost:8080/api/address-book/{id} - 주소 조회</strong><br>
파라미터: PathVariable {id}<br><br>
<strong>GET: http://localhost:8080/api/address-book/list - 주소 목록 조회</strong><br>
파라미터: 없음<br><br>
<strong>POST: http://localhost:8080/api/address-book/address - 주소 저장</strong><br>
파라미터: <code>
{
    "name":"name",
    "address":"address",
    "phone":"phone",
    "email":"test@gmail.com"
}
</code><br>
<strong>PUT: http://localhost:8080/api/address-book/address - 주소 수정</strong><br>
파라미터: <code>
{
    "id":target id,
    "name":"update name",
    "address":"update address",
    "phone":"update phone",
    "email":"update test@gmail.com"
}</code><br><br>
<strong>PUT: http://localhost:8080/api/address-book/use-yn - 주소 사용 여부 수정</strong><br>
파라미터: <code>
{
    "id":target id,
    "useYn":"N"
}</code><br><br>
<strong>DEL: http://localhost:8080/api/address-book/{id} - 주소 물리적 삭제</strong><br>
파라미터: PathVariable {id}<br>
</p>

<h3> h2 db console </h3>
<p>브라우저에 http://localhost:8080/h2-console 입력</p2>
<p> 1. Saved Settings: Generic H2(Embedded)<br>
2. JDBC URL: jdbc:h2:mem:test<br>
3. connect 버튼 클릭하여 로그인
<p>

<strong>*** in-memory db로 서버를 새로 실행할 때마다 초기화됩니다.****</strong>

