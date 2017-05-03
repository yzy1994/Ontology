package com.shu.sil.eo.label.action;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Runtime获取文件创建时间示例
 * 
 * @author Dancen
 *
 */
public class FileCreatedDemo
{
	public static void main(String[] args)
	{
		try
		{
			String fileCreated = getFileCreated("D:\\xiyou.jpg");
			System.out.println(fileCreated);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getFileCreated(String path)
	{
		if(null == path)
		{
			return null;
		}
		
		return getFileCreated(new File(path));
	}
	
	public static String getFileCreated(final File file)
	{
		if(null == file)
		{
			return null;
		}
		
		String rs = null;
		final StringBuilder sb = new StringBuilder();
		Process p = null;
		
		try
		{
			p = Runtime.getRuntime().exec(String.format("cmd /C dir %s /tc", file.getAbsolutePath()));
		}
		catch(IOException e)
		{
			return rs;
		}
		
		final InputStream is = p.getInputStream();
		final InputStreamReader ir = new InputStreamReader(is);
		final BufferedReader br = new BufferedReader(ir);
		
		Runnable runnable = new Runnable()
		{

			public void run()
			{
				String data = null;
				
				try
				{
					while(null != (data = br.readLine()))
					{
						if(-1 != data.toLowerCase().indexOf(file.getName().toLowerCase()))
						{
							String[] temp = data.split(" +");
							
							if(2 <= temp.length)
							{
								String time = String.format("%s %s", temp[0], temp[1]);
								String temp2=time.replace("/", "-");
								sb.append(temp2);
							}
							
							break;
						}
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				finally
				{
					try
					{
						if(null != br)
						{
							br.close();
						}
						
						if(null != ir)
						{
							ir.close();
						}
						
						if(null != is)
						{
							is.close();
						}
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		try
		{
			thread.join();
		} 
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		if(0 != sb.length())
		{
			rs = sb.toString();
		}
		
		return rs;
	}
}

