import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDao;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/config/**/*.xml"}
)
@WebAppConfiguration
public class BoardDaoTest {

    @Autowired
    private BoardDao boardDao;

    private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);

    @Test
    public void testCreate () throws Exception {
        BoardVo boardVo = new BoardVo();
        boardVo.setTitle("새로운 글을 넣습니다.");
        boardVo.setContent("새로운 글을 넣습니다.");
        boardVo.setWriter("user00");
        boardDao.create(boardVo);
    }

    @Test
    public void testRead() throws Exception {
        logger.info(boardDao.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        BoardVo boardVo = new BoardVo();
        boardVo.setBno(2);
        boardVo.setTitle("수정된 글 입니다.");
        boardVo.setContent("수정 테스트");
        boardVo.setWriter("user01");
        boardDao.update(boardVo);
    }

    @Test
    public void testDelete() throws Exception {
        boardDao.delete(3);
        logger.info("delete complete");
        List<BoardVo> boardVoList = boardDao.listAll();
        logger.info(boardVoList.toString());
    }

    @Test
    public void testListPage() throws Exception {
        int page = 3;

        List<BoardVo> list = boardDao.lsitPage(page);

        for (BoardVo boardVo : list) {
            logger.info(boardVo.getBno() + " : " + boardVo.getTitle());
        }
    }

    @Test
    public void testCriteria() throws Exception {
        Criteria cri = new Criteria();
        cri.setPage(2);
        cri.setPerPageNum(20);

        List<BoardVo> list = boardDao.listCriteria(cri);

        for (BoardVo boardVo : list) {
            logger.info(boardVo.getBno() + " : " + boardVo.getWriter());
        }
    }
}
