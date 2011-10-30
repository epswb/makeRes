import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrinemaftToEclipse
{ 
     
    static private BufferedInputStream in = null; 
    static private BufferedOutputStream out = null; 
    static File target;
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
    	target = new File("C:\\Dokumente und Einstellungen\\Fabi\\git\\Crinemaft-resources\\Crinemaft");

	
    	
    	copyDir(new File("C:\\Crinemaft"), target);
    	
    	System.out.println("____________________________________________________________");
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    	System.out.println("Copied Crinemaft folder successfully.");
    }
     
    static void copyDir(File quelle, File ziel) throws FileNotFoundException, IOException { 
         
        File[] files = quelle.listFiles(); 
        ziel.mkdirs(); 
        for (File file : files) { 
            if (file.isDirectory()) 
            { 
                copyDir(file, new File(ziel.getAbsolutePath() + System.getProperty("file.separator") + file.getName())); 
            } 
            else 
            { 
                copyFile(file, new File(ziel.getAbsolutePath() + System.getProperty("file.separator") + file.getName()));
                System.out.println(file.getName());
            } 
        } 
    } 
     
    static void copyFile(File file, File ziel) throws FileNotFoundException, IOException { 
         
 	if (ziel.exists())
	{
		ziel.delete();
	}  
        in = new BufferedInputStream(new FileInputStream(file)); 
        out = new BufferedOutputStream(new FileOutputStream(ziel, true)); 
        int bytes = 0; 
        while ((bytes = in.read()) != -1) { 
            out.write(bytes); 
        } 
        in.close(); 
        out.close(); 
    } 
}  