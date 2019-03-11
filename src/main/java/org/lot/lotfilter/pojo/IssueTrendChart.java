package org.lot.lotfilter.pojo;

import org.springframework.stereotype.Component;

@Component("issueTrendChart")
public class IssueTrendChart {

	private Integer type;
	private Integer playType;

	private String issue;
	private String openCode;
	private int one;
	private int two;
	private int three;
	private int four;
	private int five;
	private int six;
	private int seven;
	private int eight;
	private int nine;
	private int ten;
	private int eleven;

	public IssueTrendChart() {
		//
	}

	@Override
	public String toString() {
		return "IssueTrendChart [type=" + type + ", playType=" + playType + ", issue=" + issue + ", openCode="
				+ openCode + ", one=" + one + ", two=" + two + ", three=" + three + ", four=" + four + ", five=" + five
				+ ", six=" + six + ", seven=" + seven + ", eight=" + eight + ", nine=" + nine + ", ten=" + ten
				+ ", eleven=" + eleven + "]";
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPlayType() {
		return playType;
	}

	public void setPlayType(Integer playType) {
		this.playType = playType;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getThree() {
		return three;
	}

	public void setThree(int three) {
		this.three = three;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getSix() {
		return six;
	}

	public void setSix(int six) {
		this.six = six;
	}

	public int getSeven() {
		return seven;
	}

	public void setSeven(int seven) {
		this.seven = seven;
	}

	public int getEight() {
		return eight;
	}

	public void setEight(int eight) {
		this.eight = eight;
	}

	public int getNine() {
		return nine;
	}

	public void setNine(int nine) {
		this.nine = nine;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public int getEleven() {
		return eleven;
	}

	public void setEleven(int eleven) {
		this.eleven = eleven;
	}

}
