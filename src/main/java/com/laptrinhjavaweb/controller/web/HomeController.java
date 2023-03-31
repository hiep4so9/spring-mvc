package com.laptrinhjavaweb.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DAO.ProductDAO;
import DAO.Sharedata;
import model.Product;

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
		mav.addObject("a",a );
		return mav;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cartPage() {
		List<Product> list = new ArrayList<>();
		Sharedata ls = new Sharedata();
		ProductDAO dao = new ProductDAO();
		Product pd = new Product();

		for (int i = 0; i < ls.CList.size(); i++) {
			pd = dao.getproductById(ls.CList.get(i));
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
		
		mav.addObject("list", list);
		mav.addObject("productDAO", dao);
		return mav;
	}
}
