package handler.office;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import office.OfficeDAO;
import office.OfficeRegisterDataBean;

@Controller
public class OfficeRegisterHandler implements CommandHandler {
	
	@Resource(name="officeDao")
	private OfficeDAO officeDao;
	
	@RequestMapping("/officeregister")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int office_id = Integer.parseInt(request.getParameter("officeId"));
		OfficeRegisterDataBean dto = officeDao.getOfficeReg(office_id);
		
		request.setAttribute("dto", dto);
		
		
		return new ModelAndView("office/officeRegister");
	}

}