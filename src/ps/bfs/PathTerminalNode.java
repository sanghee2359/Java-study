package ps.bfs;

import java.util.LinkedList;
import java.util.Queue;

// 말단 노드까지의 가장 짧은 경로의 길이를 구하는 프로그램(BFS)
public class PathTerminalNode {
    Node root;
    public int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0; // level 탐색
        while(!Q.isEmpty()) {
            int len = Q.size(); // queue의 size만큼 반복할것
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if (cur.lt == null && cur.rt == null) return level;
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            level++;
        }
        return level;
    }
    public static void main(String[] args) {
        PathTerminalNode O = new PathTerminalNode();
        O.root = new Node(1);
        O.root.lt = new Node(2);
        O.root.rt = new Node(3);
        O.root.lt.lt = new Node(4);
        O.root.lt.rt = new Node(5);
        System.out.println(O.BFS(O.root));
    }
}
