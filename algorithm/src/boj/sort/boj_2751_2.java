package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*==========================
 * sorting int type array
 *==========================*/
public class boj_2751_2 {
    private static int[] INTSorted;
    public static void sort(int[] a) {

        INTSorted = new int[a.length];
        sort(a, 0, a.length - 1);
        INTSorted = null;
    }

    // Bottom-Up
    private static void sort(int[] a, int left, int right) {

        for (int size = 1; size <= right; size += size) {

            for (int l = 0; l <= right - size; l += (2 * size)) {
                int high = Math.min(l + (2 * size) - 1, right);
                merge(a, l, l + size - 1, high);
            }
        }

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {

            if (a[l] <= a[r]) {
                INTSorted[idx++] = a[l++];
            }

            else {
                INTSorted[idx++] = a[r++];
            }
        }

        if (l > mid) {
            while (r <= right) {
                INTSorted[idx++] = a[r++];
            }
        } else {
            while (l <= mid) {
                INTSorted[idx++] = a[l++];
            }
        }

        System.arraycopy(INTSorted, left, a, left, right - left + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sort(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(INTSorted[i]);
        }
    }
}
