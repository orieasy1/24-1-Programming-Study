package org.example.authenticationcode.db;

import jakarta.annotation.PostConstruct;
import org.example.authenticationcode.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserRepository {
    private List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findyByName(String name) {
        return userList.stream().filter(it -> {
            return it.getName().equals(name);
        }).findFirst();
    }
    @PostConstruct  //해당 빈이 초기화 되었을 때 이 메소드 호출
    public void init() {
        userList.add(
                new UserDto(
                        "윤동희",
                        "91"
                )
        );

        userList.add(
                new UserDto(
                        "나승엽",
                        "51"
                )
        );

        userList.add(
                new UserDto(
                        "손성빈",
                        "00"
                )
        );

        userList.add(
                new UserDto(
                        "김진욱",
                        "15"
                )
        );

    }
}
