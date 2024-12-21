package inflearn.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// import java.util.HashMap; -> 데이터의 순서가 보장되지 않는다
// class 활용
class Info implements Comparable<Info> {
    public String name;
    public int time;
    Info(String name, int time) { // 생성자
        this.name = name;
        this.time = time;
    }
    @Override
    public int compareTo(Info object) {
        return this.time - object.time; // 시간 순 오름차순
    }
}
public class DocumentTheft {
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }
    public String[] solution(String[] reports, String times) {
        ArrayList<Info> tmp = new ArrayList<>();
        for (String x : reports) {
            String name = x.split(" ")[0];
            String time = x.split(" ")[1];
            tmp.add(new Info(name, getTime(time)));
        }
        Collections.sort(tmp);
        String from = times.split(" ")[0];
        String to = times.split(" ")[1];

        // 분 단위로 데이터 값을 변경하면, 간단하게 분류 가능
        int fromTime = getTime(from);
        int toTime = getTime(to);
        ArrayList<String> result = new ArrayList<>();
        for (Info obj : tmp) {
            if(obj.time >= fromTime && obj.time <= toTime){
                result.add(obj.name);
            }
            if(obj.time > toTime) break; // tmp가 시간순 정렬이 되어있기 때문
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args){
        DocumentTheft T = new DocumentTheft();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
