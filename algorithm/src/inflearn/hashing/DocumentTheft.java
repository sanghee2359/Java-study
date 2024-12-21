package inflearn.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DocumentTheft {
    public String[] solution(String[] reports, String times) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> reportMap = new HashMap<>(); // 이름을 key, 시간을 value
        for (String x : reports) {
            String name = x.split(" ")[0];
            String time = x.split(" ")[1];
            reportMap.putIfAbsent(name, new ArrayList<>());
            reportMap.get(name).add(Integer.parseInt(time.split(":")[0]));
            reportMap.get(name).add(Integer.parseInt(time.split(":")[1]));
        }
        String from = times.split(" ")[0];
        String to = times.split(" ")[1];
        int fromTime = Integer.parseInt(from.split(":")[0]);
        int fromMinute = Integer.parseInt(from.split(":")[1]);
        int toTime = Integer.parseInt(to.split(":")[0]);
        int toMinute = Integer.parseInt(to.split(":")[1]);
        for (String x : reportMap.keySet()) {
            int curTime = reportMap.get(x).get(0);
            int curMinute = reportMap.get(x).get(1);
            // 반대의 경우로 if 문 작성
            if (curTime < fromTime || curTime > toTime
                    || curTime == fromTime && curMinute < fromMinute
                    || curTime == toTime && curMinute > toMinute) {
                continue;
            }
            answer.add(x);

        }
        return answer.toArray(new String[answer.size()]);
    }

    public static void main(String[] args){
        DocumentTheft T = new DocumentTheft();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
