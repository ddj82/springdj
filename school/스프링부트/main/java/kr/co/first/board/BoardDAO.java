package kr.co.first.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDAO {
	private final JdbcTemplate jdbcTemplate;
	private final String INSERTSQL ="INSERT INTO BOARD (BOARD_NO, TITLE, WRITER, CONTENT , REG_DATE) VALUES (?, ?, ?, ?, NOW())";
	private final String SELECTLISTSQL ="SELECT BOARD_NO, TITLE, CONTENT, WRITER, REG_DATE FROM BOARD WHERE BOARD_NO >= 0 ORDER BY BOARD_NO DESC";
	private final String SELECTONESQL ="SELECT BOARD_NO, TITLE, CONTENT, WRITER, REG_DATE FROM BOARD WHERE BOARD_NO = ?";
	private final String UPDATESQL ="UPDATE BOARD SET TITLE = ?, CONTENT=? , WRITER=? WHERE BOARD_NO = ?";
	private final String DELETESQL ="DELETE FROM BOARD WHERE BOARD_NO = ?";
	
	public void create(Board board) throws Exception{
		
		
		jdbcTemplate.update(
			new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//					PreparedStatement ps = con.prepareStatement(INSERTSQL,new String[] {"boardNo"});
					PreparedStatement ps = con.prepareStatement(INSERTSQL);
					ps.setInt(1, board.getBoardNo());
					ps.setString(2, board.getTitle());
					ps.setString(3, board.getWriter());
					ps.setString(4, board.getContent());
					return ps;
				}
			}
		);
		
	}
	
	public List<Board> list() throws Exception{
		
		List<Board> results = jdbcTemplate.query(
			SELECTLISTSQL, 
			new RowMapper<Board>() {
				@Override
				public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
					Board board = new Board();
					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setContent(rs.getString("CONTENT"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					Timestamp timestamp = rs.getTimestamp("REG_DATE");
					board.setRegDate(timestamp.toLocalDateTime());
					return board;
				}
			}
		);
		return results;
	}
	
	public Board read(int boardNo) throws Exception{
		
		List<Board> results = jdbcTemplate.query(
			SELECTONESQL, 
			new RowMapper<Board>() {
				@Override
				public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
					Board board = new Board();
					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setContent(rs.getString("CONTENT"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					Timestamp timestamp = rs.getTimestamp("REG_DATE");
					board.setRegDate(timestamp.toLocalDateTime());
					return board;
				}
			}, boardNo
		);
		return results.isEmpty()? null: results.get(0);
	}
	
	
	public void update(Board board) throws Exception{
		jdbcTemplate.update(UPDATESQL, board.getTitle(), board.getContent(), board.getWriter(), board.getBoardNo());
	}
	
	
	public void delete(long boardNo) throws Exception{
		jdbcTemplate.update(DELETESQL, boardNo);
	}
	
	
}
