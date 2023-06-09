package handler.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import member.MemberDao;
import member.MemberDataBean;

@Controller
public class MemberLoginProHandler implements CommandHandler {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@RequestMapping("/memberloginpro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String	user_id		= request.getParameter("user_id");
		String	user_passwd	= request.getParameter("user_passwd");
		int		result		= memberDao.check(user_id, user_passwd);
		
		MemberDataBean dto = memberDao.getMember(user_id);
		int grade_id = dto.getGrade_id();
		
		request.setAttribute("grade_id", grade_id);
		request.setAttribute("result", result);
		request.setAttribute("user_id", user_id);
		
		return new ModelAndView("member/loginPro");
	}

}
