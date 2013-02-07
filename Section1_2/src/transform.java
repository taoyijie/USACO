import java.io.*;
import java.util.*;

/*
 ID: taoyiji1
 LANG: JAVA
 TASK: transform
 */
public class transform {
	static boolean eq(char[][] s1, char[][] s2){
		int n = s1.length;
		boolean e = true;
		for(int i=0;i<n;i++){
			e = e && Arrays.equals(s1[i], s2[i]);
		}
		return e;
	}
	
	static char[][] trans(char[][] s, int num){
		int n = s.length;
		char[][] res = new char[n][n];
		for(int i=0;i<n;i++){
			char[] tomove = s[i];
			switch(num){
			case 1:
				for(int j=0;j<n;j++){
					res[j][n-i-1] = tomove[j];
				}
				break;
			case 2:
				for(int j=0;j<n;j++){
					res[n-1-i][n-1-j] = tomove[j];
				}
				break;
			case 3:
				for(int j=0;j<n;j++){
					res[n-1-j][i] = tomove[j];
				}
				break;
			case 4:
				for(int j=0;j<n;j++){
					res[i][j] = s[i][n-1-j];
				}
			}
			
		}
		return res;
	} 
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int n = sc.nextInt();
		sc.nextLine();
		char[][] before = new char[n][n];
		char[][] after = new char[n][n];
		for(int i=0;i<n;i++)
			before[i] = sc.nextLine().toCharArray();
		for(int i=0;i<n;i++)
			after[i] = sc.nextLine().toCharArray();
		sc.close();
		
		if(eq(after,trans(before,1)))
			out.println(1);
		else if(eq(after,trans(before,2)))
			out.println(2);
		else if(eq(after,trans(before,3)))
			out.println(3);
		else if(eq(after,trans(before,4)))
			out.println(4);
		else{
			char[][] tmp = trans(before, 4);
			if(eq(after,trans(tmp,1)))
				out.println(5);
			else if(eq(after,trans(tmp,2)))
				out.println(5);
			else if(eq(after,trans(tmp,3)))
				out.println(5);
			else if(eq(after,before))
				out.println(6);
			else
				out.println(7);
		}
		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}
