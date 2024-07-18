package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class boj_11650 {
    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Coordinate> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            arr.add(new Coordinate(x, y));
        }
        Collections.sort(arr, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if(o1.x == o2.x) return o1.y - o2.y;
                else return o1.x - o2.x;
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.println(arr.get(i).x +" "+ arr.get(i).y);
        }
    }

}
