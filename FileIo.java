import java.io.*;
import java.util.zip.*;
class FileIo
{
	public static void read(String inputFilePath, String outputFilePath)
	{
		ZipInputStream zis = null;
		ZipEntry ze = null;
		try
		{
			File outputDir = new File(outputFilePath);
			zis = new ZipInputStream(new FileInputStream(inputFilePath));
			
			while((ze = zis.getNextEntry()) != null) // get next folder or file
			{
				String currentFile = ze.getName(); // get file or folder name
				if(ze.isDirectory() == true) // check isdirectory or not
				{
					new File(outputFilePath,currentFile).mkdirs(); // create all directories
				}
				else
				{
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(outputFilePath+currentFile));
					byte [] barr = new byte[2048];
					while(zis.read(barr) != -1)
					{
						bs.write(barr);// write all data of file
					}
				}
				zis.closeEntry();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String [] args)
	{
		try
		{
			String inputFilePath = "E:\\study\\mca3_gautam_rcc.zip";
			String outputFilePath = "E:\\";
			read( inputFilePath, outputFilePath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}