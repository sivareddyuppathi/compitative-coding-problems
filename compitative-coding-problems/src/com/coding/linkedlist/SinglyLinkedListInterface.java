package com.coding.linkedlist;

public interface SinglyLinkedListInterface {
	
// **************INSERTION**************
	void insertFirst(int data);

	void insertAtEnd(int data);

	void insertAtGivenIndex(int index, int data);

	void insertAfterGivenNode(Node prevNode, int data);

// **************SEARCH**************
	Node search(int data);
	
	int noOfNodesItterative(); //length of LL
	int noOfNodesRecursive();
	
}
