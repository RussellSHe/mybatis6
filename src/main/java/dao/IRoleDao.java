package dao;

import domain.role;

import java.util.List;

/**
 * User: Russell
 * Date: 2019-05-04
 * Time: 16:45
 */
public interface IRoleDao {
    List<role> findAll();
}
