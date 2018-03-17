package com.StackOps;

import java.util.ArrayList;

public class StackUsingList {
	private ArrayList<Integer> stack = new ArrayList<Integer>();

	public void push(int num) {
		stack.add(num);
	}

	public int pop() {
		if (stack.size() > 0) {
			int poppedItem = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return poppedItem;
		} else {
			System.out.println("Underflow");
			return -1;
		}
	}

	public void printStack() {
		for (int i = 0; i < stack.size(); i++)
			System.out.println(stack.get(i));
	}

}
