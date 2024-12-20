package inflearn.hashing;

import java.util.HashMap;

public class PresidentialElection {
    private String solution(String[] votes, int k) {
        String answer = "";
        HashMap<String, Integer> hashing = new HashMap<>();

        for (String x : votes) {
            String[] tmp = x.split(" ");

            hashing.put(tmp[1],
                    hashing.getOrDefault(tmp[1], 0)+1);
        }

        return answer;
    }
    public static void main(String[] args) {
        PresidentialElection T = new PresidentialElection();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
//        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
//        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
//        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }

}
