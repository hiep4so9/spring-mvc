package model;

import java.sql.Timestamp;

public class Categories {
	private Long categoryID;
	private String categoryName;
	private String cate_description;
	private Timestamp create_at;
	
	public Categories()
	{
		
	}
	public Categories(Long categoryID, String categoryName, String cate_description, Timestamp create_at) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.cate_description = cate_description;
		this.create_at = create_at;
	}
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCate_description() {
		return cate_description;
	}
	public void setCate_description(String cate_description) {
		this.cate_description = cate_description;
	}
	public Timestamp getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Timestamp timestamp) {
		this.create_at = timestamp;
	}
	@Override
	public String toString() {
		return "Categories [categoryID=" + categoryID + ", categoryName=" + categoryName + ", cate_description="
				+ cate_description + ", create_at=" + create_at + "]";
	}
	
	
}
