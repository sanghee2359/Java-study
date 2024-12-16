package multi-thread;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private InputStream in;
    private BufferedReader br;
    private Scanner sc;
    private PrintWriter pout;
    private String website;
    public Client() {
        try {
            socket = new Socket("192.168.152.1", 9000);
            System.out.println("서버와 연결되었습니다.");
            System.out.println("접속할 webSite와 탭의 개수를 입력하세요");

            // input
            in = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            sc = new Scanner(System.in);

            // output
            // server로 메세지를 보내는 스트림
            pout = new PrintWriter( socket.getOutputStream(), true);
            website = sc.nextLine(); // 출력할 웹사이트 명
            int num = sc.nextInt(); // 활성화 할 웹사이트 개수

            pout.println(website);
            pout.println(num);

            String line = null;

            // 서버가 보낸 스트림을 라인별로 출력
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            sc.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}