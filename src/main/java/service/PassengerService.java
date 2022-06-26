package service;

import dto.request.passenger.GetInformationPassengerRequest;
import dto.request.passenger.UpdatePassengerRequest;
import dto.response.passenger.PassengerResponse;
import dto.request.passenger.AddPassengerRequest;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Optional<PassengerResponse> createPassenger(AddPassengerRequest request);
    Optional<PassengerResponse> removePassengerById(String id);
    Optional<PassengerResponse> updatePassenger(UpdatePassengerRequest updateRequest);
    List<PassengerResponse> findPassenger(GetInformationPassengerRequest request);
    List<PassengerResponse> findAll (int pageNo, int pageSize);
}
