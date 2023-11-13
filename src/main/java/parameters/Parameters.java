package parameters;

public abstract class Parameters {
    protected String parameterType;

    public abstract void initialiseDefaultParameters();

    public abstract boolean validateParameters();

}
