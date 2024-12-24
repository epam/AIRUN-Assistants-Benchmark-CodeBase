package com.aicode.java;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Orders o " +
        "WHERE (:status IS NULL OR o.status = status) " +
        "AND (:customerId IS NULL OR o.customerId = customerId) " +
        "AND (CAST(:minTotalCost AS double) IS NULL OR o.totalCost >= minTotalCost) " +
        "AND (CAST(:maxTotalCost AS double) IS NULL OR o.totalCost <= maxTotalCost) " +
        "AND (:startDate IS NULL OR o.orderDate >= startDate) " +
        "AND (:endDate IS NULL OR o.orderDate <= endDate)")
    Page<Order> findOrders(
        @Param("status") String status,
        @Param("customerId") Long customerId,
        @Param("minTotalCost") Double minTotalCost,
        @Param("maxTotalCost") Double maxTotalCost,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate,
        Pageable pageable
    );
}
