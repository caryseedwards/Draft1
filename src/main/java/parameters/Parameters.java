package parameters;

public abstract class Parameters {
    protected String parameterType;

    public abstract void initialiseDefaultParameters();

    public abstract boolean validateParameters();

    public abstract Parameters copy();

    @Override
    public abstract boolean equals(Object other);

}
