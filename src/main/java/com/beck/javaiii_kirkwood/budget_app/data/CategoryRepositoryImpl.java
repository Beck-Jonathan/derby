package com.beck.javaiii_kirkwood.budget_app.data;

import com.beck.javaiii_kirkwood.budget_app.models.Category;
import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.beck.javaiii_kirkwood.budget_app.data.Database.getConnection;

@Service
@Repository
@Component

public  class CategoryRepositoryImpl implements CategoryRepository{

  public  List<Category_VM> getOneYearAnalysis(int year, int user_ID) throws SQLException {
    int result = 0;
    year=year-1900;
    List<Category_VM> category_vms = new ArrayList<>();
    try (Connection connection = getConnection()) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_pie_chart(?,?)}")) {
          Date date = new Date(year, 11, 31);
          statement.setDate(1, date);
          statement.setInt(2, user_ID);
            try (ResultSet resultSet = statement.executeQuery()) {
              while (resultSet.next()) {
                Category_VM category = new Category_VM();
                category.setCategory_ID(resultSet.getString(1));
                category.setCount(resultSet.getInt(2));
                double amount = Math.abs(resultSet.getDouble(3));
                category.setAmount(amount);
                category_vms.add(category);
              }
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
        }
      }
      return category_vms;
    }

  public  List<Category_VM> getOneCategoryAnalysis(String Category, int user_ID) throws SQLException {

    List<Category_VM> category_vms = new ArrayList<>();
    try (Connection connection = getConnection()) {
      try (CallableStatement statement = connection.prepareCall("{CALL sp_bar_chart(?,?)}")) {

        statement.setString(1, Category);
        statement.setInt(2, user_ID);
        try (ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {
            Category_VM category = new Category_VM();
            category.setCategory_ID(Category+" "+(resultSet.getInt(1 )));
            category.setCount(resultSet.getInt(2));
            double amount = Math.abs(resultSet.getDouble(3));
            category.setAmount(amount);
            category_vms.add(category);
          }
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
    return category_vms;
  }



  @Override
  public void flush() {

  }

  @Override
  public <S extends Category_VM> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Category_VM> List<S> saveAllAndFlush(Iterable<S> entities) {
    return null;
  }

  @Override
  public void deleteAllInBatch(Iterable<Category_VM> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Integer> integers) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Category_VM getOne(Integer integer) {
    return null;
  }

  @Override
  public Category_VM getById(Integer integer) {
    return null;
  }

  @Override
  public Category_VM getReferenceById(Integer integer) {
    return null;
  }

  @Override
  public <S extends Category_VM> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Category_VM> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends Category_VM> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public <S extends Category_VM> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Category_VM> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Category_VM> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Category_VM, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  @Override
  public <S extends Category_VM> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Category_VM> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Category_VM> findById(Integer integer) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Integer integer) {
    return false;
  }

  @Override
  public List<Category_VM> findAll() {
    return null;
  }

  @Override
  public List<Category_VM> findAllById(Iterable<Integer> integers) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Integer integer) {

  }

  @Override
  public void delete(Category_VM entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Integer> integers) {

  }

  @Override
  public void deleteAll(Iterable<? extends Category_VM> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<Category_VM> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<Category_VM> findAll(Pageable pageable) {
    return null;
  }
}
