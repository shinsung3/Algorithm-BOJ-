package Gold2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �� �л���
		int M = sc.nextInt(); // �� Ƚ��

		int[] graph = new int[N + 1];

		// ����ġ�� ���� �׷��� - ���� ����Ʈ ���
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		// �ܹ��� ���� ����
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			// ������ �� ����
			graph[b]++;
		}
		topologicalSort(list, graph);
	}

	// ��������
	static void topologicalSort(List<ArrayList<Integer>> list, int[] graph) {
		// 1. ���� ������ ������ �ʴ� ������ ť�� �ֱ�
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < graph.length; i++) {
			if (graph[i] == 0) {
				q.add(i);
			}
		}

		// ������ ����ŭ �ݺ�
		for (int i = 1; i < graph.length; i++) {
			int v = q.poll(); //ť���� ���� ����
			System.out.print(v+" ");
			
			for(int a : list.get(v)) {
				graph[a]--;
				
				if(graph[a]==0) {
					q.add(a);
				}
			}
		}
	}

}
