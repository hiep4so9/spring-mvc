package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.connect.DatabaseConfig;
import model.Bill;
import model.Product;

public class BillDAO {
Connection conn = null;
	
	java.sql.PreparedStatement sttm = null;
	
	public int addBill(Bill bill) {
		try {
		String sql = "INSERT INTO `bills` "
				+ "(`bill_id`, `date_order`, `total`, `status`, `create_at`, `Id_customer`, `Diachi`) "
				+ "		VALUES (?, ?, ?,?, ?,?,?);";
			conn = DatabaseConfig.getConnection();
			sttm = conn.prepareStatement(sql);	
//			sttm.setLong(6, bill.getId_customer());
			sttm.setLong(1, 0);
			sttm.setTimestamp(2, bill.getDate_order());
			sttm.setFloat(3, bill.getTotal());
			sttm.setString(4, bill.getStatus());
			sttm.setTimestamp(5, bill.getCreate_at());
			sttm.setLong(6,1);
			sttm.setString(7, bill.getDiachi());
			if(sttm.executeUpdate()>0) {
				System.out.print("Them hoa don thanh cong");
				return 1;
			}
			else {
				return 0;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return -1;
	}
	
	public String getNameById(long id) {

		ResultSet rs = null;
		String categoryName = "";
		try {
			String sql = "SELECT categoryName "
					+ "FROM categories c,products p "
					+ "WHERE c.categoryID = p.categoryID "
					+ "and p.ProductId = ?";
			conn = DatabaseConfig.getConnection();
			sttm = conn.prepareStatement(sql)	;
			sttm.setLong(1, id);
			rs = sttm.executeQuery();
			while(rs.next()) {
				categoryName = rs.getString("categoryName");
			}	
		} catch (Exception e) {	
			System.out.println("error: " +e.toString());
		}
		finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return categoryName;
	}
	
	
	public int updateBill(Bill bill) {
		try {
		String sql = "UPDATE `bills` "
				+ "SET `date_order` = ?, "
				+ "`total` = ?, "
				+ "`status` = ?, "
				+ "`create_at` = ?, "
				+ "`Id_customer` = ?, "
				+ "WHERE `bills`.`bill_id` = ?";
			conn = DatabaseConfig.getConnection();
			sttm = conn.prepareStatement(sql);
			
			sttm.setLong(6, bill.getId_customer());
			sttm.setLong(1, bill.getBill_id());
			sttm.setTimestamp(2, bill.getDate_order());
			sttm.setFloat(3, bill.getTotal());
			sttm.setString(4, bill.getStatus());
			sttm.setTimestamp(5, bill.getCreate_at());
			if(sttm.executeUpdate()>0) {
				System.out.println("Update hóa đơn thành công!");
				return 1;
			}
			else {
				return 0;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	public int updateBillgiaohang(Long id) {
		try {
		String sql = "UPDATE bills SET status=? WHERE bill_id=?";
			conn = DatabaseConfig.getConnection();
			sttm = conn.prepareStatement(sql);
			
		
			sttm.setLong(2, id);
		
			sttm.setString(1, "Da giao");
	
			if(sttm.executeUpdate()>0) {
				System.out.println("Update hóa đơn thành công!");
				return 1;
			}
			else {
				return 0;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return -1;
	}
	
	public int updateBillhoanthanh(Long id) {
		try {
		String sql = "UPDATE bills SET status=? WHERE bill_id=?";
			conn = DatabaseConfig.getConnection();
			sttm = conn.prepareStatement(sql);
			
		
			sttm.setLong(2, id);
		
			sttm.setString(1, "hoanthanh");
	
			if(sttm.executeUpdate()>0) {
				System.out.println("Update hóa đơn thành công!");
				return 1;
			}
			else {
				return 0;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return -1;
	}
	
	
	
	public List<Bill> readBill() {
		List<Bill> list = new ArrayList<>();
		ResultSet rs = null;
		Statement sttm = null;
		try {
			String sql = "Select * from bills";
			conn = DatabaseConfig.getConnection();
			sttm = conn.createStatement()	;
			rs = sttm.executeQuery(sql);
			while(rs.next()) {
				Bill pd = new Bill();
				pd.setBill_id(rs.getLong(1));
				pd.setDate_order(rs.getTimestamp(2));
				pd.setTotal(rs.getFloat(3));
				pd.setStatus(rs.getString(4));
				pd.setCreate_at(rs.getTimestamp(5));
				pd.setId_customer(rs.getLong(6));
				list.add(pd);
			}	
		
		} catch (Exception e) {	
			System.out.println("error: " +e.toString());
		}
		finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return list;
	}
	
	
//	public Bill getProductByemail(String id) {
//
//		ResultSet rs = null;
//
//		Bill pd = new Bill();
//		try {
//			String sql = "Select * from products WHERE `products`.`email` = ?";
//			conn = DatabaseConfig.getConnection();
//			sttm = conn.prepareStatement(sql)	;
//			sttm.setString(1, id);
//			rs = sttm.executeQuery();
//			while(rs.next()) {
//				
//				
//				pd.setBill_id(rs.getLong(1));
//				pd.setDate_order(rs.getTimestamp(2));
//				pd.setTotal(rs.getFloat(3));
//				pd.setStatus(rs.getString(4));
//				pd.setCreate_at(rs.getTimestamp(5));
//				pd.setId_customer(rs.getLong(6));
//				
//			}	
//		} catch (Exception e) {	
//			System.out.println("error: " +e.toString());
//		}
//		finally {
//			try {
//				rs.close();
//				sttm.close();
//				conn.close();
//			}
//			catch(Exception error){
//				System.out.println("error: " +error.toString());
//			}
//		}
//		return pd;
//	}
	
	
	//load hoa don
	
	public List<Bill> dochoadon() {
		List<Bill> list = new ArrayList<>();
		ResultSet rs = null;
		Statement sttm = null;
		try {
			String sql = "Select * from bills";
			conn = DatabaseConfig.getConnection();
			sttm = conn.createStatement()	;
			rs = sttm.executeQuery(sql);
			while(rs.next()) {
				Bill pd = new Bill();
				pd.setBill_id(rs.getLong(1));
				pd.setDate_order(rs.getTimestamp(2));
				pd.setTotal(rs.getFloat(3));
				pd.setStatus(rs.getString(4));
				pd.setCreate_at(rs.getTimestamp(5));
				pd.setId_customer(rs.getLong(6));
				pd.setDiachi(rs.getString(7));
				System.out.println("kiem dia chi:  " +pd);
				list.add(pd);
			}	
		
		} catch (Exception e) {	
			System.out.println("error: " +e.toString());
		}
		finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return list;
	}
	//dffsdf
	
	
	
	
	
	public List<Bill> readBillByStatus() {
		List<Bill> list = new ArrayList<>();
		ResultSet rs = null;
		Statement sttm = null;
		try {
			String sql = "Select * from bills WHERE `bills`.`status` = 0";
			conn = DatabaseConfig.getConnection();
			sttm = conn.createStatement()	;
			rs = sttm.executeQuery(sql);
			while(rs.next()) {
				Bill pd = new Bill();
				pd.setBill_id(rs.getLong(1));
				pd.setDate_order(rs.getTimestamp(2));
				pd.setTotal(rs.getFloat(3));
				pd.setStatus(rs.getString(4));
				pd.setCreate_at(rs.getTimestamp(5));
				pd.setId_customer(rs.getLong(6));
				list.add(pd);
			}	
		
		} catch (Exception e) {	
			System.out.println("error: " +e.toString());
		}
		finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return list;
	}
	
	public List<Bill> readBillDonHang() {
		List<Bill> list = new ArrayList<>();
		ResultSet rs = null;
		Statement sttm = null;
		try {
			String sql = "Select * from bills WHERE `bills`.`status` = 1";
			conn = DatabaseConfig.getConnection();
			sttm = conn.createStatement()	;
			rs = sttm.executeQuery(sql);
			while(rs.next()) {
				Bill pd = new Bill();
				pd.setBill_id(rs.getLong(1));
				pd.setDate_order(rs.getTimestamp(2));
				pd.setTotal(rs.getFloat(3));
				pd.setStatus(rs.getString(4));
				pd.setCreate_at(rs.getTimestamp(5));
				pd.setId_customer(rs.getLong(6));
				list.add(pd);
			}	
		
		} catch (Exception e) {	
			System.out.println("error: " +e.toString());
		}
		finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return list;
	}
	
	
	
	
	
	
	
//	public List<Bill> readBilll() {
//		List<Bill> list = new ArrayList<>();
//		ResultSet rs = null;
//		Statement sttm = null;
//		try {
//			String sql = "Select * from bills WHERE `bills`.`Id_customer` = ?";
//			conn = DatabaseConfig.getConnection();
//			sttm = conn.createStatement()	;

//			rs = sttm.executeQuery(sql);
//			while(rs.next()) {
//				Bill pd = new Bill();
//				pd.setBill_id(rs.getLong(1));
//				pd.setDate_order(rs.getTimestamp(2));
//				pd.setTotal(rs.getFloat(3));
//				pd.setStatus(rs.getString(4));
//				pd.setCreate_at(rs.getTimestamp(5));
//				pd.setId_customer(rs.getLong(6));
//				list.add(pd);
//			}	
//		
//		} catch (Exception e) {	
//			System.out.println("error: " +e.toString());
//		}
//		finally {
//			try {
//				rs.close();
//				sttm.close();
//				conn.close();
//			}
//			catch(Exception error){
//				System.out.println("error: " +error.toString());
//			}
//		}
//		return list;
//	}
	
	
	public List<Bill> readBilll(long id) {
		List<Bill> list = new ArrayList<>();
		ResultSet rs = null;

		Bill pd = null;
		try {
			String sql = "Select * from bills WHERE `bills`.`Id_customer` = ?";
			conn = DatabaseConfig.getConnection();
			sttm = conn.prepareStatement(sql)	;
			sttm.setLong(1, id);
			rs = sttm.executeQuery();
			while(rs.next()) {
				pd = new Bill();
				pd.setBill_id(rs.getLong(1));
				pd.setDate_order(rs.getTimestamp(2));
				pd.setTotal(rs.getFloat(3));
				pd.setStatus(rs.getString(4));
				pd.setCreate_at(rs.getTimestamp(5));
				pd.setId_customer(rs.getLong(6));
				list.add(pd);
			}	
		} catch (Exception e) {	
			System.out.println("error: " +e.toString());
		}
		finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			}
			catch(Exception error){
				System.out.println("error: " +error.toString());
			}
		}
		return list;
	}
}
