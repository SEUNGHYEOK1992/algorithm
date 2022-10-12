package greedyAlgorithmStyudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 첫번째 11 
		// (1, 4) (5, 7) (8, 11) (12, 14)
		// 1 ~ 4시, 5 ~ 7시, 8 ~ 11시, 12 ~ 14시
		/*
		 * int start = 0; int end = 0;
		 */
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt(); // 입력받은 값	
		
		/*
		  time[][0] 은 시작시점을 의미 
		  time[][1] 은 종료시점을 의미 
		*/
		int[][] time = new int[N][2];
	
		for(int i = 0; i < N; i++) {
			time[i][0] = in.nextInt();	// 시작시간 
			time[i][1] = in.nextInt();	// 종료시간 
			System.out.println(time[i][0]);
		}
		
		
		// 끝나는 시간을 기준으로 time[i][1] 오름차순으로 정렬하기 위해 comparator로 재정렬을 한다. 
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.  
				if(o1[1] == o2[1]) {
					
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}	
		System.out.println(count);
	}

}
