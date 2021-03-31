package chn.scalar.api.brd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 1117782279L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final StringPath brdContent = createString("brdContent");

    public final NumberPath<Long> brdCount = createNumber("brdCount", Long.class);

    public final StringPath brdImg = createString("brdImg");

    public final NumberPath<Long> brdKind = createNumber("brdKind", Long.class);

    public final StringPath brdLike = createString("brdLike");

    public final NumberPath<Long> brdNo = createNumber("brdNo", Long.class);

    public final StringPath brdPwd = createString("brdPwd");

    public final StringPath brdRank = createString("brdRank");

    public final StringPath brdTitle = createString("brdTitle");

    public final StringPath brdWrtDate = createString("brdWrtDate");

    public final chn.scalar.api.pay.domain.QPayment payment;

    public final chn.scalar.api.prd.domain.QProduct product;

    public final ListPath<chn.scalar.api.rpl.domain.Reply, chn.scalar.api.rpl.domain.QReply> replies = this.<chn.scalar.api.rpl.domain.Reply, chn.scalar.api.rpl.domain.QReply>createList("replies", chn.scalar.api.rpl.domain.Reply.class, chn.scalar.api.rpl.domain.QReply.class, PathInits.DIRECT2);

    public final chn.scalar.api.usr.domain.QUserVo userVo;

    public final StringPath usrNikcname = createString("usrNikcname");

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new chn.scalar.api.pay.domain.QPayment(forProperty("payment"), inits.get("payment")) : null;
        this.product = inits.isInitialized("product") ? new chn.scalar.api.prd.domain.QProduct(forProperty("product"), inits.get("product")) : null;
        this.userVo = inits.isInitialized("userVo") ? new chn.scalar.api.usr.domain.QUserVo(forProperty("userVo"), inits.get("userVo")) : null;
    }

}

