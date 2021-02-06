package org.zerock.persistence;

import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;

import java.util.List;

public interface BoardDao {

    public void create(BoardVo boardVo) throws Exception;

    public BoardVo read(Integer bno) throws Exception;

    public void update(BoardVo boardVo) throws Exception;

    public void delete(Integer bno) throws Exception;

    public List<BoardVo> listAll() throws Exception;

    public List<BoardVo> lsitPage(int page) throws Exception;

    public List<BoardVo> listCriteria(Criteria cri) throws Exception;
}
