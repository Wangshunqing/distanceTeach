//package LibraryManager.web;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.math.BigDecimal;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
//import org.apache.commons.fileupload.ProgressListener;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import LibraryManager.domain.User;
//import LibraryManager.util.IOUtils;
//
//public class upimageServlet extends HttpServlet {
//
//	/**
//	 * The doGet method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to get.
//	 * 
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		try {
//			User user = (User) request.getSession().getAttribute("user");
//			String name = user.getName();
//			// 1.创建工厂
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//			factory.setSizeThreshold(100 * 1024);
//			factory.setRepository(new File(this.getServletContext()
//					.getRealPath("WEB-INF/temp")));
//			// 2.生产文件上传核心类
//			ServletFileUpload fileUpload = new ServletFileUpload(factory);
//
//			// --检查是否是正确的文件上传表单
//			if (!ServletFileUpload.isMultipartContent(request)) {
//				throw new RuntimeException("请用正确的表单进行上传!");
//			}
//			// --设置文件上传的大小限制
//			// fileUpload.setFileSizeMax(1024*1024*100);//单个文件不大于10M
//			// fileUpload.setSizeMax(1024*1024*100);//总大小不大于100M
//
//			// --设置编码集,解决上传文件名的乱码问题
//			fileUpload.setHeaderEncoding("utf-8");
//
//			// --设置文件上传监听
//			fileUpload.setProgressListener(new ProgressListener() {
//				Long beginTime = System.currentTimeMillis();
//
//				public void update(long bytesRead, long contentLength, int items) {
//					BigDecimal br = new BigDecimal(bytesRead).divide(
//							new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
//					BigDecimal cl = new BigDecimal(contentLength).divide(
//							new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
//					System.out.print("当前读取的是第" + items + "个上传项,总大小" + cl
//							+ "KB,已经读取" + br + "KB");
//					// 剩余字节数
//					BigDecimal ll = cl.subtract(br);
//					System.out.print("剩余" + ll + "KB");
//					// 上传百分比
//					BigDecimal per = br.multiply(new BigDecimal(100)).divide(
//							cl, 2, BigDecimal.ROUND_HALF_UP);
//					System.out.print("已经完成" + per + "%");
//					// 上传用时
//					Long nowTime = System.currentTimeMillis();
//					Long useTime = (nowTime - beginTime) / 1000;
//					System.out.print("已经用时" + useTime + "秒");
//					// 上传速度
//					BigDecimal speed = new BigDecimal(0);
//					if (useTime != 0) {
//						speed = br.divide(new BigDecimal(useTime), 2,
//								BigDecimal.ROUND_HALF_UP);
//					}
//					System.out.print("上传速度为" + speed + "KB/S");
//
//					// 大致剩余时间
//					BigDecimal ltime = new BigDecimal(0);
//					if (!speed.equals(new BigDecimal(0))) {
//						ltime = ll.divide(speed, 0, BigDecimal.ROUND_HALF_UP);
//					}
//					System.out.print("大致剩余时间为" + ltime + "秒");
//					System.out.println();
//				}
//			});
//
//			// 3.利用文件上传核心类解析request
//			@SuppressWarnings("unchecked")
//			List<FileItem> list = fileUpload.parseRequest(request);
//			// 4.遍历所有的FileItem
//			
//				for (FileItem item : list) {
//					if (item.isFormField()) {
//						// 当前是一个普通的字段项
//						// System.out.println(name_teacher+":"+value);
//					} else {
//						// 当前是一个文件上传项
//						String filename = "1.jpg";
//						String path = this.getServletContext().getRealPath(
//								"upload/image/"+name);	
//						System.out.println(path);
//						new File(path).mkdirs();
//
//						InputStream in = item.getInputStream();
//						OutputStream out = new FileOutputStream(new File(path,
//								filename));
//					
//						path = path + "/" + filename;
//						System.out.println(path);
//						IOUtils.In2Out(in, out);
//						IOUtils.close(in, out);
//						// --删除临时文件
//						item.delete();		
//						
//						response.sendRedirect(request.getContextPath()
//								+ "/info.jsp");
//					}
//				}
//			 
//		} catch (FileSizeLimitExceededException e) {
//			response.getWriter().write("单个文件不超过10M,总大小不超过100M!");
//			return;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//		
//	}
//
//	/**
//	 * The doPost method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to post.
//	 * 
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		this.doGet(request, response);
//	}
//
//}
