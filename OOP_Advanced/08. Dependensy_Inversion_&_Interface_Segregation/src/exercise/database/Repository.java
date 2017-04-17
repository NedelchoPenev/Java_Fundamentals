package exercise.database;

import exercise.contracts.IRepository;
import exercise.contracts.Modable;
import exercise.exeptions.DuplicateModelException;
import exercise.exeptions.NonExistantModelException;
import exercise.utility.Constants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Repository<T extends Modable> implements IRepository {

    private Map<String, Modable> itemsByModel;

    public Repository() {
        this.setItemsByModel(new LinkedHashMap<>());
    }

    private void setItemsByModel(HashMap<String, Modable> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void add(Modable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())){
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

        this.itemsByModel.put(item.getModel(),item);
    }

    @Override
    public Modable getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)){
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }

        return this.itemsByModel.get(model);
    }
}
