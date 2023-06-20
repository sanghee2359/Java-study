
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Semaphore;


/*
 * - 요구사항
 * 스레드의 실행 순서는 JVM의 스레드 스케줄링에 의해 결정되므로, 우선순위는 보장되지 않습니다.
 * 스레드의 실행 순서나 제어에 대한 요구사항이 있다면 세마포어, lock, 조건 변수 등의 동기화 기법을 사용하여 제어해야 합니다.
 *
 * 스무고개 게임
 * 1) 1개의 문제와 20개의 힌트 설정
 * 2) Game 스레드가 시작되면 제한시간 60초 타이머와 배경음악 스레드가 실행됨
 * 3) JOptionPane 박스에 추측한 답을 입력하며, 오답 시 다음 힌트가 하나씩 표시됨
 * 3-1) 오답일 경우 Score –5점씩 감점, 20번 틀리면 게임오버
 * 4) 공유자원으로 Score 및 스레드의 조건을 걸어줄 flag들이 있습니다.
 * 5) Game -> Result 순서로 수행 (semaphore)
 * 5-1) Game 스레드가 끝날 때쯤 semaphore.release()를 해주면서 Result 스레드의 semaphore.acquire() 수행 가능
 * 6) Result box엔 Score 결과, 종료, 다시 시작 버튼이 있으며, 다시 시작 시 공유자원을 reset하므로 새 게임처럼 진행가능
 *
 */

class Game extends Thread
{
    JOptionPane pane = new JOptionPane();
    String ans = "독도";
    String hint[]={"한국","일본","칠성사이다","역사","경상북도",
            "경비대","MB","군인","동남쪽","뱃길",
            "이백리","외롭다","조그마한","다케시마","남의것",
            "땅","울릉도","제주도","제부도","마라도"};

    public void run()


    {
        Thread t1 = Thread.currentThread();
        System.out.println("["+t1.getName()+"] game 스레드 수행 시작 ...");
        int i = 0;
        for(i = 0; i<20; i++)
        {
            String input = pane.showInputDialog(
                    null,
                    (i+1)+"번째 힌트 : " + hint[i],
                    "스무고개",
                    JOptionPane.QUESTION_MESSAGE);

            try{
                if(input.equals(ans))

                {
                    twenty_ques.chk = true;
                    break;
                }
                else if(i < 20 && twenty_ques.timeout) {
                    twenty_ques.Score = 0;
                    break;
                }
                else if(!twenty_ques.timeout)
                {
                    System.out.println(">> 오답 : " + input);
                    twenty_ques.Score = (twenty_ques.Score) - 5; // 점수 감점
                    System.out.println(">> 감점 : -5  현재점수 : " + twenty_ques.Score);
                }
            }catch (NullPointerException e) {
                twenty_ques.Score = 0;
                twenty_ques.clear = true;
                break;
            }
        }

        twenty_ques.out = true;
        // synch 세마포어 값 증가
        twenty_ques.synch.release();
    }
}

class Timer extends Thread
{
    public void run()
    {
        int i;
        Thread th = Thread.currentThread();
        System.out.println("["+th.getName()+"] time 스레드 시작 ...");
        for(i=60;i>=1 ;i--)
        {
            if(twenty_ques.chk ||twenty_ques.out) {
                break; // 정답을 맞췄을 경우 종료
            }

            try
            {
                Thread.sleep(1000);
                System.out.println("남은시간 : " + i +"초");
            }
            catch (Exception e)
            {

            }
        }
        if(twenty_ques.chk)
        {
            System.out.println("정답을 맞추셨습니다. 당신의 점수는 " + twenty_ques.Score + "점 입니다.");
        }
        else if(twenty_ques.out && twenty_ques.clear) {

            System.out.println("게임이 종료되었습니다.");
        }
        else if (i == 0) {
            twenty_ques.timeout = true;
            System.out.println("Time over. 게임을 종료합니다.");
        }
        else if(twenty_ques.out)
        {
            System.out.println("힌트 소진!!! 게임을 종료합니다.");
        }
    }
}
class Result extends JFrame implements Runnable{
    private JLabel scoreLabel;
    @Override
    public void run() {

        try {
            twenty_ques.synch.acquire();

            // 실행 중인 스레드 출력
            Thread th = Thread.currentThread();
            System.out.println("["+th.getName()+"] result 스레드 시작 ...");

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new FlowLayout());

            // 스코어 라벨 생성
            scoreLabel = new JLabel("Score: " + twenty_ques.Score);
            mainPanel.add(scoreLabel);
            // 종료 버튼 생성
            JButton exit = new JButton("종료");
            exit.addActionListener(new ExitButtonListener());
            mainPanel.add(exit);
            // 다시시작 버튼 생성
            JButton retry = new JButton("다시시작");
            retry.addActionListener(new RetryButtonListener());
            mainPanel.add(retry);

            // 프레임에 패널 추가
            add(mainPanel);

            pack();
            setLocationRelativeTo(null);
            setVisible(true);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // 버튼 리스너 클래스
    class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    class RetryButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 초기화
            reset();
            // 스레드 재 실행
            Thread th = new Thread(new Game());
            th.start();
            Timer t = new Timer();
            t.start();
            Thread th2 = new Thread(new Result());
            th2.start();
        }
        public void reset() {
            twenty_ques.Score = 100;
            twenty_ques.chk = false;
            twenty_ques.out = false;
            twenty_ques.timeout = false;
            dispose();
        }
    }
}
class Music extends Thread{
    private static AudioInputStream bgm;
    @Override
    public void run() {
        try {
            bgm = AudioSystem.getAudioInputStream(new File("sound/bgm.wage"));
            Clip clip = AudioSystem.getClip();
            clip.open(bgm);

            // 소리설정
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f);
            clip.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class twenty_ques {

    static boolean chk = false;
    static boolean out = false;
    static boolean clear = false;
    static boolean timeout = false;
    static int Score = 100;
    static Semaphore synch = new Semaphore(0);

    /**
     * @param args
     */
    public static void  main(String[] args)
    {
        Game my_game = new Game();
        Timer time = new Timer();
        Thread result = new Thread(new Result());
        // 스레드 실행
        time.start();
        my_game.start();
        result.start();

    }
}