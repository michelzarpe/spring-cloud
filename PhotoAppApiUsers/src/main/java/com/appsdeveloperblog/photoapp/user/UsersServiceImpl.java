package com.appsdeveloperblog.photoapp.user;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UsersServiceImpl implements UsersService {

	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BCryptPasswordEncoder bcp;
	@Autowired
	private AlbumsServiceClient albunsServiceCliente;
	//private RestTemplate restTemplate;
	@Autowired
	private Environment env;
	
	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword(bcp.encode(userDetails.getPassword()));
		usersRepository.save(userEntity);
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = usersRepository.findByEmail(username);
		if(userEntity==null) throw new UsernameNotFoundException("User not exists "+username);
		// opção para dizer se a conta está bloqueada ou não
		return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),true,true,true,true, new ArrayList<>()); 
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		UserEntity userEntity = usersRepository.findByEmail(email);
		if(userEntity==null) throw new UsernameNotFoundException("User not exists "+email);
		return new ModelMapper().map(userEntity, UserDto.class);
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserEntity userEntity = usersRepository.findByUserId(userId);
		if(userEntity==null) throw new UsernameNotFoundException("User not Foud");
		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		/*
		String albumUrl = String.format(env.getProperty("albums.url"), userId);
		
		ResponseEntity<List<AlbumResponseModel>> albumsListResponse = 
				restTemplate.exchange(albumUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumResponseModel>>() {
				});
		List<AlbumResponseModel> albumList = albumsListResponse.getBody();
		 */
		log.info("Before calling albums Microservice");
		userDto.setAlbums(albunsServiceCliente.getAlbums(userId));
		log.info("After calling albums Microservice");
		return userDto;
	}
}
