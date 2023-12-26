package ps.dfs;
// 말단 노드까지의 가장 짧은 경로의 길이를 구하는 프로그램(DFS)
// 단, 최단거리 경로 찾기를 DFS로 풀이할 땐 완전 이진 트리이어야 한다.
public class PathTerminalNode {
    Node root;
    public int DFS(int level, Node root) {
        if(root.lt == null && root.rt == null) return level;
        else {
            // 최소 경로를 찾으므로
            // 왼쪽에서 말단 노드의 최소 경로, 오른쪽에서 말단 노드 최소 경로를 비교
            return Math.min( DFS(level+1, root.lt), DFS(level+1, root.rt));
        }
    }
    public static void main(String[] args) {
        PathTerminalNode O = new PathTerminalNode();
        O.root = new Node(1);
        O.root.lt = new Node(2);
        O.root.rt = new Node(3);
        O.root.lt.lt = new Node(4);
        O.root.lt.rt = new Node(5);
        System.out.println(O.DFS(0, O.root));
    }
}
