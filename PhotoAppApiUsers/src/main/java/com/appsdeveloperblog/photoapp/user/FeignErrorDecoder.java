package com.appsdeveloperblog.photoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

//@Component se colocar essa anotaço posso retirar o bean 
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400: {
			return new ResponseStatusException(HttpStatus.BAD_REQUEST, response.reason());
		}
		case 404: {
			if (methodKey.contains("getAlbums")) {
				return new ResponseStatusException(HttpStatus.valueOf(response.status()),response.reason());
			}
			break;
		}
		default:
			return new Exception(response.reason());
		}
		return null;
	}

}
