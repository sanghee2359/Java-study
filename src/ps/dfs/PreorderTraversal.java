package ps.dfs;

import java.util.Scanner;

// 이진 트리 dfs 전위 순회
class Node{
    int data;
    Node lt, rt;
    public Node(int val) {
        this.data = val;
        rt=lt= null;
    }
}
public class PreorderTraversal {
    Node root;
    public void DFS(Node root){
        System.out.println(root.data);
        DFS(root.lt);
        DFS(root.rt);
    }
    public static void main(String[] args) {

        PreorderTraversal O = new PreorderTraversal();
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
