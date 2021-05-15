package com.coding.linkedlist;

public interface SinglyLinkedListInterface {

// **************INSERTION**************
	void insertFirst(int data);

	void insertAtEnd(int data);

	void insertAtGivenIndex(int index, int data);

	void insertAfterGivenNode(Node prevNode, int data);

// **************SEARCH**************
	Node search(int data);

	int noOfNodesItterative(); // length of LL

	int noOfNodesRecursive();

// **************REVERSE**************
	Node reverseLLUsing3Pinters(Node headCopy); // reverse and return head node

	Node reverseLLUsing1Pointer(Node headCopy);

	Node reverseLLRecursive(Node headCopy);

	Node reverseLLRecursive2(Node head);

	// **************MERGE**************
	Node mergeTwoListsRecu(Node n1, Node n2);

	Node mergeTwoLists(Node n1, Node n2);

//	Node arrangeVowelsAndConsonents(Node head); //it needs char node...

}
