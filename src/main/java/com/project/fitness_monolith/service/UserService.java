package com.project.fitness_monolith.service;

import com.project.fitness_monolith.Model.User;
import com.project.fitness_monolith.Model.UserRole;
import com.project.fitness_monolith.dto.RegisterRequest;
import com.project.fitness_monolith.dto.UserResponse;
import com.project.fitness_monolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request) {
        UserRole role  = request.getRole() != null ? request.getRole() : UserRole.USER;
        // 2️⃣ Build User entity
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // encode later
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
                .role(role)
                .build();

        // 3️⃣ Save entity
        User savedUser = userRepository.save(user);

        // 4️⃣ Map to response DTO
        return mapToResponse(savedUser);
    }

    public UserResponse mapToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
