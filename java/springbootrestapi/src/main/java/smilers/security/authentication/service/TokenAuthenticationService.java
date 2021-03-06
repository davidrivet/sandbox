//package smilers.security.authentication.service;
//
//import static lombok.AccessLevel.PACKAGE;
//import static lombok.AccessLevel.PRIVATE;
//
//import java.util.Objects;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.google.common.collect.ImmutableMap;
//
//import lombok.AllArgsConstructor;
//import lombok.NonNull;
//import lombok.experimental.FieldDefaults;
//import smilers.security.authentication.jwt.token.api.TokenService;
//import smilers.security.user.entity.User;
//import smilers.security.user.service.UserAuthenticationService;
//import smilers.security.user.service.UserCrudService;
//
////@Component("tokenAuthenticationService")
//@Service
//@AllArgsConstructor(access = PACKAGE)
//@FieldDefaults(level = PRIVATE, makeFinal = true)
//final class TokenAuthenticationService implements UserAuthenticationService {
//	@NonNull
//	TokenService tokens;
//	@NonNull
//	UserCrudService users;
//
//	@Override
//	public Optional<String> login(final String username, final String password) {
//		return users.findByUsername(username).filter(user -> Objects.equals(password, user.getPassword()))
//				.map(user -> tokens.expiring(ImmutableMap.of("username", username)));
//	}
//
//	@Override
//	public Optional<User> findByToken(final String token) {
//		return Optional.of(tokens.verify(token)).map(map -> map.get("username")).flatMap(users::findByUsername);
//	}
//
//	@Override
//	public void logout(final User user) {
//		// Nothing to do
//	}
//}