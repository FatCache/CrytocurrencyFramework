package com.me.crypto.exception;

public class NewsException extends Exception
{
	public NewsException(String message)
	{
		super("NewsException-"+ message);
	}
	
	public NewsException(String message, Throwable cause)
	{
		super("NewsException-"+ message,cause);
	}
}