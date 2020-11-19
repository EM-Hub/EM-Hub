package com.spring.biz.vo;
// 전과/복수전공신청 관리 
public class ApplyManagementVO {

    // PK 
    private int applyNum;

    // 학생번호 
    private int stuNum;

    // 신청타입 
    private int applyType;

    // 신청일 
    private String majorCreateDate;

    // 사유 
    private String majorContent;

    // 처리일 
    private String processingDate;

    // 처리상태 
    private String majorStatus;

    // 학과변경번호 
    private int majorDepno;

    // 대학변경번호 
    private int majorCollegeNum;

    // 복수전공대학 
    private int dmajorCollegeNum;

    // 복수전공학과 
    private int dmajorDepno;
    
    // 현재소속대학 
    private int fromCollegeNum;
    // 현재소속학과 
    private int fromDepNo;
    
    
    private String collegeName;
    private String depName;
    //변경 
    private String collegeName2;
    private String depName2;
    private String collegeName21;
    private String depName21;
    
    private int collegeNum;
    private int depNo;
    
	private String memStatus;
	private int stuYear;
	private String stuName;
    
    

	public int getCollegeNum() {
		return collegeNum;
	}

	public int getFromCollegeNum() {
		return fromCollegeNum;
	}

	public void setFromCollegeNum(int fromCollegeNum) {
		this.fromCollegeNum = fromCollegeNum;
	}

	public int getFromDepNo() {
		return fromDepNo;
	}

	public void setFromDepNo(int fromDepNo) {
		this.fromDepNo = fromDepNo;
	}

	public void setCollegeNum(int collegeNum) {
		this.collegeNum = collegeNum;
	}

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public String getCollegeName21() {
		return collegeName21;
	}

	public void setCollegeName21(String collegeName21) {
		this.collegeName21 = collegeName21;
	}

	public String getDepName21() {
		return depName21;
	}

	public void setDepName21(String depName21) {
		this.depName21 = depName21;
	}
    
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getCollegeName2() {
		return collegeName2;
	}

	public void setCollegeName2(String collegeName2) {
		this.collegeName2 = collegeName2;
	}

	public String getDepName2() {
		return depName2;
	}

	public void setDepName2(String depName2) {
		this.depName2 = depName2;
	}

	public String getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}

	public int getStuYear() {
		return stuYear;
	}

	public void setStuYear(int stuYear) {
		this.stuYear = stuYear;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public int getApplyType() {
        return applyType;
    }

    public void setApplyType(int applyType) {
        this.applyType = applyType;
    }

    public String getMajorCreateDate() {
        return majorCreateDate;
    }

    public void setMajorCreateDate(String majorCreateDate) {
        this.majorCreateDate = majorCreateDate;
    }

    public String getMajorContent() {
        return majorContent;
    }

    public void setMajorContent(String majorContent) {
        this.majorContent = majorContent;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    public String getMajorStatus() {
        return majorStatus;
    }

    public void setMajorStatus(String majorStatus) {
        this.majorStatus = majorStatus;
    }

    public int getMajorDepno() {
        return majorDepno;
    }

    public void setMajorDepno(int majorDepno) {
        this.majorDepno = majorDepno;
    }

    public int getMajorCollegeNum() {
        return majorCollegeNum;
    }

    public void setMajorCollegeNum(int majorCollegeNum) {
        this.majorCollegeNum = majorCollegeNum;
    }

    public int getDmajorCollegeNum() {
        return dmajorCollegeNum;
    }

    public void setDmajorCollegeNum(int dmajorCollegeNum) {
        this.dmajorCollegeNum = dmajorCollegeNum;
    }

    public int getDmajorDepno() {
        return dmajorDepno;
    }

    public void setDmajorDepno(int dmajorDepno) {
        this.dmajorDepno = dmajorDepno;
    }

	@Override
	public String toString() {
		return "ApplyManagementVO [applyNum=" + applyNum + ", stuNum=" + stuNum + ", applyType=" + applyType
				+ ", majorCreateDate=" + majorCreateDate + ", majorContent=" + majorContent + ", processingDate="
				+ processingDate + ", majorStatus=" + majorStatus + ", majorDepno=" + majorDepno + ", majorCollegeNum="
				+ majorCollegeNum + ", dmajorCollegeNum=" + dmajorCollegeNum + ", dmajorDepno=" + dmajorDepno
				+ ", collegeName=" + collegeName + ", depName=" + depName + ", collegeName2=" + collegeName2
				+ ", depName2=" + depName2 + ", memStatus=" + memStatus + ", stuYear=" + stuYear + ", stuName="
				+ stuName + "]";
	}

   
}