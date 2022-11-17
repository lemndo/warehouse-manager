package com.warehouse.manager.repos;

import com.warehouse.manager.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 货物
 * @Date 2020/7/14 16:12
 * @Author by lemndo
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> {

}
