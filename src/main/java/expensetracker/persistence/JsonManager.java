package expensetracker.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class JsonManager {
		
	private final Path PATH;
	private final String emptyJson = "[]";
	
	public JsonManager(String path) {
		PATH = Paths.get(path);
	}
	
	public String readOrCreate() {
        try {
            if (!Files.exists(PATH)) {               
                return write(emptyJson);
            }
            return Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
            return emptyJson;
        }
    }

    public String write(String newJson) {
        try {
            Files.write(PATH, newJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newJson;
    }
    
    boolean clear() {
    	if(write(emptyJson).equals(emptyJson)) {
    		return true;
    	}
    	return false;
    }
    
    

}
