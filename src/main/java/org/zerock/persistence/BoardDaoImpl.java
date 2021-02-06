package org.zerock.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;

import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void create(BoardVo boardVo) throws Exception {
        sqlSession.insert("create" ,boardVo);
    }

    @Override
    public BoardVo read(Integer bno) throws Exception {
        return sqlSession.selectOne("read", bno);
    }

    @Override
    public void update(BoardVo boardVo) throws Exception {
        sqlSession.update("update", boardVo);
    }

    @Override
    public void delete(Integer bno) throws Exception {
        sqlSession.delete("delete", bno);
    }

    @Override
    public List<BoardVo> listAll() throws Exception {
        return sqlSession.selectList("listAll");
    }

    @Override
    public List<BoardVo> lsitPage(int page) throws Exception {

        if (page <= 0) {
            page = 1;
        }

        page = (page - 1) * 10;

        return sqlSession.selectList("listPage", page);
    }

    @Override
    public List<BoardVo> listCriteria(Criteria cri) throws Exception {
        return sqlSession.selectList("listCriteria", cri);
    }
}
