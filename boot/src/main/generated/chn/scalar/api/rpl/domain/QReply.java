package chn.scalar.api.rpl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReply is a Querydsl query type for Reply
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReply extends EntityPathBase<Reply> {

    private static final long serialVersionUID = -1210942607L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReply reply = new QReply("reply");

    public final chn.scalar.api.brd.domain.QBoard board;

    public final StringPath rplContent = createString("rplContent");

    public final NumberPath<Long> rplNo = createNumber("rplNo", Long.class);

    public final chn.scalar.api.usr.domain.QUserVo userVo;

    public QReply(String variable) {
        this(Reply.class, forVariable(variable), INITS);
    }

    public QReply(Path<? extends Reply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReply(PathMetadata metadata, PathInits inits) {
        this(Reply.class, metadata, inits);
    }

    public QReply(Class<? extends Reply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new chn.scalar.api.brd.domain.QBoard(forProperty("board"), inits.get("board")) : null;
        this.userVo = inits.isInitialized("userVo") ? new chn.scalar.api.usr.domain.QUserVo(forProperty("userVo"), inits.get("userVo")) : null;
    }

}

