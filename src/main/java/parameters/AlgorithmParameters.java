package parameters;

public abstract class AlgorithmParameters extends Parameters {
    protected String algorithmName;

    @Override
    public abstract AlgorithmParameters copy();
}
