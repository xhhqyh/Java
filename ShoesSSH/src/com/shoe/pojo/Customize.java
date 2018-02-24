package com.shoe.pojo;
/**
 * 定制鞋
 * add by zrh 2018年1月17日 上午10:44:32
 *@param customizeId 定制编号
 *@param customizeNum  部件个数
 *@param customizeMessage  部件信息
 *@param customizeMinute  详细信息
 *@param customizePrice 产品价格
 *@param customizeStyle 款式风格
 *@param customizeCard 产品序号
 *@param customizeName 产品名称
 *@param goods  商品
 *@param size  尺寸
 *@param type	类型
 */
public class Customize {
		private Integer customizeId;
		private Integer customizeNum;
		private String  customizeMessage;
		private String customizeMinute;
		private String customizePrice;
		private String customizeStyle;
		private String customizeCard;
		private String customizeName;
		
		private Size size;
		private Brand brand;
		private Type type;
		
		
		
		public String getCustomizeStyle() {
			return customizeStyle;
		}
		public void setCustomizeStyle(String customizeStyle) {
			this.customizeStyle = customizeStyle;
		}
		public String getCustomizeCard() {
			return customizeCard;
		}
		public void setCustomizeCard(String customizeCard) {
			this.customizeCard = customizeCard;
		}
		public String getCustomizeName() {
			return customizeName;
		}
		public void setCustomizeName(String customizeName) {
			this.customizeName = customizeName;
		}
		
		public String getCustomizePrice() {
			return customizePrice;
		}
		public void setCustomizePrice(String customizePrice) {
			this.customizePrice = customizePrice;
		}
		public Brand getBrand() {
			return brand;
		}
		public void setBrand(Brand brand) {
			this.brand = brand;
		}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}
		public Integer getCustomizeId() {
			return customizeId;
		}
		public void setCustomizeId(Integer customizeId) {
			this.customizeId = customizeId;
		}
		public Integer getCustomizeNum() {
			return customizeNum;
		}
		public void setCustomizeNum(Integer customizeNum) {
			this.customizeNum = customizeNum;
		}
		public String getCustomizeMessage() {
			return customizeMessage;
		}
		public void setCustomizeMessage(String customizeMessage) {
			this.customizeMessage = customizeMessage;
		}
		public String getCustomizeMinute() {
			return customizeMinute;
		}
		public void setCustomizeMinute(String customizeMinute) {
			this.customizeMinute = customizeMinute;
		}
		public Size getSize() {
			return size;
		}
		public void setSize(Size size) {
			this.size = size;
		}
		@Override
		public String toString() {
			return "Customize [customizeId=" + customizeId + ", customizeNum=" + customizeNum + ", customizeMessage="
					+ customizeMessage + ", customizeMinute=" + customizeMinute + "]";
		}
		
		
		
		
		
}
