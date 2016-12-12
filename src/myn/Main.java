package myn;
import java.io.*;
import java.util.*;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String index;
		System.out.println("欢迎使用二维码生成软件\n");
		System.out.println("操作说明:");
		System.out.println("1: 生成一个二维码");
		System.out.println("2: 解析一个二维码");
		System.out.println("q: 退出程序");
		o: while(true){
			index=in.nextLine();
			switch(index){
			case "1":{
				System.out.println("欢迎使用二维码生成软件\n请输入要生成的句子：");
				String words = in.nextLine();
		        System.out.println("------------------------------------------------"); 
				System.out.println("开始生成二维码");
				System.out.println("请输入保存路径：");
				String url = in.nextLine();
		        EncodeZxing.writeToFile(words, "png", new File(url)); 
		        System.out.println("二位码已生成为 : "+url);
		        break;
		  
			}
				
			case "2":{
				System.out.println("欢迎使用二维码识别软件\n请输入要识别的二维码路径：");
				String url = in.nextLine();
				System.out.println("------------------------------------------------"); 
		        System.out.println("二维码内容解析结果为 : "); 
		        String text = DecodeZxing.decodeImg(new File(url));
				System.out.println(text);	
		        System.out.println("------------------------------------------------"); 
		        System.out.println("请继续选择操作：");
				break;
			}
			
			case "q":{
				break o;
			}
			default:
				System.out.println("输入错误");
			}
		}
		System.out.println("谢谢使用,再见");
	}
}
