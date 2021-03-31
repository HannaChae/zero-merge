package chn.scalar.api.brd.repository;

 
import java.util.List;       
import static chn.scalar.api.brd.domain.QBoard.board;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import chn.scalar.api.brd.domain.Board;
import chn.scalar.api.brd.domain.BoardDto;
import chn.scalar.api.usr.domain.QUserVo;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;


import lombok.RequiredArgsConstructor;



@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements IBoardRepository{
	private final JPAQueryFactory qf;
	private final EntityManager em;
	public BoardRepositoryImpl(EntityManager em,JPAQueryFactory qf) {
		super(Board.class);
		this.qf = qf;
		this.em = em;
		
	}

	@Override
	public Board findByTitle(String brdTitle) {
//		return em.createQuery("select b2 from Board b2 where b2.brd_title like :brdTitle")
//				.setParameter("brdTitle", brdTitle)
//				.getResultList();
		return qf.selectFrom(board).where(board.brdTitle.eq(brdTitle)).fetchOne();
	}
	@Transactional
	@Override
	public Board findByBrd(Board brd) {
		qf.update(board).set(board.brdCount, brd.getBrdCount()+1).where(board.brdNo.eq(brd.getBrdNo())).execute();
		return qf.selectFrom(board).where(board.brdNo.eq(brd.getBrdNo())).fetchOne();
	}



	@Override
	public List<Board> search(String brdTitle) {
		
		return qf.selectFrom(board).where(board.brdTitle.contains(brdTitle)).fetch();
	}
	@Override
	public List<Board> blogListAll(){
		
		return qf.selectFrom(board).where(board.brdKind.eq(1L)).orderBy(board.brdWrtDate.desc()).fetch();
	}

	@Override
	public long update(Board brd, BoardDto t) {
		
		return qf.update(board).set(board.brdTitle, t.getBrdTitle())
				.where(board.brdNo.eq(t.getBrdNo())).execute();
	}



	

	

//	@Override
//	public Board update(Board t) {
//		// update boards
//		//set title=#{title}, content=#{content},written_date=#{writtenDate}
//		//where board_num like ${boardNum}
//		JPAUpdateClause update1 = new JPAUpdateClause(em, board);
//		return update1.set(board.brdTitle , t.getBrdTitle()).set(board.brdContent, t.getBrdContent()).where(board.brdNo.eq(t.getBrdNo()));
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Board> findByWriteDate(String writeDate) {
//		return em.createQuery("select b from Board b where b.brdwritten_date like :brdwrittenDate")
//				.setParameter("writeDate", writeDate)
//				.getResultList();
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<BoardDto> findByUserNo(long usrNo) {
//		return em.createQuery("select "
//				+ "b.brd_no brdNum "
//				+ "b.brd_title brdTitle "
//				+ "b.brd_content brdContent "
//				+ "b.brdwritten_date brdwrittenDate "
//				+ "b.brd_rank brdRank "
//				+ "b.brd_img brdImg "
//				+ "b.brd_kind brdKind "
//				+ "b.count count "
//				+ "b.brd_like brdLike "
//				+ "b.brd_pwd brdPwd "
//				+ "b.usr_no usrNo "
//				+ "b.usr_name usrName \n"
//				+ "from Board b inner join User u on b.usr_no = u.usr_no \n"
//				+ "where b.usr_no like : usrNo")
//				.setParameter("usrNo", usrNo)
//				.getResultList();
//	}
	
	


}
