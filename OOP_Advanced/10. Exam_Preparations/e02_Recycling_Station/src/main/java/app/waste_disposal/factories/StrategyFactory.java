package app.waste_disposal.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StrategyFactory implements Factory<GarbageDisposalStrategy> {

    private static final String STRATEGY_PATH = "app.waste_disposal.models.strategies.";
    private static final String SUFFIX = "Strategy";

    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
    }};

    @Override
    public GarbageDisposalStrategy create(String... args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        String type = args[args.length - 1];
        String path = STRATEGY_PATH + type + SUFFIX;
        Class<?> strategyClass = Class.forName(path);

        Constructor<?> strategyConstructor = strategyClass.getDeclaredConstructors()[0];
        strategyConstructor.setAccessible(true);
        Class[] strategyParamTypes = strategyConstructor.getParameterTypes();

        Object[] arguments = new Object[strategyParamTypes.length];

        for (int i = 0; i < strategyParamTypes.length; i++) {
            Class<?> paramType = strategyParamTypes[i].isPrimitive() ? getWrapper(strategyParamTypes[i]) : strategyParamTypes[i];
            Constructor<?> paramConstructor = paramType.getConstructor(String.class);
            arguments[i] = paramConstructor.newInstance(args[i]);
        }

        return (GarbageDisposalStrategy) strategyConstructor.newInstance(arguments);
    }

    private Class<?> getWrapper(Class<?> parameterType) {
        return this.mapper.get(parameterType);
    }
}
