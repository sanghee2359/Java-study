package inflearn.hashing;

import java.util.*;

public class PresidentialElection {
    private String solution(String[] votes, int k) {
        String answer = "";
        HashMap<String, Set<String>> voteHash = new HashMap<>(); // 유권자(key), 투표한 학생들의 set (value)
        HashMap<String, Integer> candidate = new HashMap<>(); // 후보자들이 받은 투표 수
        HashMap<String, Integer> present = new HashMap<>(); // 선물

        for (String x : votes) {
            String voter = x.split(" ")[0];
            String voted = x.split(" ")[1];
            voteHash.putIfAbsent(voter, new HashSet<>());
            voteHash.get(voter).add(voted);
            candidate.put(voted, candidate.getOrDefault(voted, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(String voter : voteHash.keySet()) {
            int count = 0;
            for(String voted : voteHash.get(voter)) {
                if(candidate.get(voted) >= k) count++; // 후보의 조건 충족 -> 선물 받는 횟수 count++
            }
            present.put(voter, count); // 받은 선물의 개수를 count
            max = Math.max(max, count);
        }
        ArrayList<String> tmp = new ArrayList<>();
        for(String name : present.keySet()) {
            if(present.get(name) == max) tmp.add(name);
        }
        tmp.sort(String::compareTo); // 오름차순
        answer = tmp.get(0);
        return answer;
    }
    public static void main(String[] args) {
        PresidentialElection T = new PresidentialElection();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }

}
