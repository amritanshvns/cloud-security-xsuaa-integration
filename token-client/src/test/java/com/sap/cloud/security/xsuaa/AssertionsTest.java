package com.sap.cloud.security.xsuaa;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertionsTest {

	@Test
	public void assertNotNull_throwsIllegalArgumentExceptionContainingMessage() {
		String message = "A message";
		assertThatThrownBy(() -> {
			Assertions.assertNotNull(null, message);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(message);
	}

	@Test
	public void assertNotNull_doesNotThrow() {
		Assertions.assertNotNull(new Object(), "Should not be thrown");
	}

	@Test
	public void assertHasText_throwsIllegalArgumentExceptionContainingMessage() {
		String message = "A message";
		assertThatThrownBy(() -> {
			Assertions.assertHasText(null, message);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(message);

		assertThatThrownBy(() -> {
			Assertions.assertHasText("", message);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(message);

		assertThatThrownBy(() -> {
			Assertions.assertHasText("  ", message);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(message);
	}

	@Test
	public void assertHasText_doesNotThrow() {
		Assertions.assertHasText(" s ", "Should not be thrown");
	}
}
