package helper;

import java.io.File;

public class FileManagement {

	 
    public static void DeleteFile(String path, String filename) {

        File file = new File(path+filename);
        
        //Zuvor alle mit dem File assoziierten Streams schlieﬂen...
        
        if(file.exists()){
            file.delete();
        }
        
        System.out.println("File deleted");
    }
}
