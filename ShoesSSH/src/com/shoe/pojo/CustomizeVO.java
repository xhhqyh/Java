package com.shoe.pojo;
/**
 * ����Ь
 * add by zrh 2018��1��17�� ����10:44:32
 *@param customizeId ���Ʊ��
 *@param customizeNum  ��������
 *@param customizeMessage  ������Ϣ
 *@param customizeMinute  ��ϸ��Ϣ
 *@param customizePrice ��Ʒ�۸�
 *@param customizeStyle ��ʽ���
 *@param customizeCard ��Ʒ���
 *@param customizeName ��Ʒ����
 *@param goods  ��Ʒ
 *@param size  �ߴ�
 *@param type	����
 */
public class CustomizeVO {
		private Integer customizeId;
		private Integer sizeId;
		private Integer customizeNum;
		private String  customizeMessage;
		private String customizeMinute;
		private Integer typeId;
		private Integer brandId;
		private String customizePrice;
		private String customizeStyle;
		private String customizeCard;
		private String customizeName;
		public Integer getCustomizeId() {
			return customizeId;
		}
		public void setCustomizeId(Integer customizeId) {
			this.customizeId = customizeId;
		}
		public Integer getSizeId() {
			return sizeId;
		}
		public void setSizeId(Integer sizeId) {
			this.sizeId = sizeId;
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
		public Integer getTypeId() {
			return typeId;
		}
		public void setTypeId(Integer typeId) {
			this.typeId = typeId;
		}
		public Integer getBrandId() {
			return brandId;
		}
		public void setBrandId(Integer brandId) {
			this.brandId = brandId;
		}
		public String getCustomizePrice() {
			return customizePrice;
		}
		public void setCustomizePrice(String customizePrice) {
			this.customizePrice = customizePrice;
		}
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
		@Override
		public String toString() {
			return "CustomizeVO [customizeId=" + customizeId + ", sizeId=" + sizeId + ", customizeNum=" + customizeNum
					+ ", customizeMessage=" + customizeMessage + ", customizeMinute=" + customizeMinute + ", typeId="
					+ typeId + ", brandId=" + brandId + ", customizePrice=" + customizePrice + ", customizeStyle="
					+ customizeStyle + ", customizeCard=" + customizeCard + ", customizeName=" + customizeName + "]";
		}	
		
}
