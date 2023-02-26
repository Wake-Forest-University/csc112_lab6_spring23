/**
 * CSC 112 Lab6 (Convert Image) Spring 2023
 * This program reads a JPEG file and writes an equivalent ASCII image file.
 * The JPEG and ACSII file names are read from the user.
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Feb. 25, 2023
 */

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConvertImage {
    public static void main(String[] args) {
        BufferedImage image = null;   // JPEG image (object)
        int[][] gray = null;          // grayscale image
        char[][] ascii = null;        // ASCII image
        int maxRow = 100;             // maximum ASCII image width
        int maxCol = 100;             // maximum ASCII image height
        String imageFileName = null;  // JPEG image file name
        Scanner keyboard = new Scanner(System.in);  // keyboard
        String textFileName = null;   // ASCII image file name

        // prompt and read file names from user

        // read the JPEG image
        try {
            image = ImageIO.read(new File(imageFileName));
        }
        catch(IOException e) {
            System.out.println("Error opening " + imageFileName);
            System.exit(0);
        }

        System.out.println("JPEG size: " + image.getWidth() + "x" + image.getHeight());

        // create grayscale image array
        gray = createGrayscale(image);

        // method: transpose gray (rows and columns)
        
        // method: scale gray (if needed)
        
        // method: create ASCII image (ascii) from gray
        
        // method: write ascii to text file

    } // end of main
    
    
    /**
     * Creates 2d int array of grayscale pixel values from a BufferedImage
     *
     * @param image the BufferedImage
     * @return 2d int array of grayscale values
     */
    static int[][] createGrayscale(BufferedImage image) {
        int nRow = image.getWidth();         // number of rows
        int nCol = image.getHeight();        // number of columns
        int[][] gray = new int[nRow][nCol];  // grayscale image
        
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                Color c = new Color(image.getRGB(i, j));  // pixel RGB values
                gray[i][j] = (int) Math.round(0.299*c.getRed() + 0.587*c.getGreen() +
                                              0.114*c.getBlue());
            }
        }
        return gray;
    }


    /**
     * Display a BufferedImage to the screen
     * (just for debugging, DO NOT CALL IN FINAL VERSION)
     *
     * @param image the BufferedImage
     */
    static void displayImage(BufferedImage image) {
        ImageIcon icon=new ImageIcon(image);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(image.getWidth(), image.getHeight());
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


