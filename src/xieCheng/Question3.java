package xieCheng;

import java.util.Scanner;

/*
 * 在m个节点的分布式计算系统中，有一批任务需要执行，
 * 每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，
 * 每个节点只能执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
 * 
 * 样例输入：
 * 3 5
   1 5 3 4 2
 * 样例输出：
 * 6 
 */

public class Question3 {

	/*
	 * 请完成下面这个函数，实现题目要求的功能 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 开始写代码
	 ******************************/
	static int schedule(int m, int[] array) {
		return m;

	}

	/****************************** 结束写代码 ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int size = in.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = in.nextInt();
		}
		int res = schedule(m, array);
		System.out.println(String.valueOf(res));
	}

}
