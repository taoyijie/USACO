import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: taoyiji1
LANG: JAVA
TASK: friday
 */
public class friday {
	static int[] norm = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int[] pick;
	
	static boolean isLeap(int year){
		if(year%400 == 0)
			return true;
		if(year%4 == 0 && year%100 != 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int n = sc.nextInt();
		sc.close();
		
		int init = 0;
		int s_year = 1900;
		int[] count = new int[7];
		for(int i=0;i<n;i++){
			int year = s_year+i;
			boolean l = isLeap(year);
			if(l)
				pick = leap;
			else
				pick = norm;
			for(int j=0;j<12;j++){
				count[init%7]++;
				init += pick[j];
			}
			init %= 7;
		}
		for(int i=0;i<6;i++){
			out.write(count[i]+" ");
		}
		out.write(count[6]+"\n");
		
		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}
