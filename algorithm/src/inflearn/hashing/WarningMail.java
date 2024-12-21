package inflearn.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Data implements Comparable<Data> {
    String name;
    int time;
    int index;
    Data(String name, int time, int index) {
        this.name = name;
        this.time = time;
        this.index = index;
    }
    @Override
    public int compareTo(Data o) {
        return this.name.compareTo(o.name); // 알파벳 순으로 오름차순
    }
}
public class WarningMail {
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }
    public String[] solution(String[] reports, int timeLimit){
        String[] answer = {};
        ArrayList<Data> tmp = new ArrayList<>();
        HashMap<String, Integer> timeOfUse = new HashMap<>();
        int idx = 0;
        for(String x : reports) {
            String name = x.split(" ")[0];
            String time = x.split(" ")[1];
            String access = x.split(" ")[2];

            if(access.equals("in")) { // 데이터 저장
                tmp.add(new Data(name, getTime(time), idx++));
            }else if(access.equals("out")) { // in부터 현재 time을 뺀 값을 누적합에 저장
                // out했을 때 시간 - in했을 때 시간
                // in 했을 때의 time을 어떻게 arrayList에서 꺼내올 것인가
                int use = getTime(time) - tmp.get(idx).time; // -> 문제 발생
                tmp.remove(idx);
                timeOfUse.put(name, timeOfUse.get(name) + use); // 이용시간에 누적
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(String x : timeOfUse.keySet()) {
            if(timeOfUse.get(x) >= timeLimit) result.add(x);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    public static void main(String[] args){
        WarningMail T = new WarningMail();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
