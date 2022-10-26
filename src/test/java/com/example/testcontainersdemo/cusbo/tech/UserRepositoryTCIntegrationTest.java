package com.example.testcontainersdemo.cusbo.tech;

import com.example.testcontainersdemo.cusbo.tech.model.User;
import com.example.testcontainersdemo.cusbo.tech.repository.UserRepository;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTCIntegrationTest {
    @Autowired
    protected UserRepository userRepository;
    @ClassRule
    public static PostgreSQLContainer<CusboPostgresqlContainer> postgreSQLContainer
            = CusboPostgresqlContainer.getInstance();

    @Test
    @Transactional
    public void givenUsersInDB_WhenUpdateStatusForNameModifyingQueryAnnotationJPQL_ThenModifyMatchingUsers(){
        insertUsers();
        int updatedUsersSize = userRepository.updateUserSetStatusForName(0, "SAMPLE");
        assertThat(updatedUsersSize).isEqualTo(2);
    }

    private void insertUsers() {
        userRepository.save(new User("SAMPLE", "email@example.com", 1));
        userRepository.save(new User("SAMPLE1", "email2@example.com", 1));
        userRepository.save(new User("SAMPLE", "email3@example.com", 1));
        userRepository.save(new User("SAMPLE3", "email4@example.com", 1));
        userRepository.flush();
    }
}