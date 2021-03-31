package chn.scalar.api.crt.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCart is a Querydsl query type for Cart
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCart extends EntityPathBase<Cart> {

    private static final long serialVersionUID = 451408688L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCart cart = new QCart("cart");

    public final NumberPath<Long> cartAmount = createNumber("cartAmount", Long.class);

    public final NumberPath<Long> cartNo = createNumber("cartNo", Long.class);

    public final chn.scalar.api.pay.domain.QPayment payment;

    public QCart(String variable) {
        this(Cart.class, forVariable(variable), INITS);
    }

    public QCart(Path<? extends Cart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCart(PathMetadata metadata, PathInits inits) {
        this(Cart.class, metadata, inits);
    }

    public QCart(Class<? extends Cart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new chn.scalar.api.pay.domain.QPayment(forProperty("payment"), inits.get("payment")) : null;
    }

}

