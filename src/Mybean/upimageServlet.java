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
//			// 1.��������
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//			factory.setSizeThreshold(100 * 1024);
//			factory.setRepository(new File(this.getServletContext()
//					.getRealPath("WEB-INF/temp")));
//			// 2.�����ļ��ϴ�������
//			ServletFileUpload fileUpload = new ServletFileUpload(factory);
//
//			// --����Ƿ�����ȷ���ļ��ϴ���
//			if (!ServletFileUpload.isMultipartContent(request)) {
//				throw new RuntimeException("������ȷ�ı������ϴ�!");
//			}
//			// --�����ļ��ϴ��Ĵ�С����
//			// fileUpload.setFileSizeMax(1024*1024*100);//�����ļ�������10M
//			// fileUpload.setSizeMax(1024*1024*100);//�ܴ�С������100M
//
//			// --���ñ��뼯,����ϴ��ļ�������������
//			fileUpload.setHeaderEncoding("utf-8");
//
//			// --�����ļ��ϴ�����
//			fileUpload.setProgressListener(new ProgressListener() {
//				Long beginTime = System.currentTimeMillis();
//
//				public void update(long bytesRead, long contentLength, int items) {
//					BigDecimal br = new BigDecimal(bytesRead).divide(
//							new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
//					BigDecimal cl = new BigDecimal(contentLength).divide(
//							new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
//					System.out.print("��ǰ��ȡ���ǵ�" + items + "���ϴ���,�ܴ�С" + cl
//							+ "KB,�Ѿ���ȡ" + br + "KB");
//					// ʣ���ֽ���
//					BigDecimal ll = cl.subtract(br);
//					System.out.print("ʣ��" + ll + "KB");
//					// �ϴ��ٷֱ�
//					BigDecimal per = br.multiply(new BigDecimal(100)).divide(
//							cl, 2, BigDecimal.ROUND_HALF_UP);
//					System.out.print("�Ѿ����" + per + "%");
//					// �ϴ���ʱ
//					Long nowTime = System.currentTimeMillis();
//					Long useTime = (nowTime - beginTime) / 1000;
//					System.out.print("�Ѿ���ʱ" + useTime + "��");
//					// �ϴ��ٶ�
//					BigDecimal speed = new BigDecimal(0);
//					if (useTime != 0) {
//						speed = br.divide(new BigDecimal(useTime), 2,
//								BigDecimal.ROUND_HALF_UP);
//					}
//					System.out.print("�ϴ��ٶ�Ϊ" + speed + "KB/S");
//
//					// ����ʣ��ʱ��
//					BigDecimal ltime = new BigDecimal(0);
//					if (!speed.equals(new BigDecimal(0))) {
//						ltime = ll.divide(speed, 0, BigDecimal.ROUND_HALF_UP);
//					}
//					System.out.print("����ʣ��ʱ��Ϊ" + ltime + "��");
//					System.out.println();
//				}
//			});
//
//			// 3.�����ļ��ϴ����������request
//			@SuppressWarnings("unchecked")
//			List<FileItem> list = fileUpload.parseRequest(request);
//			// 4.�������е�FileItem
//			
//				for (FileItem item : list) {
//					if (item.isFormField()) {
//						// ��ǰ��һ����ͨ���ֶ���
//						// System.out.println(name_teacher+":"+value);
//					} else {
//						// ��ǰ��һ���ļ��ϴ���
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
//						// --ɾ����ʱ�ļ�
//						item.delete();		
//						
//						response.sendRedirect(request.getContextPath()
//								+ "/info.jsp");
//					}
//				}
//			 
//		} catch (FileSizeLimitExceededException e) {
//			response.getWriter().write("�����ļ�������10M,�ܴ�С������100M!");
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
