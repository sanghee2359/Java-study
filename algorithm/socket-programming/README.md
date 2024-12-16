# TCP 소켓 프로그래밍
 1. TCP 연결 기반 소켓을 Java Socket 클래스로 구현한 코드입니다.
 2. TCP 소켓은 일반적으로 클라이언트-서버 모델에서 사용됩니다. 클라이언트는 서버에 요청을 보내고, 서버는 그 요청에 대한 응답을 반환합니다.

 ### process
- Date Server : 소켓 연결 된 client에게 현재 날짜정보 데이터를 전달
- Network Server`multi-process` : server의 `ipconfig` 네트워크 정보를 자식프로세스가 수행하여 client에게 전달 