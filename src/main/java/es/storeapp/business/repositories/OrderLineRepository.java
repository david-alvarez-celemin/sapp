package es.storeapp.business.repositories;

import java.text.MessageFormat;

import org.springframework.stereotype.Repository;

import es.storeapp.business.entities.OrderLine;
import jakarta.persistence.Query;

@Repository
public class OrderLineRepository extends AbstractRepository<OrderLine>{

    private static final String FIND_BY_USER_AND_PRODUCT_QUERY =
            "SELECT COUNT(*) FROM OrderLine o WHERE " +
            "o.order.state = es.storeapp.business.entities.OrderState.COMPLETED " +
            "AND o.order.user.id = {0} AND o.product.id = {1}";

    public boolean findIfUserBuyProduct(Long userId, Long productId) {
        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
        return ((Long) query.getSingleResult()) > 0;
    }

}
