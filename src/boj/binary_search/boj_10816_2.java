package boj.binary_search;
// 이분 탐색의 경우
// 구간의 중간 위치의 값과 key(찾고자 하는 값)를 비교하여
// 구간을 절반으로 줄여나가며 풀이하는 것이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 고려해야 할 점은 '중복 원소의 개수'를 알아내는 것
public class boj_10816_2 {
 private static int lowerBound(int[] arr, int key) {
  int lo = 0, hi = arr.length;

  while(lo < hi) {
   int mid = (lo + hi) / 2;
   if (key <= arr[mid]) hi = mid;
   else lo = mid + 1;
  }
  return lo;
 }
 private static int upperBound(int[] arr, int key) {
  int lo = 0, hi = arr.length;

  while(lo < hi) {
   int mid = (lo + hi) / 2;
   if (key < arr[mid]) hi = mid;
   else lo = mid + 1;
  }
  return lo;
 }
  public static void main(String[] args) throws IOException {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   int N = Integer.parseInt(br.readLine());
   int [] arr = new int[N];
   StringTokenizer st = new StringTokenizer(br.readLine(), " ");
   StringBuilder sb = new StringBuilder();

   for (int i = 0; i < N; i++) {
    // key
    int tmp = Integer.parseInt(st.nextToken());
    arr[i] = tmp;
   }
   Arrays.sort(arr);
   int M = Integer.parseInt(br.readLine());
   st = new StringTokenizer(br.readLine(), " ");

   for (int i = 0; i < M; i++) {
     int key = Integer.parseInt(st.nextToken());
     sb.append(upperBound(arr,key)-lowerBound(arr, key)).append(" ");
   }
   System.out.println(sb);
  }
}
