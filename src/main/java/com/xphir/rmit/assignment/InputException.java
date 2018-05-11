package com.xphir.rmit.assignment;
import java.io.IOException;

@SuppressWarnings("serial")
public class InputException extends IOException
{
	public InputException(String message)
	{
		super(message);
	}
}
