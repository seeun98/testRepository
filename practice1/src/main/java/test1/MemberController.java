package test1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")   //브라우저에서 요청 시 두 단계로 요청 이뤄짐
public class MemberController extends HttpServlet {
	MemberDAO memberDAO;

	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		if (action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test1/listMembers.jsp";		//위치 확인
		
		} else if (action.equals("/addMember.do")) {    //전송된 회원 정보 가져와 테이블에 추가
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/listMembers.do";	

		} else if (action.equals("/MemberForm.do")) {	//회원 가입창을 화면에 출력
			nextPage = "/test1/MemberForm.jsp";				//위치 확인
		} else {  										// 회원 정보 조회
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test1/listMembers.jsp";			//위치 확인
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
