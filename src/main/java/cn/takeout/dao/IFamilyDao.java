package cn.takeout.dao;

import cn.takeout.domain.Family;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFamilyDao {
    void addFamily(Family family);
    List<Family> getFamilies(int shopId);
    void deleteFamily(String family);
}
