package io.security.springsecuritymaster.security.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.security.springsecuritymaster.domain.dto.AccountContext;
import io.security.springsecuritymaster.domain.dto.AccountDto;
import io.security.springsecuritymaster.domain.entity.Account;
import io.security.springsecuritymaster.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service("userDetailsService")
@RequiredArgsConstructor
public class FormUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = userRepository.findByUsername(username);
		if(account == null) {
			throw new UsernameNotFoundException("No User");
		}

		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(account.getRoles()));
		ModelMapper mapper = new ModelMapper();
		AccountDto accountDto = mapper.map(account, AccountDto.class);

		return new AccountContext(accountDto, authorities);

	}
}
