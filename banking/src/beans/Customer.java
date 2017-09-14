package beans;

public class Customer {
	String cname,cadd,cmob,cemail,accno,accpass,ltype,ldescription,date;
	Double balance,lamount;
	public Customer()
	{
		
	}
		public Customer(String cname,String cadd,String cmob,String cemail,String accno,String accpass,Double balance,String ltype,String ldescription,String date,double lamount)
		{
			this.cname=cname;
			this.cadd=cadd;
			this.cmob=cmob;
			this.cemail=cemail;
			this.accno=accno;
			this.accpass=accpass;
			this.balance=balance;
			this.ltype=ltype;//
			this.ldescription=ldescription;
			this.date=date;
			this.lamount=lamount;
			
		}
		/**
		 * @return the ltype
		 */
		public String getLtype() {
			return ltype;
		}
		/**
		 * @param ltype the ltype to set
		 */
		public void setLtype(String ltype) {
			this.ltype = ltype;
		}
		/**
		 * @return the ldescription
		 */
		public String getLdescription() {
			return ldescription;
		}
		/**
		 * @param ldescription the ldescription to set
		 */
		public void setLdescription(String ldescription) {
			this.ldescription = ldescription;
		}
		/**
		 * @return the date
		 */
		public String getDate() {
			return date;
		}
		/**
		 * @param date the date to set
		 */
		public void setDate(String date) {
			this.date = date;
		}
		/**
		 * @return the lamount
		 */
		public Double getLamount() {
			return lamount;
		}
		/**
		 * @param lamount the lamount to set
		 */
		public void setLamount(Double lamount) {
			this.lamount = lamount;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getCadd() {
			return cadd;
		}
		public void setCadd(String cadd) {
			this.cadd = cadd;
		}
		public String getCmob() {
			return cmob;
		}
		public void setCmob(String cmob) {
			this.cmob = cmob;
		}
		public String getCemail() {
			return cemail;
		}
		public void setCemail(String cemail) {
			this.cemail = cemail;
		}
		public String getAccno() {
			return accno;
		}
		public void setAccno(String accno) {
			this.accno = accno;
		}
		public String getAccpass() {
			return accpass;
		}
		public void setAccpass(String accpass) {
			this.accpass = accpass;
		}
		public Double getBalance() {
			return balance;
		}
		public void setBalance(Double balance) {
			this.balance = balance;
		}
		
}
