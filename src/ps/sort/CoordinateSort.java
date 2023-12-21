package ps.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 정렬기준 : 먼저 x값에 의해서 정렬, x값이 같을 경우 y값에 의해 정렬
// 5개의 좌표 오른차순 정렬
class Point implements Comparable<Point>{ // comparable 인터페이스의 구현체
   public int x, y;
   Point(int x, int y) {
       this.x = x;
       this.y = y;
   }
   // 정렬 기준
   // 인터페이스 안에 compare to 메소드 재정의
    @Override
    public int compareTo(Point o) {
       // x값이  같으면 y끼리 비교, x값이 다르면 x 오름차순
       if(this.x == o.x) return this.y-o.y;
       else {
           return this.x - o.x;
       }
       // 음수가 return 되도록
        // 오름차순 정렬 : 메소드 호출의 this 객체 - 매개변수 객체
        // 내림차순 정렬 : 매개변수 객체 - 메소드 호출의 this 객체
    }
}
public class CoordinateSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();// 좌표 개수
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x, y)); // arrylist에 추가
        }
        // 정렬
        Collections.sort(arr);

        for(Point o : arr) System.out.println(o.x+" "+o.y);
    }
}
