package networkServer;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class NetworkClient extends JFrame {
    public final static int SERVER_PORT=9000;
    private JTextField messageField;
    private JTextArea messages;

    // 생성자
    public NetworkClient() {
        super(" TCP Client");
        messageField=new JTextField(40); // 절대 위치와 크기 지정
        messages=new JTextArea(10,50); // rows, columns 지정

        messages.setBackground(Color.black);                    // 배경 검은색
        JScrollPane scrolledMessages=new JScrollPane(messages); // 스크롤 가능하도록

        this.setLayout(new BorderLayout(10,10));
        this.add("North",messageField);
        this.add("Center",scrolledMessages);

        messages.setEnabled(false); //TextArea disactive

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(620,400);
        this.setLocationRelativeTo(null);   //창 가운데 위치
        this.setVisible(true);

        // client program 핵심 메소드
        connectServer();
    }

    public void connectServer() {
        String serverIP="172.30.58.101";

        try {
            // 서버로 접속 시도 (서버의 IP, PORT가 필요하다)
            Socket s=new Socket(serverIP,SERVER_PORT);
            messages.append("server port:"+s.getPort()+", my port:"+s.getLocalPort()+"\n");
            // socket 통신을 하기 때문에 socket의 stream을 가져옴
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

            // 서버로부터 메시지 받기 위한 부분 - 서버가 보내는 문자열 한 줄을 읽어들임
            String str = br.readLine();
            int pos = 0; // 현재 문자열의 OFFSET을 넣을 변수
            while((pos = str.indexOf("   "))!=-1) { // 문자열에서 "   "이 없을 때까지 반복
                String tmp = str.substring(0, pos); // 0에서 pos까지의 문자열 자르기
                messages.append(tmp+"\n"); // 해당 문자열 뒤에 newLine을 추가
                str = str.substring(pos+3); // pos + 공백 다음의 문자열을 str에 저장
            }
            messages.append("\n");
            messages.append(str); // 남은 str을 출력
            br.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NetworkClient();
    }
}