import java.io.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;
public class MyImage{
  public static void main(String args[])throws Exception{
	Scanner cmd = new Scanner(System.in);
    BufferedImage image = null;
    File f = null;
    //System.out.println("Give the file path");
    String path = "C:\\Users\\kprab\\Desktop\\chakai.jpg";
    //read image file
    
    try{
      f = new File(path);
      image = ImageIO.read(f);
      System.out.println("Reading Completed...");
    }catch(IOException e){
      System.out.println("Error: "+e);
    }
    int height = image.getHeight();
    int width = image.getWidth();
    cmd.close();
    int message = 0,count = 8;
    boolean flag = false;
    
    FileReader f1 = new FileReader("C:\\Users\\kprab\\Desktop\\mess.txt");
    
    for(int i=0;i<width;i++) {
    	for(int j=0;j<height;j++)
    	{
    		int pix = image.getRGB(i, j);
    		if(count==8) {
    		
    			count = 0;
    			message = f1.read();
    			System.out.println((char)message);
    			if(message == -1)
    				{flag = true;break;}
    		}
    		int bit = message % 2;
    		message /= 2;
    		count++;
   			if(bit == 0 && pix%2 != 0)
   				pix = (pix& 0b11111111111111111111111111111110);
   			else if(bit ==1 && pix%2 == 0)
   				pix = pix | 0b00000000000000000000000000000001;
   			image.setRGB(i, j, pix);
    			
    		
    	}
    	if(flag)
    		break;
    }
    f1.close();
  
    //write image
    try{
      f = new File("C:\\Users\\kprab\\Desktop\\steg.bmp");
      ImageIO.write(image, "bmp", f);
      System.out.println("Writing Completed");
    }catch(Exception e){
      System.out.println("Error: "+e);
    }
    
  }//main() ends here
}//class ends here

