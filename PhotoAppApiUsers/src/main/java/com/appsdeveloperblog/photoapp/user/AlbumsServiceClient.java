package com.appsdeveloperblog.photoapp.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@FeignClient(name="albums-ws", fallbackFactory = AlbumsFallBackFactory.class)
public interface AlbumsServiceClient {
	@GetMapping(path = "/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);
}


@Component
class AlbumsFallBackFactory implements FallbackFactory<AlbumsServiceClient> {
	@Override
	public AlbumsServiceClient create(Throwable cause) {
		return new AlbumsServiceClientFallback(cause);
	}
}

@Slf4j
@AllArgsConstructor
class AlbumsServiceClientFallback implements AlbumsServiceClient{
	Throwable cause;
	
	@Override
	public List<AlbumResponseModel> getAlbums(String id) {
		if(cause instanceof FeignException && ((FeignException)cause).status()==404) {
			log.error("404 error took place when getAlbums was called with userId: "+id+". Error Message: "+cause.getLocalizedMessage());
		}else {
			log.error("Other error Took place "+cause.getLocalizedMessage());
		}
		
		return new ArrayList<>();
	}
	
}
