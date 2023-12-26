package ps.bfs;

import java.util.LinkedList;
import java.util.Queue;

// 이진 트리 bfs 레벨 탐색
// bfs는 queue를 활용하여 순회한다.
class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}
public class LevelorderTraversal {
    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while(!Q.isEmpty()) {
            int len=Q.size(); // queue의 원소 개수 확인
            System.out.printf(level+" : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data+" "); // queue에 들어간 원소의 data 출력
                if(cur.lt  != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            level++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LevelorderTraversal tree = new LevelorderTraversal();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
