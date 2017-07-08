package com.example.service.security;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
@Component
public class LoginAttemptService {
	private final int MAX_ATTEMPT = 3; 
	private LoadingCache<String,Integer> attemptsCache;
	
	public LoginAttemptService(){
		 attemptsCache = 
				 CacheBuilder.newBuilder()
				 .expireAfterWrite(1, TimeUnit.DAYS)
				 .build(new CacheLoader<String,Integer>(){
			 public Integer load(String key){
				 return 0;
			 }
		 });
	}
	public void loginSucceeded(String key){
		attemptsCache.invalidate(key);
		System.out.println("succeded");
	}
	
	public void loginFailed(String key){
		int attempts = 0; 
		try{
			attempts = attemptsCache.get(key);
		}catch(ExecutionException e){
			attempts=0;
		}
		attempts++;
		attemptsCache.put(key, attempts);
		System.out.println("login failed");
	}
	
	public boolean isBlocked(String key){
		try{
			System.out.println(key+"="+attemptsCache.get(key) + " = " + MAX_ATTEMPT);
			boolean result= attemptsCache.get(key)>=MAX_ATTEMPT; 
			System.out.println(result);
			return result;
		}catch(ExecutionException e){
			e.printStackTrace();
			return false;
		}
	}
}
