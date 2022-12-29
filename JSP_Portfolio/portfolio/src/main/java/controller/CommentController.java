package controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.CommentService;
import service.CommentServiceImpl;

@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=LoggerFactory.getLogger(CommentController.class);
	private CommentService csv;
	private int isOk;
	
       
    public CommentController() {
    	csv=new CommentServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		String uri=req.getRequestURI();
		String pathUri=uri.substring("/cmt".length());
		String path=pathUri;
		String pathVar="";
		if(pathUri.contains("/")) {
			path=pathUri.substring(0,pathUri.lastIndexOf("/"));
			pathVar=pathUri.substring(pathUri.lastIndexOf("/")+1);
		}
		log.info("uri>> "+uri);
		log.info("pathUri>> "+pathUri);
		log.info("path>> "+path);
		log.info("pathVar>> "+pathVar);
		switch (path) {
		case "post":
			try {
				StringBuffer sb=new StringBuffer();
				String line=null;
				BufferedReader br=req.getReader();
				while((line=br.readLine())!=null) {
					sb.append(line);
				}
				log.info(">sb:"+sb.toString());
				JSONParser parser=new JSONParser();
				JSONObject jsonObj=(JSONObject)parser.parse(sb.toString());
				int bno=Integer.parseInt(line)
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;

		default:
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}