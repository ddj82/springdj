package kr.co.biz.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="BOARD")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int boardNo;
	
	@Column(length = 200)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(length = 50)
	private String writer;
	
	@Column(name="REG_DATE")
	private LocalDateTime regDate;
}
