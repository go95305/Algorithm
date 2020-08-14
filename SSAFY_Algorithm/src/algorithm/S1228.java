package algorithm;

import java.util.Scanner;


class Node {
	int num;
	int data;
	Node link;

	public Node(int data, Node link) {

		this.data = data;
		this.link = link;
	}

	public Node(int data, int idx) {
		super();
		this.num = idx;
		this.data = data;
	}

}

class Sll {
	Node head;

	public void addFirstNode(int data, int idx) {
		Node newNode = new Node(data, head);
		head = newNode;
		head.num = idx+1;
	}

	public Node getLastNode() {
		Node currNode = head;
		if (currNode != null) {
			while (currNode.link != null) {
				currNode = currNode.link;
			}
		}
		return currNode;
	}

	public void addmiddleNode(int idx, int data) {
		Node currNode = head;
		for(int i=1;i<idx;i++) {
			currNode = currNode.link;
		}
		Node tmp = new Node(data, idx+1);
		tmp.link = currNode.link;
		currNode.link = tmp;
	}

	public void addLastNode(int data, int idx) {
		Node newNode = new Node(data, idx);
		Node lastNode = getLastNode();

		// 마지막 노드가 없는 경우(공백리스트)
		// 새 노드를 head 노드에 연결한다.
		if (lastNode == null) {
			head = newNode;
		} else {
			// 마지막 노드가 있는 경우
			// 마지막 노드에 새 노드를 연결한다.
			lastNode.link = newNode;
		}
	}


	public void printList() {
		int i=0;
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			if(i==10) {
				break;
			}
			System.out.print(currNode.data+" ");
			i++;
		}
	
	}

	
}

public class S1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			Sll list = new Sll();
			for (int i = 1; i <= N; i++) {
					list.addLastNode(sc.nextInt(), i);
			
			}
			int S = sc.nextInt();
			for (int i = 0; i < S; i++) {
				String str = sc.next();
				int stidx = sc.nextInt();
				int quantity = sc.nextInt();
				for (int j = 0; j < quantity; j++) {
					if (stidx == 0) {
						list.addFirstNode(sc.nextInt(),stidx);
					} else {
						list.addmiddleNode(stidx, sc.nextInt());
					}
					stidx++;
				}
			}
			System.out.printf("#%d ", test_case);
			list.printList();
			System.out.println();
		}
	}
}
