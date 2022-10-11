package greedyAlgorithmStyudy;

import java.util.Scanner;

public class coin {

	public static void main(String[] args) {
		 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = in.nextInt();
		}
	
		int count = 0;
 
		for(int i = N - 1; i >= 0; i--) {
			// 현재 동전의 가치가 K보다 작거나 같아야지 구성가능하다.
			if(coin[i] <= K) {
				// 현재 가치의 동전으로 구성할 수 있는 개수를 더해준다.
				count += (K / coin[i]); // 현재 동전의 가치로 구성할 수 있는 최대의 개수 구하기
				K = K % coin[i]; // 위에서 구한 가치를 제외한 나머지 값 저장
			}
		}
		System.out.println(count);	
	}
}

