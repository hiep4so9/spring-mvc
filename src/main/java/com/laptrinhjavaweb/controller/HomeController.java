package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		mav.setViewName("admin/user/quanlyuser");
		UserDAO dao = new UserDAO();
		List<Users> userList = dao.readUsers();
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping("/quanlyproduct")
	public ModelAndView Quanlysanpham() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/quanlysanpham");
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.readProduct();
		mav.addObject("productList", productList);
		mav.addObject("productDAO", dao);
		return mav;
	}

	@RequestMapping("/quanlyhoadon")
	public ModelAndView Quanlyhoadon() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/bill/quanlyhoadon");
		BillDAO dao = new BillDAO();
		List<Bill> billList = dao.readBill();
		mav.addObject("billList", billList);
		mav.addObject("billDAO", dao);
		return mav;
	}

	@RequestMapping("/quanlykhachhang")
	public ModelAndView Quanlykhachhang() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/khachhang/quanlykhachhang");
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customerList = dao.readCustomer();
		mav.addObject("customerList", customerList);
		mav.addObject("customerDAO", dao);
		return mav;
	}
	
	//addproduct

	@RequestMapping("/addproduct")
	public String addProduct() {
		return "/admin/product/addProduct";
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView AddBill(HttpServletRequest request) {
		ProductDAO dao = new ProductDAO();
		Product product = new Product();
		product.setProductName(request.getParameter("productname"));
		product.setListPrice(Integer.parseInt(request.getParameter("listprice")));
		product.setCategoryID(Long.parseLong(request.getParameter("categoryID")));
		if (dao.addProduct(product) == 1) {
			return new ModelAndView("redirect:/quanlyproduct");
		} else {
			return new ModelAndView("redirect:/spring-mvc/addproduct");
		}
	}
	
	
	@RequestMapping(value = "/editproduct/{productId}", method = RequestMethod.GET)
	public ModelAndView showEditProductForm(@PathVariable Long productId) {
	    ProductDAO dao = new ProductDAO();
	    Product product = dao.getProductById(productId);
	    ModelAndView mav = new ModelAndView("/admin/product/editProduct");
	    mav.addObject("product", product);
	    return mav;
	}


	
	@RequestMapping(value = "/editproduct/{productId}", method = RequestMethod.POST)
	public ModelAndView handleEditProductForm(HttpServletRequest request, @PathVariable Long productId) {
	    ProductDAO dao = new ProductDAO();
	    Product product = dao.getProductById(productId);
	    product.setProductName(request.getParameter("productname"));
	    product.setListPrice(Integer.parseInt(request.getParameter("listprice")));
	    product.setCategoryID(Long.parseLong(request.getParameter("categoryID")));
	    if (dao.updateProduct(product) == 1) {
	        return new ModelAndView("redirect:/quanlyproduct");
	    } else {
	        return new ModelAndView("redirect:/spring-mvc/editproduct/" + productId);
	    }
	}


}
