import java.io.*;
import java.util.*;

/*
 ID: taoyiji1
 LANG: JAVA
 TASK: milk2
 */
public class milk2 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int n = sc.nextInt();
		int[] start = new int[n];
		int[] end = new int[n];
		int max = -1;
		for(int i=0;i<n;i++){
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
			max = end[i]>max ? end[i]:max;
		}
		sc.close();
		
		int[] bitmap = new int[max+1];
		for(int i=0;i<n;i++){
			Arrays.fill(bitmap, start[i]+1, end[i]+1, 1);
		}
		int index = -1;
		for(int i=1;;i++){
			if(bitmap[i]==1){
				index = i;
				break;
			}
		}
		int milk = 0;
		int cnt = 0;
		int idle = 0;
		int cnt2 = 0;
		for(int i=index;i<=max;i++){
			if(bitmap[i] == 1){
				cnt++;
				milk = cnt>milk ? cnt:milk;
				cnt2 = 0;
			}
			else{
				cnt = 0;
				cnt2++;
				idle = cnt2>idle ? cnt2:idle;
			}
		}
		out.write(milk+" "+idle+"\n");	

		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}
