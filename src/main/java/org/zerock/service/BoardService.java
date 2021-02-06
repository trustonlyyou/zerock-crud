package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void regist (BoardVo boardVo) throws Exception;

    public BoardVo read(Integer bno) throws Exception;

    public void modify(BoardVo boardVo) throws Exception;

    public void remove(Integer bno) throws Exception;

    public List<BoardVo> listAll() throws Exception;

    public List<BoardVo> listCriteria(Criteria cri) throws Exception;

}
