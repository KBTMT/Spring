package com.service.spring.domain;

public class DiscountCalendar {
    private long discountSeq;
    private String startDate;
    private String endDate;
    private String brand;
    private String content;
    private String url;
    private String imagePath;
    private int calendarLike;
    private String consumptionCat;
    
    public DiscountCalendar() {
    }  

    public DiscountCalendar(String startDate, String endDate, String brand, String content, String url, int calendarLike, String consumptionCat) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.brand = brand;
        this.content = content;
        this.url = url;
        this.imagePath = null;
        this.calendarLike = calendarLike;
        this.consumptionCat = consumptionCat;
    }

    public DiscountCalendar(long discountSeq, String startDate, String endDate, String brand, String content, String url, int calendarLike, String consumptionCat) {
        this.discountSeq = discountSeq;
        this.startDate = startDate;
        this.endDate = endDate;
        this.brand = brand;
        this.content = content;
        this.url = url;
        this.calendarLike = calendarLike;
        this.consumptionCat = consumptionCat;
    }

    public long getDiscountSeq() {
        return discountSeq;
    }

    public void setDiscountSeq(long discountSeq) {
        this.discountSeq = discountSeq;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate.substring(0,10);
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
    	this.endDate = endDate.substring(0,10);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getCalendarLike() {
        return calendarLike;
    }

    public void setCalendarLike(int calendarLike) {
        this.calendarLike = calendarLike;
    }

    public String getConsumptionCat() {
        return consumptionCat;
    }

    public void setConsumptionCat(String consumptionCat) {
        this.consumptionCat = consumptionCat;
    }

	@Override
	public String toString() {
		return "DiscountCalendar [discountSeq=" + discountSeq + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", brand=" + brand + ", content=" + content + ", url=" + url + ", imagePath=" + imagePath
				+ ", calendarLike=" + calendarLike + ", consumptionCat=" + consumptionCat + "]";
	}
    
    
}
