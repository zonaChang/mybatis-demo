package com.thinkive.dzjf.title.change.tool.constant;

import lombok.Getter;

public enum PagePathEnum {
	
	INDEX_PATH("index", "首页"),
	STUDENT_INFO_PAHT("student/studentInfo", "学生信息页面")
	;
	
	/** 页面相对路径 WEB-INF/views/ */
	@Getter
	private String path;
	
	/** 路径描述 */
	@Getter
	private String desc;
	
	private PagePathEnum(String path, String desc) {
		this.path = path;
		this.desc = desc;
	}

}
