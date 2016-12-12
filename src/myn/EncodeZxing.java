package myn;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;

import javax.imageio.ImageIO;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class EncodeZxing {   
    //��ά����ɫ ������ɫ 
	//(ע����ά����ɫɫ���ɨ��죬�����"BLACK'����Ϊ��ɫ��������ɫ�������޷�ɨ��  )
    private static final int BLACK = 0xFF000000;
    private static final int RED =  0xFFFF0000;
    private static final int BLUE = 0x49c1f9;
    private static final int WHITE = 0xFFFFFFFF;
    //��ά��ͼƬ��� ���߶�  
    private static final int width = 400;  
    private static final int height = 400;  
    //��ά���ʽ����  
    private static final EnumMap<EncodeHintType, Object> 
    			hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);  
    static{  
        /*��ά��ľ�����(�Ŵ���),4������ 
         L (7%)�� 
         M (15%)�� 
         Q (25%)�� 
         H (30%)(���H) 
         ������Ϣͬ���洢�ڶ�ά���У�������Խ�ߣ�������Ϣռ�õĿռ�Խ�࣬��ô�ܴ洢������ѶϢ��Խ�٣������ļ��� 
         ѡ��M��ɨ���ٶȿ졣 
         */  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        // ��ά��߽�հ״�С 1,2,3,4 (4ΪĬ��,���)  
        hints.put(EncodeHintType.MARGIN, 0);  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        hints.put(EncodeHintType.MAX_SIZE, 350);  
        hints.put(EncodeHintType.MIN_SIZE, 150);  
    }  
    /** 
     * ���ƶ�ά�� 
     * @param contents ��ά������   
     * @return image ��ά��ͼƬ 
     * */  
    public static BufferedImage encodeImg(String contents){  
        BufferedImage image = null;  
        try{  
            BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);  
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            int width = matrix.getWidth();  
            int height = matrix.getHeight();  
            for(int x = 0; x < width; x++){  
                for(int y =0;y < height; y++){  
                    image.setRGB(x, y, matrix.get(x, y) ? BLUE : WHITE);  
                }  
            }  
        }catch(Exception e){  
            System.out.println("���ɶ�ά��ʧ��"+e.getMessage());  
        }  
        return image;  
    }  
      
    /** 
     * ��ά��������ļ� 
     *  @param contents ��ά������ 
     * @param format ͼƬ��ʽ 
     * @param file ����ļ� 
     * */  
    public static void writeToFile(String contents,String format,File file){  
        BufferedImage image = encodeImg(contents);  
        try {  
            ImageIO.write(image, format, file);  
        } catch (IOException e) {  
            System.out.println("��ά��д���ļ�ʧ��"+e.getMessage());  
        }  
    }  
    /** 
     * ��ά����ʽ��� 
     *  @param contents ��ά������ 
     * @param format ͼƬ��ʽ 
     * @param stream ����� 
     * */  
    public static void writeToStream(String contents,String format,OutputStream stream){  
        BufferedImage image = encodeImg(contents);  
        try {  
            ImageIO.write(image, format, stream);  
        } catch (IOException e) {  
            System.out.println("��ά��д����ʧ��"+e.getMessage());  
        }  
    }  
}  
