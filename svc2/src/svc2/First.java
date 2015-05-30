package svc2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.lang.String;
import java.io.*;

public class First {
	 public void removeLineFromFile(String file, String lineToRemove) {
		 
		    try {
		 
		      File inFile = new File(file);
		      
		      if (!inFile.isFile()) {
		        System.out.println("Parameter is not an existing file");
		        return;
		      }
		       
		      //Construct the new file that will later be renamed to the original filename. 
		      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
		      
		      BufferedReader br = new BufferedReader(new FileReader(file));
		      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
		      
		      String line = null;
		 
		      //Read from the original file and write to the new 
		      //unless content matches data to be removed.
		      while ((line = br.readLine()) != null) {
		        
		        if (!line.trim().equals(lineToRemove)) {
		 
		          pw.println(line);
		          pw.flush();
		        }
		      }
		      pw.close();
		      br.close();
		      
		      //Delete the original file
		      if (!inFile.delete()) {
		        System.out.println("Could not delete file");
		        return;
		      } 
		      
		      //Rename the new file to the filename the original file had.
		      if (!tempFile.renameTo(inFile))
		        System.out.println("Could not rename file");
		      
		    }
		    catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		    catch (IOException ex) {
		      ex.printStackTrace();
		    }
		  }
		 
	public static void main(String[] args){
		
		
			 Scanner sc = new Scanner(System.in);
			 int ch;
			 while(true)
			 {
			 System.out.println("Enter choice ...1)append 2)delete 3)exit");
			 ch=sc.nextInt();
			
			 switch(ch)
			 {
			 case 1 :
				 try{
					 BufferedWriter bw =null;
					 
					 	
					 	
					 	FileReader fr=null;
					 	//Specify the file name and path here
					 	LineNumberReader lnr=null;
					 	
					 	
					 	System.out.println("Enter line ...");
					 	char content[] =new char[100]; 
					 	String a = sc.next();
					 	
					 	//strcpy(content,a);
					 	
					 	content = a.toCharArray();
					 	
				    	File file =new File("/home/ash/git/isharepository/isha/src/isha/a.txt");
				    	fr = new FileReader("/home/ash/git/isharepository/isha/src/isha/a.txt");
				    	if(!file.exists()){
					    	   file.createNewFile();
					    }
			                
				        lnr = new LineNumberReader(fr);		    	/* This logic is to create the file if the
				    	 * file is not already present
				    	 */
				        int cnt=0;
				        while((a=lnr.readLine())!=null)
				         {
				            cnt=lnr.getLineNumber();
				            System.out.println("count "+ cnt);
				           
					  }
				        try{
				        if(cnt<20)
				    	{
				    	for(int i=0;i<10;i++)
				    	{
				    	FileWriter fw = new FileWriter(file,true);
				    	bw = new BufferedWriter(fw);
				    	
				    	if(content[i]=='\0')
				    	{
				    		break;
				    	}
				    	bw.write(content[i]);
				    
				    	//Closing BufferedWriter Stream
				    
				    	bw.close();
				    	}
				    	FileWriter fw = new FileWriter(file,true);
				    	bw = new BufferedWriter(fw);
				    	
				    	bw.write("\n");
				    	
				    	//Closing BufferedWriter Stream
				    
				    	bw.close();
				    	
				    	cnt++;
				    	System.out.println("Data successfully appended at the end of file");
				    	}
			            else 
			            {
			            	System.out.println("Max limit is 20");
			            }
				        }catch(Exception e)
				        {
				        	e.printStackTrace();
				        }

				      }catch(IOException ioe){
				         System.out.println("Exception occurred:");
				    	 ioe.printStackTrace();
				       }
				
				 break;
			 case 2:
				 First util=new First();
				 System.out.println("Enter string that u want to remove from file");
		    	   //System.out.println("Enter line number");
		    	   String b=sc.next();
		    	   //int i=sc.nextInt();
				 util.removeLineFromFile("/home/ash/git/isharepository/isha/src/isha/a.txt", b);
				 break;
				 
			 case 3:
				 System.out.println("Operation Finished");
				 System.exit(0);
				
			}  
			 
	}
				 
	}	
			 
}