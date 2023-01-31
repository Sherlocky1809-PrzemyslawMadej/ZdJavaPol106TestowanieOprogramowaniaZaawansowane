package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.Optional;

public interface AnimalRepository {

    Animal addAnimal(Animal animal);

    Optional<Animal> findAnimalById(Long id);


}
