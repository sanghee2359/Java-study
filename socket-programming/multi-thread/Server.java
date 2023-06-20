package multi-thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;


public class Server {
    private ArrayList<ServerThread> users = new ArrayList<>();
    private static Socket socketUser;
    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000); // 소켓 접속 대기
            System.out.println("서버 대기 중");
            serverSocket.setReuseAddress(true); //  SO_REUSEADDR이라는 옵션 활성화 -> 이전 연결이 시간 초과 상태인 경우에도 소켓을 바인딩할 수 있습니다
            String line = null;

            while(true) { // 다수의 클라이언트에게 지속적으로 서비스 하기 위해 while 이용
                socketUser = serverSocket.accept();
                ServerThread t = new ServerThread(this, socketUser);
                users.add(t);   // 서비스 받을 client 추가
                t.start();
            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new Server();
    }
    public ArrayList<ServerThread> getUsers() {
        return users;
    }

}
