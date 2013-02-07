import java.io.*;
import java.util.*;

/*
ID: taoyiji1
LANG: JAVA
TASK: beads
 */
public class beads {
	static int n;
	static int[] beads;
	
	static int findCF(int in){
		for(int i=in;i<in+n;i++){
			if(beads[i%n]!=0)
				return beads[i%n];
		}
		return 0;
	}
	
	static int findCB(int in){
		for(int i=in-1;i>=in-1-n;i--){
			if(beads[(i+n)%n]!=0)
				return beads[(i+n)%n];
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		n = sc.nextInt();
		beads = new int[n];
		char[] line = sc.next().toCharArray();
		sc.close();
		
		for(int i=0;i<n;i++){
			if(line[i]=='r')
				beads[i] = 1;
			else if(line[i]=='b')
				beads[i] = 2;
			else
				beads[i] = 0;
		}
		int max = -1;
		for(int i=1;i<n;i++){
			int c1 = findCF(i);
			if(c1==0)
				max = n;
			int cnt1 = 1;
			for(int j=i+1;j<i+n;j++){
				if(beads[j%n]==(3-c1))
					break;
				else
					cnt1++;
			}
			int c2 = findCB(i);
			if(c2==0)
				max = n;
			int cnt2 = 1;
			for(int j=i-2;j>i-n+1;j--){
				if(beads[(j+n)%n]==(3-c2))
					break;
				else
					cnt2++;
			}
			int cnt = cnt1+cnt2;
			cnt = cnt>n ? n:cnt;
			max = cnt>max ? cnt:max;
		}
		
		out.write(max+"\n");
		
		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}
