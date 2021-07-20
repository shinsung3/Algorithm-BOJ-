import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int inMyBag = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		int height = 0;
		int map[][] = new int[N][M];
		int max= 0;
		int min= Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max,map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		for(int i = max ; i >= min ; i--) {
			int time = 0;
			int bag = inMyBag;
			
			for(int y = 0 ; y < N ; y ++) {
				for(int  x= 0 ; x < M ; x++) {
					if(map[y][x] == i) 
                        continue;
					else {
						int diff = Math.abs(i - map[y][x]);
						if(i > map[y][x]) {
							bag -= diff;
							time +=diff;
						} else {
							bag += diff;
							time += (2*diff);
						}
						
					}
				}
			}
			if(bag< 0) {
				continue;
			}
			if(time < answer) {
				answer = time;
				height = i;
			}
		}
		System.out.println(answer + " " + height );
	}
}