package joochang.project.board;

import joochang.project.domain.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Board board) {
        em.persist(board);
    }

    public void update(Board board) {
        em.persist(board);
    }
}
