package xieCheng;

import java.util.Scanner;

/*
 * 给定一个单向链表和一个整数m，将链表中小于等于m的节点移到大于m的节点之前，要求两部分中的节点各自保持原有的先后顺序
 */

public class Question1 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*
	 * 请完成下面这个函数，实现题目要求的功能 开始写代码
	 ******************************/
	static ListNode partition(ListNode head, int m) {
		ListNode cur = head;
		ListNode less = null;
		ListNode greater = null;
		ListNode lessStart = null;
		ListNode greaterStart = null;
		while (cur != null) {
			if (cur.val <= m) {
				if (less == null) {
					less = cur;
					lessStart = cur;
					cur = cur.next;
				} else {
					less.next = cur;
					cur = cur.next;
					less = less.next;
				}
			} else {
				if (greater == null) {
					greater = cur;
					greaterStart = cur;
					cur = cur.next;
				} else {
					greater.next = cur;
					cur = cur.next;
					greater = greater.next;
				}
			}
		}
		if (less == null) {
			return greaterStart;
		} else {
			less.next = greaterStart;
			return lessStart;
		}
	}

	/****************************** 结束写代码 ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ListNode head = null;
		ListNode node = null;
		int m = in.nextInt();
		while (in.hasNextInt()) {
			int v = in.nextInt();
			if (head == null) {
				node = new ListNode(v);
				head = node;
			} else {
				node.next = new ListNode(v);
				node = node.next;
			}
		}
		head = partition(head, m);
		if (head != null) {
			System.out.print(head.val);
			head = head.next;
			while (head != null) {
				System.out.print(",");
				System.out.print(head.val);
				head = head.next;
			}
		}
		System.out.println();
	}

}
