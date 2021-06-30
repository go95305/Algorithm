package algorithm;

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

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));
        String num;
        while ((num = br.readLine()) != null) {
            Node node = new Node(Integer.parseInt(num));
            dfs(root, node);
        }

        searchLast(root);

    }

    private static void searchLast(Node root) {

        if (root.left != null)
            searchLast(root.left);
        if (root.right != null)
            searchLast(root.right);
        System.out.println(root.value);
    }

    private static void dfs(Node root, Node nextNum) {
        if (root.value > nextNum.value) {
            if (root.left != null) {
                dfs(root.left, nextNum);
            } else {
                root.left = nextNum;
            }
        } else {
            if (root.right != null) {
                dfs(root.right, nextNum);
            } else {
                root.right = nextNum;
            }
        }
    }

}
