package smilers.security.authentication.service;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import smilers.security.user.entity.User;
import smilers.security.user.service.UserAuthenticationService;
import smilers.security.user.service.UserCrudService;

//@Component("uuidAuthenticationService")
@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class UUIDAuthenticationService implements UserAuthenticationService {
	@NonNull
	UserCrudService users;

	@Override
	public Optional<String> login(final String username, final String password) {
		final String uuid = UUID.randomUUID().toString();
		final User user = User.builder().id(uuid).username(username).password(password).build();

		users.save(user);
		return Optional.of(uuid);
	}

	@Override
	public Optional<User> findByToken(final String token) {
		return users.find(token);
	}

	@Override
	public void logout(final User user) {

	}
}