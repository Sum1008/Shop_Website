package com.grocery.shop.grocery.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grocery.shop.grocery.entity.Order;
import com.grocery.shop.grocery.entity.OrderDetail;
import com.grocery.shop.grocery.entity.Product;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	@Query("select od from OrderDetail od join od.order o where o.id in :ids and o.customerEmail = :customerEmail order by o.id desc")
List<OrderDetail> findOrdersByOrderId(@Param("ids") Set<Long> ids, @Param("customerEmail") String customerEmail);

	@Modifying
	@Query(value = "insert into order_detail (order_id, product_id, quantity, mrp_price, price, amount, payment_id, order_status, payment_mode) values (:order, :product, :quantity, :mrpPrice, :amount, :totalPrice, :paymentId, :orderStatus, :paymentMode)", nativeQuery = true)
	void saveOrderDetails(@Param("order") Order orders, @Param("product") Product products, @Param("quantity") int quantity,
			@Param("mrpPrice") double mrpPrice, @Param("amount") double amount, @Param("totalPrice") double totalPrice, @Param("paymentId") double paymentId, @Param("orderStatus") String orderStatus, @Param("paymentMode") String paymentMode);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "delete from OrderDetail od where od.paymentId=?1")
	void deleteOrderDetailByNum(int paymentId);
	
	@Query(value= "select od from OrderDetail od where od.paymentId=?1")
	List<OrderDetail> findOrderByPayId(int paymentId);
	
	@Query("select od from OrderDetail od join od.order o where od.orderStatus= :orderStatus order by o.orderDate desc")
List<OrderDetail> findOrdersByStatus(@Param("orderStatus") String orderStatus);

@Query("select od from OrderDetail od join od.order o where od.orderStatus= :orderStatus order by o.orderDate desc")
List<OrderDetail> findTop10OrdersByStatus(@Param("orderStatus") String orderStatus, Pageable pageable);

@Query("SELECT od FROM OrderDetail od JOIN od.order o ORDER BY o.id DESC")
List<OrderDetail> findAllOrders();

	@Query(value = "select o from OrderDetail o order by o.order desc")
	List<OrderDetail> getLastOrder(Pageable pageable);
} 