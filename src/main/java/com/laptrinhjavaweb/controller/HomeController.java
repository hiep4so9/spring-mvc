package com.laptrinhjavaweb.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import DAO.BillDAO;
import DAO.CustomerDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import model.Bill;
import model.Customer;
import model.Product;
import model.Users;

@Controller(value = "homeControllerOfLogin")
public class HomeController {
	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public String Index() {

		return "dangnhap";
	}

	@RequestMapping(value = "/dangnhap-post", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView property(HttpServletRequest request) {
		UserDAO dao = new UserDAO();
		if (dao.CheckLogin(request.getParameter("email"), request.getParameter("password"))) {
			Users user = new Users();
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			HttpSession userSession = request.getSession();
			userSession.setAttribute("userSession", user);
			return new ModelAndView("redirect:/trang-chu");
		} else {
			return new ModelAndView("redirect:/dangnhap");
		}

	}

	@RequestMapping(value = "/dangxuat")
	public RedirectView Dangxuat(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userSession");
		return new RedirectView("trang-chu");
	}

	@RequestMapping("/dangky")
	public String Dangky() {
		return "dangky";
	}

	@RequestMapping(value = "/dangkypost", method = RequestMethod.POST)
	public ModelAndView DangkyPost(HttpServletRequest request) {
		UserDAO dao = new UserDAO();

		Users user = new Users();
		user.setName(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		if (dao.addUser(user) == 1) {
			HttpSession userSession = request.getSession();
			userSession.setAttribute("userSession", user);
			return new ModelAndView("redirect:/trang-chu");
		} else {
			return new ModelAndView("redirect:/dangky");
		}

	}

	@RequestMapping("/quanlyuser")
	public ModelAndView Quanlytaikhoan() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/quanlyuser");
		UserDAO dao = new UserDAO();
		List<Users> userList = dao.readUsers();
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping("/quanlyproduct")
	public ModelAndView Quanlysanpham() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/quanlysanpham");
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.readProduct();
		mav.addObject("productList", productList);
		mav.addObject("productDAO", dao);
		return mav;
	}

	@RequestMapping("/quanlyhoadon")
	public ModelAndView Quanlyhoadon() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/quanlyhoadon");
		BillDAO dao = new BillDAO();
		List<Bill> billList = dao.readBill();
		mav.addObject("billList", billList);
		mav.addObject("billDAO", dao);
		return mav;
	}

	@RequestMapping("/quanlykhachhang")
	public ModelAndView Quanlykhachhang() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/quanlykhachhang");
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customerList = dao.readCustomer();
		mav.addObject("customerList", customerList);
		mav.addObject("customerDAO", dao);
		return mav;
	}

	@RequestMapping("/addproduct")
	public String addProduct() {
		return "/admin/addProduct";
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView AddBill(MultipartHttpServletRequest request) {
	
		ProductDAO dao = new ProductDAO();
		Product product = new Product();
		MultipartFile file1 = request.getFile("file1");
		MultipartFile file2= request.getFile("file2");
		MultipartFile file3 = request.getFile("file3");
		ModelAndView model = new ModelAndView();
		//handle anh 1
		if (!file1.isEmpty()) {
	        try {
	            String originalFilename = file1.getOriginalFilename();
	            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
	            String newFilename ="hinh1" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + extension;
	            byte[] bytes = file1.getBytes();
	            ServletContext context = request.getServletContext();

		        String path1 = context.getRealPath("/resources/images/" + newFilename);
		        product.setProductImage(newFilename);
	            FileOutputStream fos = new FileOutputStream(path1);
	            fos.write(bytes);
	            fos.close();
	            model.addObject("message2", "File uploaded successfully");

	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addObject("message2", "File upload failed");
	            return new ModelAndView("redirect:/spring-mvc/addproduct");
	        }
	    } else {
	        model.addObject("message2", "Please select a file to upload");
	        return new ModelAndView("redirect:/spring-mvc/addproduct");
	    }
		//handle anh 2
		if (!file2.isEmpty()) {
	        try {
	            String originalFilename = file2.getOriginalFilename();
	            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
	            String newFilename = "hinh2" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + extension;
	            byte[] bytes = file2.getBytes();
	            ServletContext context = request.getServletContext();

		        String path2 = context.getRealPath("/resources/images/" + newFilename);
		        product.setImage1(newFilename);
	            FileOutputStream fos = new FileOutputStream(path2);
	            fos.write(bytes);
	            fos.close();
	            model.addObject("message2", "File uploaded successfully");

	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addObject("message2", "File upload failed");
	            return new ModelAndView("redirect:/spring-mvc/addproduct");
	        }
	    } else {
	        model.addObject("message2", "Please select a file to upload");
	        return new ModelAndView("redirect:/spring-mvc/addproduct");
	    }
		//handle anh 3\
		if (!file3.isEmpty()) {
	        try {
	            String originalFilename = file3.getOriginalFilename();
	            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
	            String newFilename = "hinh3" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + extension;
	            byte[] bytes = file3.getBytes();
	            ServletContext context = request.getServletContext();

		        String path3 = context.getRealPath("/resources/images/" + newFilename);
		        product.setImage2(newFilename);
	            FileOutputStream fos = new FileOutputStream(path3);
	            fos.write(bytes);
	            fos.close();
	            model.addObject("message3", "File uploaded successfully");

	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addObject("message3", "File upload failed");
	            return new ModelAndView("redirect:/spring-mvc/addproduct");
	        }
	    } else {
	        model.addObject("message3", "Please select a file to upload");
	        return new ModelAndView("redirect:/spring-mvc/addproduct");
	    }
		product.setProductName(request.getParameter("productname"));
		product.setListPrice(Integer.parseInt(request.getParameter("listprice")));
		product.setCategoryID(Long.parseLong(request.getParameter("categoryID")));
		
		if (dao.addProduct(product) == 1) {
			return new ModelAndView("redirect:/quanlyproduct");
		} else {
			return new ModelAndView("redirect:/spring-mvc/addproduct");
		}
	}

}
