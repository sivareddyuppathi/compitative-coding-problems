package com.coding.linkedlist;

public class SinglyLinkedList implements SinglyLinkedListInterface {

	private Node head;

	public SinglyLinkedList() {
		head = null;
	}

	private boolean isEmpty(Node headNode) {
		return (headNode == null);
	}

	private Node createNode(int data) {
		return new Node(data);
	}

	@Override
	public void insertFirst(int data) {
		Node newNode = createNode(data);
		newNode.next = head;
		head = newNode;
	}

	@Override
	public void insertAtEnd(int data) {
		Node newNode = createNode(data);

		if (isEmpty(head)) {
			head = newNode;
		} else {
			Node last = head;

			while (last.next != null) {
				last = last.next;
			}

			last.next = newNode;
		}
	}

	@Override
	public void insertAtGivenIndex(int index, int data) {

		if (index == 0) {
			insertFirst(data);
		}

		Node newNode = createNode(data);
		Node temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	@Override
	public void insertAfterGivenNode(Node prevNode, int data) {
		if (prevNode == null) {
			insertFirst(data);
			return;
		}
		Node newNode = createNode(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	@Override
	public Node search(int data) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	@Override
	public int noOfNodesItterative() {
		int length = 0;
		Node current = head;

		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	@Override
	public int noOfNodesRecursive() {

		return getCountRecursive(head);
	}

	private int getCountRecursive(Node head2) {
		if (head2 == null)
			return 0;

		return 1 + getCountRecursive(head2.next);
	}

	@Override
	public Node reverseLLUsing3Pointers(Node headCopy) {
		Node prev = null;
		Node next = null;
		Node curr = headCopy;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
//		head = prev;
		return prev;
	}

	@Override
	public Node reverseLLUsing1Pointer(Node headCopy) {
		Node prevHead = null;

		while (headCopy != null) {
			Node next = headCopy.next;
			headCopy.next = prevHead;
			prevHead = headCopy;
			headCopy = next;
		}
		return prevHead;
	}

	@Override
	public Node reverseLLRecursive(Node headCopy) { // code cinsise
		return headCopy != null ? headCopy.next != null ? reverseHelper(null, headCopy, headCopy.next) : headCopy
				: headCopy;

	}

	@Override
	public Node reverseLLRecursive2(Node head) { // Easy to understand

		return reverseHepler(head, null);
	}

	private Node reverseHelper(Node prev, Node curr, Node next) {
		curr.next = prev;
		return next != null ? reverseHelper(curr, next, next.next) : curr;
	}

	private Node reverseHepler(Node node, Node prev) {
		if (node == null)
			return prev;

		Node next = node.next;
		node.next = prev;
		return reverseHepler(next, node);
	}

	@Override
	public Node mergeTwoListsRecu(Node n1, Node n2) {

		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;

		if (n1.data < n2.data) {
			n1.next = mergeTwoListsRecu(n1.next, n2);
			return n1;
		} else {
			n2.next = mergeTwoListsRecu(n1, n2.next);
			return n2;
		}
	}

	@Override
	public Node mergeTwoLists(Node n1, Node n2) {
		if (isEmpty(n1))
			return n2;
		if (isEmpty(n2))
			return n1;

		Node dummy = createNode(0);
		Node curr = dummy;

		while (n1 != null && n2 != null) {
			if (n1.data <= n2.data) {
				curr.next = n1;
				n1 = n1.next;
			} else {
				curr.next = n2;
				n2 = n2.next;
			}
			curr = curr.next;
		}
		curr.next = n1 == null ? n2 : n1;
		return dummy.next;
	}

	@Override
	public Node revrseKGroupLL(Node head, int k) {
		Node curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			curr = revrseKGroupLL(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part,
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group:
				Node tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed list
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct part
			}
			head = curr;
		}
		return head;
	}

}
