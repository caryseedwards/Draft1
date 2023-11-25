package template.parameters;

/**
 * The parent parameter class used to standardise all types of parameters.
 * Part of the template pattern
 * @author carysedwards
 */
public abstract class Parameters {
    protected String parameterType;
    public abstract void initialiseDefaultParameters();
    public abstract boolean validateParameters();

}
