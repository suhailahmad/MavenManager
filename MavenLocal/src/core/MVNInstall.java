package core;

import java.io.File;

/**
 *
 * @author Anirudh Varma, Ashish Dandriyal
 */
public class MVNInstall {
    
    public boolean installFile(File file,String[] param){
		boolean status=false;		
		String path=file.getAbsolutePath();
		String command=generateCommand(path,param[0],param[1],param[2]);
		Runtime runtime=Runtime.getRuntime();
		try{
		Process pr=runtime.exec(command);
		pr.waitFor();
		return true;
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
			return status;
		}		
	}
	
	private static String generateCommand(String filePath, String artifact, String group, String version){
		String space=" ";
		String dfile="-Dfile="+filePath+space;
		String dartifact="-DartifactId="+artifact+space;
		String dgroup="-DgroupId="+group+space;
		String dversion="-Dversion="+version+space;		
		String command="mvn install:install-file"+space+dfile+dgroup+dartifact+dversion+"-Dpackaging=jar";
		return command;
	}
        
        public String getDependency(String[] param){
            
            String str = "<dependency>\n" +
                    "<groupId>"+param[1]+"</groupId>\n" +
                    "<artifactId>"+param[0]+"</artifactId>\n" +
                    "<version>"+param[2]+"</version>\n" +
                    "</dependency>";  
            return str;
        }
}
