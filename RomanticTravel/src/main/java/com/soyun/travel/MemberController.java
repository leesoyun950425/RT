package com.soyun.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.mail.JinsMail;

import jdk.nashorn.internal.ir.annotations.Reference;

@Controller
public class MemberController {

	@Autowired
	MemberDAO memberDAO;
	@Autowired
	MemberTools tool;

	@RequestMapping("loginPage")
	public void loginPage(Model model) {
		model.addAttribute("loginPage", tool.login());
	}

	// 회원가입
	@RequestMapping("sign")
	public void sign() {
	}

	@RequestMapping("insert")
	public String insert(MemberDTO memberDTO, HttpServletResponse response, Model model) throws IOException {
		memberDTO.setAuthKey('0');
		memberDTO.setTotaddr();
		memberDTO.setThumb("thumb.jpg");
		memberDAO.insert(memberDTO);
		// 인증메일보내기
		JinsMail mail = new JinsMail();
		mail.setId("leesoyun702");
		mail.setPw("verycuteso0425");
		mail.setSndUsr("이소윤", "leesoyun702@gmail");
		String id = "\"http://localhost:9002/travel/authkey?id=" + memberDTO.getId() + "\"";
		mail.SendMail(memberDTO.getEmail(), "가입완료 메일입니다.", "<a href=" + id + ">회원가입 인증하기</a>");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('회원가입 성공!! 로그인 페이지로 이동합니다.')");
		out.println("</script>");
		out.flush();
		model.addAttribute("loginPage", tool.login());
		return "loginPage";
	}

	@RequestMapping("selectId")
	public void selectId(String id, Model model) {
		if (memberDAO.select(id) != null) {
			model.addAttribute("result", "중복됨");
		} else {
			model.addAttribute("result", "중복안됨");
		}
	}

	// 인증키 인증된 처리
	@RequestMapping("authkey")
	public String authkey(String id, Model model, HttpServletResponse response) throws IOException {
		if ('0' == (memberDAO.select(id).getAuthkey())) {
			memberDAO.update(id);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('인증완료!! 로그인페이지로 이동합니다.')");
			out.println("</script>");
			out.flush();
			model.addAttribute("loginPage", tool.login());
			return "loginPage";
		} else {
			return "";
		}
	}

	// 로그인하기
	@RequestMapping("login")
	public String login(String id, String pw, HttpServletResponse response, Model model, HttpSession session)
			throws IOException {
		MemberDTO dto = memberDAO.select(id);
		int dto2 = memberDAO.selectCnt3(id);
		if (dto2 == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('없는 아이디 입니다.')");
			out.println("</script>");
			out.flush();
			model.addAttribute("loginPage", tool.login());
			return "loginPage";
		} else {
			if (pw.equals(dto.getPw())) {
				char authkey = dto.getAuthkey();
				if (authkey == '0') {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script type='text/javascript'>");
					out.println("alert('인증되지 않은 아이디입니다!!이메일에서 확인 후 로그인해주세요.')");
					out.println("</script>");
					out.flush();
					model.addAttribute("loginPage", tool.login());
					return "loginPage";
				} else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script type='text/javascript'>");
					out.println("alert('로그인 성공!!')");
					out.println("</script>");
					out.flush();
					session.setAttribute("id", dto.getId());
					session.setAttribute("name", dto.getName() + "_" + dto.getId());
					return "success";
				}
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('비밀번호 틀렸어요!!')");
				out.println("</script>");
				out.flush();
				model.addAttribute("loginPage", tool.login());
				return "loginPage";
			}
		}
	}

	// 아이디 찾기
	@RequestMapping("searchId")
	public void searchId() {
	}

	@RequestMapping("findId")
	public String findId(MemberDTO memberDTO, HttpServletResponse response, Model model) throws IOException {
		MemberDTO dto = memberDAO.selectId(memberDTO);
		int dto2 = memberDAO.selectCnt(memberDTO);
		if (dto2 == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('등록된 정보가 없습니다')");
			out.println("</script>");
			out.flush();
			return "searchId";
		} else {
			JinsMail mail = new JinsMail();
			mail.setId("leesoyun702");
			mail.setPw("verycuteso0425");
			mail.setSndUsr("이소윤", "leesoyun702@gmail");
			mail.SendMail(memberDTO.getEmail(), "찾으신 아이디입니다.", "찾으신 아이디는 " + "<h2>" + dto.getId() + "</h2>" + "입니다.");

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('메일로 발송이 완료되었습니다!!')");
			out.println("</script>");
			out.flush();
			model.addAttribute("loginPage", tool.login());
			return "loginPage";
		}
	}

	// 비밀번호 찾기
	@RequestMapping("searchPw")
	public void searchPw() {
	}

	@RequestMapping("findPw")
	public String findPw(MemberDTO memberDTO, HttpServletResponse response, Model model) throws IOException {
		MemberDTO dto = memberDAO.selectPw(memberDTO);
		int dto2 = memberDAO.selectCnt2(memberDTO);
		if (dto2 == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('등록된 정보가 없습니다')");
			out.println("</script>");
			out.flush();
			return "searchPw";
		} else {
			JinsMail mail = new JinsMail();
			String pw = "\"http://localhost:9002/travle/updatePw?id=" + dto.getId() + "\"";
			mail.setId("leesoyun702");
			mail.setPw("verycuteso0425");
			mail.setSndUsr("이소윤", "leesoyun702@gmail");
			mail.SendMail(dto.getEmail(), "비밀번호 변경메일 입니다.", "<a href=" + pw + ">비밀번호 변경하기</a>");

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('등록된 메일로 발송해드렸습니다!')");
			out.println("</script>");
			out.flush();
			model.addAttribute("loginPage", tool.login());
			return "loginPage";
		}
	}

	// 비밀번호 찾고 변경하기
	@RequestMapping("updatePw")
	public void updatePw(MemberDTO memberDTO, Model model) {
		String id = memberDTO.getId();
		MemberDTO dto = memberDAO.select(id);
		model.addAttribute("id", dto.getId());
	}

	@RequestMapping("updatePw2")
	public String updatePw2(MemberDTO memberDTO, Model model) {
		memberDAO.updatePw(memberDTO);
		model.addAttribute("loginPage", tool.login());
		return "loginPage";
	}

	// 마이페이지로 이동하기
	@RequestMapping("my")
	public void my(MemberDTO memberDTO, HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		MemberDTO dto = memberDAO.select(id);
		model.addAttribute("dto", dto);
		String addr = dto.getTotaddr();
		String[] addrs = addr.split("\\.");
		model.addAttribute("addr",addrs[0]);
		model.addAttribute("addr1",addrs[1]);
		model.addAttribute("addr2",addrs[2]);
		model.addAttribute("addr3",addrs[3]);
	}

	// 회원수정하기
	@RequestMapping("updateAll")
	public String updateAll(MemberDTO memberDTO,String travel_theme2,String addr1,HttpSession session,HttpServletResponse response) throws IOException {
		String id = (String) session.getAttribute("id");
		MemberDTO dto = memberDAO.select(id);
		String roadaddr = dto.getRoadaddr();
		String totaddr = dto.getTotaddr();
		
		if(travel_theme2 != null) {
			memberDTO.setTravel_theme(travel_theme2);
			memberDTO.setTotaddr();
			memberDAO.updateAll(memberDTO);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('수정이 완료되었습니다!!!')");
			out.println("</script>");
			out.flush();
			return "updateAll";
		}else {
			memberDTO.setTotaddr();
			memberDAO.updateAll(memberDTO);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('수정이 완료되었습니다!!!')");
			out.println("</script>");
			out.flush();
			return "updateAll";
		}
	}
	
	//회원탈퇴하기
	@RequestMapping("delete")
	public String delete(String inputId,Model model,HttpSession session,HttpServletResponse response) throws IOException {
		inputId = (String)session.getAttribute("id");
		memberDAO.delete(inputId);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('탈퇴가 완료되었습니다!')");
		out.println("</script>");
		out.flush();
		session.invalidate();
		model.addAttribute("loginPage", tool.login());
		return "loginPage";
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(Model model,HttpSession session) {
		session.invalidate();
		model.addAttribute("loginPage", tool.login());
		return "loginPage";
	}
}

