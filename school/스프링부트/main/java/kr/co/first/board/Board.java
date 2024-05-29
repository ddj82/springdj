package kr.co.first.board;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;
	
//	public int getBoard_no() {
//		return board_no;
//	}
//	public void setBoard_no(int board_no) {
//		this.board_no = board_no;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getWriter() {
//		return writer;
//	}
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//	public LocalDateTime getRegDate() {
//		return regDate;
//	}
//	public void setRegDate(LocalDateTime regDate) {
//		this.regDate = regDate;
//	}
	
//	@Override
//	public String toString() {
//		return "Board [board_no=" + board_no + ", title=" + title + ", content=" + content + ", writer=" + writer
//				+ ", regDate=" + regDate + "]";
//	}
	
}
