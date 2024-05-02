package com.drink.ko;

import java.util.List;

public interface QnaService {
	List<QnaVO> qnaList();
	QnaVO qnaView(String q_no);
	int qnaAcontent(QnaVO vo);
	int qnaState(QnaVO vo);
	int qnaDelete(String q_no);
	int qnaInsert(QnaVO vo);
}
