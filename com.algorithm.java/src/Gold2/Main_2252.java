package Gold2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 총 학생수
		int M = sc.nextInt(); // 비교 횟수

		int[] graph = new int[N + 1];

		// 가중치가 없는 그래프 - 인접 리스트 사용
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		// 단방향 연결 설정
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			// 간선의 수 증가
			graph[b]++;
		}
		topologicalSort(list, graph);
	}

	// 위상정렬
	static void topologicalSort(List<ArrayList<Integer>> list, int[] graph) {
		// 1. 선행 점정을 가지지 않는 정점을 큐에 넣기
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < graph.length; i++) {
			if (graph[i] == 0) {
				q.add(i);
			}
		}

		// 정점의 수만큼 반복
		for (int i = 1; i < graph.length; i++) {
			int v = q.poll(); //큐에서 정점 추출
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
