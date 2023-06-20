package multi-thread;

public class WebSiteCloser implements Runnable {

    private final WebBrowser webBrowser;
    private boolean allExit = true;
    private Integer num;
    public WebSiteCloser(WebBrowser webBrowser, int num) {
        this.webBrowser = webBrowser;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            while (allExit) {
                Thread.sleep(3000);
                webBrowser.removeAndNotify(num);
                if(webBrowser.webSiteIndex==num){
                    allExit = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}