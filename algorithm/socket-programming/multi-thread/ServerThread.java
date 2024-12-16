package multi-thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ServerThread extends Thread {

    private Server Server;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private WebBrowser webBrowser;

    public ServerThread(Server Server, Socket socket) {
        this. Server = Server;
        this. socket = socket;

    }

    public void run() {
        try {
            webBrowser = new WebBrowser(5, socket); // webBrower을 client로 보내기 위해 소켓 추가
            // 클라이언트가 보낸 메세지 읽을 스트림
            in = new BufferedReader( new InputStreamReader(
                    socket.getInputStream()));
            // 클라이언트로 메세지를 보내는 스트림
            out = new PrintWriter( socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {

                // 클라이언트가 보낸 메세지 받기
                String message = in.readLine(); // site 이름
                int num = Integer.valueOf(in.readLine()); // 활성화 할 개수

                Thread thread = new Thread(new WebSite(message, webBrowser, num)); // this = ChatServer 객체
                final Thread closer = new Thread(new WebSiteCloser(webBrowser, num));
                thread.start(); // 증식하는 메소드
                closer.start(); // 삭제하는 메소드

                out.println("get "+message+" Stream..."); // thread가 잘 수행되었을 경우 수행확인을 client에게 전송
            }

        } catch (SocketTimeoutException e) {
            Server.getUsers().remove( this);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}