package service;

import java.util.List;

public interface IService<E> {

    List<E> findAll();

    void save(E e);

    E findById(int id);

    void update(int id, E e);

    void remove(int id);

}
