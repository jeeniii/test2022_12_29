package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import domain.PagingVO;
import handler.FileHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=LoggerFactory.getLogger(BoardController.class);
	private RequestDispatcher rdp;
	private BoardService bsv;
	private String destPage;
	private int isOk;
	private String savePath;
	private final String UTF8="utf-8";
       
    public BoardController() {
    	bsv=new BoardServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri=req.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/")+1);
		log.info("uri> :"+uri);
		log.info("path> :"+path);
		
		switch(path) {
		case "register":
			log.info("register1");
			destPage="/board/register.jsp";
			break;
			
		case "insert":
			try {
				savePath=getServletContext().getRealPath("_fileUpload");
				File fileDir=new File(savePath);
				log.info("저장 위치"+savePath);
				
				DiskFileItemFactory fileItemFactory=new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(2*1024*1024);
				
				BoardVO bvo=new BoardVO();
				ServletFileUpload fileUpload=new ServletFileUpload(fileItemFactory); 
				List<FileItem> itemList=fileUpload.parseRequest(req);
				log.info("insert 1");
				for(FileItem item:itemList) {
					switch(item.getFieldName()) {
					case "title":
						bvo.setTitle(item.getString(UTF8));
						break;
					case "writer":
						bvo.setWriter(item.getString(UTF8));
						break;
					case "content":
						bvo.setContent(item.getString(UTF8));
						break;
					case "image_file":
						if(item.getSize()>0) {
							String fileName=item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							log.info(fileName);
							fileName=System.currentTimeMillis()+"_"+fileName;
							File uploadFilePath=new File(fileDir+File.separator+fileName);
							log.info("파일 경로+이름: "+uploadFilePath);
							log.info("insert 2");
							try {
								item.write(uploadFilePath);							
								bvo.setImage_file(fileName);
								Thumbnails.of(uploadFilePath).size(100, 100).toFile(new File(fileDir+File.separator+"th_"+fileName));
							} catch (Exception e) {
								log.info("file writer on disk fail");
								e.printStackTrace();
							}
						}else {
							
						}
						break;
					}
				}
				isOk=bsv.register(bvo);
				log.info("insert > :"+(isOk>0?"ok":"fail"));
				destPage="pageList";
			} catch (Exception e) {
				log.info("insert error");
				e.printStackTrace();
			}
			break;
			
		case "pageList":
			try {
				PagingVO pgvo=new PagingVO();
				int totCount=bsv.getPageCnt();
				List<BoardVO> list=bsv.getListPage(pgvo);
				PagingHandler ph=new PagingHandler(pgvo, totCount);
				req.setAttribute("list", list);
				req.setAttribute("ph", ph);
				destPage="/board/list.jsp";
			} catch (Exception e) {
				log.info("pagint error");
				e.printStackTrace();
			}
			break;
			
			case "page":
				try {
					int pageNo=Integer.parseInt(req.getParameter("pageNo"));
					int qty=Integer.parseInt(req.getParameter("qty"));
					PagingVO pgvo=new PagingVO(pageNo,qty);
					int totCount=bsv.getPageCnt();
					List<BoardVO> list=bsv.getListPage(pgvo);
					PagingHandler ph=new PagingHandler(pgvo, totCount);
					System.out.println(ph.getStartpage());
					req.setAttribute("list", list);
					req.setAttribute("ph", ph);
					destPage="/board/list.jsp";
				} catch (Exception e) {
					log.info("subPage error");
					e.printStackTrace();
				}
				break;
			case "detail":
				try {
					log.info("detail 1");
					int bno=Integer.parseInt(req.getParameter("bno"));
					//service 호출 시 read_count+1(update)하고 디테일 값 호출
					BoardVO bvo=bsv.getDetail(bno);
					req.setAttribute("bvo", bvo);
					log.info("detail 4");
					destPage="/board/detail.jsp";
				} catch (Exception e) {
					log.info("detail error");
					e.printStackTrace();
				}
				break;
				
			case "modify":
				try {
					int bno=Integer.parseInt(req.getParameter("bno"));
					BoardVO bvo=bsv.getDetail(bno);
					req.setAttribute("bvo", bvo);
					destPage="/board/modify.jsp";
				} catch (Exception e) {
					log.info("modify error");
					e.printStackTrace();
				}
				break;
				
			case "update":
				try {
					log.info("modify 1");
					savePath=getServletContext().getRealPath("_fileUpload");
					log.info(savePath);
					File fileDir=new File(savePath);
					DiskFileItemFactory fileItemFactory=new DiskFileItemFactory();
					fileItemFactory.setRepository(fileDir);
					fileItemFactory.setSizeThreshold(2*1024*1024);
					
					BoardVO bvo=new BoardVO();
					ServletFileUpload fileUpload=new ServletFileUpload(fileItemFactory);
					log.info("update 준비");
					List<FileItem> itemList=fileUpload.parseRequest(req);
					String old_file=null;
					
					for(FileItem item:itemList) {
						switch(item.getFieldName()) {
						case "bno":
							bvo.setBno(Integer.parseInt(item.getString(UTF8)));
							break;
						case "title":
							bvo.setTitle(item.getString(UTF8));
							break;
						case "content":
							bvo.setContent(item.getString(UTF8));
							break;
						case "new_file":
							if(item.getSize()>0) {
								if(old_file !=null) {
									//fileHandler로 기존 파일 삭제
									FileHandler fileHandler=new FileHandler();
									isOk=fileHandler.deleteFile(old_file, savePath);
								}
								String fileName=item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
								log.info("newFileName: "+fileName);
								log.info(item.getName());
								
								fileName=System.currentTimeMillis()+"_"+fileName;
								File uploaFilePath=new File(fileDir+File.separator+fileName);
								log.info("파일 경로, 이름: "+uploaFilePath);
								try {
									item.write(uploaFilePath);
									bvo.setImage_file(fileName);
									log.info("upload ima_file: "+bvo.getImage_file());
									Thumbnails.of(uploaFilePath).size(100, 100).toFile(fileDir+File.separator+"th_"+fileName);
								} catch (Exception e) {
									log.info("File write on disk fail");
									e.printStackTrace();
								}
							}else {
								bvo.setImage_file(old_file);
							}
							break;
						}
					}
					isOk=bsv.modify(bvo);
					log.info("update: "+(isOk>0? "ok":"fail"));
					destPage="pageList";
				} catch (Exception e) {
					log.info("update error");
					e.printStackTrace();
				}
			
		default:
			break;
		}
		
		rdp=req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
