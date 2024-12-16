package multi-thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WebBrowser {

    private static final String SPACE = " ";

    private final List<String> webSiteNames = new ArrayList<>();
    public final List<Integer> webSiteIndexes = new ArrayList<>();

    private PrintWriter out;
    private final int maxWebCount; // 최대로 노출될 수 있는 탭의 수
    public int webSiteIndex = 0;  // 현재 활성화된 웹사이트의 개수를 저장하는 변수

    public WebBrowser(final int maxWebCount, Socket socket) {
        this.maxWebCount = maxWebCount;
        try {
            out = new PrintWriter( socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 메서드 동기화
    public synchronized void createNewTab(final String webSiteName) {
        try {
            Thread th = Thread.currentThread(); // 현재 접근한 스레드 정보를 저장
            if (full()) { // maxWebCount에 공간이 남았는지 확인
                wait(); // 모니터 Condition Variable
            }
            System.out.println("["+th.getName()+"] >"+webSiteName + " 사이트가 켜지는 중입니다...");
            Thread.sleep(new Random().nextInt(1000)); // 0~1초 랜덤으로 멈췄다가 다시 스레드 수행

            webSiteNames.add(webSiteName);
            System.out.println(webSiteNames.toString());
            webSiteIndexes.add(++webSiteIndex); // websiteIndex 배열에 1 증가시킨 현재 index를 저장
            showRunningBrowser();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void showRunningBrowser() {
        if (webSiteNames.size() > maxWebCount) {
            throw new UnsupportedOperationException("현재 브라우저 탭이 6개 이상 활성화 되어 강제 종료합니다...");
        }

        out.println("┌───────────────────────────────────────────────────────────────────────────────┐");
        out.println("│ ◆  Web Browser                                                          - □ x │");
        out.println("└───────────────────────────────────────────────────────────────────────────────┘");

        StringBuilder browserNameLine = new StringBuilder();
        StringBuilder browserUnderLine = new StringBuilder();

        if (webSiteNames.size() > 0) {
            browserNameLine.append("│");
            browserUnderLine.append("└");
        }

        for (int i = 0; i < webSiteNames.size(); i++) {
            browserNameLine.append(generateWebSiteName(webSiteNames.get(i)))
                    .append(generateWebSiteIndex(webSiteIndexes.get(i)))
                    .append(" │");
            browserUnderLine.append("───────────────┘");
        }

        out.println(browserNameLine);
        out.println(browserUnderLine);
    }

    private String generateWebSiteName(final String name) {
        StringBuilder builder = new StringBuilder();

        if (name.length() > 11) {
            return name.substring(0, 11);
        }

        int space = 11 - name.length();
        int interval = space / 2;

        builder.append(SPACE.repeat(interval))
                .append(name)
                .append(SPACE.repeat(11 - interval - name.length()));

        return builder.toString();
    }
    public boolean hasSpace() {
        return webSiteNames.size() < maxWebCount;
    }
    private boolean full() {
        return !hasSpace();
    }
    public boolean isNotEmpty() {
        return webSiteNames.size() != 0;
    }
    private String generateWebSiteIndex(final int index) { // webSiteIndex 의 출력형식 맞추기
        if (index < 10) {
            return "00" + index;
        }
        if (index < 100) {
            return "0" + index;
        }
        return "" + index;
    }
    // 메서드 동기화
    public synchronized void removeAndNotify(int num) {
        Thread th = Thread.currentThread();
        if (isNotEmpty()) {
            webSiteNames.remove(0); // 이름 하나 삭제
            webSiteIndexes.remove(0); // 인덱스 하나 삭제
            // thread 작업 확인 용
            System.out.println("["+th.getName()+"] >"+webSiteNames.get(0) + " 사이트가 종료됩니다!");
            // 현재 출력되고 있는 웹사이트 리스트 (개수 확인용)
            System.out.println(webSiteNames.toString());

            showRunningBrowser();
            notify();   // 모니터 Condition Variable
        }
    }
}