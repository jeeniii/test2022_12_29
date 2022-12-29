package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static Logger log=LoggerFactory.getLogger(FileHandler.class);
	
	public int deleteFile(String imageFileName,String savePath) {
		boolean isDel=true;
		log.info("deletefile method access");
		log.info("imagefilename"+imageFileName);
		
		File fileDir=new File(savePath);
		File removeFile=new File(fileDir+File.separator+imageFileName);
		File removeThumbFile=new File(fileDir+File.separator+"th_"+imageFileName);
		
		if(removeFile.exists() || removeThumbFile.exists()) {
			isDel=removeFile.delete();
			log.info("filehandler remove :"+(isDel?"ok":"fail"));
			if(isDel) {
				isDel=removeThumbFile.delete();
				log.info("filehandler remove thumbnail :"+(isDel?"ok":"fail"));
			}
		}
		log.info("filehandler remove ok");
		return isDel?1:0;
	}
}
