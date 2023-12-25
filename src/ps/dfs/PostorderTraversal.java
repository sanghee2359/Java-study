package ps.dfs;
// 이진 트리 dfs 후위 순회
public class PostorderTraversal {
    Node root;
    public void DFS(Node root){
        if(root == null) return;
        else {
            DFS(root.lt);
            DFS(root.rt);
            System.out.println(root.data);
        }
    }
    public static void main(String[] args) {

        PostorderTraversal O = new PostorderTraversal();
        O.root = new Node(1);
        O.root.lt = new Node(2);
        O.root.rt = new Node(3);
        O.root.lt.lt = new Node(4);
        O.root.lt.rt = new Node(5);
        O.root.rt.lt = new Node(6);
        O.root.rt.rt = new Node(7);
        O.DFS(O.root);
    }
}

