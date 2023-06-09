package com.laptrinhjavaweb.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.BillDAO;
import DAO.CategoriesDAO;
import DAO.CustomerDAO;
import DAO.ProductDAO;
import DAO.Sharedata;
import DAO.UserDAO;
import model.Bill;
import model.Categories;
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
			userSession.setAttribute("userSessionemail", user.getEmail());
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
		mav.setViewName("admin/Bill/quanlyhoadon");
		BillDAO dao = new BillDAO();
		List<Bill> billList = dao.readBill();
		mav.addObject("billList", billList);
		mav.addObject("billDAO", dao);
		return mav;
	}
	
	
	
	//updaate 
	@RequestMapping(value = "/quanlydondathang", method = RequestMethod.POST)
	public ModelAndView addcarrtt(@RequestParam String id) {
		System.out.println("sao ko vo dc v"+ id);
	
		BillDAO dao = new BillDAO();
	

//		Bill bill = new Bill();

		long num = Long.parseLong(id); 
		if (dao.updateBillgiaohang(num) == 1) {
	
			 return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("web/cart");
		}
//		return new ModelAndView("web/cart");
	    
	}
	
	//updaate 
	@RequestMapping(value = "/quanlydondathangg", method = RequestMethod.POST)
	public ModelAndView addcarrttt(@RequestParam String id) {
		System.out.println("sao ko vo dc v lan 2"+ id);
	
		BillDAO dao = new BillDAO();
	

//		Bill bill = new Bill();

		long num = Long.parseLong(id); 
		if (dao.updateBillhoanthanh(num) == 1) {
	
			 return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("web/cart");
		}
//		return new ModelAndView("web/cart");
	    
	}
	//day la cai trang nay
	@RequestMapping("/quanlydondathang")
	public ModelAndView QuanlyDonDatHang() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/Bill/quanlydondathang");
		BillDAO dao = new BillDAO();
		List<Bill> billList = dao.dochoadon();
		System.out.println("kiem dia chi lan 3:  ");
		System.out.println("kiem dia chi lan 2:  " +billList.toString());

		mav.addObject("billList", billList);
		mav.addObject("billDAO", dao);
		return mav;
	}
	
	@RequestMapping("/quanlydonhang")
	public ModelAndView QuanLyDonHang() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/Bill/quanlydondathang");
		BillDAO dao = new BillDAO();
		List<Bill> billList = dao.readBillDonHang();
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

	@RequestMapping("/editproduct")
	public ModelAndView editProduct(HttpServletRequest request) {
		CategoriesDAO categoryDAO = new CategoriesDAO();
		ProductDAO dao = new ProductDAO();
		ModelAndView model = new ModelAndView();
		List<Categories> listCategory = categoryDAO.readCategories();
		Product product = dao.getProductById(Long.parseLong(request.getParameter("id").trim()));
		List<String> listStatus = dao.getListStatus();
		model.addObject("product", product);
		model.addObject("listCategory", listCategory);
		model.addObject("listStatus", listStatus);
		model.setViewName("admin/editProduct");
		return model;
	}
	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		CategoriesDAO categoryDAO = new CategoriesDAO();
		ModelAndView model = new ModelAndView();
		List<Categories> listCategory = categoryDAO.readCategories();
		model.addObject("listCategory", listCategory);
		model.setViewName("admin/addProduct");
		return model;
	}
	@RequestMapping(value="/delete-product", method = RequestMethod.POST)
	@ResponseBody
    public String doAction(@RequestBody String selectedValues) {
		System.out.println(selectedValues);

		ObjectMapper mapper = new ObjectMapper();
		try {
		    @SuppressWarnings("unchecked")
			Map<String, Object> jsonMap = mapper.readValue(selectedValues, Map.class);

			@SuppressWarnings("unchecked")
			List<String> Values = (List<String>) jsonMap.get("selectedValues");

		    List<Long> selectedIds = new ArrayList<>();
		    for (String value : Values) {
		        selectedIds.add(Long.parseLong(value));
		    }
		    ProductDAO dao = new ProductDAO();
		    for(long item : selectedIds) {
		    	if(dao.hideProduct(item) == 1) {
		    		System.out.println(selectedIds);
				    
		    	}
		    }
		    return selectedIds.toString();
		} catch (Exception ex) {
		    ex.printStackTrace();

		}
	    return "404";
		
 
    }
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView AddBill(MultipartHttpServletRequest request) {

		ProductDAO dao = new ProductDAO();
		Product product = new Product();
		MultipartFile file1 = request.getFile("file1");
		ModelAndView model = new ModelAndView();

		// handle anh 1
		if (!file1.isEmpty()) {
			try {
				String originalFilename = file1.getOriginalFilename();
				String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
				String newFilename = "hinh1"
						+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + extension;
				byte[] bytes = file1.getBytes();
				ServletContext context = request.getServletContext();

				String path1 = context.getRealPath("/resources/img/" + newFilename);
				product.setProductImage(newFilename);
				FileOutputStream fos = new FileOutputStream(path1);
				fos.write(bytes);
				fos.close();
				model.addObject("message1", "File uploaded successfully");

			} catch (IOException e) {
				e.printStackTrace();
				model.addObject("message2", "File upload failed");
				return new ModelAndView("redirect:/addproduct");
			}
		} else {
			model.addObject("message2", "Please select a file to upload");
			return new ModelAndView("redirect:/addproduct");
		}
		// handle anh 2
		
		product.setProductName(request.getParameter("productname"));
		product.setListPrice(Integer.parseInt(request.getParameter("listprice")));
		product.setCategoryID(Long.parseLong(request.getParameter("categoryID")));
		System.out.println(request.getParameter("description"));
		product.setDescription(request.getParameter("description"));

		if (dao.addProduct(product) == 1) {
			return new ModelAndView("redirect:/quanlyproduct");
		} else {
			return new ModelAndView("redirect:/spring-mvc/addproduct");
		}
	}

}
