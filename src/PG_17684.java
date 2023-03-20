import java.util.*;

public class PG_17684 {
    public List<Integer> solution(String msg) {

        List<Integer> answer = new ArrayList<>();
        int mapIdx = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)('A'+i) +"", mapIdx++);
        }
        int size = msg.length();
        for(int i =0; i< size; i++){
            int a = 1;
            while(i+a<=size && map.containsKey(msg.substring(i,i+a))) {
//                System.out.println("a:" + a);
                a++;
            }
            if(i+a>size){
                answer.add(map.get(msg.substring(i)));
                System.out.println(map.get(msg.substring(i)));
                break;
            }
            answer.add(map.get(msg.substring(i,i+a-1)));
            map.put(msg.substring(i,i+a),mapIdx++);
            System.out.println(i);
            if(a>1){
                System.out.println("i+(a-1) : "+i+(a-2));
                i= i+a-2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PG_17684 T = new PG_17684();
        System.out.println(T.solution("KAKAO"));
    }
}
