package com.keysoft.pigfarm.common;

public enum MailContentEnum {
	// TITLE MAIL
	TITLE_EDIT_TASK("<b>Quản lý</b> đã thay đổi nội dung công việc. <br/>"),
	TITLE_CREATED("<b>Có công việc mới cần xác nhận từ"),
	TITLE_CONFIRMED("<span> đã tiếp nhận công việc</span><br/>"),
	TITLE_REJECTED("<span> đã từ chối công việc</span><br/>"),
	TITLE_UPDATE("<span> cập nhật tiến độ công việc</span></div>"),
	TILTE_DOCUMENT("<span>Có tài liệu mới được cập nhật.</span></div>"),
	TITLE_ACCEPT_REJECT_FREQUENCY("đã đồng ý thay đổi tần suất công việc"),

	// CONTENT
	DATE("<b>Ngày: </b>"),
	FARM("<b>Trại: </b>"),
	AT_TIME("<b>Vào lúc: </b>"),
	TITLE_LABEL("<b>Tiêu đề: </b>"),
	CONTENT_LABEL("<b>Nội dung: </b>"),
	ACCESS_TO_DETAIL("<p>Truy cập hệ thống để xem chi tiết công việc.</p>"),
	CONTENT_DONE("<div>Hoàn thành công việc</div>"),
	CREATED_BY("<b>Người tạo: </b>"),
	
	// TAG SELECTOR
	DIV_TAG_OPEN("<div>"),
	DIV_TAG_CLOSE("</div>"),
	B_TAG_OPEN("<b>"),
	B_TAG_CLOSE("</b>"),
	BR_TAG("<br />"),
	P_TAG_OPEN("<p>"),
	P_TAG_CLOSE("</p>"),
	PRE_TAG_OPEN("<pre style='font-family: inherit; font-size: inherit; line-height: inherit;'>"),
	PRE_TAG_CLOSE("</pre>"),
	//
	APP_NAME("MPorker")
	;
	
	public String val;
	
	private MailContentEnum(String val) {
		this.val = val;
	}
}
