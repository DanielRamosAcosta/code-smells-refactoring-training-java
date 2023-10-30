package birthdaygreetings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileEmployeeRepositoryTest {
  @Test
  void throws_exception_when_file_does_not_exists() {
    final String fileName = "nonExistent.txt";
    final FileEmployeeRepository fileEmployeeRepository = new FileEmployeeRepository(fileName);

    assertThrows(RetrieveEmployeeException.class, () -> fileEmployeeRepository.getEmployees());
  }
}
