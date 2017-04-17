package exercise.contracts;

import exercise.exeptions.DuplicateModelException;
import exercise.exeptions.NonExistantModelException;

public interface IRepository<T extends Modable> {

    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
}
