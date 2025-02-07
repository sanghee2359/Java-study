package inflearn.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
public class WarningMail {
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }
    public String[] solution(String[] reports, int timeLimit){
        HashMap<String, Integer> tmp = new HashMap<>();
        HashMap<String, Integer> timeOfUse = new HashMap<>();
        for(String x : reports) {
            String name = x.split(" ")[0];
            String time = x.split(" ")[1];
            String access = x.split(" ")[2];

            if(access.equals("in")) tmp.put(name, getTime(time));
            else if(access.equals("out")) { // in부터 현재 time을 뺀 값을 누적합에 저장
                int use = getTime(time) - tmp.get(name);
                timeOfUse.put(name, timeOfUse.getOrDefault(name, 0) + use); // 이용시간에 누적
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(String x : timeOfUse.keySet()) {
            if(timeOfUse.get(x) > timeLimit) result.add(x);
        }
        result.sort(String::compareTo);
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
