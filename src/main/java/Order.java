public class Order {
	
	private int ord_no;
	private double purch_amt;
	private String ord_date;
	private int costumer_id;
	private int salesman_id;
	
	public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public String getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}
	public double getPurch_amt() {
		return purch_amt;
	}
	public void setPurch_amt(double purch_amt) {
		this.purch_amt = purch_amt;
	}
	public int getCostumer_id() {
		return costumer_id;
	}
	public void setCostumer_id(int costumer_id) {
		this.costumer_id = costumer_id;
	}
	public int getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
}
