package myn;
import java.io.*;
import java.util.*;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String index;
		System.out.println("��ӭʹ�ö�ά���������\n");
		System.out.println("����˵��:");
		System.out.println("1: ����һ����ά��");
		System.out.println("2: ����һ����ά��");
		System.out.println("q: �˳�����");
		o: while(true){
			index=in.nextLine();
			switch(index){
			case "1":{
				System.out.println("��ӭʹ�ö�ά���������\n������Ҫ���ɵľ��ӣ�");
				String words = in.nextLine();
		        System.out.println("------------------------------------------------"); 
				System.out.println("��ʼ���ɶ�ά��");
				System.out.println("�����뱣��·����");
				String url = in.nextLine();
		        EncodeZxing.writeToFile(words, "png", new File(url)); 
		        System.out.println("��λ��������Ϊ : "+url);
		        break;
		  
			}
				
			case "2":{
				System.out.println("��ӭʹ�ö�ά��ʶ�����\n������Ҫʶ��Ķ�ά��·����");
				String url = in.nextLine();
				System.out.println("------------------------------------------------"); 
		        System.out.println("��ά�����ݽ������Ϊ : "); 
		        String text = DecodeZxing.decodeImg(new File(url));
				System.out.println(text);	
		        System.out.println("------------------------------------------------"); 
		        System.out.println("�����ѡ�������");
				break;
			}
			
			case "q":{
				break o;
			}
			default:
				System.out.println("�������");
			}
		}
		System.out.println("ллʹ��,�ټ�");
	}
}
