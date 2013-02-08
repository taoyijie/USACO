import java.io.*;
import java.util.*;

/*
 ID: taoyiji1
 LANG: JAVA
 TASK: palsquare
 */
public class palsquare {
	
	static char[] set = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
	
	static boolean isPalin(String str){		
		int p1 = 0;
		int p2 = str.length()-1;
		while(p1<p2){
			if(str.charAt(p1)!=str.charAt(p2))
				return false;
			p1++;
			p2--;
		}
		return true;
	}
	
	static String convert(int num, int base){
		int msb = 1;
		while(msb<=num)
			msb *= base;
		msb = msb/base;
		ArrayList<Integer> exp = new ArrayList<Integer>();
		
		while(msb!=0){
			exp.add(num/msb);
			num %= msb;
			msb /= base;
		}
		String res = "";
		for(int i=0;i<exp.size();i++){
			res += set[exp.get(i)];
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {

//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int base = sc.nextInt();
		sc.close();
		
		for(int i=0;i<300;i++){
			int prod = (i+1)*(i+1);
			String exp = convert(prod, base);
			if(isPalin(exp))
				out.println(convert(i+1, base)+" "+exp);
		}				
		
		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}
