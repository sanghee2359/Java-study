package ps.recursive;
// 1부터 n까지 출력하는 프로그램
public class Recursive {
    // 스택 프레임 사용 - 매개변수, 지역변수 ,복귀주소 정보가 저장
    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n-1);
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Recursive O = new Recursive();
        O.DFS(3);
    }
}
