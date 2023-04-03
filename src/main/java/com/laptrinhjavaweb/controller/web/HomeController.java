package com.laptrinhjavaweb.controller.web;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DAO.BillDAO;
import DAO.ProductDAO;
import DAO.Sharedata;
import DAO.UserDAO;
import model.Bill;
import model.Product;
import model.Users;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

//	<li><a href="trang-chu/${product.productId}"><i class="fas fa-shopping-cart"></i></a></li>

	@RequestMapping(value = "trang-chu/{id}", method = RequestMethod.GET)
	public ModelAndView addcart(@PathVariable("id") String id) {
		System.out.println("okay vao dc cai xoa11 " + id);
		Sharedata ls = new Sharedata();
		int number = Integer.parseInt(id);
		ls.CList.add(number);
		System.out.println("kiem tra cai lisst: " + ls.CList.toString());
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.readProduct();
		mav.addObject("productList", productList);
		mav.addObject("productDAO", dao);
		Sharedata ls = new Sharedata();

		int a = ls.CList.size();
		mav.addObject("a", a);
		return mav;
	}

	@RequestMapping(value = "/hoadonkhach", method = RequestMethod.GET)
	public ModelAndView homePageee(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/Hoadonkhach");
		HttpSession userSession = request.getSession();
		String userid = userSession.getAttribute("userSession").toString();
		System.out.println("trang carrt kiem tra session trang thêm cart: " + userid);
		UserDAO dio = new UserDAO();
		Users khanh = new Users();
		khanh = dio.getProductByemail(userid);
		System.out.println("do huy khanh: " + khanh.getId_user());
		BillDAO dao1 = new BillDAO();
		List<Bill> billList = dao1.readBilll(khanh.getId_user());
		System.out.println("do huy khanh 1 : " + billList);
		mav.addObject("billList", billList);

		return mav;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView homePageeeyuy(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/Pr");
		HttpSession userSession = request.getSession();
		String userid = userSession.getAttribute("userSessionemail").toString();
		System.out.println("trang carrt kiem tra session trang thêm cart: " + userid);
		UserDAO dio = new UserDAO();
		Users khanh = new Users();
		khanh = dio.getProductByemail(userid);
		System.out.println("do huy khanh: " + khanh.getId_user());
		BillDAO dao1 = new BillDAO();
		List<Bill> billList = dao1.readBilll(khanh.getId_user());

		mav.addObject("fullname", khanh.getName());
		mav.addObject("email", khanh.getEmail());
		mav.addObject("pass", khanh.getPassword());

		return mav;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ModelAndView addcarrtt(@RequestParam String totalPrice, HttpServletRequest request,
			@RequestParam("country") String selectedCountry) {
		System.out.println("sao ko vo dc v");
		HttpSession userSession = request.getSession();
		String userid = userSession.getAttribute("userSessionemail").toString();
		System.out.println("trang carrt kiem tra session trang thêm cart: " + userid);
		BillDAO dao = new BillDAO();
		UserDAO dio = new UserDAO();
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
//	    SecureRandom random = new SecureRandom(); // You can also use java.util.Random for less security
//        byte[] bytes = new byte[32]; // 32 bytes = 256 bits
//        random.nextBytes(bytes);
//        BigInteger bigInt = new BigInteger(1, bytes);
//        System.out.println("Random BigInteger: " + bigInt);
		Random random = new Random();
		long min = 10000000L; // Minimum value (8 digits)
		long max = 99999999L; // Maximum value (8 digits)
		long randomLong = min + ((long) (random.nextDouble() * (max - min)));
		System.out.println("Random 8-digit number: " + randomLong);
		Users khanh = new Users();
		khanh = dio.getProductByemail(userid);
		System.out.println("trang carrt kiem tra session trang thêm cart: " + khanh.getId_user());
		Bill bill = new Bill();
		bill.setBill_id(randomLong);
		bill.setId_customer(khanh.getId_user());
		float f = Float.parseFloat(totalPrice);
		bill.setTotal(f);
		bill.setCreate_at(timestamp);
		bill.setDate_order(timestamp);
		bill.setStatus("Chua gui hang");
		bill.setDiachi(selectedCountry);

		if (dao.addBill(bill) == 1) {
			Sharedata ls = new Sharedata();
			ls.CList.clear();
			return new ModelAndView("redirect:/trang-chu");
		} else {
			return new ModelAndView("web/cart");
		}
//		return new ModelAndView("web/cart");

	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cartPage() {
//		HttpSession userSession = request.getSession();
//		String userid =userSession.getAttribute("userSessionemail").toString();
//		System.out.println("trang carrt kiem tra session" + userid);

		List<Product> list = new ArrayList<>();
		Sharedata ls = new Sharedata();
		ProductDAO dao = new ProductDAO();
		Product pd = new Product();
		int tongtien = 0;
		for (int i = 0; i < ls.CList.size(); i++) {
			pd = dao.getproductById(ls.CList.get(i));
			tongtien = tongtien + pd.getListPrice();
			list.add(pd);
			System.out.println("trang carrt" + ls.CList.get(i));

		}

		for (int i = 0; i < list.size(); i++) {

			System.out.println("kiem tra cai list: " + list.get(i));

		}
//		ls.CList.add(null);
		ModelAndView mav = new ModelAndView("web/cart");
//		int a =  ls.CList.size();
//		String s=String.valueOf(a);
		mav.addObject("tongtien", tongtien);
		mav.addObject("list", list);
		mav.addObject("productDAO", dao);
		return mav;
	}
}
