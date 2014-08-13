package test.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

public class FileCheckSum {

	public FileCheckSum(){
		//do nothing in this constructor
	}
	public void calculateFileCheckSum(String filePath,String fileName){
		/*String separator=File.separator.concat(File.separator);
		filePath="D:".concat(separator).concat("hc105").concat(separator).concat("private").concat(separator);
		fileName="javaSpreadSheet.zip";*/
		try {
			if (!("".equals(filePath)||"".equals(fileName))) {
				CheckedInputStream cis = new CheckedInputStream(
						new FileInputStream(filePath.concat(fileName)),new CRC32());
				byte[] buffer = new byte[1024];//read buffer
				while (cis.read(buffer) >= 0) {
					//do nothing
				}
				long checksum = cis.getChecksum().getValue();
				System.out.println(checksum);
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not exist!!!!");
		} catch (IOException e) {
			System.out.println("error occur in reading file,check the file!!! ");
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}finally{
			System.out.println("finished!!!");
		}
	}
	
	public static void main(String args[]){
		FileCheckSum test=new FileCheckSum();
		test.calculateFileCheckSum("D:/hc105/user-lib/", "wstx-asl-3.2.7.jar");
		test.calculateFileCheckSum("D:/hc105/user-lib/", "wstx-asl-3.2.7 - ¸´ÖÆ.jar");
	}
}
