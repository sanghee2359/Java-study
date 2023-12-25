package ps.recursive;
// 1부터 n까지 출력하는 프로그램
public class Recursive {
    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n-1);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        Recursive O = new Recursive();
        O.DFS(3);
    }
}
