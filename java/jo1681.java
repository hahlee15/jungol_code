import java.io.*;
import java.util.*;

public class Main {
	static int N, index = 0;
	static int[][] place;
	static int[] find_path;
	static boolean[] visit;
	
	public static void Hamilton(int from, int to) {
		int i = 1;
		
		while(to != 1) {
			visit[from] = true;
			System.out.println("place[" + from + "][" + to + "] : " + place[from][to]);
			find_path[index] += place[from][to];
			from = to;
			for(i = 0; i < N + 1; i++) {
				if(visit[i] == false) {
					if(i != from) {
						to = i;
						break;
					}
				}
				if(to != i) {
					to = 1;
				}
			}
			//System.out.print("from : " + from + " to : " + to + "\n");
		}
		find_path[index] += place[from][to];
		System.out.println("find_path[" + index + "] : " + find_path[index]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		place = new int[N + 1][N + 1];
		find_path = new int[N - 1];
		visit = new boolean[N + 1];
		visit[0] = true;

		int i = 1, j = 1;
		for (i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			j = 1;
			while (st.hasMoreTokens()) {
				place[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		for(j = 2; j < N + 1; j++) {
			Hamilton(1,j);
			for(i = 1; i < N + 1; i++) {
				visit[i] = false;
			}
			index++;
			if(index == N-1) {
				break;
			}
		}
		
		for(i = 0; i < N; i++) {
			Arrays.sort(find_path);
		}
		System.out.print(find_path[0]);
	}
}
