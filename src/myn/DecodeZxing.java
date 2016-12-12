package myn;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import javax.imageio.ImageIO;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public final class DecodeZxing {  
    //��ά���ʽ����  
    private static final EnumMap<DecodeHintType, Object> hints =
    		new EnumMap<DecodeHintType, Object>(DecodeHintType.class);  
    static{  
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
        hints.put(DecodeHintType.PURE_BARCODE, true);
    }  
    /** 
     * ������ά�룬ʹ��google��zxing 
     * @param imgPath ��ά��·�� 
     * @return content ��ά������ 
     * */  
    public static String decodeImg(File imgFile){  
        String content = null;  
        if(!imgFile.isFile()){  
            System.out.println("������ļ�");  
            return null;  
        }  
            BufferedImage image;
			try {
				image = ImageIO.read(imgFile);
				LuminanceSource source = new BufferedImageLuminanceSource(image); 
				Binarizer binarizer = new HybridBinarizer(source);  
				BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
				MultiFormatReader reader = new MultiFormatReader();  
	            Result result = reader.decode(binaryBitmap, hints);  
	            content = result.getText(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotFoundException e) {
				 System.out.println("�޷�ʶ����ļ� : ��ȷ�ϸ�ͼƬΪ��׼�������Ķ�ά��");  
				//e.printStackTrace();
			}         
        return content;  
    }  
}  
