package inflearn.sorting;
import java.util.*;
public class BinarySorting {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        ArrayList<Num> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(new Num(nums[i]));
        }
        System.out.println(numList);
        Collections.sort(numList);
        System.out.println(numList);
        int idx= 0;
        for(Num x : numList) {
            answer[idx++] = x.decimal;
        }

        return answer;
    }

    public static void main(String[] args){
        BinarySorting T = new BinarySorting();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
class Num implements Comparable<Num> {
    public int decimal;
    public String binary;
    public int numberOfOne;

    public Num(int decimal) {
        int count = 0;
        this.decimal = decimal;
        this.binary = Integer.toBinaryString(decimal);
        while(binary.contains("1")) count++;
        this.numberOfOne = count;
    }

    @Override
    public int compareTo(Num o) {
        if (this.numberOfOne == o.numberOfOne) {
            return this.decimal - o.decimal;
        }
        return this.numberOfOne - o.numberOfOne;
    }
}
