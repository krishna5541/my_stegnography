import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;

public class StagMessage {

	public StagMessage() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		Scanner cmd = new Scanner(System.in);
		//System.out.print("File location of stag image: ");
		//String path = cmd.nextLine();
		File f = new File("C:\\Users\\kprab\\Desktop\\steg.bmp");
		BufferedImage image = ImageIO.read(f);
		String message = "00000000";
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<image.getWidth();i++)
		{
			for(int j=0;j < image.getHeight() && (!message.substring(message.length()-7).equals(";;;;;;;"));j++) {
				int bit = Math.abs(image.getRGB(i,j) % 2);
				//System.out.print(bit + " ");
				st.push(bit);
				if(st.size() == 8) {
					int buffer = 0;
					while(!st.empty())
					{
						buffer = buffer * 2 + st.pop();  
					}
					message = message + (char)buffer;
					System.out.println((char)buffer);
				}
				
			}
			
		}
		//System.out.println(message.substring(8,message.length()-7));
		cmd.close();
		

	}

}
