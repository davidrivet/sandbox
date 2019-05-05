package smilers.utils;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

final class JodaDateService implements DateService {

	private final DateTimeZone timeZone;

	/**
	 * Force system-wide timezone to ensure consistent dates over all servers,
	 * independently from the region the server is running.
	 */
	JodaDateService(final DateTimeZone timeZone) {
		super();
		this.timeZone = checkNotNull(timeZone);

		System.setProperty("user.timezone", timeZone.getID());
		TimeZone.setDefault(timeZone.toTimeZone());
		DateTimeZone.setDefault(timeZone);
	}

	@Override
	public DateTime now() {
		return DateTime.now(timeZone);
	}
}