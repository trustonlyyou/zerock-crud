package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDao;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public void regist(BoardVo boardVo) throws Exception {
        boardDao.create(boardVo);
    }

    @Override
    public BoardVo read(Integer bno) throws Exception {
        return boardDao.read(bno);
    }

    @Override
    public void modify(BoardVo boardVo) throws Exception {
        boardDao.update(boardVo);
    }

    @Override
    public void remove(Integer bno) throws Exception {
        boardDao.delete(bno);
    }

    @Override
    public List<BoardVo> listAll() throws Exception {
        return boardDao.listAll();
    }

    @Override
    public List<BoardVo> listCriteria(Criteria cri) throws Exception {
        return boardDao.listCriteria(cri);
    }
}
