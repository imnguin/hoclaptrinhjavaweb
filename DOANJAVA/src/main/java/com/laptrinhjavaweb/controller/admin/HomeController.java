package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.DTO.AccountDTO;
import com.laptrinhjavaweb.DTO.CategoryDTO;
import com.laptrinhjavaweb.DTO.NewDTO;
import com.laptrinhjavaweb.DTO.ProductDTO;
import com.laptrinhjavaweb.DTO.VideoDTO;
import com.laptrinhjavaweb.service.IAccountService;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.IVideoService;
import com.laptrinhjavaweb.utils.MessageUtil;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("admin/home");
      return mav;
	}
	@Autowired
	private MessageUtil messageUtil;
	
	//CONTROLLER TRANG SẢN PHẨM
	@Autowired
	private IProductService productService;
	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request, String keyword) {
		ProductDTO model = new ProductDTO();
		ModelAndView mav = new ModelAndView("admin/listproduct");
		model.setListResult(productService.findAll(keyword));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/quan-tri/san-pham/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/edit");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = productService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	// CONTROLLER TRANG DANH MỤC SẢN PHẨM
	@Autowired
	private ICategoryService categoryService;
	@RequestMapping(value = "/quan-tri/danh-muc/danh-sach", method = RequestMethod.GET)
	public ModelAndView showListcategory(HttpServletRequest request) {
		CategoryDTO model = new CategoryDTO();
		ModelAndView mav = new ModelAndView("admin/listcategory");
		model.setListResult(categoryService.Getlistcategory());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/quan-tri/danh-muc/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/editcategory");
		CategoryDTO model = new CategoryDTO();
		if (id != null) {
			model = categoryService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	//CONTROLLER TRANG TÀI KHOẢN
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping(value = "/quan-tri/tai-khoan/danh-sach", method = RequestMethod.GET)
	public ModelAndView ListAccount(HttpServletRequest request) {
		AccountDTO model = new AccountDTO();
		ModelAndView mav = new ModelAndView("admin/listaccount");
		model.setListResult(accountService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/quan-tri/tai-khoan/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editAccount(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/editaccount");
		AccountDTO model = new AccountDTO();
		if (id != null) {
			model = accountService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	//CONTROLLER TRANG VIDEO
	@Autowired
	private IVideoService videoService;
	@RequestMapping(value = "/quan-tri/video/danh-sach", method = RequestMethod.GET)
	public ModelAndView ListVideo(HttpServletRequest request) {
		VideoDTO model = new VideoDTO();
		ModelAndView mav = new ModelAndView("admin/listvideo");
		model.setListResult(videoService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/quan-tri/video/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editVideo(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/editvideo");
		VideoDTO model = new VideoDTO();
		if (id != null) {
			model = videoService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	//CONTROLLER TRANG BÀI VIẾT
	@Autowired
	private INewService newService;
	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView ListNew(HttpServletRequest request) {
		NewDTO model = new NewDTO();
		ModelAndView mav = new ModelAndView("admin/listnew");
		model.setListResult(newService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/editnew");
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
}
