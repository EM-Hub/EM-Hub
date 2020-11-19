package com.spring.biz.vo;

public class EmpVO {

	    // 직원번호 
	    private int empNo;

	    // 소속부서 
	    private int depNo;

	    // 직위 
	    private String empJob;
	    private String depName;

	    // 직원이름 
	    private String empName;
	    private int collegeNum;

	    public int getEmpNo() {
	        return empNo;
	    }

	    public void setEmpNo(int empNo) {
	        this.empNo = empNo;
	    }

	    public int getDepNo() {
	        return depNo;
	    }

	    public void setDepNo(int depNo) {
	        this.depNo = depNo;
	    }

	    public String getEmpJob() {
	        return empJob;
	    }

	    public void setEmpJob(String empJob) {
	        this.empJob = empJob;
	    }

	    public String getEmpName() {
	        return empName;
	    }

	    public void setEmpName(String empName) {
	        this.empName = empName;
	    }

		@Override
		public String toString() {
			return "ProfVO [empNo=" + empNo + ", depNo=" + depNo + ", empJob=" + empJob + ", empName=" + empName + "]";
		}

		public String getDepName() {
			return depName;
		}

		public void setDepName(String depName) {
			this.depName = depName;
		}

		public int getCollegeNum() {
			return collegeNum;
		}

		public void setCollegeNum(int collegeNum) {
			this.collegeNum = collegeNum;
		}

	   
}
