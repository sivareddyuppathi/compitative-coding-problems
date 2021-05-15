package com.coding.compitative.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	public static void main(String[] args) {
		PushCostly pushCostly = new PushCostly();
		pushCostly.push(1);
		pushCostly.push(2);
		pushCostly.push(3);

		System.out.println("current size: " + pushCostly.size());
		System.out.println(pushCostly.top());
		pushCostly.pop();
		System.out.println(pushCostly.top());
		pushCostly.pop();
		System.out.println(pushCostly.top());

		System.out.println("current size: " + pushCostly.size());
	}
}

class PushCostly {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();

	// To maintain current number of elements
	private int currNoOfElements;

	PushCostly() {
		currNoOfElements = 0;
	}

	public void push(int x) {
		currNoOfElements++;

		// Push x first in empty q2
		q2.add(x);

		// Push all the remaining elements in q1 to q2.
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}

		// swap the names of two queues
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}

	// Remove and return
	public int pop() {
		if (q1.isEmpty())
			return -1;

		currNoOfElements--;
		return q1.remove();
	}

	// Return but not remove
	public int top() {
		if (q1.isEmpty())
			return -1;

		return q1.peek();
	}

	public int size() {
		return currNoOfElements;
	}
}

class PopCostly {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();

	// To maintain current number of elements
	private int currNoOfElements;

	PopCostly() {
		currNoOfElements = 0;
	}

	public void push(int x) {
		q1.add(x);
		currNoOfElements++;
	}

	public int pop() {
		if (q1.isEmpty())
			return -1;

		// Leave one element in q1 and push others in q2.
		while (q1.size() != 1) {
			q2.add(q1.remove());
		}
		// Pop the only left element from q1
		int out = q1.remove();
		currNoOfElements--;

		// swap the names of two queues
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;

		return out;
	}

	public int top() {
		if (q1.isEmpty())
			return -1;

		while (q1.size() != 1) {
			q2.add(q1.peek());
			q1.remove();
		}

		// last pushed element
		int temp = q1.peek();

		// to empty the auxiliary queue after last operation
		q1.remove();

		// push last element to q2
		q2.add(temp);

		// swap the two queues names
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;

		return temp;
	}

	public int size() {
		return currNoOfElements;
	}
}
