package br.com.platao.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.platao.resource.dto.TokenDto;
import br.com.platao.resource.form.LoginForm;
import br.com.platao.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> authenticate (@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken loginData = form.converter();
		try {
			Authentication authentication = authManager.authenticate(loginData);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		}catch(AuthenticationException  e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

}
