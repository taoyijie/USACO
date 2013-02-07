import java.io.*;
import java.util.*;

/*
 ID: taoyiji1
 LANG: JAVA
 TASK: namenum
 */
public class namenum {
	
	static String[] table = {"2","2","2","3","3","3","4","4","4","5","5","5","6","6","6","7","0","7","7","8","8","8","9","9","9","0"}; 
	
	public static void main(String[] args) throws IOException {

		Scanner dict = new Scanner(new FileReader("dict.txt"));
		
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		String num = sc.nextLine();
		sc.close();
		
		boolean f = false;
		while(dict.hasNextLine()){
			String line = dict.nextLine();
			String nnew = "";
			for(int i=0;i<line.length();i++)
				nnew += table[line.charAt(i)-'A'];
			if(num.equals(nnew)){
				out.println(line);
				f = true;
			}
		}
		
		if(!f)
			out.println("NONE");
		
		dict.close();
		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}
