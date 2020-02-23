package com.epam.CalculatorTesting;



public class App<T extends Number>
{
	
private T t;
	
	public T get(){
		return this.t;
	}
	
	public void set(T t1){
		this.t=t1;
	}
	
	
    public static void main( String[] args )
    {
    	@SuppressWarnings("rawtypes")
    	App  a= new App();
    	a.set(15l);
    	if(a.get() instanceof Long)
    		System.out.println("long");
    	else
    		System.out.println("wrong");
    	
    	
    }
}
