package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2108 {
    static int [] arr;
    // N(1 ≤ N ≤ 500,000) && N은 홀수
    public static int calculation() {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (int) Math.round(sum/ arr.length);
    }
    public static int center() {
        Arrays.sort(arr);
        int center = arr.length/2;
        return arr[center];
    }
    public static int frequency() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // 최빈값이 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
        int maxValue = Collections.max(map.values()); // 가장 최빈값일 때의 value
        // treeSet에 최빈값을 가진 키를 저장
        TreeSet<Integer> keysWithMaxValue = new TreeSet<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == maxValue) keysWithMaxValue.add(entry.getKey());
        }
        if (keysWithMaxValue.size() < 2) {
            return keysWithMaxValue.first(); // 두 개 이상의 요소가 없으면 null 반환
        }
        else{
            // 첫 번째 요소를 가져오고 삭제
            keysWithMaxValue.pollFirst();
            // 두 번째 요소를 출력
            return keysWithMaxValue.first();
        }
    }
    public static long range() {
        long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
        }
        return max - min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(calculation());
        System.out.println(center());
        System.out.println(frequency());
        System.out.println(range());
    }
}
