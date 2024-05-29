package kr.co.first.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.first.board.Board;
import kr.co.first.board.BoardService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
	private final BoardService service;
	
	@PostMapping
	public ResponseEntity<Board> register(@RequestBody Board board) throws Exception {
//	public ResponseEntity<Board> register(@Validated @RequestBody Board board) throws Exception {
		System.out.println("board: "+board);
		service.register(board);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Board>> list() throws Exception {
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	} 

	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) throws Exception {
		Board board = service.read(boardNo);
		System.out.println("vo: "+board);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
	
	
	@PutMapping("/{boardNo}")
	public ResponseEntity<Board> modify(@PathVariable("boardNo") int boardNo, @Validated @RequestBody Board board) throws Exception {
		board.setBoardNo(boardNo);
		service.modify(board);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
	
	@DeleteMapping("/{boardNo}")
	public String remove(@PathVariable("boardNo") int boardNo) throws Exception {
		service.remove(boardNo);
		return "삭제완료";
	}
}
