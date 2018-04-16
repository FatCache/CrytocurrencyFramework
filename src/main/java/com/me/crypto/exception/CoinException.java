package com.me.crypto.exception;

public class CoinException extends Exception
{
	public CoinException(String message)
	{
		super("CoinException-"+ message);
	}
	
	public CoinException(String message, Throwable cause)
	{
		super("CoinException-"+ message,cause);
	}
}