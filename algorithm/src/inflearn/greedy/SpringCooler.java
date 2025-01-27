package inflearn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpringCooler {
    public int solution(int n, int[] nums){
        int answer = 0;
        List<Point> spot = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            spot.add(new Point(nums[i], i));
        }
        Collections.sort(spot);

        for () {
            Point point = spot.get(0);

        }
        return answer;
    }

    public static void main(String[] args){
        SpringCooler T = new SpringCooler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
class Point implements Comparable<Point> {

    int start;
    int end;
    int range;
    public Point(int num, int idx) {
        this.start = idx - num;
        this.end = idx + num;
        this.range = end - start;
    }
    @Override
    public int compareTo(Point o) {
        if(this.range == o.range) return this.end - o.end;
        return this.range - o.range;
    }
}
