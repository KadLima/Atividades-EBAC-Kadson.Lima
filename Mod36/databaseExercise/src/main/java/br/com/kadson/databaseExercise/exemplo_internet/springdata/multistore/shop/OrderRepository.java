package br.com.kadson.databaseExercise.exemplo_internet.springdata.multistore.shop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {}