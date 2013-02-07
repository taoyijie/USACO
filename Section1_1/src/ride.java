/*
ID: taoyiji1
LANG: JAVA
TASK: ride
 */
import java.io.*;
import java.util.*;

class ride {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		char[] group = sc.nextLine().toCharArray();
		char[] comet = sc.nextLine().toCharArray();
		sc.close();
		
		
		int g = 1;
		for(int i=0;i<group.length;i++){
			g *= group[i]-'A'+1;
		}
		g = g%47;
		
		int c = 1;
		for(int i=0;i<comet.length;i++){
			c *= comet[i]-'A'+1;
		}
		c = c%47;
		
		if(g==c)
			out.write("GO\n");
		else
			out.write("STAY\n");
		
		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}