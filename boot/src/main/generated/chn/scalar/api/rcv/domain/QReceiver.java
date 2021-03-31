package chn.scalar.api.rcv.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReceiver is a Querydsl query type for Receiver
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReceiver extends EntityPathBase<Receiver> {

    private static final long serialVersionUID = -1414655873L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReceiver receiver = new QReceiver("receiver");

    public final chn.scalar.api.pay.domain.QPayment payment;

    public final StringPath rcvAddr = createString("rcvAddr");

    public final StringPath rcvName = createString("rcvName");

    public final NumberPath<Long> rcvNo = createNumber("rcvNo", Long.class);

    public final StringPath rcvPhone = createString("rcvPhone");

    public QReceiver(String variable) {
        this(Receiver.class, forVariable(variable), INITS);
    }

    public QReceiver(Path<? extends Receiver> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReceiver(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReceiver(PathMetadata metadata, PathInits inits) {
        this(Receiver.class, metadata, inits);
    }

    public QReceiver(Class<? extends Receiver> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new chn.scalar.api.pay.domain.QPayment(forProperty("payment"), inits.get("payment")) : null;
    }

}

