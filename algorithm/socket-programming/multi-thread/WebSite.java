package multi-thread;

import java.util.Random;

public class WebSite implements Runnable {

    private final String webSiteName;
    private final WebBrowser webBrowser;
    private final Integer num;
    private boolean allExit = true;

    public WebSite(final String webSiteName, final WebBrowser webBrowser, int num) {
        this.webSiteName = webSiteName;
        this.webBrowser = webBrowser;
        this.num = num;
    }

    @Override
    public void run() {
        // 메서드 블럭 동기화
        synchronized (this) {
            while (allExit) {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                webBrowser.createNewTab(webSiteName);

                if(webBrowser.webSiteIndex==num){  // 현재 브라우저에 출력되는 인덱스(개수) == 사용자가 입력한 출력 개수
                    allExit = false; // 더 이상 탭을 추가하거나 삭제하지 않음
                }
            }
        }
    }

}