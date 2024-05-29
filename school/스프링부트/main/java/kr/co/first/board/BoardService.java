package kr.co.first.board;

import java.util.List;

public interface BoardService {
	public void register(Board board) throws Exception;
	public List<Board> list() throws Exception;
	public Board read(int boardNo) throws Exception;
	public void modify(Board board) throws Exception;
	public void remove(int boardNo) throws Exception;
}
