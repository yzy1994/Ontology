package com.shu.sil.eo.label.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@Controller("openFileAction")
public class OpenFileAction extends ActionSupport{

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	private static final long serialVersionUID = 1L;
	private File upload;// 上传文件
	private String uploadContentType;// 上传文件类型的属性
	private String uploadFileName;// 上传文件名
	private String savePath;// 上传路径（struts.xml 中配置的参数）
	private String message = "";
	private String showFilePath = "";
	private  StringBuilder txtStr;
	private ArrayList<String> txtStrList=new ArrayList<String>();
	public StringBuilder getTxtStr() {
		return txtStr;
	}

	public void setTxtStr(StringBuilder txtStr) {
		this.txtStr = txtStr;
	}

	public ArrayList<String> getTxtStrList() {
		return txtStrList;
	}

	public void setTxtStrList(ArrayList<String> txtStrList) {
		this.txtStrList = txtStrList;
	}

	public String upload() {
		try {
			this.message="";
			// System.out.println(savePath+"savePath");
			// File targetFile = new File(getServerPath() + savePath);
			// if (!targetFile.exists()) {
			// targetFile.mkdirs();
			// }
			// targetFile = new File(targetFile, getUploadFileName());
			String productTypeInfoImgPath = ServletActionContext
					.getServletContext().getRealPath("ProductTypeInfoImg")
					+ "/" + this.uploadFileName;
			String productTypeInfoImgUrl = "ProductTypeInfoImg" + "/"
					+ this.uploadFileName;
		
			File toFile = new File(productTypeInfoImgPath);
			HttpServletResponse response = ServletActionContext.getResponse();
			System.out.println(" == 文件寫入 == ");
			try {
				InputStream in = null;
				OutputStream out = null;
				try {
					in = new BufferedInputStream(new FileInputStream(this.upload),
							BUFFER_SIZE);
//					OutputStream toClient = new BufferedOutputStream(
//							response.getOutputStream());	
					byte[] buffer = new byte[100];
					while (in.read(buffer) > 0) {
						String strRead = new String(buffer);
						System.out.println("开始开始"+strRead);
//						message+=strRead;
//						toClient.write(buffer);
//						toClient.flush();
						txtStrList.add(strRead);
						
					}
				} finally {
		
//					if (null != out) {
//						out.close();
//					}
					if (null != in) {
						in.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("写入成功！");
		}catch (Exception e) {
			e.printStackTrace();
		}
//		this.message=this.gsonTemp.toJson(message);
			return SUCCESS;
	}

	private static final int BUFFER_SIZE = 16*1024;

//	private static String writeFile(File src, File dst) {
//		
//	}

	public String getServerPath() {
		// String serverPath =
		// getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		// serverPath = serverPath.substring(1, serverPath.indexOf("WEB-INF"));
		String serverPath = ServletActionContext.getServletContext()
				.getRealPath("webapp");
		String lll = serverPath.substring(0, serverPath.length() - 7);
		System.out.println(lll);
		return lll;

	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getShowFilePath() {
		return showFilePath;
	}

	public void setShowFilePath(String showFilePath) {
		this.showFilePath = showFilePath;
	}

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
    
	public String download() {
		String path = ServletActionContext.getServletContext().getRealPath(
				"ProductTypeInfoImg")
				+ "/"+filePath;
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			String ext = filename.substring(filename.lastIndexOf(".") + 1)
					.toUpperCase();

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			String filenameString = new String(filename.getBytes("gbk"),
					"iso-8859-1");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ filenameString);
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String fileList() {
		String directory = ServletActionContext.getServletContext()
				.getRealPath("ProductTypeInfoImg");
		List<DocumentVO> documentVOList = new ArrayList<DocumentVO>();
		File file = new File(directory);
		File[] subFile = file.listFiles();
		for (int i = 0; i < subFile.length; i++) {
			DocumentVO temp = new DocumentVO();
			temp.setFileName(subFile[i].getName());
			String updateTime=String.format("yyyy-MM-dd HH:mm",subFile[i].lastModified());
			temp.setUpdateTime(updateTime);
			String fileCreatedTime = FileCreatedDemo.getFileCreated(subFile[i].getAbsolutePath());
			temp.setCreateTime(fileCreatedTime);
			temp.setFilePath("ProductTypeInfoImg/"+subFile[i].getName());
			documentVOList.add(temp);
		}
		String resultStr = gsonTemp.toJson(documentVOList);
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter()
					.print("{path:"+resultStr+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
		// return SUCCESS;
	}
    
}
