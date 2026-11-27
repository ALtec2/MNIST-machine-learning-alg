import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MNISTReader {

    // Reads MNIST image files
    public static byte[][][] readImages(String filePath){
        byte[][][] images = null;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))){
            int magicNumber = dis.readInt(); 
            int numberOfImages = dis.readInt(); 
            int numRows = dis.readInt();
            int numCols = dis.readInt();

            images = new byte[numberOfImages][numRows][numCols];
            for(int i = 0; i < numberOfImages; i++){
                for(int r = 0; r < numRows;r++){
                    for(int c = 0; c< numCols; c++){
                        images[i][r][c]= dis.readByte();
                    }
                }
            }
        }
        catch(IOException e){
            ;
        }
    return images;
    } 
    
}
