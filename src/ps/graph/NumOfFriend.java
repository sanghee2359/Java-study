package ps.graph;
// 그래프로 연결된 친구를 세는 프로그램
// 연결되는 친구의 친구까지 포함해서 전체 친구를 구한다
// 가장 인기가 많은(= 전체 친구가 많은) 사람의 친구 수를 출력

public class NumOfFriend {
    public static void main(String[] args) {
        NumOfFriend T = new NumOfFriend();
        String[] friends = {"NYNNN","YNYNN","NYNYN","NNYNY", "NNNYN"};
        System.out.println(T.solution(friends));
    }

    private int solution(String[] friends) {
        int answer = 0;
        int n = friends.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                if(friends[i].charAt(j) == 'Y') { // (i, j)
                    cnt++;
                }else {
                    for (int k = 0; k < n; k++) { // 공통되는 친구 찾기
                        if(friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y'){
                            cnt++;
                            break;
                        }
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
