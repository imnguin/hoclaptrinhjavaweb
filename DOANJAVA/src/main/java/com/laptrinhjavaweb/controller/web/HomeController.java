package com.laptrinhjavaweb.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.DTO.NewDTO;
import com.laptrinhjavaweb.DTO.ProductDTO;
import com.laptrinhjavaweb.DTO.VideoDTO;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.IVideoService;
import com.laptrinhjavaweb.utils.MessageUtil;

@Controller(value = "homeControllerOfWeb")

public class HomeController {

	@Autowired
	private IProductService productService;

	@Autowired
	private INewService newService;

	@Autowired
	private IVideoService videoService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView showList(@ModelAttribute("model") ProductDTO model, @ModelAttribute("news") NewDTO news,

			@ModelAttribute("video") VideoDTO video, String keyword) {
		ModelAndView mav = new ModelAndView("web/home");
		ProductModel spmoi = new ProductModel();
		ProductModel spnoibat = new ProductModel();
		spnoibat.setListResult(productService.spnoibat());
		spmoi.setListResult(productService.spmoi());
		model.setListResult(productService.findAll(keyword));
		news.setListResult(newService.findAll());
		video.setListResult(videoService.findAll());
		mav.addObject("model", model);
		mav.addObject("spnoibat", spnoibat);
		mav.addObject("spmoi", spmoi);
		mav.addObject("news", news);
		mav.addObject("video", video);
		return mav;
	}

	@RequestMapping(value = "/san-pham/chi-tiet-san-pham", method = RequestMethod.GET)
	public ModelAndView chitietsanpham(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/chitietsanpham");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = productService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView tintuc(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/new");
		NewDTO model = new NewDTO();
		if (id != null) {
			model = newService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/lien-he", method = RequestMethod.GET)
	public ModelAndView trangMoi() {
		ModelAndView mav = new ModelAndView("web/lienhe");
		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // = isAutheticated o header.jsp
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth); // logout = sessionUtils
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(ProductDTO model,NewDTO news, @Param("keyword")String keyword) {
		ModelAndView mav = new ModelAndView("web/timkiem");
		model.setListResult(productService.findAll(keyword));
		news.setListResult(newService.findAll());
		mav.addObject("model", model);
		mav.addObject("news", news);
		return mav;
	}

}