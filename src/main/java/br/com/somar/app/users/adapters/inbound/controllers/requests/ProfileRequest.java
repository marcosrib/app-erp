package br.com.somar.app.users.adapters.inbound.controllers.requests;
import jakarta.validation.constraints.Positive;

public record ProfileRequest(@Positive(message = "{profile.id.not.zero}") Long id, String name) {
}
