package kripton70.core;

public enum BinderType {
	JSON(false),
	PROPERTIES(true),
	XML(false),
	YAML(true);	
	
	private BinderType(boolean value)
	{
		onlyText=value;
	}
	
	public final boolean onlyText; 
}
