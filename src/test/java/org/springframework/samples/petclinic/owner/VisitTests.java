/*
 * Copyright 2012-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;

class VisitTests {

	@Test
	void newVisitDefaultsToToday() {
		LocalDate today = LocalDate.of(2026, 10, 13);

		try (var dates = mockStatic(LocalDate.class, CALLS_REAL_METHODS)) {
			dates.when(LocalDate::now).thenReturn(today);

			Visit visit = new Visit();

			assertEquals(today, visit.getDate(), "A new visit should default to today's date, not tomorrow");
		}
	}

}
