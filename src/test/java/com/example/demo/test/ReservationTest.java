package com.example.demo.test;

import com.example.demo.command.ReservationCommand;
import com.example.demo.entity.Apartment;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationTest {

/*    @LocalServerPort
    int port;

    private RestTemplate restTemplate = new RestTemplate();

    URI getUri(String path) throws URISyntaxException {
        return new URI("http://localhost:" + port + "/apartmentReservation" + path);
    }

    @Test
    void noReservationAddToDb() throws URISyntaxException {

        ReservationCommand reservationCommand = new ReservationCommand(
                LocalDate.of(2020, 10, 2),
                LocalDate.of(2020, 10, 3),
                new Apartment("house1", "middle", 1400.00, 60.00),
                new User("Jacek", "Owner"),
                new User("Marcin", "Borrower"),
                1400.00);

        ResponseEntity<Reservation> bookingResponseEntity = restTemplate.postForEntity(getUri(""), reservationCommand, Reservation.class);

        assertThat(Objects.requireNonNull(bookingResponseEntity.getBody()).getFinishReservation()).isEqualTo(reservationCommand.getFinishReservation());
        assertThat(Objects.requireNonNull(bookingResponseEntity.getBody()).getStartReservation()).isEqualTo(reservationCommand.getStartReservation());
        assertThat(1500.00).isEqualTo(reservationCommand.getPrice());


    }

    @Test
    void reservationAddToDb() throws URISyntaxException {

        ReservationCommand reservationCommand = new ReservationCommand(
                LocalDate.of(2020, 10, 2),
                LocalDate.of(2020, 10, 3),
                new Apartment("house1", "middle", 1400.00, 60.00),
                new User("Jacek", "Owner"),
                new User("Marcin", "Borrower"),
                1400.00);

        ResponseEntity<Reservation> bookingResponseEntity = restTemplate.postForEntity(getUri(""), reservationCommand, Reservation.class);

        assertThat(Objects.requireNonNull(bookingResponseEntity.getBody()).getFinishReservation()).isEqualTo(reservationCommand.getFinishReservation());
        assertThat(Objects.requireNonNull(bookingResponseEntity.getBody()).getStartReservation()).isEqualTo(reservationCommand.getStartReservation());
        assertThat(1400.00).isEqualTo(reservationCommand.getPrice());
    }*/
}
