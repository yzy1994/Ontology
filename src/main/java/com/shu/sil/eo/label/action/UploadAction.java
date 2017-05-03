package com.shu.sil.eo.label.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@Controller("uploadAction")
public class UploadAction extends ActionSupport {

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	private static final long serialVersionUID = 1L;
	private File upload;// 上传文件
	private String uploadContentType;// 上传文件类型的属性
	private String uploadFileName;// 上传文件名
	private String savePath;// 上传路径（struts.xml 中配置的参数）
	private String message = "";
	private String showFilePath = "";

	public String upload() {
		try {
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
			// File toFile = new File(getServerPath() +
			// savePath+getUploadFileName());
			// boolean b = FileUtil.copyPaste(getUpload(), targetFile);
			writeFile(this.upload, toFile);
			if (true) {
				// ServletActionContext.getResponse().setContentType(
				// "text/html; charset=utf-8");
				// ServletActionContext
				// .getResponse()
				// .getWriter()
				// .print("{success:true,path:'" + productTypeInfoImgUrl
				// + "'}");
				showFilePath = productTypeInfoImgUrl;
				message = "文件上传成功，文件名为：" + uploadFileName + "。";
			} else {
				message = "文件上传失败，文件名为：" + uploadFileName + "。";
			}
		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		}

		return SUCCESS;
	}

	private static final int BUFFER_SIZE = 16 * 1024;

	private static void writeFile(File src, File dst) {

		System.out.println(" == 文件寫入 == ");
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				int bufferLength = 0;
			    while ( (bufferLength = in.read(buffer)) > 0 ) {
			    out.write(buffer, 0, bufferLength);
			    }
//			    我是个菜鸟 如果说原因我只能猜测 可能是错误的写法每次写入固定1024的长度
//
//			    而换用有bufferLength的方法write 则规定了长度 避免了不足1024的用NUL代替了吧！
//
//			    因为这个问题困扰了我3天的时间 又未在网上找到相应的解决办法
//			    http://www.shangxueba.com/jingyan/1867403.html
//				while (in.read(buffer) > 0) {
//					out.write(buffer);
//				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("写入成功！");
	}

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
				+ "/" + filePath;
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
			System.out.println(subFile[i].lastModified());
			Date dupdate = new Date(subFile[i].lastModified());
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String updateTime = ft.format(dupdate);
			System.out.println(updateTime);
			temp.setUpdateTime(updateTime);
			String fileCreatedTime = FileCreatedDemo.getFileCreated(subFile[i]
					.getAbsolutePath());
			temp.setCreateTime(fileCreatedTime);
			temp.setFilePath("ProductTypeInfoImg/" + subFile[i].getName());
			documentVOList.add(temp);
		}
		String resultStr = gsonTemp.toJson(documentVOList);
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter()
					.print("{path:" + resultStr + "}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
		// return SUCCESS;
	}

}
