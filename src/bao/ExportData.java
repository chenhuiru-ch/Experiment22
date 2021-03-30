package bao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExportData {	
	/**
		此类主要是把控制台输入的内容保存到data.txt中
	*/
	public class TextOutputTest {
		private static final String fileName = "H:\\软件工程:\\data.txt";
	
		public void main(String[] args) throws IOException {
		System.out.println("请输入一串字符,系统将自动保存到H:\\软件工程:\\data.txt文件中。");
		System.out.println("字符串为：");
	
		//进行file的初始化
		File outputFile = new File(fileName);
		if(!outputFile.exists()){
		outputFile.createNewFile();
		}
	
		//读取控制台的字符串
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)), true);
		String str = in.nextLine();
			
		if (str != null && str.length() != 0) {
			System.out.println(str);
		}else{
			System.out.println("提示！没有在控制台输入任何字符!");
		}
	
		System.out.println("请观察你的H盘中软件工程文件夹下的data.txt文件,程序执行完毕。");
		out.close();
		in.close();
		}

	}

}
