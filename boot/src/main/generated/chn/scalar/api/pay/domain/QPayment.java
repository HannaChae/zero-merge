package chn.scalar.api.pay.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = -833547565L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final ListPath<chn.scalar.api.brd.domain.Board, chn.scalar.api.brd.domain.QBoard> boards = this.<chn.scalar.api.brd.domain.Board, chn.scalar.api.brd.domain.QBoard>createList("boards", chn.scalar.api.brd.domain.Board.class, chn.scalar.api.brd.domain.QBoard.class, PathInits.DIRECT2);

    public final chn.scalar.api.crt.domain.QCart cart;

    public final StringPath dvrFee = createString("dvrFee");

    public final NumberPath<Long> payAmount = createNumber("payAmount", Long.class);

    public final StringPath payDate = createString("payDate");

    public final NumberPath<Long> payNo = createNumber("payNo", Long.class);

    public final StringPath payPrice = createString("payPrice");

    public final StringPath payState = createString("payState");

    public final chn.scalar.api.prd.domain.QProduct product;

    public final ListPath<chn.scalar.api.rcv.domain.Receiver, chn.scalar.api.rcv.domain.QReceiver> receivers = this.<chn.scalar.api.rcv.domain.Receiver, chn.scalar.api.rcv.domain.QReceiver>createList("receivers", chn.scalar.api.rcv.domain.Receiver.class, chn.scalar.api.rcv.domain.QReceiver.class, PathInits.DIRECT2);

    public final chn.scalar.api.usr.domain.QUserVo userVo;

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new chn.scalar.api.crt.domain.QCart(forProperty("cart"), inits.get("cart")) : null;
        this.product = inits.isInitialized("product") ? new chn.scalar.api.prd.domain.QProduct(forProperty("product"), inits.get("product")) : null;
        this.userVo = inits.isInitialized("userVo") ? new chn.scalar.api.usr.domain.QUserVo(forProperty("userVo"), inits.get("userVo")) : null;
    }

}

