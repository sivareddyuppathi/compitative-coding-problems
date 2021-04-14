package com.coding.linkedlist;

public class SinglyLinkedList implements SinglyLinkedListInterface {

	private Node head;

	public SinglyLinkedList() {
		head = null;
	}

	private boolean isEmpty() {
		return (head == null);
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

		if (isEmpty()) {
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
		Node newNode = new Node(data);
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

}
