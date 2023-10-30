package birthdaygreetings;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileEmployeeRepositoryTest {
  @Test
  void throws_exception_when_file_does_not_exists() {
    final String fileName = "nonExistent.txt";
    final FileEmployeeRepository fileEmployeeRepository = new FileEmployeeRepository(fileName);

    assertThrows(RetrieveEmployeeException.class, () -> fileEmployeeRepository.getEmployees());
  }

  @Test
  void throws_exception_when_header_is_not_present() {
    final String fileName = "src/test/resources/empty_employee_data.txt";
    final FileEmployeeRepository fileEmployeeRepository = new FileEmployeeRepository(fileName) {
      @Override
      protected void skipHeader(final BufferedReader in) throws IOException {
        throw new IOException();
      }
    };

    assertThrows(RetrieveEmployeeException.class, () -> fileEmployeeRepository.getEmployees());
  }
}
