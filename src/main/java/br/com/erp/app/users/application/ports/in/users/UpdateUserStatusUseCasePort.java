package br.com.erp.app.users.application.ports.in.users;

public interface UpdateUserStatusUseCasePort {
    void updateStatus(Long userId, boolean status);
}
