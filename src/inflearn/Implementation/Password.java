package inflearn.Implementation;
// 1. 상하좌우 & 대각선에 위치한 키패드로 이동하는 시간 1초
// 2. 그렇지 않은 경우 2초 소요
// 3. 현재 키패드의 숫자에 패스워드를 입력했을 때 걸리는 시간을 출력
public class Password {
    public int[][] distanceArray(){
        int[][] dist = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = 2;
            }
        }
        return dist;
    }
    public int[][] composeKeypad(int[] keypad) {
        int[][] answer = new int[3][3];
        int d1 = 0, d2 = 0;
        for(int i = 0; i < keypad.length; i++ ){
            answer[d2][d1] = keypad[i];
            d1 = (d1+1) % 3;
            if(d1 == 0) d2++;
        }
        return answer;
    }
    public int findFirst(String password) {
        String first = password.substring(0, 1);
        return Integer.parseInt(first);
    }
    
    public int solution(int[] keypad, String password){
        int answer = 0;
        // 1. 키패드 구성에 맞게 2차원 배열로 옮겨야할까?
        int[][] pad = composeKeypad(keypad);
        // 2. dx, dy를 대각선까지 포함시켜 반복문으로 방문하며 값을 확인해야할까?
        // 3. 키의 위치마다 근접한 키의 조건이 다른데 어떻게 처리할까
        int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
        int[][] dist = distanceArray();
        for (int i = 0; i < 3; i++) { // i = 1
            for (int j = 0; j < 3; j++) { // j = 0
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k]; // nx = 1 - 0
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                        int near = pad[nx][ny] - 1;
                        int cur = pad[i][j] - 1;
                        dist[cur][near] = 1;
                    }
                }
            }
        }
        // 첫번째 위치 값
        int cur = findFirst(password) - 1;
        for(int i = 1; i < password.length(); i++){
            int next = Integer.parseInt(String.valueOf(password.charAt(i))) - 1;
            answer += dist[cur][next];
            cur = next;
        }
        return answer;
    }

    public static void main(String[] args){
        Password T = new Password();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
