package com.test.pds;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired private BoardService boardService;
	
	@RequestMapping(value = "/getBoardOne", method = RequestMethod.GET)
	public String selectBoardOne(Model model, int boardId) {
		Map<String, Object> map = boardService.selectBoardOne(boardId);
		model.addAttribute("map", map);
		return "board/getBoardOne";
	}
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String selectBoardList(Model model) {
		List<Board> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		return "board/getBoardList";
	}
	@RequestMapping(value = "/addBoard", method = RequestMethod.GET)
	public String insertBoard() {
		return "board/addBoard";
	}
	
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public String insertBoard(BoardRequest boardRequest) {
		boardService.insertBoard(boardRequest);
		return "redirect:/getBoardList";
	}
		
	
		
}
