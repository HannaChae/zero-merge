package chn.scalar.api.brd.service;

import java.util.List;

import chn.scalar.api.brd.domain.Board;
import chn.scalar.api.brd.domain.BoardDto;

public interface BoardService {
	public Board findByTitle(String brdTitle);


}
