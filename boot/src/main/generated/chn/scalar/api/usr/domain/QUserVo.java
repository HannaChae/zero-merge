package chn.scalar.api.usr.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserVo is a Querydsl query type for UserVo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserVo extends EntityPathBase<UserVo> {

    private static final long serialVersionUID = -97285789L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserVo userVo = new QUserVo("userVo");

    public final chn.scalar.api.lvl.domain.QLevel level;

    public final ListPath<chn.scalar.api.pay.domain.Payment, chn.scalar.api.pay.domain.QPayment> payments = this.<chn.scalar.api.pay.domain.Payment, chn.scalar.api.pay.domain.QPayment>createList("payments", chn.scalar.api.pay.domain.Payment.class, chn.scalar.api.pay.domain.QPayment.class, PathInits.DIRECT2);

    public final StringPath usrAddr = createString("usrAddr");

    public final StringPath usrAges = createString("usrAges");

    public final StringPath usrCity = createString("usrCity");

    public final StringPath usrEmail = createString("usrEmail");

    public final StringPath usrGender = createString("usrGender");

    public final StringPath usrId = createString("usrId");

    public final StringPath usrName = createString("usrName");

    public final StringPath usrNickname = createString("usrNickname");

    public final NumberPath<Long> usrNo = createNumber("usrNo", Long.class);

    public final StringPath usrPhone = createString("usrPhone");

    public final StringPath usrPwd = createString("usrPwd");

    public QUserVo(String variable) {
        this(UserVo.class, forVariable(variable), INITS);
    }

    public QUserVo(Path<? extends UserVo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserVo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserVo(PathMetadata metadata, PathInits inits) {
        this(UserVo.class, metadata, inits);
    }

    public QUserVo(Class<? extends UserVo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.level = inits.isInitialized("level") ? new chn.scalar.api.lvl.domain.QLevel(forProperty("level")) : null;
    }

}

