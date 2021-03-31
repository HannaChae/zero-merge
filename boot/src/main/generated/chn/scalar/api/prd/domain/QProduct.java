package chn.scalar.api.prd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -988596094L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final chn.scalar.api.ctg.domain.QCategory category;

    public final StringPath ctgName = createString("ctgName");

    public final ListPath<chn.scalar.api.pay.domain.Payment, chn.scalar.api.pay.domain.QPayment> payments = this.<chn.scalar.api.pay.domain.Payment, chn.scalar.api.pay.domain.QPayment>createList("payments", chn.scalar.api.pay.domain.Payment.class, chn.scalar.api.pay.domain.QPayment.class, PathInits.DIRECT2);

    public final StringPath prdImg = createString("prdImg");

    public final StringPath prdInv = createString("prdInv");

    public final StringPath prdName = createString("prdName");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final StringPath prdPrice = createString("prdPrice");

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new chn.scalar.api.ctg.domain.QCategory(forProperty("category")) : null;
    }

}

