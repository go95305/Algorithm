package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B5639_이진검색트리 {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static List<Node> list;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));
        String str = "";
        list = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            Node node = new Node(num);
            makeTree(root, node);
        }

        print(root);
    }

    private static void print(Node root) {

        if (root.left != null) {
            print(root.left);
        }
        if (root.right!=null){
            print(root.right);
        }
        System.out.println(root.value);
    }

    private static void makeTree(Node root, Node node) {
        if (root.value > node.value) {
            if (root.left != null) {
                makeTree(root.left, node);
            } else {
                root.left = node;
            }
        } else {
            if (root.right != null) {
                makeTree(root.right, node);
            } else {
                root.right = node;
            }
        }
    }
}
