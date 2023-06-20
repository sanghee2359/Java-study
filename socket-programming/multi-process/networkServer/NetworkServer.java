package networkServer;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.ServerSocket;
import java.net.Socket;


public class NetworkServer {
    public static void main(String[] args) {
        // 부모 프로세스 pid 확인
        System.out.println("Parent Process PID : "+ManagementFactory.getRuntimeMXBean().getName());
        // 자식Process가 실행할 명령어 입력
        String[] command = new String[] {"ipconfig"};
        try {
            // 소켓 생성
            ServerSocket sock = new ServerSocket(9000);
            System.out.println("서버 대기 중");
            //accept를 통한 접속 대기
            Socket client = sock.accept(); // Client와 데이터 송수신 역할
            System.out.println(client+"의 연결을 허가");

            // 자식 프로세스를 생성하는 1 번째 방법
            ProcessBuilder process_builder = new ProcessBuilder(command);
            Process process = process_builder.start();
            // 자식 프로세스 pid 확인
            System.out.println("Child Process PID : "+process.pid());
            // 자식 프로세스가 종료될 때까지 기다림
            process.waitFor();
            try (InputStream psout = process.getInputStream()) {        // 자식 프로세스에서 실행한 값을 받아 저장
                InputStreamReader isr = new InputStreamReader(psout);   // 문자 단위
                BufferedReader br = new BufferedReader(isr);            // InputStreamReader 에 버퍼링 기능 추가
                PrintWriter pout = new PrintWriter(client.getOutputStream()); // socket 출력 스트림 초기화
                String line = null;
                // 자식프로세스가 보내는 문자열 한 줄씩 읽기(null이 될때까지)
                while((line = br.readLine())!=null){
                    // client로 보낼 메세지를 조합
                    pout.append(line+"   ");
                    // server console 출력
                    System.out.print("전송받은 값 : " );
                    System.out.println(line);
                    // client로 메시지를 전송
                    pout.flush();
                }
                // 0이 출력되면 정상 종료를 의미
                System.out.println("Child Process ended...(종료코드) ::: " + process.exitValue());

                while(true) {
                    // 연결된 client의 IP주소:Port번호를 보내줌
                    pout.println("client 주소:"+client.getInetAddress()+":"+client.getPort());
                    pout.flush();
                    client.close(); // socket 접속이 끊어지며 client와 연결 종료
                }
            }
        } catch (IOException e) {           // 파일이나 통신 등 디지털 정보의 입출력을 처리하는 클래스에서 에러가 발생할 경우 실행
            throw new RuntimeException(e);
        } catch (InterruptedException e) {  // 한창 작업중인 자식프로세스의 부모 프로세스가 갑자기 죽어버려서 멈춰버렸을 경우 실행
            throw new RuntimeException(e);
        }

    }

    /**
     * Runtime
     * 자식 프로세스를 생성하는 2번째 방법
     * return : console 출력
     */
    public static void byRuntime(String[] command) {
        try {
            Runtime runtime = Runtime.getRuntime();  //런타임 객체를 생성
            Process process = runtime.exec(command); //exec 메소드를 이용하여 프로세스를 생성
            NetworkServer.printStream(process);
        }catch(IOException e1) {

        }catch(InterruptedException e2) {

        }
    }
    public static void printStream(Process process) throws IOException, InterruptedException {
        // 자식 프로세스가 종료될 때까지 기다림
        process.waitFor();
        try (InputStream psout = process.getInputStream()) {
            // 프로세스에서 얻은 스트림을 System.out으로 복사
            NetworkServer.copy(psout, System.out);

        }
    }
    public static void copy(InputStream input, OutputStream output) throws IOException, InterruptedException {
        byte[] buffer = new byte[1024]; // 버퍼 생성
        int n = 0;
        while((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
    }
}
