/*
ID: taoyiji1
LANG: JAVA
TASK: gift1
 */
import java.io.*;
import java.util.*;

class gift1 {
	static String[] name;
	
	public static int getIndex(String na){
		int index = 0;
		while(!name[index].equals(na))
			index++;
		return index;
	}
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int np = sc.nextInt();
		sc.nextLine();
		name = new String[np];
		for(int i=0;i<np;i++){
			name[i] = sc.nextLine();
		}
		int[] init = new int[np];
		int[] remain = new int[np];
		int[] receive = new int[np];
		
		while(sc.hasNext()){
			String na = sc.nextLine();
			int in = getIndex(na);
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			init[in] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			for(int i=0;i<num;i++){
				receive[getIndex(sc.nextLine())] += init[in] / num;
			}
			if(num==0)
				remain[in] = init[in];
			else
				remain[in] = init[in] % num;
		}
		sc.close();
		
		for(int i=0;i<np;i++){
			out.write(name[i]+" ");
			out.write((remain[i]+receive[i]-init[i])+"\n");
		}
				
		out.flush();
		out.close();
		System.exit(0); // don't omit this!
	}
}