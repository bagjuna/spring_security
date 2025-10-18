package io.security.springsecuritymaster.users.controller;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import io.security.springsecuritymaster.domain.dto.AccountDto;
import io.security.springsecuritymaster.domain.entity.Account;
import io.security.springsecuritymaster.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@PostMapping("/signup")
	public String signup(AccountDto accountDto) {
		ModelMapper mapper = new ModelMapper();
		Account account = mapper.map(accountDto, Account.class);
		account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		userRepository.save(account);
		return "redirect:/";
	}

}
